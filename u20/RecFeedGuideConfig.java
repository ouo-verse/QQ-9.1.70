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
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0014\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\nB/\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\t\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0011\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0016\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0019\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Lu20/l;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "getVideoProcess", "()J", "videoProcess", "b", "getInterval", WidgetCacheConstellationData.INTERVAL, "c", "I", "getTotalCount", "()I", "totalCount", "d", "getFeedPos", "feedPos", "<init>", "(JJII)V", "e", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: u20.l, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class RecFeedGuideConfig {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long videoProcess;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long interval;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int totalCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int feedPos;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lu20/l$a;", "", "Lorg/json/JSONObject;", "Lu20/l;", "a", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: u20.l$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RecFeedGuideConfig a(@NotNull JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "<this>");
            if (jSONObject.length() == 0) {
                return new RecFeedGuideConfig(0L, 0L, 0, 0, 15, null);
            }
            return new RecFeedGuideConfig(jSONObject.optLong("video_process"), jSONObject.optLong(WidgetCacheConstellationData.INTERVAL), jSONObject.optInt("total_count"), jSONObject.optInt("feed_pos"));
        }

        Companion() {
        }
    }

    public RecFeedGuideConfig() {
        this(0L, 0L, 0, 0, 15, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RecFeedGuideConfig)) {
            return false;
        }
        RecFeedGuideConfig recFeedGuideConfig = (RecFeedGuideConfig) other;
        if (this.videoProcess == recFeedGuideConfig.videoProcess && this.interval == recFeedGuideConfig.interval && this.totalCount == recFeedGuideConfig.totalCount && this.feedPos == recFeedGuideConfig.feedPos) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((androidx.fragment.app.a.a(this.videoProcess) * 31) + androidx.fragment.app.a.a(this.interval)) * 31) + this.totalCount) * 31) + this.feedPos;
    }

    @NotNull
    public String toString() {
        return "RecFeedGuideConfig(videoProcess=" + this.videoProcess + ", interval=" + this.interval + ", totalCount=" + this.totalCount + ", feedPos=" + this.feedPos + ")";
    }

    public RecFeedGuideConfig(long j3, long j16, int i3, int i16) {
        this.videoProcess = j3;
        this.interval = j16;
        this.totalCount = i3;
        this.feedPos = i16;
    }

    public /* synthetic */ RecFeedGuideConfig(long j3, long j16, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 3L : j3, (i17 & 2) != 0 ? JoinTimeType.THIRTY_MINUTES : j16, (i17 & 4) != 0 ? 10 : i3, (i17 & 8) != 0 ? 2 : i16);
    }
}
