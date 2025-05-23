package vx2;

import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lvx2/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "tipsContent", "I", "()I", "tipsColor", "<init>", "(Ljava/lang/String;I)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: vx2.c, reason: from toString */
/* loaded from: classes19.dex */
public final /* data */ class PlayerTips {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tipsContent;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int tipsColor;

    public PlayerTips(@NotNull String tipsContent, int i3) {
        Intrinsics.checkNotNullParameter(tipsContent, "tipsContent");
        this.tipsContent = tipsContent;
        this.tipsColor = i3;
    }

    /* renamed from: a, reason: from getter */
    public final int getTipsColor() {
        return this.tipsColor;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getTipsContent() {
        return this.tipsContent;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayerTips)) {
            return false;
        }
        PlayerTips playerTips = (PlayerTips) other;
        if (Intrinsics.areEqual(this.tipsContent, playerTips.tipsContent) && this.tipsColor == playerTips.tipsColor) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.tipsContent.hashCode() * 31) + this.tipsColor;
    }

    @NotNull
    public String toString() {
        return "PlayerTips(tipsContent=" + this.tipsContent + ", tipsColor=" + this.tipsColor + ")";
    }

    public /* synthetic */ PlayerTips(String str, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i16 & 2) != 0 ? R.color.f158017al3 : i3);
    }
}
