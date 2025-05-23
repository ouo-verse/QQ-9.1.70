package rx.internal.producers;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;

/* loaded from: classes29.dex */
public final class SingleProducer<T> extends AtomicBoolean implements Producer {
    private static final long serialVersionUID = -3353584923995471404L;
    final Subscriber<? super T> child;
    final T value;

    public SingleProducer(Subscriber<? super T> subscriber, T t16) {
        this.child = subscriber;
        this.value = t16;
    }

    @Override // rx.Producer
    public void request(long j3) {
        if (j3 >= 0) {
            if (j3 != 0 && compareAndSet(false, true)) {
                Subscriber<? super T> subscriber = this.child;
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
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
