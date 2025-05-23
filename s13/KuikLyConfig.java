package s13;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010$\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u0012\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\n\u001a\u0004\b\t\u0010\f\"\u0004\b\u0013\u0010\u000eR0\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Ls13/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "setPageName", "(Ljava/lang/String;)V", "pageName", "b", "setModuleName", "moduleName", "setEventName", AdMetricTag.EVENT_NAME, "", "d", "Ljava/util/Map;", "()Ljava/util/Map;", "setParams", "(Ljava/util/Map;)V", "params", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "vas_api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: s13.a, reason: from toString */
/* loaded from: classes20.dex */
public final /* data */ class KuikLyConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String pageName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String moduleName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String eventName;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private Map<String, String> params;

    public KuikLyConfig() {
        this(null, null, null, null, 15, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getEventName() {
        return this.eventName;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getModuleName() {
        return this.moduleName;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getPageName() {
        return this.pageName;
    }

    @Nullable
    public final Map<String, String> d() {
        return this.params;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof KuikLyConfig)) {
            return false;
        }
        KuikLyConfig kuikLyConfig = (KuikLyConfig) other;
        if (Intrinsics.areEqual(this.pageName, kuikLyConfig.pageName) && Intrinsics.areEqual(this.moduleName, kuikLyConfig.moduleName) && Intrinsics.areEqual(this.eventName, kuikLyConfig.eventName) && Intrinsics.areEqual(this.params, kuikLyConfig.params)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((this.pageName.hashCode() * 31) + this.moduleName.hashCode()) * 31) + this.eventName.hashCode()) * 31;
        Map<String, String> map = this.params;
        if (map == null) {
            hashCode = 0;
        } else {
            hashCode = map.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "KuikLyConfig(pageName=" + this.pageName + ", moduleName=" + this.moduleName + ", eventName=" + this.eventName + ", params=" + this.params + ")";
    }

    public KuikLyConfig(@NotNull String pageName, @NotNull String moduleName, @NotNull String eventName, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        this.pageName = pageName;
        this.moduleName = moduleName;
        this.eventName = eventName;
        this.params = map;
    }

    public /* synthetic */ KuikLyConfig(String str, String str2, String str3, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? null : map);
    }
}
