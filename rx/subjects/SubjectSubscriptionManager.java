package rx.subjects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Actions;
import rx.internal.operators.NotificationLite;
import rx.subscriptions.Subscriptions;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubjectSubscriptionManager<T> extends AtomicReference<State<T>> implements Observable.OnSubscribe<T> {
    private static final long serialVersionUID = 6035251036011671568L;
    boolean active;
    volatile Object latest;

    /* renamed from: nl, reason: collision with root package name */
    public final NotificationLite<T> f432881nl;
    Action1<SubjectObserver<T>> onAdded;
    Action1<SubjectObserver<T>> onStart;
    Action1<SubjectObserver<T>> onTerminated;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class State<T> {
        static final State EMPTY;
        static final SubjectObserver[] NO_OBSERVERS;
        static final State TERMINATED;
        final SubjectObserver[] observers;
        final boolean terminated;

        static {
            SubjectObserver[] subjectObserverArr = new SubjectObserver[0];
            NO_OBSERVERS = subjectObserverArr;
            TERMINATED = new State(true, subjectObserverArr);
            EMPTY = new State(false, subjectObserverArr);
        }

        public State(boolean z16, SubjectObserver[] subjectObserverArr) {
            this.terminated = z16;
            this.observers = subjectObserverArr;
        }

        public State add(SubjectObserver subjectObserver) {
            SubjectObserver[] subjectObserverArr = this.observers;
            int length = subjectObserverArr.length;
            SubjectObserver[] subjectObserverArr2 = new SubjectObserver[length + 1];
            System.arraycopy(subjectObserverArr, 0, subjectObserverArr2, 0, length);
            subjectObserverArr2[length] = subjectObserver;
            return new State(this.terminated, subjectObserverArr2);
        }

        public State remove(SubjectObserver subjectObserver) {
            SubjectObserver[] subjectObserverArr = this.observers;
            int length = subjectObserverArr.length;
            if (length == 1 && subjectObserverArr[0] == subjectObserver) {
                return EMPTY;
            }
            if (length == 0) {
                return this;
            }
            int i3 = length - 1;
            SubjectObserver[] subjectObserverArr2 = new SubjectObserver[i3];
            int i16 = 0;
            for (SubjectObserver subjectObserver2 : subjectObserverArr) {
                if (subjectObserver2 != subjectObserver) {
                    if (i16 == i3) {
                        return this;
                    }
                    subjectObserverArr2[i16] = subjectObserver2;
                    i16++;
                }
            }
            if (i16 == 0) {
                return EMPTY;
            }
            if (i16 < i3) {
                SubjectObserver[] subjectObserverArr3 = new SubjectObserver[i16];
                System.arraycopy(subjectObserverArr2, 0, subjectObserverArr3, 0, i16);
                subjectObserverArr2 = subjectObserverArr3;
            }
            return new State(this.terminated, subjectObserverArr2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SubjectObserver<T> implements Observer<T> {
        final Subscriber<? super T> actual;
        volatile boolean caughtUp;
        boolean emitting;
        boolean fastPath;
        boolean first = true;
        private volatile Object index;
        List<Object> queue;

        public SubjectObserver(Subscriber<? super T> subscriber) {
            this.actual = subscriber;
        }

        void accept(Object obj, NotificationLite<T> notificationLite) {
            if (obj != null) {
                notificationLite.accept(this.actual, obj);
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void emitFirst(Object obj, NotificationLite<T> notificationLite) {
            synchronized (this) {
                if (this.first && !this.emitting) {
                    boolean z16 = false;
                    this.first = false;
                    if (obj != null) {
                        z16 = true;
                    }
                    this.emitting = z16;
                    if (obj != null) {
                        emitLoop(null, obj, notificationLite);
                    }
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0038  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void emitLoop(List<Object> list, Object obj, NotificationLite<T> notificationLite) {
            boolean z16 = true;
            boolean z17 = true;
            while (true) {
                if (list != null) {
                    try {
                        Iterator<Object> it = list.iterator();
                        while (it.hasNext()) {
                            accept(it.next(), notificationLite);
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        z16 = false;
                        if (!z16) {
                        }
                        throw th;
                    }
                }
                if (z17) {
                    accept(obj, notificationLite);
                    z17 = false;
                }
                try {
                    synchronized (this) {
                        try {
                            list = this.queue;
                            this.queue = null;
                            if (list == null) {
                                this.emitting = false;
                                return;
                            }
                        } catch (Throwable th6) {
                            th = th6;
                            z16 = false;
                        }
                    }
                } catch (Throwable th7) {
                    th = th7;
                }
                try {
                    throw th;
                } catch (Throwable th8) {
                    th = th8;
                    if (!z16) {
                        synchronized (this) {
                            this.emitting = false;
                        }
                    }
                    throw th;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void emitNext(Object obj, NotificationLite<T> notificationLite) {
            if (!this.fastPath) {
                synchronized (this) {
                    this.first = false;
                    if (this.emitting) {
                        if (this.queue == null) {
                            this.queue = new ArrayList();
                        }
                        this.queue.add(obj);
                        return;
                    }
                    this.fastPath = true;
                }
            }
            notificationLite.accept(this.actual, obj);
        }

        Observer<? super T> getActual() {
            return this.actual;
        }

        public <I> I index() {
            return (I) this.index;
        }

        @Override // rx.Observer
        public void onCompleted() {
            this.actual.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            this.actual.onError(th5);
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            this.actual.onNext(t16);
        }

        public void index(Object obj) {
            this.index = obj;
        }
    }

    public SubjectSubscriptionManager() {
        super(State.EMPTY);
        this.active = true;
        this.onStart = Actions.empty();
        this.onAdded = Actions.empty();
        this.onTerminated = Actions.empty();
        this.f432881nl = NotificationLite.instance();
    }

    boolean add(SubjectObserver<T> subjectObserver) {
        State<T> state;
        do {
            state = get();
            if (state.terminated) {
                this.onTerminated.call(subjectObserver);
                return false;
            }
        } while (!compareAndSet(state, state.add(subjectObserver)));
        this.onAdded.call(subjectObserver);
        return true;
    }

    void addUnsubscriber(Subscriber<? super T> subscriber, final SubjectObserver<T> subjectObserver) {
        subscriber.add(Subscriptions.create(new Action0() { // from class: rx.subjects.SubjectSubscriptionManager.1
            @Override // rx.functions.Action0
            public void call() {
                SubjectSubscriptionManager.this.remove(subjectObserver);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object getLatest() {
        return this.latest;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SubjectObserver<T>[] next(Object obj) {
        setLatest(obj);
        return get().observers;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SubjectObserver<T>[] observers() {
        return get().observers;
    }

    void remove(SubjectObserver<T> subjectObserver) {
        State<T> state;
        State<T> remove;
        do {
            state = get();
            if (state.terminated || (remove = state.remove(subjectObserver)) == state) {
                return;
            }
        } while (!compareAndSet(state, remove));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLatest(Object obj) {
        this.latest = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SubjectObserver<T>[] terminate(Object obj) {
        setLatest(obj);
        this.active = false;
        if (get().terminated) {
            return State.NO_OBSERVERS;
        }
        return getAndSet(State.TERMINATED).observers;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super T> subscriber) {
        SubjectObserver<T> subjectObserver = new SubjectObserver<>(subscriber);
        addUnsubscriber(subscriber, subjectObserver);
        this.onStart.call(subjectObserver);
        if (!subscriber.isUnsubscribed() && add(subjectObserver) && subscriber.isUnsubscribed()) {
            remove(subjectObserver);
        }
    }
}
