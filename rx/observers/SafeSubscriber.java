package rx.observers;

import java.util.Arrays;
import rx.Subscriber;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.exceptions.UnsubscribeFailedException;
import rx.plugins.RxJavaHooks;

/* compiled from: P */
/* loaded from: classes29.dex */
public class SafeSubscriber<T> extends Subscriber<T> {
    private final Subscriber<? super T> actual;
    boolean done;

    public SafeSubscriber(Subscriber<? super T> subscriber) {
        super(subscriber);
        this.actual = subscriber;
    }

    protected void _onError(Throwable th5) {
        RxJavaHooks.onError(th5);
        try {
            this.actual.onError(th5);
            try {
                unsubscribe();
            } catch (Throwable th6) {
                RxJavaHooks.onError(th6);
                throw new OnErrorFailedException(th6);
            }
        } catch (OnErrorNotImplementedException e16) {
            try {
                unsubscribe();
                throw e16;
            } catch (Throwable th7) {
                RxJavaHooks.onError(th7);
                throw new OnErrorNotImplementedException("Observer.onError not implemented and error while unsubscribing.", new CompositeException(Arrays.asList(th5, th7)));
            }
        } catch (Throwable th8) {
            RxJavaHooks.onError(th8);
            try {
                unsubscribe();
                throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError", new CompositeException(Arrays.asList(th5, th8)));
            } catch (Throwable th9) {
                RxJavaHooks.onError(th9);
                throw new OnErrorFailedException("Error occurred when trying to propagate error to Observer.onError and during unsubscription.", new CompositeException(Arrays.asList(th5, th8, th9)));
            }
        }
    }

    public Subscriber<? super T> getActual() {
        return this.actual;
    }

    @Override // rx.Observer
    public void onCompleted() {
        UnsubscribeFailedException unsubscribeFailedException;
        if (!this.done) {
            this.done = true;
            try {
                this.actual.onCompleted();
                try {
                    unsubscribe();
                } finally {
                }
            } catch (Throwable th5) {
                try {
                    Exceptions.throwIfFatal(th5);
                    RxJavaHooks.onError(th5);
                    throw new OnCompletedFailedException(th5.getMessage(), th5);
                } catch (Throwable th6) {
                    try {
                        unsubscribe();
                        throw th6;
                    } finally {
                    }
                }
            }
        }
    }

    @Override // rx.Observer
    public void onError(Throwable th5) {
        Exceptions.throwIfFatal(th5);
        if (!this.done) {
            this.done = true;
            _onError(th5);
        }
    }

    @Override // rx.Observer
    public void onNext(T t16) {
        try {
            if (!this.done) {
                this.actual.onNext(t16);
            }
        } catch (Throwable th5) {
            Exceptions.throwOrReport(th5, this);
        }
    }
}
