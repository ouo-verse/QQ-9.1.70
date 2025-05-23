package vi3;

import com.google.gson.annotations.SerializedName;
import com.tencent.freesia.IConfigData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001a\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lvi3/b;", "Lcom/tencent/freesia/IConfigData;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lvi3/a;", "floatingViewCfg", "Lvi3/a;", "getFloatingViewCfg", "()Lvi3/a;", "<init>", "(Lvi3/a;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: vi3.b, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ModCloudConfig implements IConfigData {

    @SerializedName("floating_view")
    private final FloatingViewCfg floatingViewCfg;

    public ModCloudConfig() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public int hashCode() {
        return this.floatingViewCfg.hashCode();
    }

    public String toString() {
        return "ModCloudConfig(floatingViewCfg=" + this.floatingViewCfg + ")";
    }

    public ModCloudConfig(FloatingViewCfg floatingViewCfg) {
        Intrinsics.checkNotNullParameter(floatingViewCfg, "floatingViewCfg");
        this.floatingViewCfg = floatingViewCfg;
    }

    public /* synthetic */ ModCloudConfig(FloatingViewCfg floatingViewCfg, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? new FloatingViewCfg(false, 0, 3, null) : floatingViewCfg);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ModCloudConfig) && Intrinsics.areEqual(this.floatingViewCfg, ((ModCloudConfig) other).floatingViewCfg);
    }
}
