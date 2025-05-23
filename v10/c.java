package v10;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c extends b {

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WSVerticalPageFragment f440744d;

        a(WSVerticalPageFragment wSVerticalPageFragment) {
            this.f440744d = wSVerticalPageFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f440744d.getBaseActivity() != null) {
                com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.v(this.f440744d.getFrom(), this.f440744d.getPlayScene(), this.f440744d.Th(), this.f440744d.getPresenter().E());
                this.f440744d.getBaseActivity().doOnBackPressed();
            }
        }
    }

    public c(WSVerticalPageFragment wSVerticalPageFragment, boolean z16) {
        super(wSVerticalPageFragment, z16);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.f168555fw3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // v10.b, com.tencent.biz.pubaccount.weishi.baseui.b
    public void s() {
        super.s();
        WSVerticalPageFragment fragment = getFragment();
        com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.r(fragment.getBaseActivity(), (RelativeLayout) p(R.id.f11691701));
        p(R.id.f11690700).setOnClickListener(new a(fragment));
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
