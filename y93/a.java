package y93;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.avbiz.AVBizModuleFactory;
import com.tencent.avbiz.Constants;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IQQWinkEditorResAPI;
import com.tencent.mobileqq.wink.api.IQQWinkLaunchReporter;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.schema.d;
import com.tencent.mobileqq.wink.sdk.Wink;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.util.HashMap;
import java.util.Map;
import r93.h;
import uq3.c;
import uq3.g;

/* compiled from: P */
@Deprecated
/* loaded from: classes21.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f449912a = "sp_qqcirlce_business";

    /* renamed from: b, reason: collision with root package name */
    public static String f449913b = "qcircle_is_authenticated";

    /* renamed from: c, reason: collision with root package name */
    private static String[] f449914c = {QQWinkConstants.HOME_SHOW_CAPTURE_TAB, QQWinkConstants.HOME_SHOW_PICKER_TAB, QQWinkConstants.HOME_SHOW_TEMPLATE_TAB};

    public static boolean a(String str, int i3) {
        if (c.e4()) {
            QLog.e("[QcirclePublish]WinkPublishJumpUtil", 1, "checkBindPhoneNumber needCheck");
            int f16 = f();
            if (f16 != 0 && f16 != 1) {
                QLog.e("[QcirclePublish]WinkPublishJumpUtil", 1, "checkBindPhoneNumber needCheck not pass");
                ((IQQWinkLaunchReporter) QRoute.api(IQQWinkLaunchReporter.class)).reportOnClickBroken(str, i3, "-10004", true);
                return false;
            }
            ((IQQWinkLaunchReporter) QRoute.api(IQQWinkLaunchReporter.class)).reportOnClickBroken(str, i3, "-10004", false);
        }
        return true;
    }

    private static void b(Context context, @NonNull Bundle bundle) {
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.putExtras(bundle);
        h(context, intent);
    }

    private static void c(Context context, Bundle bundle, int i3, String str) {
        if (TextUtils.isEmpty(str)) {
            String g16 = g();
            bundle.putString(PeakConstants.QCIRCLE_CLIENT_TRACEID, g16);
            ((IQQWinkLaunchReporter) QRoute.api(IQQWinkLaunchReporter.class)).reportBeforeStart(context, g16, i3, false, 0);
        } else {
            bundle.putString(PeakConstants.QCIRCLE_CLIENT_TRACEID, str);
            ((IQQWinkLaunchReporter) QRoute.api(IQQWinkLaunchReporter.class)).reportBeforeStart(context, str, i3, false, 0);
        }
    }

    private static void d(Intent intent, HashMap<String, String> hashMap) {
        String str = hashMap.get(QCircleScheme.AttrQQPublish.CHALLENGE_TAG);
        if (!TextUtils.isEmpty(str) && !com.tencent.mobileqq.wink.model.b.f324006a.d()) {
            w53.b.f("[QcirclePublish]WinkPublishJumpUtil", "downgradeChallengeTag: " + str);
            hashMap.remove(QCircleScheme.AttrQQPublish.CHALLENGE_TAG);
            hashMap.remove(QCircleScheme.AttrQQPublish.CHALLENGE_NUMS);
            hashMap.put("tag", str);
            intent.putExtra("key_attrs", hashMap);
        }
    }

    private static void e(@NonNull Map<String, String> map, @NonNull Bundle bundle) {
        QLog.i("[QcirclePublish]WinkPublishJumpUtil", 1, "flatmapSchemaToIntent" + map.keySet());
        for (String str : map.keySet()) {
            if (!"key_scheme".equals(str)) {
                if ("clicktime".equals(str)) {
                    bundle.putString(WinkDaTongReportConstant.ElementParamKey.XSJ_SCHEMA_CLICK_TIME, map.get("clicktime"));
                } else {
                    bundle.putString(str, map.get(str));
                }
            }
        }
    }

    public static int f() {
        SharedPreferences a16 = g.a(f449912a + ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount(), false, false);
        if (a16 == null) {
            return 0;
        }
        return a16.getInt(f449913b + "_" + ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount(), 0);
    }

    private static String g() {
        z93.c f16 = Wink.INSTANCE.f();
        if (f16 != null) {
            return f16.getTraceId();
        }
        return "";
    }

    private static void h(Context context, Intent intent) {
        AVBizModuleFactory.getModuleByName(Constants.Business.QQCIRCLE).abandonAVFocus();
        Bundle bundle = new Bundle();
        if (intent != null) {
            bundle.putAll(intent.getExtras());
        }
        QLog.i("[QcirclePublish]WinkPublishJumpUtil", 1, "jumpSelectPhoto" + intent);
        if (!bundle.containsKey(QQWinkConstants.ENTRY_BUSINESS_NAME)) {
            bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
        }
        if (!bundle.containsKey("app_key")) {
            bundle.putString("app_key", "00000QG6YX3X0LZH");
        }
        if (intent != null) {
            HashMap<String, String> e16 = d.f326305a.e(intent);
            if (l(e16, bundle)) {
                e(e16, bundle);
            } else {
                j(f449914c, bundle, true);
            }
            k(e16, bundle);
            d(intent, e16);
        }
        if (!com.tencent.mobileqq.wink.schema.a.f326297a.c(context, bundle)) {
            ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToQQWinkHome(context, bundle);
        }
    }

    public static void i(Context context, Bundle bundle, int i3, String str) {
        if (!a(str, i3)) {
            return;
        }
        ((IWinkEditorResourceAPI) QRoute.api(IWinkEditorResourceAPI.class)).fetchUserPublishInfo();
        ((IQQWinkEditorResAPI) QRoute.api(IQQWinkEditorResAPI.class)).requestWangZheTabData();
        bundle.putInt(IProfileCardConst.KEY_FROM_TYPE, i3);
        c(context, bundle, i3, str);
        b(context, bundle);
    }

    private static void j(String[] strArr, Bundle bundle, boolean z16) {
        for (String str : strArr) {
            bundle.putBoolean(str, z16);
        }
    }

    private static void k(@NonNull Map<String, String> map, Bundle bundle) {
        String str = map.get(QCircleScheme.AttrQQPublish.INPUT_TABS);
        QLog.d("[QcirclePublish]WinkPublishJumpUtil", 1, "updateBySchema, inputTabs: " + str);
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!str.contains("a")) {
            bundle.putBoolean(QQWinkConstants.HOME_SHOW_PICKER_TAB, false);
        }
        if (!str.contains("c")) {
            bundle.putBoolean(QQWinkConstants.HOME_SHOW_CAPTURE_TAB, false);
        }
        if (!str.contains("t")) {
            bundle.putBoolean(QQWinkConstants.HOME_SHOW_TEMPLATE_TAB, false);
        }
    }

    private static boolean l(Map<String, String> map, Bundle bundle) {
        return h.f430993a.h(bundle);
    }
}
