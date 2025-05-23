package t00;

import android.os.SystemClock;
import com.tencent.biz.pubaccount.weishi.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi.player.i;
import com.tencent.biz.pubaccount.weishi.player.l;
import com.tencent.biz.pubaccount.weishi.player.wrapper.WSPlayerDownloadInfo;
import com.tencent.biz.pubaccount.weishi.player.wrapper.j;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.mobileqq.app.ThreadManager;

/* compiled from: P */
/* loaded from: classes36.dex */
public class f implements a {

    /* renamed from: c, reason: collision with root package name */
    private long f435221c;

    /* renamed from: b, reason: collision with root package name */
    private final WSPlayerDownloadInfo f435220b = new WSPlayerDownloadInfo();

    /* renamed from: a, reason: collision with root package name */
    private final c f435219a = new c();

    private void m(WSPlayerDownloadInfo wSPlayerDownloadInfo) {
        j.f81226a.c(this.f435220b, wSPlayerDownloadInfo);
    }

    private void n() {
        x.j("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onInfo] \u64ad\u653e\u72b6\u6001\u56de\u8c03 PLAYER_INFO_CHANGE_HW_BACKUP_URL");
        this.f435219a.W = true;
    }

    private void o() {
        x.j("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onInfo] \u64ad\u653e\u72b6\u6001\u56de\u8c03 PLAYER_INFO_DECODER_BLOCK");
    }

    private void p(Object obj) {
        x.j("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onInfo] \u64ad\u653e\u72b6\u6001\u56de\u8c03 PLAYER_INFO_HW_DECODE_FAILED");
        if (obj instanceof String) {
            this.f435219a.V = (String) obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(String str) {
        c cVar = this.f435219a;
        cVar.M = i.r(cVar.f435196h, cVar.f435198j);
        t(this.f435219a);
        s(str);
    }

    private void s(String str) {
        j.f81226a.e(str);
    }

    private void t(c cVar) {
        x.f("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onStop] mReportData:" + cVar.toString());
        g.c(cVar);
    }

    @Override // t00.a
    public void b(WSPlayerWrapper wSPlayerWrapper, WSPlayerDownloadInfo wSPlayerDownloadInfo) {
        j.f81226a.d(this.f435220b, wSPlayerDownloadInfo);
    }

    @Override // t00.a
    public void c(WSPlayerWrapper wSPlayerWrapper) {
        this.f435219a.f435214z = SystemClock.uptimeMillis() - this.f435221c;
    }

    @Override // t00.a
    public void d(final l lVar, boolean z16, String str) {
        String str2;
        String str3;
        String str4;
        x.j("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onOpenVideo] ==== start ====");
        this.f435221c = !z16 ? SystemClock.uptimeMillis() : 0L;
        c cVar = this.f435219a;
        if (lVar == null) {
            str2 = "";
        } else {
            str2 = lVar.f81166a;
        }
        cVar.f435191c = str2;
        cVar.f435193e = lVar != null ? lVar.f81167b : 0;
        cVar.f435194f = lVar != null ? lVar.f81168c : 0;
        if (lVar == null) {
            str3 = "";
        } else {
            str3 = lVar.f81171f;
        }
        cVar.f435196h = str3;
        if (lVar == null) {
            str4 = "";
        } else {
            str4 = lVar.f81171f;
        }
        cVar.f435197i = i.F(str4);
        c cVar2 = this.f435219a;
        cVar2.f435199k = lVar != null ? lVar.f81169d : 0L;
        cVar2.f435206r = lVar != null ? lVar.f81178m : -1;
        cVar2.F = lVar != null ? lVar.f81179n : -1;
        cVar2.G = lVar != null ? lVar.f81180o : 0;
        cVar2.f435190b = str;
        cVar2.f435209u = false;
        cVar2.f435210v = false;
        cVar2.f435211w = 0;
        cVar2.f435200l = 0;
        cVar2.f435201m = 0;
        cVar2.A = 0;
        cVar2.J = 0L;
        cVar2.I = 0L;
        cVar2.H = "";
        cVar2.T = "";
        cVar2.U = "";
        cVar2.f435195g = "";
        cVar2.V = "";
        cVar2.W = false;
        this.f435220b.I();
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: t00.e
            @Override // java.lang.Runnable
            public final void run() {
                f.this.q(lVar);
            }
        });
    }

