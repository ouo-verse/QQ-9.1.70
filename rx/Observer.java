package rx;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface Observer<T> {
    void onCompleted();

    void onError(Throwable th5);

    void onNext(T t16);
}
