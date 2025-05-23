package pw2;

import android.text.TextUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdConfigDefine$CHID;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadutils.SpaEffectReportActionKey;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, String> f427787a;

    static {
        HashMap hashMap = new HashMap();
        f427787a = hashMap;
        hashMap.put(SpaEffectReportActionKey.ID_START_FROM_APP_CLIENT, "181");
        hashMap.put(SpaEffectReportActionKey.ID_FINISH_FROM_APP_CLIENT, "182");
        hashMap.put(SpaEffectReportActionKey.ID_INSTALL_FROM_APP_CLIENT, "183");
        hashMap.put(SpaEffectReportActionKey.ID_START_FROM_H5, "184");
        hashMap.put(SpaEffectReportActionKey.ID_FINISH_FROM_H5, "185");
        hashMap.put(SpaEffectReportActionKey.ID_INSTALL_FROM_H5, "186");
        hashMap.put(SpaEffectReportActionKey.ID_LAUNCH_FROM_APP, "187");
        hashMap.put(SpaEffectReportActionKey.ID_START_FROM_APP_DIRECT, "188");
        hashMap.put(SpaEffectReportActionKey.ID_FINISH_FROM_APP_DIRECT, QAdConfigDefine$CHID.SUBMARINE);
        hashMap.put(SpaEffectReportActionKey.ID_INSTALL_FROM_APP_DIRECT, "190");
        hashMap.put(SpaEffectReportActionKey.ID_LAUNCH_FROM_CONFIRM_SUCC, "191");
        hashMap.put(SpaEffectReportActionKey.ID_START_FROM_CONFIRM, "192");
        hashMap.put(SpaEffectReportActionKey.ID_FINISH_FROM_CONFIRM, QAdConfigDefine$CHID.QQ);
        hashMap.put(SpaEffectReportActionKey.ID_INSTALL_FROM_CONFIRM, "194");
        hashMap.put(SpaEffectReportActionKey.ID_LAUNCH_FROM_CONFIRM, "195");
        hashMap.put(SpaEffectReportActionKey.ID_DISMISS_FROM_CONFIRM, "196");
        hashMap.put(SpaEffectReportActionKey.ID_LAUNCH_FROM_APP_LANDINGPAGE_XS, "198");
        hashMap.put(SpaEffectReportActionKey.ID_VIDEO_AD_DETAIL_ACTION_BUTTON_CLICK, "231");
        hashMap.put(SpaEffectReportActionKey.ID_GO_DETAIL_FROM_AD_DETAIL, "242");
        hashMap.put(SpaEffectReportActionKey.ID_GO_DETAIL_FROM_AD_REPLAY, "243");
        hashMap.put(SpaEffectReportActionKey.ID_PRE_AD_DOWNLOAD_GUIDE_START_DOWNLOAD, "250");
        hashMap.put(SpaEffectReportActionKey.ID_PRE_AD_DOWNLOAD_GUIDE_COMPLETE_DOWNLOAD, "251");
        hashMap.put(SpaEffectReportActionKey.ID_PRE_AD_DOWNLOAD_GUIDE_COMPLETE_INSTALL, "252");
        hashMap.put(SpaEffectReportActionKey.ID_PRE_AD_DOWNLOAD_GUIDE_OPEN_APP, "253");
        hashMap.put(SpaEffectReportActionKey.ID_LINKAGE_AD_START_DOWNLOAD, "254");
        hashMap.put(SpaEffectReportActionKey.ID_LINKAGE_AD_COMPLETE_DOWNLOAD, "255");
        hashMap.put(SpaEffectReportActionKey.ID_LINKAGE_AD_COMPLETE_INSTALL, "256");
        hashMap.put(SpaEffectReportActionKey.ID_LINKAGE_AD_GUIDE_OPEN_APP, "257");
        hashMap.put(SpaEffectReportActionKey.ID_START_FROM_APP_CLIENT, "181");
        hashMap.put(SpaEffectReportActionKey.ID_START_FROM_H5_AUTO_DOWNLOAD, "287");
        hashMap.put(SpaEffectReportActionKey.ID_FINISH_FROM_H5_AUTO_DOWNLOAD, "288");
        hashMap.put(SpaEffectReportActionKey.ID_INSTALL_FROM_H5_AUTO_DOWNLOAD, "289");
        hashMap.put(SpaEffectReportActionKey.ID_LAUNCH_FROM_APP_DIRECT_TRY_XS, "298");
        hashMap.put(SpaEffectReportActionKey.ID_LAUNCH_FROM_APP_DIRECT_SUCC_XS, "299");
        hashMap.put(SpaEffectReportActionKey.ID_LAUNCH_FROM_APP_DIRECT_FAIL_XS, IndividuationPlugin.Business_Font);
        hashMap.put(SpaEffectReportActionKey.ID_LAUNCH_FROM_APP_TRY_XS, "304");
        hashMap.put(SpaEffectReportActionKey.ID_LAUNCH_FROM_APP_SUCC_XS, "305");
        hashMap.put(SpaEffectReportActionKey.ID_LAUNCH_FROM_APP_FAIL_XS, "306");
        hashMap.put(SpaEffectReportActionKey.ID_APP_SWITCH_FRONT, "325");
        hashMap.put(SpaEffectReportActionKey.ID_TRY_OPEN_HAP_APP_XS, "326");
        hashMap.put(SpaEffectReportActionKey.ID_OPEN_HAP_APP_SUCC_XS, "327");
        hashMap.put(SpaEffectReportActionKey.ID_OPEN_HAP_APP_FAIL_XS, "328");
    }

    public static String a(@SpaEffectReportActionKey String str) {
        if (TextUtils.isEmpty(str)) {
            return "0";
        }
        hv2.c cVar = (hv2.c) dv2.b.d().a(hv2.c.class);
        if (cVar != null) {
            return cVar.i(str);
        }
        return b(str);
    }

    public static String b(@SpaEffectReportActionKey String str) {
        String str2 = f427787a.get(str);
        if (TextUtils.isEmpty(str2)) {
            return "0";
        }
        return str2;
    }
}
