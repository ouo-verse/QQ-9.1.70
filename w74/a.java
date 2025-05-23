package w74;

import com.tencent.mobileqq.zplan.api.IZplanHandleApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import m94.j;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00032\u00020\u0001:\u0001\u000fB+\u0012\u0018\b\u0002\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0018j\b\u0012\u0004\u0012\u00020\t`\u0019\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0004\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0004J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016J\u0016\u0010\u0011\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\tJ\b\u0010\u0013\u001a\u00020\u0012H\u0016J\t\u0010\u0014\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\u0017\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u00d6\u0003R'\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0018j\b\u0012\u0004\u0012\u00020\t`\u00198\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001e\u00a8\u0006\""}, d2 = {"Lw74/a;", "Lm94/j;", "", "c", "", "e", "g", "d", "targetIndex", "Lw74/b;", "f", "targetCursor", h.F, "", "b", "a", IZplanHandleApi.BUSINESS_DRESS_INFO, "i", "", "toString", "hashCode", "", "other", "equals", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "getHistoryList", "()Ljava/util/ArrayList;", "historyList", "I", "historyCursor", "<init>", "(Ljava/util/ArrayList;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final /* data */ class a implements j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<UgcColorInfoData> historyList;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int historyCursor;

    public a() {
        this(null, 0, 3, 0 == true ? 1 : 0);
    }

    private final void c() {
        if (this.historyList.size() <= 30) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<UgcColorInfoData> arrayList2 = this.historyList;
        arrayList.addAll(arrayList2.subList(arrayList2.size() - 30, this.historyList.size()));
        this.historyList.clear();
        this.historyList.addAll(arrayList);
    }

    @Override // m94.j
    public boolean a() {
        return this.historyCursor < this.historyList.size() - 1;
    }

    @Override // m94.j
    public boolean b() {
        return this.historyCursor > 0;
    }

    public final void d() {
        if (this.historyList.size() <= 0) {
            return;
        }
        this.historyCursor = -1;
        this.historyList.clear();
    }

    /* renamed from: e, reason: from getter */
    public final int getHistoryCursor() {
        return this.historyCursor;
    }

    public final UgcColorInfoData f(int targetIndex) {
        UgcColorInfoData ugcColorInfoData = this.historyList.get(targetIndex);
        Intrinsics.checkNotNullExpressionValue(ugcColorInfoData, "historyList[targetIndex]");
        return ugcColorInfoData;
    }

    public final int g() {
        return this.historyList.size();
    }

    public final void h(int targetCursor) {
        QLog.i("UgcColorHistoryData", 1, "updateCursor targetCursor:" + targetCursor + ", historySize:" + this.historyList.size());
        if (targetCursor >= -1 && targetCursor < this.historyList.size()) {
            this.historyCursor = targetCursor;
        }
    }

    public int hashCode() {
        return (this.historyList.hashCode() * 31) + this.historyCursor;
    }

    public final void i(int targetIndex, UgcColorInfoData dressInfo) {
        int coerceAtMost;
        Intrinsics.checkNotNullParameter(dressInfo, "dressInfo");
        if (targetIndex < 0) {
            return;
        }
        if (targetIndex == 0) {
            this.historyList.clear();
            this.historyList.add(dressInfo);
        } else if (!this.historyList.isEmpty() && targetIndex != this.historyList.size()) {
            ArrayList<UgcColorInfoData> arrayList = this.historyList;
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(targetIndex, arrayList.size());
            ArrayList arrayList2 = new ArrayList(arrayList.subList(0, coerceAtMost));
            this.historyList.clear();
            this.historyList.addAll(arrayList2);
            this.historyList.add(dressInfo);
        } else {
            this.historyList.add(dressInfo);
        }
        c();
        this.historyCursor = this.historyList.size() - 1;
    }

    public String toString() {
        return "{historyCursor:" + this.historyCursor + ", historyList:" + this.historyList.size() + "}";
    }

    public a(ArrayList<UgcColorInfoData> historyList, int i3) {
        Intrinsics.checkNotNullParameter(historyList, "historyList");
        this.historyList = historyList;
        this.historyCursor = i3;
    }

    public /* synthetic */ a(ArrayList arrayList, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? new ArrayList() : arrayList, (i16 & 2) != 0 ? -1 : i3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof a)) {
            return false;
        }
        a aVar = (a) other;
        return Intrinsics.areEqual(this.historyList, aVar.historyList) && this.historyCursor == aVar.historyCursor;
    }
}
