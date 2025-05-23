package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func0;
import rx.observers.SerializedSubscriber;
import rx.subjects.UnicastSubject;
import rx.subscriptions.SerialSubscription;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorWindowWithObservableFactory<T, U> implements Observable.Operator<Observable<T>, T> {
    static final Object NEXT_SUBJECT = new Object();
    static final NotificationLite<Object> NL = NotificationLite.instance();
    final Func0<? extends Observable<? extends U>> otherFactory;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class BoundarySubscriber<T, U> extends Subscriber<U> {
        boolean done;
        final SourceSubscriber<T, U> sub;

        public BoundarySubscriber(SourceSubscriber<T, U> sourceSubscriber) {
            this.sub = sourceSubscriber;
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.done) {
                this.done = true;
                this.sub.onCompleted();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            this.sub.onError(th5);
        }

        @Override // rx.Observer
        public void onNext(U u16) {
            if (!this.done) {
                this.done = true;
                this.sub.replaceWindow();
            }
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SourceSubscriber<T, U> extends Subscriber<T> {
        final Subscriber<? super Observable<T>> child;
        Observer<T> consumer;
        boolean emitting;
        final Object guard = new Object();
        final Func0<? extends Observable<? extends U>> otherFactory;
        Observable<T> producer;
        List<Object> queue;
        final SerialSubscription ssub;

        public SourceSubscriber(Subscriber<? super Observable<T>> subscriber, Func0<? extends Observable<? extends U>> func0) {
            this.child = new SerializedSubscriber(subscriber);
            SerialSubscription serialSubscription = new SerialSubscription();
            this.ssub = serialSubscription;
            this.otherFactory = func0;
            add(serialSubscription);
        }

        void complete() {
            Observer<T> observer = this.consumer;
            this.consumer = null;
            this.producer = null;
            if (observer != null) {
                observer.onCompleted();
            }
            this.child.onCompleted();
            unsubscribe();
        }

        void createNewWindow() {
            UnicastSubject create = UnicastSubject.create();
            this.consumer = create;
            this.producer = create;
            try {
                Observable<? extends U> call = this.otherFactory.call();
                BoundarySubscriber boundarySubscriber = new BoundarySubscriber(this);
                this.ssub.set(boundarySubscriber);
                call.unsafeSubscribe(boundarySubscriber);
            } catch (Throwable th5) {
                this.child.onError(th5);
                unsubscribe();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void drain(List<Object> list) {
            if (list == null) {
                return;
            }
            for (Object obj : list) {
                if (obj == OperatorWindowWithObservableFactory.NEXT_SUBJECT) {
                    replaceSubject();
                } else {
                    NotificationLite<Object> notificationLite = OperatorWindowWithObservableFactory.NL;
                    if (notificationLite.isError(obj)) {
                        error(notificationLite.getError(obj));
                        return;
                    } else {
                        if (notificationLite.isCompleted(obj)) {
                            complete();
                            return;
                        }
                        emitValue(obj);
                    }
                }
            }
        }

        void emitValue(T t16) {
            Observer<T> observer = this.consumer;
            if (observer != null) {
                observer.onNext(t16);
            }
        }

        void error(Throwable th5) {
            Observer<T> observer = this.consumer;
            this.consumer = null;
            this.producer = null;
            if (observer != null) {
                observer.onError(th5);
            }
            this.child.onError(th5);
            unsubscribe();
        }

        @Override // rx.Observer
        public void onCompleted() {
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.queue == null) {
                        this.queue = new ArrayList();
                    }
                    this.queue.add(OperatorWindowWithObservableFactory.NL.completed());
                    return;
                }
                List<Object> list = this.queue;
                this.queue = null;
                this.emitting = true;
                try {
                    drain(list);
                    complete();
                } catch (Throwable th5) {
                    error(th5);
                }
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            synchronized (this.guard) {
                if (this.emitting) {
                    this.queue = Collections.singletonList(OperatorWindowWithObservableFactory.NL.error(th5));
                    return;
                }
                this.queue = null;
                this.emitting = true;
                error(th5);
            }
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.queue == null) {
                        this.queue = new ArrayList();
                    }
                    this.queue.add(t16);
                    return;
                }
                List<Object> list = this.queue;
                this.queue = null;
                boolean z16 = true;
                this.emitting = true;
                boolean z17 = true;
                while (true) {
                    try {
                        drain(list);
                        if (z17) {
                            emitValue(t16);
                            z17 = false;
                        }
                        try {
                            synchronized (this.guard) {
                                try {
                                    List<Object> list2 = this.queue;
                                    this.queue = null;
                                    if (list2 == null) {
                                        this.emitting = false;
                                        return;
                                    } else {
                                        if (this.child.isUnsubscribed()) {
                                            synchronized (this.guard) {
                                                this.emitting = false;
                                            }
                                            return;
                                        }
                                        list = list2;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    z16 = false;
                                    try {
                                        throw th;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        if (!z16) {
                                            synchronized (this.guard) {
                                                this.emitting = false;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            }
                        } catch (Throwable th7) {
                            th = th7;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        z16 = false;
                    }
                }
            }
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        void replaceSubject() {
            Observer<T> observer = this.consumer;
            if (observer != null) {
                observer.onCompleted();
            }
            createNewWindow();
            this.child.onNext(this.producer);
        }

        void replaceWindow() {
            synchronized (this.guard) {
                if (this.emitting) {
                    if (this.queue == null) {
                        this.queue = new ArrayList();
                    }
                    this.queue.add(OperatorWindowWithObservableFactory.NEXT_SUBJECT);
                    return;
                }
                List<Object> list = this.queue;
                this.queue = null;
                boolean z16 = true;
                this.emitting = true;
                boolean z17 = true;
                while (true) {
                    try {
                        drain(list);
                        if (z17) {
                            replaceSubject();
                            z17 = false;
                        }
                        try {
                            synchronized (this.guard) {
                                try {
                                    List<Object> list2 = this.queue;
                                    this.queue = null;
                                    if (list2 == null) {
                                        this.emitting = false;
                                        return;
                                    } else {
                                        if (this.child.isUnsubscribed()) {
                                            synchronized (this.guard) {
                                                this.emitting = false;
                                            }
                                            return;
                                        }
                                        list = list2;
                                    }
                                } catch (Throwable th5) {
                                    th = th5;
                                    z16 = false;
                                    try {
                                        throw th;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        if (!z16) {
                                            synchronized (this.guard) {
                                                this.emitting = false;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            }
                        } catch (Throwable th7) {
                            th = th7;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                        z16 = false;
                    }
                }
            }
        }
    }

    public OperatorWindowWithObservableFactory(Func0<? extends Observable<? extends U>> func0) {
        this.otherFactory = func0;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super Observable<T>> subscriber) {
        SourceSubscriber sourceSubscriber = new SourceSubscriber(subscriber, this.otherFactory);
        subscriber.add(sourceSubscriber);
        sourceSubscriber.replaceWindow();
        return sourceSubscriber;
    }
}
