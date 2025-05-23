package rx.internal.operators;

import ADV_REPORT.mobile_adv_report_req;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnSubscribeFromArray<T> implements Observable.OnSubscribe<T> {
    final T[] array;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class FromArrayProducer<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = 3534218984725836979L;
        final T[] array;
        final Subscriber<? super T> child;
        int index;

        public FromArrayProducer(Subscriber<? super T> subscriber, T[] tArr) {
            this.child = subscriber;
            this.array = tArr;
        }

        void fastPath() {
            Subscriber<? super T> subscriber = this.child;
            for (mobile_adv_report_req mobile_adv_report_reqVar : this.array) {
                if (subscriber.isUnsubscribed()) {
                    return;
                }
                subscriber.onNext(mobile_adv_report_reqVar);
            }
            if (subscriber.isUnsubscribed()) {
                return;
            }
            subscriber.onCompleted();
        }

        @Override // rx.Producer
        public void request(long j3) {
            if (j3 >= 0) {
                if (j3 == Long.MAX_VALUE) {
                    if (BackpressureUtils.getAndAddRequest(this, j3) == 0) {
                        fastPath();
                        return;
                    }
                    return;
                } else {
                    if (j3 != 0 && BackpressureUtils.getAndAddRequest(this, j3) == 0) {
                        slowPath(j3);
                        return;
                    }
                    return;
                }
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j3);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0038, code lost:
        
            r10.index = r3;
            r11 = addAndGet(r6);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void slowPath(long j3) {
            Subscriber<? super T> subscriber = this.child;
            T[] tArr = this.array;
            int length = tArr.length;
            int i3 = this.index;
            do {
                long j16 = 0;
                while (true) {
                    if (j3 != 0 && i3 != length) {
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        subscriber.onNext(tArr[i3]);
                        i3++;
                        if (i3 == length) {
                            if (!subscriber.isUnsubscribed()) {
                                subscriber.onCompleted();
                                return;
                            }
                            return;
                        }
                        j3--;
                        j16--;
                    } else {
                        j3 = get() + j16;
                        if (j3 == 0) {
                            break;
                        }
                    }
                }
            } while (j3 != 0);
        }
    }

    public OnSubscribeFromArray(T[] tArr) {
        this.array = tArr;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super T> subscriber) {
        subscriber.setProducer(new FromArrayProducer(subscriber, this.array));
    }
}
