package rx.observers;

import rx.Completable;
import rx.Subscription;
import rx.annotations.Experimental;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.plugins.RxJavaHooks;

/* compiled from: P */
@Experimental
/* loaded from: classes29.dex */
public final class SafeCompletableSubscriber implements Completable.CompletableSubscriber, Subscription {
    final Completable.CompletableSubscriber actual;
    boolean done;

    /* renamed from: s, reason: collision with root package name */
    Subscription f432874s;

    public SafeCompletableSubscriber(Completable.CompletableSubscriber completableSubscriber) {
        this.actual = completableSubscriber;
    }

    @Override // rx.Subscription
    public boolean isUnsubscribed() {
        if (!this.done && !this.f432874s.isUnsubscribed()) {
            return false;
        }
        return true;
    }

    @Override // rx.Completable.CompletableSubscriber
    public void onCompleted() {
        if (this.done) {
            return;
        }
        this.done = true;
        try {
            this.actual.onCompleted();
        } catch (Throwable th5) {
            Exceptions.throwIfFatal(th5);
            throw new OnCompletedFailedException(th5);
        }
    }

    @Override // rx.Completable.CompletableSubscriber
    public void onError(Throwable th5) {
        RxJavaHooks.onError(th5);
        if (this.done) {
            return;
        }
        this.done = true;
        try {
            this.actual.onError(th5);
        } catch (Throwable th6) {
            Exceptions.throwIfFatal(th6);
            throw new OnErrorFailedException(new CompositeException(th5, th6));
        }
    }

    @Override // rx.Completable.CompletableSubscriber
    public void onSubscribe(Subscription subscription) {
        this.f432874s = subscription;
        try {
            this.actual.onSubscribe(this);
        } catch (Throwable th5) {
            Exceptions.throwIfFatal(th5);
            subscription.unsubscribe();
            onError(th5);
        }
    }

    @Override // rx.Subscription
    public void unsubscribe() {
        this.f432874s.unsubscribe();
    }
}
