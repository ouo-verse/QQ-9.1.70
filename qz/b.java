package qz;

import UserGrowth.stDrama;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi.image.WSPicLoader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b extends a {
    private KandianUrlImageView F;

    public b(Context context) {
        super(context);
    }

    private void y() {
        stDrama stdrama = this.C;
        if (stdrama != null && stdrama.tagIcon != null) {
            this.F.setVisibility(0);
            WSPicLoader.g().p(this.F, this.C.tagIcon);
        } else {
            this.F.setVisibility(8);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void h() {
        y();
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected int q() {
        return R.layout.f168552fw0;
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.b
    protected void s() {
        this.F = (KandianUrlImageView) p(R.id.ulo);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.AbsWsUI
    protected void f() {
    }

    @Override // qz.a
    public void x(int i3) {
    }
}
