package pu2;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.c;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.f;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.g;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.player.b;
import com.tencent.qqlive.playerinterface.QAdUserInfo;
import java.lang.ref.WeakReference;
import java.util.Map;
import kt3.d;
import kt3.j;
import nu2.e;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends f implements c.a {

    /* renamed from: k, reason: collision with root package name */
    private static String f427384k;

    /* renamed from: b, reason: collision with root package name */
    private volatile WeakReference<Context> f427385b;

    /* renamed from: c, reason: collision with root package name */
    private volatile ViewGroup f427386c;

    /* renamed from: d, reason: collision with root package name */
    private volatile QAdUserInfo f427387d;

    /* renamed from: e, reason: collision with root package name */
    private volatile j f427388e;

    /* renamed from: f, reason: collision with root package name */
    private volatile c f427389f;

    /* renamed from: g, reason: collision with root package name */
    private volatile String f427390g;

    /* renamed from: h, reason: collision with root package name */
    private volatile boolean f427391h = false;

    /* renamed from: i, reason: collision with root package name */
    private Map<String, Object> f427392i;

    /* renamed from: j, reason: collision with root package name */
    private nu2.j f427393j;

    public a(Context context, ViewGroup viewGroup) {
        String str = "[QAd]QAdManager" + hashCode();
        f427384k = str;
        n.e(str, "create QAdManager");
        B(context, viewGroup);
    }

    private synchronized void A() {
        if (this.f427389f != null) {
            this.f427389f.E();
        }
    }

    private void B(Context context, ViewGroup viewGroup) {
        Context context2;
        this.f427386c = viewGroup;
        if (context != null) {
            context2 = context.getApplicationContext();
        } else {
            context2 = null;
        }
        this.f427385b = new WeakReference<>(context2);
    }

    private synchronized boolean C() {
        boolean z16;
        if (this.f427387d != null) {
            if (this.f427388e != null) {
                z16 = true;
            }
        }
        z16 = false;
        return z16;
    }

    private void F(int i3, int i16) {
        n.e(f427384k, "onVideoAdFinish, adType = " + i3);
        u(i16);
    }

    private synchronized void H() {
        n.e(f427384k, "release");
        this.f427385b = null;
        if (this.f427389f != null) {
            this.f427389f.P(null);
            this.f427389f.Q(null);
        }
        nu2.j jVar = this.f427393j;
        if (jVar != null) {
            jVar.s();
        }
        e.z().c(null);
    }

    private synchronized void J() {
        H();
        t();
        K();
    }

    private synchronized void K() {
        n.e(f427384k, "resetParams");
        this.f427386c = null;
        this.f427387d = null;
        this.f427388e = null;
        this.f427389f = null;
        this.f427390g = null;
        this.f427391h = false;
        this.f427392i = null;
        this.f303622a = null;
    }

    public static void L(kt3.c cVar) {
        n.e(f427384k, "setQAdMediaPlayerCreator() QAD_TVKPlayer\u6ce8\u518c\u6210\u529f");
        b.e(cVar);
    }

    private synchronized void Q(long j3) {
        if (this.f427389f != null) {
            this.f427389f.V(j3);
        }
        if (this.f427388e != null) {
            this.f427388e.s(j3);
        }
    }

    private synchronized boolean q(@Nullable Context context) {
        if (C() && context != null) {
            return true;
        }
        n.e(f427384k, "isCanLoadMidAd, params is not valid");
        return false;
    }

    private boolean r(Object obj, Context context) {
        if (!q(context)) {
            n.e(f427384k, "handleMidVideoAd, can't load mid ad");
            return true;
        }
        if (!(obj instanceof com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.a)) {
            n.e(f427384k, "handleMidVideoAd, params is not AdAnchorItemWrapper");
            return true;
        }
        return false;
    }

    private void u(int i3) {
        n.e(f427384k, "closeCurrentAd: base=" + this.f427389f + ", this=" + this);
        c cVar = this.f427389f;
        if (cVar != null) {
            cVar.s(i3);
            cVar.N();
            this.f427389f = null;
        }
    }

    private synchronized void w(Object obj) {
        Context context;
        n.e(f427384k, "handleMidVideoAd");
        if (this.f427385b == null) {
            context = null;
        } else {
            context = this.f427385b.get();
        }
        if (r(obj, context)) {
            return;
        }
        if (this.f427389f == null) {
            g gVar = new g(context, this.f427386c);
            this.f427389f = gVar;
            n.e(f427384k, "handleMidVideoAd, create new mid impl");
            gVar.b0(this.f427392i);
            gVar.d0((com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.a) obj);
            gVar.U(this.f427388e);
            gVar.T(this.f427387d);
            gVar.S(this.f427390g);
            gVar.O(this.f427391h);
            gVar.P(this);
            gVar.Q(this);
            gVar.Y(((com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.a) obj).b());
        }
    }

    private void y(Object obj) {
        Context context;
        n.e(f427384k, "handleRewardAd");
        if (!(obj instanceof com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.g)) {
            return;
        }
        if (this.f427385b == null) {
            context = null;
        } else {
            context = this.f427385b.get();
        }
        this.f427393j = new nu2.j(context, this.f427386c);
        n.e(f427384k, "handleRewardAd, create new reward impl");
        this.f427393j.t(this);
        this.f427393j.n((com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.g) obj);
    }

    private void z(int i3) {
        nu2.j jVar = this.f427393j;
        if (jVar == null) {
            return;
        }
        jVar.q(i3);
    }

    public void D() {
        n.e(f427384k, "notifyInsideDynamicAdManagerUpdate");
        e.z().d(this.f427385b.get());
        e.z().f(this.f427386c);
    }

    public void E(int i3, int i16, int i17, String str, Object obj) {
        p(i3, i16, i17, str, obj);
    }

    public synchronized boolean G() {
        n.e(f427384k, "pauseAd");
        if (this.f427389f != null) {
            this.f427389f.M();
        }
        return false;
    }

    public synchronized void I() {
        n.e(f427384k, "releaseAd");
        if (this.f427389f != null) {
            this.f427389f.K(1);
        }
        n.e(f427384k, "releaseAd async");
        J();
    }

    public synchronized void M(d dVar) {
        this.f303622a = dVar;
        e.z().c(this);
    }

    public synchronized boolean N() {
        n.e(f427384k, "startAd");
        if (this.f427389f != null) {
            return this.f427389f.R();
        }
        return false;
    }

    public void O() {
        n.e(f427384k, "startMidIfNeed");
        e.z().N();
    }

    public synchronized void P(String str) {
        n.e(f427384k, "updateDefinition, lastDef = " + this.f427390g + ", curDef = " + str);
        this.f427390g = str;
        e.z().e(str);
        if (this.f427389f != null) {
            this.f427389f.S(str);
        }
    }

    public synchronized void R(QAdUserInfo qAdUserInfo) {
        n.e(f427384k, "updateUserInfo");
        this.f427387d = qAdUserInfo;
        e.z().g(qAdUserInfo);
        if (this.f427389f != null) {
            this.f427389f.T(qAdUserInfo);
        }
    }

    public void S(j jVar) {
        String str;
        this.f427388e = jVar;
        String str2 = f427384k;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("updateVideoInfo, ");
        if (jVar != null) {
            str = jVar.toString();
        } else {
            str = "";
        }
        sb5.append(str);
        n.e(str2, sb5.toString());
        e.z().R(jVar);
        c cVar = this.f427389f;
        if (cVar != null) {
            cVar.U(jVar);
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.QAdAbstractMgrListener, kt3.d
    public void d(int i3, long j3, boolean z16, boolean z17, int i16) {
        if (z16) {
            s(1);
        }
        super.d(i3, j3, z16, z17, i16);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.c.a
    public synchronized void n(int i3, int i16) {
        n.e(f427384k, "onVideoAdFinish sync");
        F(i3, i16);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.f
    protected void p(int i3, int i16, int i17, String str, Object obj) {
        e.z().o(i3, i16, i17, str, obj);
        z(i3);
        if (i3 != 1) {
            if (i3 != 5) {
                if (i3 != 12) {
                    if (i3 != 16) {
                        if (i3 != 10008) {
                            if (i3 == 10019) {
                                y(obj);
                                return;
                            }
                            return;
                        }
                        w(obj);
                        return;
                    }
                    x();
                    return;
                }
                Q(((Long) obj).longValue());
                return;
            }
            A();
            return;
        }
        D();
    }

    public synchronized void s(int i3) {
        n.e(f427384k, "closeAd");
        if (this.f427389f != null) {
            this.f427389f.K(i3);
        }
    }

    public void t() {
        n.e(f427384k, "closeAllDynamicMidAd");
    }

    public void v(com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.f fVar, nu2.b bVar) {
        Context context;
        if (this.f427393j == null) {
            n.e(f427384k, "enterRewardAd invalid, create QAdRewardUnlockImpl right now");
            if (this.f427385b == null) {
                context = null;
            } else {
                context = this.f427385b.get();
            }
            this.f427393j = new nu2.j(context, this.f427386c);
        }
        this.f427393j.g(fVar, bVar);
    }

    private void x() {
    }
}
