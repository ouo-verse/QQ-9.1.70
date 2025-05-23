package vv;

import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.qavperf.manager.QAVPCpuManager;
import com.tencent.av.qavperf.manager.QAVPFpsManager;
import com.tencent.av.qavperf.manager.QAVPMemoryManager;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b implements a {

    /* renamed from: a, reason: collision with root package name */
    private final QAVPFpsManager f443584a;

    /* renamed from: b, reason: collision with root package name */
    private final QAVPMemoryManager f443585b;

    /* renamed from: c, reason: collision with root package name */
    private final QAVPCpuManager f443586c;

    public b(VideoAppInterface videoAppInterface) {
        this.f443584a = new QAVPFpsManager(videoAppInterface);
        this.f443585b = new QAVPMemoryManager(videoAppInterface);
        this.f443586c = new QAVPCpuManager(videoAppInterface);
    }

    @Override // vv.a
    public void a(SessionInfo sessionInfo) {
        this.f443584a.j(sessionInfo);
    }

    @Override // vv.a
    public void b(SessionInfo sessionInfo) {
        this.f443585b.j(sessionInfo);
        xv.a.f448737f = true;
    }

    @Override // vv.a
    public void c(SessionInfo sessionInfo) {
        this.f443586c.i(sessionInfo);
        xv.a.f448739h = true;
    }

    @Override // vv.a
    public void d(SessionInfo sessionInfo) {
        this.f443584a.i(sessionInfo);
        xv.a.f448738g = true;
    }

    @Override // vv.a
    public void e(SessionInfo sessionInfo) {
        this.f443586c.j(sessionInfo);
    }

    @Override // vv.a
    public void f(SessionInfo sessionInfo) {
        this.f443585b.l(sessionInfo);
    }
}
