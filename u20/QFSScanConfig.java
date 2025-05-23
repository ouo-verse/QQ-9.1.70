package u20;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\n\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\tB7\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0011\u0010\u0016R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0015\u001a\u0004\b\t\u0010\u0016R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\u0014\u0010\f\u00a8\u0006\u001d"}, d2 = {"Lu20/j;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "e", "()I", "maxCountOneCycle", "b", "f", "timeoutOneCycle", "c", "coolDownTime", "", "d", "D", "()D", "feedScanCpuRate", "cmtScanCpuRate", "maxCount", "<init>", "(IIIDDI)V", "g", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: u20.j, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class QFSScanConfig {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int maxCountOneCycle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int timeoutOneCycle;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int coolDownTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final double feedScanCpuRate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final double cmtScanCpuRate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final int maxCount;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lu20/j$a;", "", "Lorg/json/JSONObject;", "Lu20/j;", "a", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: u20.j$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final QFSScanConfig a(@NotNull JSONObject jSONObject) {
            int optInt;
            Intrinsics.checkNotNullParameter(jSONObject, "<this>");
            if (jSONObject.length() == 0) {
                return new QFSScanConfig(3000, 150, 100, 0.25d, 0.35d, 10000);
            }
            int optInt2 = jSONObject.optInt("max_count_on_cycle");
            int optInt3 = jSONObject.optInt("timeout_on_cycle");
            int optInt4 = jSONObject.optInt("cool_down_time");
            double optDouble = jSONObject.optDouble("feed_scan_cpu_rate");
            double optDouble2 = jSONObject.optDouble("cmt_scan_cpu_rate");
            if (jSONObject.optInt("max_count", -1) == -1) {
                optInt = 10000;
            } else {
                optInt = jSONObject.optInt("max_count", -1);
            }
            return new QFSScanConfig(optInt2, optInt3, optInt4, optDouble, optDouble2, optInt);
        }

        Companion() {
        }
    }

    public QFSScanConfig(int i3, int i16, int i17, double d16, double d17, int i18) {
        this.maxCountOneCycle = i3;
        this.timeoutOneCycle = i16;
        this.coolDownTime = i17;
        this.feedScanCpuRate = d16;
        this.cmtScanCpuRate = d17;
        this.maxCount = i18;
    }

    /* renamed from: a, reason: from getter */
    public final double getCmtScanCpuRate() {
        return this.cmtScanCpuRate;
    }

    /* renamed from: b, reason: from getter */
    public final int getCoolDownTime() {
        return this.coolDownTime;
    }

    /* renamed from: c, reason: from getter */
    public final double getFeedScanCpuRate() {
        return this.feedScanCpuRate;
    }

    /* renamed from: d, reason: from getter */
    public final int getMaxCount() {
        return this.maxCount;
    }

    /* renamed from: e, reason: from getter */
    public final int getMaxCountOneCycle() {
        return this.maxCountOneCycle;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QFSScanConfig)) {
            return false;
        }
        QFSScanConfig qFSScanConfig = (QFSScanConfig) other;
        if (this.maxCountOneCycle == qFSScanConfig.maxCountOneCycle && this.timeoutOneCycle == qFSScanConfig.timeoutOneCycle && this.coolDownTime == qFSScanConfig.coolDownTime && Double.compare(this.feedScanCpuRate, qFSScanConfig.feedScanCpuRate) == 0 && Double.compare(this.cmtScanCpuRate, qFSScanConfig.cmtScanCpuRate) == 0 && this.maxCount == qFSScanConfig.maxCount) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final int getTimeoutOneCycle() {
        return this.timeoutOneCycle;
    }

    public int hashCode() {
        return (((((((((this.maxCountOneCycle * 31) + this.timeoutOneCycle) * 31) + this.coolDownTime) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.feedScanCpuRate)) * 31) + com.tencent.biz.qqcircle.comment.recpic.a.a(this.cmtScanCpuRate)) * 31) + this.maxCount;
    }

    @NotNull
    public String toString() {
        return "QFSScanConfig(maxCountOneCycle=" + this.maxCountOneCycle + ", timeoutOneCycle=" + this.timeoutOneCycle + ", coolDownTime=" + this.coolDownTime + ", feedScanCpuRate=" + this.feedScanCpuRate + ", cmtScanCpuRate=" + this.cmtScanCpuRate + ", maxCount=" + this.maxCount + ")";
    }
}
