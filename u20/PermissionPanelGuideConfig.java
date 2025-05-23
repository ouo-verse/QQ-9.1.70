package u20;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.guild.setting.guildmanage.speak.threshold.model.JoinTimeType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0001\tB\u001b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lu20/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "totalCount", "", "J", "()J", WidgetCacheConstellationData.INTERVAL, "<init>", "(IJ)V", "c", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: u20.c, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class PermissionPanelGuideConfig {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int totalCount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long interval;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lu20/c$a;", "", "Lorg/json/JSONObject;", "Lu20/c;", "a", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: u20.c$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PermissionPanelGuideConfig a(@NotNull JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "<this>");
            if (jSONObject.length() == 0) {
                return new PermissionPanelGuideConfig(0, 0L, 3, null);
            }
            return new PermissionPanelGuideConfig(jSONObject.optInt("total_count"), jSONObject.optLong(WidgetCacheConstellationData.INTERVAL));
        }

        Companion() {
        }
    }

    public PermissionPanelGuideConfig() {
        this(0, 0L, 3, null);
    }

    /* renamed from: a, reason: from getter */
    public final long getInterval() {
        return this.interval;
    }

    /* renamed from: b, reason: from getter */
    public final int getTotalCount() {
        return this.totalCount;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PermissionPanelGuideConfig)) {
            return false;
        }
        PermissionPanelGuideConfig permissionPanelGuideConfig = (PermissionPanelGuideConfig) other;
        if (this.totalCount == permissionPanelGuideConfig.totalCount && this.interval == permissionPanelGuideConfig.interval) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.totalCount * 31) + androidx.fragment.app.a.a(this.interval);
    }

    @NotNull
    public String toString() {
        return "PermissionPanelGuideConfig(totalCount=" + this.totalCount + ", interval=" + this.interval + ")";
    }

    public PermissionPanelGuideConfig(int i3, long j3) {
        this.totalCount = i3;
        this.interval = j3;
    }

    public /* synthetic */ PermissionPanelGuideConfig(int i3, long j3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this((i16 & 1) != 0 ? 10 : i3, (i16 & 2) != 0 ? JoinTimeType.THREE_HOUR : j3);
    }
}
