package rs;

import com.tencent.beacon.event.open.BeaconEvent;
import com.tencent.beacon.event.open.BeaconReport;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import java.util.Map;
import org.light.LightEngine;
import org.light.report.LightReportInterface;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b implements LightReportInterface {

    /* renamed from: a, reason: collision with root package name */
    private String f432135a;

    /* renamed from: b, reason: collision with root package name */
    private String f432136b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f432137a = new b();
    }

    b() {
    }

    private String a(int i3) {
        if (gq.a.f(i3)) {
            return "qq_aio";
        }
        return QQWinkConstants.ENTRY_QQ_OTHER;
    }

    public static b c() {
        return a.f432137a;
    }

    public String b() {
        return this.f432135a;
    }

    public void d(int i3) {
        this.f432135a = a(i3);
        ms.a.f("ReporterForLightSdk", "setEntry---int entry=" + i3 + ", convert=" + this.f432135a);
    }

    @Override // org.light.report.LightReportInterface
    public void report(String str, Map<String, String> map) {
        if (this.f432136b == null) {
            this.f432136b = LightEngine.version();
        }
        map.put("lightsdk_version", this.f432136b);
        map.put("app_id", "lightsdk_qq");
        map.put("entry", this.f432135a);
        BeaconReport.getInstance().report(BeaconEvent.builder().withCode(str).withParams(map).withAppKey("0AND0WH9714UPYKY").build());
    }
}
