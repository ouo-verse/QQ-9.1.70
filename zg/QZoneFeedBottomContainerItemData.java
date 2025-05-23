package zg;

import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001f\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0007\u0012\b\b\u0002\u0010!\u001a\u00020\u0005\u0012\b\b\u0002\u0010#\u001a\u00020\u0005\u00a2\u0006\u0004\b$\u0010%J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\"\u0010\u0018\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\"\u0010\u001b\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u001a\u0010\u000eR\"\u0010!\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010#\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001c\u001a\u0004\b\u0019\u0010\u001e\"\u0004\b\"\u0010 \u00a8\u0006&"}, d2 = {"Lzg/a;", "", "other", "", "equals", "", "hashCode", "", "toString", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "k", "(Ljava/lang/String;)V", "name", "b", "i", "icon", "c", "j", "jumpurl", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "e", "g", "adID", "I", "getAdPosID", "()I", h.F, "(I)V", "adPosID", "l", "order", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: zg.a, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class QZoneFeedBottomContainerItemData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private String name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private String icon;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private String jumpurl;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private String traceInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private String adID;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private int adPosID;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private int order;

    public QZoneFeedBottomContainerItemData() {
        this(null, null, null, null, null, 0, 0, 127, null);
    }

    /* renamed from: a, reason: from getter */
    public final String getAdID() {
        return this.adID;
    }

    /* renamed from: b, reason: from getter */
    public final String getIcon() {
        return this.icon;
    }

    /* renamed from: c, reason: from getter */
    public final String getJumpurl() {
        return this.jumpurl;
    }

    /* renamed from: d, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: e, reason: from getter */
    public final int getOrder() {
        return this.order;
    }

    /* renamed from: f, reason: from getter */
    public final String getTraceInfo() {
        return this.traceInfo;
    }

    public final void g(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.adID = str;
    }

    public final void h(int i3) {
        this.adPosID = i3;
    }

    public int hashCode() {
        return this.adID.hashCode();
    }

    public final void i(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.icon = str;
    }

    public final void j(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.jumpurl = str;
    }

    public final void k(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.name = str;
    }

    public final void l(int i3) {
        this.order = i3;
    }

    public final void m(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.traceInfo = str;
    }

    public String toString() {
        return "QZoneFeedBottomContainerItemData(name=" + this.name + ", icon=" + this.icon + ", jumpurl=" + this.jumpurl + ", traceInfo=" + this.traceInfo + ", adID=" + this.adID + ", adPosID=" + this.adPosID + ", order=" + this.order + ")";
    }

    public QZoneFeedBottomContainerItemData(String name, String icon, String jumpurl, String traceInfo, String adID, int i3, int i16) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(jumpurl, "jumpurl");
        Intrinsics.checkNotNullParameter(traceInfo, "traceInfo");
        Intrinsics.checkNotNullParameter(adID, "adID");
        this.name = name;
        this.icon = icon;
        this.jumpurl = jumpurl;
        this.traceInfo = traceInfo;
        this.adID = adID;
        this.adPosID = i3;
        this.order = i16;
    }

    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof QZoneFeedBottomContainerItemData) {
            return Intrinsics.areEqual(this.adID, ((QZoneFeedBottomContainerItemData) other).adID);
        }
        return false;
    }

    public /* synthetic */ QZoneFeedBottomContainerItemData(String str, String str2, String str3, String str4, String str5, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? "" : str, (i17 & 2) != 0 ? "" : str2, (i17 & 4) != 0 ? "" : str3, (i17 & 8) != 0 ? "" : str4, (i17 & 16) == 0 ? str5 : "", (i17 & 32) != 0 ? 0 : i3, (i17 & 64) != 0 ? 0 : i16);
    }
}
