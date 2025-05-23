package zh2;

import ai2.HistogramInfo;
import android.util.Log;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildHistogramScene;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ,\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J,\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002JG\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00052\u0018\u0010\u000e\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fH\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J0\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0018\u0010\u000e\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\r2\u0006\u0010\b\u001a\u00020\u0007J,\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007R0\u0010\u001c\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00180\u0017j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0018`\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lzh2/g;", "", "Lcom/tencent/mobileqq/qqguildsdk/tianjige/GuildHistogramScene;", "scene", "", "", "param", "", "duration", "", "c", "f", "name", "", "map", "", "bucket", "d", "(Ljava/lang/String;Ljava/util/Map;D[Ljava/lang/Double;)V", "Lai2/c;", "info", "i", "g", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/tianjige/metric/d;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "histogramMap", "<init>", "()V", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f452566a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashMap<String, com.tencent.mobileqq.tianjige.metric.d> histogramMap = new HashMap<>();

    g() {
    }

    private final void c(GuildHistogramScene scene, Map<String, String> param, double duration) {
        if (!a.f452546a.d(scene)) {
            return;
        }
        f(scene, param, duration);
    }

    private final void d(String name, final Map<String, String> map, final double duration, Double[] bucket) {
        HashMap<String, com.tencent.mobileqq.tianjige.metric.d> hashMap = histogramMap;
        final com.tencent.mobileqq.tianjige.metric.d histogram = hashMap.get(name);
        if (histogram == null) {
            histogram = a.f452546a.j().f(name, bucket);
        }
        Intrinsics.checkNotNullExpressionValue(histogram, "histogram");
        hashMap.put(name, histogram);
        Logger logger = Logger.f235387a;
        if (QLog.isDevelopLevel()) {
            Log.d("GuildTimeCostRecorder", "report: " + name + " value " + duration + " " + map);
        }
        ThreadManagerV2.excute(new Runnable() { // from class: zh2.f
            @Override // java.lang.Runnable
            public final void run() {
                g.e(com.tencent.mobileqq.tianjige.metric.d.this, duration, map);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(com.tencent.mobileqq.tianjige.metric.d dVar, double d16, Map map) {
        dVar.b(d16, map);
    }

    private final void f(GuildHistogramScene scene, Map<String, String> param, double duration) {
        HashMap<String, com.tencent.mobileqq.tianjige.metric.d> hashMap = histogramMap;
        if (!hashMap.containsKey(scene.getScene())) {
            String scene2 = scene.getScene();
            com.tencent.mobileqq.tianjige.metric.d f16 = a.f452546a.j().f(scene.getScene(), com.tencent.mobileqq.qqguildsdk.tianjige.c.a(scene));
            Intrinsics.checkNotNullExpressionValue(f16, "GuildMetricHelper.getGui\u2026etHistogramBucket(scene))");
            hashMap.put(scene2, f16);
        }
        com.tencent.mobileqq.tianjige.metric.d dVar = hashMap.get(scene.getScene());
        if (dVar != null) {
            a.f452546a.a(param);
            dVar.b(duration, param);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void h(GuildHistogramScene scene, Map map, double d16) {
        Intrinsics.checkNotNullParameter(scene, "$scene");
        g gVar = f452566a;
        if (map == null) {
            map = new HashMap();
        }
        gVar.c(scene, map, d16);
    }

    public final void g(@NotNull final GuildHistogramScene scene, @Nullable final Map<String, String> param, final double duration) {
        long j3;
        Intrinsics.checkNotNullParameter(scene, "scene");
        Runnable runnable = new Runnable() { // from class: zh2.e
            @Override // java.lang.Runnable
            public final void run() {
                g.h(GuildHistogramScene.this, param, duration);
            }
        };
        if (com.tencent.mobileqq.startup.a.f289669j) {
            j3 = 0;
        } else {
            j3 = 3000;
        }
        ThreadManagerV2.executeDelay(runnable, 16, null, true, j3);
    }

    public final void i(@NotNull HistogramInfo info, @Nullable Map<String, String> map, double duration) {
        Intrinsics.checkNotNullParameter(info, "info");
        if (!a.f452546a.i(info.getPubPolicy(), info.getGrayPolicy())) {
            QLog.d("GuildTimeCostRecorder", 2, "reportMetricTimeDurationWithPolicy:" + info + " not Sampled");
            return;
        }
        d(info.getName(), map, duration, info.getBoundary());
    }
}
