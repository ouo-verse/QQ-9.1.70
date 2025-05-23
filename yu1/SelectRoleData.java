package yu1;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ux1.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\r\u0012\u001a\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u0013\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0019\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u0011\u001a\u0004\u0018\u00010\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R+\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lyu1/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "channelId", "Lux1/e$a;", "b", "Lux1/e$a;", "()Lux1/e$a;", "onItemSelected", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "c", "Ljava/util/ArrayList;", "()Ljava/util/ArrayList;", "selectedRoleList", "Lyu1/e;", "d", "Lyu1/e;", "()Lyu1/e;", "style", "<init>", "(Ljava/lang/String;Lux1/e$a;Ljava/util/ArrayList;Lyu1/e;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: yu1.d, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class SelectRoleData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String channelId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final e.a onItemSelected;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final ArrayList<String> selectedRoleList;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final SelectRoleStyle style;

    public SelectRoleData(@Nullable String str, @Nullable e.a aVar, @Nullable ArrayList<String> arrayList, @Nullable SelectRoleStyle selectRoleStyle) {
        this.channelId = str;
        this.onItemSelected = aVar;
        this.selectedRoleList = arrayList;
        this.style = selectRoleStyle;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final e.a getOnItemSelected() {
        return this.onItemSelected;
    }

    @Nullable
    public final ArrayList<String> c() {
        return this.selectedRoleList;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final SelectRoleStyle getStyle() {
        return this.style;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectRoleData)) {
            return false;
        }
        SelectRoleData selectRoleData = (SelectRoleData) other;
        if (Intrinsics.areEqual(this.channelId, selectRoleData.channelId) && Intrinsics.areEqual(this.onItemSelected, selectRoleData.onItemSelected) && Intrinsics.areEqual(this.selectedRoleList, selectRoleData.selectedRoleList) && Intrinsics.areEqual(this.style, selectRoleData.style)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        String str = this.channelId;
        int i3 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i16 = hashCode * 31;
        e.a aVar = this.onItemSelected;
        if (aVar == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = aVar.hashCode();
        }
        int i17 = (i16 + hashCode2) * 31;
        ArrayList<String> arrayList = this.selectedRoleList;
        if (arrayList == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = arrayList.hashCode();
        }
        int i18 = (i17 + hashCode3) * 31;
        SelectRoleStyle selectRoleStyle = this.style;
        if (selectRoleStyle != null) {
            i3 = selectRoleStyle.hashCode();
        }
        return i18 + i3;
    }

    @NotNull
    public String toString() {
        return "SelectRoleData(channelId=" + this.channelId + ", onItemSelected=" + this.onItemSelected + ", selectedRoleList=" + this.selectedRoleList + ", style=" + this.style + ")";
    }
}
