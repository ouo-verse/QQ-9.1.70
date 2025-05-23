package vg;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.reborn.base.QZoneBaseActivity;
import com.qzone.reborn.feedx.widget.i;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.qphone.base.util.QLog;
import gf.j;
import jo.h;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class a implements c {
    protected Activity C;
    protected ViewGroup D;
    private j E;

    /* renamed from: d, reason: collision with root package name */
    protected View f441562d;

    /* renamed from: e, reason: collision with root package name */
    protected View f441563e;

    /* renamed from: f, reason: collision with root package name */
    private b f441564f;

    /* renamed from: h, reason: collision with root package name */
    protected BusinessFeedData f441565h;

    /* renamed from: i, reason: collision with root package name */
    protected BusinessFeedData f441566i;

    /* renamed from: m, reason: collision with root package name */
    protected int f441567m;

    private void h() {
        ViewStub viewStub;
        if (this.f441563e == null) {
            QLog.e(getTAG(), 1, "checkInitView  mRootView == null");
            return;
        }
        if (this.f441562d != null) {
            return;
        }
        View h16 = this.f441564f.h(s());
        if (h16 == null && (viewStub = (ViewStub) this.f441563e.findViewById(s())) != null) {
            h hVar = h.f410717a;
            hVar.g("item_view_stub_inflate").h(getTAG() + "#view_stub_inflate");
            hVar.b(getTAG() + "#view_stub_inflate");
            View g16 = jm.b.f410600a.g(viewStub);
            hVar.d();
            hVar.g("item_view_stub_inflate").b(getTAG() + "#view_stub_inflate");
            h16 = g16;
        }
        if (h16 == null) {
            QLog.e(getTAG(), 1, "checkInitView  viewStub == null");
            return;
        }
        this.f441564f.a(s(), h16);
        this.f441562d = h16;
        C(h16);
    }

    protected abstract void A(BusinessFeedData businessFeedData);

    protected abstract void C(View view);

    /* JADX INFO: Access modifiers changed from: protected */
    public void D(cf.b bVar) {
        b bVar2 = this.f441564f;
        if (bVar2 == null) {
            return;
        }
        bVar2.b(bVar);
    }

    public void E(BusinessFeedData businessFeedData, int i3) {
        if (x() && w(businessFeedData)) {
            this.f441565h = businessFeedData.getOriginalInfo();
            this.f441566i = businessFeedData;
        } else {
            this.f441565h = businessFeedData;
        }
        this.f441567m = i3;
        A(this.f441565h);
    }

    public void F(b bVar) {
        this.f441564f = bVar;
    }

    public void G(ViewGroup viewGroup) {
        this.D = viewGroup;
    }

    public Activity i() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public <T> T j(Class<T> cls) {
        T t16 = (T) RFWIocAbilityProvider.g().getIocInterface(cls, this.f441563e, this.D);
        String str = "qioc-" + getTAG();
        int i3 = RFWLog.USR;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getIocInterface  | iocClass = ");
        sb5.append(cls.getSimpleName());
        sb5.append(" | iocInterface = ");
        sb5.append(t16);
        sb5.append(" | this = ");
        sb5.append(this);
        sb5.append(" | viewHash = ");
        View view = this.f441563e;
        sb5.append(view != null ? Integer.valueOf(view.hashCode()) : null);
        RFWLog.i(str, i3, sb5.toString());
        return t16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: k */
    public abstract String getTAG();

    public Handler l() {
        if (p() != null) {
            return p().getMainHandler();
        }
        return new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public j m() {
        if (this.E == null) {
            this.E = (j) j(j.class);
        }
        return this.E;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int o() {
        return this.f441564f.e();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BasePartFragment p() {
        View view = this.f441563e;
        if (view != null && (view.getContext() instanceof QZoneBaseActivity)) {
            return ((QZoneBaseActivity) this.f441563e.getContext()).getQZoneBaseFragment();
        }
        try {
            Fragment findFragment = FragmentManager.findFragment(this.D);
            if (findFragment instanceof BasePartFragment) {
                return (BasePartFragment) findFragment;
            }
            return null;
        } catch (Throwable th5) {
            RFWLog.fatal(getTAG(), RFWLog.USR, th5);
            return null;
        }
    }

    public String q() {
        return getTAG();
    }

    public <VM extends BaseViewModel> VM r(Class<VM> cls) {
        View view = this.f441563e;
        if (view instanceof QZoneBaseWidgetView) {
            return (VM) ((QZoneBaseWidgetView) view).p(cls);
        }
        return null;
    }

    protected abstract int s();

    public void u(View view) {
        this.f441563e = view;
        this.C = i.c(view);
        h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean v() {
        return this.f441566i != null;
    }

    protected boolean w(BusinessFeedData businessFeedData) {
        return com.qzone.reborn.feedx.itemview.d.d(businessFeedData);
    }

    protected abstract boolean x();

    public boolean y() {
        return !lm.a.f414989a.i(this);
    }

    public void B() {
    }

    @Override // vg.c
    public void c() {
    }

    @Override // vg.c
    public void onDestroy() {
    }

    @Override // vg.c
    public void onPaused() {
    }

    @Override // vg.c
    public void onStop() {
    }

    public void z() {
    }

    @Override // vg.c
    public void onViewHolderAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
    }

    @Override // vg.c
    public void onViewHolderDetachedFromWindow(RecyclerView.ViewHolder viewHolder) {
    }

    public void t(cf.b bVar) {
    }
}
