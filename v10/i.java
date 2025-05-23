package v10;

import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.weishi.q;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi.z;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;

/* compiled from: P */
/* loaded from: classes36.dex */
public class i extends b implements View.OnClickListener {
    public i(WSVerticalPageFragment wSVerticalPageFragment, boolean z16) {
        super(wSVerticalPageFragment, z16);
    }

    private void F() {
        WSVerticalPageFragment fragment = getFragment();
        if (fragment.getBaseActivity() != null) {
            com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.u(fragment.getFrom(), fragment.getPlayScene(), fragment.Th());
            fragment.getBaseActivity().doOnBackPressed();
        }
    }

    private boolean G() {
        return TextUtils.equals(getFragment().Zh(), "native");
    }

    private void H() {
        String str;
        if (bb.E()) {
            x.i("WSVerticalPageShareTopAreaController", "[launchWSHomePage] fast click, ignored: vertical video top homepage");
            return;
        }
        WSVerticalPageFragment fragment = getFragment();
        stSimpleMetaFeed Th = fragment.Th();
        com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.q(fragment.getFrom(), fragment.getPlayScene(), Th);
        BaseActivity baseActivity = fragment.getBaseActivity();
        q h16 = new q("from_qq_scheme", 0, false).h(true);
        if (Th != null) {
            str = Th.f25129id;
        } else {
            str = "";
        }
        z.l(baseActivity, h16.g(str));
        baseActivity.finish();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.p8g /* 1929773272 */:
            case R.id.p8j /* 1929773275 */:
                H();
                return;
            case R.id.p8h /* 1929773273 */:
            default:
                return;
            case R.id.p8i /* 1929773274 */:
                F();
                return;
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.d0y;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // v10.b, com.tencent.biz.pubaccount.weishi.baseui.b
    public void s() {
        super.s();
        WSVerticalPageFragment fragment = getFragment();
        if (fragment == null) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.r(fragment.getBaseActivity(), (RelativeLayout) p(R.id.p8h));
        p(R.id.p8i).setOnClickListener(this);
        View p16 = p(R.id.p8j);
        p16.setOnClickListener(this);
        View p17 = p(R.id.p8g);
        p17.setOnClickListener(this);
        p16.setVisibility(G() ? 8 : 0);
        p17.setVisibility(G() ? 8 : 0);
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
