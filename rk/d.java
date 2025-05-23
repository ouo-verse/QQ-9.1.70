package rk;

import android.os.Bundle;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b6\u00107R$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\u0011\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0015\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010$\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0014\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010\u0018R\"\u0010(\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0014\u001a\u0004\b&\u0010\u0016\"\u0004\b'\u0010\u0018R$\u0010.\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010*\u001a\u0004\b%\u0010+\"\u0004\b,\u0010-R\"\u00105\u001a\u00020/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104\u00a8\u00068"}, d2 = {"Lrk/d;", "Lrk/c;", "Lcom/qzone/proxy/feedcomponent/model/CellPictureInfo;", "e", "Lcom/qzone/proxy/feedcomponent/model/CellPictureInfo;", DomainData.DOMAIN_NAME, "()Lcom/qzone/proxy/feedcomponent/model/CellPictureInfo;", "v", "(Lcom/qzone/proxy/feedcomponent/model/CellPictureInfo;)V", "pictureInfo", "Lcom/qzone/proxy/feedcomponent/model/CellFeedCommInfo;", "f", "Lcom/qzone/proxy/feedcomponent/model/CellFeedCommInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/qzone/proxy/feedcomponent/model/CellFeedCommInfo;", "t", "(Lcom/qzone/proxy/feedcomponent/model/CellFeedCommInfo;)V", "feedCommonInfo", "", "g", "Z", "isSafeMode", "()Z", HippyTKDListViewAdapter.X, "(Z)V", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", tl.h.F, "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "k", "()Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "r", "(Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;)V", "businessFeedData", "i", "l", ReportConstant.COSTREPORT_PREFIX, "disAllowShare", "j", "p", "u", "isForwardAlbumFeed", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Landroid/os/Bundle;)V", "bundle", "", "J", "o", "()J", "w", "(J)V", "realOwnerUin", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d extends c {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private CellPictureInfo pictureInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private CellFeedCommInfo feedCommonInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isSafeMode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private BusinessFeedData businessFeedData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean disAllowShare;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean isForwardAlbumFeed;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private Bundle bundle;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private long realOwnerUin;

    /* renamed from: j, reason: from getter */
    public final Bundle getBundle() {
        return this.bundle;
    }

    /* renamed from: k, reason: from getter */
    public final BusinessFeedData getBusinessFeedData() {
        return this.businessFeedData;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getDisAllowShare() {
        return this.disAllowShare;
    }

    /* renamed from: m, reason: from getter */
    public final CellFeedCommInfo getFeedCommonInfo() {
        return this.feedCommonInfo;
    }

    /* renamed from: n, reason: from getter */
    public final CellPictureInfo getPictureInfo() {
        return this.pictureInfo;
    }

    /* renamed from: o, reason: from getter */
    public final long getRealOwnerUin() {
        return this.realOwnerUin;
    }

    /* renamed from: p, reason: from getter */
    public final boolean getIsForwardAlbumFeed() {
        return this.isForwardAlbumFeed;
    }

    public final void q(Bundle bundle) {
        this.bundle = bundle;
    }

    public final void r(BusinessFeedData businessFeedData) {
        this.businessFeedData = businessFeedData;
    }

    public final void s(boolean z16) {
        this.disAllowShare = z16;
    }

    public final void t(CellFeedCommInfo cellFeedCommInfo) {
        this.feedCommonInfo = cellFeedCommInfo;
    }

    public final void u(boolean z16) {
        this.isForwardAlbumFeed = z16;
    }

    public final void v(CellPictureInfo cellPictureInfo) {
        this.pictureInfo = cellPictureInfo;
    }

    public final void w(long j3) {
        this.realOwnerUin = j3;
    }

    public final void x(boolean z16) {
        this.isSafeMode = z16;
    }
}
