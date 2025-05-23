package rx.internal.operators;

import androidx.lifecycle.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.internal.util.OpenHashSet;
import rx.observables.ConnectableObservable;
import rx.schedulers.Timestamped;
import rx.subscriptions.Subscriptions;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorReplay<T> extends ConnectableObservable<T> {
    static final Func0 DEFAULT_UNBOUNDED_FACTORY = new Func0() { // from class: rx.internal.operators.OperatorReplay.1
        @Override // rx.functions.Func0, java.util.concurrent.Callable
        public Object call() {
            return new UnboundedReplayBuffer(16);
        }
    };
    final Func0<? extends ReplayBuffer<T>> bufferFactory;
    final AtomicReference<ReplaySubscriber<T>> current;
    final Observable<? extends T> source;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class InnerProducer<T> extends AtomicLong implements Producer, Subscription {
        static final long UNSUBSCRIBED = Long.MIN_VALUE;
        private static final long serialVersionUID = -4453897557930727610L;
        final Subscriber<? super T> child;
        boolean emitting;
        Object index;
        boolean missed;
        final ReplaySubscriber<T> parent;
        final AtomicLong totalRequested = new AtomicLong();

        public InnerProducer(ReplaySubscriber<T> replaySubscriber, Subscriber<? super T> subscriber) {
            this.parent = replaySubscriber;
            this.child = subscriber;
        }

        void addTotalRequested(long j3) {
            long j16;
            long j17;
            do {
                j16 = this.totalRequested.get();
                j17 = j16 + j3;
                if (j17 < 0) {
                    j17 = Long.MAX_VALUE;
                }
            } while (!this.totalRequested.compareAndSet(j16, j17));
        }

        <U> U index() {
            return (U) this.index;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            if (get() == Long.MIN_VALUE) {
                return true;
            }
            return false;
        }

        public long produced(long j3) {
            long j16;
            long j17;
            if (j3 <= 0) {
                throw new IllegalArgumentException("Cant produce zero or less");
            }
            do {
                j16 = get();
                if (j16 == Long.MIN_VALUE) {
                    return Long.MIN_VALUE;
                }
                j17 = j16 - j3;
                if (j17 < 0) {
                    throw new IllegalStateException("More produced (" + j3 + ") than requested (" + j16 + ")");
                }
            } while (!compareAndSet(j16, j17));
            return j17;
        }

        @Override // rx.Producer
        public void request(long j3) {
            long j16;
            long j17;
            if (j3 < 0) {
                return;
            }
            do {
                j16 = get();
                if (j16 == Long.MIN_VALUE) {
                    return;
                }
                if (j16 >= 0 && j3 == 0) {
                    return;
                }
                j17 = j16 + j3;
                if (j17 < 0) {
                    j17 = Long.MAX_VALUE;
                }
            } while (!compareAndSet(j16, j17));
            addTotalRequested(j3);
            this.parent.manageRequests(this);
            this.parent.buffer.replay(this);
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (get() != Long.MIN_VALUE && getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.remove(this);
                this.parent.manageRequests(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class Node extends AtomicReference<Node> {
        private static final long serialVersionUID = 245354315435971818L;
        final long index;
        final Object value;

        public Node(Object obj, long j3) {
            this.value = obj;
            this.index = j3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public interface ReplayBuffer<T> {
        void complete();

        void error(Throwable th5);

        void next(T t16);

        void replay(InnerProducer<T> innerProducer);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ReplaySubscriber<T> extends Subscriber<T> {
        static final InnerProducer[] EMPTY = new InnerProducer[0];
        static final InnerProducer[] TERMINATED = new InnerProducer[0];
        final ReplayBuffer<T> buffer;
        boolean coordinateAll;
        List<InnerProducer<T>> coordinationQueue;
        boolean done;
        boolean emitting;
        long maxChildRequested;
        long maxUpstreamRequested;
        boolean missed;
        volatile Producer producer;
        long producersCacheVersion;
        volatile long producersVersion;
        volatile boolean terminated;

        /* renamed from: nl, reason: collision with root package name */
        final NotificationLite<T> f432678nl = NotificationLite.instance();
        final OpenHashSet<InnerProducer<T>> producers = new OpenHashSet<>();
        InnerProducer<T>[] producersCache = EMPTY;
        final AtomicBoolean shouldConnect = new AtomicBoolean();

        public ReplaySubscriber(ReplayBuffer<T> replayBuffer) {
            this.buffer = replayBuffer;
            request(0L);
        }

        boolean add(InnerProducer<T> innerProducer) {
            innerProducer.getClass();
            if (this.terminated) {
                return false;
            }
            synchronized (this.producers) {
                if (this.terminated) {
                    return false;
                }
                this.producers.add(innerProducer);
                this.producersVersion++;
                return true;
            }
        }

        InnerProducer<T>[] copyProducers() {
            InnerProducer<T>[] innerProducerArr;
            synchronized (this.producers) {
                InnerProducer<T>[] values = this.producers.values();
                int length = values.length;
                innerProducerArr = new InnerProducer[length];
                System.arraycopy(values, 0, innerProducerArr, 0, length);
            }
            return innerProducerArr;
        }

        void init() {
            add(Subscriptions.create(new Action0() { // from class: rx.internal.operators.OperatorReplay.ReplaySubscriber.1
                @Override // rx.functions.Action0
                public void call() {
                    if (!ReplaySubscriber.this.terminated) {
                        synchronized (ReplaySubscriber.this.producers) {
                            if (!ReplaySubscriber.this.terminated) {
                                ReplaySubscriber.this.producers.terminate();
                                ReplaySubscriber.this.producersVersion++;
                                ReplaySubscriber.this.terminated = true;
                            }
                        }
                    }
                }
            }));
        }

        void makeRequest(long j3, long j16) {
            long j17 = this.maxUpstreamRequested;
            Producer producer = this.producer;
            long j18 = j3 - j16;
            if (j18 != 0) {
                this.maxChildRequested = j3;
                if (producer != null) {
                    if (j17 != 0) {
                        this.maxUpstreamRequested = 0L;
                        producer.request(j17 + j18);
                        return;
                    } else {
                        producer.request(j18);
                        return;
                    }
                }
                long j19 = j17 + j18;
                if (j19 < 0) {
                    j19 = Long.MAX_VALUE;
                }
                this.maxUpstreamRequested = j19;
                return;
            }
            if (j17 != 0 && producer != null) {
                this.maxUpstreamRequested = 0L;
                producer.request(j17);
            }
        }

        void manageRequests(InnerProducer<T> innerProducer) {
            long j3;
            List<InnerProducer<T>> list;
            boolean z16;
            long j16;
            if (isUnsubscribed()) {
                return;
            }
            synchronized (this) {
                if (this.emitting) {
                    if (innerProducer != null) {
                        List list2 = this.coordinationQueue;
                        if (list2 == null) {
                            list2 = new ArrayList();
                            this.coordinationQueue = list2;
                        }
                        list2.add(innerProducer);
                    } else {
                        this.coordinateAll = true;
                    }
                    this.missed = true;
                    return;
                }
                this.emitting = true;
                long j17 = this.maxChildRequested;
                if (innerProducer != null) {
                    j3 = Math.max(j17, innerProducer.totalRequested.get());
                } else {
                    long j18 = j17;
                    for (InnerProducer<T> innerProducer2 : copyProducers()) {
                        if (innerProducer2 != null) {
                            j18 = Math.max(j18, innerProducer2.totalRequested.get());
                        }
                    }
                    j3 = j18;
                }
                makeRequest(j3, j17);
                while (!isUnsubscribed()) {
                    synchronized (this) {
                        if (!this.missed) {
                            this.emitting = false;
                            return;
                        }
                        this.missed = false;
                        list = this.coordinationQueue;
                        this.coordinationQueue = null;
                        z16 = this.coordinateAll;
                        this.coordinateAll = false;
                    }
                    long j19 = this.maxChildRequested;
                    if (list != null) {
                        Iterator<InnerProducer<T>> it = list.iterator();
                        j16 = j19;
                        while (it.hasNext()) {
                            j16 = Math.max(j16, it.next().totalRequested.get());
                        }
                    } else {
                        j16 = j19;
                    }
                    if (z16) {
                        for (InnerProducer<T> innerProducer3 : copyProducers()) {
                            if (innerProducer3 != null) {
                                j16 = Math.max(j16, innerProducer3.totalRequested.get());
                            }
                        }
                    }
                    makeRequest(j16, j19);
                }
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                try {
                    this.buffer.complete();
                    replay();
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            if (!this.done) {
                this.done = true;
                try {
                    this.buffer.error(th5);
                    replay();
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            if (!this.done) {
                this.buffer.next(t16);
                replay();
            }
        }

        void remove(InnerProducer<T> innerProducer) {
            if (this.terminated) {
                return;
            }
            synchronized (this.producers) {
                if (this.terminated) {
                    return;
                }
                this.producers.remove(innerProducer);
                this.producersVersion++;
            }
        }

        void replay() {
            InnerProducer<T>[] innerProducerArr = this.producersCache;
            if (this.producersCacheVersion != this.producersVersion) {
                synchronized (this.producers) {
                    innerProducerArr = this.producersCache;
                    InnerProducer<T>[] values = this.producers.values();
                    int length = values.length;
                    if (innerProducerArr.length != length) {
                        innerProducerArr = new InnerProducer[length];
                        this.producersCache = innerProducerArr;
                    }
                    System.arraycopy(values, 0, innerProducerArr, 0, length);
                    this.producersCacheVersion = this.producersVersion;
                }
            }
            ReplayBuffer<T> replayBuffer = this.buffer;
            for (InnerProducer<T> innerProducer : innerProducerArr) {
                if (innerProducer != null) {
                    replayBuffer.replay(innerProducer);
                }
            }
        }

        @Override // rx.Subscriber
        public void setProducer(Producer producer) {
            if (this.producer == null) {
                this.producer = producer;
                manageRequests(null);
                replay();
                return;
            }
            throw new IllegalStateException("Only a single producer can be set on a Subscriber.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SizeAndTimeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = 3457957419649567404L;
        final int limit;
        final long maxAgeInMillis;
        final Scheduler scheduler;

        public SizeAndTimeBoundReplayBuffer(int i3, long j3, Scheduler scheduler) {
            this.scheduler = scheduler;
            this.limit = i3;
            this.maxAgeInMillis = j3;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        Object enterTransform(Object obj) {
            return new Timestamped(this.scheduler.now(), obj);
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        Node getInitialHead() {
            Node node;
            long now = this.scheduler.now() - this.maxAgeInMillis;
            Node node2 = get();
            Node node3 = node2.get();
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 == null || ((Timestamped) node2.value).getTimestampMillis() > now) {
                    break;
                }
                node3 = node2.get();
            }
            return node;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        Object leaveTransform(Object obj) {
            return ((Timestamped) obj).getValue();
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        void truncate() {
            Node node;
            long now = this.scheduler.now() - this.maxAgeInMillis;
            Node node2 = get();
            Node node3 = node2.get();
            int i3 = 0;
            while (true) {
                Node node4 = node3;
                node = node2;
                node2 = node4;
                if (node2 != null) {
                    int i16 = this.size;
                    if (i16 > this.limit) {
                        i3++;
                        this.size = i16 - 1;
                        node3 = node2.get();
                    } else {
                        if (((Timestamped) node2.value).getTimestampMillis() > now) {
                            break;
                        }
                        i3++;
                        this.size--;
                        node3 = node2.get();
                    }
                } else {
                    break;
                }
            }
            if (i3 != 0) {
                setFirst(node);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x003c, code lost:
        
            setFirst(r3);
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x003f, code lost:
        
            return;
         */
        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void truncateFinal() {
            long now = this.scheduler.now() - this.maxAgeInMillis;
            Node node = get();
            Node node2 = node.get();
            int i3 = 0;
            while (true) {
                Node node3 = node2;
                Node node4 = node;
                node = node3;
                if (node == null || this.size <= 1 || ((Timestamped) node.value).getTimestampMillis() > now) {
                    break;
                }
                i3++;
                this.size--;
                node2 = node.get();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SizeBoundReplayBuffer<T> extends BoundedReplayBuffer<T> {
        private static final long serialVersionUID = -5898283885385201806L;
        final int limit;

        public SizeBoundReplayBuffer(int i3) {
            this.limit = i3;
        }

        @Override // rx.internal.operators.OperatorReplay.BoundedReplayBuffer
        void truncate() {
            if (this.size > this.limit) {
                removeFirst();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class UnboundedReplayBuffer<T> extends ArrayList<Object> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 7063189396499112664L;

        /* renamed from: nl, reason: collision with root package name */
        final NotificationLite<T> f432679nl;
        volatile int size;

        public UnboundedReplayBuffer(int i3) {
            super(i3);
            this.f432679nl = NotificationLite.instance();
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public void complete() {
            add(this.f432679nl.completed());
            this.size++;
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public void error(Throwable th5) {
            add(this.f432679nl.error(th5));
            this.size++;
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public void next(T t16) {
            add(this.f432679nl.next(t16));
            this.size++;
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public void replay(InnerProducer<T> innerProducer) {
            int i3;
            synchronized (innerProducer) {
                if (innerProducer.emitting) {
                    innerProducer.missed = true;
                    return;
                }
                innerProducer.emitting = true;
                while (!innerProducer.isUnsubscribed()) {
                    int i16 = this.size;
                    Integer num = (Integer) innerProducer.index();
                    if (num != null) {
                        i3 = num.intValue();
                    } else {
                        i3 = 0;
                    }
                    long j3 = innerProducer.get();
                    long j16 = 0;
                    while (j16 != j3 && i3 < i16) {
                        Object obj = get(i3);
                        try {
                            if (this.f432679nl.accept(innerProducer.child, obj) || innerProducer.isUnsubscribed()) {
                                return;
                            }
                            i3++;
                            j16++;
                        } catch (Throwable th5) {
                            Exceptions.throwIfFatal(th5);
                            innerProducer.unsubscribe();
                            if (!this.f432679nl.isError(obj) && !this.f432679nl.isCompleted(obj)) {
                                innerProducer.child.onError(OnErrorThrowable.addValueAsLastCause(th5, this.f432679nl.getValue(obj)));
                                return;
                            }
                            return;
                        }
                    }
                    if (j16 != 0) {
                        innerProducer.index = Integer.valueOf(i3);
                        if (j3 != Long.MAX_VALUE) {
                            innerProducer.produced(j16);
                        }
                    }
                    synchronized (innerProducer) {
                        if (!innerProducer.missed) {
                            innerProducer.emitting = false;
                            return;
                        }
                        innerProducer.missed = false;
                    }
                }
            }
        }
    }

    OperatorReplay(Observable.OnSubscribe<T> onSubscribe, Observable<? extends T> observable, AtomicReference<ReplaySubscriber<T>> atomicReference, Func0<? extends ReplayBuffer<T>> func0) {
        super(onSubscribe);
        this.source = observable;
        this.current = atomicReference;
        this.bufferFactory = func0;
    }

    public static <T> ConnectableObservable<T> create(Observable<? extends T> observable) {
        return create(observable, DEFAULT_UNBOUNDED_FACTORY);
    }

    public static <T, U, R> Observable<R> multicastSelector(final Func0<? extends ConnectableObservable<U>> func0, final Func1<? super Observable<U>, ? extends Observable<R>> func1) {
        return Observable.create(new Observable.OnSubscribe<R>() { // from class: rx.internal.operators.OperatorReplay.2
            @Override // rx.functions.Action1
            public void call(final Subscriber<? super R> subscriber) {
                try {
                    ConnectableObservable connectableObservable = (ConnectableObservable) Func0.this.call();
                    ((Observable) func1.call(connectableObservable)).subscribe((Subscriber) subscriber);
                    connectableObservable.connect(new Action1<Subscription>() { // from class: rx.internal.operators.OperatorReplay.2.1
                        @Override // rx.functions.Action1
                        public void call(Subscription subscription) {
                            subscriber.add(subscription);
                        }
                    });
                } catch (Throwable th5) {
                    Exceptions.throwOrReport(th5, subscriber);
                }
            }
        });
    }

    public static <T> ConnectableObservable<T> observeOn(final ConnectableObservable<T> connectableObservable, Scheduler scheduler) {
        final Observable<T> observeOn = connectableObservable.observeOn(scheduler);
        return new ConnectableObservable<T>(new Observable.OnSubscribe<T>() { // from class: rx.internal.operators.OperatorReplay.3
            @Override // rx.functions.Action1
            public void call(final Subscriber<? super T> subscriber) {
                Observable.this.unsafeSubscribe(new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorReplay.3.1
                    @Override // rx.Observer
                    public void onCompleted() {
                        subscriber.onCompleted();
                    }

                    @Override // rx.Observer
                    public void onError(Throwable th5) {
                        subscriber.onError(th5);
                    }

                    @Override // rx.Observer
                    public void onNext(T t16) {
                        subscriber.onNext(t16);
                    }
                });
            }
        }) { // from class: rx.internal.operators.OperatorReplay.4
            @Override // rx.observables.ConnectableObservable
            public void connect(Action1<? super Subscription> action1) {
                connectableObservable.connect(action1);
            }
        };
    }

    @Override // rx.observables.ConnectableObservable
    public void connect(Action1<? super Subscription> action1) {
        ReplaySubscriber<T> replaySubscriber;
        while (true) {
            replaySubscriber = this.current.get();
            if (replaySubscriber != null && !replaySubscriber.isUnsubscribed()) {
                break;
            }
            ReplaySubscriber<T> replaySubscriber2 = new ReplaySubscriber<>(this.bufferFactory.call());
            replaySubscriber2.init();
            if (c.a(this.current, replaySubscriber, replaySubscriber2)) {
                replaySubscriber = replaySubscriber2;
                break;
            }
        }
        boolean z16 = false;
        if (!replaySubscriber.shouldConnect.get() && replaySubscriber.shouldConnect.compareAndSet(false, true)) {
            z16 = true;
        }
        action1.call(replaySubscriber);
        if (z16) {
            this.source.unsafeSubscribe(replaySubscriber);
        }
    }

    public static <T> ConnectableObservable<T> create(Observable<? extends T> observable, final int i3) {
        if (i3 == Integer.MAX_VALUE) {
            return create(observable);
        }
        return create(observable, new Func0<ReplayBuffer<T>>() { // from class: rx.internal.operators.OperatorReplay.5
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public ReplayBuffer<T> call() {
                return new SizeBoundReplayBuffer(i3);
            }
        });
    }

    public static <T> ConnectableObservable<T> create(Observable<? extends T> observable, long j3, TimeUnit timeUnit, Scheduler scheduler) {
        return create(observable, j3, timeUnit, scheduler, Integer.MAX_VALUE);
    }

    public static <T> ConnectableObservable<T> create(Observable<? extends T> observable, long j3, TimeUnit timeUnit, final Scheduler scheduler, final int i3) {
        final long millis = timeUnit.toMillis(j3);
        return create(observable, new Func0<ReplayBuffer<T>>() { // from class: rx.internal.operators.OperatorReplay.6
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public ReplayBuffer<T> call() {
                return new SizeAndTimeBoundReplayBuffer(i3, millis, scheduler);
            }
        });
    }

    static <T> ConnectableObservable<T> create(Observable<? extends T> observable, final Func0<? extends ReplayBuffer<T>> func0) {
        final AtomicReference atomicReference = new AtomicReference();
        return new OperatorReplay(new Observable.OnSubscribe<T>() { // from class: rx.internal.operators.OperatorReplay.7
            @Override // rx.functions.Action1
            public void call(Subscriber<? super T> subscriber) {
                ReplaySubscriber replaySubscriber;
                while (true) {
                    replaySubscriber = (ReplaySubscriber) atomicReference.get();
                    if (replaySubscriber != null) {
                        break;
                    }
                    ReplaySubscriber replaySubscriber2 = new ReplaySubscriber((ReplayBuffer) func0.call());
                    replaySubscriber2.init();
                    if (c.a(atomicReference, replaySubscriber, replaySubscriber2)) {
                        replaySubscriber = replaySubscriber2;
                        break;
                    }
                }
                InnerProducer<T> innerProducer = new InnerProducer<>(replaySubscriber, subscriber);
                replaySubscriber.add((InnerProducer) innerProducer);
                subscriber.add(innerProducer);
                replaySubscriber.buffer.replay(innerProducer);
                subscriber.setProducer(innerProducer);
            }
        }, observable, atomicReference, func0);
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static class BoundedReplayBuffer<T> extends AtomicReference<Node> implements ReplayBuffer<T> {
        private static final long serialVersionUID = 2346567790059478686L;
        long index;

        /* renamed from: nl, reason: collision with root package name */
        final NotificationLite<T> f432677nl = NotificationLite.instance();
        int size;
        Node tail;

        public BoundedReplayBuffer() {
            Node node = new Node(null, 0L);
            this.tail = node;
            set(node);
        }

        final void addLast(Node node) {
            this.tail.set(node);
            this.tail = node;
            this.size++;
        }

        final void collect(Collection<? super T> collection) {
            Node initialHead = getInitialHead();
            while (true) {
                initialHead = initialHead.get();
                if (initialHead != null) {
                    Object leaveTransform = leaveTransform(initialHead.value);
                    if (!this.f432677nl.isCompleted(leaveTransform) && !this.f432677nl.isError(leaveTransform)) {
                        collection.add(this.f432677nl.getValue(leaveTransform));
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public final void complete() {
            Object enterTransform = enterTransform(this.f432677nl.completed());
            long j3 = this.index + 1;
            this.index = j3;
            addLast(new Node(enterTransform, j3));
            truncateFinal();
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public final void error(Throwable th5) {
            Object enterTransform = enterTransform(this.f432677nl.error(th5));
            long j3 = this.index + 1;
            this.index = j3;
            addLast(new Node(enterTransform, j3));
            truncateFinal();
        }

        Node getInitialHead() {
            return get();
        }

        boolean hasCompleted() {
            Object obj = this.tail.value;
            if (obj != null && this.f432677nl.isCompleted(leaveTransform(obj))) {
                return true;
            }
            return false;
        }

        boolean hasError() {
            Object obj = this.tail.value;
            if (obj != null && this.f432677nl.isError(leaveTransform(obj))) {
                return true;
            }
            return false;
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public final void next(T t16) {
            Object enterTransform = enterTransform(this.f432677nl.next(t16));
            long j3 = this.index + 1;
            this.index = j3;
            addLast(new Node(enterTransform, j3));
            truncate();
        }

        final void removeFirst() {
            Node node = get().get();
            if (node != null) {
                this.size--;
                setFirst(node);
                return;
            }
            throw new IllegalStateException("Empty list!");
        }

        final void removeSome(int i3) {
            Node node = get();
            while (i3 > 0) {
                node = node.get();
                i3--;
                this.size--;
            }
            setFirst(node);
        }

        @Override // rx.internal.operators.OperatorReplay.ReplayBuffer
        public final void replay(InnerProducer<T> innerProducer) {
            Node node;
            synchronized (innerProducer) {
                if (innerProducer.emitting) {
                    innerProducer.missed = true;
                    return;
                }
                innerProducer.emitting = true;
                while (!innerProducer.isUnsubscribed()) {
                    Node node2 = (Node) innerProducer.index();
                    if (node2 == null) {
                        node2 = getInitialHead();
                        innerProducer.index = node2;
                        innerProducer.addTotalRequested(node2.index);
                    }
                    if (innerProducer.isUnsubscribed()) {
                        return;
                    }
                    long j3 = innerProducer.get();
                    long j16 = 0;
                    while (j16 != j3 && (node = node2.get()) != null) {
                        Object leaveTransform = leaveTransform(node.value);
                        try {
                            if (this.f432677nl.accept(innerProducer.child, leaveTransform)) {
                                innerProducer.index = null;
                                return;
                            }
                            j16++;
                            if (innerProducer.isUnsubscribed()) {
                                return;
                            } else {
                                node2 = node;
                            }
                        } catch (Throwable th5) {
                            innerProducer.index = null;
                            Exceptions.throwIfFatal(th5);
                            innerProducer.unsubscribe();
                            if (!this.f432677nl.isError(leaveTransform) && !this.f432677nl.isCompleted(leaveTransform)) {
                                innerProducer.child.onError(OnErrorThrowable.addValueAsLastCause(th5, this.f432677nl.getValue(leaveTransform)));
                                return;
                            }
                            return;
                        }
                    }
                    if (j16 != 0) {
                        innerProducer.index = node2;
                        if (j3 != Long.MAX_VALUE) {
                            innerProducer.produced(j16);
                        }
                    }
                    synchronized (innerProducer) {
                        if (!innerProducer.missed) {
                            innerProducer.emitting = false;
                            return;
                        }
                        innerProducer.missed = false;
                    }
                }
            }
        }

        final void setFirst(Node node) {
            set(node);
        }

        void truncate() {
        }

        void truncateFinal() {
        }

        Object enterTransform(Object obj) {
            return obj;
        }

        Object leaveTransform(Object obj) {
            return obj;
        }
    }
}
