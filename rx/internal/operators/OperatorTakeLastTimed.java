package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Scheduler;
import rx.Subscriber;
import rx.functions.Func1;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OperatorTakeLastTimed<T> implements Observable.Operator<T, T> {
    final long ageMillis;
    final int count;
    final Scheduler scheduler;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class TakeLastTimedSubscriber<T> extends Subscriber<T> implements Func1<Object, T> {
        final Subscriber<? super T> actual;
        final long ageMillis;
        final int count;
        final Scheduler scheduler;
        final AtomicLong requested = new AtomicLong();
        final ArrayDeque<Object> queue = new ArrayDeque<>();
        final ArrayDeque<Long> queueTimes = new ArrayDeque<>();

        /* renamed from: nl, reason: collision with root package name */
        final NotificationLite<T> f432685nl = NotificationLite.instance();

        public TakeLastTimedSubscriber(Subscriber<? super T> subscriber, int i3, long j3, Scheduler scheduler) {
            this.actual = subscriber;
            this.count = i3;
            this.ageMillis = j3;
            this.scheduler = scheduler;
        }

        @Override // rx.functions.Func1
        public T call(Object obj) {
            return this.f432685nl.getValue(obj);
        }

        protected void evictOld(long j3) {
            long j16 = j3 - this.ageMillis;
            while (true) {
                Long peek = this.queueTimes.peek();
                if (peek != null && peek.longValue() < j16) {
                    this.queue.poll();
                    this.queueTimes.poll();
                } else {
                    return;
                }
            }
        }

        @Override // rx.Observer
        public void onCompleted() {
            evictOld(this.scheduler.now());
            this.queueTimes.clear();
            BackpressureUtils.postCompleteDone(this.requested, this.queue, this.actual, this);
        }

        @Override // rx.Observer
        public void onError(Throwable th5) {
            this.queue.clear();
            this.queueTimes.clear();
            this.actual.onError(th5);
        }

        @Override // rx.Observer
        public void onNext(T t16) {
            if (this.count != 0) {
                long now = this.scheduler.now();
                if (this.queue.size() == this.count) {
                    this.queue.poll();
                    this.queueTimes.poll();
                }
                evictOld(now);
                this.queue.offer(this.f432685nl.next(t16));
                this.queueTimes.offer(Long.valueOf(now));
            }
        }

        void requestMore(long j3) {
            BackpressureUtils.postCompleteRequest(this.requested, j3, this.queue, this.actual, this);
        }
    }

    public OperatorTakeLastTimed(long j3, TimeUnit timeUnit, Scheduler scheduler) {
        this.ageMillis = timeUnit.toMillis(j3);
        this.scheduler = scheduler;
        this.count = -1;
    }

    @Override // rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        final TakeLastTimedSubscriber takeLastTimedSubscriber = new TakeLastTimedSubscriber(subscriber, this.count, this.ageMillis, this.scheduler);
        subscriber.add(takeLastTimedSubscriber);
        subscriber.setProducer(new Producer() { // from class: rx.internal.operators.OperatorTakeLastTimed.1
            @Override // rx.Producer
            public void request(long j3) {
                takeLastTimedSubscriber.requestMore(j3);
            }
        });
        return takeLastTimedSubscriber;
    }

    public OperatorTakeLastTimed(int i3, long j3, TimeUnit timeUnit, Scheduler scheduler) {
        if (i3 >= 0) {
            this.ageMillis = timeUnit.toMillis(j3);
            this.scheduler = scheduler;
            this.count = i3;
            return;
        }
        throw new IndexOutOfBoundsException("count could not be negative");
    }
}
