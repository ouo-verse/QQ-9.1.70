package yu1;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0004\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b\t\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lyu1/e;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "dividerColor", "I", "c", "()I", "textColor", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable;", "()Landroid/graphics/drawable/Drawable;", "backgroundDrawable", "<init>", "(Ljava/lang/String;ILandroid/graphics/drawable/Drawable;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: yu1.e, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class SelectRoleStyle {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String dividerColor;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int textColor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Drawable backgroundDrawable;

    public SelectRoleStyle(@NotNull String dividerColor, int i3, @Nullable Drawable drawable) {
        Intrinsics.checkNotNullParameter(dividerColor, "dividerColor");
        this.dividerColor = dividerColor;
        this.textColor = i3;
        this.backgroundDrawable = drawable;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Drawable getBackgroundDrawable() {
        return this.backgroundDrawable;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getDividerColor() {
        return this.dividerColor;
    }

    /* renamed from: c, reason: from getter */
    public final int getTextColor() {
        return this.textColor;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SelectRoleStyle)) {
            return false;
        }
        SelectRoleStyle selectRoleStyle = (SelectRoleStyle) other;
        if (Intrinsics.areEqual(this.dividerColor, selectRoleStyle.dividerColor) && this.textColor == selectRoleStyle.textColor && Intrinsics.areEqual(this.backgroundDrawable, selectRoleStyle.backgroundDrawable)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((this.dividerColor.hashCode() * 31) + this.textColor) * 31;
        Drawable drawable = this.backgroundDrawable;
        if (drawable == null) {
            hashCode = 0;
        } else {
            hashCode = drawable.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "SelectRoleStyle(dividerColor=" + this.dividerColor + ", textColor=" + this.textColor + ", backgroundDrawable=" + this.backgroundDrawable + ")";
    }
}
