package rx.subjects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.annotations.Beta;
import rx.exceptions.Exceptions;
import rx.internal.operators.BackpressureUtils;
import rx.plugins.RxJavaHooks;
import rx.schedulers.Schedulers;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ReplaySubject<T> extends Subject<T, T> {
    private static final Object[] EMPTY_ARRAY = new Object[0];
    final ReplayState<T> state;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface ReplayBuffer<T> {
        void complete();

        void drain(ReplayProducer<T> replayProducer);

        Throwable error();

        void error(Throwable th5);

        boolean isComplete();

        boolean isEmpty();

        T last();

        void next(T t16);

        int size();

        T[] toArray(T[] tArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ReplayProducer<T> extends AtomicInteger implements Producer, Subscription {
        private static final long serialVersionUID = -5006209596735204567L;
        final Subscriber<? super T> actual;
        int index;
        Object node;
        final AtomicLong requested = new AtomicLong();
        final ReplayState<T> state;
        int tailIndex;

        public ReplayProducer(Subscriber<? super T> subscriber, ReplayState<T> replayState) {
            this.actual = subscriber;
            this.state = replayState;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.actual.isUnsubscribed();
        }

        @Override // rx.Producer
        public void request(long j3) {
            if (j3 > 0) {
                BackpressureUtils.getAndAddRequest(this.requested, j3);
                this.state.buffer.drain(this);
            } else {
                if (j3 >= 0) {
                    return;
                }
                throw new IllegalArgumentException("n >= required but it was " + j3);
            }
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            this.state.remove(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ReplayState<T> extends AtomicReference<ReplayProducer<T>[]> implements Observable.OnSubscribe<T>, Observer<T> {
        static final ReplayProducer[] EMPTY = new ReplayProducer[0];
        static final ReplayProducer[] TERMINATED = new ReplayProducer[0];
        private static final long serialVersionUID = 5952362471246910544L;
        final ReplayBuffer<T> buffer;

        public ReplayState(ReplayBuffer<T> replayBuffer) {
            this.buffer = replayBuffer;
            lazySet(EMPTY);
        }

        boolean add(ReplayProducer<T> replayProducer) {
            ReplayProducer<T>[] replayProducerArr;
            ReplayProducer[] replayProducerArr2;
            do {
                replayProducerArr = get();
                if (replayProducerArr == TERMINATED) {
                    return false;
                }
                int length = replayProducerArr.length;
                replayProducerArr2 = new ReplayProducer[length + 1];
                System.arraycopy(replayProducerArr, 0, replayProducerArr2, 0, length);
                replayProducerArr2[length] = replayProducer;
            } while (!compareAndSet(replayProducerArr, replayProducerArr2));
            return true;
        }

        boolean isTerminated() {
            if (get() == TERMINATED) {
                return true;
            }
            return false;
        }

        @Override // rx.Observer
        public void onCompleted() {
            ReplayBuffer<T> replayBuffer = this.buffer;
            replayBuffer.complete();
            for (ReplayProducer<T> replayProducer : getAndSet(TERMINATED)) {
                replayBuffer.drain(replayProducer);
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            ReplayBuffer<T> replayBuffer = this.buffer;
            replayBuffer.error(th5);
            ArrayList arrayList = null;
            for (ReplayProducer<T> replayProducer : getAndSet(TERMINATED)) {
                try {
                    replayBuffer.drain(replayProducer);
                } catch (Throwable th6) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th6);
                }
            }
            Exceptions.throwIfAny(arrayList);
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            ReplayBuffer<T> replayBuffer = this.buffer;
            replayBuffer.next(t16);
            for (ReplayProducer<T> replayProducer : get()) {
                replayBuffer.drain(replayProducer);
            }
        }

        void remove(ReplayProducer<T> replayProducer) {
            ReplayProducer<T>[] replayProducerArr;
            ReplayProducer[] replayProducerArr2;
            do {
                replayProducerArr = get();
                if (replayProducerArr != TERMINATED && replayProducerArr != EMPTY) {
                    int length = replayProducerArr.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 < length) {
                            if (replayProducerArr[i3] == replayProducer) {
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
                        replayProducerArr2 = EMPTY;
                    } else {
                        ReplayProducer[] replayProducerArr3 = new ReplayProducer[length - 1];
                        System.arraycopy(replayProducerArr, 0, replayProducerArr3, 0, i3);
                        System.arraycopy(replayProducerArr, i3 + 1, replayProducerArr3, i3, (length - i3) - 1);
                        replayProducerArr2 = replayProducerArr3;
                    }
                } else {
                    return;
                }
            } while (!compareAndSet(replayProducerArr, replayProducerArr2));
        }

        @Override // rx.functions.Action1
        public void call(Subscriber<? super T> subscriber) {
            ReplayProducer<T> replayProducer = new ReplayProducer<>(subscriber, this);
            subscriber.add(replayProducer);
            subscriber.setProducer(replayProducer);
            if (add(replayProducer) && replayProducer.isUnsubscribed()) {
                remove(replayProducer);
            } else {
                this.buffer.drain(replayProducer);
            }
        }
    }

    ReplaySubject(ReplayState<T> replayState) {
        super(replayState);
        this.state = replayState;
    }

    public static <T> ReplaySubject<T> create() {
        return create(16);
    }

    static <T> ReplaySubject<T> createUnbounded() {
        return new ReplaySubject<>(new ReplayState(new ReplaySizeBoundBuffer(Integer.MAX_VALUE)));
    }

    static <T> ReplaySubject<T> createUnboundedTime() {
        return new ReplaySubject<>(new ReplayState(new ReplaySizeAndTimeBoundBuffer(Integer.MAX_VALUE, Long.MAX_VALUE, Schedulers.immediate())));
    }

    public static <T> ReplaySubject<T> createWithSize(int i3) {
        return new ReplaySubject<>(new ReplayState(new ReplaySizeBoundBuffer(i3)));
    }

    public static <T> ReplaySubject<T> createWithTime(long j3, TimeUnit timeUnit, Scheduler scheduler) {
        return createWithTimeAndSize(j3, timeUnit, Integer.MAX_VALUE, scheduler);
    }

    public static <T> ReplaySubject<T> createWithTimeAndSize(long j3, TimeUnit timeUnit, int i3, Scheduler scheduler) {
        return new ReplaySubject<>(new ReplayState(new ReplaySizeAndTimeBoundBuffer(i3, timeUnit.toMillis(j3), scheduler)));
    }

    @Beta
    public Throwable getThrowable() {
        if (this.state.isTerminated()) {
            return this.state.buffer.error();
        }
        return null;
    }

    @Beta
    public T getValue() {
        return this.state.buffer.last();
    }

    @Beta
    public T[] getValues(T[] tArr) {
        return this.state.buffer.toArray(tArr);
    }

    @Beta
    public boolean hasAnyValue() {
        return !this.state.buffer.isEmpty();
    }

    @Beta
    public boolean hasCompleted() {
        if (this.state.isTerminated() && this.state.buffer.error() == null) {
            return true;
        }
        return false;
    }

    @Override // rx.subjects.Subject
    public boolean hasObservers() {
        if (this.state.get().length != 0) {
            return true;
        }
        return false;
    }

    @Beta
    public boolean hasThrowable() {
        if (this.state.isTerminated() && this.state.buffer.error() != null) {
            return true;
        }
        return false;
    }

    @Beta
    public boolean hasValue() {
        return hasAnyValue();
    }

    @Override // rx.Observer
    public void onCompleted() {
        this.state.onCompleted();
    }

    @Override // rx.Observer
    public void onError(Throwable th5) {
        this.state.onError(th5);
    }

    @Override // rx.Observer
    public void onNext(T t16) {
        this.state.onNext(t16);
    }

    @Beta
    public int size() {
        return this.state.buffer.size();
    }

    int subscriberCount() {
        return this.state.get().length;
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class ReplaySizeBoundBuffer<T> implements ReplayBuffer<T> {
        volatile boolean done;
        Throwable error;
        volatile Node<T> head;
        final int limit;
        int size;
        Node<T> tail;

        /* compiled from: P */
        /* loaded from: classes29.dex */
        static final class Node<T> extends AtomicReference<Node<T>> {
            private static final long serialVersionUID = 3713592843205853725L;
            final T value;

            public Node(T t16) {
                this.value = t16;
            }
        }

        public ReplaySizeBoundBuffer(int i3) {
            this.limit = i3;
            Node<T> node = new Node<>(null);
            this.tail = node;
            this.head = node;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void complete() {
            this.done = true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x005e, code lost:
        
            if (r10 != r5) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0064, code lost:
        
            if (r2.isUnsubscribed() == false) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0069, code lost:
        
            r3 = r17.done;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x006f, code lost:
        
            if (r7.get() != null) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0071, code lost:
        
            r13 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0072, code lost:
        
            if (r3 == false) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0074, code lost:
        
            if (r13 == false) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0076, code lost:
        
            r18.node = null;
            r1 = r17.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x007a, code lost:
        
            if (r1 == null) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x007c, code lost:
        
            r2.onError(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0080, code lost:
        
            r2.onCompleted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0083, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0066, code lost:
        
            r18.node = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0068, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0086, code lost:
        
            if (r10 == 0) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x008f, code lost:
        
            if (r5 == Long.MAX_VALUE) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0091, code lost:
        
            rx.internal.operators.BackpressureUtils.produced(r18.requested, r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0096, code lost:
        
            r18.node = r7;
            r4 = r18.addAndGet(-r4);
         */
        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drain(ReplayProducer<T> replayProducer) {
            boolean z16;
            if (replayProducer.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = replayProducer.actual;
            int i3 = 1;
            do {
                long j3 = replayProducer.requested.get();
                Node<T> node = (Node) replayProducer.node;
                if (node == null) {
                    node = this.head;
                }
                long j16 = 0;
                while (true) {
                    boolean z17 = false;
                    if (j16 == j3) {
                        break;
                    }
                    if (subscriber.isUnsubscribed()) {
                        replayProducer.node = null;
                        return;
                    }
                    boolean z18 = this.done;
                    Node<T> node2 = node.get();
                    if (node2 == null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z18 && z16) {
                        replayProducer.node = null;
                        Throwable th5 = this.error;
                        if (th5 != null) {
                            subscriber.onError(th5);
                            return;
                        } else {
                            subscriber.onCompleted();
                            return;
                        }
                    }
                    if (z16) {
                        break;
                    }
                    subscriber.onNext(node2.value);
                    j16++;
                    node = node2;
                }
            } while (i3 != 0);
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void error(Throwable th5) {
            this.error = th5;
            this.done = true;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public boolean isComplete() {
            return this.done;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public boolean isEmpty() {
            if (this.head.get() == null) {
                return true;
            }
            return false;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public T last() {
            Node<T> node = this.head;
            while (true) {
                Node<T> node2 = node.get();
                if (node2 != null) {
                    node = node2;
                } else {
                    return node.value;
                }
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void next(T t16) {
            Node<T> node = new Node<>(t16);
            this.tail.set(node);
            this.tail = node;
            int i3 = this.size;
            if (i3 == this.limit) {
                this.head = this.head.get();
            } else {
                this.size = i3 + 1;
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            Node<T> node = this.head.get();
            int i3 = 0;
            while (node != null && i3 != Integer.MAX_VALUE) {
                node = node.get();
                i3++;
            }
            return i3;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public T[] toArray(T[] tArr) {
            ArrayList arrayList = new ArrayList();
            for (Node<T> node = this.head.get(); node != null; node = node.get()) {
                arrayList.add(node.value);
            }
            return (T[]) arrayList.toArray(tArr);
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public Throwable error() {
            return this.error;
        }
    }

    public static <T> ReplaySubject<T> create(int i3) {
        if (i3 > 0) {
            return new ReplaySubject<>(new ReplayState(new ReplayUnboundedBuffer(i3)));
        }
        throw new IllegalArgumentException("capacity > 0 required but it was " + i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Beta
    public Object[] getValues() {
        Object[] objArr = EMPTY_ARRAY;
        Object[] values = getValues(objArr);
        return values == objArr ? new Object[0] : values;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ReplaySizeAndTimeBoundBuffer<T> implements ReplayBuffer<T> {
        volatile boolean done;
        Throwable error;
        volatile TimedNode<T> head;
        final int limit;
        final long maxAgeMillis;
        final Scheduler scheduler;
        int size;
        TimedNode<T> tail;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
            private static final long serialVersionUID = 3713592843205853725L;
            final long timestamp;
            final T value;

            public TimedNode(T t16, long j3) {
                this.value = t16;
                this.timestamp = j3;
            }
        }

        public ReplaySizeAndTimeBoundBuffer(int i3, long j3, Scheduler scheduler) {
            this.limit = i3;
            TimedNode<T> timedNode = new TimedNode<>(null, 0L);
            this.tail = timedNode;
            this.head = timedNode;
            this.maxAgeMillis = j3;
            this.scheduler = scheduler;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void complete() {
            evictFinal();
            this.done = true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x0060, code lost:
        
            if (r10 != r5) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0066, code lost:
        
            if (r2.isUnsubscribed() == false) goto L35;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x006b, code lost:
        
            r3 = r17.done;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0071, code lost:
        
            if (r7.get() != null) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0073, code lost:
        
            r13 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0074, code lost:
        
            if (r3 == false) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0076, code lost:
        
            if (r13 == false) goto L45;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0078, code lost:
        
            r18.node = null;
            r1 = r17.error;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x007c, code lost:
        
            if (r1 == null) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x007e, code lost:
        
            r2.onError(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0082, code lost:
        
            r2.onCompleted();
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0085, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0068, code lost:
        
            r18.node = null;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x006a, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0088, code lost:
        
            if (r10 == 0) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x0091, code lost:
        
            if (r5 == Long.MAX_VALUE) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x0093, code lost:
        
            rx.internal.operators.BackpressureUtils.produced(r18.requested, r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x0098, code lost:
        
            r18.node = r7;
            r4 = r18.addAndGet(-r4);
         */
        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void drain(ReplayProducer<T> replayProducer) {
            boolean z16;
            if (replayProducer.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = replayProducer.actual;
            int i3 = 1;
            do {
                long j3 = replayProducer.requested.get();
                TimedNode<T> timedNode = (TimedNode) replayProducer.node;
                if (timedNode == null) {
                    timedNode = latestHead();
                }
                long j16 = 0;
                while (true) {
                    boolean z17 = false;
                    if (j16 == j3) {
                        break;
                    }
                    if (subscriber.isUnsubscribed()) {
                        replayProducer.node = null;
                        return;
                    }
                    boolean z18 = this.done;
                    TimedNode<T> timedNode2 = timedNode.get();
                    if (timedNode2 == null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z18 && z16) {
                        replayProducer.node = null;
                        Throwable th5 = this.error;
                        if (th5 != null) {
                            subscriber.onError(th5);
                            return;
                        } else {
                            subscriber.onCompleted();
                            return;
                        }
                    }
                    if (z16) {
                        break;
                    }
                    subscriber.onNext(timedNode2.value);
                    j16++;
                    timedNode = timedNode2;
                }
            } while (i3 != 0);
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void error(Throwable th5) {
            evictFinal();
            this.error = th5;
            this.done = true;
        }

        void evictFinal() {
            long now = this.scheduler.now() - this.maxAgeMillis;
            TimedNode<T> timedNode = this.head;
            TimedNode<T> timedNode2 = timedNode;
            while (true) {
                TimedNode<T> timedNode3 = timedNode2.get();
                if (timedNode3 == null || timedNode3.timestamp > now) {
                    break;
                } else {
                    timedNode2 = timedNode3;
                }
            }
            if (timedNode != timedNode2) {
                this.head = timedNode2;
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public boolean isComplete() {
            return this.done;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public boolean isEmpty() {
            if (latestHead().get() == null) {
                return true;
            }
            return false;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public T last() {
            TimedNode<T> latestHead = latestHead();
            while (true) {
                TimedNode<T> timedNode = latestHead.get();
                if (timedNode != null) {
                    latestHead = timedNode;
                } else {
                    return latestHead.value;
                }
            }
        }

        TimedNode<T> latestHead() {
            long now = this.scheduler.now() - this.maxAgeMillis;
            TimedNode<T> timedNode = this.head;
            while (true) {
                TimedNode<T> timedNode2 = timedNode.get();
                if (timedNode2 == null || timedNode2.timestamp > now) {
                    break;
                }
                timedNode = timedNode2;
            }
            return timedNode;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void next(T t16) {
            TimedNode<T> timedNode;
            long now = this.scheduler.now();
            TimedNode<T> timedNode2 = new TimedNode<>(t16, now);
            this.tail.set(timedNode2);
            this.tail = timedNode2;
            long j3 = now - this.maxAgeMillis;
            int i3 = this.size;
            TimedNode<T> timedNode3 = this.head;
            if (i3 == this.limit) {
                timedNode = timedNode3.get();
            } else {
                i3++;
                timedNode = timedNode3;
            }
            while (true) {
                TimedNode<T> timedNode4 = timedNode.get();
                if (timedNode4 == null || timedNode4.timestamp > j3) {
                    break;
                }
                i3--;
                timedNode = timedNode4;
            }
            this.size = i3;
            if (timedNode != timedNode3) {
                this.head = timedNode;
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            TimedNode<T> timedNode = latestHead().get();
            int i3 = 0;
            while (timedNode != null && i3 != Integer.MAX_VALUE) {
                timedNode = timedNode.get();
                i3++;
            }
            return i3;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public T[] toArray(T[] tArr) {
            ArrayList arrayList = new ArrayList();
            for (TimedNode<T> timedNode = latestHead().get(); timedNode != null; timedNode = timedNode.get()) {
                arrayList.add(timedNode.value);
            }
            return (T[]) arrayList.toArray(tArr);
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public Throwable error() {
            return this.error;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ReplayUnboundedBuffer<T> implements ReplayBuffer<T> {
        final int capacity;
        volatile boolean done;
        Throwable error;
        final Object[] head;
        volatile int size;
        Object[] tail;
        int tailIndex;

        public ReplayUnboundedBuffer(int i3) {
            this.capacity = i3;
            Object[] objArr = new Object[i3 + 1];
            this.head = objArr;
            this.tail = objArr;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void complete() {
            this.done = true;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void drain(ReplayProducer<T> replayProducer) {
            boolean z16;
            boolean z17;
            if (replayProducer.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = replayProducer.actual;
            int i3 = this.capacity;
            int i16 = 1;
            do {
                long j3 = replayProducer.requested.get();
                Object[] objArr = (Object[]) replayProducer.node;
                if (objArr == null) {
                    objArr = this.head;
                }
                int i17 = replayProducer.tailIndex;
                int i18 = replayProducer.index;
                long j16 = 0;
                while (true) {
                    z16 = false;
                    if (j16 == j3) {
                        break;
                    }
                    if (subscriber.isUnsubscribed()) {
                        replayProducer.node = null;
                        return;
                    }
                    boolean z18 = this.done;
                    if (i18 == this.size) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z18 && z17) {
                        replayProducer.node = null;
                        Throwable th5 = this.error;
                        if (th5 != null) {
                            subscriber.onError(th5);
                            return;
                        } else {
                            subscriber.onCompleted();
                            return;
                        }
                    }
                    if (z17) {
                        break;
                    }
                    if (i17 == i3) {
                        objArr = (Object[]) objArr[i17];
                        i17 = 0;
                    }
                    subscriber.onNext(objArr[i17]);
                    j16++;
                    i17++;
                    i18++;
                }
                if (j16 == j3) {
                    if (subscriber.isUnsubscribed()) {
                        replayProducer.node = null;
                        return;
                    }
                    boolean z19 = this.done;
                    if (i18 == this.size) {
                        z16 = true;
                    }
                    if (z19 && z16) {
                        replayProducer.node = null;
                        Throwable th6 = this.error;
                        if (th6 != null) {
                            subscriber.onError(th6);
                            return;
                        } else {
                            subscriber.onCompleted();
                            return;
                        }
                    }
                }
                if (j16 != 0 && j3 != Long.MAX_VALUE) {
                    BackpressureUtils.produced(replayProducer.requested, j16);
                }
                replayProducer.index = i18;
                replayProducer.tailIndex = i17;
                replayProducer.node = objArr;
                i16 = replayProducer.addAndGet(-i16);
            } while (i16 != 0);
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void error(Throwable th5) {
            if (this.done) {
                RxJavaHooks.onError(th5);
            } else {
                this.error = th5;
                this.done = true;
            }
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public boolean isComplete() {
            return this.done;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public boolean isEmpty() {
            if (this.size == 0) {
                return true;
            }
            return false;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public T last() {
            int i3 = this.size;
            if (i3 == 0) {
                return null;
            }
            Object[] objArr = this.head;
            int i16 = this.capacity;
            while (i3 >= i16) {
                objArr = (Object[]) objArr[i16];
                i3 -= i16;
            }
            return (T) objArr[i3 - 1];
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public void next(T t16) {
            if (this.done) {
                return;
            }
            int i3 = this.tailIndex;
            Object[] objArr = this.tail;
            if (i3 == objArr.length - 1) {
                Object[] objArr2 = new Object[objArr.length];
                objArr2[0] = t16;
                this.tailIndex = 1;
                objArr[i3] = objArr2;
                this.tail = objArr2;
            } else {
                objArr[i3] = t16;
                this.tailIndex = i3 + 1;
            }
            this.size++;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public int size() {
            return this.size;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public T[] toArray(T[] tArr) {
            int i3 = this.size;
            if (tArr.length < i3) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i3));
            }
            Object[] objArr = this.head;
            int i16 = this.capacity;
            int i17 = 0;
            while (true) {
                int i18 = i17 + i16;
                if (i18 >= i3) {
                    break;
                }
                System.arraycopy(objArr, 0, tArr, i17, i16);
                objArr = objArr[i16];
                i17 = i18;
            }
            System.arraycopy(objArr, 0, tArr, i17, i3 - i17);
            if (tArr.length > i3) {
                tArr[i3] = null;
            }
            return tArr;
        }

        @Override // rx.subjects.ReplaySubject.ReplayBuffer
        public Throwable error() {
            return this.error;
        }
    }
}
