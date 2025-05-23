package wg;

import android.text.TextUtils;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.adapter.feedcomponent.j;
import com.qzone.common.event.EventCenter;
import com.qzone.common.logic.report.MiscReportUtils;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellGuiding;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.text.CellTextView;
import com.qzone.widget.AsyncImageView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import yo.d;
import yo.f;
import yo.g;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends vg.a implements View.OnClickListener {
    private CellTextView F;
    private CellTextView G;
    private TextView H;
    private AsyncImageView I;
    private ImageView J;
    private CellGuiding K;

    private void H() {
        if (this.f441565h.getFeedCommInfo() == null) {
            QLog.e("QZonePermissionSettingContentPresenter", 1, "feedCommInfo is null");
            return;
        }
        EventCenter.getInstance().post("Feed", 27);
        LpReportInfo_pf00064.allReport(619, 4, 3);
        EventCenter.getInstance().post("WriteOperation", 38, this.f441565h.getFeedCommInfo().feedskey);
    }

    private void I() {
        CellGuiding cellGuiding = this.K;
        if (cellGuiding == null) {
            QLog.e("QZonePermissionSettingContentPresenter", 1, "mCellGuiding is null");
            return;
        }
        if (TextUtils.isEmpty(cellGuiding.action_url)) {
            QLog.e("QZonePermissionSettingContentPresenter", 1, "action_url is null");
            return;
        }
        String str = this.K.action_url;
        if (URLUtil.isNetworkUrl(str)) {
            str = f.b(str, "from", "2");
        }
        d.b(this.C, new g(str));
        MiscReportUtils.k(this.K, "report_click_button");
        MiscReportUtils.b(this.K);
    }

    private void J() {
        CellGuiding cellGuiding = this.K;
        if (cellGuiding == null) {
            QLog.e("QZonePermissionSettingContentPresenter", 1, "mFunctionGuide is null");
            return;
        }
        PictureItem pictureItem = cellGuiding.pic;
        if (pictureItem == null) {
            QLog.e("QZonePermissionSettingContentPresenter", 1, "banner is null");
        } else {
            this.I.setAsyncImage(j.D(pictureItem.currentUrl.url));
        }
    }

    private void K() {
        CellGuiding cellGuiding = this.K;
        if (cellGuiding == null) {
            QLog.e("QZonePermissionSettingContentPresenter", 1, "mFunctionGuide is null");
        } else if (!TextUtils.isEmpty(cellGuiding.button_title)) {
            this.H.setVisibility(0);
            this.H.setText(this.K.button_title);
        } else {
            this.H.setVisibility(8);
        }
    }

    private void L() {
        if (this.K == null) {
            QLog.e("QZonePermissionSettingContentPresenter", 1, "mFunctionGuide is null");
            return;
        }
        this.G.setTextGravity(1);
        CellTextView cellTextView = this.G;
        String str = this.K.summary;
        if (str == null) {
            str = "";
        }
        cellTextView.setRichText(str);
    }

    private void M() {
        CellGuiding cellGuiding = this.K;
        if (cellGuiding == null) {
            QLog.e("QZonePermissionSettingContentPresenter", 1, "mFunctionGuide is null");
            return;
        }
        CellTextView cellTextView = this.F;
        String str = cellGuiding.title;
        if (str == null) {
            str = "";
        }
        cellTextView.setRichText(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // vg.a
    /* renamed from: k */
    public String getTAG() {
        return "QZonePermissionSettingContentPresenter";
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.n8x) {
            I();
        } else if (id5 == R.id.f162905n90) {
            H();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // vg.a
    protected int s() {
        return R.id.nlm;
    }

    @Override // vg.a
    protected boolean x() {
        return false;
    }

    @Override // vg.a
    protected void A(BusinessFeedData businessFeedData) {
        if (businessFeedData == null) {
            QLog.e("QZonePermissionSettingContentPresenter", 1, "[onBindData] feedData is null");
            return;
        }
        this.K = businessFeedData.getCellGuiding();
        M();
        L();
        K();
        J();
    }

    @Override // vg.a
    protected void C(View view) {
        this.F = (CellTextView) view.findViewById(R.id.n8z);
        this.G = (CellTextView) view.findViewById(R.id.n8y);
        this.H = (TextView) view.findViewById(R.id.n8x);
        this.J = (ImageView) view.findViewById(R.id.f162905n90);
        this.I = (AsyncImageView) view.findViewById(R.id.n8w);
        this.J.setOnClickListener(this);
        this.H.setOnClickListener(this);
    }
}
