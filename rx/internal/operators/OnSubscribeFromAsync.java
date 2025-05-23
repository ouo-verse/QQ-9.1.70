package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.AsyncEmitter;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action1;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue;
import rx.internal.util.unsafe.SpscUnboundedArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.SerialSubscription;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnSubscribeFromAsync<T> implements Observable.OnSubscribe<T> {
    final Action1<AsyncEmitter<T>> asyncEmitter;
    final AsyncEmitter.BackpressureMode backpressure;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: rx.internal.operators.OnSubscribeFromAsync$1, reason: invalid class name */
    /* loaded from: classes29.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$rx$AsyncEmitter$BackpressureMode;

        static {
            int[] iArr = new int[AsyncEmitter.BackpressureMode.values().length];
            $SwitchMap$rx$AsyncEmitter$BackpressureMode = iArr;
            try {
                iArr[AsyncEmitter.BackpressureMode.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$rx$AsyncEmitter$BackpressureMode[AsyncEmitter.BackpressureMode.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$rx$AsyncEmitter$BackpressureMode[AsyncEmitter.BackpressureMode.DROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$rx$AsyncEmitter$BackpressureMode[AsyncEmitter.BackpressureMode.LATEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class BufferAsyncEmitter<T> extends BaseAsyncEmitter<T> {
        private static final long serialVersionUID = 2427151001689639875L;
        volatile boolean done;
        Throwable error;

        /* renamed from: nl, reason: collision with root package name */
        final NotificationLite<T> f432662nl;
        final Queue<Object> queue;
        final AtomicInteger wip;

        public BufferAsyncEmitter(Subscriber<? super T> subscriber, int i3) {
            super(subscriber);
            Queue<Object> spscUnboundedAtomicArrayQueue;
            if (UnsafeAccess.isUnsafeAvailable()) {
                spscUnboundedAtomicArrayQueue = new SpscUnboundedArrayQueue<>(i3);
            } else {
                spscUnboundedAtomicArrayQueue = new SpscUnboundedAtomicArrayQueue<>(i3);
            }
            this.queue = spscUnboundedAtomicArrayQueue;
            this.wip = new AtomicInteger();
            this.f432662nl = NotificationLite.instance();
        }

        void drain() {
            boolean z16;
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.actual;
            Queue<Object> queue = this.queue;
            int i3 = 1;
            do {
                long j3 = get();
                long j16 = 0;
                while (j16 != j3) {
                    if (subscriber.isUnsubscribed()) {
                        queue.clear();
                        return;
                    }
                    boolean z17 = this.done;
                    Object poll = queue.poll();
                    if (poll == null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z17 && z16) {
                        Throwable th5 = this.error;
                        if (th5 != null) {
                            super.onError(th5);
                            return;
                        } else {
                            super.onCompleted();
                            return;
                        }
                    }
                    if (z16) {
                        break;
                    }
                    subscriber.onNext(this.f432662nl.getValue(poll));
                    j16++;
                }
                if (j16 == j3) {
                    if (subscriber.isUnsubscribed()) {
                        queue.clear();
                        return;
                    }
                    boolean z18 = this.done;
                    boolean isEmpty = queue.isEmpty();
                    if (z18 && isEmpty) {
                        Throwable th6 = this.error;
                        if (th6 != null) {
                            super.onError(th6);
                            return;
                        } else {
                            super.onCompleted();
                            return;
                        }
                    }
                }
                if (j16 != 0) {
                    BackpressureUtils.produced(this, j16);
                }
                i3 = this.wip.addAndGet(-i3);
            } while (i3 != 0);
        }

        @Override // rx.internal.operators.OnSubscribeFromAsync.BaseAsyncEmitter, rx.Observer
        public void onCompleted() {
            this.done = true;
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeFromAsync.BaseAsyncEmitter, rx.Observer
        public void onError(Throwable th5) {
            this.error = th5;
            this.done = true;
            drain();
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            this.queue.offer(this.f432662nl.next(t16));
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeFromAsync.BaseAsyncEmitter
        void onRequested() {
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeFromAsync.BaseAsyncEmitter
        void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.clear();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class CancellableSubscription extends AtomicReference<AsyncEmitter.Cancellable> implements Subscription {
        private static final long serialVersionUID = 5718521705281392066L;

        public CancellableSubscription(AsyncEmitter.Cancellable cancellable) {
            super(cancellable);
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            if (get() == null) {
                return true;
            }
            return false;
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            AsyncEmitter.Cancellable andSet;
            if (get() != null && (andSet = getAndSet(null)) != null) {
                try {
                    andSet.cancel();
                } catch (Exception e16) {
                    Exceptions.throwIfFatal(e16);
                    RxJavaHooks.onError(e16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ErrorAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 338953216916120960L;

        public ErrorAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // rx.internal.operators.OnSubscribeFromAsync.NoOverflowBaseAsyncEmitter
        void onOverflow() {
            onError(new MissingBackpressureException("fromAsync: could not emit value due to lack of requests"));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class LatestAsyncEmitter<T> extends BaseAsyncEmitter<T> {
        private static final long serialVersionUID = 4023437720691792495L;
        volatile boolean done;
        Throwable error;

        /* renamed from: nl, reason: collision with root package name */
        final NotificationLite<T> f432663nl;
        final AtomicReference<Object> queue;
        final AtomicInteger wip;

        public LatestAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
            this.queue = new AtomicReference<>();
            this.wip = new AtomicInteger();
            this.f432663nl = NotificationLite.instance();
        }

        void drain() {
            boolean z16;
            boolean z17;
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.actual;
            AtomicReference<Object> atomicReference = this.queue;
            int i3 = 1;
            do {
                long j3 = get();
                long j16 = 0;
                while (true) {
                    z16 = false;
                    if (j16 == j3) {
                        break;
                    }
                    if (subscriber.isUnsubscribed()) {
                        atomicReference.lazySet(null);
                        return;
                    }
                    boolean z18 = this.done;
                    Object andSet = atomicReference.getAndSet(null);
                    if (andSet == null) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z18 && z17) {
                        Throwable th5 = this.error;
                        if (th5 != null) {
                            super.onError(th5);
                            return;
                        } else {
                            super.onCompleted();
                            return;
                        }
                    }
                    if (z17) {
                        break;
                    }
                    subscriber.onNext(this.f432663nl.getValue(andSet));
                    j16++;
                }
                if (j16 == j3) {
                    if (subscriber.isUnsubscribed()) {
                        atomicReference.lazySet(null);
                        return;
                    }
                    boolean z19 = this.done;
                    if (atomicReference.get() == null) {
                        z16 = true;
                    }
                    if (z19 && z16) {
                        Throwable th6 = this.error;
                        if (th6 != null) {
                            super.onError(th6);
                            return;
                        } else {
                            super.onCompleted();
                            return;
                        }
                    }
                }
                if (j16 != 0) {
                    BackpressureUtils.produced(this, j16);
                }
                i3 = this.wip.addAndGet(-i3);
            } while (i3 != 0);
        }

        @Override // rx.internal.operators.OnSubscribeFromAsync.BaseAsyncEmitter, rx.Observer
        public void onCompleted() {
            this.done = true;
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeFromAsync.BaseAsyncEmitter, rx.Observer
        public void onError(Throwable th5) {
            this.error = th5;
            this.done = true;
            drain();
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            this.queue.set(this.f432663nl.next(t16));
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeFromAsync.BaseAsyncEmitter
        void onRequested() {
            drain();
        }

        @Override // rx.internal.operators.OnSubscribeFromAsync.BaseAsyncEmitter
        void onUnsubscribed() {
            if (this.wip.getAndIncrement() == 0) {
                this.queue.lazySet(null);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static abstract class NoOverflowBaseAsyncEmitter<T> extends BaseAsyncEmitter<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        public NoOverflowBaseAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // rx.Observer
        public final void onNext(T t16) {
            if (this.actual.isUnsubscribed()) {
                return;
            }
            if (get() != 0) {
                this.actual.onNext(t16);
                BackpressureUtils.produced(this, 1L);
            } else {
                onOverflow();
            }
        }

        abstract void onOverflow();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class NoneAsyncEmitter<T> extends BaseAsyncEmitter<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        public NoneAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            long j3;
            if (this.actual.isUnsubscribed()) {
                return;
            }
            this.actual.onNext(t16);
            do {
                j3 = get();
                if (j3 == 0) {
                    return;
                }
            } while (!compareAndSet(j3, j3 - 1));
        }
    }

    public OnSubscribeFromAsync(Action1<AsyncEmitter<T>> action1, AsyncEmitter.BackpressureMode backpressureMode) {
        this.asyncEmitter = action1;
        this.backpressure = backpressureMode;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super T> subscriber) {
        BaseAsyncEmitter noneAsyncEmitter;
        int i3 = AnonymousClass1.$SwitchMap$rx$AsyncEmitter$BackpressureMode[this.backpressure.ordinal()];
        if (i3 == 1) {
            noneAsyncEmitter = new NoneAsyncEmitter(subscriber);
        } else if (i3 == 2) {
            noneAsyncEmitter = new ErrorAsyncEmitter(subscriber);
        } else if (i3 == 3) {
            noneAsyncEmitter = new DropAsyncEmitter(subscriber);
        } else if (i3 != 4) {
            noneAsyncEmitter = new BufferAsyncEmitter(subscriber, RxRingBuffer.SIZE);
        } else {
            noneAsyncEmitter = new LatestAsyncEmitter(subscriber);
        }
        subscriber.add(noneAsyncEmitter);
        subscriber.setProducer(noneAsyncEmitter);
        this.asyncEmitter.call(noneAsyncEmitter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static abstract class BaseAsyncEmitter<T> extends AtomicLong implements AsyncEmitter<T>, Producer, Subscription {
        private static final long serialVersionUID = 7326289992464377023L;
        final Subscriber<? super T> actual;
        final SerialSubscription serial = new SerialSubscription();

        public BaseAsyncEmitter(Subscriber<? super T> subscriber) {
            this.actual = subscriber;
        }

        @Override // rx.Subscription
        public final boolean isUnsubscribed() {
            return this.serial.isUnsubscribed();
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (this.actual.isUnsubscribed()) {
                return;
            }
            try {
                this.actual.onCompleted();
            } finally {
                this.serial.unsubscribe();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            if (this.actual.isUnsubscribed()) {
                return;
            }
            try {
                this.actual.onError(th5);
            } finally {
                this.serial.unsubscribe();
            }
        }

        @Override // rx.Producer
        public final void request(long j3) {
            if (BackpressureUtils.validate(j3)) {
                BackpressureUtils.getAndAddRequest(this, j3);
                onRequested();
            }
        }

        @Override // rx.AsyncEmitter
        public final long requested() {
            return get();
        }

        @Override // rx.AsyncEmitter
        public final void setCancellation(AsyncEmitter.Cancellable cancellable) {
            setSubscription(new CancellableSubscription(cancellable));
        }

        @Override // rx.AsyncEmitter
        public final void setSubscription(Subscription subscription) {
            this.serial.set(subscription);
        }

        @Override // rx.Subscription
        public final void unsubscribe() {
            this.serial.unsubscribe();
            onUnsubscribed();
        }

        void onRequested() {
        }

        void onUnsubscribed() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class DropAsyncEmitter<T> extends NoOverflowBaseAsyncEmitter<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        public DropAsyncEmitter(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // rx.internal.operators.OnSubscribeFromAsync.NoOverflowBaseAsyncEmitter
        void onOverflow() {
        }
    }
}
