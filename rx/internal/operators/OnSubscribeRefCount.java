package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.observables.ConnectableObservable;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnSubscribeRefCount<T> implements Observable.OnSubscribe<T> {
    private final ConnectableObservable<? extends T> source;
    volatile CompositeSubscription baseSubscription = new CompositeSubscription();
    final AtomicInteger subscriptionCount = new AtomicInteger(0);
    final ReentrantLock lock = new ReentrantLock();

    public OnSubscribeRefCount(ConnectableObservable<? extends T> connectableObservable) {
        this.source = connectableObservable;
    }

    private Subscription disconnect(final CompositeSubscription compositeSubscription) {
        return Subscriptions.create(new Action0() { // from class: rx.internal.operators.OnSubscribeRefCount.3
            @Override // rx.functions.Action0
            public void call() {
                OnSubscribeRefCount.this.lock.lock();
                try {
                    if (OnSubscribeRefCount.this.baseSubscription == compositeSubscription && OnSubscribeRefCount.this.subscriptionCount.decrementAndGet() == 0) {
                        OnSubscribeRefCount.this.baseSubscription.unsubscribe();
                        OnSubscribeRefCount.this.baseSubscription = new CompositeSubscription();
                    }
                } finally {
                    OnSubscribeRefCount.this.lock.unlock();
                }
            }
        });
    }

    private Action1<Subscription> onSubscribe(final Subscriber<? super T> subscriber, final AtomicBoolean atomicBoolean) {
        return new Action1<Subscription>() { // from class: rx.internal.operators.OnSubscribeRefCount.1
            @Override // rx.functions.Action1
            public void call(Subscription subscription) {
                try {
                    OnSubscribeRefCount.this.baseSubscription.add(subscription);
                    OnSubscribeRefCount onSubscribeRefCount = OnSubscribeRefCount.this;
                    onSubscribeRefCount.doSubscribe(subscriber, onSubscribeRefCount.baseSubscription);
                } finally {
                    OnSubscribeRefCount.this.lock.unlock();
                    atomicBoolean.set(false);
                }
            }
        };
    }

    void doSubscribe(final Subscriber<? super T> subscriber, final CompositeSubscription compositeSubscription) {
        subscriber.add(disconnect(compositeSubscription));
        this.source.unsafeSubscribe(new Subscriber<T>(subscriber) { // from class: rx.internal.operators.OnSubscribeRefCount.2
            void cleanup() {
                OnSubscribeRefCount.this.lock.lock();
                try {
                    if (OnSubscribeRefCount.this.baseSubscription == compositeSubscription) {
                        OnSubscribeRefCount.this.baseSubscription.unsubscribe();
                        OnSubscribeRefCount.this.baseSubscription = new CompositeSubscription();
                        OnSubscribeRefCount.this.subscriptionCount.set(0);
                    }
                } finally {
                    OnSubscribeRefCount.this.lock.unlock();
                }
            }

            @Override // rx.Observer
            public void onCompleted() {
                cleanup();
                subscriber.onCompleted();
            }

            @Override // rx.Observer
            public void onError(Throwable th5) {
                cleanup();
                subscriber.onError(th5);
            }

            @Override // rx.Observer
            public void onNext(T t16) {
                subscriber.onNext(t16);
            }
        });
    }

    @Override // rx.functions.Action1
    public void call(Subscriber<? super T> subscriber) {
        boolean z16;
        this.lock.lock();
        if (this.subscriptionCount.incrementAndGet() == 1) {
            AtomicBoolean atomicBoolean = new AtomicBoolean(true);
            try {
                this.source.connect(onSubscribe(subscriber, atomicBoolean));
                if (z16) {
                    return;
                } else {
                    return;
                }
            } finally {
                if (atomicBoolean.get()) {
                }
            }
        }
        try {
            doSubscribe(subscriber, this.baseSubscription);
        } finally {
            this.lock.unlock();
        }
    }
}
