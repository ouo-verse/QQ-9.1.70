package rx.subjects;

import rx.Observable;
import rx.Subscriber;
import rx.observers.SerializedObserver;

/* compiled from: P */
/* loaded from: classes29.dex */
public class SerializedSubject<T, R> extends Subject<T, R> {
    private final Subject<T, R> actual;
    private final SerializedObserver<T> observer;

    public SerializedSubject(final Subject<T, R> subject) {
        super(new Observable.OnSubscribe<R>() { // from class: rx.subjects.SerializedSubject.1
            @Override // rx.functions.Action1
            public void call(Subscriber<? super R> subscriber) {
                Subject.this.unsafeSubscribe(subscriber);
            }
        });
        this.actual = subject;
        this.observer = new SerializedObserver<>(subject);
    }

    @Override // rx.subjects.Subject
    public boolean hasObservers() {
        return this.actual.hasObservers();
    }

    @Override // rx.Observer
    public void onCompleted() {
        this.observer.onCompleted();
    }

    @Override // rx.Observer
    public void onError(Throwable th5) {
        this.observer.onError(th5);
    }

    @Override // rx.Observer
    public void onNext(T t16) {
        this.observer.onNext(t16);
    }
}
