package v10;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes36.dex */
public class d extends b {

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WSVerticalPageFragment f440746d;

        a(WSVerticalPageFragment wSVerticalPageFragment) {
            this.f440746d = wSVerticalPageFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f440746d.getBaseActivity() != null) {
                com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.v(this.f440746d.getFrom(), this.f440746d.getPlayScene(), this.f440746d.Th(), this.f440746d.getPresenter().E());
                this.f440746d.getBaseActivity().doOnBackPressed();
            }
        }
    }

    public d(WSVerticalPageFragment wSVerticalPageFragment, boolean z16) {
        super(wSVerticalPageFragment, z16);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.d0m;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // v10.b, com.tencent.biz.pubaccount.weishi.baseui.b
    public void s() {
        super.s();
        WSVerticalPageFragment fragment = getFragment();
        com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.r(fragment.getBaseActivity(), (RelativeLayout) p(R.id.p8h));
        LinearLayout linearLayout = (LinearLayout) p(R.id.f163258p52);
        linearLayout.setBackgroundDrawable(ba.a(b().getResources().getColor(R.color.aet), ba.f81737l));
        linearLayout.setOnClickListener(new a(fragment));
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
