package pw2;

import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.thread.QAdThreadManager;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class w {
    public static Map<String, ?> b(Map<String, ?> map) {
        if (map == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        hashMap.putAll(map);
        return hashMap;
    }

    private static Map<String, Object> c(@NonNull Map<String, Object> map, @NonNull Object obj) {
        Map map2 = (Map) obj;
        Object obj2 = map2.get("ref_pg");
        if (obj2 instanceof Map) {
            map.put("ref_pg", obj2);
        }
        if (map2.get(QAdVrReportParams.ParamKey.REF_ELE) instanceof Map) {
            map.put(QAdVrReportParams.ParamKey.REF_ELE, map2.get(QAdVrReportParams.ParamKey.REF_ELE));
        }
        return map;
    }

    public static Map<String, Object> d() {
        hv2.a e16 = e();
        if (e16 != null) {
            return e16.f();
        }
        return null;
    }

    private static hv2.a e() {
        return ev2.e.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f(hv2.a aVar, String str, Map map) {
        aVar.b(str, b(map));
    }

    public static Map<String, Object> g(View view) {
        Map<String, Object> c16;
        hv2.a e16 = e();
        if (e16 == null || (c16 = e16.c(view)) == null) {
            return null;
        }
        Object obj = c16.get("cur_pg");
        if (!(obj instanceof Map)) {
            return c16;
        }
        return c(c16, obj);
    }

    public static void h(@Nullable Object obj, @Nullable String str, @Nullable Object obj2) {
        hv2.a e16 = e();
        if (e16 != null) {
            e16.a(obj, str, obj2);
        }
    }

    public static void i(String str, Map<String, ?> map) {
        j(str, map, true);
    }

    public static void j(String str, Map<String, ?> map, boolean z16) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            n.a("QAdVideoReportUtils", "QAdVideoReportUtils reportEvent," + str + ",eid:" + map.get("eid"));
            hashMap.putAll(map);
        }
        n.a("QAdVideoReportUtils", "enablePreInit:" + str);
        k(str, hashMap);
    }

    public static void k(final String str, final Map<String, ?> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        final hv2.a e16 = e();
        if (e16 == null) {
            return;
        }
        if (Looper.myLooper() != Looper.getMainLooper()) {
            e16.b(str, b(map));
        } else {
            QAdThreadManager.INSTANCE.execTask(new Runnable() { // from class: pw2.v
                @Override // java.lang.Runnable
                public final void run() {
                    w.f(hv2.a.this, str, map);
                }
            });
        }
    }

    public static void l(@Nullable Object obj, @Nullable String str, @Nullable Map<String, ?> map) {
        hv2.a e16 = e();
        if (e16 != null) {
            e16.e(obj, str, b(map));
        }
    }

    public static void m(View view, View view2) {
        hv2.a e16 = e();
        if (e16 != null) {
            e16.setLogicParent(view, view2);
        }
    }

    public static void n(Object obj, @QAdVrReport.ReportPolicy int i3) {
        hv2.a e16 = e();
        if (e16 != null) {
            e16.d(obj, i3);
        }
    }

    public static void o(Object obj, @Nullable Map<String, ?> map) {
        hv2.a e16 = e();
        if (e16 != null) {
            e16.setPageParams(obj, map);
        }
    }
}
