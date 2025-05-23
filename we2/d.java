package we2;

import com.tencent.common.config.AppSetting;
import com.tencent.ecommerce.base.opentelemtry.api.IECOpenTelemetryMetric;
import com.tencent.mobileqq.tianjige.metric.h;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ(\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J<\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J<\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H\u0016JQ\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010H\u0016\u00a2\u0006\u0004\b\u0012\u0010\u0013JQ\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0017R \u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001a0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006 "}, d2 = {"Lwe2/d;", "Lcom/tencent/ecommerce/base/opentelemtry/api/IECOpenTelemetryMetric;", "", "", "attributes", "a", "", "value", "counterName", "unit", "description", "", "addDoubleValue", "", "addLongValue", "histogramName", "", "buckets", "recordDoubleValue", "(DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;[Ljava/lang/Double;)V", "recordLongValue", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;[Ljava/lang/Double;)V", "Lcom/tencent/mobileqq/tianjige/metric/h;", "Lcom/tencent/mobileqq/tianjige/metric/h;", "openTelemetryMetric", "", "Lcom/tencent/mobileqq/tianjige/metric/d;", "b", "Ljava/util/Map;", "histogramMap", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class d implements IECOpenTelemetryMetric {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final h openTelemetryMetric = b.INSTANCE.a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final Map<String, com.tencent.mobileqq.tianjige.metric.d> histogramMap = new LinkedHashMap();

    private final Map<String, String> a(Map<String, String> attributes) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String subVersion = AppSetting.f99551k;
        Intrinsics.checkNotNullExpressionValue(subVersion, "subVersion");
        linkedHashMap.put("app_ver_short", subVersion);
        linkedHashMap.put("app_env", "2");
        linkedHashMap.putAll(attributes);
        return linkedHashMap;
    }

    @Override // com.tencent.ecommerce.base.opentelemtry.api.IECOpenTelemetryMetric
    public void addDoubleValue(double value, String counterName, String unit, String description, Map<String, String> attributes) {
        Intrinsics.checkNotNullParameter(counterName, "counterName");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.openTelemetryMetric.c(counterName, unit, description).c((long) value, a(attributes));
    }

    @Override // com.tencent.ecommerce.base.opentelemtry.api.IECOpenTelemetryMetric
    public void addLongValue(long value, String counterName, String unit, String description, Map<String, String> attributes) {
        Intrinsics.checkNotNullParameter(counterName, "counterName");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        this.openTelemetryMetric.c(counterName, description, unit).c(value, a(attributes));
    }

    @Override // com.tencent.ecommerce.base.opentelemtry.api.IECOpenTelemetryMetric
    public void recordDoubleValue(double value, String histogramName, String unit, String description, Map<String, String> attributes, Double[] buckets) {
        Intrinsics.checkNotNullParameter(histogramName, "histogramName");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(buckets, "buckets");
        com.tencent.mobileqq.tianjige.metric.d dVar = this.histogramMap.get(histogramName);
        if (dVar == null) {
            dVar = this.openTelemetryMetric.e(histogramName, description, unit, buckets);
            this.histogramMap.put(histogramName, dVar);
        }
        if (dVar != null) {
            dVar.c((long) value, a(attributes));
        }
    }

    @Override // com.tencent.ecommerce.base.opentelemtry.api.IECOpenTelemetryMetric
    public void recordLongValue(long value, String histogramName, String unit, String description, Map<String, String> attributes, Double[] buckets) {
        Intrinsics.checkNotNullParameter(histogramName, "histogramName");
        Intrinsics.checkNotNullParameter(unit, "unit");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        Intrinsics.checkNotNullParameter(buckets, "buckets");
        com.tencent.mobileqq.tianjige.metric.d dVar = this.histogramMap.get(histogramName);
        if (dVar == null) {
            dVar = this.openTelemetryMetric.e(histogramName, description, unit, buckets);
            this.histogramMap.put(histogramName, dVar);
        }
        if (dVar != null) {
            dVar.c(value, a(attributes));
        }
    }
}
