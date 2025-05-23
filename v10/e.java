package v10;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.weishi.q;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.z;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes36.dex */
public class e extends v10.b {

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WSVerticalPageFragment f440748d;

        a(WSVerticalPageFragment wSVerticalPageFragment) {
            this.f440748d = wSVerticalPageFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f440748d.getBaseActivity() != null) {
                com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.u(this.f440748d.getFrom(), this.f440748d.getPlayScene(), this.f440748d.Th());
                this.f440748d.getBaseActivity().doOnBackPressed();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WSVerticalPageFragment f440750d;

        b(WSVerticalPageFragment wSVerticalPageFragment) {
            this.f440750d = wSVerticalPageFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (hf0.a.a("vertical_video_top_homepage_click")) {
                x.i("AbsWsUIGroup", "fast click, ignored: vertical video top homepage");
            } else {
                com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.K(this.f440750d.getFrom(), this.f440750d.getPlayScene(), this.f440750d.Th());
                z.l(this.f440750d.getBaseActivity(), new q("from_qq_chat", 0, false));
            }
        }
    }

    public e(WSVerticalPageFragment wSVerticalPageFragment, boolean z16) {
        super(wSVerticalPageFragment, z16);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.f168556fw4;
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
        p(R.id.f11693703).setOnClickListener(new b(fragment));
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
