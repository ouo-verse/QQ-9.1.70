package u20;

import com.heytap.databaseengine.model.UserInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\tB/\u0012\b\b\u0002\u0010\r\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0015\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\t\u0010\u0013R\u0017\u0010\u0019\u001a\u00020\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0011\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lu20/i;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "strategyId", "getText", "text", "", "c", "[F", "()[F", "feature", "", "d", UserInfo.SEX_FEMALE, "()F", "threshold", "<init>", "(Ljava/lang/String;Ljava/lang/String;[FF)V", "e", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: u20.i, reason: from toString */
/* loaded from: classes4.dex */
public final /* data */ class QFSSafeStrategyConfig {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String strategyId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String text;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final float[] feature;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final float threshold;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0007\u001a\u00020\u0006*\u00020\u0005H\u0002J\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\t2\u0006\u0010\b\u001a\u00020\u0005\u00a8\u0006\r"}, d2 = {"Lu20/i$a;", "", "Lorg/json/JSONObject;", "Lu20/i;", "c", "Lorg/json/JSONArray;", "", "b", "jsonArray", "", "a", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: u20.i$a, reason: from kotlin metadata */
    /* loaded from: classes4.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final float[] b(JSONArray jSONArray) {
            float[] fArr = new float[jSONArray.length()];
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                fArr[i3] = (float) jSONArray.optDouble(i3);
            }
            return fArr;
        }

        private final QFSSafeStrategyConfig c(JSONObject jSONObject) {
            float[] fArr;
            if (jSONObject.length() == 0) {
                return new QFSSafeStrategyConfig(null, null, null, 0.0f, 15, null);
            }
            String optString = jSONObject.optString("strategy_id");
            Intrinsics.checkNotNullExpressionValue(optString, "optString(\"strategy_id\")");
            String optString2 = jSONObject.optString("text");
            Intrinsics.checkNotNullExpressionValue(optString2, "optString(\"text\")");
            JSONArray optJSONArray = jSONObject.optJSONArray("feature");
            if (optJSONArray == null || (fArr = b(optJSONArray)) == null) {
                fArr = new float[1024];
            }
            return new QFSSafeStrategyConfig(optString, optString2, fArr, (float) jSONObject.optDouble("threshold"));
        }

        @NotNull
        public final List<QFSSafeStrategyConfig> a(@NotNull JSONArray jsonArray) {
            Intrinsics.checkNotNullParameter(jsonArray, "jsonArray");
            ArrayList arrayList = new ArrayList();
            int length = jsonArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jsonObj = jsonArray.getJSONObject(i3);
                Intrinsics.checkNotNullExpressionValue(jsonObj, "jsonObj");
                arrayList.add(c(jsonObj));
            }
            return arrayList;
        }

        Companion() {
        }
    }

    public QFSSafeStrategyConfig() {
        this(null, null, null, 0.0f, 15, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final float[] getFeature() {
        return this.feature;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getStrategyId() {
        return this.strategyId;
    }

    /* renamed from: c, reason: from getter */
    public final float getThreshold() {
        return this.threshold;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QFSSafeStrategyConfig)) {
            return false;
        }
        QFSSafeStrategyConfig qFSSafeStrategyConfig = (QFSSafeStrategyConfig) other;
        if (Intrinsics.areEqual(this.strategyId, qFSSafeStrategyConfig.strategyId) && Intrinsics.areEqual(this.text, qFSSafeStrategyConfig.text) && Intrinsics.areEqual(this.feature, qFSSafeStrategyConfig.feature) && Float.compare(this.threshold, qFSSafeStrategyConfig.threshold) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.strategyId.hashCode() * 31) + this.text.hashCode()) * 31) + Arrays.hashCode(this.feature)) * 31) + Float.floatToIntBits(this.threshold);
    }

    @NotNull
    public String toString() {
        return "QFSSafeStrategyConfig(strategyId=" + this.strategyId + ", text=" + this.text + ", feature=" + Arrays.toString(this.feature) + ", threshold=" + this.threshold + ")";
    }

    public QFSSafeStrategyConfig(@NotNull String strategyId, @NotNull String text, @NotNull float[] feature, float f16) {
        Intrinsics.checkNotNullParameter(strategyId, "strategyId");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(feature, "feature");
        this.strategyId = strategyId;
        this.text = text;
        this.feature = feature;
        this.threshold = f16;
    }

    public /* synthetic */ QFSSafeStrategyConfig(String str, String str2, float[] fArr, float f16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? new float[1024] : fArr, (i3 & 8) != 0 ? 80.0f : f16);
    }
}
