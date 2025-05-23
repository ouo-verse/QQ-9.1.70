package rx.internal.operators;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.exceptions.OnErrorThrowable;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.atomic.SpscExactAtomicArrayQueue;
import rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue;
import rx.internal.util.unsafe.Pow2;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.subscriptions.CompositeSubscription;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorMerge<T> implements Observable.Operator<T, Observable<? extends T>> {
    final boolean delayErrors;
    final int maxConcurrent;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class HolderDelayErrors {
        static final OperatorMerge<Object> INSTANCE = new OperatorMerge<>(true, Integer.MAX_VALUE);

        HolderDelayErrors() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class HolderNoDelay {
        static final OperatorMerge<Object> INSTANCE = new OperatorMerge<>(false, Integer.MAX_VALUE);

        HolderNoDelay() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class InnerSubscriber<T> extends Subscriber<T> {
        static final int LIMIT = RxRingBuffer.SIZE / 4;
        volatile boolean done;

        /* renamed from: id, reason: collision with root package name */
        final long f432672id;
        int outstanding;
        final MergeSubscriber<T> parent;
        volatile RxRingBuffer queue;

        public InnerSubscriber(MergeSubscriber<T> mergeSubscriber, long j3) {
            this.parent = mergeSubscriber;
            this.f432672id = j3;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.done = true;
            this.parent.emit();
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            this.done = true;
            this.parent.getOrCreateErrorQueue().offer(th5);
            this.parent.emit();
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            this.parent.tryEmit(this, t16);
        }

        @Override // rx.Subscriber
        public void onStart() {
            int i3 = RxRingBuffer.SIZE;
            this.outstanding = i3;
            request(i3);
        }

        public void requestMore(long j3) {
            int i3 = this.outstanding - ((int) j3);
            if (i3 > LIMIT) {
                this.outstanding = i3;
                return;
            }
            int i16 = RxRingBuffer.SIZE;
            this.outstanding = i16;
            int i17 = i16 - i3;
            if (i17 > 0) {
                request(i17);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class MergeProducer<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -1214379189873595503L;
        final MergeSubscriber<T> subscriber;

        public MergeProducer(MergeSubscriber<T> mergeSubscriber) {
            this.subscriber = mergeSubscriber;
        }

        public long produced(int i3) {
            return addAndGet(-i3);
        }

        @Override // rx.Producer
        public void request(long j3) {
            if (j3 > 0) {
                if (get() == Long.MAX_VALUE) {
                    return;
                }
                BackpressureUtils.getAndAddRequest(this, j3);
                this.subscriber.emit();
                return;
            }
            if (j3 >= 0) {
            } else {
                throw new IllegalArgumentException("n >= 0 required");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class MergeSubscriber<T> extends Subscriber<Observable<? extends T>> {
        static final InnerSubscriber<?>[] EMPTY = new InnerSubscriber[0];
        final Subscriber<? super T> child;
        final boolean delayErrors;
        volatile boolean done;
        boolean emitting;
        volatile ConcurrentLinkedQueue<Throwable> errors;
        long lastId;
        int lastIndex;
        final int maxConcurrent;
        boolean missed;
        MergeProducer<T> producer;
        volatile Queue<Object> queue;
        int scalarEmissionCount;
        final int scalarEmissionLimit;
        volatile CompositeSubscription subscriptions;
        long uniqueId;

        /* renamed from: nl, reason: collision with root package name */
        final NotificationLite<T> f432673nl = NotificationLite.instance();
        final Object innerGuard = new Object();
        volatile InnerSubscriber<?>[] innerSubscribers = EMPTY;

        public MergeSubscriber(Subscriber<? super T> subscriber, boolean z16, int i3) {
            this.child = subscriber;
            this.delayErrors = z16;
            this.maxConcurrent = i3;
            if (i3 == Integer.MAX_VALUE) {
                this.scalarEmissionLimit = Integer.MAX_VALUE;
                request(Long.MAX_VALUE);
            } else {
                this.scalarEmissionLimit = Math.max(1, i3 >> 1);
                request(i3);
            }
        }

        private void reportError() {
            ArrayList arrayList = new ArrayList(this.errors);
            if (arrayList.size() == 1) {
                this.child.onError((Throwable) arrayList.get(0));
            } else {
                this.child.onError(new CompositeException(arrayList));
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void addInner(InnerSubscriber<T> innerSubscriber) {
            getOrCreateComposite().add(innerSubscriber);
            synchronized (this.innerGuard) {
                InnerSubscriber<?>[] innerSubscriberArr = this.innerSubscribers;
                int length = innerSubscriberArr.length;
                InnerSubscriber<?>[] innerSubscriberArr2 = new InnerSubscriber[length + 1];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, length);
                innerSubscriberArr2[length] = innerSubscriber;
                this.innerSubscribers = innerSubscriberArr2;
            }
        }

        boolean checkTerminate() {
            if (this.child.isUnsubscribed()) {
                return true;
            }
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.errors;
            if (!this.delayErrors && concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty()) {
                try {
                    reportError();
                    return true;
                } finally {
                    unsubscribe();
                }
            }
            return false;
        }

        void emit() {
            synchronized (this) {
                if (this.emitting) {
                    this.missed = true;
                } else {
                    this.emitting = true;
                    emitLoop();
                }
            }
        }

        void emitEmpty() {
            int i3 = this.scalarEmissionCount + 1;
            if (i3 == this.scalarEmissionLimit) {
                this.scalarEmissionCount = 0;
                requestMore(i3);
            } else {
                this.scalarEmissionCount = i3;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:101:0x01a8  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void emitLoop() {
            boolean z16;
            boolean z17;
            long j3;
            int i3;
            boolean z18;
            try {
                Subscriber<? super T> subscriber = this.child;
                while (!checkTerminate()) {
                    Queue<Object> queue = this.queue;
                    long j16 = this.producer.get();
                    if (j16 == Long.MAX_VALUE) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (queue != null) {
                        int i16 = 0;
                        while (true) {
                            j3 = j16;
                            i3 = i16;
                            int i17 = 0;
                            Object obj = null;
                            while (true) {
                                if (j3 <= 0) {
                                    break;
                                }
                                Object poll = queue.poll();
                                if (checkTerminate()) {
                                    return;
                                }
                                if (poll == null) {
                                    obj = poll;
                                    break;
                                }
                                try {
                                    subscriber.onNext(this.f432673nl.getValue(poll));
                                } catch (Throwable th5) {
                                    if (!this.delayErrors) {
                                        Exceptions.throwIfFatal(th5);
                                        unsubscribe();
                                        subscriber.onError(th5);
                                        return;
                                    }
                                    getOrCreateErrorQueue().offer(th5);
                                }
                                i3++;
                                i17++;
                                j3--;
                                obj = poll;
                            }
                            if (i17 > 0) {
                                if (z17) {
                                    j3 = Long.MAX_VALUE;
                                } else {
                                    j3 = this.producer.produced(i17);
                                }
                            }
                            if (j3 == 0 || obj == null) {
                                break;
                            }
                            i16 = i3;
                            j16 = j3;
                        }
                    } else {
                        j3 = j16;
                        i3 = 0;
                    }
                    boolean z19 = this.done;
                    Queue<Object> queue2 = this.queue;
                    InnerSubscriber<?>[] innerSubscriberArr = this.innerSubscribers;
                    int length = innerSubscriberArr.length;
                    if (z19 && ((queue2 == null || queue2.isEmpty()) && length == 0)) {
                        ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.errors;
                        if (concurrentLinkedQueue != null && !concurrentLinkedQueue.isEmpty()) {
                            reportError();
                            return;
                        }
                        subscriber.onCompleted();
                        return;
                    }
                    if (length > 0) {
                        boolean z26 = z17;
                        long j17 = this.lastId;
                        int i18 = this.lastIndex;
                        if (length <= i18 || innerSubscriberArr[i18].f432672id != j17) {
                            if (length <= i18) {
                                i18 = 0;
                            }
                            for (int i19 = 0; i19 < length && innerSubscriberArr[i18].f432672id != j17; i19++) {
                                i18++;
                                if (i18 == length) {
                                    i18 = 0;
                                }
                            }
                            this.lastIndex = i18;
                            this.lastId = innerSubscriberArr[i18].f432672id;
                        }
                        z18 = false;
                        for (int i26 = 0; i26 < length; i26++) {
                            if (checkTerminate()) {
                                return;
                            }
                            InnerSubscriber<?> innerSubscriber = innerSubscriberArr[i18];
                            Object obj2 = null;
                            do {
                                int i27 = 0;
                                while (j3 > 0) {
                                    if (checkTerminate()) {
                                        return;
                                    }
                                    RxRingBuffer rxRingBuffer = innerSubscriber.queue;
                                    if (rxRingBuffer == null || (obj2 = rxRingBuffer.poll()) == null) {
                                        break;
                                    }
                                    try {
                                        try {
                                            subscriber.onNext(this.f432673nl.getValue(obj2));
                                            j3--;
                                            i27++;
                                        } catch (Throwable th6) {
                                            th = th6;
                                            z16 = true;
                                            if (!z16) {
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th7) {
                                        Exceptions.throwIfFatal(th7);
                                        try {
                                            subscriber.onError(th7);
                                            return;
                                        } finally {
                                            unsubscribe();
                                        }
                                    }
                                }
                                if (i27 > 0) {
                                    if (!z26) {
                                        j3 = this.producer.produced(i27);
                                    } else {
                                        j3 = Long.MAX_VALUE;
                                    }
                                    innerSubscriber.requestMore(i27);
                                }
                                if (j3 == 0) {
                                    break;
                                }
                            } while (obj2 != null);
                            boolean z27 = innerSubscriber.done;
                            RxRingBuffer rxRingBuffer2 = innerSubscriber.queue;
                            if (z27 && (rxRingBuffer2 == null || rxRingBuffer2.isEmpty())) {
                                removeInner(innerSubscriber);
                                if (checkTerminate()) {
                                    return;
                                }
                                i3++;
                                z18 = true;
                            }
                            if (j3 == 0) {
                                break;
                            }
                            i18++;
                            if (i18 == length) {
                                i18 = 0;
                            }
                        }
                        this.lastIndex = i18;
                        this.lastId = innerSubscriberArr[i18].f432672id;
                    } else {
                        z18 = false;
                    }
                    if (i3 > 0) {
                        request(i3);
                    }
                    if (!z18) {
                        synchronized (this) {
                            try {
                                if (!this.missed) {
                                    try {
                                        this.emitting = false;
                                        return;
                                    } catch (Throwable th8) {
                                        th = th8;
                                        z16 = true;
                                        while (true) {
                                            try {
                                                break;
                                            } catch (Throwable th9) {
                                                th = th9;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                                this.missed = false;
                            } catch (Throwable th10) {
                                th = th10;
                                z16 = false;
                            }
                        }
                        try {
                            break;
                            throw th;
                        } catch (Throwable th11) {
                            th = th11;
                            if (!z16) {
                                synchronized (this) {
                                    this.emitting = false;
                                }
                            }
                            throw th;
                        }
                    }
                }
            } catch (Throwable th12) {
                th = th12;
                z16 = false;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        protected void emitScalar(InnerSubscriber<T> innerSubscriber, T t16, long j3) {
            boolean z16 = true;
            try {
            } catch (Throwable th5) {
                th = th5;
                if (!z16) {
                }
                throw th;
            }
            try {
                try {
                    this.child.onNext(t16);
                } catch (Throwable th6) {
                    if (!this.delayErrors) {
                        Exceptions.throwIfFatal(th6);
                        innerSubscriber.unsubscribe();
                        innerSubscriber.onError(th6);
                        return;
                    }
                    getOrCreateErrorQueue().offer(th6);
                }
                if (j3 != Long.MAX_VALUE) {
                    this.producer.produced(1);
                }
                innerSubscriber.requestMore(1L);
                synchronized (this) {
                    if (!this.missed) {
                        this.emitting = false;
                    } else {
                        this.missed = false;
                        emitLoop();
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                z16 = false;
                if (!z16) {
                    synchronized (this) {
                        this.emitting = false;
                    }
                }
                throw th;
            }
        }

        CompositeSubscription getOrCreateComposite() {
            boolean z16;
            CompositeSubscription compositeSubscription = this.subscriptions;
            if (compositeSubscription == null) {
                synchronized (this) {
                    compositeSubscription = this.subscriptions;
                    if (compositeSubscription == null) {
                        compositeSubscription = new CompositeSubscription();
                        this.subscriptions = compositeSubscription;
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                }
                if (z16) {
                    add(compositeSubscription);
                }
            }
            return compositeSubscription;
        }

        Queue<Throwable> getOrCreateErrorQueue() {
            ConcurrentLinkedQueue<Throwable> concurrentLinkedQueue = this.errors;
            if (concurrentLinkedQueue == null) {
                synchronized (this) {
                    concurrentLinkedQueue = this.errors;
                    if (concurrentLinkedQueue == null) {
                        concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
                        this.errors = concurrentLinkedQueue;
                    }
                }
            }
            return concurrentLinkedQueue;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.done = true;
            emit();
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            getOrCreateErrorQueue().offer(th5);
            this.done = true;
            emit();
        }

        protected void queueScalar(InnerSubscriber<T> innerSubscriber, T t16) {
            RxRingBuffer rxRingBuffer = innerSubscriber.queue;
            if (rxRingBuffer == null) {
                rxRingBuffer = RxRingBuffer.getSpscInstance();
                innerSubscriber.add(rxRingBuffer);
                innerSubscriber.queue = rxRingBuffer;
            }
            try {
                rxRingBuffer.onNext(this.f432673nl.next(t16));
                emit();
            } catch (IllegalStateException e16) {
                if (innerSubscriber.isUnsubscribed()) {
                    return;
                }
                innerSubscriber.unsubscribe();
                innerSubscriber.onError(e16);
            } catch (MissingBackpressureException e17) {
                innerSubscriber.unsubscribe();
                innerSubscriber.onError(e17);
            }
        }

        void removeInner(InnerSubscriber<T> innerSubscriber) {
            RxRingBuffer rxRingBuffer = innerSubscriber.queue;
            if (rxRingBuffer != null) {
                rxRingBuffer.release();
            }
            this.subscriptions.remove(innerSubscriber);
            synchronized (this.innerGuard) {
                InnerSubscriber<?>[] innerSubscriberArr = this.innerSubscribers;
                int length = innerSubscriberArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 < length) {
                        if (innerSubscriber.equals(innerSubscriberArr[i3])) {
                            break;
                        } else {
                            i3++;
                        }
                    } else {
                        i3 = -1;
                        break;
                    }
                }
                if (i3 < 0) {
                    return;
                }
                if (length == 1) {
                    this.innerSubscribers = EMPTY;
                    return;
                }
                InnerSubscriber<?>[] innerSubscriberArr2 = new InnerSubscriber[length - 1];
                System.arraycopy(innerSubscriberArr, 0, innerSubscriberArr2, 0, i3);
                System.arraycopy(innerSubscriberArr, i3 + 1, innerSubscriberArr2, i3, (length - i3) - 1);
                this.innerSubscribers = innerSubscriberArr2;
            }
        }

        public void requestMore(long j3) {
            request(j3);
        }

        void tryEmit(InnerSubscriber<T> innerSubscriber, T t16) {
            long j3 = this.producer.get();
            boolean z16 = false;
            if (j3 != 0) {
                synchronized (this) {
                    j3 = this.producer.get();
                    if (!this.emitting && j3 != 0) {
                        this.emitting = true;
                        z16 = true;
                    }
                }
            }
            if (z16) {
                emitScalar(innerSubscriber, t16, j3);
            } else {
                queueScalar(innerSubscriber, t16);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.Observer
        public void onNext(Observable<? extends T> observable) {
            if (observable == null) {
                return;
            }
            if (observable == Observable.empty()) {
                emitEmpty();
                return;
            }
            if (observable instanceof ScalarSynchronousObservable) {
                tryEmit(((ScalarSynchronousObservable) observable).get());
                return;
            }
            long j3 = this.uniqueId;
            this.uniqueId = 1 + j3;
            InnerSubscriber innerSubscriber = new InnerSubscriber(this, j3);
            addInner(innerSubscriber);
            observable.unsafeSubscribe(innerSubscriber);
            emit();
        }

        void tryEmit(T t16) {
            long j3 = this.producer.get();
            boolean z16 = false;
            if (j3 != 0) {
                synchronized (this) {
                    j3 = this.producer.get();
                    if (!this.emitting && j3 != 0) {
                        this.emitting = true;
                        z16 = true;
                    }
                }
            }
            if (z16) {
                emitScalar(t16, j3);
            } else {
                queueScalar(t16);
            }
        }

        protected void queueScalar(T t16) {
            Queue<Object> spscExactAtomicArrayQueue;
            Queue<Object> queue = this.queue;
            if (queue == null) {
                int i3 = this.maxConcurrent;
                if (i3 == Integer.MAX_VALUE) {
                    queue = new SpscUnboundedAtomicArrayQueue<>(RxRingBuffer.SIZE);
                } else {
                    if (Pow2.isPowerOfTwo(i3)) {
                        if (UnsafeAccess.isUnsafeAvailable()) {
                            spscExactAtomicArrayQueue = new SpscArrayQueue<>(i3);
                        } else {
                            spscExactAtomicArrayQueue = new SpscAtomicArrayQueue<>(i3);
                        }
                    } else {
                        spscExactAtomicArrayQueue = new SpscExactAtomicArrayQueue<>(i3);
                    }
                    queue = spscExactAtomicArrayQueue;
                }
                this.queue = queue;
            }
            if (!queue.offer(this.f432673nl.next(t16))) {
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(new MissingBackpressureException(), t16));
            } else {
                emit();
            }
        }

        protected void emitScalar(T t16, long j3) {
            boolean z16 = true;
            try {
            } catch (Throwable th5) {
                th = th5;
            }
            try {
                try {
                    this.child.onNext(t16);
                } catch (Throwable th6) {
                    if (!this.delayErrors) {
                        Exceptions.throwIfFatal(th6);
                        unsubscribe();
                        onError(th6);
                        return;
                    }
                    getOrCreateErrorQueue().offer(th6);
                }
                if (j3 != Long.MAX_VALUE) {
                    this.producer.produced(1);
                }
                int i3 = this.scalarEmissionCount + 1;
                if (i3 == this.scalarEmissionLimit) {
                    this.scalarEmissionCount = 0;
                    requestMore(i3);
                } else {
                    this.scalarEmissionCount = i3;
                }
                synchronized (this) {
                    if (!this.missed) {
                        this.emitting = false;
                    } else {
                        this.missed = false;
                        emitLoop();
                    }
                }
            } catch (Throwable th7) {
                th = th7;
                z16 = false;
                if (!z16) {
                    synchronized (this) {
                        this.emitting = false;
                    }
                }
                throw th;
            }
        }
    }

    OperatorMerge(boolean z16, int i3) {
        this.delayErrors = z16;
        this.maxConcurrent = i3;
    }

    public static <T> OperatorMerge<T> instance(boolean z16) {
        if (z16) {
            return (OperatorMerge<T>) HolderDelayErrors.INSTANCE;
        }
        return (OperatorMerge<T>) HolderNoDelay.INSTANCE;
    }

    @Override // rx.functions.Func1
    public Subscriber<Observable<? extends T>> call(Subscriber<? super T> subscriber) {
        MergeSubscriber mergeSubscriber = new MergeSubscriber(subscriber, this.delayErrors, this.maxConcurrent);
        MergeProducer<T> mergeProducer = new MergeProducer<>(mergeSubscriber);
        mergeSubscriber.producer = mergeProducer;
        subscriber.add(mergeSubscriber);
        subscriber.setProducer(mergeProducer);
        return mergeSubscriber;
    }

    public static <T> OperatorMerge<T> instance(boolean z16, int i3) {
        if (i3 > 0) {
            if (i3 == Integer.MAX_VALUE) {
                return instance(z16);
            }
            return new OperatorMerge<>(z16, i3);
        }
        throw new IllegalArgumentException("maxConcurrent > 0 required but it was " + i3);
    }
}
