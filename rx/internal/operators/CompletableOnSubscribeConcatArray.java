package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.Subscription;
import rx.subscriptions.SerialSubscription;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class CompletableOnSubscribeConcatArray implements Completable.CompletableOnSubscribe {
    final Completable[] sources;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class ConcatInnerSubscriber extends AtomicInteger implements Completable.CompletableSubscriber {
        private static final long serialVersionUID = -7965400327305809232L;
        final Completable.CompletableSubscriber actual;
        int index;

        /* renamed from: sd, reason: collision with root package name */
        final SerialSubscription f432656sd = new SerialSubscription();
        final Completable[] sources;

        public ConcatInnerSubscriber(Completable.CompletableSubscriber completableSubscriber, Completable[] completableArr) {
            this.actual = completableSubscriber;
            this.sources = completableArr;
        }

        void next() {
            if (this.f432656sd.isUnsubscribed() || getAndIncrement() != 0) {
                return;
            }
            Completable[] completableArr = this.sources;
            while (!this.f432656sd.isUnsubscribed()) {
                int i3 = this.index;
                this.index = i3 + 1;
                if (i3 == completableArr.length) {
                    this.actual.onCompleted();
                    return;
                } else {
                    completableArr[i3].unsafeSubscribe(this);
                    if (decrementAndGet() == 0) {
                        return;
                    }
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
            this.f432656sd.set(subscription);
        }
    }

    public CompletableOnSubscribeConcatArray(Completable[] completableArr) {
        this.sources = completableArr;
    }

    @Override // rx.functions.Action1
    public void call(Completable.CompletableSubscriber completableSubscriber) {
        ConcatInnerSubscriber concatInnerSubscriber = new ConcatInnerSubscriber(completableSubscriber, this.sources);
        completableSubscriber.onSubscribe(concatInnerSubscriber.f432656sd);
        concatInnerSubscriber.next();
    }
}
