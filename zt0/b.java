package zt0;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.IModule;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.ServiceConst;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f453177a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f453178b = false;

    /* renamed from: c, reason: collision with root package name */
    private static IAegisLogApi f453179c = (IAegisLogApi) QRoute.api(IAegisLogApi.class);

    /* renamed from: d, reason: collision with root package name */
    private static long f453180d = 0;

    /* renamed from: e, reason: collision with root package name */
    private static long f453181e = 0;

    private static boolean b(xt0.a aVar) {
        if (aVar != null && aVar.f448491a != null) {
            IModule moduleByName = AVBizModuleFactory.getModuleByName("\u4e92\u52a8\u4e91\u73a9\u6cd5");
            final Context context = aVar.f448491a;
            String checkAVFocus = moduleByName.checkAVFocus();
            if (!"true".equals(checkAVFocus)) {
                final String format = String.format(context.getResources().getString(R.string.z_k), checkAVFocus);
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: zt0.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.d(context, format);
                    }
                });
                f453179c.e("ICGameEntrance|ICGameIliveEntranceUtil", 1, "preCheckIsUserGamePlaying, res[" + checkAVFocus + "]");
                return false;
            }
            f453179c.i("ICGameEntrance|ICGameIliveEntranceUtil", "checkAVEnable success");
        }
        return true;
    }

    public static boolean c(int i3) {
        f453181e = System.currentTimeMillis();
        boolean z16 = true;
        QLog.i("ICGameEntrance|ICGameIliveEntranceUtil", 1, " offset = " + (f453181e - f453180d));
        long j3 = f453181e;
        if (j3 - f453180d <= i3) {
            z16 = false;
        }
        f453180d = j3;
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(Context context, String str) {
        QQToast.makeText(context, str, 1).show();
    }

    public static void e(xt0.a aVar) {
        String account;
        if (aVar == null) {
            return;
        }
        if (!b(aVar)) {
            HashMap hashMap = new HashMap();
            hashMap.put("ext1", aVar.f448508r);
            hashMap.put(AudienceReportConst.EVENT_MSG, "AV Disable");
            com.tencent.mobileqq.icgame.techreport.d.g("ev_icgame_enter_room_break", hashMap);
            return;
        }
        if (!TextUtils.isEmpty(aVar.f448499i)) {
            try {
                aVar.f448499i = Uri.decode(aVar.f448499i);
            } catch (Exception e16) {
                f453179c.e("ICGameEntrance|ICGameIliveEntranceUtil", e16.getMessage());
            }
        }
        f453179c.i("ICGameEntrance|ICGameIliveEntranceUtil", "liveWatchEntranceJump source = " + aVar.f448492b + " roomID = " + aVar.f448493c + " retain = " + aVar.f448495e + " sIsAnchorIsLive = " + f453177a + " sIsAudienceIsLive = " + f453178b);
        if (TextUtils.isEmpty(aVar.f448493c)) {
            aVar.f448493c = "-1";
        }
        if (aVar.f448499i == null) {
            aVar.f448499i = "";
        }
        if (TextUtils.isEmpty(aVar.f448497g)) {
            aVar.f448497g = "";
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            account = "";
        } else {
            account = peekAppRuntime.getAccount();
        }
        String str = account + "_" + System.currentTimeMillis();
        try {
            JSONObject jSONObject = new JSONObject();
            if (!TextUtils.isEmpty(aVar.f448497g)) {
                jSONObject = new JSONObject(Uri.decode(aVar.f448497g));
            }
            jSONObject.put(ServiceConst.PARA_SESSION_ID, str);
            aVar.f448497g = jSONObject.toString();
        } catch (Exception unused) {
            QLog.e("ICGameEntrance|ICGameIliveEntranceUtil", 1, "");
        }
        yt0.a.b(aVar);
    }
}
