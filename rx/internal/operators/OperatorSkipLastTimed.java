package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.schedulers.Timestamped;

/* compiled from: P */
/* loaded from: classes29.dex */
public class OperatorSkipLastTimed<T> implements Observable.Operator<T, T> {
    final Scheduler scheduler;
    final long timeInMillis;

    public OperatorSkipLastTimed(long j3, TimeUnit timeUnit, Scheduler scheduler) {
        this.timeInMillis = timeUnit.toMillis(j3);
        this.scheduler = scheduler;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorSkipLastTimed.1
            private Deque<Timestamped<T>> buffer = new ArrayDeque();

            private void emitItemsOutOfWindow(long j3) {
                long j16 = j3 - OperatorSkipLastTimed.this.timeInMillis;
                while (!this.buffer.isEmpty()) {
                    Timestamped<T> first = this.buffer.getFirst();
                    if (first.getTimestampMillis() < j16) {
                        this.buffer.removeFirst();
                        subscriber.onNext(first.getValue());
                    } else {
                        return;
                    }
                }
            }

            @Override // rx.Observer
            public void onCompleted() {
                emitItemsOutOfWindow(OperatorSkipLastTimed.this.scheduler.now());
                subscriber.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable th5) {
                subscriber.onError(th5);
            }

            @Override // rx.Observer
            public void onNext(T t16) {
                long now = OperatorSkipLastTimed.this.scheduler.now();
                emitItemsOutOfWindow(now);
                this.buffer.offerLast(new Timestamped<>(now, t16));
            }
        };
    }
}
