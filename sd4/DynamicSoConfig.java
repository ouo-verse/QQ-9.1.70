package sd4;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\t\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lsd4/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "soPath", "b", "soName", "Z", "()Z", "needLoad", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
/* renamed from: sd4.a, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class DynamicSoConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String soPath;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String soName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean needLoad;

    public DynamicSoConfig(@NotNull String soPath, @NotNull String soName, boolean z16) {
        Intrinsics.checkParameterIsNotNull(soPath, "soPath");
        Intrinsics.checkParameterIsNotNull(soName, "soName");
        this.soPath = soPath;
        this.soName = soName;
        this.needLoad = z16;
    }

    /* renamed from: a, reason: from getter */
    public final boolean getNeedLoad() {
        return this.needLoad;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getSoName() {
        return this.soName;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getSoPath() {
        return this.soPath;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof DynamicSoConfig) {
                DynamicSoConfig dynamicSoConfig = (DynamicSoConfig) other;
                if (!Intrinsics.areEqual(this.soPath, dynamicSoConfig.soPath) || !Intrinsics.areEqual(this.soName, dynamicSoConfig.soName) || this.needLoad != dynamicSoConfig.needLoad) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        String str = this.soPath;
        int i16 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = i3 * 31;
        String str2 = this.soName;
        if (str2 != null) {
            i16 = str2.hashCode();
        }
        int i18 = (i17 + i16) * 31;
        boolean z16 = this.needLoad;
        int i19 = z16;
        if (z16 != 0) {
            i19 = 1;
        }
        return i18 + i19;
    }

    @NotNull
    public String toString() {
        return "DynamicSoConfig(soPath=" + this.soPath + ", soName=" + this.soName + ", needLoad=" + this.needLoad + ")";
    }
}
