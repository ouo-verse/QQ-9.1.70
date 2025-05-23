package rx.internal.util;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.producers.SingleProducer;
import rx.internal.schedulers.EventLoopsScheduler;
import rx.observers.Subscribers;
import rx.plugins.RxJavaHooks;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ScalarSynchronousObservable<T> extends Observable<T> {
    static final boolean STRONG_MODE = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();

    /* renamed from: t, reason: collision with root package name */
    final T f432690t;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class JustOnSubscribe<T> implements Observable.OnSubscribe<T> {
        final T value;

        JustOnSubscribe(T t16) {
            this.value = t16;
        }

        @Override // rx.functions.Action1
        public void call(Subscriber<? super T> subscriber) {
            subscriber.setProducer(ScalarSynchronousObservable.createProducer(subscriber, this.value));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ScalarAsyncOnSubscribe<T> implements Observable.OnSubscribe<T> {
        final Func1<Action0, Subscription> onSchedule;
        final T value;

        ScalarAsyncOnSubscribe(T t16, Func1<Action0, Subscription> func1) {
            this.value = t16;
            this.onSchedule = func1;
        }

        @Override // rx.functions.Action1
        public void call(Subscriber<? super T> subscriber) {
            subscriber.setProducer(new ScalarAsyncProducer(subscriber, this.value, this.onSchedule));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ScalarAsyncProducer<T> extends AtomicBoolean implements Producer, Action0 {
        private static final long serialVersionUID = -2466317989629281651L;
        final Subscriber<? super T> actual;
        final Func1<Action0, Subscription> onSchedule;
        final T value;

        public ScalarAsyncProducer(Subscriber<? super T> subscriber, T t16, Func1<Action0, Subscription> func1) {
            this.actual = subscriber;
            this.value = t16;
            this.onSchedule = func1;
        }

        @Override // rx.functions.Action0
        public void call() {
            Subscriber<? super T> subscriber = this.actual;
            if (subscriber.isUnsubscribed()) {
                return;
            }
            T t16 = this.value;
            try {
                subscriber.onNext(t16);
                if (subscriber.isUnsubscribed()) {
                    return;
                }
                subscriber.onCompleted();
            } catch (Throwable th5) {
                Exceptions.throwOrReport(th5, subscriber, t16);
            }
        }

        @Override // rx.Producer
        public void request(long j3) {
            if (j3 >= 0) {
                if (j3 != 0 && compareAndSet(false, true)) {
                    this.actual.add(this.onSchedule.call(this));
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j3);
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.value + ", " + get() + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class WeakSingleProducer<T> implements Producer {
        final Subscriber<? super T> actual;
        boolean once;
        final T value;

        public WeakSingleProducer(Subscriber<? super T> subscriber, T t16) {
            this.actual = subscriber;
            this.value = t16;
        }

        @Override // rx.Producer
        public void request(long j3) {
            if (this.once) {
                return;
            }
            if (j3 >= 0) {
                if (j3 == 0) {
                    return;
                }
                this.once = true;
                Subscriber<? super T> subscriber = this.actual;
                if (subscriber.isUnsubscribed()) {
                    return;
                }
                T t16 = this.value;
                try {
                    subscriber.onNext(t16);
                    if (subscriber.isUnsubscribed()) {
                        return;
                    }
                    subscriber.onCompleted();
                    return;
                } catch (Throwable th5) {
                    Exceptions.throwOrReport(th5, subscriber, t16);
                    return;
                }
            }
            throw new IllegalStateException("n >= required but it was " + j3);
        }
    }

    protected ScalarSynchronousObservable(T t16) {
        super(RxJavaHooks.onCreate(new JustOnSubscribe(t16)));
        this.f432690t = t16;
    }

    public static <T> ScalarSynchronousObservable<T> create(T t16) {
        return new ScalarSynchronousObservable<>(t16);
    }

    static <T> Producer createProducer(Subscriber<? super T> subscriber, T t16) {
        if (STRONG_MODE) {
            return new SingleProducer(subscriber, t16);
        }
        return new WeakSingleProducer(subscriber, t16);
    }

    public T get() {
        return this.f432690t;
    }

    public <R> Observable<R> scalarFlatMap(final Func1<? super T, ? extends Observable<? extends R>> func1) {
        return Observable.create(new Observable.OnSubscribe<R>() { // from class: rx.internal.util.ScalarSynchronousObservable.3
            @Override // rx.functions.Action1
            public void call(Subscriber<? super R> subscriber) {
                Observable observable = (Observable) func1.call(ScalarSynchronousObservable.this.f432690t);
                if (observable instanceof ScalarSynchronousObservable) {
                    subscriber.setProducer(ScalarSynchronousObservable.createProducer(subscriber, ((ScalarSynchronousObservable) observable).f432690t));
                } else {
                    observable.unsafeSubscribe(Subscribers.wrap(subscriber));
                }
            }
        });
    }

    public Observable<T> scalarScheduleOn(final Scheduler scheduler) {
        Func1<Action0, Subscription> func1;
        if (scheduler instanceof EventLoopsScheduler) {
            final EventLoopsScheduler eventLoopsScheduler = (EventLoopsScheduler) scheduler;
            func1 = new Func1<Action0, Subscription>() { // from class: rx.internal.util.ScalarSynchronousObservable.1
                @Override // rx.functions.Func1
                public Subscription call(Action0 action0) {
                    return eventLoopsScheduler.scheduleDirect(action0);
                }
            };
        } else {
            func1 = new Func1<Action0, Subscription>() { // from class: rx.internal.util.ScalarSynchronousObservable.2
                @Override // rx.functions.Func1
                public Subscription call(final Action0 action0) {
                    final Scheduler.Worker createWorker = scheduler.createWorker();
                    createWorker.schedule(new Action0() { // from class: rx.internal.util.ScalarSynchronousObservable.2.1
                        @Override // rx.functions.Action0
                        public void call() {
                            try {
                                action0.call();
                            } finally {
                                createWorker.unsubscribe();
                            }
                        }
                    });
                    return createWorker;
                }
            };
        }
        return Observable.create(new ScalarAsyncOnSubscribe(this.f432690t, func1));
    }
}
