package wk3;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u001a\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lwk3/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "enableDestroyWhenPause", "Z", "b", "()Z", "", "destroyInterval", "J", "a", "()J", "<init>", "(ZJ)V", "zplan_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: wk3.a, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class CoupleAvatarDestroyConfig {

    @SerializedName("destroy_interval")
    private final long destroyInterval;

    @SerializedName("enable_destroy_when_pause")
    private final boolean enableDestroyWhenPause;

    public CoupleAvatarDestroyConfig() {
        this(false, 0L, 3, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getDestroyInterval() {
        return this.destroyInterval;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getEnableDestroyWhenPause() {
        return this.enableDestroyWhenPause;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CoupleAvatarDestroyConfig)) {
            return false;
        }
        CoupleAvatarDestroyConfig coupleAvatarDestroyConfig = (CoupleAvatarDestroyConfig) other;
        if (this.enableDestroyWhenPause == coupleAvatarDestroyConfig.enableDestroyWhenPause && this.destroyInterval == coupleAvatarDestroyConfig.destroyInterval) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z16 = this.enableDestroyWhenPause;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        return (r06 * 31) + androidx.fragment.app.a.a(this.destroyInterval);
    }

    @NotNull
    public String toString() {
        return "CoupleAvatarDestroyConfig(enableDestroyWhenPause=" + this.enableDestroyWhenPause + ", destroyInterval=" + this.destroyInterval + ')';
    }

    public CoupleAvatarDestroyConfig(boolean z16, long j3) {
        this.enableDestroyWhenPause = z16;
        this.destroyInterval = j3;
    }

    public /* synthetic */ CoupleAvatarDestroyConfig(boolean z16, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? true : z16, (i3 & 2) != 0 ? 5000L : j3);
    }
}
