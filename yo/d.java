package yo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.util.ToastUtil;
import com.qzone.util.l;
import com.tencent.ad.tangram.downloader.AdDownloadConstants;
import com.tencent.gdtad.IGdtAPI;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.vas.VipMMKV;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.webview.swift.ag;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.ipc.IPCConst;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qzonehub.api.IQZoneRouteApi;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzoneTranslucentBrowserFragment;
import cooperation.qzone.statistic.AccManager;
import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes36.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f450705a = false;

    public static int h(String str, Context context, String str2, Map map) {
        try {
            String transformUrlToScheme = ((IWeatherCommApi) QRoute.api(IWeatherCommApi.class)).transformUrlToScheme(str);
            QLog.i("WeatherWebPage", 1, "handleWeatherScheme url = " + str + ",schemeUrl=" + transformUrlToScheme);
            if (!TextUtils.isEmpty(transformUrlToScheme)) {
                str = transformUrlToScheme;
            }
            g gVar = new g(str, str2);
            gVar.f450714g = map;
            return b(context, gVar);
        } catch (Exception e16) {
            QLog.i("WeatherWebPage", 1, "handleWeatherUrl", e16);
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x003a A[Catch: Exception -> 0x0041, TRY_LEAVE, TryCatch #0 {Exception -> 0x0041, blocks: (B:5:0x0008, B:7:0x0019, B:9:0x0022, B:11:0x002b, B:16:0x003a), top: B:4:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean i(String str, String str2) {
        boolean z16;
        if (!TextUtils.isEmpty(str)) {
            try {
                String scheme = Uri.parse(str).getScheme();
                if (!"mqzone".equals(scheme) && !"mqzonev2".equals(scheme) && !"mqzonev3".equals(scheme) && !SchemaUtils.SCHEMA_MQQAPI.equals(scheme)) {
                    z16 = false;
                    if (z16) {
                        if (str.contains(str2)) {
                            return true;
                        }
                    }
                }
                z16 = true;
                if (z16) {
                }
            } catch (Exception e16) {
                QLog.e("QZoneSchemeManager", 1, "parse schema error: ", e16);
            }
        }
        return false;
    }

    public static String j(String str) {
        return TextUtils.isEmpty(str) ? str : f.f(str, "sid");
    }

    public static void k(Activity activity, String str, int i3, Bundle bundle, String str2, Map map) {
        if (TextUtils.isEmpty(str)) {
            ToastUtil.n(R.string.a95);
            QZLog.w(QZLog.TO_DEVICE_TAG, "browse url fail:" + j(str));
            return;
        }
        String t16 = f.t(f.w(f.u(str), LoginData.getInstance().getUin()));
        String u16 = f.u(str2);
        byte[] bytes = TextUtils.isEmpty(u16) ? null : u16.getBytes();
        String c16 = f.c(t16, 5L, false);
        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserActivity.class);
        QZoneHelper.openWebSecurityVerify(intent);
        intent.putExtra("post_data", bytes);
        intent.putExtra("url", c16);
        intent.putExtra("fromQZone", true);
        intent.putExtra("injectrecommend", true);
        intent.putExtra("source_name", BaseApplication.getContext().getString(R.string.ghh));
        intent.setData(Uri.parse(c16));
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        b.a(intent);
        if (activity instanceof PluginProxyActivity) {
            ((PluginProxyActivity) activity).startActivityForResult(intent, i3);
        } else if (activity instanceof BasePluginActivity) {
            ((BasePluginActivity) activity).startActivityForResult(intent, i3);
        } else {
            activity.startActivityForResult(intent, i3);
        }
    }

    public static void o(Activity activity, String str, boolean z16, int i3, int i16, int i17, boolean z17, boolean z18) {
        if (!TextUtils.isEmpty(str) && activity != null) {
            String c16 = f.c(f.t(f.w(f.u(str), LoginData.getInstance().getUin())), 5L, false);
            Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQTranslucentBrowserActivity.class);
            intent.putExtra("fragmentStyle", 2);
            intent.putExtra("url", c16);
            intent.putExtra("fromQZone", true);
            intent.putExtra("injectrecommend", true);
            intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, z16);
            if (z17) {
                intent.putExtra(QQBrowserActivity.EXTRA_FINISH_ANIMATION_OUT_TO_TOP, true);
            } else {
                intent.putExtra(QQBrowserActivity.EXTRA_FINISH_ANIMATION_NONE, true);
            }
            intent.putExtra(QzoneTranslucentBrowserFragment.CONTENT_BACKGROUND_COLOR, i16);
            intent.putExtra(QQTranslucentBrowserActivity.FLAG_HIDE_PROGRESS_BAR, z18);
            intent.setData(Uri.parse(c16));
            b.a(intent);
            activity.startActivityForResult(intent, i17);
            activity.overridePendingTransition(i3, 0);
            return;
        }
        ToastUtil.o(R.string.a95, 4);
        QZLog.e(QZLog.TO_DEVICE_TAG, "browse url fail: " + str);
    }

    public static void q(Context context, String str, int i3, Bundle bundle, String str2, Map map, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            ToastUtil.n(R.string.a95);
            QZLog.w(QZLog.TO_DEVICE_TAG, "browse url fail:" + str);
            return;
        }
        String t16 = f.t(f.w(f.u(str), LoginData.getInstance().getUin()));
        String u16 = f.u(str2);
        byte[] bytes = TextUtils.isEmpty(u16) ? null : u16.getBytes();
        boolean z17 = false;
        String c16 = f.c(t16, 5L, false);
        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQTranslucentBrowserActivity.class);
        intent.putExtra("post_data", bytes);
        intent.putExtra("url", c16);
        intent.putExtra("fromQZone", true);
        intent.putExtra("injectrecommend", true);
        intent.putExtra(IPCConst.KEY_HIDE_LEFT_BUTTON, z16);
        if (bundle != null && bundle.getBoolean(QQTranslucentBrowserActivity.FLAG_SHOW_LOADING_DIALOG, false)) {
            z17 = true;
        }
        intent.putExtra(QQTranslucentBrowserActivity.FLAG_SHOW_LOADING_DIALOG, z17);
        intent.setData(Uri.parse(c16));
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i3);
        } else {
            intent.setFlags(268435456);
            BaseApplication.getContext().startActivity(intent);
        }
    }

    public static int c(String str, Context context) {
        return e(str, context, null, null);
    }

    public static int d(String str, Context context, String str2) {
        return e(str, context, str2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void f(String str, Context context, String str2) {
        g(str, context, str2, null);
    }

    public static void l(Activity activity, String str, int i3, String str2) {
        m(activity, str, i3, str2, null);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
    
        if (r1.isWeatherArkPageUrl(r4) != false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String r(String str) {
        try {
            IWeatherCommApi iWeatherCommApi = (IWeatherCommApi) QRoute.api(IWeatherCommApi.class);
            if (!TextUtils.isEmpty(str)) {
                if (!iWeatherCommApi.isWeatherArkPageUrl(str)) {
                    str = Uri.parse(str).getQueryParameter("url");
                    if (!TextUtils.isEmpty(str)) {
                        str = URLDecoder.decode(str);
                    }
                }
                return str;
            }
            str = null;
            return str;
        } catch (Exception e16) {
            QLog.i("WeatherWebPage", 1, "tryFilterWeatherUrl", e16);
            return null;
        }
    }

    @Deprecated
    public static int b(Context context, g gVar) {
        if (gVar != null) {
            return gVar.m(context);
        }
        return -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int e(String str, Context context, String str2, Map map) {
        int i3;
        Context outActivity;
        Object obj;
        BusinessFeedData businessFeedData = (map == null || (obj = map.get("businessFeedData")) == null || !(obj instanceof BusinessFeedData)) ? null : (BusinessFeedData) obj;
        if (!TextUtils.isEmpty(str) && str.startsWith(QzoneConfig.SCHEME_FOR_SWEET_MAIN_PAGE_JUMP)) {
            return a(str, context, str2, map);
        }
        if (!TextUtils.isEmpty(str) && str.startsWith("mqzone://arouse/groupalbum/")) {
            ((IQZoneRouteApi) QRoute.api(IQZoneRouteApi.class)).launchQZoneScheme(context, str);
            return 1;
        }
        String r16 = r(str);
        if (!TextUtils.isEmpty(r16)) {
            return h(r16, context, str2, map);
        }
        if (((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(str)) {
            if (map != null) {
                Object obj2 = map.get("scene");
                if (obj2 instanceof Integer) {
                    i3 = ((Integer) obj2).intValue();
                    outActivity = !(context instanceof BasePluginActivity) ? ((BasePluginActivity) context).getOutActivity() : context;
                    if (outActivity != null) {
                        ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(outActivity, str, i3, null);
                        return 4;
                    }
                }
            }
            i3 = 2009;
            if (!(context instanceof BasePluginActivity)) {
            }
            if (outActivity != null) {
            }
        }
        if (businessFeedData != null && businessFeedData.isGDTAdvFeed()) {
            return -1;
        }
        g gVar = new g(str, str2);
        gVar.f450714g = map;
        return b(context, gVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01bd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int a(String str, Context context, String str2, Map map) {
        String str3;
        String str4;
        String str5;
        z5.a f16;
        String str6;
        String str7;
        String config;
        x6.a g16;
        boolean f17;
        if (context == null) {
            return -1;
        }
        String str8 = "";
        if (!TextUtils.isEmpty(str) && str.startsWith(QzoneConfig.SCHEME_FOR_SWEET_MAIN_PAGE_JUMP)) {
            boolean z16 = false;
            if (((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch()) {
                QQToast.makeText(context, l.a(R.string.f167672dk), 0).show();
                return -1;
            }
            Long l3 = 0L;
            if (map != null) {
                Object obj = map.get("uin");
                if (obj != null && (obj instanceof Long)) {
                    l3 = (Long) obj;
                }
                if (l3.longValue() > 0 && (!(f17 = y6.b.f(l3.longValue())) || !TextUtils.equals(VipMMKV.getLoveZone(String.valueOf(LoginData.getInstance().getUin())).decodeString(AppConstants.Preferences.LOVE_UIN_FOR_CURRENT_USER, ""), String.valueOf(l3)))) {
                    z16 = f17;
                }
                map.remove("uin");
            } else {
                map = new HashMap();
            }
            Uri parse = Uri.parse(str);
            if (parse == null) {
                str3 = "";
                str4 = str3;
            } else {
                str4 = parse.getQueryParameter("refer");
                str3 = parse.getQueryParameter("openid");
            }
            int i3 = 2009;
            if (!TextUtils.isEmpty(str4)) {
                if ("qzone_feeds_lover_tail".equals(str4)) {
                    if (z16) {
                        str5 = "9";
                    } else {
                        str5 = "5";
                    }
                } else if ("qzone_home_page".equals(str4)) {
                    if (z16) {
                        str5 = "8";
                    } else {
                        str5 = "3";
                    }
                } else if ("qzone_passive_feeds".equals(str4)) {
                    str5 = "7";
                } else if ("qzone_widget".equals(str4)) {
                    str5 = "4";
                    i3 = 2088;
                }
                if ("0".equals(str5)) {
                    QZLog.w(QZLog.TO_DEVICE_TAG, "jump to lover zone with unknown refer, url:" + str + " context:" + context.getClass().getName());
                }
                f16 = z5.a.f();
                if (f16 != null) {
                    if (z16) {
                        g16 = f16.g(l3.longValue());
                    } else {
                        g16 = f16.g(LoginData.getInstance().getUin());
                    }
                    if (g16 != null) {
                        str7 = g16.jumpUrlParamsForLoveZone;
                        if (!g16.isLoverZoneUser) {
                            str6 = "2";
                        } else {
                            str6 = "1";
                        }
                        if (z16) {
                            String config2 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_SWEET_MINI_APP, QzoneConfig.SECONDARY_KEY_SWEET_GUEST_PAGE, QzoneConfig.DEFAULT_SWEET_MAIN_PAGE_JUMP_URL_FOR_GUEST);
                            if (!TextUtils.isEmpty(str7)) {
                                config = config2 + ContainerUtils.FIELD_DELIMITER + str7;
                            } else if (!TextUtils.isEmpty(str3)) {
                                config = config2 + "&openid=" + str3;
                            } else {
                                config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_SWEET_MINI_APP, QzoneConfig.SECONDARY_KEY_SWEET_MAIN_PAGE_JUMP_URL_FOR_GUEST, QzoneConfig.DEFAULT_SWEET_MAIN_PAGE_JUMP_H5_URL) + "&uin=" + l3;
                            }
                        } else {
                            config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_SWEET_MINI_APP, QzoneConfig.SECONDARY_KEY_SWEET_MAIN_PAGE_JUMP_URL, QzoneConfig.DEFAULT_SWEET_MAIN_PAGE_JUMP_URL);
                        }
                        map.put("scene", i3 + "");
                        com.tencent.mobileqq.loverzone.a.a(str5, "2", "2", str6);
                        str8 = config;
                    }
                }
                str6 = "";
                str7 = str6;
                if (z16) {
                }
                map.put("scene", i3 + "");
                com.tencent.mobileqq.loverzone.a.a(str5, "2", "2", str6);
                str8 = config;
            }
            str5 = "0";
            if ("0".equals(str5)) {
            }
            f16 = z5.a.f();
            if (f16 != null) {
            }
            str6 = "";
            str7 = str6;
            if (z16) {
            }
            map.put("scene", i3 + "");
            com.tencent.mobileqq.loverzone.a.a(str5, "2", "2", str6);
            str8 = config;
        }
        g gVar = new g(str8, str2);
        gVar.f450714g = map;
        return b(context, gVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(String str, Context context, String str2, Map map) {
        BusinessFeedData businessFeedData;
        Serializable serializable;
        int i3;
        boolean z16;
        boolean z17;
        int i16;
        if (TextUtils.isEmpty(str)) {
            ToastUtil.n(R.string.a95);
            QZLog.w(QZLog.TO_DEVICE_TAG, "browse url fail:" + j(str));
            return;
        }
        if (map != null) {
            Object obj = map.get("businessFeedData");
            Object obj2 = map.get("isNativeLikeWebview");
            Object obj3 = map.get("needGdtLandingPageReport");
            businessFeedData = obj instanceof BusinessFeedData ? (BusinessFeedData) obj : null;
            z16 = obj2 instanceof Boolean ? ((Boolean) obj2).booleanValue() : false;
            z17 = obj3 instanceof Boolean ? ((Boolean) obj3).booleanValue() : false;
            if (map.get(QQBrowserActivity.TAB_CONFIG_DATA) != null) {
                serializable = (ArrayList) map.get(QQBrowserActivity.TAB_CONFIG_DATA);
                i3 = ((Integer) map.get(QQBrowserActivity.TOPTAB_SELECT_INDEX)).intValue();
            } else {
                serializable = null;
                i3 = 0;
            }
        } else {
            businessFeedData = null;
            serializable = null;
            i3 = 0;
            z16 = false;
            z17 = false;
        }
        String t16 = f.t(f.w(f.u(str), LoginData.getInstance().getUin()));
        String u16 = f.u(str2);
        byte[] bytes = TextUtils.isEmpty(u16) ? null : u16.getBytes();
        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserDelegationActivity.class);
        if (businessFeedData != null && businessFeedData.isGDTAdvFeed()) {
            intent.setClass(BaseApplication.getContext(), QQBrowserActivity.class);
        }
        BusinessFeedData businessFeedData2 = businessFeedData;
        intent.putExtra("startOpenPageTime", System.currentTimeMillis());
        if (z16) {
            intent.putExtra("browserType", 1);
            i16 = 16777249;
        } else {
            i16 = 1;
        }
        String c16 = f.c(t16, i16, false);
        if (serializable != null) {
            intent.putExtra(QQBrowserActivity.TAB_CONFIG_DATA, serializable);
            intent.putExtra(QQBrowserActivity.TOPTAB_SWITCH_FRAGMENT, true);
            intent.putExtra(QQBrowserActivity.TOPTAB_SELECT_INDEX, i3);
            intent.putExtra("titleBarStyle", 2);
        } else {
            intent.putExtra("url", c16);
        }
        intent.putExtra("post_data", bytes);
        intent.putExtra("fromQZone", true);
        intent.putExtra("injectrecommend", true);
        intent.putExtra("needGdtLandingPageReport", z17);
        if (businessFeedData2 != null && businessFeedData2.getOperationInfo() != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(businessFeedData2.getOperationInfo().cookie);
            intent.putExtra("FeedDataCookie", arrayList);
        }
        QZoneHelper.openWebSecurityVerify(intent);
        if (c16.contains("from_kandian=1")) {
            intent.putExtra("articalChannelId", 6);
        } else {
            intent.putExtra("articalChannelId", 5);
        }
        ArrayList arrayList2 = new ArrayList();
        if (ag.f314191a.containsKey("Qzone")) {
            arrayList2.add("Qzone");
        }
        if (z17 && ag.f314191a.containsKey("gdtReportPlugin")) {
            arrayList2.add("gdtReportPlugin");
        }
        if (businessFeedData2 != null) {
            long nocoId = businessFeedData2.getNocoId();
            if (nocoId != -1) {
                intent.putExtra("GdtNocoId", nocoId);
            }
        }
        arrayList2.add(((IGdtAPI) QRoute.api(IGdtAPI.class)).getGdtWebReportPluginName());
        intent.putExtra("insertPluginsArray", (String[]) arrayList2.toArray(new String[arrayList2.size()]));
        intent.putExtra("source_name", BaseApplication.getContext().getString(R.string.ghh));
        intent.setData(Uri.parse(c16));
        boolean z18 = context instanceof Activity;
        if (!z18) {
            intent.addFlags(268435456);
        }
        if (businessFeedData2 != null && businessFeedData2.isGDTAdvFeed()) {
            intent.putExtra("big_brother_source_key", AdDownloadConstants.DOWNLOAD_SOURCE_AD);
            if (z18) {
                Activity activity = (Activity) context;
                if (!TextUtils.isEmpty(activity.getIntent().getStringExtra(LaunchParam.KEY_REF_ID))) {
                    intent.putExtra(LaunchParam.KEY_REF_ID, activity.getIntent().getStringExtra(LaunchParam.KEY_REF_ID));
                }
            }
            intent.putExtra(LaunchParam.KEY_REF_ID, "biz_src_jc_qzone");
        } else {
            b.a(intent);
        }
        String queryParameter = Uri.parse(c16).getQueryParameter("hssourceid");
        if (!TextUtils.isEmpty(queryParameter)) {
            intent.putExtra("big_brother_source_key", queryParameter);
        }
        context.startActivity(intent);
        AccManager.jumpQZoneWap(c16);
        QZLog.w(QZLog.TO_DEVICE_TAG, "jump to browser: " + j(c16));
    }

    public static void m(Activity activity, String str, int i3, String str2, Map map) {
        k(activity, str, i3, null, str2, map);
    }

    public static void p(Context context, String str, int i3, Bundle bundle, String str2, Map map) {
        q(context, str, i3, bundle, str2, map, true);
    }

    public static void n(Activity activity, String str, boolean z16, int i3, int i16, int i17) {
        o(activity, str, z16, i3, i16, i17, true, false);
    }
}
