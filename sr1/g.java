package sr1;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.guild.mainframe.GuildSecondaryFragment;
import com.tencent.mobileqq.guild.mainframe.centerpanel.GuildMainFrameLayout;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class g implements d {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.guild.mainframe.i f434324a;

    /* renamed from: b, reason: collision with root package name */
    private GuildMainFrameLayout f434325b;

    /* renamed from: c, reason: collision with root package name */
    private h f434326c;

    /* renamed from: d, reason: collision with root package name */
    private int f434327d = 2;

    /* renamed from: e, reason: collision with root package name */
    public Runnable f434328e = null;

    public g(com.tencent.mobileqq.guild.mainframe.i iVar) {
        this.f434324a = iVar;
    }

    private int o(int i3, int i16) {
        if (i3 < i16) {
            return 1;
        }
        if (i3 > i16) {
            return 2;
        }
        return 0;
    }

    private int p(int i3) {
        if (i3 == 0) {
            return 2;
        }
        if (i3 == 1) {
            return 1;
        }
        return 3;
    }

    private int q(Intent intent) {
        if (intent == null) {
            intent = this.f434324a.getActivity().getIntent();
        }
        Bundle bundleExtra = intent.getBundleExtra("goto_guildtab_actionextra");
        if (bundleExtra == null) {
            return this.f434327d;
        }
        boolean z16 = bundleExtra.getBoolean("keepOpenPos", false);
        int i3 = bundleExtra.getInt("openAioIn", 1);
        if (!z16) {
            return i3;
        }
        return this.f434327d;
    }

    public static int r(int i3) {
        if (i3 == 1) {
            return 1;
        }
        if (i3 != 2) {
            return 2;
        }
        return 0;
    }

    private boolean s() {
        return QQGuildUIUtil.A(this.f434324a.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void t(int i3) {
        b(i3);
        this.f434326c.a().t(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void u(int i3) {
        b(i3);
        this.f434326c.a().u(i3);
    }

    private void x(int i3, boolean z16) {
        int e16 = e();
        b(i3);
        if (!this.f434324a.P()) {
            if (i3 != 2) {
                GuildSecondaryFragment.zh(this.f434324a);
            }
            QLog.i("Guild.MF.Gesture.GuildChatFrameGestureManager", 1, "showForPad, GuildSecondaryFragment == null, waiting launch...");
        }
        GuildSecondaryFragment.yh(i3);
        this.f434326c.h().n(1).s(2).m(p(e16)).q(o(e16, i3)).k();
        this.f434326c.h().n(3).p(p(i3)).k();
        this.f434326c.h().n(0).k();
    }

    @Override // sr1.d
    public boolean a() {
        return this.f434326c.a().r();
    }

    @Override // sr1.d
    public void addGestureListener(rr1.a aVar) {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Gesture.GuildChatFrameGestureManager", 2, "addGestureListener");
        }
        this.f434326c.h().f(aVar);
    }

    @Override // sr1.d
    public void b(int i3) {
        if (QLog.isColorLevel()) {
            QLog.i("Guild.MF.Gesture.GuildChatFrameGestureManager", 1, "setTargetShowType old=" + this.f434327d + " new=" + i3);
        }
        this.f434327d = i3;
    }

    @Override // sr1.d
    public void c(final int i3) {
        this.f434328e = null;
        if (s()) {
            x(i3, true);
            return;
        }
        if (AppSetting.t(this.f434324a.getActivity()) && !this.f434324a.P() && i3 < 2) {
            this.f434328e = new Runnable() { // from class: sr1.f
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.t(i3);
                }
            };
            GuildSecondaryFragment.zh(this.f434324a);
        } else {
            t(i3);
        }
    }

    @Override // sr1.d
    public void d(Intent intent) {
        b(q(intent));
    }

    @Override // sr1.d
    public int e() {
        return this.f434327d;
    }

    @Override // sr1.d
    public boolean f() {
        if (s()) {
            if (this.f434327d == 0) {
                return true;
            }
            return false;
        }
        return this.f434326c.i().j();
    }

    @Override // sr1.d
    public void g(final int i3) {
        this.f434328e = null;
        if (s()) {
            x(i3, false);
            return;
        }
        if (AppSetting.t(this.f434324a.getActivity()) && !this.f434324a.P() && i3 < 2) {
            this.f434328e = new Runnable() { // from class: sr1.e
                @Override // java.lang.Runnable
                public final void run() {
                    g.this.u(i3);
                }
            };
            GuildSecondaryFragment.zh(this.f434324a);
        } else {
            u(i3);
        }
    }

    @Override // sr1.d
    public boolean h() {
        return this.f434326c.l();
    }

    @Override // sr1.d
    public void i(boolean z16) {
        this.f434326c.m(z16);
    }

    @Override // sr1.d
    public boolean j() {
        if (s()) {
            if (this.f434327d == 2) {
                return true;
            }
            return false;
        }
        return this.f434326c.i().k();
    }

    @Override // sr1.d
    public void k(View view, ViewGroup viewGroup, ViewGroup viewGroup2, ViewGroup viewGroup3) {
        this.f434325b = (GuildMainFrameLayout) view;
        h hVar = new h(this.f434324a, viewGroup, viewGroup2, viewGroup3);
        this.f434326c = hVar;
        this.f434325b.b(this.f434324a, hVar);
    }

    @Override // sr1.d
    public boolean l() {
        if (s()) {
            if (this.f434327d == 1) {
                return true;
            }
            return false;
        }
        return this.f434326c.i().l();
    }

    @Override // sr1.d
    public void onConfigurationChanged(Configuration configuration) {
        j i3 = this.f434326c.i();
        i3.v(i3.r(this.f434327d));
    }

    @Override // sr1.d
    public void onDestroy() {
        if (QLog.isColorLevel()) {
            QLog.d("Guild.MF.Gesture.GuildChatFrameGestureManager", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
        GuildMainFrameLayout guildMainFrameLayout = this.f434325b;
        if (guildMainFrameLayout != null) {
            guildMainFrameLayout.r();
        }
    }

    @Override // sr1.d
    public void removeGestureListener(rr1.a aVar) {
        this.f434326c.h().l(aVar);
    }
}
