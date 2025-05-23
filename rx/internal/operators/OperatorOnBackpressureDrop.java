package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action1;

/* compiled from: P */
/* loaded from: classes29.dex */
public class OperatorOnBackpressureDrop<T> implements Observable.Operator<T, T> {
    final Action1<? super T> onDrop;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class Holder {
        static final OperatorOnBackpressureDrop<Object> INSTANCE = new OperatorOnBackpressureDrop<>();

        Holder() {
        }
    }

    OperatorOnBackpressureDrop() {
        this(null);
    }

    public static <T> OperatorOnBackpressureDrop<T> instance() {
        return (OperatorOnBackpressureDrop<T>) Holder.INSTANCE;
    }

    public OperatorOnBackpressureDrop(Action1<? super T> action1) {
        this.onDrop = action1;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        final AtomicLong atomicLong = new AtomicLong();
        subscriber.setProducer(new Producer() { // from class: rx.internal.operators.OperatorOnBackpressureDrop.1
            @Override // rx.Producer
            public void request(long j3) {
                BackpressureUtils.getAndAddRequest(atomicLong, j3);
            }
        });
        return new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorOnBackpressureDrop.2
            @Override // rx.Observer
            public void onCompleted() {
                subscriber.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable th5) {
                subscriber.onError(th5);
            }

            @Override // rx.Observer
            public void onNext(T t16) {
                if (atomicLong.get() > 0) {
                    subscriber.onNext(t16);
                    atomicLong.decrementAndGet();
                    return;
                }
                Action1<? super T> action1 = OperatorOnBackpressureDrop.this.onDrop;
                if (action1 != null) {
                    try {
                        action1.call(t16);
                    } catch (Throwable th5) {
                        Exceptions.throwOrReport(th5, subscriber, t16);
                    }
                }
            }

            @Override // rx.Subscriber
            public void onStart() {
                request(Long.MAX_VALUE);
            }
        };
    }
}
