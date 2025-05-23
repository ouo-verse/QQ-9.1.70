package u20;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u0000 \u00112\u00020\u0001:\u0001\tB\u001b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lu20/m;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "b", "()I", "totalCount", WidgetCacheConstellationData.INTERVAL, "<init>", "(II)V", "c", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: u20.m, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class RecPanelGuideConfig {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int totalCount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int interval;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0002\u00a8\u0006\u0007"}, d2 = {"Lu20/m$a;", "", "Lorg/json/JSONObject;", "Lu20/m;", "a", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: u20.m$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final RecPanelGuideConfig a(@NotNull JSONObject jSONObject) {
            Intrinsics.checkNotNullParameter(jSONObject, "<this>");
            if (jSONObject.length() == 0) {
                int i3 = 0;
                return new RecPanelGuideConfig(i3, i3, 3, null);
            }
            return new RecPanelGuideConfig(jSONObject.optInt("total_count"), jSONObject.optInt(WidgetCacheConstellationData.INTERVAL));
        }

        Companion() {
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RecPanelGuideConfig() {
        this(r2, r2, 3, null);
        int i3 = 0;
    }

    /* renamed from: a, reason: from getter */
    public final int getInterval() {
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
        if (!(other instanceof RecPanelGuideConfig)) {
            return false;
        }
        RecPanelGuideConfig recPanelGuideConfig = (RecPanelGuideConfig) other;
        if (this.totalCount == recPanelGuideConfig.totalCount && this.interval == recPanelGuideConfig.interval) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.totalCount * 31) + this.interval;
    }

    @NotNull
    public String toString() {
        return "RecPanelGuideConfig(totalCount=" + this.totalCount + ", interval=" + this.interval + ")";
    }

    public RecPanelGuideConfig(int i3, int i16) {
        this.totalCount = i3;
        this.interval = i16;
    }

    public /* synthetic */ RecPanelGuideConfig(int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? 20 : i3, (i17 & 2) != 0 ? 60 : i16);
    }
}
