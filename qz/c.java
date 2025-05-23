package qz;

import UserGrowth.stDrama;
import UserGrowth.stDramaInfo;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c extends a implements View.OnClickListener {
    private ViewGroup F;
    private KandianUrlImageView G;
    private TextView H;
    private View I;

    public c(Context context) {
        super(context);
    }

    private boolean D() {
        return false;
    }

    private void F() {
        if (D()) {
            this.G.setVisibility(8);
            return;
        }
        this.G.setVisibility(0);
        WSPicLoader.g().w(this.G, z(), BaseApplicationImpl.getApplication().getResources().getDrawable(R.drawable.d7y));
    }

    private String z() {
        stDramaInfo stdramainfo;
        stDrama stdrama = this.C;
        if (stdrama != null && (stdramainfo = stdrama.dramaInfo) != null) {
            return stdramainfo.coverImg;
        }
        return "";
    }

    public ImageView A() {
        return this.G;
    }

    public ViewGroup B() {
        return this.F;
    }

    public void C() {
        this.I.setVisibility(8);
        this.H.setVisibility(8);
    }

    public void E(String str) {
        this.I.setVisibility(0);
        this.H.setVisibility(0);
        this.H.setText(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // qz.a, com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    public void g() {
        super.g();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
        F();
        C();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.f116866zw) {
            C();
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.f168553fw1;
    }

    public void y(int i3, int i16) {
        KandianUrlImageView kandianUrlImageView = this.G;
        if (kandianUrlImageView == null || i3 == kandianUrlImageView.getVisibility()) {
            return;
        }
        bb.a(this.G, i3, i16);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        this.F = (FrameLayout) p(R.id.f116846zu);
        this.G = (KandianUrlImageView) p(R.id.f116856zv);
        this.H = (TextView) p(R.id.f116876zx);
        View p16 = p(R.id.f116866zw);
        this.I = p16;
        p16.setOnClickListener(this);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }

    @Override // qz.a
    public void x(int i3) {
    }
}
