package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.Deque;
import rx.Observable;
import rx.Subscriber;

/* compiled from: P */
/* loaded from: classes29.dex */
public class OperatorSkipLast<T> implements Observable.Operator<T, T> {
    final int count;

    public OperatorSkipLast(int i3) {
        if (i3 >= 0) {
            this.count = i3;
            return;
        }
        throw new IndexOutOfBoundsException("count could not be negative");
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OperatorSkipLast.1

            /* renamed from: on, reason: collision with root package name */
            private final NotificationLite<T> f432681on = NotificationLite.instance();
            private final Deque<Object> deque = new ArrayDeque();

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
                if (OperatorSkipLast.this.count == 0) {
                    subscriber.onNext(t16);
                    return;
                }
                if (this.deque.size() == OperatorSkipLast.this.count) {
                    subscriber.onNext(this.f432681on.getValue(this.deque.removeFirst()));
                } else {
                    request(1L);
                }
                this.deque.offerLast(this.f432681on.next(t16));
            }
        };
    }
}
