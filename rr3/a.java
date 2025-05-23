package rr3;

import com.tencent.qmethod.monitor.report.base.reporter.data.ReportData;
import com.tencent.qmethod.pandoraex.core.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import or3.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u000e\u0010\u000b\u001a\u00020\n*\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010\f\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lrr3/a;", "Lor3/c;", "Lcom/tencent/qmethod/monitor/report/base/reporter/data/ReportData;", "reportData", "", "url", "Lor3/c$a;", "callback", "", "d", "", "c", "a", "<init>", "()V", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes22.dex */
public final class a implements c {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"rr3/a$b", "Lcom/tencent/qmethod/monitor/network/c;", "", "responseJson", "", "onSuccess", "", "errorCode", "errorMsg", "onFailure", "qmethod-privacy-monitor_tencentBuglyRelease"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes22.dex */
    public static final class b implements com.tencent.qmethod.monitor.network.c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ c.a f432089b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ReportData f432090c;

        b(c.a aVar, ReportData reportData) {
            this.f432089b = aVar;
            this.f432090c = reportData;
        }

        @Override // com.tencent.qmethod.monitor.network.c
        public void onFailure(int errorCode, @NotNull String errorMsg) {
            Intrinsics.checkParameterIsNotNull(errorMsg, "errorMsg");
            c.a aVar = this.f432089b;
            if (aVar != null) {
                aVar.a(errorCode, errorMsg, this.f432090c.getDbId());
            }
        }

        @Override // com.tencent.qmethod.monitor.network.c
        public void onSuccess(@NotNull String responseJson) {
            Intrinsics.checkParameterIsNotNull(responseJson, "responseJson");
            if (com.tencent.qmethod.monitor.a.f343451h.g().getDebug()) {
                o.c("UploadProxy", responseJson);
            }
            if (a.this.c(responseJson)) {
                c.a aVar = this.f432089b;
                if (aVar != null) {
                    aVar.onSuccess(this.f432090c.getDbId());
                    return;
                }
                return;
            }
            c.a aVar2 = this.f432089b;
            if (aVar2 != null) {
                aVar2.a(200, responseJson, this.f432090c.getDbId());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean c(@Nullable String str) {
        boolean z16;
        boolean z17 = true;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return false;
        }
        try {
            if (new JSONObject(str).optInt("code", -1) != 0) {
                z17 = false;
            }
            return z17;
        } catch (Throwable th5) {
            o.c("UploadProxy", th5 + ": response parameter json error");
            return false;
        }
    }

    private final void d(ReportData reportData, String url, c.a callback) {
        com.tencent.qmethod.monitor.network.b.b(com.tencent.qmethod.monitor.network.b.f343747b, url, reportData.getParams(), new b(callback, reportData), reportData.b(), 0, 16, null);
    }

    @Override // or3.c
    public boolean a(@NotNull ReportData reportData, @Nullable c.a callback) {
        Intrinsics.checkParameterIsNotNull(reportData, "reportData");
        try {
            d(reportData, nr3.a.INSTANCE.a() + rr3.b.a(reportData), callback);
            return true;
        } catch (Exception e16) {
            o.d("UploadProxy", "reportNow", e16);
            return false;
        }
    }
}
