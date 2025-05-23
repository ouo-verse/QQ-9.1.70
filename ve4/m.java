package ve4;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface m extends ue4.a {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface a {
    }

    String C();

    void asyncRunInRequestThread(Runnable runnable);

    void l(Runnable runnable);

    void m(Runnable runnable);

    void onDestroy();

    void syncRunInRequestThread(a aVar, long j3);
}
