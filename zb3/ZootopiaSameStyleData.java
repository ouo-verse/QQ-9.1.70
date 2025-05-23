package zb3;

import com.tencent.sqshow.zootopia.samestyle.ZPlanTemplate;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\t\u0010\u0012\"\u0004\b\u0013\u0010\u0014R(\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\u0010\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lzb3/n;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setTitleName", "(Ljava/lang/String;)V", "titleName", "b", "I", "()I", "setOrder", "(I)V", "order", "", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplate;", "Ljava/util/List;", "()Ljava/util/List;", "setSameStyleList", "(Ljava/util/List;)V", "sameStyleList", "<init>", "(Ljava/lang/String;ILjava/util/List;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: zb3.n, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ZootopiaSameStyleData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private String titleName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int order;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private List<ZPlanTemplate> sameStyleList;

    public ZootopiaSameStyleData() {
        this(null, 0, null, 7, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getOrder() {
        return this.order;
    }

    public final List<ZPlanTemplate> b() {
        return this.sameStyleList;
    }

    /* renamed from: c, reason: from getter */
    public final String getTitleName() {
        return this.titleName;
    }

    public int hashCode() {
        return (((this.titleName.hashCode() * 31) + this.order) * 31) + this.sameStyleList.hashCode();
    }

    public String toString() {
        return "ZootopiaSameStyleData(titleName=" + this.titleName + ", order=" + this.order + ", sameStyleList=" + this.sameStyleList + ")";
    }

    public ZootopiaSameStyleData(String titleName, int i3, List<ZPlanTemplate> sameStyleList) {
        Intrinsics.checkNotNullParameter(titleName, "titleName");
        Intrinsics.checkNotNullParameter(sameStyleList, "sameStyleList");
        this.titleName = titleName;
        this.order = i3;
        this.sameStyleList = sameStyleList;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZootopiaSameStyleData)) {
            return false;
        }
        ZootopiaSameStyleData zootopiaSameStyleData = (ZootopiaSameStyleData) other;
        return Intrinsics.areEqual(this.titleName, zootopiaSameStyleData.titleName) && this.order == zootopiaSameStyleData.order && Intrinsics.areEqual(this.sameStyleList, zootopiaSameStyleData.sameStyleList);
    }

    public /* synthetic */ ZootopiaSameStyleData(String str, int i3, List list, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? "" : str, (i16 & 2) != 0 ? 1 : i3, (i16 & 4) != 0 ? new ArrayList() : list);
    }
}
