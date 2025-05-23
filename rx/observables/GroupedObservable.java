package rx.observables;

import rx.Observable;
import rx.Subscriber;

/* compiled from: P */
/* loaded from: classes29.dex */
public class GroupedObservable<K, T> extends Observable<T> {
    private final K key;

    /* JADX INFO: Access modifiers changed from: protected */
    public GroupedObservable(K k3, Observable.OnSubscribe<T> onSubscribe) {
        super(onSubscribe);
        this.key = k3;
    }

    public static <K, T> GroupedObservable<K, T> create(K k3, Observable.OnSubscribe<T> onSubscribe) {
        return new GroupedObservable<>(k3, onSubscribe);
    }

    public static <K, T> GroupedObservable<K, T> from(K k3, final Observable<T> observable) {
        return new GroupedObservable<>(k3, new Observable.OnSubscribe<T>() { // from class: rx.observables.GroupedObservable.1
            @Override // rx.functions.Action1
            public void call(Subscriber<? super T> subscriber) {
                Observable.this.unsafeSubscribe(subscriber);
            }
        });
    }

    public K getKey() {
        return this.key;
    }
}
