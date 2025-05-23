package rx;

import rx.internal.util.SubscriptionList;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class Subscriber<T> implements Observer<T>, Subscription {
    private static final long NOT_SET = Long.MIN_VALUE;
    private Producer producer;
    private long requested;
    private final Subscriber<?> subscriber;
    private final SubscriptionList subscriptions;

    /* JADX INFO: Access modifiers changed from: protected */
    public Subscriber() {
        this(null, false);
    }

    private void addToRequested(long j3) {
        long j16 = this.requested;
        if (j16 == Long.MIN_VALUE) {
            this.requested = j3;
            return;
        }
        long j17 = j16 + j3;
        if (j17 < 0) {
            this.requested = Long.MAX_VALUE;
        } else {
            this.requested = j17;
        }
    }

    public final void add(Subscription subscription) {
        this.subscriptions.add(subscription);
    }

    @Override // rx.Subscription
    public final boolean isUnsubscribed() {
        return this.subscriptions.isUnsubscribed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void request(long j3) {
        if (j3 >= 0) {
            synchronized (this) {
                Producer producer = this.producer;
                if (producer != null) {
                    producer.request(j3);
                    return;
                } else {
                    addToRequested(j3);
                    return;
                }
            }
        }
        throw new IllegalArgumentException("number requested cannot be negative: " + j3);
    }

    public void setProducer(Producer producer) {
        long j3;
        Subscriber<?> subscriber;
        boolean z16;
        synchronized (this) {
            j3 = this.requested;
            this.producer = producer;
            subscriber = this.subscriber;
            if (subscriber != null && j3 == Long.MIN_VALUE) {
                z16 = true;
            } else {
                z16 = false;
            }
        }
        if (z16) {
            subscriber.setProducer(producer);
        } else if (j3 == Long.MIN_VALUE) {
            producer.request(Long.MAX_VALUE);
        } else {
            producer.request(j3);
        }
    }

    @Override // rx.Subscription
    public final void unsubscribe() {
        this.subscriptions.unsubscribe();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Subscriber(Subscriber<?> subscriber) {
        this(subscriber, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Subscriber(Subscriber<?> subscriber, boolean z16) {
        this.requested = Long.MIN_VALUE;
        this.subscriber = subscriber;
        this.subscriptions = (!z16 || subscriber == null) ? new SubscriptionList() : subscriber.subscriptions;
    }

    public void onStart() {
    }
}
