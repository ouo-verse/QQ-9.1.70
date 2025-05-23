package rx.internal.operators;

import androidx.lifecycle.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subscriptions.Subscriptions;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnSubscribeAmb<T> implements Observable.OnSubscribe<T> {
    final Iterable<? extends Observable<? extends T>> sources;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class AmbSubscriber<T> extends Subscriber<T> {
        private boolean chosen;
        private final Selection<T> selection;
        private final Subscriber<? super T> subscriber;

        AmbSubscriber(long j3, Subscriber<? super T> subscriber, Selection<T> selection) {
            this.subscriber = subscriber;
            this.selection = selection;
            request(j3);
        }

        private boolean isSelected() {
            if (this.chosen) {
                return true;
            }
            if (this.selection.choice.get() == this) {
                this.chosen = true;
                return true;
            }
            if (c.a(this.selection.choice, null, this)) {
                this.selection.unsubscribeOthers(this);
                this.chosen = true;
                return true;
            }
            this.selection.unsubscribeLosers();
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void requestMore(long j3) {
            request(j3);
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!isSelected()) {
                return;
            }
            this.subscriber.onCompleted();
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            if (!isSelected()) {
                return;
            }
            this.subscriber.onError(th5);
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            if (!isSelected()) {
                return;
            }
            this.subscriber.onNext(t16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class Selection<T> {
        final AtomicReference<AmbSubscriber<T>> choice = new AtomicReference<>();
        final Collection<AmbSubscriber<T>> ambSubscribers = new ConcurrentLinkedQueue();

        Selection() {
        }

        public void unsubscribeLosers() {
            AmbSubscriber<T> ambSubscriber = this.choice.get();
            if (ambSubscriber != null) {
                unsubscribeOthers(ambSubscriber);
            }
        }

        public void unsubscribeOthers(AmbSubscriber<T> ambSubscriber) {
            for (AmbSubscriber<T> ambSubscriber2 : this.ambSubscribers) {
                if (ambSubscriber2 != ambSubscriber) {
                    ambSubscriber2.unsubscribe();
                }
            }
            this.ambSubscribers.clear();
        }
    }

    OnSubscribeAmb(Iterable<? extends Observable<? extends T>> iterable) {
        this.sources = iterable;
    }

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        return amb(arrayList);
    }

    static <T> void unsubscribeAmbSubscribers(Collection<AmbSubscriber<T>> collection) {
        if (!collection.isEmpty()) {
            Iterator<AmbSubscriber<T>> it = collection.iterator();
            while (it.hasNext()) {
                it.next().unsubscribe();
            }
            collection.clear();
        }
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super T> subscriber) {
        final Selection selection = new Selection();
        final AtomicReference<AmbSubscriber<T>> atomicReference = selection.choice;
        subscriber.add(Subscriptions.create(new Action0() { // from class: rx.internal.operators.OnSubscribeAmb.1
            @Override // rx.functions.Action0
            public void call() {
                AmbSubscriber ambSubscriber = (AmbSubscriber) atomicReference.get();
                if (ambSubscriber != null) {
                    ambSubscriber.unsubscribe();
                }
                OnSubscribeAmb.unsubscribeAmbSubscribers(selection.ambSubscribers);
            }
        }));
        for (Observable<? extends T> observable : this.sources) {
            if (subscriber.isUnsubscribed()) {
                break;
            }
            AmbSubscriber<T> ambSubscriber = new AmbSubscriber<>(0L, subscriber, selection);
            selection.ambSubscribers.add(ambSubscriber);
            AmbSubscriber<T> ambSubscriber2 = atomicReference.get();
            if (ambSubscriber2 != null) {
                selection.unsubscribeOthers(ambSubscriber2);
                return;
            }
            observable.unsafeSubscribe(ambSubscriber);
        }
        if (subscriber.isUnsubscribed()) {
            unsubscribeAmbSubscribers(selection.ambSubscribers);
        }
        subscriber.setProducer(new Producer() { // from class: rx.internal.operators.OnSubscribeAmb.2
            @Override // rx.Producer
            public void request(long j3) {
                AmbSubscriber ambSubscriber3 = (AmbSubscriber) atomicReference.get();
                if (ambSubscriber3 != null) {
                    ambSubscriber3.requestMore(j3);
                    return;
                }
                for (AmbSubscriber<T> ambSubscriber4 : selection.ambSubscribers) {
                    if (!ambSubscriber4.isUnsubscribed()) {
                        if (atomicReference.get() == ambSubscriber4) {
                            ambSubscriber4.requestMore(j3);
                            return;
                        }
                        ambSubscriber4.requestMore(j3);
                    }
                }
            }
        });
    }

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        return amb(arrayList);
    }

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        arrayList.add(observable4);
        return amb(arrayList);
    }

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        arrayList.add(observable4);
        arrayList.add(observable5);
        return amb(arrayList);
    }

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        arrayList.add(observable4);
        arrayList.add(observable5);
        arrayList.add(observable6);
        return amb(arrayList);
    }

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        arrayList.add(observable4);
        arrayList.add(observable5);
        arrayList.add(observable6);
        arrayList.add(observable7);
        return amb(arrayList);
    }

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        arrayList.add(observable4);
        arrayList.add(observable5);
        arrayList.add(observable6);
        arrayList.add(observable7);
        arrayList.add(observable8);
        return amb(arrayList);
    }

    public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> observable, Observable<? extends T> observable2, Observable<? extends T> observable3, Observable<? extends T> observable4, Observable<? extends T> observable5, Observable<? extends T> observable6, Observable<? extends T> observable7, Observable<? extends T> observable8, Observable<? extends T> observable9) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(observable);
        arrayList.add(observable2);
        arrayList.add(observable3);
        arrayList.add(observable4);
        arrayList.add(observable5);
        arrayList.add(observable6);
        arrayList.add(observable7);
        arrayList.add(observable8);
        arrayList.add(observable9);
        return amb(arrayList);
    }

    public static <T> Observable.OnSubscribe<T> amb(Iterable<? extends Observable<? extends T>> iterable) {
        return new OnSubscribeAmb(iterable);
    }
}
