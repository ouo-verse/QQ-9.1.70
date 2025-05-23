package rx.subjects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import rx.Observable;
import rx.annotations.Beta;
import rx.exceptions.Exceptions;
import rx.functions.Action1;
import rx.internal.operators.NotificationLite;
import rx.subjects.SubjectSubscriptionManager;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class BehaviorSubject<T> extends Subject<T, T> {
    private static final Object[] EMPTY_ARRAY = new Object[0];

    /* renamed from: nl, reason: collision with root package name */
    private final NotificationLite<T> f432879nl;
    private final SubjectSubscriptionManager<T> state;

    protected BehaviorSubject(Observable.OnSubscribe<T> onSubscribe, SubjectSubscriptionManager<T> subjectSubscriptionManager) {
        super(onSubscribe);
        this.f432879nl = NotificationLite.instance();
        this.state = subjectSubscriptionManager;
    }

    public static <T> BehaviorSubject<T> create() {
        return create(null, false);
    }

    @Beta
    public Throwable getThrowable() {
        Object latest = this.state.getLatest();
        if (this.f432879nl.isError(latest)) {
            return this.f432879nl.getError(latest);
        }
        return null;
    }

    @Beta
    public T getValue() {
        Object latest = this.state.getLatest();
        if (this.f432879nl.isNext(latest)) {
            return this.f432879nl.getValue(latest);
        }
        return null;
    }

    @Beta
    public T[] getValues(T[] tArr) {
        Object latest = this.state.getLatest();
        if (this.f432879nl.isNext(latest)) {
            if (tArr.length == 0) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
            }
            tArr[0] = this.f432879nl.getValue(latest);
            if (tArr.length > 1) {
                tArr[1] = null;
            }
        } else if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }

    @Beta
    public boolean hasCompleted() {
        return this.f432879nl.isCompleted(this.state.getLatest());
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
        return this.f432879nl.isError(this.state.getLatest());
    }

    @Beta
    public boolean hasValue() {
        return this.f432879nl.isNext(this.state.getLatest());
    }

    @Override // rx.Observer
    public void onCompleted() {
        if (this.state.getLatest() == null || this.state.active) {
            Object completed = this.f432879nl.completed();
            for (SubjectSubscriptionManager.SubjectObserver<T> subjectObserver : this.state.terminate(completed)) {
                subjectObserver.emitNext(completed, this.state.f432881nl);
            }
        }
    }

    @Override // rx.Observer
    public void onError(Throwable th5) {
        if (this.state.getLatest() == null || this.state.active) {
            Object error = this.f432879nl.error(th5);
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
        if (this.state.getLatest() == null || this.state.active) {
            Object next = this.f432879nl.next(t16);
            for (SubjectSubscriptionManager.SubjectObserver<T> subjectObserver : this.state.next(next)) {
                subjectObserver.emitNext(next, this.state.f432881nl);
            }
        }
    }

    int subscriberCount() {
        return this.state.observers().length;
    }

    public static <T> BehaviorSubject<T> create(T t16) {
        return create(t16, true);
    }

    private static <T> BehaviorSubject<T> create(T t16, boolean z16) {
        final SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        if (z16) {
            subjectSubscriptionManager.setLatest(NotificationLite.instance().next(t16));
        }
        Action1<SubjectSubscriptionManager.SubjectObserver<T>> action1 = new Action1<SubjectSubscriptionManager.SubjectObserver<T>>() { // from class: rx.subjects.BehaviorSubject.1
            @Override // rx.functions.Action1
            public void call(SubjectSubscriptionManager.SubjectObserver<T> subjectObserver) {
                subjectObserver.emitFirst(SubjectSubscriptionManager.this.getLatest(), SubjectSubscriptionManager.this.f432881nl);
            }
        };
        subjectSubscriptionManager.onAdded = action1;
        subjectSubscriptionManager.onTerminated = action1;
        return new BehaviorSubject<>(subjectSubscriptionManager, subjectSubscriptionManager);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Beta
    public Object[] getValues() {
        Object[] objArr = EMPTY_ARRAY;
        Object[] values = getValues(objArr);
        return values == objArr ? new Object[0] : values;
    }
}
