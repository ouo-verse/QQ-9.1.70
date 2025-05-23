package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.Subscription;
import rx.subscriptions.SerialSubscription;
import rx.subscriptions.Subscriptions;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class CompletableOnSubscribeConcatIterable implements Completable.CompletableOnSubscribe {
    final Iterable<? extends Completable> sources;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements Completable.CompletableSubscriber {
        private static final long serialVersionUID = -7965400327305809232L;
        final Completable.CompletableSubscriber actual;
        int index;

        /* renamed from: sd, reason: collision with root package name */
        final SerialSubscription f432657sd = new SerialSubscription();
        final Iterator<? extends Completable> sources;

        public ConcatInnerSubscriber(Completable.CompletableSubscriber completableSubscriber, Iterator<? extends Completable> it) {
            this.actual = completableSubscriber;
            this.sources = it;
        }

        void next() {
            if (this.f432657sd.isUnsubscribed() || getAndIncrement() != 0) {
                return;
            }
            Iterator<? extends Completable> it = this.sources;
            while (!this.f432657sd.isUnsubscribed()) {
                try {
                    if (!it.hasNext()) {
                        this.actual.onCompleted();
                        return;
                    }
                    try {
                        Completable next = it.next();
                        if (next == null) {
                            this.actual.onError(new NullPointerException("The completable returned is null"));
                            return;
                        } else {
                            next.unsafeSubscribe(this);
                            if (decrementAndGet() == 0) {
                                return;
                            }
                        }
                    } catch (Throwable th5) {
                        this.actual.onError(th5);
                        return;
                    }
                } catch (Throwable th6) {
                    this.actual.onError(th6);
                    return;
                }
            }
        }

        @Override // rx.Completable.CompletableSubscriber
        public void onCompleted() {
            next();
        }

        @Override // rx.Completable.CompletableSubscriber
        public void onError(Throwable th5) {
            this.actual.onError(th5);
        }

        @Override // rx.Completable.CompletableSubscriber
        public void onSubscribe(Subscription subscription) {
            this.f432657sd.set(subscription);
        }
    }

    public CompletableOnSubscribeConcatIterable(Iterable<? extends Completable> iterable) {
        this.sources = iterable;
    }

    @Override // rx.functions.Action1
    public void call(Completable.CompletableSubscriber completableSubscriber) {
        try {
            Iterator<? extends Completable> it = this.sources.iterator();
            if (it == null) {
                completableSubscriber.onSubscribe(Subscriptions.unsubscribed());
                completableSubscriber.onError(new NullPointerException("The iterator returned is null"));
            } else {
                ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(completableSubscriber, it);
                completableSubscriber.onSubscribe(concatInnerSubscriber.f432657sd);
                concatInnerSubscriber.next();
            }
        } catch (Throwable th5) {
            completableSubscriber.onSubscribe(Subscriptions.unsubscribed());
            completableSubscriber.onError(th5);
        }
    }
}
