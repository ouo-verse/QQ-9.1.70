package r84;

import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import com.tencent.sqshow.zootopia.data.ZootopiaCardTitleData;
import com.tencent.sqshow.zootopia.data.ZootopiaTabConfigData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u001f\u001a\u00020\u0019\u0012\u000e\b\u0002\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\t\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010#\u001a\b\u0012\u0004\u0012\u00020 0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\f\u001a\u0004\b\u0012\u0010\r\"\u0004\b\"\u0010\u000f\u00a8\u0006&"}, d2 = {"Lr84/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/sqshow/zootopia/data/c;", "a", "Ljava/util/List;", "()Ljava/util/List;", "setHeaderCardList", "(Ljava/util/List;)V", "headerCardList", "Lcom/tencent/sqshow/zootopia/data/r;", "b", "Lcom/tencent/sqshow/zootopia/data/r;", "getTabConfig", "()Lcom/tencent/sqshow/zootopia/data/r;", "setTabConfig", "(Lcom/tencent/sqshow/zootopia/data/r;)V", "tabConfig", "Lcom/tencent/sqshow/zootopia/data/e;", "c", "Lcom/tencent/sqshow/zootopia/data/e;", "()Lcom/tencent/sqshow/zootopia/data/e;", "setTitleData", "(Lcom/tencent/sqshow/zootopia/data/e;)V", "titleData", "Lpu4/b;", "d", "setStoreItemList", "storeItemList", "<init>", "(Ljava/util/List;Lcom/tencent/sqshow/zootopia/data/r;Lcom/tencent/sqshow/zootopia/data/e;Ljava/util/List;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: r84.b, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ZootopiaBrandMallListData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private List<ZootopiaCardData> headerCardList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private ZootopiaTabConfigData tabConfig;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private ZootopiaCardTitleData titleData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private List<pu4.b> storeItemList;

    public ZootopiaBrandMallListData(List<ZootopiaCardData> headerCardList, ZootopiaTabConfigData zootopiaTabConfigData, ZootopiaCardTitleData titleData, List<pu4.b> storeItemList) {
        Intrinsics.checkNotNullParameter(headerCardList, "headerCardList");
        Intrinsics.checkNotNullParameter(titleData, "titleData");
        Intrinsics.checkNotNullParameter(storeItemList, "storeItemList");
        this.headerCardList = headerCardList;
        this.tabConfig = zootopiaTabConfigData;
        this.titleData = titleData;
        this.storeItemList = storeItemList;
    }

    public final List<ZootopiaCardData> a() {
        return this.headerCardList;
    }

    public final List<pu4.b> b() {
        return this.storeItemList;
    }

    /* renamed from: c, reason: from getter */
    public final ZootopiaCardTitleData getTitleData() {
        return this.titleData;
    }

    public int hashCode() {
        int hashCode = this.headerCardList.hashCode() * 31;
        ZootopiaTabConfigData zootopiaTabConfigData = this.tabConfig;
        return ((((hashCode + (zootopiaTabConfigData == null ? 0 : zootopiaTabConfigData.hashCode())) * 31) + this.titleData.hashCode()) * 31) + this.storeItemList.hashCode();
    }

    public String toString() {
        return "ZootopiaBrandMallListData(headerCardList=" + this.headerCardList + ", tabConfig=" + this.tabConfig + ", titleData=" + this.titleData + ", storeItemList=" + this.storeItemList + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaBrandMallListData)) {
            return false;
        }
        ZootopiaBrandMallListData zootopiaBrandMallListData = (ZootopiaBrandMallListData) other;
        return Intrinsics.areEqual(this.headerCardList, zootopiaBrandMallListData.headerCardList) && Intrinsics.areEqual(this.tabConfig, zootopiaBrandMallListData.tabConfig) && Intrinsics.areEqual(this.titleData, zootopiaBrandMallListData.titleData) && Intrinsics.areEqual(this.storeItemList, zootopiaBrandMallListData.storeItemList);
    }
}
