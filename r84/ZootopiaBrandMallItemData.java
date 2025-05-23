package r84;

import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u00192\u00020\u0001:\u0001\nB#\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\n\u0010\u0012R\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0014\u001a\u0004\b\u0010\u0010\u0015\u00a8\u0006\u001a"}, d2 = {"Lr84/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/sqshow/zootopia/data/c;", "a", "Lcom/tencent/sqshow/zootopia/data/c;", "c", "()Lcom/tencent/sqshow/zootopia/data/c;", "cardData", "Lpu4/b;", "b", "Lpu4/b;", "()Lpu4/b;", "brandStore", "I", "()I", "brandStoreIndex", "<init>", "(Lcom/tencent/sqshow/zootopia/data/c;Lpu4/b;I)V", "d", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: r84.a, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ZootopiaBrandMallItemData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final ZootopiaCardData cardData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final pu4.b brandStore;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int brandStoreIndex;

    public ZootopiaBrandMallItemData(ZootopiaCardData zootopiaCardData, pu4.b bVar, int i3) {
        this.cardData = zootopiaCardData;
        this.brandStore = bVar;
        this.brandStoreIndex = i3;
    }

    /* renamed from: a, reason: from getter */
    public final pu4.b getBrandStore() {
        return this.brandStore;
    }

    /* renamed from: b, reason: from getter */
    public final int getBrandStoreIndex() {
        return this.brandStoreIndex;
    }

    /* renamed from: c, reason: from getter */
    public final ZootopiaCardData getCardData() {
        return this.cardData;
    }

    public int hashCode() {
        ZootopiaCardData zootopiaCardData = this.cardData;
        int hashCode = (zootopiaCardData == null ? 0 : zootopiaCardData.hashCode()) * 31;
        pu4.b bVar = this.brandStore;
        return ((hashCode + (bVar != null ? bVar.hashCode() : 0)) * 31) + this.brandStoreIndex;
    }

    public String toString() {
        return "ZootopiaBrandMallItemData(cardData=" + this.cardData + ", brandStore=" + this.brandStore + ", brandStoreIndex=" + this.brandStoreIndex + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaBrandMallItemData)) {
            return false;
        }
        ZootopiaBrandMallItemData zootopiaBrandMallItemData = (ZootopiaBrandMallItemData) other;
        return Intrinsics.areEqual(this.cardData, zootopiaBrandMallItemData.cardData) && Intrinsics.areEqual(this.brandStore, zootopiaBrandMallItemData.brandStore) && this.brandStoreIndex == zootopiaBrandMallItemData.brandStoreIndex;
    }
}
