package x80;

import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.immersive.views.search.util.ad;
import com.tencent.biz.qqcircle.launcher.QCircleSchemeLauncher;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RoundRectImageView;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends b implements View.OnClickListener {
    private static final int L = ViewUtils.dip2px(8.0f);
    private RoundRectImageView J;
    private w80.g K;

    private void i1() {
        HashMap hashMap = new HashMap();
        hashMap.put(QCircleDaTongConstant.ElementParamKey.XSJ_TRANSFER_INFO, this.K.f444988c);
        ua0.i.k(this.J, this.I.d(), hashMap, this.K.hashCode());
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    public void N0(@NonNull View view) {
        super.N0(view);
        RoundRectImageView roundRectImageView = (RoundRectImageView) view.findViewById(R.id.f52972b9);
        this.J = roundRectImageView;
        roundRectImageView.setOnClickListener(this);
        this.J.setCornerRadiusAndMode(L, 1);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: h1, reason: merged with bridge method [inline-methods] */
    public void L0(w80.c cVar, int i3) {
        super.L0(cVar, i3);
        w80.g gVar = cVar.f444966d;
        this.K = gVar;
        String str = gVar.f444986a;
        if (TextUtils.isEmpty(str)) {
            this.J.setVisibility(8);
            return;
        }
        this.J.setVisibility(0);
        ad.s(this.J, str);
        i1();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        String str = this.K.f444987b;
        if (TextUtils.isEmpty(str)) {
            QLog.w("QCircleSearchGameUnionContentPresenter", 1, "#onClick: url is empty");
        } else {
            QCircleSchemeLauncher.f(view.getContext(), str);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.qqcircle.immersive.feed.QFSBaseFeedChildPresenter
    /* renamed from: w0 */
    public String getTAG() {
        return "QCircleSearchGameUnionContentPresenter";
    }
}
