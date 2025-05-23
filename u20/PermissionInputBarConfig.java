package u20;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u0000 \u000f2\u00020\u0001:\u0001\tB\u0011\u0012\b\b\u0002\u0010\f\u001a\u00020\u0004\u00a2\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000b\u00a8\u0006\u0010"}, d2 = {"Lu20/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "totalCount", "<init>", "(I)V", "b", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: u20.b, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class PermissionInputBarConfig {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int totalCount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lu20/b$a;", "", "Lorg/json/JSONObject;", "Lu20/b;", "a", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: u20.b$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PermissionInputBarConfig a(@NotNull JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "<this>");
            if (jSONObject.length() == 0) {
                return new PermissionInputBarConfig(0, 1, null);
            }
            return new PermissionInputBarConfig(jSONObject.optInt("total_count"));
        }

        Companion() {
        }
    }

    public PermissionInputBarConfig() {
        this(0, 1, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getTotalCount() {
        return this.totalCount;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof PermissionInputBarConfig) && this.totalCount == ((PermissionInputBarConfig) other).totalCount) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.totalCount;
    }

    @NotNull
    public String toString() {
        return "PermissionInputBarConfig(totalCount=" + this.totalCount + ")";
    }

    public PermissionInputBarConfig(int i3) {
        this.totalCount = i3;
    }

    public /* synthetic */ PermissionInputBarConfig(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 3 : i3);
    }
}
