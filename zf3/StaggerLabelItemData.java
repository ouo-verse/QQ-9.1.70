package zf3;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.protobuf.nano.MessageNano;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pu4.g;
import pv4.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\nB\u001d\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lzf3/f;", "", "other", "", "equals", "", "toString", "", "hashCode", "Lpv4/o;", "a", "Lpv4/o;", "b", "()Lpv4/o;", "labelBtnInfo", "", "Ljava/util/List;", "()Ljava/util/List;", "idList", "<init>", "(Lpv4/o;Ljava/util/List;)V", "c", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: zf3.f, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class StaggerLabelItemData {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final o labelBtnInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final List<Integer> idList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lzf3/f$a;", "", "", "Lpv4/o;", TtmlNode.ATTR_TTS_ORIGIN, "Lzf3/f;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: zf3.f$a, reason: from kotlin metadata */
    /* loaded from: classes36.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:
        
            r2 = kotlin.collections.ArraysKt___ArraysKt.toList(r2);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final List<StaggerLabelItemData> a(List<o> origin) {
            List arrayList;
            ArrayList arrayList2 = new ArrayList();
            if (origin == null) {
                return arrayList2;
            }
            for (o oVar : origin) {
                if (oVar.f427645c != 2) {
                    QLog.e("StaggerLabelItemData_", 1, "convertToItemList item.type is not EI_INDEX_BUTTON_TYPE_FEEDS_TAGS!");
                } else {
                    pv4.c cVar = new pv4.c();
                    try {
                        MessageNano.mergeFrom(cVar, oVar.f427646d);
                    } catch (Exception unused) {
                        QLog.e("StaggerLabelItemData_", 1, "convertToItemList FeedsTagsInfo mergeFrom failed!");
                    }
                    int[] iArr = cVar.f427577a;
                    if (iArr == null || arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList2.add(new StaggerLabelItemData(oVar, arrayList));
                }
            }
            return arrayList2;
        }

        Companion() {
        }
    }

    public StaggerLabelItemData(o labelBtnInfo, List<Integer> idList) {
        Intrinsics.checkNotNullParameter(labelBtnInfo, "labelBtnInfo");
        Intrinsics.checkNotNullParameter(idList, "idList");
        this.labelBtnInfo = labelBtnInfo;
        this.idList = idList;
    }

    public final List<Integer> a() {
        return this.idList;
    }

    /* renamed from: b, reason: from getter */
    public final o getLabelBtnInfo() {
        return this.labelBtnInfo;
    }

    public boolean equals(Object other) {
        StaggerLabelItemData staggerLabelItemData = other instanceof StaggerLabelItemData ? (StaggerLabelItemData) other : null;
        if (staggerLabelItemData == null) {
            return false;
        }
        g gVar = this.labelBtnInfo.f427647e;
        String str = gVar != null ? gVar.f427435b : null;
        g gVar2 = staggerLabelItemData.labelBtnInfo.f427647e;
        if (!Intrinsics.areEqual(str, gVar2 != null ? gVar2.f427435b : null)) {
            return false;
        }
        g gVar3 = this.labelBtnInfo.f427647e;
        String str2 = gVar3 != null ? gVar3.f427434a : null;
        g gVar4 = staggerLabelItemData.labelBtnInfo.f427647e;
        if (!Intrinsics.areEqual(str2, gVar4 != null ? gVar4.f427434a : null)) {
            return false;
        }
        o oVar = this.labelBtnInfo;
        int i3 = oVar.f427645c;
        o oVar2 = staggerLabelItemData.labelBtnInfo;
        return i3 == oVar2.f427645c && Intrinsics.areEqual(oVar.f427644b, oVar2.f427644b) && Intrinsics.areEqual(this.labelBtnInfo.f427643a, staggerLabelItemData.labelBtnInfo.f427643a) && this.idList.containsAll(staggerLabelItemData.idList) && staggerLabelItemData.idList.containsAll(this.idList);
    }

    public int hashCode() {
        return (this.labelBtnInfo.hashCode() * 31) + this.idList.hashCode();
    }

    public String toString() {
        return "StaggerLabelItemData(labelBtnInfo=" + this.labelBtnInfo + ", idList=" + this.idList + ")";
    }
}
