package y53;

import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.winkpublish.report.WinkPublishQualityReportData;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes21.dex */
public class e {

    /* renamed from: b, reason: collision with root package name */
    private static final e f449483b = new e();

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, Long> f449484a = new HashMap<>();

    e() {
    }

    private void b(WinkPublishQualityReportData winkPublishQualityReportData, String str) {
        z93.c f16 = Wink.INSTANCE.f();
        if (f16 != null) {
            f16.b(winkPublishQualityReportData, str);
        }
    }

    public static e d() {
        return f449483b;
    }

    public void a(String str, String str2, WinkPublishQualityReportData winkPublishQualityReportData) {
        long c16 = c(str2);
        if (c16 > 0) {
            winkPublishQualityReportData.setExt3(String.valueOf(c16));
            b(winkPublishQualityReportData, str);
        } else {
            w53.b.f("WinkMapReport", "reportEnd... cost < 0 id:" + str2);
        }
    }

    public long c(String str) {
        if (this.f449484a.containsKey(str)) {
            long currentTimeMillis = System.currentTimeMillis() - this.f449484a.get(str).longValue();
            if (currentTimeMillis < 0) {
                w53.b.f("WinkMapReport", "endKey... cost < 0 id:" + str);
                return -1L;
            }
            return currentTimeMillis;
        }
        w53.b.f("WinkMapReport", "endKey... clickTimesMap not contain id:" + str);
        return -1L;
    }

    public void e(String str, String str2, WinkPublishQualityReportData winkPublishQualityReportData) {
        long c16 = c(str2);
        if (c16 > 0) {
            winkPublishQualityReportData.setExt1(String.valueOf(c16));
            b(winkPublishQualityReportData, str);
        } else {
            w53.b.f("WinkMapReport", "reportEnd... cost < 0 id:" + str2);
        }
    }

    public void f(String str) {
        this.f449484a.put(str, Long.valueOf(System.currentTimeMillis()));
    }
}
