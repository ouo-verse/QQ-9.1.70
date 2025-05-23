package tq1;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.guild.live.livemanager.player.m;
import com.tencent.mobileqq.guild.live.model.LiveChannelRoomInfo;
import com.tencent.mobileqq.guild.media.core.notify.NotifyGiftRankChanged;
import com.tencent.mobileqq.guild.media.core.notify.NotifyReceivePayGiftChanged;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.ff;
import com.tencent.mobileqq.qqlive.data.gift.GiftMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.UiThreadUtil;
import e12.e;
import java.util.List;
import rs0.LiveUserEnterTipsModel;
import sq1.GLiveOutPlayerInfo;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b {
    private final cn<Void> A;
    private boolean B;
    private boolean C;
    private final e<ff> D;
    private final e<ff> E;
    private final e<Integer> F;
    private final e<Long> G;
    private final e12.a<Boolean> H;
    private final e12.a<NotifyGiftRankChanged> I;
    private final e12.a<NotifyReceivePayGiftChanged> J;

    /* renamed from: a, reason: collision with root package name */
    private final e<Boolean> f437100a;

    /* renamed from: b, reason: collision with root package name */
    private final e<Boolean> f437101b;

    /* renamed from: c, reason: collision with root package name */
    private final e<View> f437102c;

    /* renamed from: d, reason: collision with root package name */
    private m f437103d;

    /* renamed from: e, reason: collision with root package name */
    private final e<Boolean> f437104e;

    /* renamed from: f, reason: collision with root package name */
    private final e12.a<Boolean> f437105f;

    /* renamed from: g, reason: collision with root package name */
    private final e<Integer> f437106g;

    /* renamed from: h, reason: collision with root package name */
    private final e12.a<IGProGuildInfo> f437107h;

    /* renamed from: i, reason: collision with root package name */
    private final e12.a<IGProChannelInfo> f437108i;

    /* renamed from: j, reason: collision with root package name */
    private final e12.a<Boolean> f437109j;

    /* renamed from: k, reason: collision with root package name */
    private final e<Boolean> f437110k;

    /* renamed from: l, reason: collision with root package name */
    private final e<Boolean> f437111l;

    /* renamed from: m, reason: collision with root package name */
    private final cn<GiftMessage> f437112m;

    /* renamed from: n, reason: collision with root package name */
    private final cn<Boolean> f437113n;

    /* renamed from: o, reason: collision with root package name */
    private final cn<List<? extends LiveUserEnterTipsModel>> f437114o;

    /* renamed from: p, reason: collision with root package name */
    private final cn<String> f437115p;

    /* renamed from: q, reason: collision with root package name */
    private final e<Boolean> f437116q;

    /* renamed from: r, reason: collision with root package name */
    private final e<Boolean> f437117r;

    /* renamed from: s, reason: collision with root package name */
    private final e<Integer> f437118s;

    /* renamed from: t, reason: collision with root package name */
    private final e12.a<LiveChannelRoomInfo> f437119t;

    /* renamed from: u, reason: collision with root package name */
    private final e<Integer> f437120u;

    /* renamed from: v, reason: collision with root package name */
    private final MutableLiveData<Boolean> f437121v;

    /* renamed from: w, reason: collision with root package name */
    private final MutableLiveData<Integer> f437122w;

    /* renamed from: x, reason: collision with root package name */
    private final MutableLiveData<Integer> f437123x;

    /* renamed from: y, reason: collision with root package name */
    private final e12.a<Boolean> f437124y;

    /* renamed from: z, reason: collision with root package name */
    private GLiveOutPlayerInfo f437125z;

    public b() {
        Boolean bool = Boolean.FALSE;
        this.f437100a = new e<>(bool);
        this.f437101b = new e<>(bool);
        this.f437102c = new e<>(null);
        this.f437104e = new e<>(Boolean.TRUE);
        this.f437105f = new e12.a<>(bool);
        this.f437106g = new e<>(1);
        this.f437107h = new e12.a<>();
        this.f437108i = new e12.a<>();
        this.f437109j = new e12.a<>();
        this.f437110k = new e<>(bool);
        this.f437111l = new e<>();
        this.f437112m = new cn<>();
        this.f437113n = new cn<>();
        this.f437114o = new cn<>();
        this.f437115p = new cn<>();
        this.f437116q = new e<>();
        this.f437117r = new e<>();
        this.f437118s = new e<>(0);
        this.f437119t = new e12.a<>();
        this.f437120u = new e<>();
        this.f437121v = new MutableLiveData<>(bool);
        this.f437122w = new MutableLiveData<>(0);
        this.f437123x = new MutableLiveData<>(0);
        this.f437124y = new e12.a<>(bool);
        this.A = new cn<>();
        this.C = false;
        this.D = new e<>();
        this.E = new e<>();
        this.F = new e<>();
        this.G = new e<>(-1L);
        this.H = new e12.a<>();
        this.I = new e12.a<>();
        this.J = new e12.a<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(GiftMessage giftMessage) {
        this.f437112m.setValue(giftMessage);
    }

    public e<ff> A() {
        return this.D;
    }

    public e12.a<NotifyReceivePayGiftChanged> B() {
        return this.J;
    }

    public LiveData<Boolean> C() {
        return this.f437110k;
    }

    public LiveData<Boolean> D() {
        return this.f437100a;
    }

    public LiveData<Boolean> E() {
        return this.f437111l;
    }

    public cn<Boolean> F() {
        return this.f437113n;
    }

    public e<Long> G() {
        return this.G;
    }

    public LiveData<List<? extends LiveUserEnterTipsModel>> H() {
        return this.f437114o;
    }

    public MutableLiveData<Integer> I() {
        return this.f437123x;
    }

    public LiveData<Boolean> J() {
        return this.f437104e;
    }

    public m K() {
        return this.f437103d;
    }

    public MutableLiveData<Integer> L() {
        return this.f437122w;
    }

    public boolean M() {
        return this.C;
    }

    public boolean N() {
        if (this.f437100a.getValue() == Boolean.TRUE) {
            return true;
        }
        return false;
    }

    public void P() {
        this.f437113n.setValue(Boolean.TRUE);
    }

    public void Q(boolean z16) {
        this.C = z16;
    }

    public void R(boolean z16) {
        this.f437124y.setValue(Boolean.valueOf(z16));
    }

    public boolean S() {
        return this.B;
    }

    public void T(int i3) {
        QLog.i("QGL.QQGuildLiveRoomUiData", 1, "updateActivityOrientation:" + i3 + ", original orientation: " + this.f437120u.getValue());
        this.f437120u.setValue(Integer.valueOf(i3));
    }

    public void U(IGProChannelInfo iGProChannelInfo) {
        if (QLog.isColorLevel()) {
            QLog.i("QGL.QQGuildLiveRoomUiData", 2, "updateChannelInfo: " + iGProChannelInfo);
        }
        this.f437108i.setValue(iGProChannelInfo);
    }

    public void V(Boolean bool) {
        if (QLog.isColorLevel()) {
            QLog.i("QGL.QQGuildLiveRoomUiData", 2, "updateDanmuIsShow isShow:" + bool);
        }
        this.f437105f.setValue(bool);
    }

    public void W(String str) {
        QLog.i("QGL.QQGuildLiveRoomUiData", 1, "updateRoomLogo posterUrl:" + str);
        this.f437115p.setValue(str);
    }

    public void X(ff ffVar) {
        QLog.i("QGL.QQGuildLiveRoomUiData", 1, "updateGameLiveRoomInfo: " + ffVar);
        this.E.setValue(ffVar);
    }

    public void Y(final GiftMessage giftMessage) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: tq1.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.O(giftMessage);
                }
            });
        } else {
            this.f437112m.setValue(giftMessage);
        }
    }

    public void Z(NotifyGiftRankChanged notifyGiftRankChanged) {
        this.I.setValue(notifyGiftRankChanged);
    }

    public void a0(IGProGuildInfo iGProGuildInfo) {
        QLog.i("QGL.QQGuildLiveRoomUiData", 1, "updateGuildInfo: " + iGProGuildInfo);
        this.f437107h.setValue(iGProGuildInfo);
    }

    public void b() {
        QLog.i("QGL.QQGuildLiveRoomUiData", 1, "clearUiDataWhenExitChannel.");
        q0(false);
        e0(null);
        p0(false);
        Q(false);
        R(false);
        c();
        t0(-1L);
        s0(false);
        u0(null);
        Z(null);
        n0(null);
        k0(null);
    }

    public void b0(Integer num) {
        if (QLog.isColorLevel()) {
            QLog.i("QGL.QQGuildLiveRoomUiData", 2, "updateGuildLiveVideoState: " + num);
        }
        this.f437118s.setValue(num);
    }

    public void c() {
        QLog.i("QGL.QQGuildLiveRoomUiData", 1, "clearUiDataWhenExitRoom.");
        Boolean bool = Boolean.FALSE;
        c0(bool);
        o0(1);
        l0(null, null);
        w0(Boolean.TRUE);
        r0(bool);
        Y(null);
        W(null);
        j0(null);
        T(1);
        b0(0);
        m0(null);
        X(null);
        h0(null);
        d0(true);
        Z(null);
        n0(null);
        V(bool);
    }

    public void c0(Boolean bool) {
        QLog.i("QGL.QQGuildLiveRoomUiData", 1, "updateIsEnterRoomSuc: " + bool);
        this.f437101b.setValue(bool);
    }

    public e12.a<Integer> d() {
        return this.f437120u;
    }

    public void d0(boolean z16) {
        this.H.setValue(Boolean.valueOf(z16));
    }

    public LiveData<IGProChannelInfo> e() {
        return this.f437108i;
    }

    public void e0(LiveChannelRoomInfo liveChannelRoomInfo) {
        QLog.i("QGL.QQGuildLiveRoomUiData", 1, "updateLiveRoomInfo: " + liveChannelRoomInfo);
        this.f437119t.setValue(liveChannelRoomInfo);
    }

    public LiveData<Integer> f() {
        return this.f437106g;
    }

    public void f0(Boolean bool) {
        QLog.i("QGL.QQGuildLiveRoomUiData", 1, "updateMultiSelect: " + bool);
        this.f437109j.setValue(bool);
    }

    public LiveData<Boolean> g() {
        return this.f437105f;
    }

    public void g0(int i3) {
        this.F.setValue(Integer.valueOf(i3));
    }

    public e<ff> h() {
        return this.E;
    }

    public void h0(GLiveOutPlayerInfo gLiveOutPlayerInfo) {
        this.f437125z = gLiveOutPlayerInfo;
    }

    public LiveData<GiftMessage> i() {
        return this.f437112m;
    }

    public void i0(boolean z16) {
        this.f437121v.setValue(Boolean.valueOf(z16));
    }

    public e12.a<NotifyGiftRankChanged> j() {
        return this.I;
    }

    public void j0(Boolean bool) {
        QLog.i("QGL.QQGuildLiveRoomUiData", 2, "updatePlayerOnError: " + bool);
        this.f437117r.setValue(bool);
    }

    public LiveData<IGProGuildInfo> k() {
        return this.f437107h;
    }

    public void k0(Boolean bool) {
        QLog.i("QGL.QQGuildLiveRoomUiData", 1, "updatePlayerOnFirstFrameCome: " + bool);
        this.f437116q.setValue(bool);
    }

    public LiveData<Integer> l() {
        return this.f437118s;
    }

    public void l0(View view, m mVar) {
        QLog.i("QGL.QQGuildLiveRoomUiData", 1, "updatePlayerVideoVideo:" + view);
        this.f437103d = mVar;
        this.f437102c.setValue(view);
    }

    public int m() {
        return this.f437118s.getValue().intValue();
    }

    public void m0(ff ffVar) {
        QLog.i("QGL.QQGuildLiveRoomUiData", 1, "updatePushLiveRoomInfo: " + ffVar);
        this.D.setValue(ffVar);
    }

    public LiveData<Boolean> n() {
        return this.f437101b;
    }

    public void n0(NotifyReceivePayGiftChanged notifyReceivePayGiftChanged) {
        this.J.setValue(notifyReceivePayGiftChanged);
    }

    public e12.a<Boolean> o() {
        return this.H;
    }

    public void o0(int i3) {
        QLog.d("QGL.QQGuildLiveRoomUiData", 4, "updateRoomAudienceNum:" + i3);
        this.f437106g.setValue(Integer.valueOf(i3));
    }

    public LiveData<LiveChannelRoomInfo> p() {
        return this.f437119t;
    }

    public void p0(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i("QGL.QQGuildLiveRoomUiData", 2, "updateSelfAllowStartLive: " + z16);
        }
        this.f437110k.setValue(Boolean.valueOf(z16));
    }

    public GLiveOutPlayerInfo q() {
        return this.f437125z;
    }

    public void q0(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.i("QGL.QQGuildLiveRoomUiData", 2, "updateSelfIsAdmin: " + z16);
        }
        this.f437111l.setValue(Boolean.valueOf(z16));
    }

    public LiveData<String> r() {
        return this.f437115p;
    }

    public void r0(Boolean bool) {
        if (QLog.isColorLevel()) {
            QLog.i("QGL.QQGuildLiveRoomUiData", 2, "updateSelfIsAnchorLiving: " + bool);
        }
        this.f437100a.setValue(bool);
    }

    public LiveData<Boolean> s() {
        return this.f437109j;
    }

    public void s0(boolean z16) {
        QLog.i("QGL.QQGuildLiveRoomUiData", 1, "updateShouldShowSelfEnterTips: " + z16);
        this.B = z16;
    }

    public e<Integer> t() {
        return this.F;
    }

    public void t0(long j3) {
        QLog.i("QGL.QQGuildLiveRoomUiData", 1, "[updateShowMaxMsgSeq] msgSeq = " + j3);
        this.G.setValue(Long.valueOf(j3));
    }

    public int u(Context context) {
        Integer value = this.F.getValue();
        if (value == null) {
            return gq1.b.b(context);
        }
        return value.intValue();
    }

    public void u0(List<? extends LiveUserEnterTipsModel> list) {
        this.f437114o.setValue(list);
    }

    public cn<Void> v() {
        return this.A;
    }

    public void v0() {
        boolean z16;
        GLiveOutPlayerInfo gLiveOutPlayerInfo = this.f437125z;
        if (gLiveOutPlayerInfo != null) {
            l0(gLiveOutPlayerInfo.getVideo(), gLiveOutPlayerInfo.getVideoViewCtrl());
            x0(gLiveOutPlayerInfo.getWidth(), gLiveOutPlayerInfo.getHeight());
            if (gLiveOutPlayerInfo.getWidth() >= gLiveOutPlayerInfo.getHeight()) {
                z16 = true;
            } else {
                z16 = false;
            }
            w0(Boolean.valueOf(z16));
        }
    }

    public MutableLiveData<Boolean> w() {
        return this.f437121v;
    }

    public void w0(Boolean bool) {
        QLog.i("QGL.QQGuildLiveRoomUiData", 1, "updateVideoIsLand isLand:" + bool);
        this.f437104e.setValue(bool);
    }

    public LiveData<Boolean> x() {
        return this.f437117r;
    }

    public void x0(int i3, int i16) {
        QLog.i("QGL.QQGuildLiveRoomUiData", 1, "updateVideoWidthAndHeight: " + i3 + ", " + i16);
        this.f437122w.postValue(Integer.valueOf(i3));
        this.f437123x.postValue(Integer.valueOf(i16));
    }

    public LiveData<Boolean> y() {
        return this.f437116q;
    }

    public LiveData<View> z() {
        return this.f437102c;
    }
}
