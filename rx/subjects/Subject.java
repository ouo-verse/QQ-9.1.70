package rx.subjects;

import rx.Observable;
import rx.Observer;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class Subject<T, R> extends Observable<R> implements Observer<T> {
    /* JADX INFO: Access modifiers changed from: protected */
    public Subject(Observable.OnSubscribe<R> onSubscribe) {
        super(onSubscribe);
    }

    public abstract boolean hasObservers();

    public final SerializedSubject<T, R> toSerialized() {
        if (getClass() == SerializedSubject.class) {
            return (SerializedSubject) this;
        }
        return new SerializedSubject<>(this);
    }
}
