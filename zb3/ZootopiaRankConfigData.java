package zb3;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001Bu\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u001a\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010%\u001a\u00020\u0002\u0012\u0006\u0010'\u001a\u00020\u0002\u0012\u0006\u0010)\u001a\u00020\u0004\u0012\u0006\u0010+\u001a\u00020\u0002\u0012\f\u00101\u001a\b\u0012\u0004\u0012\u00020-0,\u00a2\u0006\u0004\b2\u00103J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0015\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0019\u0010\u0014R\u0017\u0010\u001c\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u0017\u0010\u001f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\n\u001a\u0004\b\u001e\u0010\fR\u0017\u0010\"\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0014R\u0017\u0010%\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b#\u0010\u0012\u001a\u0004\b$\u0010\u0014R\u0017\u0010'\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u0012\u001a\u0004\b\u000e\u0010\u0014R\u0017\u0010)\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b(\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010+\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b*\u0010\u0012\u001a\u0004\b\u0011\u0010\u0014R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020-0,8\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b\u001b\u00100\u00a8\u00064"}, d2 = {"Lzb3/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getMapId", "()I", "mapId", "b", "getRankId", "rankId", "c", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "rankTable", "getRankTableSort", "rankTableSort", "e", "getRankTableSortPrefix", "rankTableSortPrefix", "f", "rankTableSortSuffix", "g", "getRankType", "rankType", tl.h.F, "getRankTimeOpen", "rankTimeOpen", "i", "getRankTimeClose", "rankTimeClose", "j", "rankHelpDesc", "k", "rankDataMax", "l", "rankIcon", "", "Lzb3/m;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "()Ljava/util/List;", "showInfoList", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/util/List;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: zb3.j, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ZootopiaRankConfigData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int mapId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int rankId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final String rankTable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final String rankTableSort;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String rankTableSortPrefix;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final String rankTableSortSuffix;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private final int rankType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private final String rankTimeOpen;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private final String rankTimeClose;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private final String rankHelpDesc;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private final int rankDataMax;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private final String rankIcon;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<ZootopiaRankShowInfo> showInfoList;

    public ZootopiaRankConfigData(int i3, int i16, String rankTable, String rankTableSort, String rankTableSortPrefix, String rankTableSortSuffix, int i17, String rankTimeOpen, String rankTimeClose, String rankHelpDesc, int i18, String rankIcon, List<ZootopiaRankShowInfo> showInfoList) {
        Intrinsics.checkNotNullParameter(rankTable, "rankTable");
        Intrinsics.checkNotNullParameter(rankTableSort, "rankTableSort");
        Intrinsics.checkNotNullParameter(rankTableSortPrefix, "rankTableSortPrefix");
        Intrinsics.checkNotNullParameter(rankTableSortSuffix, "rankTableSortSuffix");
        Intrinsics.checkNotNullParameter(rankTimeOpen, "rankTimeOpen");
        Intrinsics.checkNotNullParameter(rankTimeClose, "rankTimeClose");
        Intrinsics.checkNotNullParameter(rankHelpDesc, "rankHelpDesc");
        Intrinsics.checkNotNullParameter(rankIcon, "rankIcon");
        Intrinsics.checkNotNullParameter(showInfoList, "showInfoList");
        this.mapId = i3;
        this.rankId = i16;
        this.rankTable = rankTable;
        this.rankTableSort = rankTableSort;
        this.rankTableSortPrefix = rankTableSortPrefix;
        this.rankTableSortSuffix = rankTableSortSuffix;
        this.rankType = i17;
        this.rankTimeOpen = rankTimeOpen;
        this.rankTimeClose = rankTimeClose;
        this.rankHelpDesc = rankHelpDesc;
        this.rankDataMax = i18;
        this.rankIcon = rankIcon;
        this.showInfoList = showInfoList;
    }

    /* renamed from: a, reason: from getter */
    public final int getRankDataMax() {
        return this.rankDataMax;
    }

    /* renamed from: b, reason: from getter */
    public final String getRankHelpDesc() {
        return this.rankHelpDesc;
    }

    /* renamed from: c, reason: from getter */
    public final String getRankIcon() {
        return this.rankIcon;
    }

    /* renamed from: d, reason: from getter */
    public final String getRankTable() {
        return this.rankTable;
    }

    /* renamed from: e, reason: from getter */
    public final String getRankTableSortSuffix() {
        return this.rankTableSortSuffix;
    }

    public final List<ZootopiaRankShowInfo> f() {
        return this.showInfoList;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.mapId * 31) + this.rankId) * 31) + this.rankTable.hashCode()) * 31) + this.rankTableSort.hashCode()) * 31) + this.rankTableSortPrefix.hashCode()) * 31) + this.rankTableSortSuffix.hashCode()) * 31) + this.rankType) * 31) + this.rankTimeOpen.hashCode()) * 31) + this.rankTimeClose.hashCode()) * 31) + this.rankHelpDesc.hashCode()) * 31) + this.rankDataMax) * 31) + this.rankIcon.hashCode()) * 31) + this.showInfoList.hashCode();
    }

    public String toString() {
        return "ZootopiaRankConfigData(mapId=" + this.mapId + ", rankId=" + this.rankId + ", rankTable=" + this.rankTable + ", rankTableSort=" + this.rankTableSort + ", rankTableSortPrefix=" + this.rankTableSortPrefix + ", rankTableSortSuffix=" + this.rankTableSortSuffix + ", rankType=" + this.rankType + ", rankTimeOpen=" + this.rankTimeOpen + ", rankTimeClose=" + this.rankTimeClose + ", rankHelpDesc=" + this.rankHelpDesc + ", rankDataMax=" + this.rankDataMax + ", rankIcon=" + this.rankIcon + ", showInfoList=" + this.showInfoList + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaRankConfigData)) {
            return false;
        }
        ZootopiaRankConfigData zootopiaRankConfigData = (ZootopiaRankConfigData) other;
        return this.mapId == zootopiaRankConfigData.mapId && this.rankId == zootopiaRankConfigData.rankId && Intrinsics.areEqual(this.rankTable, zootopiaRankConfigData.rankTable) && Intrinsics.areEqual(this.rankTableSort, zootopiaRankConfigData.rankTableSort) && Intrinsics.areEqual(this.rankTableSortPrefix, zootopiaRankConfigData.rankTableSortPrefix) && Intrinsics.areEqual(this.rankTableSortSuffix, zootopiaRankConfigData.rankTableSortSuffix) && this.rankType == zootopiaRankConfigData.rankType && Intrinsics.areEqual(this.rankTimeOpen, zootopiaRankConfigData.rankTimeOpen) && Intrinsics.areEqual(this.rankTimeClose, zootopiaRankConfigData.rankTimeClose) && Intrinsics.areEqual(this.rankHelpDesc, zootopiaRankConfigData.rankHelpDesc) && this.rankDataMax == zootopiaRankConfigData.rankDataMax && Intrinsics.areEqual(this.rankIcon, zootopiaRankConfigData.rankIcon) && Intrinsics.areEqual(this.showInfoList, zootopiaRankConfigData.showInfoList);
    }
}
