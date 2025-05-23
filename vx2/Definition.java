package vx2;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lvx2/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "definitionId", "b", "showName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: vx2.a, reason: from toString */
/* loaded from: classes19.dex */
public final /* data */ class Definition {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String definitionId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String showName;

    public Definition(@NotNull String definitionId, @NotNull String showName) {
        Intrinsics.checkNotNullParameter(definitionId, "definitionId");
        Intrinsics.checkNotNullParameter(showName, "showName");
        this.definitionId = definitionId;
        this.showName = showName;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getDefinitionId() {
        return this.definitionId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getShowName() {
        return this.showName;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Definition)) {
            return false;
        }
        Definition definition = (Definition) other;
        if (Intrinsics.areEqual(this.definitionId, definition.definitionId) && Intrinsics.areEqual(this.showName, definition.showName)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.definitionId.hashCode() * 31) + this.showName.hashCode();
    }

    @NotNull
    public String toString() {
        return "Definition(definitionId=" + this.definitionId + ", showName=" + this.showName + ")";
    }
}
