package uz;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.weishi.drama.WSDramaPageFragment;
import com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends com.tencent.biz.pubaccount.weishi.baseui.b<Object> implements View.OnClickListener {
    private final WSDramaPageFragment C;

    public a(WSDramaPageFragment wSDramaPageFragment) {
        super(wSDramaPageFragment.getContext());
        this.C = wSDramaPageFragment;
    }

    private void u() {
        if (this.C.getBaseActivity() != null) {
            this.C.getBaseActivity().doOnBackPressed();
            v();
        }
    }

    private void v() {
        pz.a Bd = this.C.Bd();
        tz.a.f(vz.a.f(Bd), vz.a.g(Bd), vz.a.d(Bd), vz.a.c(Bd), this.C.getFrom());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.p3s) {
            u();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.d0q;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        if (this.C == null) {
            return;
        }
        e.r(this.C.getBaseActivity(), (RelativeLayout) p(R.id.p3r));
        p(R.id.p3s).setOnClickListener(this);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
    }
}
