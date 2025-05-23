package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func1;
import rx.observers.SerializedObserver;
import rx.observers.SerializedSubscriber;
import rx.subjects.UnicastSubject;
import rx.subscriptions.CompositeSubscription;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorWindowWithStartEndObservable<T, U, V> implements Observable.Operator<Observable<T>, T> {
    final Func1<? super U, ? extends Observable<? extends V>> windowClosingSelector;
    final Observable<? extends U> windowOpenings;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class SerializedSubject<T> {
        final Observer<T> consumer;
        final Observable<T> producer;

        public SerializedSubject(Observer<T> observer, Observable<T> observable) {
            this.consumer = new SerializedObserver(observer);
            this.producer = observable;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public final class SourceSubscriber extends Subscriber<T> {
        final Subscriber<? super Observable<T>> child;
        final CompositeSubscription csub;
        boolean done;
        final Object guard = new Object();
        final List<SerializedSubject<T>> chunks = new LinkedList();

        public SourceSubscriber(Subscriber<? super Observable<T>> subscriber, CompositeSubscription compositeSubscription) {
            this.child = new SerializedSubscriber(subscriber);
            this.csub = compositeSubscription;
        }

        void beginWindow(U u16) {
            final SerializedSubject<T> createSerializedSubject = createSerializedSubject();
            synchronized (this.guard) {
                if (this.done) {
                    return;
                }
                this.chunks.add(createSerializedSubject);
                this.child.onNext(createSerializedSubject.producer);
                try {
                    Observable<? extends V> call = OperatorWindowWithStartEndObservable.this.windowClosingSelector.call(u16);
                    Subscriber<V> subscriber = new Subscriber<V>() { // from class: rx.internal.operators.OperatorWindowWithStartEndObservable.SourceSubscriber.1
                        boolean once = true;

                        @Override // rx.Observer
                        public void onCompleted() {
                            if (this.once) {
                                this.once = false;
                                SourceSubscriber.this.endWindow(createSerializedSubject);
                                SourceSubscriber.this.csub.remove(this);
                            }
                        }

                        @Override // rx.Observer
                        public void onError(Throwable th5) {
                            SourceSubscriber.this.onError(th5);
                        }

                        @Override // rx.Observer
                        public void onNext(V v3) {
                            onCompleted();
                        }
                    };
                    this.csub.add(subscriber);
                    call.unsafeSubscribe(subscriber);
                } catch (Throwable th5) {
                    onError(th5);
                }
            }
        }

        SerializedSubject<T> createSerializedSubject() {
            UnicastSubject create = UnicastSubject.create();
            return new SerializedSubject<>(create, create);
        }

        void endWindow(SerializedSubject<T> serializedSubject) {
            boolean z16;
            synchronized (this.guard) {
                if (this.done) {
                    return;
                }
                Iterator<SerializedSubject<T>> it = this.chunks.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next() == serializedSubject) {
                            it.remove();
                            z16 = true;
                            break;
                        }
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (z16) {
                    serializedSubject.consumer.onCompleted();
                }
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            try {
                synchronized (this.guard) {
                    if (this.done) {
                        return;
                    }
                    this.done = true;
                    ArrayList arrayList = new ArrayList(this.chunks);
                    this.chunks.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((SerializedSubject) it.next()).consumer.onCompleted();
                    }
                    this.child.onCompleted();
                }
            } finally {
                this.csub.unsubscribe();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            try {
                synchronized (this.guard) {
                    if (this.done) {
                        return;
                    }
                    this.done = true;
                    ArrayList arrayList = new ArrayList(this.chunks);
                    this.chunks.clear();
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        ((SerializedSubject) it.next()).consumer.onError(th5);
                    }
                    this.child.onError(th5);
                }
            } finally {
                this.csub.unsubscribe();
            }
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            synchronized (this.guard) {
                if (this.done) {
                    return;
                }
                Iterator it = new ArrayList(this.chunks).iterator();
                while (it.hasNext()) {
                    ((SerializedSubject) it.next()).consumer.onNext(t16);
                }
            }
        }

        @Override // rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    public OperatorWindowWithStartEndObservable(Observable<? extends U> observable, Func1<? super U, ? extends Observable<? extends V>> func1) {
        this.windowOpenings = observable;
        this.windowClosingSelector = func1;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super Observable<T>> subscriber) {
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        subscriber.add(compositeSubscription);
        final SourceSubscriber sourceSubscriber = new SourceSubscriber(subscriber, compositeSubscription);
        Subscriber<U> subscriber2 = new Subscriber<U>() { // from class: rx.internal.operators.OperatorWindowWithStartEndObservable.1
            @Override // rx.Observer
            public void onCompleted() {
                sourceSubscriber.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable th5) {
                sourceSubscriber.onError(th5);
            }

            @Override // rx.Observer
            public void onNext(U u16) {
                sourceSubscriber.beginWindow(u16);
            }

            @Override // rx.Subscriber
            public void onStart() {
                request(Long.MAX_VALUE);
            }
        };
        compositeSubscription.add(sourceSubscriber);
        compositeSubscription.add(subscriber2);
        this.windowOpenings.unsafeSubscribe(subscriber2);
        return sourceSubscriber;
    }
}
