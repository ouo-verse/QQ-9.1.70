package w32;

import android.text.TextUtils;
import com.tencent.opentelemetry.api.trace.Span;
import com.tencent.opentelemetry.api.trace.StatusCode;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, a> f444513b = new ConcurrentHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    private final c f444514a;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final Span f444515a;

        /* renamed from: b, reason: collision with root package name */
        private final c f444516b;

        /* renamed from: c, reason: collision with root package name */
        private final String f444517c;

        /* renamed from: d, reason: collision with root package name */
        private StatusCode f444518d = StatusCode.OK;

        a(c cVar, String str, String str2) {
            Span r16 = cVar.r(str);
            this.f444515a = r16;
            this.f444516b = cVar;
            if (!TextUtils.isEmpty(str2)) {
                this.f444517c = str2;
            } else {
                this.f444517c = f.a(cVar, r16);
            }
        }

        public static a a(c cVar, String str, String str2) {
            return new a(cVar, str, str2);
        }

        public void b() {
            this.f444516b.a(this.f444515a, this.f444518d);
            e.f444513b.remove(this.f444517c);
        }

        public String c(boolean z16, String str, String str2) {
            boolean f16 = this.f444516b.f();
            boolean h16 = this.f444516b.h();
            if (!f16 && h16 && z16) {
                return str2;
            }
            return str;
        }

        public String d() {
            return this.f444517c;
        }

        public String e() {
            return f.a(this.f444516b, this.f444515a);
        }

        public void f(Map<String, String> map) {
            this.f444516b.n(this.f444515a, map);
        }

        public void g(int i3) {
            if (i3 != 0) {
                this.f444518d = StatusCode.ERROR;
            }
            this.f444516b.q(this.f444515a, this.f444518d);
        }
    }

    public e(c cVar) {
        this.f444514a = cVar;
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("ICGameQQOpenTelemetryReport", 1, "endReportTask taskKey is empty!");
            return;
        }
        a aVar = f444513b.get(str);
        if (aVar == null) {
            QLog.e("ICGameQQOpenTelemetryReport", 1, "endReportTask is not exist tasKey = " + str);
            return;
        }
        aVar.b();
    }

    public String c(String str, boolean z16, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("ICGameQQOpenTelemetryReport", 1, "getSourceTag taskKey is empty!");
            return "";
        }
        a aVar = f444513b.get(str);
        if (aVar == null) {
            QLog.e("ICGameQQOpenTelemetryReport", 1, "getSourceTag is not exist tasKey = " + str);
            return "";
        }
        return aVar.c(z16, str2, str3);
    }

    public String d(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("ICGameQQOpenTelemetryReport", 1, "getTraceInfo taskKey is empty!");
            return "";
        }
        a aVar = f444513b.get(str);
        if (aVar == null) {
            QLog.e("ICGameQQOpenTelemetryReport", 1, "getTraceInfo is not exist tasKey = " + str);
            return "";
        }
        return aVar.e();
    }

    public void e(String str, Map<String, String> map) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("ICGameQQOpenTelemetryReport", 1, "setAttributes taskKey is empty!");
            return;
        }
        a aVar = f444513b.get(str);
        if (aVar == null) {
            QLog.e("ICGameQQOpenTelemetryReport", 1, "setAttributes is not exist tasKey = " + str);
            return;
        }
        aVar.f(map);
    }

    public void f(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("ICGameQQOpenTelemetryReport", 1, "setStatusCode taskKey is empty!");
            return;
        }
        a aVar = f444513b.get(str);
        if (aVar == null) {
            QLog.e("ICGameQQOpenTelemetryReport", 1, "setStatusCode is not exist tasKey = " + str);
            return;
        }
        aVar.g(i3);
    }

    public String g(String str, String str2) {
        a a16 = a.a(this.f444514a, str, str2);
        String d16 = a16.d();
        if (TextUtils.isEmpty(d16)) {
            QLog.e("ICGameQQOpenTelemetryReport", 1, "startReportTask taskKey is empty!");
            return "";
        }
        f444513b.put(d16, a16);
        return d16;
    }
}
