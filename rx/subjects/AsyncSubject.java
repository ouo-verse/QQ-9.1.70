package rx.subjects;

import java.util.ArrayList;
import rx.Observable;
import rx.annotations.Beta;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.internal.operators.NotificationLite;
import rx.internal.producers.SingleProducer;
import rx.subjects.SubjectSubscriptionManager;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class AsyncSubject<T> extends Subject<T, T> {
    volatile Object lastValue;

    /* renamed from: nl, reason: collision with root package name */
    private final NotificationLite<T> f432878nl;
    final SubjectSubscriptionManager<T> state;

    protected AsyncSubject(Observable.OnSubscribe<T> onSubscribe, SubjectSubscriptionManager<T> subjectSubscriptionManager) {
        super(onSubscribe);
        this.f432878nl = NotificationLite.instance();
        this.state = subjectSubscriptionManager;
    }

    public static <T> AsyncSubject<T> create() {
        final SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        subjectSubscriptionManager.onTerminated = new Action1<SubjectSubscriptionManager.SubjectObserver<T>>() { // from class: rx.subjects.AsyncSubject.1
            @Override // rx.functions.Action1
            public void call(SubjectSubscriptionManager.SubjectObserver<T> subjectObserver) {
                Object latest = SubjectSubscriptionManager.this.getLatest();
                NotificationLite<T> notificationLite = SubjectSubscriptionManager.this.f432881nl;
                if (latest != null && !notificationLite.isCompleted(latest)) {
                    if (notificationLite.isError(latest)) {
                        subjectObserver.onError(notificationLite.getError(latest));
                        return;
                    } else {
                        subjectObserver.actual.setProducer(new SingleProducer(subjectObserver.actual, notificationLite.getValue(latest)));
                        return;
                    }
                }
                subjectObserver.onCompleted();
            }
        };
        return new AsyncSubject<>(subjectSubscriptionManager, subjectSubscriptionManager);
    }

    @Beta
    public Throwable getThrowable() {
        Object latest = this.state.getLatest();
        if (this.f432878nl.isError(latest)) {
            return this.f432878nl.getError(latest);
        }
        return null;
    }

    @Beta
    public T getValue() {
        Object obj = this.lastValue;
        if (!this.f432878nl.isError(this.state.getLatest()) && this.f432878nl.isNext(obj)) {
            return this.f432878nl.getValue(obj);
        }
        return null;
    }

    @Beta
    public boolean hasCompleted() {
        Object latest = this.state.getLatest();
        if (latest != null && !this.f432878nl.isError(latest)) {
            return true;
        }
        return false;
    }

    @Override // rx.subjects.Subject
    public boolean hasObservers() {
        if (this.state.observers().length > 0) {
            return true;
        }
        return false;
    }

    @Beta
    public boolean hasThrowable() {
        return this.f432878nl.isError(this.state.getLatest());
    }

    @Beta
    public boolean hasValue() {
        Object obj = this.lastValue;
        if (!this.f432878nl.isError(this.state.getLatest()) && this.f432878nl.isNext(obj)) {
            return true;
        }
        return false;
    }

    @Override // rx.Observer
    public void onCompleted() {
        if (this.state.active) {
            Object obj = this.lastValue;
            if (obj == null) {
                obj = this.f432878nl.completed();
            }
            for (SubjectSubscriptionManager.SubjectObserver<T> subjectObserver : this.state.terminate(obj)) {
                if (obj == this.f432878nl.completed()) {
                    subjectObserver.onCompleted();
                } else {
                    subjectObserver.actual.setProducer(new SingleProducer(subjectObserver.actual, this.f432878nl.getValue(obj)));
                }
            }
        }
    }

    @Override // rx.Observer
    public void onError(Throwable th5) {
        if (this.state.active) {
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager.SubjectObserver<T> subjectObserver : this.state.terminate(this.f432878nl.error(th5))) {
                try {
                    subjectObserver.onError(th5);
                } catch (Throwable th6) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th6);
                }
            }
            Exceptions.throwIfAny(arrayList);
        }
    }

    @Override // rx.Observer
    public void onNext(T t16) {
        this.lastValue = this.f432878nl.next(t16);
    }
}
