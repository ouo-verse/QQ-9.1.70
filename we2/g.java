package we2;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ecommerce.base.opentelemtry.api.IECSpan;
import com.tencent.mobileqq.tianjige.i;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0014B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J \u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0016J,\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\rH\u0016J$\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\rH\u0016J$\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\rH\u0017J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0004\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lwe2/g;", "Lcom/tencent/ecommerce/base/opentelemtry/api/IECSpan;", "", "spanName", "serviceName", "", "startSpan", "parentSpanName", "startSpanWithParent", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "endSpan", "event", "", "attributes", "addEvent", "setAttribute", "updateAttribute", "getTraceInfo", "Lcom/tencent/mobileqq/tianjige/i;", "a", "Lcom/tencent/mobileqq/tianjige/i;", "openTelemetryTracer", "getServiceName", "()Ljava/lang/String;", "<init>", "()V", "b", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class g implements IECSpan {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final i openTelemetryTracer = b.INSTANCE.b();

    @Override // com.tencent.ecommerce.base.opentelemtry.api.IECSpan
    public void addEvent(String spanName, String event, Map<String, String> attributes) {
        Intrinsics.checkNotNullParameter(spanName, "spanName");
        Intrinsics.checkNotNullParameter(event, "event");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        i iVar = this.openTelemetryTracer;
        if (iVar != null) {
            iVar.h(spanName, event, attributes);
        }
    }

    @Override // com.tencent.ecommerce.base.opentelemtry.api.IECSpan
    public void endSpan(String spanName, int statusCode) {
        Intrinsics.checkNotNullParameter(spanName, "spanName");
        i iVar = this.openTelemetryTracer;
        if (iVar != null) {
            iVar.b(spanName, statusCode, null);
        }
    }

    @Override // com.tencent.ecommerce.base.opentelemtry.api.IECSpan
    public String getServiceName() {
        return "QQECommerceAppTelemetry";
    }

    @Override // com.tencent.ecommerce.base.opentelemtry.api.IECSpan
    public String getTraceInfo(String spanName) {
        Intrinsics.checkNotNullParameter(spanName, "spanName");
        i iVar = this.openTelemetryTracer;
        String e16 = iVar != null ? iVar.e(spanName) : null;
        return e16 == null ? "" : e16;
    }

    @Override // com.tencent.ecommerce.base.opentelemtry.api.IECSpan
    public void setAttribute(String spanName, Map<String, String> attributes) {
        Intrinsics.checkNotNullParameter(spanName, "spanName");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        i iVar = this.openTelemetryTracer;
        if (iVar != null) {
            iVar.m(spanName, attributes);
        }
    }

    @Override // com.tencent.ecommerce.base.opentelemtry.api.IECSpan
    public void startSpan(String spanName, String serviceName) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(spanName, "spanName");
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        i iVar = this.openTelemetryTracer;
        if (iVar != null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            iVar.v(spanName, serviceName, emptyMap, null);
        }
    }

    @Override // com.tencent.ecommerce.base.opentelemtry.api.IECSpan
    public void startSpanWithParent(String spanName, String serviceName, String parentSpanName) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(spanName, "spanName");
        Intrinsics.checkNotNullParameter(serviceName, "serviceName");
        Intrinsics.checkNotNullParameter(parentSpanName, "parentSpanName");
        i iVar = this.openTelemetryTracer;
        if (iVar != null) {
            emptyMap = MapsKt__MapsKt.emptyMap();
            iVar.v(spanName, serviceName, emptyMap, parentSpanName);
        }
    }

    @Override // com.tencent.ecommerce.base.opentelemtry.api.IECSpan
    public void updateAttribute(String spanName, Map<String, String> attributes) {
        Intrinsics.checkNotNullParameter(spanName, "spanName");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        i iVar = this.openTelemetryTracer;
        if (iVar != null) {
            iVar.x(spanName, attributes);
        }
    }
}
