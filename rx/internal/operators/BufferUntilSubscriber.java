package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subjects.Subject;
import rx.subscriptions.Subscriptions;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class BufferUntilSubscriber<T> extends Subject<T, T> {
    static final Observer EMPTY_OBSERVER = new Observer() { // from class: rx.internal.operators.BufferUntilSubscriber.1
        @Override // rx.Observer
        public void onCompleted() {
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
        }

        @Override // rx.Observer
        public void onNext(Object obj) {
        }
    };
    private boolean forward;
    final State<T> state;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    static final class OnSubscribeAction<T> implements Observable.OnSubscribe<T> {
        final State<T> state;

        public OnSubscribeAction(State<T> state) {
            this.state = state;
        }

        @Override // rx.functions.Action1
        public void call(Subscriber<? super T> subscriber) {
            boolean z16;
            if (this.state.casObserverRef(null, subscriber)) {
                subscriber.add(Subscriptions.create(new Action0() { // from class: rx.internal.operators.BufferUntilSubscriber.OnSubscribeAction.1
                    @Override // rx.functions.Action0
                    public void call() {
                        OnSubscribeAction.this.state.set(BufferUntilSubscriber.EMPTY_OBSERVER);
                    }
                }));
                synchronized (this.state.guard) {
                    State<T> state = this.state;
                    if (state.emitting) {
                        z16 = false;
                    } else {
                        z16 = true;
                        state.emitting = true;
                    }
                }
                if (!z16) {
                    return;
                }
                NotificationLite instance = NotificationLite.instance();
                while (true) {
                    Object poll = this.state.buffer.poll();
                    if (poll != null) {
                        instance.accept(this.state.get(), poll);
                    } else {
                        synchronized (this.state.guard) {
                            if (this.state.buffer.isEmpty()) {
                                this.state.emitting = false;
                                return;
                            }
                        }
                    }
                }
            } else {
                subscriber.onError(new IllegalStateException("Only one subscriber allowed!"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class State<T> extends AtomicReference<Observer<? super T>> {
        private static final long serialVersionUID = 8026705089538090368L;
        boolean emitting;
        final Object guard = new Object();
        final ConcurrentLinkedQueue<Object> buffer = new ConcurrentLinkedQueue<>();

        /* renamed from: nl, reason: collision with root package name */
        final NotificationLite<T> f432653nl = NotificationLite.instance();

        State() {
        }

        boolean casObserverRef(Observer<? super T> observer, Observer<? super T> observer2) {
            return compareAndSet(observer, observer2);
        }
    }

    BufferUntilSubscriber(State<T> state) {
        super(new OnSubscribeAction(state));
        this.state = state;
    }

    public static <T> BufferUntilSubscriber<T> create() {
        return new BufferUntilSubscriber<>(new State());
    }

    private void emit(Object obj) {
        synchronized (this.state.guard) {
            this.state.buffer.add(obj);
            if (this.state.get() != null) {
                State<T> state = this.state;
                if (!state.emitting) {
                    this.forward = true;
                    state.emitting = true;
                }
            }
        }
        if (!this.forward) {
            return;
        }
        while (true) {
            Object poll = this.state.buffer.poll();
            if (poll != null) {
                State<T> state2 = this.state;
                state2.f432653nl.accept(state2.get(), poll);
            } else {
                return;
            }
        }
    }

    @Override // rx.subjects.Subject
    public boolean hasObservers() {
        boolean z16;
        synchronized (this.state.guard) {
            if (this.state.get() != null) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        return z16;
    }

    @Override // rx.Observer
    public void onCompleted() {
        if (this.forward) {
            this.state.get().onCompleted();
        } else {
            emit(this.state.f432653nl.completed());
        }
    }

    @Override // rx.Observer
    public void onError(Throwable th5) {
        if (this.forward) {
            this.state.get().onError(th5);
        } else {
            emit(this.state.f432653nl.error(th5));
        }
    }

    @Override // rx.Observer
    public void onNext(T t16) {
        if (this.forward) {
            this.state.get().onNext(t16);
        } else {
            emit(this.state.f432653nl.next(t16));
        }
    }
}
