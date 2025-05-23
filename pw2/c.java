package pw2;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.OpenSdkManager;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdConfigDefine$VersionDefine;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadutils.QAdDeviceUtils;
import com.tencent.qqlive.ona.protocol.jce.AdBaseExtraInfo;
import com.tencent.qqlive.ona.protocol.jce.AdExtraSystemInfo;
import com.tencent.qqlive.ona.protocol.jce.AdVideoPlatformInfo;
import com.tencent.qqlive.ona.protocol.jce.WechatVersionInfo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static WechatVersionInfo f427750a;

    public static AdBaseExtraInfo a(boolean z16, AdExtraSystemInfo adExtraSystemInfo) {
        return null;
    }

    public static AdExtraSystemInfo b() {
        return null;
    }

    private static void c(AdVideoPlatformInfo adVideoPlatformInfo, ow2.c cVar, boolean z16, AdExtraSystemInfo adExtraSystemInfo) {
        int l3;
        if (cVar != null) {
            l3 = QAdDeviceUtils.m(cVar.a());
        } else {
            l3 = QAdDeviceUtils.l();
        }
        adVideoPlatformInfo.newNetType = l3;
        adVideoPlatformInfo.vrPublicParams = k();
        adVideoPlatformInfo.taidTicket = ev2.b.j();
        adVideoPlatformInfo.adBaseExtraInfo = a(z16, adExtraSystemInfo);
        adVideoPlatformInfo.systemVersion = QAdDeviceUtils.x();
    }

    public static WechatVersionInfo d() {
        if (f427750a == null) {
            OpenSdkManager openSdkManager = OpenSdkManager.INSTANCE;
            f427750a = new WechatVersionInfo(openSdkManager.getWXOpenSdkVersion(), openSdkManager.isWXAppSupportAPI(), openSdkManager.getInternalOpenSdkVersion(), 0);
        }
        return f427750a;
    }

    @NonNull
    public static AdVideoPlatformInfo e() {
        AdVideoPlatformInfo adVideoPlatformInfo = new AdVideoPlatformInfo();
        adVideoPlatformInfo.f345338pf = QAdDeviceUtils.r();
        adVideoPlatformInfo.chid = ov2.a.b().a();
        adVideoPlatformInfo.sdtfrom = j();
        adVideoPlatformInfo.platform = i();
        adVideoPlatformInfo.device = Integer.toString(QAdDeviceUtils.s());
        adVideoPlatformInfo.openudid = QAdDeviceUtils.o();
        adVideoPlatformInfo.hwmachine = QAdDeviceUtils.g();
        adVideoPlatformInfo.wxVersionCode = OpenSdkManager.INSTANCE.getWXSupportAPIVersion();
        adVideoPlatformInfo.harmony_os_version = QAdDeviceUtils.f();
        adVideoPlatformInfo.harmony_pure_mode = QAdDeviceUtils.e();
        adVideoPlatformInfo.os_type = QAdDeviceUtils.n();
        adVideoPlatformInfo.wechatVersionInfo = d();
        c(adVideoPlatformInfo, null, false, b());
        return adVideoPlatformInfo;
    }

    @NonNull
    public static AdVideoPlatformInfo f(String str) {
        return g(str, "v5272");
    }

    @NonNull
    public static AdVideoPlatformInfo g(String str, String str2) {
        AdVideoPlatformInfo e16 = e();
        e16.sdtfrom = QAdConfigDefine$VersionDefine.K_QAD_SDT_FROM;
        e16.adxEncryData = nv2.a.a(str);
        if (qv2.b.e()) {
            n.e("AdRequestParamUtils", "AdVideoPlatformInfo adxEncryptData = " + e16.adxEncryData);
        }
        return e16;
    }

    public static String h() {
        n.e("AdRequestParamUtils", "getMidiaAdCookie");
        return "";
    }

    public static String i() {
        return "10303";
    }

    public static String j() {
        return "v5004";
    }

    public static Map<String, String> k() {
        return l();
    }

    private static Map<String, String> l() {
        String str;
        HashMap hashMap = new HashMap();
        Map<String, Object> d16 = w.d();
        if (d16 == null) {
            return hashMap;
        }
        for (String str2 : d16.keySet()) {
            Object obj = d16.get(str2);
            if (obj != null) {
                str = obj.toString();
            } else {
                str = "";
            }
            hashMap.put(str2, str);
        }
        return hashMap;
    }
}
