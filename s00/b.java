package s00;

import android.content.Context;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.superplayer.api.ISPBandwidthMonitor;
import com.tencent.superplayer.api.SuperPlayerFactory;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u001a\u0010\u000b\u001a\u00020\u00042\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Ls00/b;", "", "Landroid/content/Context;", "context", "", "c", "e", "", "", "Lcom/tencent/superplayer/api/ISPBandwidthMonitor$Stat;", "stats", "b", "Lcom/tencent/superplayer/api/ISPBandwidthMonitor;", "Lcom/tencent/superplayer/api/ISPBandwidthMonitor;", "monitor", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f433050a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static ISPBandwidthMonitor monitor = SuperPlayerFactory.createBandwidthMonitor(112);

    b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Map it) {
        b bVar = f433050a;
        Intrinsics.checkNotNullExpressionValue(it, "it");
        bVar.b(it);
    }

    public final void b(Map<String, ? extends ISPBandwidthMonitor.Stat> stats) {
        Intrinsics.checkNotNullParameter(stats, "stats");
        for (Map.Entry<String, ? extends ISPBandwidthMonitor.Stat> entry : stats.entrySet()) {
            ISPBandwidthMonitor.Stat value = entry.getValue();
            String key = entry.getKey();
            long j3 = value.httpBandwidth;
            long j16 = value.pcdnBandwidth;
            long j17 = value.p2pBandwidth;
            long j18 = value.p2pUploadBandwidth;
            x.f("WSBandwidthMonitor", "[dealCallback] host:" + key + ", httpBw:" + j3 + ", pcdnBw:" + j16 + ", p2pBw:" + j17 + ", p2pUploadBw:" + j18);
            if (j3 > 0 || j16 > 0 || j17 > 0) {
                WSBandwidthReportData wSBandwidthReportData = new WSBandwidthReportData(key);
                wSBandwidthReportData.f(j3);
                wSBandwidthReportData.i(j16);
                wSBandwidthReportData.g(j17);
                wSBandwidthReportData.h(j18);
                e.c(wSBandwidthReportData);
            }
        }
    }

    public final void c(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ISPBandwidthMonitor iSPBandwidthMonitor = monitor;
        if (iSPBandwidthMonitor != null) {
            iSPBandwidthMonitor.start(context, new ISPBandwidthMonitor.Callback() { // from class: s00.a
                @Override // com.tencent.superplayer.api.ISPBandwidthMonitor.Callback
                public final void onBandwidthUpdate(Map map) {
                    b.d(map);
                }
            }, 60000L);
        }
    }

    public final void e(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ISPBandwidthMonitor iSPBandwidthMonitor = monitor;
        if (iSPBandwidthMonitor != null) {
            iSPBandwidthMonitor.stop(context);
        }
    }
}
