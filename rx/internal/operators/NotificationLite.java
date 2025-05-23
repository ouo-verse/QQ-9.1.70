package rx.internal.operators;

import java.io.Serializable;
import rx.Notification;
import rx.Observer;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class NotificationLite<T> {
    private static final NotificationLite INSTANCE = new NotificationLite();
    private static final Object ON_COMPLETED_SENTINEL = new Serializable() { // from class: rx.internal.operators.NotificationLite.1
        private static final long serialVersionUID = 1;

        public String toString() {
            return "Notification=>Completed";
        }
    };
    private static final Object ON_NEXT_NULL_SENTINEL = new Serializable() { // from class: rx.internal.operators.NotificationLite.2
        private static final long serialVersionUID = 2;

        public String toString() {
            return "Notification=>NULL";
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class OnErrorSentinel implements Serializable {
        private static final long serialVersionUID = 3;

        /* renamed from: e, reason: collision with root package name */
        final Throwable f432659e;

        public OnErrorSentinel(Throwable th5) {
            this.f432659e = th5;
        }

        public String toString() {
            return "Notification=>Error:" + this.f432659e;
        }
    }

    NotificationLite() {
    }

    public static <T> NotificationLite<T> instance() {
        return INSTANCE;
    }

    public boolean accept(Observer<? super T> observer, Object obj) {
        if (obj == ON_COMPLETED_SENTINEL) {
            observer.onCompleted();
            return true;
        }
        if (obj == ON_NEXT_NULL_SENTINEL) {
            observer.onNext(null);
            return false;
        }
        if (obj != null) {
            if (obj.getClass() == OnErrorSentinel.class) {
                observer.onError(((OnErrorSentinel) obj).f432659e);
                return true;
            }
            observer.onNext(obj);
            return false;
        }
        throw new IllegalArgumentException("The lite notification can not be null");
    }

    public Object completed() {
        return ON_COMPLETED_SENTINEL;
    }

    public Object error(Throwable th5) {
        return new OnErrorSentinel(th5);
    }

    public Throwable getError(Object obj) {
        return ((OnErrorSentinel) obj).f432659e;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T getValue(Object obj) {
        if (obj == ON_NEXT_NULL_SENTINEL) {
            return null;
        }
        return obj;
    }

    public boolean isCompleted(Object obj) {
        if (obj == ON_COMPLETED_SENTINEL) {
            return true;
        }
        return false;
    }

    public boolean isError(Object obj) {
        return obj instanceof OnErrorSentinel;
    }

    public boolean isNext(Object obj) {
        if (obj != null && !isError(obj) && !isCompleted(obj)) {
            return true;
        }
        return false;
    }

    public boolean isNull(Object obj) {
        if (obj == ON_NEXT_NULL_SENTINEL) {
            return true;
        }
        return false;
    }

    public Notification.Kind kind(Object obj) {
        if (obj != null) {
            if (obj == ON_COMPLETED_SENTINEL) {
                return Notification.Kind.OnCompleted;
            }
            if (obj instanceof OnErrorSentinel) {
                return Notification.Kind.OnError;
            }
            return Notification.Kind.OnNext;
        }
        throw new IllegalArgumentException("The lite notification can not be null");
    }

    public Object next(T t16) {
        if (t16 == null) {
            return ON_NEXT_NULL_SENTINEL;
        }
        return t16;
    }
}
