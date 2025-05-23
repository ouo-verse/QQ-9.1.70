package we2;

import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.util.SSODebugUtil;
import com.tencent.opentelemetry.api.logging.IPrinterLogger;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016J\u001c\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\r\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\u000e\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010\u000e\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010\u000f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J$\u0010\u000f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016R\u0016\u0010\u0011\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0010R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lwe2/e;", "Lcom/tencent/opentelemetry/api/logging/IPrinterLogger;", "", "msg", "", "t", "", "a", "", "isDebug", "isColorLevel", "tag", "d", "i", "w", "e", "Ljava/lang/String;", MosaicConstants$JsProperty.PROP_ENV, "b", "Z", "", "c", "J", "lastPrintTime", "", "I", "errorLogIgnoreCount", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class e implements IPrinterLogger {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String env;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isDebug;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long lastPrintTime;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int errorLogIgnoreCount;

    public e() {
        String str;
        this.env = "";
        boolean isTestEnv = SSODebugUtil.isTestEnv();
        this.isDebug = isTestEnv;
        if (isTestEnv) {
            str = "test";
        } else {
            str = "formal";
        }
        this.env = str;
    }

    private final void a(String msg2, Throwable t16) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.lastPrintTime < 10000) {
                this.errorLogIgnoreCount++;
                return;
            }
            int i3 = this.errorLogIgnoreCount;
            if (i3 > 0) {
                QLog.e("ECOpenTelemetryPrinterLogger", 1, i3 + " error msg is detected in last 10s. to get full details, please modify code: OpenTelemetryWrapper.printOpenTelemetryError");
            }
            this.lastPrintTime = currentTimeMillis;
            QLog.e("ECOpenTelemetryPrinterLogger", 1, msg2, t16);
            this.errorLogIgnoreCount = 0;
        } catch (Exception e16) {
            QLog.e("ECOpenTelemetryPrinterLogger", 1, "printOpenTelemetryError: " + e16);
        }
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void e(String tag, String msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        a(msg2, null);
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public boolean isColorLevel() {
        return false;
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    /* renamed from: isDebug, reason: from getter */
    public boolean getIsDebug() {
        return this.isDebug;
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void w(String tag, String msg2) {
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void e(String tag, String msg2, Throwable t16) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        a(msg2, t16);
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void w(String tag, String msg2, Throwable t16) {
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void d(String tag, String msg2) {
    }

    @Override // com.tencent.opentelemetry.api.logging.IPrinterLogger
    public void i(String tag, String msg2) {
    }
}
