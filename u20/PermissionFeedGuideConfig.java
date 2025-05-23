package u20;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\b\u0086\b\u0018\u0000 \u00182\u00020\u0001:\u0001\nB/\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0016\u0010\u0017J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0014\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0015\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0012\u00a8\u0006\u0019"}, d2 = {"Lu20/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "d", "()J", "videoProcess", "b", "I", "c", "()I", "totalCount", WidgetCacheConstellationData.INTERVAL, "feedPos", "<init>", "(JIJI)V", "e", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: u20.a, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class PermissionFeedGuideConfig {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long videoProcess;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int totalCount;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long interval;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int feedPos;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lu20/a$a;", "", "Lorg/json/JSONObject;", "Lu20/a;", "a", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: u20.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PermissionFeedGuideConfig a(@NotNull JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "<this>");
            if (jSONObject.length() == 0) {
                return new PermissionFeedGuideConfig(0L, 0, 0L, 0, 15, null);
            }
            return new PermissionFeedGuideConfig(jSONObject.optLong("video_process"), jSONObject.optInt("total_count"), jSONObject.optLong(WidgetCacheConstellationData.INTERVAL), jSONObject.optInt("feed_pos"));
        }

        Companion() {
        }
    }

    public PermissionFeedGuideConfig() {
        this(0L, 0, 0L, 0, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getFeedPos() {
        return this.feedPos;
    }

    /* renamed from: b, reason: from getter */
    public final long getInterval() {
        return this.interval;
    }

    /* renamed from: c, reason: from getter */
    public final int getTotalCount() {
        return this.totalCount;
    }

    /* renamed from: d, reason: from getter */
    public final long getVideoProcess() {
        return this.videoProcess;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PermissionFeedGuideConfig)) {
            return false;
        }
        PermissionFeedGuideConfig permissionFeedGuideConfig = (PermissionFeedGuideConfig) other;
        if (this.videoProcess == permissionFeedGuideConfig.videoProcess && this.totalCount == permissionFeedGuideConfig.totalCount && this.interval == permissionFeedGuideConfig.interval && this.feedPos == permissionFeedGuideConfig.feedPos) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((androidx.fragment.app.a.a(this.videoProcess) * 31) + this.totalCount) * 31) + androidx.fragment.app.a.a(this.interval)) * 31) + this.feedPos;
    }

    @NotNull
    public String toString() {
        return "PermissionFeedGuideConfig(videoProcess=" + this.videoProcess + ", totalCount=" + this.totalCount + ", interval=" + this.interval + ", feedPos=" + this.feedPos + ")";
    }

    public PermissionFeedGuideConfig(long j3, int i3, long j16, int i16) {
        this.videoProcess = j3;
        this.totalCount = i3;
        this.interval = j16;
        this.feedPos = i16;
    }

    public /* synthetic */ PermissionFeedGuideConfig(long j3, int i3, long j16, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 3L : j3, (i17 & 2) != 0 ? 5 : i3, (i17 & 4) != 0 ? com.tencent.qqnt.chats.core.b.b() * 6 : j16, (i17 & 8) != 0 ? 2 : i16);
    }
}
