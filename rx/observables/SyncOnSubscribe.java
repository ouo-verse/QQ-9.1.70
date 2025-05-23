package rx.observables;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.annotations.Beta;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Func0;
import rx.functions.Func2;
import rx.internal.operators.BackpressureUtils;
import rx.plugins.RxJavaHooks;

/* compiled from: P */
@Beta
/* loaded from: classes29.dex */
public abstract class SyncOnSubscribe<S, T> implements Observable.OnSubscribe<T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SubscriptionProducer<S, T> extends AtomicLong implements Producer, Subscription, Observer<T> {
        private static final long serialVersionUID = -3736864024352728072L;
        private final Subscriber<? super T> actualSubscriber;
        private boolean hasTerminated;
        private boolean onNextCalled;
        private final SyncOnSubscribe<S, T> parent;
        private S state;

        SubscriptionProducer(Subscriber<? super T> subscriber, SyncOnSubscribe<S, T> syncOnSubscribe, S s16) {
            this.actualSubscriber = subscriber;
            this.parent = syncOnSubscribe;
            this.state = s16;
        }

        private void doUnsubscribe() {
            try {
                this.parent.onUnsubscribe(this.state);
            } catch (Throwable th5) {
                Exceptions.throwIfFatal(th5);
                RxJavaHooks.onError(th5);
            }
        }

        private void fastpath() {
            SyncOnSubscribe<S, T> syncOnSubscribe = this.parent;
            Subscriber<? super T> subscriber = this.actualSubscriber;
            do {
                try {
                    this.onNextCalled = false;
                    nextIteration(syncOnSubscribe);
                } catch (Throwable th5) {
                    handleThrownError(subscriber, th5);
                    return;
                }
            } while (!tryUnsubscribe());
        }

        private void handleThrownError(Subscriber<? super T> subscriber, Throwable th5) {
            if (this.hasTerminated) {
                RxJavaHooks.onError(th5);
                return;
            }
            this.hasTerminated = true;
            subscriber.onError(th5);
            unsubscribe();
        }

        private void nextIteration(SyncOnSubscribe<S, T> syncOnSubscribe) {
            this.state = syncOnSubscribe.next(this.state, this);
        }

        private void slowPath(long j3) {
            SyncOnSubscribe<S, T> syncOnSubscribe = this.parent;
            Subscriber<? super T> subscriber = this.actualSubscriber;
            do {
                long j16 = j3;
                do {
                    try {
                        this.onNextCalled = false;
                        nextIteration(syncOnSubscribe);
                        if (tryUnsubscribe()) {
                            return;
                        }
                        if (this.onNextCalled) {
                            j16--;
                        }
                    } catch (Throwable th5) {
                        handleThrownError(subscriber, th5);
                        return;
                    }
                } while (j16 != 0);
                j3 = addAndGet(-j3);
            } while (j3 > 0);
            tryUnsubscribe();
        }

        private boolean tryUnsubscribe() {
            if (!this.hasTerminated && get() >= -1) {
                return false;
            }
            set(-1L);
            doUnsubscribe();
            return true;
        }

        @Override // rx.Subscription
        public boolean isUnsubscribed() {
            if (get() < 0) {
                return true;
            }
            return false;
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.hasTerminated) {
                this.hasTerminated = true;
                if (!this.actualSubscriber.isUnsubscribed()) {
                    this.actualSubscriber.onCompleted();
                    return;
                }
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            if (!this.hasTerminated) {
                this.hasTerminated = true;
                if (!this.actualSubscriber.isUnsubscribed()) {
                    this.actualSubscriber.onError(th5);
                    return;
                }
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            if (!this.onNextCalled) {
                this.onNextCalled = true;
                this.actualSubscriber.onNext(t16);
                return;
            }
            throw new IllegalStateException("onNext called multiple times!");
        }

        @Override // rx.Producer
        public void request(long j3) {
            if (j3 > 0 && BackpressureUtils.getAndAddRequest(this, j3) == 0) {
                if (j3 == Long.MAX_VALUE) {
                    fastpath();
                } else {
                    slowPath(j3);
                }
            }
        }

        @Override // rx.Subscription
        public void unsubscribe() {
            long j3;
            do {
                j3 = get();
                if (compareAndSet(0L, -1L)) {
                    doUnsubscribe();
                    return;
                }
            } while (!compareAndSet(j3, -2L));
        }
    }

