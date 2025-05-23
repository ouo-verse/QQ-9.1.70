package v10;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.verticalvideo.holder.au;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes36.dex */
public class g extends v10.b {
    private View J;
    private View K;

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WSVerticalPageFragment f440754d;

        a(WSVerticalPageFragment wSVerticalPageFragment) {
            this.f440754d = wSVerticalPageFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f440754d.getBaseActivity() != null) {
                com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.u(this.f440754d.getFrom(), this.f440754d.getPlayScene(), this.f440754d.Th());
                this.f440754d.getBaseActivity().doOnBackPressed();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g.this.H();
        }
    }

    public g(Context context, WSVerticalPageFragment wSVerticalPageFragment, boolean z16) {
        super(wSVerticalPageFragment, z16);
    }

    private void G() {
        WSVerticalPageFragment fragment = getFragment();
        if (fragment.ai() != null) {
            fragment.ai().j(fragment.sh());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        WSVerticalPageFragment fragment = getFragment();
        if (fragment.getAdapter() == null) {
            return;
        }
        au z16 = fragment.getAdapter().z();
        if (z16 != null) {
            z16.u();
        }
        G();
    }

    private void J(boolean z16) {
        if (getLlFloatWindowArea() == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) getLlFloatWindowArea().getLayoutParams();
        if (z16) {
            layoutParams.addRule(0, R.id.f11694704);
        } else {
            layoutParams.addRule(0, R.id.f11692702);
        }
        getLlFloatWindowArea().setLayoutParams(layoutParams);
    }

    public void I(boolean z16, m00.a aVar) {
        if (this.J == null || aVar == null) {
            return;
        }
        aVar.l(z16);
        this.J.setVisibility((aVar.i() <= 0 || !z16) ? 4 : 0);
    }

    public void K(boolean z16) {
        View view = this.K;
        if (view != null) {
            view.setVisibility(z16 ? 0 : 8);
        }
        J(z16);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.fw6;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // v10.b, com.tencent.biz.pubaccount.weishi.baseui.b
    public void s() {
        super.s();
        WSVerticalPageFragment fragment = getFragment();
        if (fragment == null) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.r(fragment.getBaseActivity(), (RelativeLayout) p(R.id.f11691701));
        p(R.id.f11692702).setOnClickListener(new a(fragment));
        View p16 = p(R.id.f11694704);
        this.K = p16;
        p16.setOnClickListener(new b());
        View p17 = p(R.id.xzu);
        this.J = p17;
        fragment.Bi(p17);
    }

    @Override // v10.b, com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }

    @Override // v10.b, com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
    }
}
