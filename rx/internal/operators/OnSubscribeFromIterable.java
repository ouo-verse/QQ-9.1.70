package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnSubscribeFromIterable<T> implements Observable.OnSubscribe<T> {

    /* renamed from: is, reason: collision with root package name */
    final Iterable<? extends T> f432664is;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class IterableProducer<T> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -8730475647105475802L;
        private final Iterator<? extends T> it;

        /* renamed from: o, reason: collision with root package name */
        private final Subscriber<? super T> f432665o;

        /* JADX INFO: Access modifiers changed from: package-private */
        public IterableProducer(Subscriber<? super T> subscriber, Iterator<? extends T> it) {
            this.f432665o = subscriber;
            this.it = it;
        }

        void fastpath() {
            Subscriber<? super T> subscriber = this.f432665o;
            Iterator<? extends T> it = this.it;
            while (!subscriber.isUnsubscribed()) {
                try {
                    subscriber.onNext(it.next());
                    if (subscriber.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (!subscriber.isUnsubscribed()) {
                                subscriber.onCompleted();
                                return;
                            }
                            return;
                        }
                    } catch (Throwable th5) {
                        Exceptions.throwOrReport(th5, subscriber);
                        return;
                    }
                } catch (Throwable th6) {
                    Exceptions.throwOrReport(th6, subscriber);
                    return;
                }
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

        /* JADX WARN: Code restructure failed: missing block: B:9:0x0046, code lost:
        
            r9 = rx.internal.operators.BackpressureUtils.produced(r8, r4);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void slowpath(long j3) {
            Subscriber<? super T> subscriber = this.f432665o;
            Iterator<? extends T> it = this.it;
            do {
                long j16 = 0;
                while (true) {
                    if (j16 != j3) {
                        if (subscriber.isUnsubscribed()) {
                            return;
                        }
                        try {
                            subscriber.onNext(it.next());
                            if (subscriber.isUnsubscribed()) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (!subscriber.isUnsubscribed()) {
                                        subscriber.onCompleted();
                                        return;
                                    }
                                    return;
                                }
                                j16++;
                            } catch (Throwable th5) {
                                Exceptions.throwOrReport(th5, subscriber);
                                return;
                            }
                        } catch (Throwable th6) {
                            Exceptions.throwOrReport(th6, subscriber);
                            return;
                        }
                    } else {
                        j3 = get();
                        if (j16 == j3) {
                            break;
                        }
                    }
                }
            } while (j3 != 0);
        }
    }

    public OnSubscribeFromIterable(Iterable<? extends T> iterable) {
        if (iterable != null) {
            this.f432664is = iterable;
            return;
        }
        throw new NullPointerException("iterable must not be null");
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super T> subscriber) {
        try {
            Iterator<? extends T> it = this.f432664is.iterator();
            boolean hasNext = it.hasNext();
            if (subscriber.isUnsubscribed()) {
                return;
            }
            if (!hasNext) {
                subscriber.onCompleted();
            } else {
                subscriber.setProducer(new IterableProducer(subscriber, it));
            }
        } catch (Throwable th5) {
            Exceptions.throwOrReport(th5, subscriber);
        }
    }
}
