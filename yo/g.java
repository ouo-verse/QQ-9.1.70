package yo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.route.QZoneMoodListInitBean;
import com.qzone.util.ToastUtil;
import com.tencent.aelight.camera.api.IAECameraUnit;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.IConfigProxy;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.mobileqq.vas.toggle.VasLongToggle;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZonePublishConfig;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.report.lp.QZoneLoginReportHelper;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.QZoneJsConstants;
import ho.i;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public class g {

    /* renamed from: i, reason: collision with root package name */
    public static boolean f450707i = true;

    /* renamed from: a, reason: collision with root package name */
    public String f450708a;

    /* renamed from: b, reason: collision with root package name */
    public String f450709b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f450710c;

    /* renamed from: d, reason: collision with root package name */
    public String f450711d;

    /* renamed from: e, reason: collision with root package name */
    public int f450712e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f450713f;

    /* renamed from: g, reason: collision with root package name */
    public Map f450714g;

    /* renamed from: h, reason: collision with root package name */
    private int f450715h;

    static {
        f450707i = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_JUMPQZONE, QzoneConfig.SECONDARY_JUMPQZONE_SCHEME_ENABLE, 1) == 1;
    }

    public g(String str, String str2) {
        int indexOf;
        int i3;
        this.f450710c = true;
        this.f450715h = 0;
        this.f450711d = str2;
        this.f450708a = str;
        if (!a(str) || (indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) < 0 || (i3 = indexOf + 1) >= str.length()) {
            return;
        }
        str.substring(i3);
        Bundle e16 = f.e(str);
        this.f450710c = "0".equals(e16.getString("update"));
        this.f450709b = e16.getString("backup");
        String string = e16.getString("versionCode");
        this.f450713f = "1".equals(e16.getString("syncflag"));
        this.f450708a = f.f(str, "backup");
        this.f450708a = f.f(str, "update");
        this.f450708a = f.f(str, "versionCode");
        if (TextUtils.isEmpty(string)) {
            this.f450712e = 0;
            return;
        }
        try {
            this.f450712e = Integer.parseInt(string);
        } catch (NumberFormatException e17) {
            QZLog.e("exception", "scheme \u643a\u5e26\u7684\u7248\u672c\u53f7\u6709\u95ee\u9898", e17);
            this.f450712e = 0;
        }
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String scheme = Uri.parse(str).getScheme();
        return "mqzone".equals(scheme) || "mqzonev2".equals(scheme) || "mqzonev3".equals(scheme);
    }

    private void b(Context context, String str) {
        if (QZonePublishConfig.isUseQCirclePublish()) {
            try {
                Uri parse = Uri.parse(str);
                String queryParameter = parse.getQueryParameter(IAECameraUnit.WIDGET_NAME);
                String queryParameter2 = parse.getQueryParameter("from");
                Bundle c16 = c(queryParameter);
                c16.putString("from", queryParameter2);
                com.qzone.common.business.service.b.f().v(context, c16);
                return;
            } catch (Exception e16) {
                QLog.e("SchemeInfo", 1, "dealWithTakeVideo error :" + e16 + ",scheme :" + str);
                e16.printStackTrace();
                return;
            }
        }
        c.C(context, str);
    }

    private Bundle c(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(PeakConstants.DEST_ACTIVITY_CLASS_NAME, ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).getQZonePublishMoodActivityClass().getName());
        return bundle;
    }

    private static void d(Context context, String str) {
        try {
            String queryParameter = Uri.parse(str).getQueryParameter("tab");
            i.u().a(context, "getActiveFeeds", (TextUtils.isEmpty(queryParameter) || !"intimate".equals(queryParameter)) ? 0 : 2);
        } catch (Exception e16) {
            QLog.e("SchemeInfo", 1, "parse loginfrom error" + e16);
        }
    }

    private void e(String str, Context context) {
        String str2;
        try {
            str2 = Uri.parse(str).getQueryParameter("source");
        } catch (Exception e16) {
            e16.printStackTrace();
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2) && "push".equals(str2)) {
            c.v(context, str);
            return;
        }
        if (!TextUtils.isEmpty(str2) && "tafrefer".equals(str2)) {
            c.v(context, str);
            return;
        }
        if (!TextUtils.isEmpty(str2) && "doNotJumpQzone".equals(str2)) {
            c.v(context, str);
        } else if (b.g(context, b.f450702d)) {
            k(context);
        } else {
            c.v(context, str);
        }
    }

    private void f(String str, Context context) {
        c.A(context, str);
    }

    private void g(Context context, String str) {
        if (b.g(context, b.f450702d)) {
            LoginData.getInstance().getUin();
            k(context);
        } else {
            c.B(context, str);
        }
    }

    private boolean h(String str, Context context, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        d.g(str, context, str2, this.f450714g);
        return true;
    }

    private boolean i(Context context, String str) {
        Intent intent = new Intent();
        intent.setData(Uri.parse(str));
        List<ResolveInfo> queryIntentActivities = InstalledAppListMonitor.queryIntentActivities(context.getPackageManager(), intent, 65536);
        return queryIntentActivities != null && queryIntentActivities.size() > 0;
    }

    private void j(Context context) {
        if (TextUtils.isEmpty(this.f450708a)) {
            return;
        }
        if (a(this.f450708a)) {
            l(context, this.f450708a);
            return;
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse(this.f450708a));
        b.a(intent);
        context.startActivity(intent);
    }

    private void l(Context context, String str) {
        Object obj;
        if (a(this.f450708a)) {
            if (this.f450713f) {
                this.f450708a = f.b(this.f450708a, "selfUin", LoginData.getInstance().getUinString());
            }
            Map map = this.f450714g;
            Map map2 = (map == null || (obj = map.get("key2")) == null || !(obj instanceof Map)) ? null : (Map) obj;
            if (f450707i) {
                b.f(context, Uri.parse(str), map2);
            }
        }
    }

    private void n() {
        this.f450708a = f.h(this.f450708a);
        String u16 = f.u(this.f450711d);
        this.f450711d = u16;
        if (TextUtils.isEmpty(u16)) {
            return;
        }
        this.f450711d.getBytes();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k(Context context) {
        if (context == null) {
            return -1;
        }
        if (a(this.f450708a)) {
            if (b.g(context, this.f450712e) && b.h(context)) {
                l(context, this.f450708a);
            } else {
                if (!TextUtils.isEmpty(this.f450709b)) {
                    h(this.f450709b, context, this.f450711d);
                    return 3;
                }
                if (!this.f450710c) {
                    b.e(context);
                    return 2;
                }
                if (!b.h(context) || b.g(context, this.f450712e)) {
                    return -1;
                }
                l(context, this.f450708a);
            }
            return 1;
        }
        if (!TextUtils.isEmpty(this.f450709b)) {
            h(this.f450709b, context, this.f450711d);
            return 4;
        }
        i.p(context, this.f450708a);
        return -1;
    }

    @Deprecated
    public int m(Context context) {
        int i3;
        long j3;
        if (context == null || (i3 = this.f450715h) > 5) {
            return -1;
        }
        int i16 = 1;
        this.f450715h = i3 + 1;
        QLog.d("SchemeInfo", 1, "[navigate] jump scheme:" + this.f450708a);
        String str = this.f450711d;
        byte[] bytes = str != null ? str.getBytes() : null;
        if (TextUtils.isEmpty(this.f450708a) && TextUtils.isEmpty(this.f450709b)) {
            ToastUtil.n(R.string.a95);
            QZLog.w(QZLog.TO_DEVICE_TAG, "browse url fail:" + this.f450708a);
            return -1;
        }
        if (TextUtils.isEmpty(this.f450708a)) {
            this.f450708a = this.f450709b;
        }
        if (this.f450708a.contains("create_qzone_publish_id=1")) {
            eo.c.f396879a.b();
        }
        n();
        if (e.a(context, this.f450708a)) {
            return 4;
        }
        QZoneLoginReportHelper.reportLoginFromSchema(this.f450708a);
        if (this.f450708a.startsWith("https") && this.f450708a.contains("is_famous_space=1")) {
            try {
                j3 = Long.parseLong(Uri.parse(this.f450708a).getQueryParameter("uin"));
            } catch (Exception unused) {
                QZLog.e(QZLog.TO_DEVICE_TAG, "openShareHomePage uin parse error");
                j3 = 0;
            }
            i.z().f(context, j3);
            return 4;
        }
        if (URLUtil.isNetworkUrl(this.f450708a)) {
            if (this.f450708a.contains("giftv2/vuemall")) {
                IConfigProxy iConfigProxy = VasLongToggle.QZONE_BIRTHDAY_GIFT;
                if (iConfigProxy.isEnable(false)) {
                    String stringData = iConfigProxy.getStringData("");
                    if (!TextUtils.isEmpty(stringData)) {
                        ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openSchema(context, stringData.replace("{friends}", String.valueOf(LoginData.getInstance().getUin())).replace("{from}", "qqnavigation"));
                    }
                    return 4;
                }
            }
            h(this.f450708a, context, this.f450711d);
            return 4;
        }
        if (this.f450708a.startsWith("mqqapi://videostory/takevideo")) {
            b(context, this.f450708a);
            return 4;
        }
        if (this.f450708a.startsWith("mqqapi:")) {
            c.C(context, this.f450708a);
            return 4;
        }
        if (!a(this.f450708a) && i(context, this.f450708a)) {
            j(context);
            return 5;
        }
        if (this.f450708a.startsWith("mqzone://arouse/yellowdiamond")) {
            c.T(context, this.f450708a);
        } else if (this.f450708a.startsWith("mqzone://arouse/albumedit")) {
            c.D(context, this.f450708a);
        } else if (this.f450708a.startsWith("mqzone://arouse/albumlist")) {
            c.n(context, this.f450708a);
        } else if (this.f450708a.startsWith("mqzone://arouse/newmoodsignin")) {
            vo.c.W(context);
        } else if (this.f450708a.startsWith(QZoneJsConstants.SCHEME_PREFIX_UPLOAD_PHOTO)) {
            c.S(context, this.f450708a);
        } else if (this.f450708a.startsWith("mqzone://arouse/writemood")) {
            c.N(context, this.f450708a);
        } else if (this.f450708a.startsWith(QZoneJsConstants.SCHEME_PREFIX_SET_PHONE_TAG)) {
            c.O(context);
        } else if (this.f450708a.startsWith(QZoneJsConstants.SCHEME_PREFIX_UPDATE_QZDESC)) {
            c.Q(context, this.f450708a);
        } else if (this.f450708a.startsWith("mqzone://arouse/takevideo")) {
            c.R((Activity) context, this.f450708a);
        } else if (this.f450708a.startsWith("mqzone://arouse/picsetting")) {
            c.L();
        } else if (this.f450708a.startsWith(QZoneJsConstants.SCHEME_PREFIX_AVATAR)) {
            c.q(context, this.f450708a, this.f450714g);
        } else {
            if (this.f450708a.startsWith("mqzone://arouse/visitor")) {
                if (f450707i) {
                    vo.a.b(context, LoginData.getInstance().getUin(), this);
                }
            } else if (this.f450708a.startsWith("mqzone://arouse/persionsetting")) {
                c.r(context);
            } else if (this.f450708a.startsWith("mqzone://arouse/opapp")) {
                if (f450707i) {
                    c.M(context, this.f450708a, bytes, this.f450714g);
                }
            } else if (this.f450708a.startsWith(QZoneJsConstants.SCHEME_PREFIX_SET_DECORATION)) {
                c.p(context, this.f450708a, this.f450714g);
            } else if (!this.f450708a.startsWith(QZoneJsConstants.SCHEME_PREFIX_SET_COVER) && !this.f450708a.startsWith(QZoneJsConstants.SCHEME_PREFIX_SET_COVER_V2)) {
                if (this.f450708a.startsWith(QZoneJsConstants.SCHEME_PREFIX_FACADE)) {
                    b.c(context, this);
                } else if (this.f450708a.startsWith("mqzone://arouse/customsetting")) {
                    b.c(context, this);
                } else if (this.f450708a.startsWith("mqzone://arouse/gamecenter")) {
                    b.c(context, this);
                } else if (this.f450708a.startsWith("mqzonev2://arouse/choosegift")) {
                    b.c(context, this);
                } else if (this.f450708a.startsWith("mqzonev2://arouse/magicVoice")) {
                    b.c(context, this);
                } else if (this.f450708a.startsWith("mqzone://arouse/backgroundmusic")) {
                    c.o(context, this.f450708a);
                } else if (this.f450708a.startsWith("mqzone://arouse/rightssetting")) {
                    vo.b.h(context);
                } else if (this.f450708a.startsWith("mqzone://arouse/listmessage")) {
                    vo.b.k(context);
                } else if (this.f450708a.startsWith("mqzone://arouse/friendbirthday")) {
                    vo.c.I(context, QZoneConfigHelper.G0());
                } else if (this.f450708a.startsWith("mqzone://arouse/visitingnotification")) {
                    vo.c.H(context);
                } else if (this.f450708a.startsWith("mqzone://arouse/hidevisitorrecordsetting")) {
                    vo.c.J(context);
                } else if (this.f450708a.startsWith("mqzone://arouse/stealthvisitsetting")) {
                    vo.c.K(context);
                } else if (this.f450708a.startsWith(QZoneJsConstants.SCHEMA_DYNAMICNICKNAME)) {
                    vo.b.i(context);
                } else if (this.f450708a.startsWith("mqzone://arouse/hidesetting")) {
                    vo.b.j(context);
                } else if (this.f450708a.startsWith("mqzone://arouse/scanmyqzone")) {
                    vo.c.s(context);
                } else if (this.f450708a.startsWith("mqzone://arouse/scanmyvister")) {
                    vo.c.U(context);
                } else if (this.f450708a.startsWith("mqzone://arouse/noscanfeeds")) {
                    vo.c.i(context);
                } else if (this.f450708a.startsWith("mqzone://arouse/archivemyfeeds")) {
                    vo.c.F(context);
                } else if (this.f450708a.startsWith("mqzone://arouse/moodlist")) {
                    if (!i.p(context, this.f450708a)) {
                        QLog.d("SchemeInfo", 1, "launch old mood list scheme");
                        i.j().b(context, new QZoneMoodListInitBean(LoginData.getInstance().getUin(), LoginData.getInstance().getNickName(""), "getActiveFeeds"));
                    }
                } else if (this.f450708a.startsWith("mqzone://arouse/bloglist")) {
                    vo.b.g(context, LoginData.getInstance().getUin(), LoginData.getInstance().getNickName(""), "getActiveFeeds");
                } else if (!this.f450708a.startsWith("mqzone://arouse/passive") && !this.f450708a.startsWith("mqzone://arouse/passivityfeed")) {
                    if (!this.f450708a.startsWith("mqzone://arouse/signin") && !this.f450708a.startsWith("mqzone://arouse/moodsignin")) {
                        if (this.f450708a.startsWith("mqzone://arouse/albumcategorydetail")) {
                            c.g(context, this.f450708a);
                        } else if (this.f450708a.startsWith("mqzone://arouse/album")) {
                            e(this.f450708a, context);
                        } else if (this.f450708a.startsWith("mqzone://arouse/photofromwxapp")) {
                            f(this.f450708a, context);
                        } else if (this.f450708a.startsWith("mqzone://arouse/bizfriendalbum")) {
                            c.v(context, this.f450708a);
                        } else if (this.f450708a.startsWith("mqzone://arouse/webtofeeddetail")) {
                            c.x(context, this.f450708a);
                        } else if (this.f450708a.startsWith("mqzone://arouse/detailbyurl")) {
                            i16 = c.u(context, this.f450708a);
                        } else if (this.f450708a.startsWith(QZoneJsConstants.SCHEME_FEED_DETAIL)) {
                            i16 = c.t(context, this.f450708a);
                        } else if (!this.f450708a.startsWith("mqzonev2://arouse/activefeed") && !this.f450708a.startsWith("mqzone://arouse/activefeed")) {
                            if (!this.f450708a.startsWith(QZoneHelper.SCHEME_OPEN_HOME_PAGE) && !this.f450708a.startsWith("mqzone://arouse/open_homepage")) {
                                if (this.f450708a.startsWith("mqzone://arouse/app")) {
                                    c.I(context, this.f450708a);
                                } else if (this.f450708a.startsWith("mqzone://arouse/webview")) {
                                    g(context, this.f450708a);
                                } else if (this.f450708a.startsWith("mqzone://arouse/pastercategory")) {
                                    c.z(context, this.f450708a);
                                } else if (this.f450708a.startsWith(QZoneJsConstants.SCHEME_OPEN_VIDEOLAYER)) {
                                    c.J(context, this.f450708a);
                                } else if (this.f450708a.startsWith("mqzone://arouse/setLocalCover")) {
                                    c.F(context, this.f450708a);
                                } else if (this.f450708a.startsWith("mqzone://arouse/eventtagpage")) {
                                    c.E(context, this.f450708a, this.f450714g);
                                } else if (this.f450708a.startsWith("mqzone://arouse/potentialfriends")) {
                                    c.G(context, this.f450708a);
                                } else if (this.f450708a.startsWith("mqzone://arouse/wnssetting")) {
                                    c.K(context, this.f450708a);
                                } else if (this.f450708a.startsWith("mqzone://arouse/test")) {
                                    c.H(context, this.f450708a);
                                } else if (this.f450708a.startsWith("mqzone://arouse/weishi")) {
                                    c.m(context, this.f450708a, this.f450714g);
                                } else if (this.f450708a.startsWith("mqzone://arouse/gamebar")) {
                                    h(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_GAMEBAR, QzoneConfig.DefaultValue.QZONE_GAMEBAR_URL), context, null);
                                } else if (this.f450708a.startsWith("mqzone://arouse/choosegif")) {
                                    c.l((Activity) context, this.f450708a);
                                } else if (this.f450708a.startsWith("mqzone://arouse/choosepicture")) {
                                    c.k((Activity) context, this.f450708a, 1);
                                } else if (this.f450708a.startsWith("mqzone://arouse/qzvideomaker?businesstype=videomaker")) {
                                    c.h(context, this.f450708a);
                                } else if (this.f450708a.startsWith("mqzone://arouse/sharememberlist")) {
                                    c.j(context, this.f450708a);
                                } else if (this.f450708a.startsWith("mqzone://arouse/minigame")) {
                                    c.i(context, this.f450708a);
                                } else {
                                    i.p(context, this.f450708a);
                                }
                            } else {
                                c.y(context, this.f450708a);
                            }
                        } else {
                            e.b(context, this.f450708a);
                        }
                    } else {
                        vo.c.W(context);
                    }
                } else {
                    d(context, this.f450708a);
                }
            } else {
                c.s(context, this.f450708a, bytes, this.f450714g);
            }
            LpReportInfo_dc02880.report(this.f450708a);
            return i16;
        }
        i16 = 4;
        LpReportInfo_dc02880.report(this.f450708a);
        return i16;
    }

    public g(String str) {
        this(str, null);
    }
}
