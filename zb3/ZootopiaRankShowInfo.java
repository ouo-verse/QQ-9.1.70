package zb3;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u000f\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\t\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0010\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lzb3/m;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TYPE, "getOpType", "opType", "c", "Ljava/lang/String;", "()Ljava/lang/String;", "showName", "d", "Z", "()Z", "isOn", "<init>", "(IILjava/lang/String;Z)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: zb3.m, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ZootopiaRankShowInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int showType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int opType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String showName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isOn;

    public ZootopiaRankShowInfo(int i3, int i16, String showName, boolean z16) {
        Intrinsics.checkNotNullParameter(showName, "showName");
        this.showType = i3;
        this.opType = i16;
        this.showName = showName;
        this.isOn = z16;
    }

    /* renamed from: a, reason: from getter */
    public final String getShowName() {
        return this.showName;
    }

    /* renamed from: b, reason: from getter */
    public final int getShowType() {
        return this.showType;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsOn() {
        return this.isOn;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((this.showType * 31) + this.opType) * 31) + this.showName.hashCode()) * 31;
        boolean z16 = this.isOn;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return hashCode + i3;
    }

    public String toString() {
        return "ZootopiaRankShowInfo(showType=" + this.showType + ", opType=" + this.opType + ", showName=" + this.showName + ", isOn=" + this.isOn + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaRankShowInfo)) {
            return false;
        }
        ZootopiaRankShowInfo zootopiaRankShowInfo = (ZootopiaRankShowInfo) other;
        return this.showType == zootopiaRankShowInfo.showType && this.opType == zootopiaRankShowInfo.opType && Intrinsics.areEqual(this.showName, zootopiaRankShowInfo.showName) && this.isOn == zootopiaRankShowInfo.isOn;
    }
}
