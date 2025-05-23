package vo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.ak;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.gdt.QZoneAdFeedDataExtKt;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxMainPageInitBean;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.model.BusinessAlbumInfo;
import cooperation.qzone.util.PerfTracer;
import cooperation.qzone.util.QZLog;
import ho.i;
import java.util.ArrayList;
import org.json.JSONArray;
import tencent.gdt.qq_ad_get;
import yo.f;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b {
    public static void a(Activity activity) {
        yo.d.d(f.t(f.w(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_QZONE_PHONELABELSETTING, "https://h5.qzone.qq.com/show/tail?_wv=2097159&_bid=2178&uin={uin}&qua={qua}"), LoginData.getInstance().getUin())), activity, null);
    }

    public static void b(Context context, String str, Long l3, String str2, int i3, long j3, long j16) {
        BusinessAlbumInfo businessAlbumInfo = new BusinessAlbumInfo(str);
        businessAlbumInfo.mUin = l3.longValue();
        businessAlbumInfo.mAlbumType = i3;
        businessAlbumInfo.mCover = "";
        businessAlbumInfo.mTitle = str2;
        com.qzone.feed.utils.b.d(context, ak.L(context, businessAlbumInfo, 0, j3, j16));
    }

    public static void d(Context context, String str, Long l3, String str2, int i3, boolean z16, int i16, boolean z17, String str3, boolean z18) {
        BusinessAlbumInfo businessAlbumInfo = new BusinessAlbumInfo(str);
        businessAlbumInfo.mUin = l3.longValue();
        businessAlbumInfo.mTitle = str2;
        businessAlbumInfo.mAlbumType = i3;
        businessAlbumInfo.mCover = "";
        businessAlbumInfo.isIndividualityAlbum = z16;
        com.qzone.feed.utils.b.d(context, ak.K(context, businessAlbumInfo, 0, i16, z17, str3, z18));
    }

    public static void e(Activity activity, String str, String str2, String str3, long j3) {
        yo.d.l(activity, QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_QUN_ALBUM_SETTING, QzoneConfig.SECONDARY_QUN_ALBUM_PHOTO_URL, QZoneHelper.Constants.URL_QUN_ALBUM).replace("{QUN_ID}", str).replace("{ALBUM_ID}", str2), 0, null);
    }

    public static void f(Context context, long j3, String str) {
        if (com.qzone.reborn.albumx.qzonex.utils.d.a()) {
            QLog.i("QZoneJumpInternalManager", 1, "jumpToAlbum  context = " + context + " | uin = " + j3 + " | refer = " + str);
            QZAlbumxMainPageInitBean qZAlbumxMainPageInitBean = new QZAlbumxMainPageInitBean(String.valueOf(j3));
            qZAlbumxMainPageInitBean.setFrom(str);
            i.x().i(context, qZAlbumxMainPageInitBean, null);
            return;
        }
        Intent G = ak.G(context, Long.valueOf(j3), 0);
        G.putExtra(PerfTracer.PARAM_CLICK_TIME, System.currentTimeMillis());
        G.putExtra("refer", str);
        com.qzone.feed.utils.b.d(context, G);
    }

    public static void g(Context context, long j3, String str, String str2) {
        yo.d.d(f.i(f.i(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_QZONE_BLOGLIST, "https://h5.qzone.qq.com/blog/list2/{uin}/bloglist?_wv=3&_proxy=1"), "{hostuin}", j3), "{uin}", j3), context, null);
    }

    public static void h(Context context) {
        String w3 = f.w(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_QZONE_SETTING_MAIN_PAGE, QzoneConfig.DefaultValue.DEFAULT_QZONE_SETTING_MAIN_PAGE), LoginData.getInstance().getUin());
        if (QZLog.isColorLevel()) {
            QZLog.d(b.class.getSimpleName(), 2, "JumpQzoneSettingPage URL:" + w3);
        }
        yo.d.d(w3, context, null);
    }

    public static void i(Context context) {
        com.qzone.feed.utils.b.d(context, ak.j(context));
    }

    public static void j(Context context) {
        String w3 = f.w("https://h5.qzone.qq.com/visit/setting/visitSetting?_wv=3&_proxy=1&uin={uin}", LoginData.getInstance().getUin());
        if (QZLog.isColorLevel()) {
            QZLog.d(b.class.getSimpleName(), 2, "JumpQzoneSettingPage URL:" + w3);
        }
        yo.d.d(w3, context, null);
    }

    public static void k(Context context) {
        String j3;
        Intent intent = new Intent(BaseApplication.getContext(), (Class<?>) QQBrowserActivity.class);
        QZoneHelper.openWebSecurityVerify(intent);
        String replace = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_MSG_LIST_URL, QzoneConfig.DefaultValue.MSG_LIST_URL).replace("{uin}", LoginData.getInstance().getUinString());
        if (!replace.contains("manu")) {
            j3 = replace + "&manu=" + Build.MANUFACTURER;
        } else {
            j3 = f.j(replace, "{manu}", Build.MANUFACTURER);
        }
        intent.putExtra("url", j3);
        intent.putExtra("fromQZone", true);
        intent.putExtra("injectrecommend", true);
        intent.setData(Uri.parse(j3));
        intent.addFlags(268435456);
        yo.b.a(intent);
        BaseApplication.getContext().startActivity(intent);
    }

    public static void m(boolean z16, BusinessFeedData businessFeedData) {
        String str;
        if (z16) {
            str = "click ";
        } else {
            str = "exposure ";
        }
        QLog.d("FeedC2S", 4, str);
        if (businessFeedData == null || businessFeedData.getOperationInfoV2() == null) {
            return;
        }
        qq_ad_get.QQAdGetRsp.AdInfo adInfo = new qq_ad_get.QQAdGetRsp.AdInfo();
        try {
            String str2 = businessFeedData.getOperationInfoV2().cookie.get(7);
            if (str2 != null && !str2.isEmpty()) {
                adInfo.report_info.trace_info.aid.set(Long.valueOf(str2).longValue());
            }
            JSONArray jSONArray = new JSONArray(QZoneAdFeedDataExtKt.getC2SApiClickUrl(businessFeedData));
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                String string = jSONArray.getString(i3);
                arrayList.add(string);
                QLog.d("FeedC2S", 4, "api url " + i3 + ":   " + string);
            }
            JSONArray jSONArray2 = new JSONArray(QZoneAdFeedDataExtKt.getC2SApiExposureUrl(businessFeedData));
            ArrayList arrayList2 = new ArrayList();
            for (int i16 = 0; i16 < jSONArray2.length(); i16++) {
                String string2 = jSONArray2.getString(i16);
                arrayList2.add(string2);
                QLog.d("FeedC2S", 4, "exposure url " + i16 + ":   " + string2);
            }
            adInfo.report_info.thirdparty_monitor_urls.api_click_monitor_url.set(arrayList);
            adInfo.report_info.thirdparty_monitor_urls.api_exposure_monitor_url.set(arrayList2);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        com.tencent.gdtad.statistics.a.b(z16 ? 1 : 0, 0, adInfo);
    }

    public static void c(Context context, String str, Long l3, String str2, int i3, boolean z16) {
        d(context, str, l3, str2, i3, z16, 0, false, null, false);
    }

    public static void l(Context context, BusinessFeedData businessFeedData, Rect rect, boolean z16) {
    }
}
