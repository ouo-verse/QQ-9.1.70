package zb3;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b*\b\u0086\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001BW\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0005\u0012\b\b\u0002\u0010\"\u001a\u00020\t\u0012\b\b\u0002\u0010&\u001a\u00020\u0003\u0012\b\b\u0002\u0010(\u001a\u00020\u0005\u0012\b\b\u0002\u0010,\u001a\u00020\u0005\u0012\b\b\u0002\u00100\u001a\u00020\u0003\u00a2\u0006\u0004\b1\u00102J\u0011\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0096\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0003H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\u0002\u001a\u0004\u0018\u00010\bH\u00d6\u0003R\"\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\"\u0010\"\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010&\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010\f\u001a\u0004\b$\u0010\u000e\"\u0004\b%\u0010\u0010R\"\u0010(\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010\u0013\u001a\u0004\b#\u0010\u0015\"\u0004\b'\u0010\u0017R\"\u0010,\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010\u0013\u001a\u0004\b*\u0010\u0015\"\u0004\b+\u0010\u0017R\"\u00100\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010\f\u001a\u0004\b.\u0010\u000e\"\u0004\b/\u0010\u0010\u00a8\u00063"}, d2 = {"Lzb3/d;", "", "other", "", "c", "", "toString", "hashCode", "", "", "equals", "d", "I", tl.h.F, "()I", DomainData.DOMAIN_NAME, "(I)V", "iAdId", "e", "Ljava/lang/String;", "k", "()Ljava/lang/String;", "r", "(Ljava/lang/String;)V", "triggerInfo", "f", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "picUrl", "Z", "l", "()Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Z)V", "isApng", "i", "getType", ReportConstant.COSTREPORT_PREFIX, "type", "o", WadlProxyConsts.KEY_JUMP_URL, BdhLogUtil.LogTag.Tag_Conn, "getVideoUrl", "t", AppConstants.Key.KEY_QZONE_VIDEO_URL, "D", "getOrderNum", "p", "orderNum", "<init>", "(ILjava/lang/String;Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: zb3.d, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ZootopiaBannerItem implements Comparable<ZootopiaBannerItem> {

    /* renamed from: C, reason: from kotlin metadata and from toString */
    private String videoUrl;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    private int orderNum;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int iAdId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private String triggerInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private String picUrl;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isApng;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private int type;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private String jumpUrl;

    public ZootopiaBannerItem() {
        this(0, null, null, false, 0, null, null, 0, 255, null);
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(ZootopiaBannerItem other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int i3 = this.orderNum - other.orderNum;
        if (i3 > 0) {
            return 1;
        }
        return i3 < 0 ? -1 : 0;
    }

    /* renamed from: h, reason: from getter */
    public final int getIAdId() {
        return this.iAdId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.iAdId * 31) + this.triggerInfo.hashCode()) * 31) + this.picUrl.hashCode()) * 31;
        boolean z16 = this.isApng;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((((((((hashCode + i3) * 31) + this.type) * 31) + this.jumpUrl.hashCode()) * 31) + this.videoUrl.hashCode()) * 31) + this.orderNum;
    }

    /* renamed from: i, reason: from getter */
    public final String getJumpUrl() {
        return this.jumpUrl;
    }

    /* renamed from: j, reason: from getter */
    public final String getPicUrl() {
        return this.picUrl;
    }

    /* renamed from: k, reason: from getter */
    public final String getTriggerInfo() {
        return this.triggerInfo;
    }

    /* renamed from: l, reason: from getter */
    public final boolean getIsApng() {
        return this.isApng;
    }

    public final void m(boolean z16) {
        this.isApng = z16;
    }

    public final void n(int i3) {
        this.iAdId = i3;
    }

    public final void o(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.jumpUrl = str;
    }

    public final void p(int i3) {
        this.orderNum = i3;
    }

    public final void q(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.picUrl = str;
    }

    public final void r(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.triggerInfo = str;
    }

    public final void s(int i3) {
        this.type = i3;
    }

    public final void t(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.videoUrl = str;
    }

    public String toString() {
        return "ZootopiaBannerItem(iAdId=" + this.iAdId + ", triggerInfo=" + this.triggerInfo + ", picUrl=" + this.picUrl + ", isApng=" + this.isApng + ", type=" + this.type + ", jumpUrl=" + this.jumpUrl + ", videoUrl=" + this.videoUrl + ", orderNum=" + this.orderNum + ")";
    }

    public ZootopiaBannerItem(int i3, String triggerInfo, String picUrl, boolean z16, int i16, String jumpUrl, String videoUrl, int i17) {
        Intrinsics.checkNotNullParameter(triggerInfo, "triggerInfo");
        Intrinsics.checkNotNullParameter(picUrl, "picUrl");
        Intrinsics.checkNotNullParameter(jumpUrl, "jumpUrl");
        Intrinsics.checkNotNullParameter(videoUrl, "videoUrl");
        this.iAdId = i3;
        this.triggerInfo = triggerInfo;
        this.picUrl = picUrl;
        this.isApng = z16;
        this.type = i16;
        this.jumpUrl = jumpUrl;
        this.videoUrl = videoUrl;
        this.orderNum = i17;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaBannerItem)) {
            return false;
        }
        ZootopiaBannerItem zootopiaBannerItem = (ZootopiaBannerItem) other;
        return this.iAdId == zootopiaBannerItem.iAdId && Intrinsics.areEqual(this.triggerInfo, zootopiaBannerItem.triggerInfo) && Intrinsics.areEqual(this.picUrl, zootopiaBannerItem.picUrl) && this.isApng == zootopiaBannerItem.isApng && this.type == zootopiaBannerItem.type && Intrinsics.areEqual(this.jumpUrl, zootopiaBannerItem.jumpUrl) && Intrinsics.areEqual(this.videoUrl, zootopiaBannerItem.videoUrl) && this.orderNum == zootopiaBannerItem.orderNum;
    }

    public /* synthetic */ ZootopiaBannerItem(int i3, String str, String str2, boolean z16, int i16, String str3, String str4, int i17, int i18, DefaultConstructorMarker defaultConstructorMarker) {
        this((i18 & 1) != 0 ? 0 : i3, (i18 & 2) != 0 ? "" : str, (i18 & 4) != 0 ? "" : str2, (i18 & 8) != 0 ? false : z16, (i18 & 16) != 0 ? -1 : i16, (i18 & 32) != 0 ? "" : str3, (i18 & 64) == 0 ? str4 : "", (i18 & 128) == 0 ? i17 : 0);
    }
}
