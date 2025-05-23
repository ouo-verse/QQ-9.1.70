package yx1;

import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u0012\u0006\u0010\u001a\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0013\u0010\fR\"\u0010\u001a\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0016\u001a\u0004\b\u0010\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001c\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lyx1/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "e", "()Z", "f", "(Z)V", "isSelect", "b", "c", "isEnable", "d", "isRemoteSelected", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "()Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "setRole", "(Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;)V", "role", "()Ljava/lang/String;", "id", "<init>", "(ZZZLcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: yx1.e, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class RoleSelectItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isSelect;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isEnable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isRemoteSelected;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private RoleGroupModel role;

    public RoleSelectItem(boolean z16, boolean z17, boolean z18, @NotNull RoleGroupModel role) {
        Intrinsics.checkNotNullParameter(role, "role");
        this.isSelect = z16;
        this.isEnable = z17;
        this.isRemoteSelected = z18;
        this.role = role;
    }

    @NotNull
    public final String a() {
        return this.role.getId();
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final RoleGroupModel getRole() {
        return this.role;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getIsEnable() {
        return this.isEnable;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getIsRemoteSelected() {
        return this.isRemoteSelected;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RoleSelectItem)) {
            return false;
        }
        RoleSelectItem roleSelectItem = (RoleSelectItem) other;
        if (this.isSelect == roleSelectItem.isSelect && this.isEnable == roleSelectItem.isEnable && this.isRemoteSelected == roleSelectItem.isRemoteSelected && Intrinsics.areEqual(this.role, roleSelectItem.role)) {
            return true;
        }
        return false;
    }

    public final void f(boolean z16) {
        this.isSelect = z16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z16 = this.isSelect;
        int i3 = 1;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i16 = r06 * 31;
        ?? r26 = this.isEnable;
        int i17 = r26;
        if (r26 != 0) {
            i17 = 1;
        }
        int i18 = (i16 + i17) * 31;
        boolean z17 = this.isRemoteSelected;
        if (!z17) {
            i3 = z17 ? 1 : 0;
        }
        return ((i18 + i3) * 31) + this.role.hashCode();
    }

    @NotNull
    public String toString() {
        return "RoleSelectItem(isSelect=" + this.isSelect + ", isEnable=" + this.isEnable + ", isRemoteSelected=" + this.isRemoteSelected + ", role=" + this.role + ")";
    }
}
