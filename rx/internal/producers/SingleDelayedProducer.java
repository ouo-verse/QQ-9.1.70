package rx.internal.producers;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;

/* loaded from: classes29.dex */
public final class SingleDelayedProducer<T> extends AtomicInteger implements Producer {
    static final int HAS_REQUEST_HAS_VALUE = 3;
    static final int HAS_REQUEST_NO_VALUE = 2;
    static final int NO_REQUEST_HAS_VALUE = 1;
    static final int NO_REQUEST_NO_VALUE = 0;
    private static final long serialVersionUID = -2873467947112093874L;
    final Subscriber<? super T> child;
    T value;

    public SingleDelayedProducer(Subscriber<? super T> subscriber) {
        this.child = subscriber;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void emit(Subscriber<? super T> subscriber, T t16) {
        if (subscriber.isUnsubscribed()) {
            return;
        }
        try {
            subscriber.onNext(t16);
            if (subscriber.isUnsubscribed()) {
                return;
            }
            subscriber.onCompleted();
        } catch (Throwable th5) {
            Exceptions.throwOrReport(th5, subscriber, t16);
        }
    }

    @Override // rx.Producer
    public void request(long j3) {
        if (j3 >= 0) {
            if (j3 == 0) {
                return;
            }
            do {
                int i3 = get();
                if (i3 != 0) {
                    if (i3 == 1 && compareAndSet(1, 3)) {
                        emit(this.child, this.value);
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(0, 2));
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }

    public void setValue(T t16) {
        do {
            int i3 = get();
            if (i3 == 0) {
                this.value = t16;
            } else {
                if (i3 == 2 && compareAndSet(2, 3)) {
                    emit(this.child, t16);
                    return;
                }
                return;
            }
        } while (!compareAndSet(0, 1));
    }
}
