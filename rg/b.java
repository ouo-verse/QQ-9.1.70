package rg;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.common.event.EventCenter;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellGuiding;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b extends vg.a {
    private ImageView F;
    private CellGuiding G;

    /* compiled from: P */
    /* loaded from: classes36.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            b.this.I();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        int i3;
        EventCenter.getInstance().post("Feed", 27);
        CellGuiding cellGuiding = this.G;
        if (cellGuiding != null) {
            Map<String, String> map = cellGuiding.extendInfo;
            if (map != null) {
                String str = map.get("sub_guide_type");
                if (!TextUtils.isEmpty(str)) {
                    try {
                    } catch (Exception e16) {
                        QLog.e("QZoneFriendBirthdayHeadPresenter", 1, "handleClickFeedback  e = " + e16.getMessage());
                    }
                    if (Integer.valueOf(str).intValue() == 1) {
                        i3 = 1;
                        LpReportInfo_pf00064.allReport(619, 15, 2, String.valueOf(i3));
                    }
                }
            }
            i3 = 2;
            LpReportInfo_pf00064.allReport(619, 15, 2, String.valueOf(i3));
        }
        QZoneWriteOperationService.v0().I(this.f441567m, this.f441565h);
        EventCenter.getInstance().post("WriteOperation", 38, this.f441565h.getFeedCommInfo().feedskey);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZoneFriendBirthdayHeadPresenter";
    }

    @Override // vg.a
    protected int s() {
        return R.id.non;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        if (businessFeedData == null || businessFeedData.getCellGuiding() == null) {
            return;
        }
        this.G = businessFeedData.getCellGuiding();
    }

    @Override // vg.a
    protected void C(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.n2z);
        this.F = imageView;
        imageView.setOnClickListener(new a());
        view.setOnClickListener(null);
    }
}
