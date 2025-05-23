package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnSubscribeRange implements Observable.OnSubscribe<Integer> {
    private final int endIndex;
    private final int startIndex;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class RangeProducer extends AtomicLong implements Producer {
        private static final long serialVersionUID = 4114392207069098388L;
        private final Subscriber<? super Integer> childSubscriber;
        private long currentIndex;
        private final int endOfRange;

        RangeProducer(Subscriber<? super Integer> subscriber, int i3, int i16) {
            this.childSubscriber = subscriber;
            this.currentIndex = i3;
            this.endOfRange = i16;
        }

        void fastpath() {
            long j3 = this.endOfRange + 1;
            Subscriber<? super Integer> subscriber = this.childSubscriber;
            for (long j16 = this.currentIndex; j16 != j3; j16++) {
                if (subscriber.isUnsubscribed()) {
                    return;
                }
                subscriber.onNext(Integer.valueOf((int) j16));
            }
            if (!subscriber.isUnsubscribed()) {
                subscriber.onCompleted();
            }
        }

        @Override // rx.Producer
        public void request(long j3) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j3 == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                fastpath();
            } else if (j3 > 0 && BackpressureUtils.getAndAddRequest(this, j3) == 0) {
                slowpath(j3);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x003e, code lost:
        
            r12.currentIndex = r4;
            r13 = addAndGet(-r9);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void slowpath(long j3) {
            long j16 = this.endOfRange + 1;
            long j17 = this.currentIndex;
            Subscriber<? super Integer> subscriber = this.childSubscriber;
            do {
                long j18 = 0;
                while (true) {
                    if (j18 != j3 && j17 != j16) {
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        subscriber.onNext(Integer.valueOf((int) j17));
                        j17++;
                        j18++;
                    } else {
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        if (j17 == j16) {
                            subscriber.onCompleted();
                            return;
                        } else {
                            j3 = get();
                            if (j3 == j18) {
                                break;
                            }
                        }
                    }
                }
            } while (j3 != 0);
        }
    }

    public OnSubscribeRange(int i3, int i16) {
        this.startIndex = i3;
        this.endIndex = i16;
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super Integer> subscriber) {
        subscriber.setProducer(new RangeProducer(subscriber, this.startIndex, this.endIndex));
    }
}
