package zb3;

import com.tencent.sqshow.zootopia.data.ZootopiaMapSimpleInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R(\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lzb3/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "Lcom/tencent/sqshow/zootopia/data/ZootopiaMapSimpleInfo;", "a", "Ljava/util/List;", "()Ljava/util/List;", "setMapSimpleInfoList", "(Ljava/util/List;)V", "mapSimpleInfoList", "Lzb3/n;", "b", "Lzb3/n;", "()Lzb3/n;", "setSameStyleData", "(Lzb3/n;)V", "sameStyleData", "<init>", "(Ljava/util/List;Lzb3/n;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: zb3.i, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ZootopiaMapListData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private List<ZootopiaMapSimpleInfo> mapSimpleInfoList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private ZootopiaSameStyleData sameStyleData;

    public ZootopiaMapListData() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public final List<ZootopiaMapSimpleInfo> a() {
        return this.mapSimpleInfoList;
    }

    /* renamed from: b, reason: from getter */
    public final ZootopiaSameStyleData getSameStyleData() {
        return this.sameStyleData;
    }

    public int hashCode() {
        int hashCode = this.mapSimpleInfoList.hashCode() * 31;
        ZootopiaSameStyleData zootopiaSameStyleData = this.sameStyleData;
        return hashCode + (zootopiaSameStyleData == null ? 0 : zootopiaSameStyleData.hashCode());
    }

    public String toString() {
        return "ZootopiaMapListData(mapSimpleInfoList=" + this.mapSimpleInfoList + ", sameStyleData=" + this.sameStyleData + ")";
    }

    public ZootopiaMapListData(List<ZootopiaMapSimpleInfo> mapSimpleInfoList, ZootopiaSameStyleData zootopiaSameStyleData) {
        Intrinsics.checkNotNullParameter(mapSimpleInfoList, "mapSimpleInfoList");
        this.mapSimpleInfoList = mapSimpleInfoList;
        this.sameStyleData = zootopiaSameStyleData;
    }

    public /* synthetic */ ZootopiaMapListData(List list, ZootopiaSameStyleData zootopiaSameStyleData, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new ArrayList() : list, (i3 & 2) != 0 ? null : zootopiaSameStyleData);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaMapListData)) {
            return false;
        }
        ZootopiaMapListData zootopiaMapListData = (ZootopiaMapListData) other;
        return Intrinsics.areEqual(this.mapSimpleInfoList, zootopiaMapListData.mapSimpleInfoList) && Intrinsics.areEqual(this.sameStyleData, zootopiaMapListData.sameStyleData);
    }
}