    @Beta
    public static <S, T> SyncOnSubscribe<S, T> createSingleState(Func0<? extends S> func0, final Action2<? super S, ? super Observer<? super T>> action2) {
        return new SyncOnSubscribeImpl(func0, new Func2<S, Observer<? super T>, S>() { // from class: rx.observables.SyncOnSubscribe.1
            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2) {
                return call((AnonymousClass1) obj, (Observer) obj2);
            }

            public S call(S s16, Observer<? super T> observer) {
                Action2.this.call(s16, observer);
                return s16;
            }
        });
    }

    @Beta
    public static <S, T> SyncOnSubscribe<S, T> createStateful(Func0<? extends S> func0, Func2<? super S, ? super Observer<? super T>, ? extends S> func2, Action1<? super S> action1) {
        return new SyncOnSubscribeImpl(func0, func2, action1);
    }

    @Beta
    public static <T> SyncOnSubscribe<Void, T> createStateless(final Action1<? super Observer<? super T>> action1) {
        return new SyncOnSubscribeImpl(new Func2<Void, Observer<? super T>, Void>() { // from class: rx.observables.SyncOnSubscribe.3
            @Override // rx.functions.Func2
            public Void call(Void r26, Observer<? super T> observer) {
                Action1.this.call(observer);
                return r26;
            }
        });
    }

    protected abstract S generateState();

    protected abstract S next(S s16, Observer<? super T> observer);

    @Beta
    public static <S, T> SyncOnSubscribe<S, T> createStateful(Func0<? extends S> func0, Func2<? super S, ? super Observer<? super T>, ? extends S> func2) {
        return new SyncOnSubscribeImpl(func0, func2);
    }

    @Override // rx.functions.Action1
    public final void call(Subscriber<? super T> subscriber) {
        try {
            SubscriptionProducer subscriptionProducer = new SubscriptionProducer(subscriber, this, generateState());
            subscriber.add(subscriptionProducer);
            subscriber.setProducer(subscriptionProducer);
        } catch (Throwable th5) {
            Exceptions.throwIfFatal(th5);
            subscriber.onError(th5);
        }
    }

    @Beta
    public static <S, T> SyncOnSubscribe<S, T> createSingleState(Func0<? extends S> func0, final Action2<? super S, ? super Observer<? super T>> action2, Action1<? super S> action1) {
        return new SyncOnSubscribeImpl(func0, new Func2<S, Observer<? super T>, S>() { // from class: rx.observables.SyncOnSubscribe.2
            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2) {
                return call((AnonymousClass2) obj, (Observer) obj2);
            }

            public S call(S s16, Observer<? super T> observer) {
                Action2.this.call(s16, observer);
                return s16;
            }
        }, action1);
    }

    @Beta
    public static <T> SyncOnSubscribe<Void, T> createStateless(final Action1<? super Observer<? super T>> action1, final Action0 action0) {
        return new SyncOnSubscribeImpl(new Func2<Void, Observer<? super T>, Void>() { // from class: rx.observables.SyncOnSubscribe.4
            @Override // rx.functions.Func2
            public Void call(Void r16, Observer<? super T> observer) {
                Action1.this.call(observer);
                return null;
            }
        }, new Action1<Void>() { // from class: rx.observables.SyncOnSubscribe.5
            @Override // rx.functions.Action1
            public void call(Void r16) {
                Action0.this.call();
            }
        });
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class SyncOnSubscribeImpl<S, T> extends SyncOnSubscribe<S, T> {
        private final Func0<? extends S> generator;
        private final Func2<? super S, ? super Observer<? super T>, ? extends S> next;
        private final Action1<? super S> onUnsubscribe;

        SyncOnSubscribeImpl(Func0<? extends S> func0, Func2<? super S, ? super Observer<? super T>, ? extends S> func2, Action1<? super S> action1) {
            this.generator = func0;
            this.next = func2;
            this.onUnsubscribe = action1;
        }

        @Override // rx.observables.SyncOnSubscribe, rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            super.call((Subscriber) obj);
        }

        @Override // rx.observables.SyncOnSubscribe
        protected S generateState() {
            Func0<? extends S> func0 = this.generator;
            if (func0 == null) {
                return null;
            }
            return func0.call();
        }

        @Override // rx.observables.SyncOnSubscribe
        protected S next(S s16, Observer<? super T> observer) {
            return this.next.call(s16, observer);
        }

        @Override // rx.observables.SyncOnSubscribe
        protected void onUnsubscribe(S s16) {
            Action1<? super S> action1 = this.onUnsubscribe;
            if (action1 != null) {
                action1.call(s16);
            }
        }

        public SyncOnSubscribeImpl(Func0<? extends S> func0, Func2<? super S, ? super Observer<? super T>, ? extends S> func2) {
            this(func0, func2, null);
        }

        public SyncOnSubscribeImpl(Func2<S, Observer<? super T>, S> func2, Action1<? super S> action1) {
            this(null, func2, action1);
        }

        public SyncOnSubscribeImpl(Func2<S, Observer<? super T>, S> func2) {
            this(null, func2, null);
        }
    }

    protected void onUnsubscribe(S s16) {
    }
}
