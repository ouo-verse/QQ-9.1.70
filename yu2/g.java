package yu2;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.vr.IVRPlayReport;
import java.util.Map;
import pw2.n;
import pw2.w;
import pw2.y;

/* compiled from: P */
/* loaded from: classes19.dex */
public class g {
    private static sv2.a a(@NonNull sv2.a aVar, Map<String, Object> map) {
        Map<String, Object> map2 = aVar.f434837f;
        if (map2 != null) {
            map2.putAll(map);
        } else {
            aVar.f434837f = map;
        }
        return aVar;
    }

    private static IVRPlayReport b(@NonNull com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.f fVar) {
        n.e("QAdPlayReportUtil", "createVRPlayReport, event.extraVRParams=" + fVar.f304105f + ";mVRPlayReportParams=" + ((Object) null));
        if (y.i(fVar.f304105f)) {
            return null;
        }
        return com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.vr.a.a(fVar, null);
    }

    private static void c(@NonNull com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.f fVar) {
        IVRPlayReport b16 = b(fVar);
        n.a("QAdPlayReportUtil", "doVRPlayReport, vrPlayReport=" + b16);
        if (b16 != null) {
            w.i(b16.getReportKey(), b16.getReportParams());
        }
    }

    private static void d(int i3, sv2.a aVar) {
        n.e("[MERGE][REPORT]", "JointEventId = " + i3);
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.f fVar = new com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.playerEvent.f();
        fVar.f304100a = i3;
        fVar.f304106g = aVar.f434845n;
        fVar.f304105f = aVar.e(i3);
        c(fVar);
    }

    public static void e(@NonNull sv2.a aVar, int i3, Map<String, Object> map) {
        if (aVar == null) {
            return;
        }
        d(i3, a(aVar, map));
    }
}
