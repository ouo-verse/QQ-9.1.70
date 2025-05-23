package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorTake<T> implements Observable.Operator<T, T> {
    final int limit;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: rx.internal.operators.OperatorTake$1, reason: invalid class name */
    /* loaded from: classes29.dex */
    public class AnonymousClass1 extends Subscriber<T> {
        boolean completed;
        int count;
        final /* synthetic */ Subscriber val$child;

        AnonymousClass1(Subscriber subscriber) {
            this.val$child = subscriber;
        }

        @Override // rx.Observer
        public void onCompleted() {
            if (!this.completed) {
                this.completed = true;
                this.val$child.onCompleted();
            }
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            if (!this.completed) {
                this.completed = true;
                try {
                    this.val$child.onError(th5);
                } finally {
                    unsubscribe();
                }
            }
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            boolean z16;
            if (!isUnsubscribed()) {
                int i3 = this.count;
                int i16 = i3 + 1;
                this.count = i16;
                int i17 = OperatorTake.this.limit;
                if (i3 < i17) {
                    if (i16 == i17) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    this.val$child.onNext(t16);
                    if (z16 && !this.completed) {
                        this.completed = true;
                        try {
                            this.val$child.onCompleted();
                        } finally {
                            unsubscribe();
                        }
                    }
                }
            }
        }

        @Override // rx.Subscriber
        public void setProducer(final Producer producer) {
            this.val$child.setProducer(new Producer() { // from class: rx.internal.operators.OperatorTake.1.1
                final AtomicLong requested = new AtomicLong(0);

                @Override // rx.Producer
                public void request(long j3) {
                    long j16;
                    long min;
                    if (j3 <= 0 || AnonymousClass1.this.completed) {
                        return;
                    }
                    do {
                        j16 = this.requested.get();
                        min = Math.min(j3, OperatorTake.this.limit - j16);
                        if (min == 0) {
                            return;
                        }
                    } while (!this.requested.compareAndSet(j16, j16 + min));
                    producer.request(min);
                }
            });
        }
    }

    public OperatorTake(int i3) {
        if (i3 >= 0) {
            this.limit = i3;
            return;
        }
        throw new IllegalArgumentException("limit >= 0 required but it was " + i3);
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        AnonymousClass1 anonymousClass1 = new AnonymousClass1(subscriber);
        if (this.limit == 0) {
            subscriber.onCompleted();
            anonymousClass1.unsubscribe();
        }
        subscriber.add(anonymousClass1);
        return anonymousClass1;
    }
}
