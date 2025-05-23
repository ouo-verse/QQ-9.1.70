package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Func1;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorTakeLast<T> implements Observable.Operator<T, T> {
    final int count;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class TakeLastSubscriber<T> extends Subscriber<T> implements Func1<Object, T> {
        final Subscriber<? super T> actual;
        final int count;
        final AtomicLong requested = new AtomicLong();
        final ArrayDeque<Object> queue = new ArrayDeque<>();

        /* renamed from: nl, reason: collision with root package name */
        final NotificationLite<T> f432684nl = NotificationLite.instance();

        public TakeLastSubscriber(Subscriber<? super T> subscriber, int i3) {
            this.actual = subscriber;
            this.count = i3;
        }

        @Override // rx.functions.Func1
        public T call(Object obj) {
            return this.f432684nl.getValue(obj);
        }

        @Override // rx.Observer
        public void onCompleted() {
            BackpressureUtils.postCompleteDone(this.requested, this.queue, this.actual, this);
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            this.queue.clear();
            this.actual.onError(th5);
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            if (this.queue.size() == this.count) {
                this.queue.poll();
            }
            this.queue.offer(this.f432684nl.next(t16));
        }

        void requestMore(long j3) {
            if (j3 > 0) {
                BackpressureUtils.postCompleteRequest(this.requested, j3, this.queue, this.actual, this);
            }
        }
    }

    public OperatorTakeLast(int i3) {
        if (i3 >= 0) {
            this.count = i3;
            return;
        }
        throw new IndexOutOfBoundsException("count cannot be negative");
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final TakeLastSubscriber takeLastSubscriber = new TakeLastSubscriber(subscriber, this.count);
        subscriber.add(takeLastSubscriber);
        subscriber.setProducer(new Producer() { // from class: rx.internal.operators.OperatorTakeLast.1
            @Override // rx.Producer
            public void request(long j3) {
                takeLastSubscriber.requestMore(j3);
            }
        });
        return takeLastSubscriber;
    }
}
