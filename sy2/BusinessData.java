package sy2;

import com.gcore.abase.utils.PatternUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u00042\u00020\u0001:\u0001\u000bB\u0017\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\f\u001a\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lsy2/a;", "", "", "b", "c", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getPackageName", "()Ljava/lang/String;", "packageName", "getBusiness", "business", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "QQCommon_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: sy2.a, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class BusinessData {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static final BusinessData f434970d = new BusinessData("", "");

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String packageName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String business;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lsy2/a$a;", "", "Lsy2/a;", PatternUtils.NO_MATCH, "Lsy2/a;", "a", "()Lsy2/a;", "<init>", "()V", "QQCommon_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: sy2.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes20.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final BusinessData a() {
            return BusinessData.f434970d;
        }

        Companion() {
        }
    }

    public BusinessData(@NotNull String packageName, @NotNull String business) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Intrinsics.checkNotNullParameter(business, "business");
        this.packageName = packageName;
        this.business = business;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getPackageName() {
        return this.packageName;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getBusiness() {
        return this.business;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BusinessData)) {
            return false;
        }
        BusinessData businessData = (BusinessData) other;
        if (Intrinsics.areEqual(this.packageName, businessData.packageName) && Intrinsics.areEqual(this.business, businessData.business)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.packageName.hashCode() * 31) + this.business.hashCode();
    }

    @NotNull
    public String toString() {
        return "BusinessData(packageName=" + this.packageName + ", business=" + this.business + ")";
    }
}
