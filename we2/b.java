package we2;

import android.os.Build;
import com.tencent.common.config.AppSetting;
import com.tencent.ecommerce.base.opentelemtry.api.IECOpenTelemetry;
import com.tencent.ecommerce.base.opentelemtry.api.IECOpenTelemetryLogger;
import com.tencent.ecommerce.base.opentelemtry.api.IECOpenTelemetryMetric;
import com.tencent.ecommerce.base.opentelemtry.api.IECSpan;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqecommerce.base.runtime.ECRuntimeManager;
import com.tencent.mobileqq.tianjige.a;
import com.tencent.mobileqq.tianjige.i;
import com.tencent.mobileqq.tianjige.metric.h;
import com.tencent.opentelemetry.api.logging.DefaultPrintLogger;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00062\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lwe2/b;", "Lcom/tencent/ecommerce/base/opentelemtry/api/IECOpenTelemetry;", "", "uin", "", "d", "c", "Lcom/tencent/ecommerce/base/opentelemtry/api/IECOpenTelemetryLogger;", "getLoggerManager", "Lcom/tencent/ecommerce/base/opentelemtry/api/IECOpenTelemetryMetric;", "getMetricsManager", "Lcom/tencent/ecommerce/base/opentelemtry/api/IECSpan;", "getSpanManager", "Ljava/util/concurrent/atomic/AtomicBoolean;", "a", "Ljava/util/concurrent/atomic/AtomicBoolean;", "hasInitTraceConfig", "b", "hasInitMetricConfig", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b implements IECOpenTelemetry {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean hasInitTraceConfig = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean hasInitMetricConfig = new AtomicBoolean(false);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lwe2/b$a;", "", "Lcom/tencent/mobileqq/tianjige/i;", "b", "Lcom/tencent/mobileqq/tianjige/metric/h;", "a", "", "TAG", "Ljava/lang/String;", "tenantId", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: we2.b$a, reason: from kotlin metadata */
    /* loaded from: classes36.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        Companion() {
        }

        public final h a() {
            h b16 = com.tencent.mobileqq.tianjige.metric.f.b(6);
            Intrinsics.checkNotNullExpressionValue(b16, "getMetricRecorder(QQOpen\u2026.BusinessId.QQ_ECOMMERCE)");
            return b16;
        }

        public final i b() {
            return com.tencent.mobileqq.tianjige.f.d(6);
        }
    }

    public b() {
        ThreadManagerV2.excute(new Runnable() { // from class: we2.a
            @Override // java.lang.Runnable
            public final void run() {
                b.b(b.this);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(b this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ECRuntimeManager.Companion companion = ECRuntimeManager.INSTANCE;
        this$0.d(companion.a());
        this$0.c(companion.a());
    }

    private final void c(String uin) {
        boolean z16 = false;
        if (this.hasInitMetricConfig.compareAndSet(false, true)) {
            try {
                boolean a16 = f.f445549a.a();
                boolean z17 = Build.VERSION.SDK_INT > 27;
                QLog.d("ECOpenTelemetry", 1, "[initTraceConfig] isMetricEnable = " + a16 + " isValidOS = " + z17);
                a.C8649a l3 = new a.C8649a().o("qqkd").m(1.0d).p(uin).l(AppSetting.n());
                if (a16 && z17) {
                    z16 = true;
                }
                com.tencent.mobileqq.tianjige.metric.f.d(6, l3.n(z16).k());
            } catch (Exception e16) {
                QLog.e("ECOpenTelemetry", 1, "initMetricConfig catch exception", e16);
            }
        }
    }

    private final void d(String uin) {
        boolean z16 = false;
        if (this.hasInitTraceConfig.compareAndSet(false, true)) {
            try {
                boolean b16 = f.f445549a.b();
                boolean z17 = Build.VERSION.SDK_INT > 27;
                QLog.d("ECOpenTelemetry", 1, "[initTraceConfig] isTraceEnable = " + b16 + " isValidOS = " + z17);
                a.C8649a p16 = new a.C8649a().o("qqkd").m(1.0d).p(uin);
                if (b16 && z17) {
                    z16 = true;
                }
                com.tencent.mobileqq.tianjige.f.e(6, p16.n(z16).l(AppSetting.n()).k());
            } catch (Exception e16) {
                QLog.e("ECOpenTelemetry", 1, "initTelemetryConfig catch exception", e16);
            }
            DefaultPrintLogger.registerLogger(new e());
        }
    }

    @Override // com.tencent.ecommerce.base.opentelemtry.api.IECOpenTelemetry
    public IECOpenTelemetryLogger getLoggerManager() {
        return new c();
    }

    @Override // com.tencent.ecommerce.base.opentelemtry.api.IECOpenTelemetry
    public IECOpenTelemetryMetric getMetricsManager() {
        return new d();
    }

    @Override // com.tencent.ecommerce.base.opentelemtry.api.IECOpenTelemetry
    public IECSpan getSpanManager() {
        return new g();
    }
}
