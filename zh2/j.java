package zh2;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildGaugeNames;
import com.tencent.opentelemetry.api.metrics.ObservableDoubleMeasurement;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J,\u0010\f\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000b\u001a\u00020\u0007H\u0002J,\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\u0007R0\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f0\u000ej\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lzh2/j;", "", "Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildGaugeNames;", "gauge", "", "", "param", "", "duration", "", "c", "value", "d", "f", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/tianjige/metric/c;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "gaugeRecordMap", "<init>", "()V", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final j f452572a = new j();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, com.tencent.mobileqq.tianjige.metric.c> gaugeRecordMap = new HashMap<>();

    j() {
    }

    private final void c(GuildGaugeNames gauge, Map<String, String> param, double duration) {
        if (!a.f452546a.c(gauge)) {
            return;
        }
        d(gauge, param, duration);
    }

    private final void d(final GuildGaugeNames gauge, Map<String, String> param, double value) {
        a aVar = a.f452546a;
        if (!aVar.j().m()) {
            return;
        }
        aVar.a(param);
        String MODEL = DeviceInfoMonitor.getModel();
        Intrinsics.checkNotNullExpressionValue(MODEL, "MODEL");
        param.put("mobile_phone_model", MODEL);
        HashMap<String, com.tencent.mobileqq.tianjige.metric.c> hashMap = gaugeRecordMap;
        if (!hashMap.containsKey(gauge.getGaugeName())) {
            aVar.j();
            hashMap.put(gauge.getGaugeName(), new com.tencent.mobileqq.tianjige.metric.c(gauge.getGaugeName(), value, param));
            aVar.j().d(gauge.getGaugeName(), gauge.getGaugeName(), "\u00b0C", new Consumer() { // from class: zh2.i
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    j.e(GuildGaugeNames.this, (ObservableDoubleMeasurement) obj);
                }
            });
        } else {
            com.tencent.mobileqq.tianjige.metric.c cVar = hashMap.get(gauge.getGaugeName());
            if (cVar != null) {
                cVar.d(value);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(GuildGaugeNames gauge, ObservableDoubleMeasurement observableDoubleMeasurement) {
        Intrinsics.checkNotNullParameter(gauge, "$gauge");
        com.tencent.mobileqq.tianjige.metric.c cVar = gaugeRecordMap.get(gauge.getGaugeName());
        if (cVar != null && cVar.c()) {
            observableDoubleMeasurement.record(cVar.b(), cVar.a());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void g(GuildGaugeNames gauge, Map map, double d16) {
        Intrinsics.checkNotNullParameter(gauge, "$gauge");
        j jVar = f452572a;
        if (map == null) {
            map = new HashMap();
        }
        jVar.c(gauge, map, d16);
    }

    public final void f(@NotNull final GuildGaugeNames gauge, @Nullable final Map<String, String> param, final double value) {
        Intrinsics.checkNotNullParameter(gauge, "gauge");
        ThreadManagerV2.excute(new Runnable() { // from class: zh2.h
            @Override // java.lang.Runnable
            public final void run() {
                j.g(GuildGaugeNames.this, param, value);
            }
        }, 16, null, true);
    }
}
