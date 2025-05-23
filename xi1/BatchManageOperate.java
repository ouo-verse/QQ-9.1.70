package xi1;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0014\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R$\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0016\u001a\u0004\b\u0013\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001b\u001a\u0004\b\t\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lxi1/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "selectMode", "", "Ljava/util/List;", "d", "()Ljava/util/List;", "selectedList", "c", "e", "unSelectedList", "Ljava/lang/String;", "()Ljava/lang/String;", "g", "(Ljava/lang/String;)V", "selectedDesc", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "f", "(Ljava/lang/Integer;)V", "selectCount", "<init>", "(ILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/Integer;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: xi1.a, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class BatchManageOperate {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int selectMode;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<String> selectedList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<String> unSelectedList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String selectedDesc;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Integer selectCount;

    public BatchManageOperate(int i3, @NotNull List<String> selectedList, @NotNull List<String> unSelectedList, @Nullable String str, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(selectedList, "selectedList");
        Intrinsics.checkNotNullParameter(unSelectedList, "unSelectedList");
        this.selectMode = i3;
        this.selectedList = selectedList;
        this.unSelectedList = unSelectedList;
        this.selectedDesc = str;
        this.selectCount = num;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Integer getSelectCount() {
        return this.selectCount;
    }

    /* renamed from: b, reason: from getter */
    public final int getSelectMode() {
        return this.selectMode;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final String getSelectedDesc() {
        return this.selectedDesc;
    }

    @NotNull
    public final List<String> d() {
        return this.selectedList;
    }

    @NotNull
    public final List<String> e() {
        return this.unSelectedList;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BatchManageOperate)) {
            return false;
        }
        BatchManageOperate batchManageOperate = (BatchManageOperate) other;
        if (this.selectMode == batchManageOperate.selectMode && Intrinsics.areEqual(this.selectedList, batchManageOperate.selectedList) && Intrinsics.areEqual(this.unSelectedList, batchManageOperate.unSelectedList) && Intrinsics.areEqual(this.selectedDesc, batchManageOperate.selectedDesc) && Intrinsics.areEqual(this.selectCount, batchManageOperate.selectCount)) {
            return true;
        }
        return false;
    }

    public final void f(@Nullable Integer num) {
        this.selectCount = num;
    }

    public final void g(@Nullable String str) {
        this.selectedDesc = str;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((this.selectMode * 31) + this.selectedList.hashCode()) * 31) + this.unSelectedList.hashCode()) * 31;
        String str = this.selectedDesc;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = (hashCode2 + hashCode) * 31;
        Integer num = this.selectCount;
        if (num != null) {
            i3 = num.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "BatchManageOperate(selectMode=" + this.selectMode + ", selectedList=" + this.selectedList + ", unSelectedList=" + this.unSelectedList + ", selectedDesc=" + this.selectedDesc + ", selectCount=" + this.selectCount + ")";
    }

    public /* synthetic */ BatchManageOperate(int i3, List list, List list2, String str, Integer num, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, list, list2, (i16 & 8) != 0 ? "" : str, (i16 & 16) != 0 ? 0 : num);
    }
}
