package rx.internal.util;

import rx.Notification;
import rx.Observer;
import rx.functions.Action1;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ActionNotificationObserver<T> implements Observer<T> {
    final Action1<Notification<? super T>> onNotification;

    public ActionNotificationObserver(Action1<Notification<? super T>> action1) {
        this.onNotification = action1;
    }

    @Override // rx.Observer
    public void onCompleted() {
        this.onNotification.call(Notification.createOnCompleted());
    }

    @Override // rx.Observer
    public void onError(Throwable th5) {
        this.onNotification.call(Notification.createOnError(th5));
    }

    @Override // rx.Observer
    public void onNext(T t16) {
        this.onNotification.call(Notification.createOnNext(t16));
    }
}
