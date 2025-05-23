package yg;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import gf.h;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes36.dex */
public class d extends vg.a implements View.OnClickListener {
    private TextView F;
    private ImageView G;
    private h H;

    private h H() {
        if (this.H == null) {
            this.H = (h) j(h.class);
        }
        return this.H;
    }

    private void I() {
        H().h2(this.f441565h, this.f441567m, null);
    }

    private void J() {
        this.F.setText(HardCodeUtil.qqStr(R.string.ktr));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZonePYMKFeedTitlePresenter";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null && view.getId() == R.id.n1v) {
            QLog.i("QZonePYMKFeedTitlePresenter", 1, "onClick drop_down_btn");
            I();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // vg.a
    protected int s() {
        return R.id.nln;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            QLog.e("QZonePYMKFeedTitlePresenter", 1, "[setData] feedData is null");
        } else {
            J();
        }
    }

    @Override // vg.a
    protected void C(View view) {
        this.F = (TextView) view.findViewById(R.id.f162869n23);
        ImageView imageView = (ImageView) view.findViewById(R.id.n1v);
        this.G = imageView;
        imageView.setOnClickListener(this);
        HashMap hashMap = new HashMap();
        hashMap.put("business_type", "pymk");
        fo.b bVar = new fo.b();
        bVar.l(hashMap);
        fo.c.o(this.G, WinkDaTongReportConstant.ElementId.EM_QZ_MORE_BTN, bVar);
    }
}
