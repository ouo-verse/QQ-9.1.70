package x80;

import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.qqcircle.immersive.views.search.util.ad;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes4.dex */
public class k extends b {
    public static final int S = cx.a(100.0f);
    public static final int T = cx.a(8.0f);
    public static final int U = cx.a(0.0f);
    private View J;
    private ImageView K;
    private View L;
    private View M;
    private View N;
    private View P;
    private LinearLayout Q;
    private boolean R;

    private void h1() {
        this.K.setImageDrawable(ie0.a.f().k(m0(), R.color.qui_common_bg_middle_light, 0.0f, 1000));
        this.K.setLayoutParams(new ConstraintLayout.LayoutParams(-1, T));
        this.L.setVisibility(8);
    }

    private void i1() {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.Q.getLayoutParams();
        marginLayoutParams.topMargin = S;
        if (this.R) {
            marginLayoutParams.topMargin = U;
        }
        this.Q.setLayoutParams(marginLayoutParams);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void k1() {
        View view = this.J;
        String e16 = this.I.e();
        T t16 = this.f85017h;
        ua0.i.k(view, e16, ((w80.c) t16).f444972j, ((w80.c) t16).hashCode());
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void m1() {
        this.K.setVisibility(0);
        this.L.setVisibility(0);
        this.K.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -2));
        this.K.setAdjustViewBounds(true);
        String str = ((w80.c) this.f85017h).f444963a;
        if (TextUtils.isEmpty(str)) {
            this.K.setVisibility(8);
        } else {
            ad.s(this.K, str);
        }
    }

    private void n1(int i3) {
        this.L.setBackground(new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{0, i3}));
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        this.Q = (LinearLayout) view.findViewById(R.id.f52982b_);
        View findViewById = view.findViewById(R.id.f53222bx);
        this.J = findViewById;
        this.K = (ImageView) findViewById.findViewById(R.id.f52922b4);
        this.L = this.J.findViewById(R.id.f52962b8);
        this.M = this.J.findViewById(R.id.f52932b5);
        this.N = this.J.findViewById(R.id.f52942b6);
        this.P = this.J.findViewById(R.id.f52952b7);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: j1, reason: merged with bridge method [inline-methods] */
    public void L0(w80.c cVar, int i3) {
        super.L0(cVar, i3);
        i1();
        if (this.R) {
            h1();
        } else {
            m1();
        }
        this.Q.setBackground(ie0.a.f().k(m0(), R.color.qui_common_bg_bottom_light, 8.0f, 1000));
        int g16 = ie0.a.f().g(m0(), R.color.qui_common_bg_middle_standard, 1000);
        this.M.setBackgroundColor(g16);
        this.N.setBackgroundColor(g16);
        this.P.setBackgroundColor(g16);
        n1(g16);
        k1();
    }

    public void l1(boolean z16) {
        this.R = z16;
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QCircleSearchGameUnionRootPresenter";
    }
}
