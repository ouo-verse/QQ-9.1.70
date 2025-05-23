package wu2;

import android.annotation.SuppressLint;
import android.view.ViewGroup;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.report.funnel.videofunnel.QAdVideoFunnelUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.QAdThreadManager;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import kt3.j;
import pw2.w;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {
    @SuppressLint({"ThreadSafeCheck"})
    private static void b(Map<String, Object> map, vu2.a aVar) {
        if (map != null && aVar.b() == 3) {
            map.put(VRReportDefine$ReportParam.AD_REPORTKEY_FST, 5);
            map.put(VRReportDefine$ReportParam.AD_REPORTKEY_SCD, 12);
        }
    }

    private static void c(vu2.a aVar, Map<String, Object> map) {
        ViewGroup viewGroup;
        if (aVar.g() == null) {
            viewGroup = null;
        } else {
            viewGroup = aVar.g().get();
        }
        Map<String, Object> j3 = QAdVideoFunnelUtil.j(viewGroup);
        if (y.i(j3)) {
            j3 = aVar.f();
        } else {
            aVar.j(j3);
        }
        y.b(map, j3);
    }

    public static vu2.a d(WeakReference<ViewGroup> weakReference, String str, j jVar) {
        vu2.a aVar = new vu2.a();
        aVar.k(weakReference);
        aVar.i(str);
        aVar.h(jVar);
        return aVar;
    }

    @SuppressLint({"ThreadSafeCheck"})
    private static Map<String, Object> e(vu2.a aVar) {
        if (aVar != null) {
            HashMap hashMap = new HashMap();
            b(hashMap, aVar);
            hashMap.put("business", "ad");
            hashMap.put("ad_request_id", aVar.e());
            y.b(hashMap, aVar.c());
            y.b(hashMap, QAdVideoFunnelUtil.i(aVar.d()));
            c(aVar, hashMap);
            return hashMap;
        }
        return null;
    }

    public static int f(int i3, int i16) {
        if (i3 != 0) {
            if (i3 != -822 && i3 != -823) {
                return 1;
            }
            return 3;
        }
        if (i16 == 0) {
            return 1;
        }
        return 2;
    }

    public static int g(int i3, int i16) {
        if (i3 != 0) {
            return i3;
        }
        return i16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void h(vu2.a aVar, a aVar2, Object obj, String str) {
        if (aVar != null) {
            aVar2.b(gw2.b.c(obj));
            aVar2.b(e(aVar));
        }
        w.i(str, aVar2.d());
    }

    public static void i(final String str, final a aVar, final Object obj, final vu2.a aVar2) {
        if (aVar == null) {
            aVar = new a().j().h();
        }
        QAdThreadManager.INSTANCE.execOnUiThread(new Runnable() { // from class: wu2.b
            @Override // java.lang.Runnable
            public final void run() {
                c.h(vu2.a.this, aVar, obj, str);
            }
        });
    }
}
