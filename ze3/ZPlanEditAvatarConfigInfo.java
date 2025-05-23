package ze3;

import com.google.gson.Gson;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nu4.f;
import nu4.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\tB3\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0016\u001a\u0004\b\t\u0010\u0017R\u0017\u0010\u001c\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u0010\u0010\u001b\u00a8\u0006 "}, d2 = {"Lze3/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "signature", "", "Lnu4/g;", "b", "[Lnu4/g;", "c", "()[Lnu4/g;", "headConfigs", "Lnu4/a;", "[Lnu4/a;", "()[Lnu4/a;", "backgroundConfigs", "Lnu4/f;", "Lnu4/f;", "()Lnu4/f;", "globalConfig", "<init>", "(Ljava/lang/String;[Lnu4/g;[Lnu4/a;Lnu4/f;)V", "e", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: ze3.b, reason: from toString */
/* loaded from: classes36.dex */
public final /* data */ class ZPlanEditAvatarConfigInfo {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final String signature;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final g[] headConfigs;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final nu4.a[] backgroundConfigs;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final f globalConfig;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lze3/b$a;", "", "Lze3/b;", "zPlanEditAvatarConfigInfo", "", "b", "jsonString", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: ze3.b$a, reason: from kotlin metadata */
    /* loaded from: classes36.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZPlanEditAvatarConfigInfo a(String jsonString) {
            Intrinsics.checkNotNullParameter(jsonString, "jsonString");
            try {
                return (ZPlanEditAvatarConfigInfo) new Gson().fromJson(jsonString, ZPlanEditAvatarConfigInfo.class);
            } catch (Throwable th5) {
                QLog.e("ZPlanEditAvatarConfig", 1, "fromJSONString error.", th5);
                return null;
            }
        }

        public final String b(ZPlanEditAvatarConfigInfo zPlanEditAvatarConfigInfo) {
            Intrinsics.checkNotNullParameter(zPlanEditAvatarConfigInfo, "zPlanEditAvatarConfigInfo");
            try {
                return new Gson().toJson(zPlanEditAvatarConfigInfo);
            } catch (Throwable th5) {
                QLog.e("ZPlanEditAvatarConfig", 1, "toJSONString error.", th5);
                return null;
            }
        }

        Companion() {
        }
    }

    public ZPlanEditAvatarConfigInfo(String signature, g[] headConfigs, nu4.a[] backgroundConfigs, f globalConfig) {
        Intrinsics.checkNotNullParameter(signature, "signature");
        Intrinsics.checkNotNullParameter(headConfigs, "headConfigs");
        Intrinsics.checkNotNullParameter(backgroundConfigs, "backgroundConfigs");
        Intrinsics.checkNotNullParameter(globalConfig, "globalConfig");
        this.signature = signature;
        this.headConfigs = headConfigs;
        this.backgroundConfigs = backgroundConfigs;
        this.globalConfig = globalConfig;
    }

    /* renamed from: a, reason: from getter */
    public final nu4.a[] getBackgroundConfigs() {
        return this.backgroundConfigs;
    }

    /* renamed from: b, reason: from getter */
    public final f getGlobalConfig() {
        return this.globalConfig;
    }

    /* renamed from: c, reason: from getter */
    public final g[] getHeadConfigs() {
        return this.headConfigs;
    }

    /* renamed from: d, reason: from getter */
    public final String getSignature() {
        return this.signature;
    }

    public int hashCode() {
        return (((((this.signature.hashCode() * 31) + Arrays.hashCode(this.headConfigs)) * 31) + Arrays.hashCode(this.backgroundConfigs)) * 31) + this.globalConfig.hashCode();
    }

    public String toString() {
        return "ZPlanEditAvatarConfigInfo(signature=" + this.signature + ", headConfigs=" + Arrays.toString(this.headConfigs) + ", backgroundConfigs=" + Arrays.toString(this.backgroundConfigs) + ", globalConfig=" + this.globalConfig + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ZPlanEditAvatarConfigInfo)) {
            return false;
        }
        ZPlanEditAvatarConfigInfo zPlanEditAvatarConfigInfo = (ZPlanEditAvatarConfigInfo) other;
        return Intrinsics.areEqual(this.signature, zPlanEditAvatarConfigInfo.signature) && Intrinsics.areEqual(this.headConfigs, zPlanEditAvatarConfigInfo.headConfigs) && Intrinsics.areEqual(this.backgroundConfigs, zPlanEditAvatarConfigInfo.backgroundConfigs) && Intrinsics.areEqual(this.globalConfig, zPlanEditAvatarConfigInfo.globalConfig);
    }
}