    @Override // t00.a
    public void e(WSPlayerWrapper wSPlayerWrapper, WSPlayerDownloadInfo wSPlayerDownloadInfo) {
        m(wSPlayerDownloadInfo);
    }

    @Override // t00.a
    public void f(WSPlayerWrapper wSPlayerWrapper, boolean z16) {
        this.f435219a.f435189a = wSPlayerWrapper.G() instanceof u00.c ? 1 : 0;
        this.f435219a.f435210v = wSPlayerWrapper.c0();
        this.f435219a.f435195g = wSPlayerWrapper.S();
        this.f435219a.f435198j = wSPlayerWrapper.E();
        this.f435219a.f435202n = wSPlayerWrapper.R();
        this.f435219a.f435203o = wSPlayerWrapper.I().getVideoCodec();
        this.f435219a.f435204p = wSPlayerWrapper.I().getVideoProfile();
        this.f435219a.f435205q = wSPlayerWrapper.I().getVideoFps();
        this.f435219a.f435207s = wSPlayerWrapper.I().getAudioCodec();
        this.f435219a.f435208t = wSPlayerWrapper.I().getAudioProfile();
        this.f435219a.A = wSPlayerWrapper.M();
        this.f435219a.f435213y = wSPlayerWrapper.K();
        this.f435219a.f435212x = wSPlayerWrapper.L();
        this.f435219a.H = wSPlayerWrapper.O();
        this.f435219a.K = wSPlayerWrapper.y();
        this.f435219a.I = wSPlayerWrapper.F();
        this.f435219a.J = wSPlayerWrapper.H();
        this.f435219a.B = wSPlayerWrapper.J();
        this.f435219a.C = wSPlayerWrapper.A(z16);
        c cVar = this.f435219a;
        j jVar = j.f81226a;
        cVar.L = jVar.f(this.f435220b);
        c cVar2 = this.f435219a;
        final String q16 = i.q(cVar2.f435196h, cVar2.f435198j);
        c cVar3 = this.f435219a;
        cVar3.f435192d = q16;
        cVar3.N = jVar.b(q16);
        this.f435219a.D = com.tencent.biz.pubaccount.weishi.config.experiment.b.h().a();
        this.f435219a.E = wSPlayerWrapper.C();
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: t00.d
            @Override // java.lang.Runnable
            public final void run() {
                f.this.r(q16);
            }
        });
    }

    @Override // t00.a
    public void g(WSPlayerWrapper wSPlayerWrapper) {
        this.f435219a.f435200l = wSPlayerWrapper != null ? wSPlayerWrapper.V() : 0;
        this.f435219a.f435201m = wSPlayerWrapper != null ? wSPlayerWrapper.T() : 0;
    }

    @Override // t00.a
    public void h(int i3) {
        this.f435219a.f435211w = i3;
    }

    @Override // t00.a
    public void i(boolean z16) {
        x.j("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onHitPreload] loaded:" + z16);
        this.f435221c = SystemClock.uptimeMillis();
        this.f435219a.f435209u = z16;
    }

    @Override // t00.a
    public void j(int i3, int i16, int i17) {
        this.f435219a.P = s00.f.f433060d.m();
        c cVar = this.f435219a;
        cVar.Q = i3;
        cVar.R = i16;
        cVar.S = i17;
    }

    @Override // t00.a
    public void onError(int i3, int i16, String str) {
        this.f435219a.T = i3 + ":" + i16;
        this.f435219a.U = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(l lVar) {
        String str;
        if (lVar != null) {
            str = lVar.f81171f;
        } else {
            str = "";
        }
        this.f435219a.O = i.r(str, lVar != null ? lVar.f81170e : 0L);
    }

    @Override // t00.a
    public void a(int i3, Object obj) {
        if (i3 == 28) {
            o();
        } else if (i3 == 39) {
            p(obj);
        } else {
            if (i3 != 41) {
                return;
            }
            n();
        }
    }
}
