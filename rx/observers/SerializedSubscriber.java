package rx.observers;

import rx.Observer;
import rx.Subscriber;

/* compiled from: P */
/* loaded from: classes29.dex */
public class SerializedSubscriber<T> extends Subscriber<T> {

    /* renamed from: s, reason: collision with root package name */
    private final Observer<T> f432876s;

    public SerializedSubscriber(Subscriber<? super T> subscriber) {
        this(subscriber, true);
    }

    @Override // rx.Observer
    public void onCompleted() {
        this.f432876s.onCompleted();
    }

    @Override // rx.Observer
    public void onError(Throwable th5) {
        this.f432876s.onError(th5);
    }

    @Override // rx.Observer
    public void onNext(T t16) {
        this.f432876s.onNext(t16);
    }

    public SerializedSubscriber(Subscriber<? super T> subscriber, boolean z16) {
        super(subscriber, z16);
        this.f432876s = new SerializedObserver(subscriber);
    }
}
