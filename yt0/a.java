package yt0;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.icgame.api.IQQLiveUtil;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.icgame.api.room.IQQLiveAudienceRoomApi;
import com.tencent.mobileqq.icgame.api.room.IReportEnterRoom;
import com.tencent.mobileqq.icgame.context.QQLiveContext;
import com.tencent.mobileqq.icgame.techreport.d;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final IAegisLogApi f451169a = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    private static void a(Context context, xt0.a aVar, long j3) {
        f451169a.i("ICGameEntrance|ICGameEnterRoomHelper", "enterRoom-----end");
        ((IQQLiveUtil) QRoute.api(IQQLiveUtil.class)).clearAutoSwitchFlags();
        long longValue = f(aVar.f448493c).longValue();
        String str = aVar.f448500j;
        e(longValue, str, String.valueOf(aVar.f448496f));
        d("new room", longValue, str, System.currentTimeMillis() - j3);
        ((IQQLiveAudienceRoomApi) QRoute.api(IQQLiveAudienceRoomApi.class)).enterRoom(context, aVar, false);
    }

    public static void b(xt0.a aVar) {
        if (aVar != null && !TextUtils.isEmpty(aVar.f448493c)) {
            f451169a.i("ICGameEntrance|ICGameEnterRoomHelper", "enterRoom");
            a(BaseApplication.getContext(), aVar, System.currentTimeMillis());
        } else {
            f451169a.e("ICGameEntrance|ICGameEnterRoomHelper", "error enter room id null");
        }
    }

    private static String c() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && peekAppRuntime.isLogin() && !TextUtils.isEmpty(peekAppRuntime.getCurrentAccountUin())) {
            return peekAppRuntime.getAccount();
        }
        return "-1";
    }

    private static void d(String str, long j3, String str2, long j16) {
        String str3;
        String str4;
        String str5;
        QQLiveContext b16 = QQLiveContext.INSTANCE.b("1078");
        if (b16 != null) {
            str3 = b16.getTraceId();
            str5 = b16.f();
            str4 = b16.k();
        } else {
            str3 = null;
            str4 = null;
            str5 = null;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(AudienceReportConst.ROOM_ID, String.valueOf(j3));
        hashMap.put("room_type", str2);
        hashMap.put("cost_time", String.valueOf(j16));
        hashMap.put("ext1", str3);
        hashMap.put("ext2", str);
        hashMap.put("ext3", str5);
        hashMap.put("ext4", str4);
        hashMap.put("ext5", String.valueOf(System.currentTimeMillis()));
        d.g("ev_icgame_enter_room_step", hashMap);
    }

    private static void e(long j3, String str, String str2) {
        ((IReportEnterRoom) QRoute.api(IReportEnterRoom.class)).saveRecordInfo(j3, str, str2, c());
        ((IReportEnterRoom) QRoute.api(IReportEnterRoom.class)).reportStartClickEnterRoom(j3);
    }

    public static Long f(String str) {
        try {
            return Long.valueOf(Long.parseLong(str));
        } catch (NumberFormatException e16) {
            QLog.e("ICGameEntrance|ICGameEnterRoomHelper", 1, "safeParseLong fail ", e16);
            return 0L;
        }
    }
}
