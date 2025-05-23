package w32;

import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.avcore.netchannel.INetChannelCallback;
import com.tencent.mobileqq.util.SSODebugUtil;
import com.tencent.mqq.BuildConfig;
import com.tencent.opentelemetry.api.OpenTelemetry;
import com.tencent.opentelemetry.api.common.AttributesBuilder;
import com.tencent.opentelemetry.api.config.ConfigConstants;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.opentelemetry.api.logging.IPrinterLogger;
import com.tencent.opentelemetry.api.trace.Span;
import com.tencent.opentelemetry.api.trace.SpanKind;
import com.tencent.opentelemetry.api.trace.StatusCode;
import com.tencent.opentelemetry.api.trace.TraceFlags;
import com.tencent.opentelemetry.api.trace.Tracer;
import com.tencent.opentelemetry.api.trace.propagation.W3CTraceContextPropagator;
import com.tencent.opentelemetry.otlp.trace.OtlpHttpJsonSpanExporterBuilder;
import com.tencent.opentelemetry.sdk.OpenTelemetrySdk;
import com.tencent.opentelemetry.sdk.resources.AttributeResource;
import com.tencent.opentelemetry.sdk.trace.SdkTracerProvider;
import com.tencent.opentelemetry.sdk.trace.export.BatchSpanProcessor;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c implements IPrinterLogger {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.qqlive.report.tianjige.c f444502a;

    /* renamed from: b, reason: collision with root package name */
    private OpenTelemetry f444503b;

    /* renamed from: c, reason: collision with root package name */
    private SdkTracerProvider f444504c;

    /* renamed from: d, reason: collision with root package name */
    private String f444505d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f444506e = false;

    /* renamed from: f, reason: collision with root package name */
    private long f444507f = 0;

    /* renamed from: g, reason: collision with root package name */
    private int f444508g = 0;

    public c(String str, com.tencent.mobileqq.qqlive.report.tianjige.a aVar) {
        b(b.a(str, aVar));
    }

    private void c() {
        try {
            if (l()) {
                this.f444504c.setResource(AttributeResource.buildResource());
                QLog.i("ICGameOpenTelemetryWrapperImpl", 1, "update openTelemetry config");
                return;
            }
            this.f444504c = SdkTracerProvider.builder().addSpanProcessor(BatchSpanProcessor.builder(new OtlpHttpJsonSpanExporterBuilder().setEndpoint(ConfigConstants.DEFAULT_TRACE_SERVICE_ADDRESS).addHeader(ConfigConstants.TENANT_KEY, this.f444502a.c()).setCompression("gzip").setOkHttpUpload("OkHttp").build()).build()).setResource(AttributeResource.buildResource()).setSampler(com.tencent.opentelemetry.sdk.trace.samplers.a.e(this.f444502a.b())).build();
            this.f444503b = OpenTelemetrySdk.builder().setTracerProvider(this.f444504c).setPropagators(com.tencent.opentelemetry.context.propagation.a.a(W3CTraceContextPropagator.getInstance())).build();
            QLog.i("ICGameOpenTelemetryWrapperImpl", 1, "init openTelemetry success");
        } catch (Throwable th5) {
            QLog.e("ICGameOpenTelemetryWrapperImpl", 1, "initTrace error:" + th5.toString());
        }
    }

    private boolean g(com.tencent.mobileqq.qqlive.report.tianjige.c cVar) {
        com.tencent.mobileqq.qqlive.report.tianjige.c cVar2 = this.f444502a;
        if (cVar2 == null || !TextUtils.equals(cVar2.e(), cVar.e()) || !TextUtils.equals(this.f444502a.d(), cVar.d())) {
            return true;
        }
        return false;
    }

    private boolean j(com.tencent.mobileqq.qqlive.report.tianjige.c cVar) {
        if (cVar == null) {
            QLog.i("ICGameOpenTelemetryWrapperImpl", 1, "config set null");
            return false;
        }
        if (!g(cVar) && l()) {
            return false;
        }
        return true;
    }

    private boolean l() {
        if (this.f444504c != null && this.f444503b != null) {
            return true;
        }
        return false;
    }

    private void m(String str, Throwable th5) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f444507f < 10000) {
                this.f444508g++;
                return;
            }
            if (this.f444508g > 0) {
                QLog.e("ICGameOpenTelemetryWrapperImpl", 1, this.f444508g + " error msg is detected in last 10s. to get full details, please modify code: OpenTelemetryWrapper.printOpenTelemetryError");
            }
            this.f444507f = currentTimeMillis;
            QLog.e("ICGameOpenTelemetryWrapperImpl", 1, str, th5);
            this.f444508g = 0;
        } catch (Exception unused) {
        }
    }

    private void o(com.tencent.mobileqq.qqlive.report.tianjige.c cVar) {
        String str;
        if (cVar == null) {
            return;
        }
        try {
            boolean isTestEnv = SSODebugUtil.isTestEnv();
            this.f444506e = isTestEnv;
            if (isTestEnv) {
                str = "test";
            } else {
                str = "formal";
            }
            this.f444505d = str;
            AttributeResource.withAttributes(com.tencent.opentelemetry.api.common.f.a().put("app_version", cVar.a()).build());
            AttributesBuilder a16 = com.tencent.opentelemetry.api.common.f.a();
            a16.put(ConfigConstants.CONSTANT_TENANT_ID_KEY, cVar.c());
            a16.put(ConfigConstants.CONSTANT_TENANT_NAME_KEY, cVar.c());
            a16.put(INetChannelCallback.KEY_TINY_ID, cVar.d());
            a16.put("platform", "Android");
            a16.put("uin", cVar.e());
            a16.put("dev_model", d.b().c());
            a16.put("dev_brand", d.b().a());
            a16.put("os_ver", d.b().d());
            AttributeResource.addAttributes(a16.build());
        } catch (Throwable th5) {
            QLog.e("ICGameOpenTelemetryWrapperImpl", 1, "setAttributeResource error:" + th5.toString());
        }
    }

    private void p(Span span) {
        if (span == null) {
            return;
        }
        span.setAttribute(MosaicConstants$JsProperty.PROP_ENV, this.f444505d);
    }

    public void a(Span span, StatusCode statusCode) {
        boolean z16;
        if (span == null) {
            return;
        }
        boolean z17 = false;
        if (h() && statusCode == StatusCode.ERROR) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (f() || z16) {
            z17 = true;
        }
        if (!z17) {
            return;
        }
        try {
            span.end();
        } catch (Throwable th5) {
            QLog.e("ICGameOpenTelemetryWrapperImpl", 1, "startSpan error:" + th5.toString());
        }
    }

    public void b(com.tencent.mobileqq.qqlive.report.tianjige.c cVar) {
        try {
            if (!j(cVar)) {
                return;
            }
            this.f444502a = cVar;
            o(cVar);
            c();
            DefaultPrintLogger.registerLogger(this);
        } catch (Throwable th5) {
            QLog.e("ICGameOpenTelemetryWrapperImpl", 1, "init error:" + th5);
        }
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void e(String str, String str2) {
        m(str2, null);
    }

    public boolean f() {
        com.tencent.mobileqq.qqlive.report.tianjige.c cVar = this.f444502a;
        if (cVar != null && cVar.f()) {
            return true;
        }
        return false;
    }

    public boolean h() {
        com.tencent.mobileqq.qqlive.report.tianjige.c cVar = this.f444502a;
        if (cVar != null && cVar.g()) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public boolean isColorLevel() {
        return false;
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    /* renamed from: isDebug */
    public boolean getIsDebug() {
        return this.f444506e;
    }

    public boolean k(Span span) {
        TraceFlags traceFlags;
        if (span == null || span.getSpanContext() == null || (traceFlags = span.getSpanContext().getTraceFlags()) == null || !traceFlags.isSampled() || !f()) {
            return false;
        }
        return true;
    }

    public void n(Span span, Map<String, String> map) {
        if (span != null && map != null && !map.isEmpty()) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    span.setAttribute(entry.getKey(), entry.getValue());
                }
            } catch (Exception e16) {
                QLog.e("ICGameOpenTelemetryWrapperImpl", 1, "setAttribute error:" + e16.toString());
            }
        }
    }

    public void q(Span span, StatusCode statusCode) {
        if (span == null) {
            return;
        }
        try {
            span.setStatus(statusCode);
        } catch (Exception e16) {
            QLog.e("ICGameOpenTelemetryWrapperImpl", 1, "setStatusCode error:" + e16.toString());
        }
    }

    public Span r(String str) {
        return s(str, "");
    }

    public Span s(String str, String str2) {
        OpenTelemetry openTelemetry = this.f444503b;
        if (openTelemetry != null && this.f444504c != null) {
            try {
                Tracer tracer = openTelemetry.getTracer(BuildConfig.LIBRARY_PACKAGE_NAME, this.f444502a.a());
                if (!TextUtils.isEmpty(str2)) {
                    AttributeResource.addAttributes(com.tencent.opentelemetry.api.common.f.c(ResourceAttributes.SERVICE_NAME, str2));
                    this.f444504c.setResource(AttributeResource.buildResource());
                }
                Span startSpan = tracer.spanBuilder(str).setSpanKind(SpanKind.CLIENT).startSpan();
                p(startSpan);
                return startSpan;
            } catch (Throwable th5) {
                QLog.e("ICGameOpenTelemetryWrapperImpl", 1, "startSpan error:" + th5.toString());
            }
        }
        return null;
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void w(String str, String str2) {
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void e(String str, String str2, Throwable th5) {
        m(str2, th5);
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void w(String str, String str2, Throwable th5) {
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void d(String str, String str2) {
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void i(String str, String str2) {
    }
}
