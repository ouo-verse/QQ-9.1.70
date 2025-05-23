package rx;

import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Notification<T> {
    private static final Notification<Void> ON_COMPLETED = new Notification<>(Kind.OnCompleted, null, null);
    private final Kind kind;
    private final Throwable throwable;
    private final T value;

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public enum Kind {
        OnNext,
        OnError,
        OnCompleted
    }

    Notification(Kind kind, T t16, Throwable th5) {
        this.value = t16;
        this.throwable = th5;
        this.kind = kind;
    }

    public static <T> Notification<T> createOnCompleted() {
        return (Notification<T>) ON_COMPLETED;
    }

    public static <T> Notification<T> createOnError(Throwable th5) {
        return new Notification<>(Kind.OnError, null, th5);
    }

    public static <T> Notification<T> createOnNext(T t16) {
        return new Notification<>(Kind.OnNext, t16, null);
    }

    public void accept(Observer<? super T> observer) {
        Kind kind = this.kind;
        if (kind == Kind.OnNext) {
            observer.onNext(getValue());
        } else if (kind == Kind.OnCompleted) {
            observer.onCompleted();
        } else {
            observer.onError(getThrowable());
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != Notification.class) {
            return false;
        }
        Notification notification = (Notification) obj;
        if (notification.getKind() != getKind()) {
            return false;
        }
        T t16 = this.value;
        T t17 = notification.value;
        if (t16 != t17 && (t16 == null || !t16.equals(t17))) {
            return false;
        }
        Throwable th5 = this.throwable;
        Throwable th6 = notification.throwable;
        if (th5 != th6 && (th5 == null || !th5.equals(th6))) {
            return false;
        }
        return true;
    }

    public Kind getKind() {
        return this.kind;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public T getValue() {
        return this.value;
    }

    public boolean hasThrowable() {
        if (isOnError() && this.throwable != null) {
            return true;
        }
        return false;
    }

    public boolean hasValue() {
        if (isOnNext() && this.value != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = getKind().hashCode();
        if (hasValue()) {
            hashCode = (hashCode * 31) + getValue().hashCode();
        }
        if (hasThrowable()) {
            return (hashCode * 31) + getThrowable().hashCode();
        }
        return hashCode;
    }

    public boolean isOnCompleted() {
        if (getKind() == Kind.OnCompleted) {
            return true;
        }
        return false;
    }

    public boolean isOnError() {
        if (getKind() == Kind.OnError) {
            return true;
        }
        return false;
    }

    public boolean isOnNext() {
        if (getKind() == Kind.OnNext) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder(64);
        sb5.append('[');
        sb5.append(super.toString());
        sb5.append(TokenParser.SP);
        sb5.append(getKind());
        if (hasValue()) {
            sb5.append(TokenParser.SP);
            sb5.append(getValue());
        }
        if (hasThrowable()) {
            sb5.append(TokenParser.SP);
            sb5.append(getThrowable().getMessage());
        }
        sb5.append(']');
        return sb5.toString();
    }

    public static <T> Notification<T> createOnCompleted(Class<T> cls) {
        return (Notification<T>) ON_COMPLETED;
    }
}
