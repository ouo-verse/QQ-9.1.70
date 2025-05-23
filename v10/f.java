package v10;

import UserGrowth.stCollection;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.util.ba;
import com.tencent.biz.pubaccount.weishi.verticalvideo.WSVerticalPageFragment;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes36.dex */
public class f extends b {
    private static final int N = (int) (ba.o() - (ba.f81744s * 1.5f));
    private TextView J;
    private TextView K;
    private stCollection L;
    private View M;

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ WSVerticalPageFragment f440752d;

        a(WSVerticalPageFragment wSVerticalPageFragment) {
            this.f440752d = wSVerticalPageFragment;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f440752d.getBaseActivity() != null) {
                com.tencent.biz.pubaccount.weishi.verticalvideo.report.c.u(this.f440752d.getFrom(), this.f440752d.getPlayScene(), this.f440752d.Th());
                this.f440752d.getBaseActivity().doOnBackPressed();
            }
        }
    }

    public void F(int i3) {
        if (this.K == null || this.L == null) {
            return;
        }
        this.K.setText(i3 + "/" + this.L.feed_count);
    }

    @Override // v10.b, com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void g() {
        if (c() == null || !(c() instanceof stCollection)) {
            return;
        }
        this.L = (stCollection) c();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
        TextView textView = this.J;
        if (textView == null || this.L == null) {
            return;
        }
        textView.setMaxWidth(N);
        this.J.setText(e().getString(R.string.f241777ss) + this.L.name);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.fw5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // v10.b, com.tencent.biz.pubaccount.weishi.baseui.b
    public void s() {
        WSVerticalPageFragment fragment = getFragment();
        if (fragment == null) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.utils.e.r(fragment.getBaseActivity(), (RelativeLayout) p(R.id.f11691701));
        View p16 = p(R.id.f11690700);
        this.M = p16;
        p16.setOnClickListener(new a(fragment));
        this.J = (TextView) p(R.id.f116836zt);
        this.K = (TextView) p(R.id.f1068869x);
    }

    @Override // v10.b, com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }
}
