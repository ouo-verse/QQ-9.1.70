package rx.observables;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.annotations.Experimental;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Action3;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func3;
import rx.internal.operators.BufferUntilSubscriber;
import rx.observers.SerializedObserver;
import rx.plugins.RxJavaHooks;
import rx.subscriptions.CompositeSubscription;

/* compiled from: P */
@Experimental
/* loaded from: classes29.dex */
public abstract class AsyncOnSubscribe<S, T> implements Observable.OnSubscribe<T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class AsyncOuterManager<S, T> implements Producer, Subscription, Observer<Observable<? extends T>> {
        Producer concatProducer;
        boolean emitting;
        long expectedDelivery;
        private boolean hasTerminated;
        private final UnicastSubject<Observable<T>> merger;
        private boolean onNextCalled;
        private final AsyncOnSubscribe<S, T> parent;
        List<Long> requests;
        private S state;
        final CompositeSubscription subscriptions = new CompositeSubscription();
        private final SerializedObserver<Observable<? extends T>> serializedSubscriber = new SerializedObserver<>(this);
        final AtomicBoolean isUnsubscribed = new AtomicBoolean();

        public AsyncOuterManager(AsyncOnSubscribe<S, T> asyncOnSubscribe, S s16, UnicastSubject<Observable<T>> unicastSubject) {
            this.parent = asyncOnSubscribe;
            this.state = s16;
            this.merger = unicastSubject;
        }

        private void handleThrownError(Throwable th5) {
            if (this.hasTerminated) {
                RxJavaHooks.onError(th5);
                return;
            }
            this.hasTerminated = true;
            this.merger.onError(th5);
            cleanup();
        }

        private void subscribeBufferToObservable(Observable<? extends T> observable) {
            BufferUntilSubscriber create = BufferUntilSubscriber.create();
            final Subscriber<T> subscriber = new Subscriber<T>(this.expectedDelivery, create) { // from class: rx.observables.AsyncOnSubscribe.AsyncOuterManager.1
                long remaining;
                final /* synthetic */ BufferUntilSubscriber val$buffer;
                final /* synthetic */ long val$expected;

                {
                    this.val$expected = r2;
                    this.val$buffer = create;
                    this.remaining = r2;
                }

                @Override // rx.Observer
                public void onCompleted() {
                    this.val$buffer.onCompleted();
                    long j3 = this.remaining;
                    if (j3 > 0) {
                        AsyncOuterManager.this.requestRemaining(j3);
                    }
                }

                @Override // rx.Observer
                public void onError(Throwable th5) {
                    this.val$buffer.onError(th5);
                }

                @Override // rx.Observer
                public void onNext(T t16) {
                    this.remaining--;
                    this.val$buffer.onNext(t16);
                }
            };
            this.subscriptions.add(subscriber);
            observable.doOnTerminate(new Action0() { // from class: rx.observables.AsyncOnSubscribe.AsyncOuterManager.2
                @Override // rx.functions.Action0
                public void call() {
                    AsyncOuterManager.this.subscriptions.remove(subscriber);
                }
            }).subscribe((Subscriber<? super Object>) subscriber);
            this.merger.onNext(create);
        }

        void cleanup() {
            this.subscriptions.unsubscribe();
            try {
                this.parent.onUnsubscribe(this.state);
            } catch (Throwable th5) {
                handleThrownError(th5);
            }
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            return this.isUnsubscribed.get();
        }

