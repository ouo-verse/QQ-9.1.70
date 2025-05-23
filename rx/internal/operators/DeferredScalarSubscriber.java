package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class DeferredScalarSubscriber<T, R> extends Subscriber<T> {
    static final int HAS_REQUEST_HAS_VALUE = 3;
    static final int HAS_REQUEST_NO_VALUE = 1;
    static final int NO_REQUEST_HAS_VALUE = 2;
    static final int NO_REQUEST_NO_VALUE = 0;
    protected final Subscriber<? super R> actual;
    protected boolean hasValue;
    final AtomicInteger state = new AtomicInteger();
    protected R value;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class InnerProducer implements Producer {
        final DeferredScalarSubscriber<?, ?> parent;

        public InnerProducer(DeferredScalarSubscriber<?, ?> deferredScalarSubscriber) {
            this.parent = deferredScalarSubscriber;
        }

        @Override // rx.Producer
        public void request(long j3) {
            this.parent.downstreamRequest(j3);
        }
    }

    public DeferredScalarSubscriber(Subscriber<? super R> subscriber) {
        this.actual = subscriber;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void complete() {
        this.actual.onCompleted();
    }

    final void downstreamRequest(long j3) {
        if (j3 >= 0) {
            if (j3 != 0) {
                Subscriber<? super R> subscriber = this.actual;
                do {
                    int i3 = this.state.get();
                    if (i3 != 1 && i3 != 3 && !subscriber.isUnsubscribed()) {
                        if (i3 == 2) {
                            if (this.state.compareAndSet(2, 3)) {
                                subscriber.onNext(this.value);
                                if (!subscriber.isUnsubscribed()) {
                                    subscriber.onCompleted();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    } else {
                        return;
                    }
                } while (!this.state.compareAndSet(0, 1));
                return;
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required but it was " + j3);
    }

    @Override // rx.Observer
    public void onCompleted() {
        if (this.hasValue) {
            complete(this.value);
        } else {
            complete();
        }
    }

    @Override // rx.Observer
    public void onError(Throwable th5) {
        this.value = null;
        this.actual.onError(th5);
    }

    @Override // rx.Subscriber
    public final void setProducer(Producer producer) {
        producer.request(Long.MAX_VALUE);
    }

    final void setupDownstream() {
        Subscriber<? super R> subscriber = this.actual;
        subscriber.add(this);
        subscriber.setProducer(new InnerProducer(this));
    }

    public final void subscribeTo(Observable<? extends T> observable) {
        setupDownstream();
        observable.unsafeSubscribe(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void complete(R r16) {
        Subscriber<? super R> subscriber = this.actual;
        do {
            int i3 = this.state.get();
            if (i3 == 2 || i3 == 3 || subscriber.isUnsubscribed()) {
                return;
            }
            if (i3 == 1) {
                subscriber.onNext(r16);
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onCompleted();
                }
                this.state.lazySet(3);
                return;
            }
            this.value = r16;
        } while (!this.state.compareAndSet(0, 2));
    }
}
