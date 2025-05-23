package r92;

import android.view.View;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface a {

    /* compiled from: P */
    /* renamed from: r92.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public interface InterfaceC11126a {
        void a(a aVar);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface b {
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface c {
        boolean a(a aVar, int i3, int i16, int i17, String str, Object obj);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface d {
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface e {
        void a(a aVar);
    }

    void a(String str, String str2, String str3, long j3);

    void b(c cVar);

    void c(b bVar);

    void d(InterfaceC11126a interfaceC11126a);

    void e();

    void f(d dVar);

    void g(e eVar);

    long getCurrentPosition();

    long getDuration();

    int getProgress();

    View getView();

    boolean isPlaying();

    void pause();

    void restart();

    void seekTo(long j3);

    void start();
}
