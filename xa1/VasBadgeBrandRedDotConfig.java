package xa1;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u000b2\u00020\u0001:\u0001\u0005B\u0011\u0012\b\b\u0002\u0010\b\u001a\u00020\u0004\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\u00a8\u0006\f"}, d2 = {"Lxa1/a;", "", "", "toString", "", "a", "I", "()I", "dayLimit", "<init>", "(I)V", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: xa1.a, reason: from toString */
/* loaded from: classes10.dex */
public final class VasBadgeBrandRedDotConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int dayLimit;

    public VasBadgeBrandRedDotConfig(int i3) {
        this.dayLimit = i3;
    }

    /* renamed from: a, reason: from getter */
    public final int getDayLimit() {
        return this.dayLimit;
    }

    @NotNull
    public String toString() {
        return "VasBadgeBrandRedDotConfig(dayLimit=" + this.dayLimit + ")";
    }

    public /* synthetic */ VasBadgeBrandRedDotConfig(int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 3 : i3);
    }
}
