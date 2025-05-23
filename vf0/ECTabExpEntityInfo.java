package vf0;

import com.tencent.gdtad.util.SsoReporter;
import com.tencent.qqlive.tvkplayer.tools.config.ITVKConfigRequester;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010$\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0002\u0012\u0014\b\u0002\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020 \u00a2\u0006\u0004\b(\u0010)J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\f\"\u0004\b\u0016\u0010\u000eR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\"\u0010\u001f\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001c\u0010\n\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR.\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lvf0/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "getLayerName", "()Ljava/lang/String;", "setLayerName", "(Ljava/lang/String;)V", "layerName", "b", "getExpName", "setExpName", ITVKConfigRequester.ConfigRequestListener.EXTRA_KEY_EXP_NAME, "c", "getExpAppId", "setExpAppId", "expAppId", "d", "getAssignment", "setAssignment", SsoReporter.TAB_EXPERIMENT_KEY, "e", "getExpGrayId", "setExpGrayId", "expGrayId", "", "f", "Ljava/util/Map;", "getExpParams", "()Ljava/util/Map;", "setExpParams", "(Ljava/util/Map;)V", "expParams", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: vf0.a, reason: from toString */
/* loaded from: classes5.dex */
public final /* data */ class ECTabExpEntityInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private String layerName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String expName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String expAppId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String assignment;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String expGrayId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private Map<String, String> expParams;

    public ECTabExpEntityInfo() {
        this(null, null, null, null, null, null, 63, null);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof ECTabExpEntityInfo) {
                ECTabExpEntityInfo eCTabExpEntityInfo = (ECTabExpEntityInfo) other;
                if (!Intrinsics.areEqual(this.layerName, eCTabExpEntityInfo.layerName) || !Intrinsics.areEqual(this.expName, eCTabExpEntityInfo.expName) || !Intrinsics.areEqual(this.expAppId, eCTabExpEntityInfo.expAppId) || !Intrinsics.areEqual(this.assignment, eCTabExpEntityInfo.assignment) || !Intrinsics.areEqual(this.expGrayId, eCTabExpEntityInfo.expGrayId) || !Intrinsics.areEqual(this.expParams, eCTabExpEntityInfo.expParams)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        String str = this.layerName;
        int i26 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i27 = i3 * 31;
        String str2 = this.expName;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i28 = (i27 + i16) * 31;
        String str3 = this.expAppId;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i29 = (i28 + i17) * 31;
        String str4 = this.assignment;
        if (str4 != null) {
            i18 = str4.hashCode();
        } else {
            i18 = 0;
        }
        int i36 = (i29 + i18) * 31;
        String str5 = this.expGrayId;
        if (str5 != null) {
            i19 = str5.hashCode();
        } else {
            i19 = 0;
        }
        int i37 = (i36 + i19) * 31;
        Map<String, String> map = this.expParams;
        if (map != null) {
            i26 = map.hashCode();
        }
        return i37 + i26;
    }

    @NotNull
    public String toString() {
        return "ECTabExpEntityInfo(layerName=" + this.layerName + ", expName=" + this.expName + ", expAppId=" + this.expAppId + ", assignment=" + this.assignment + ", expGrayId=" + this.expGrayId + ", expParams=" + this.expParams + ")";
    }

    public ECTabExpEntityInfo(@Nullable String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull Map<String, String> map) {
        this.layerName = str;
        this.expName = str2;
        this.expAppId = str3;
        this.assignment = str4;
        this.expGrayId = str5;
        this.expParams = map;
    }

    public /* synthetic */ ECTabExpEntityInfo(String str, String str2, String str3, String str4, String str5, Map map, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? "" : str4, (i3 & 16) == 0 ? str5 : "", (i3 & 32) != 0 ? new LinkedHashMap() : map);
    }
}
