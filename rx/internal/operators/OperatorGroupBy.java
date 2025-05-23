package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.internal.producers.ProducerArbiter;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.UtilityFunctions;
import rx.observables.GroupedObservable;
import rx.observers.Subscribers;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.Subscriptions;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorGroupBy<T, K, V> implements Observable.Operator<GroupedObservable<K, V>, T> {
    final int bufferSize;
    final boolean delayError;
    final Func1<? super T, ? extends K> keySelector;
    final Func1<Action1<K>, Map<K, Object>> mapFactory;
    final Func1<? super T, ? extends V> valueSelector;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class GroupByProducer implements Producer {
        final GroupBySubscriber<?, ?, ?> parent;

        public GroupByProducer(GroupBySubscriber<?, ?, ?> groupBySubscriber) {
            this.parent = groupBySubscriber;
        }

        @Override // rx.Producer
        public void request(long j3) {
            this.parent.requestMore(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class GroupedUnicast<K, T> extends GroupedObservable<K, T> {
        final State<T, K> state;

        protected GroupedUnicast(K k3, State<T, K> state) {
            super(k3, state);
            this.state = state;
        }

        public static <T, K> GroupedUnicast<K, T> createWith(K k3, int i3, GroupBySubscriber<?, K, T> groupBySubscriber, boolean z16) {
            return new GroupedUnicast<>(k3, new State(i3, groupBySubscriber, k3, z16));
        }

        public void onComplete() {
            this.state.onComplete();
        }

        public void onError(Throwable th5) {
            this.state.onError(th5);
        }

        public void onNext(T t16) {
            this.state.onNext(t16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class State<T, K> extends AtomicInteger implements Producer, Subscription, Observable.OnSubscribe<T> {
        private static final long serialVersionUID = -3852313036005250360L;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final K key;
        final GroupBySubscriber<?, K, T> parent;
        final Queue<Object> queue = new ConcurrentLinkedQueue();
        final AtomicBoolean cancelled = new AtomicBoolean();
        final AtomicReference<Subscriber<? super T>> actual = new AtomicReference<>();
        final AtomicBoolean once = new AtomicBoolean();
        final AtomicLong requested = new AtomicLong();

        public State(int i3, GroupBySubscriber<?, K, T> groupBySubscriber, K k3, boolean z16) {
            this.parent = groupBySubscriber;
            this.key = k3;
            this.delayError = z16;
        }

        boolean checkTerminated(boolean z16, boolean z17, Subscriber<? super T> subscriber, boolean z18) {
            if (this.cancelled.get()) {
                this.queue.clear();
                this.parent.cancel(this.key);
                return true;
            }
            if (z16) {
                if (z18) {
                    if (z17) {
                        Throwable th5 = this.error;
                        if (th5 != null) {
                            subscriber.onError(th5);
                        } else {
                            subscriber.onCompleted();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th6 = this.error;
                if (th6 != null) {
                    this.queue.clear();
                    subscriber.onError(th6);
                    return true;
                }
                if (z17) {
                    subscriber.onCompleted();
                    return true;
                }
                return false;
            }
            return false;
        }

        void drain() {
            boolean z16;
            if (getAndIncrement() != 0) {
                return;
            }
            Queue<Object> queue = this.queue;
            boolean z17 = this.delayError;
            Subscriber<? super T> subscriber = this.actual.get();
            NotificationLite instance = NotificationLite.instance();
            int i3 = 1;
            while (true) {
                if (subscriber != null) {
                    if (checkTerminated(this.done, queue.isEmpty(), subscriber, z17)) {
                        return;
                    }
                    long j3 = this.requested.get();
                    long j16 = 0;
                    while (j16 != j3) {
                        boolean z18 = this.done;
                        Object poll = queue.poll();
                        if (poll == null) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (checkTerminated(z18, z16, subscriber, z17)) {
                            return;
                        }
                        if (z16) {
                            break;
                        }
                        subscriber.onNext((Object) instance.getValue(poll));
                        j16++;
                    }
                    if (j16 != 0) {
                        if (j3 != Long.MAX_VALUE) {
                            BackpressureUtils.produced(this.requested, j16);
                        }
                        this.parent.f432671s.request(j16);
                    }
                }
                i3 = addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
                if (subscriber == null) {
                    subscriber = this.actual.get();
                }
            }
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.cancelled.get();
        }

        public void onComplete() {
            this.done = true;
            drain();
        }

        public void onError(Throwable th5) {
            this.error = th5;
            this.done = true;
            drain();
        }

        public void onNext(T t16) {
            if (t16 == null) {
                this.error = new NullPointerException();
                this.done = true;
            } else {
                this.queue.offer(NotificationLite.instance().next(t16));
            }
            drain();
        }

        @Override // rx.Producer
        public void request(long j3) {
            if (j3 >= 0) {
                if (j3 != 0) {
                    BackpressureUtils.getAndAddRequest(this.requested, j3);
                    drain();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("n >= required but it was " + j3);
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (this.cancelled.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.parent.cancel(this.key);
            }
        }

        @Override // rx.functions.Action1
        public void call(Subscriber<? super T> subscriber) {
            if (this.once.compareAndSet(false, true)) {
                subscriber.add(this);
                subscriber.setProducer(this);
                this.actual.lazySet(subscriber);
                drain();
                return;
            }
            subscriber.onError(new IllegalStateException("Only one Subscriber allowed!"));
        }
    }

    public OperatorGroupBy(Func1<? super T, ? extends K> func1) {
        this(func1, UtilityFunctions.identity(), RxRingBuffer.SIZE, false, null);
    }

    public OperatorGroupBy(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12) {
        this(func1, func12, RxRingBuffer.SIZE, false, null);
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super GroupedObservable<K, V>> subscriber) {
        try {
            final GroupBySubscriber groupBySubscriber = new GroupBySubscriber(subscriber, this.keySelector, this.valueSelector, this.bufferSize, this.delayError, this.mapFactory);
            subscriber.add(Subscriptions.create(new Action0() { // from class: rx.internal.operators.OperatorGroupBy.1
                @Override // rx.functions.Action0
                public void call() {
                    groupBySubscriber.cancel();
                }
            }));
            subscriber.setProducer(groupBySubscriber.producer);
            return groupBySubscriber;
        } catch (Throwable th5) {
            Exceptions.throwOrReport(th5, subscriber);
            Subscriber<? super T> empty = Subscribers.empty();
            empty.unsubscribe();
            return empty;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class GroupBySubscriber<T, K, V> extends Subscriber<T> {
        static final Object NULL_KEY = new Object();
        final Subscriber<? super GroupedObservable<K, V>> actual;
        final int bufferSize;
        final AtomicBoolean cancelled;
        final boolean delayError;
        volatile boolean done;
        Throwable error;
        final Queue<K> evictedKeys;
        final AtomicInteger groupCount;
        final Map<Object, GroupedUnicast<K, V>> groups;
        final Func1<? super T, ? extends K> keySelector;
        final GroupByProducer producer;
        final Queue<GroupedObservable<K, V>> queue = new ConcurrentLinkedQueue();
        final AtomicLong requested;

        /* renamed from: s, reason: collision with root package name */
        final ProducerArbiter f432671s;
        final Func1<? super T, ? extends V> valueSelector;
        final AtomicInteger wip;

        /* compiled from: P */
        /* loaded from: classes29.dex */
        static class EvictionAction<K> implements Action1<K> {
            final Queue<K> evictedKeys;

            EvictionAction(Queue<K> queue) {
                this.evictedKeys = queue;
            }

            @Override // rx.functions.Action1
            public void call(K k3) {
                this.evictedKeys.offer(k3);
            }
        }

        public GroupBySubscriber(Subscriber<? super GroupedObservable<K, V>> subscriber, Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, int i3, boolean z16, Func1<Action1<K>, Map<K, Object>> func13) {
            this.actual = subscriber;
            this.keySelector = func1;
            this.valueSelector = func12;
            this.bufferSize = i3;
            this.delayError = z16;
            ProducerArbiter producerArbiter = new ProducerArbiter();
            this.f432671s = producerArbiter;
            producerArbiter.request(i3);
            this.producer = new GroupByProducer(this);
            this.cancelled = new AtomicBoolean();
            this.requested = new AtomicLong();
            this.groupCount = new AtomicInteger(1);
            this.wip = new AtomicInteger();
            if (func13 == null) {
                this.groups = new ConcurrentHashMap();
                this.evictedKeys = null;
            } else {
                ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
                this.evictedKeys = concurrentLinkedQueue;
                this.groups = createMap(func13, new EvictionAction(concurrentLinkedQueue));
            }
        }

        private Map<Object, GroupedUnicast<K, V>> createMap(Func1<Action1<K>, Map<K, Object>> func1, Action1<K> action1) {
            return func1.call(action1);
        }

        public void cancel() {
            if (this.cancelled.compareAndSet(false, true) && this.groupCount.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        boolean checkTerminated(boolean z16, boolean z17, Subscriber<? super GroupedObservable<K, V>> subscriber, Queue<?> queue) {
            if (z16) {
                Throwable th5 = this.error;
                if (th5 != null) {
                    errorAll(subscriber, queue, th5);
                    return true;
                }
                if (z17) {
                    this.actual.onCompleted();
                    return true;
                }
                return false;
            }
            return false;
        }

        void drain() {
            boolean z16;
            if (this.wip.getAndIncrement() != 0) {
                return;
            }
            Queue<GroupedObservable<K, V>> queue = this.queue;
            Subscriber<? super GroupedObservable<K, V>> subscriber = this.actual;
            int i3 = 1;
            while (!checkTerminated(this.done, queue.isEmpty(), subscriber, queue)) {
                long j3 = this.requested.get();
                long j16 = 0;
                while (j16 != j3) {
                    boolean z17 = this.done;
                    GroupedObservable<K, V> poll = queue.poll();
                    if (poll == null) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (checkTerminated(z17, z16, subscriber, queue)) {
                        return;
                    }
                    if (z16) {
                        break;
                    }
                    subscriber.onNext(poll);
                    j16++;
                }
                if (j16 != 0) {
                    if (j3 != Long.MAX_VALUE) {
                        BackpressureUtils.produced(this.requested, j16);
                    }
                    this.f432671s.request(j16);
                }
                i3 = this.wip.addAndGet(-i3);
                if (i3 == 0) {
                    return;
                }
            }
        }

        void errorAll(Subscriber<? super GroupedObservable<K, V>> subscriber, Queue<?> queue, Throwable th5) {
            queue.clear();
            ArrayList arrayList = new ArrayList(this.groups.values());
            this.groups.clear();
            Queue<K> queue2 = this.evictedKeys;
            if (queue2 != null) {
                queue2.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((GroupedUnicast) it.next()).onError(th5);
            }
            subscriber.onError(th5);
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (this.done) {
                return;
            }
            Iterator<GroupedUnicast<K, V>> it = this.groups.values().iterator();
            while (it.hasNext()) {
                it.next().onComplete();
            }
            this.groups.clear();
            Queue<K> queue = this.evictedKeys;
            if (queue != null) {
                queue.clear();
            }
            this.done = true;
            this.groupCount.decrementAndGet();
            drain();
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            if (this.done) {
                RxJavaHooks.onError(th5);
                return;
            }
            this.error = th5;
            this.done = true;
            this.groupCount.decrementAndGet();
            drain();
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            Object obj;
            boolean z16;
            if (this.done) {
                return;
            }
            Queue<?> queue = this.queue;
            Subscriber<? super GroupedObservable<K, V>> subscriber = this.actual;
            try {
                K call = this.keySelector.call(t16);
                if (call != null) {
                    obj = call;
                } else {
                    obj = NULL_KEY;
                }
                GroupedUnicast<K, V> groupedUnicast = this.groups.get(obj);
                if (groupedUnicast == null) {
                    if (!this.cancelled.get()) {
                        groupedUnicast = GroupedUnicast.createWith(call, this.bufferSize, this, this.delayError);
                        this.groups.put(obj, groupedUnicast);
                        this.groupCount.getAndIncrement();
                        queue.offer(groupedUnicast);
                        drain();
                        z16 = false;
                    } else {
                        return;
                    }
                } else {
                    z16 = true;
                }
                try {
                    groupedUnicast.onNext(this.valueSelector.call(t16));
                    if (this.evictedKeys != null) {
                        while (true) {
                            K poll = this.evictedKeys.poll();
                            if (poll == null) {
                                break;
                            }
                            GroupedUnicast<K, V> groupedUnicast2 = this.groups.get(poll);
                            if (groupedUnicast2 != null) {
                                groupedUnicast2.onComplete();
                            }
                        }
                    }
                    if (z16) {
                        this.f432671s.request(1L);
                    }
                } catch (Throwable th5) {
                    unsubscribe();
                    errorAll(subscriber, queue, th5);
                }
            } catch (Throwable th6) {
                unsubscribe();
                errorAll(subscriber, queue, th6);
            }
        }

        public void requestMore(long j3) {
            if (j3 >= 0) {
                BackpressureUtils.getAndAddRequest(this.requested, j3);
                drain();
            } else {
                throw new IllegalArgumentException("n >= 0 required but it was " + j3);
            }
        }

        @Override // rx.Subscriber
        public void setProducer(Producer producer) {
            this.f432671s.setProducer(producer);
        }

        public void cancel(K k3) {
            if (k3 == null) {
                k3 = (K) NULL_KEY;
            }
            if (this.groups.remove(k3) == null || this.groupCount.decrementAndGet() != 0) {
                return;
            }
            unsubscribe();
        }
    }

    public OperatorGroupBy(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, Func1<Action1<K>, Map<K, Object>> func13) {
        this(func1, func12, RxRingBuffer.SIZE, false, func13);
    }

    public OperatorGroupBy(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, int i3, boolean z16, Func1<Action1<K>, Map<K, Object>> func13) {
        this.keySelector = func1;
        this.valueSelector = func12;
        this.bufferSize = i3;
        this.delayError = z16;
        this.mapFactory = func13;
    }
}