        public void nextIteration(long j3) {
            this.state = this.parent.next(this.state, j3, this.serializedSubscriber);
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.hasTerminated) {
                this.hasTerminated = true;
                this.merger.onCompleted();
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            if (!this.hasTerminated) {
                this.hasTerminated = true;
                this.merger.onError(th5);
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        @Override // rx.Producer
        public void request(long j3) {
            boolean z16;
            if (j3 == 0) {
                return;
            }
            if (j3 >= 0) {
                synchronized (this) {
                    z16 = true;
                    if (this.emitting) {
                        List list = this.requests;
                        if (list == null) {
                            list = new ArrayList();
                            this.requests = list;
                        }
                        list.add(Long.valueOf(j3));
                    } else {
                        this.emitting = true;
                        z16 = false;
                    }
                }
                this.concatProducer.request(j3);
                if (z16 || tryEmit(j3)) {
                    return;
                }
                while (true) {
                    synchronized (this) {
                        List<Long> list2 = this.requests;
                        if (list2 == null) {
                            this.emitting = false;
                            return;
                        }
                        this.requests = null;
                        Iterator<Long> it = list2.iterator();
                        while (it.hasNext()) {
                            if (tryEmit(it.next().longValue())) {
                                return;
                            }
                        }
                    }
                }
            } else {
                throw new IllegalStateException("Request can't be negative! " + j3);
            }
        }

        public void requestRemaining(long j3) {
            if (j3 == 0) {
                return;
            }
            if (j3 >= 0) {
                synchronized (this) {
                    if (this.emitting) {
                        List list = this.requests;
                        if (list == null) {
                            list = new ArrayList();
                            this.requests = list;
                        }
                        list.add(Long.valueOf(j3));
                        return;
                    }
                    this.emitting = true;
                    if (tryEmit(j3)) {
                        return;
                    }
                    while (true) {
                        synchronized (this) {
                            List<Long> list2 = this.requests;
                            if (list2 == null) {
                                this.emitting = false;
                                return;
                            }
                            this.requests = null;
                            Iterator<Long> it = list2.iterator();
                            while (it.hasNext()) {
                                if (tryEmit(it.next().longValue())) {
                                    return;
                                }
                            }
                        }
                    }
                }
            } else {
                throw new IllegalStateException("Request can't be negative! " + j3);
            }
        }

        void setConcatProducer(Producer producer) {
            if (this.concatProducer == null) {
                this.concatProducer = producer;
                return;
            }
            throw new IllegalStateException("setConcatProducer may be called at most once!");
        }

        boolean tryEmit(long j3) {
            if (isUnsubscribed()) {
                cleanup();
                return true;
            }
            try {
                this.onNextCalled = false;
                this.expectedDelivery = j3;
                nextIteration(j3);
                if (!this.hasTerminated && !isUnsubscribed()) {
                    if (this.onNextCalled) {
                        return false;
                    }
                    handleThrownError(new IllegalStateException("No events emitted!"));
                    return true;
                }
                cleanup();
                return true;
            } catch (Throwable th5) {
                handleThrownError(th5);
                return true;
            }
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            if (this.isUnsubscribed.compareAndSet(false, true)) {
                synchronized (this) {
                    if (this.emitting) {
                        ArrayList arrayList = new ArrayList();
                        this.requests = arrayList;
                        arrayList.add(0L);
                    } else {
                        this.emitting = true;
                        cleanup();
                    }
                }
            }
        }

        @Override // rx.Observer
        public void onNext(Observable<? extends T> observable) {
            if (!this.onNextCalled) {
                this.onNextCalled = true;
                if (this.hasTerminated) {
                    return;
                }
                subscribeBufferToObservable(observable);
                return;
            }
            throw new IllegalStateException("onNext called multiple times!");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class UnicastSubject<T> extends Observable<T> implements Observer<T> {
        private final State<T> state;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes29.dex */
        public static final class State<T> implements Observable.OnSubscribe<T> {
            Subscriber<? super T> subscriber;

            State() {
            }

            @Override // rx.functions.Action1
            public void call(Subscriber<? super T> subscriber) {
                synchronized (this) {
                    if (this.subscriber == null) {
                        this.subscriber = subscriber;
                    } else {
                        subscriber.onError(new IllegalStateException("There can be only one subscriber"));
                    }
                }
            }
        }

        protected UnicastSubject(State<T> state) {
            super(state);
            this.state = state;
        }

        public static <T> UnicastSubject<T> create() {
            return new UnicastSubject<>(new State());
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.state.subscriber.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            this.state.subscriber.onError(th5);
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            this.state.subscriber.onNext(t16);
        }
    }

    @Experimental
    public static <S, T> AsyncOnSubscribe<S, T> createSingleState(Func0<? extends S> func0, final Action3<? super S, Long, ? super Observer<Observable<? extends T>>> action3) {
        return new AsyncOnSubscribeImpl(func0, new Func3<S, Long, Observer<Observable<? extends T>>, S>() { // from class: rx.observables.AsyncOnSubscribe.1
            @Override // rx.functions.Func3
            public /* bridge */ /* synthetic */ Object call(Object obj, Long l3, Object obj2) {
                return call((AnonymousClass1) obj, l3, (Observer) obj2);
            }

            public S call(S s16, Long l3, Observer<Observable<? extends T>> observer) {
                Action3.this.call(s16, l3, observer);
                return s16;
            }
        });
    }

    @Experimental
    public static <S, T> AsyncOnSubscribe<S, T> createStateful(Func0<? extends S> func0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> func3, Action1<? super S> action1) {
        return new AsyncOnSubscribeImpl(func0, func3, action1);
    }

    @Experimental
    public static <T> AsyncOnSubscribe<Void, T> createStateless(final Action2<Long, ? super Observer<Observable<? extends T>>> action2) {
        return new AsyncOnSubscribeImpl(new Func3<Void, Long, Observer<Observable<? extends T>>, Void>() { // from class: rx.observables.AsyncOnSubscribe.3
            @Override // rx.functions.Func3
            public Void call(Void r26, Long l3, Observer<Observable<? extends T>> observer) {
                Action2.this.call(l3, observer);
                return r26;
            }
        });
    }

    protected abstract S generateState();

    protected abstract S next(S s16, long j3, Observer<Observable<? extends T>> observer);

    @Experimental
    public static <S, T> AsyncOnSubscribe<S, T> createStateful(Func0<? extends S> func0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> func3) {
        return new AsyncOnSubscribeImpl(func0, func3);
    }

    @Override // rx.functions.Action1
    public final void call(final Subscriber<? super T> subscriber) {
        try {
            S generateState = generateState();
            UnicastSubject create = UnicastSubject.create();
            final AsyncOuterManager asyncOuterManager = new AsyncOuterManager(this, generateState, create);
            Subscriber<T> subscriber2 = new Subscriber<T>() { // from class: rx.observables.AsyncOnSubscribe.6
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

                @Override // rx.Subscriber
                public void setProducer(Producer producer) {
                    asyncOuterManager.setConcatProducer(producer);
                }
            };
            create.onBackpressureBuffer().concatMap(new Func1<Observable<T>, Observable<T>>() { // from class: rx.observables.AsyncOnSubscribe.7
                @Override // rx.functions.Func1
                public Observable<T> call(Observable<T> observable) {
                    return observable.onBackpressureBuffer();
                }
            }).unsafeSubscribe(subscriber2);
            subscriber.add(subscriber2);
            subscriber.add(asyncOuterManager);
            subscriber.setProducer(asyncOuterManager);
        } catch (Throwable th5) {
            subscriber.onError(th5);
        }
    }

    @Experimental
    public static <S, T> AsyncOnSubscribe<S, T> createSingleState(Func0<? extends S> func0, final Action3<? super S, Long, ? super Observer<Observable<? extends T>>> action3, Action1<? super S> action1) {
        return new AsyncOnSubscribeImpl(func0, new Func3<S, Long, Observer<Observable<? extends T>>, S>() { // from class: rx.observables.AsyncOnSubscribe.2
            @Override // rx.functions.Func3
            public /* bridge */ /* synthetic */ Object call(Object obj, Long l3, Object obj2) {
                return call((AnonymousClass2) obj, l3, (Observer) obj2);
            }

            public S call(S s16, Long l3, Observer<Observable<? extends T>> observer) {
                Action3.this.call(s16, l3, observer);
                return s16;
            }
        }, action1);
    }

    @Experimental
    public static <T> AsyncOnSubscribe<Void, T> createStateless(final Action2<Long, ? super Observer<Observable<? extends T>>> action2, final Action0 action0) {
        return new AsyncOnSubscribeImpl(new Func3<Void, Long, Observer<Observable<? extends T>>, Void>() { // from class: rx.observables.AsyncOnSubscribe.4
            @Override // rx.functions.Func3
            public Void call(Void r16, Long l3, Observer<Observable<? extends T>> observer) {
                Action2.this.call(l3, observer);
                return null;
            }
        }, new Action1<Void>() { // from class: rx.observables.AsyncOnSubscribe.5
            @Override // rx.functions.Action1
            public void call(Void r16) {
                Action0.this.call();
            }
        });
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class AsyncOnSubscribeImpl<S, T> extends AsyncOnSubscribe<S, T> {
        private final Func0<? extends S> generator;
        private final Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> next;
        private final Action1<? super S> onUnsubscribe;

        AsyncOnSubscribeImpl(Func0<? extends S> func0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> func3, Action1<? super S> action1) {
            this.generator = func0;
            this.next = func3;
            this.onUnsubscribe = action1;
        }

        @Override // rx.observables.AsyncOnSubscribe, rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            super.call((Subscriber) obj);
        }

        @Override // rx.observables.AsyncOnSubscribe
        protected S generateState() {
            Func0<? extends S> func0 = this.generator;
            if (func0 == null) {
                return null;
            }
            return func0.call();
        }

        @Override // rx.observables.AsyncOnSubscribe
        protected S next(S s16, long j3, Observer<Observable<? extends T>> observer) {
            return this.next.call(s16, Long.valueOf(j3), observer);
        }

        @Override // rx.observables.AsyncOnSubscribe
        protected void onUnsubscribe(S s16) {
            Action1<? super S> action1 = this.onUnsubscribe;
            if (action1 != null) {
                action1.call(s16);
            }
        }

        public AsyncOnSubscribeImpl(Func0<? extends S> func0, Func3<? super S, Long, ? super Observer<Observable<? extends T>>, ? extends S> func3) {
            this(func0, func3, null);
        }

        public AsyncOnSubscribeImpl(Func3<S, Long, Observer<Observable<? extends T>>, S> func3, Action1<? super S> action1) {
            this(null, func3, action1);
        }

        public AsyncOnSubscribeImpl(Func3<S, Long, Observer<Observable<? extends T>>, S> func3) {
            this(null, func3, null);
        }
    }

    protected void onUnsubscribe(S s16) {
    }
}
