package qk4;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.timi.game.api.ITimiGameApi;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class i {
    private static Map<String, String> a(String str, long j3, int i3, String str2, long j16) {
        String str3;
        HashMap hashMap = new HashMap();
        hashMap.put("dt_eid", str);
        hashMap.put("qqlive_abtestid", String.valueOf(j16));
        hashMap.put("qqlive_room_id", String.valueOf(j3));
        hashMap.put("qqlive_gift_id", str2);
        com.tencent.mobileqq.qqlive.sail.c cVar = com.tencent.mobileqq.qqlive.sail.c.f272176a;
        hashMap.put("qqlive_user_id", String.valueOf(cVar.G()));
        hashMap.put("qqlive_anchor_id", String.valueOf(cVar.k(j3, 0)));
        hashMap.put("qqlive_program_id", cVar.v(j3, 0));
        hashMap.put("qqlive_enter_id", cVar.G() + "_" + j3 + "_" + cVar.r(j3, 0));
        if (i3 == 0) {
            str3 = "1";
        } else {
            str3 = "0";
        }
        hashMap.put("qqlive_zhibo_type", str3);
        return hashMap;
    }

    public static void b(String str, String str2, long j3, int i3, String str3, long j16) {
        ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).getLiveReportUtil().reportEvent(str, a(str2, j3, i3, str3, j16));
    }
}
