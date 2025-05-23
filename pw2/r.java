package pw2;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.wx.OpenSdkManager;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadutils.QAdDeviceUtils;
import com.tencent.tvideo.protocol.pb.AdFreshInfo;
import com.tencent.tvideo.protocol.pb.AdPlatformInfo;
import com.tencent.tvideo.protocol.pb.AdRequestContextInfo;
import com.tencent.tvideo.protocol.pb.AdRequestInfo;
import com.tencent.tvideo.protocol.pb.WechatVersionInfo;

/* compiled from: P */
/* loaded from: classes19.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    private static volatile AdRequestInfo.a f427781a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile AdPlatformInfo.a f427782b;

    private static AdFreshInfo a(String str) {
        if (str == null) {
            return null;
        }
        AdFreshInfo.a aVar = new AdFreshInfo.a();
        aVar.a(q.c(str));
        aVar.b(q.d());
        return aVar.build();
    }

    public static AdPlatformInfo b() {
        f427782b = new AdPlatformInfo.a();
        f427782b.u(QAdDeviceUtils.h()).b(QAdDeviceUtils.a()).D(QAdDeviceUtils.o()).I(QAdDeviceUtils.i()).d(lv2.b.c().a()).B(QAdDeviceUtils.w()).C(QAdDeviceUtils.q()).j(ov2.a.b().a()).F(QAdDeviceUtils.n()).r(QAdDeviceUtils.f()).s(QAdDeviceUtils.e()).A(lv2.a.b().c()).t(QAdDeviceUtils.g()).n(QAdDeviceUtils.g()).P(ev2.b.j()).q(ev2.b.b()).g(QAdDeviceUtils.b()).O(QAdDeviceUtils.x()).L(String.valueOf(QAdDeviceUtils.u())).J(String.valueOf(QAdDeviceUtils.t())).H(ev2.b.f()).G(QAdDeviceUtils.p());
        return f427782b.build();
    }

    private static AdRequestInfo c(String str) {
        if (f427781a == null) {
            f427781a = e().e(c.h());
        }
        return f427781a.f(str).build();
    }

    public static AdRequestContextInfo d(String str, String str2) {
        n.a("QAdRequestInfoHelper", "createAdRequestContextInfo, channelid:" + str2);
        AdRequestContextInfo.a aVar = new AdRequestContextInfo.a();
        aVar.b(a(str2)).c(c(str)).e(b());
        return aVar.build();
    }

    public static AdRequestInfo.a e() {
        if (f427781a == null) {
            synchronized (AdRequestInfo.class) {
                if (f427781a == null) {
                    AdRequestInfo.a a16 = new AdRequestInfo.a().c(QAdDeviceUtils.v()).a(lv2.b.c().f());
                    OpenSdkManager openSdkManager = OpenSdkManager.INSTANCE;
                    f427781a = a16.h(openSdkManager.getWXSupportAPIVersion()).g(new WechatVersionInfo.a().d(openSdkManager.getWXOpenSdkVersion()).b(openSdkManager.isWXAppSupportAPI()).build());
                }
            }
        }
        return new AdRequestInfo.a().c(f427781a.f383704b).a(f427781a.f383707e).h(f427781a.f383710h).g(f427781a.f383711i);
    }
}
