package rx.subjects;

import java.util.ArrayList;
import rx.Observable;
import rx.annotations.Beta;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;

/* loaded from: classes29.dex */
public final class PublishSubject<T> extends Subject<T, T> {

    /* renamed from: nl, reason: collision with root package name */
    private final NotificationLite<T> f432880nl;
    final SubjectSubscriptionManager<T> state;

    protected PublishSubject(Observable.OnSubscribe<T> onSubscribe, SubjectSubscriptionManager<T> subjectSubscriptionManager) {
        super(onSubscribe);
        this.f432880nl = NotificationLite.instance();
        this.state = subjectSubscriptionManager;
    }

    public static <T> PublishSubject<T> create() {
        final SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        subjectSubscriptionManager.onTerminated = new Action1<SubjectSubscriptionManager.SubjectObserver<T>>() { // from class: rx.subjects.PublishSubject.1
            @Override // rx.functions.Action1
            public void call(SubjectSubscriptionManager.SubjectObserver<T> subjectObserver) {
                subjectObserver.emitFirst(SubjectSubscriptionManager.this.getLatest(), SubjectSubscriptionManager.this.f432881nl);
            }
        };
        return new PublishSubject<>(subjectSubscriptionManager, subjectSubscriptionManager);
    }

    @Beta
    public Throwable getThrowable() {
        Object latest = this.state.getLatest();
        if (this.f432880nl.isError(latest)) {
            return this.f432880nl.getError(latest);
        }
        return null;
    }

    @Beta
    public boolean hasCompleted() {
        Object latest = this.state.getLatest();
        if (latest != null && !this.f432880nl.isError(latest)) {
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
        return this.f432880nl.isError(this.state.getLatest());
    }

    @Override // rx.Observer
    public void onCompleted() {
        if (this.state.active) {
            Object completed = this.f432880nl.completed();
            for (SubjectSubscriptionManager.SubjectObserver<T> subjectObserver : this.state.terminate(completed)) {
                subjectObserver.emitNext(completed, this.state.f432881nl);
            }
        }
    }

    @Override // rx.Observer
    public void onError(Throwable th5) {
        if (this.state.active) {
            Object error = this.f432880nl.error(th5);
            ArrayList arrayList = null;
            for (SubjectSubscriptionManager.SubjectObserver<T> subjectObserver : this.state.terminate(error)) {
                try {
                    subjectObserver.emitNext(error, this.state.f432881nl);
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
        for (SubjectSubscriptionManager.SubjectObserver<T> subjectObserver : this.state.observers()) {
            subjectObserver.onNext(t16);
        }
    }
}
