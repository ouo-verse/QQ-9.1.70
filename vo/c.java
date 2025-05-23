package vo;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.qzone.app.QZoneFeedAlertService;
import com.qzone.common.account.LoginData;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.util.ToastUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vip.api.IVipTraceDetailReport;
import com.tencent.mobileqq.vip.api.e;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import common.config.service.QZoneConfigHelper;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.MapUtil;
import java.util.Map;
import yo.f;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c {
    public static void A(Context context, long j3, String str) {
        yo.d.d(f.j(f.i(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_GIFT_BACK, "https://h5.qzone.qq.com/gift/rebate?_wv=2098179&theuin={to_uin}&_proxy=1"), "{to_uin}", j3), "{answerid}", str), context, null);
        ClickReport.e(333, "getMainPage", 312, 9);
    }

    public static void B(Activity activity, long j3, String str, int i3, String str2, int i16) {
        String i17 = f.i(f.i(f.j(f.j(f.i(f.j(f.j(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_JUMP_TO_PREVIEW_ALBUM_FACADE_CATE, "https://h5.qzone.qq.com/albumskin/preview/{uin}/{albumid}/{itemid}/albumskin_preview?_wv=536871939&entry={entry}&qua={qua}&width={width}&height={height}"), "{uin}", String.valueOf(j3)), "{albumid}", str), "{itemid}", i3), "{entry}", str2), "{qua}", QUA.getQUA3()), "{width}", (int) (u5.a.d() / u5.a.a())), "{height}", (int) (u5.a.c() / u5.a.a()));
        yo.d.k(activity, i17, i16, null, null, null);
        if (QZLog.isColorLevel()) {
            QZLog.d("QZoneJumpUrlManager", 2, "jumpToAlbumFacadeCate, url:" + i17);
        }
    }

    public static void C(Activity activity, long j3, String str, String str2, int i3) {
        String j16 = f.j(f.j(f.j(f.j(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_JUMP_TO_PREVIEW_ALBUM_FACADE_CATE, "https://h5.qzone.qq.com/photoStore/index?_wv=2098179&qua={qua}&entry={entry}&uin={uin}&albumid={albumid}"), "{uin}", String.valueOf(j3)), "{albumid}", str), "{entry}", str2), "{qua}", QUA.getQUA3());
        yo.d.k(activity, j16, i3, null, null, null);
        if (QZLog.isColorLevel()) {
            QZLog.d("QZoneJumpUrlManager", 2, "jumpToAlbumFacadeCateHomePage, url:" + j16);
        }
    }

    public static void D(Context context, String str) {
        yo.d.d(f.j(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_PHOTO_SET_COVER, "https://h5.qzone.qq.com/bgstore/index?_wv=18875395&qua={qua}&router=userDefined&id=userDefined&qzUseTransparentNavBar=1&flag=common&showHd=false&img="), "{qua}", QUA.getQUA3()) + str, context, null);
        if (QZLog.isColorLevel()) {
            QZLog.d("QZoneJumpUrlManager", 2, "jumpToCoverSet:" + str);
        }
    }

    public static void E(Context context, long j3, String str) {
        yo.d.d(f.j(f.j(QZoneConfigHelper.B0(), "{uin}", String.valueOf(j3)), "{type}", str), context, null);
    }

    public static void F(Context context) {
        yo.d.d(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_MEMORY_SEAL, "https://h5.qzone.qq.com/mood/keepmemos?_wv=3&uin={uin}"), context, null);
    }

    public static void G(Context context) {
        yo.d.d(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qzone_master_more_feed_back", "https://ti.qq.com/tucao/index.html?productId=615148"), context, null);
    }

    public static void H(Context context) {
        LoginData.getInstance().getUin();
        yo.d.d(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_VISITOR_NOTIFY_SETTING, "https://qzs.qzone.qq.com/qzone/hybrid/module/friendsVisitNote/index.html?_wv=2097155&_bid=2047&uin={uin}"), context, null);
    }

    public static void I(Context context, String str) {
        String replace = str.replace("{UIN}", LoginData.getInstance().getUinString());
        yo.d.d(replace, context, null);
        if (QZLog.isColorLevel()) {
            QZLog.d("QZoneJumpUrlManager", 2, "jumpToGiftStore:" + replace);
        }
    }

    public static void J(Context context) {
        yo.d.d(f.j(f.i(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_HIDE_HIS_RECORD, "https://qzs.qzone.qq.com/qzone/photo/v7/page/hideToMe.html?_wv=3&hostUin={hostUin}&from={from}#init=photo.v7/module/mobile/hideToMe/index"), "{hostUin}", LoginData.getInstance().getUin()), "{from}", "androidQQ"), context, null);
    }

    public static void K(Context context) {
        yo.d.d(f.j(f.i(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_HIDE_VISIT_MY, "https://qzs.qzone.qq.com/qzone/photo/v7/page/hideMe.html?_wv=3&hostUin={hostUin}&from={from}#init=photo.v7/module/mobile/hideMe/index"), "{hostUin}", LoginData.getInstance().getUin()), "{from}", "androidQQ"), context, null);
    }

    public static void M(Context context, IVipTraceDetailReport.FROM from) {
        String str;
        String f06 = QZoneConfigHelper.f0();
        Map<Integer, Long> cTime = ((IQzoneWebViewPluginHelper) QRoute.api(IQzoneWebViewPluginHelper.class)).getCTime(Long.valueOf(LoginData.getInstance().getUin()));
        if (cTime != null) {
            str = MapUtil.covetMapToH5Param(cTime);
        } else {
            str = "";
        }
        if (QZLog.isColorLevel()) {
            QZLog.d("QZoneJumpUrlManager", 2, "jumpToPersonalSetting reddot param: " + str);
        }
        String q16 = f.q(f.j(f06, "{reddot}", str), "{idlist}");
        if (QZLog.isColorLevel()) {
            QZLog.d("QZoneJumpUrlManager", 2, "jumpToPersonalSetting jumpUrl: " + q16 + " before handleScheme");
        }
        if (from != null) {
            q16 = e.a().buildTraceDetailUrl(q16, from);
        }
        yo.d.d(q16, context, null);
    }

    public static void O(Context context, long j3) {
        P(context, QZoneConfigHelper.g0(), j3);
    }

    public static void P(Context context, String str, long j3) {
        if (TextUtils.isEmpty(str)) {
            str = QZoneConfigHelper.g0();
        }
        String j16 = f.j(f.j(str, "{qua}", QUA.getQUA3()), "{feeduin}", String.valueOf(j3));
        if (QZLog.isColorLevel()) {
            QZLog.d("QZoneJumpUrlManager", 2, "jumpToPersonalizeVipHomePage jumpUrl: " + j16 + " before handleScheme");
        }
        yo.d.d(j16, context, null);
    }

    public static void Q(Context context, String str) {
        String j3 = f.j(f.j(QZoneConfigHelper.e0(), "{qua}", QUA.getQUA3()), "{id}", str);
        if (QZLog.isColorLevel()) {
            QZLog.d("QZoneJumpUrlManager", 2, "jumpToPersonalizeVipHomePage jumpUrl: " + j3 + " before handleScheme");
        }
        yo.d.d(j3, context, null);
    }

    public static void R(Context context, String str) {
        String j3 = f.j(f.j(f.j(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_VIP_PK, "https://h5.qzone.qq.com/vip/pk?pkUin={pkUin}&_wv=2098179&from={from}&qua={qua}"), "{pkUin}", str), "{from}", "ANDinqq"), "{qua}", QUA.getQUA3());
        yo.d.d(j3, context, null);
        if (QZLog.isColorLevel()) {
            QZLog.d("QZoneJumpUrlManager", 2, "jumpToVipPK:" + j3);
        }
    }

    public static void U(Context context) {
        yo.d.d(f.i(f.j(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_VISITOR_SETTING, "https://qzs.qzone.qq.com/qzone/photo/v7/page/visitorSetting.html?&hostUin={hostUin}&from={from}#init=photo.v7/module/mobile/visitorSetting/index"), "{from}", "androidQQ"), "{hostUin}", LoginData.getInstance().getUin()), context, null);
    }

    public static void V(Context context) {
        if (!NetworkState.isNetSupport()) {
            ToastUtil.r(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "NetWorkDisable", "\u5f53\u524d\u7f51\u7edc\u4e0d\u53ef\u7528\uff0c\u8bf7\u7a0d\u5019\u518d\u8bd5"));
        } else {
            yo.d.d(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_FONT_STORE_URL, "https://h5.qzone.qq.com/fontStore/index?_wv=2098179"), context, null);
        }
    }

    public static void W(Context context) {
        String j3 = f.j(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_SIGN_IN, "https://h5.qzone.qq.com/checkin/index?_proxy=1&_wv=2098179&is_winphone=2&qua={qua}&manu={manu}"), "{qua}", QUA.getQUA3());
        String str = Build.MANUFACTURER;
        String j16 = f.j(j3, "{manu}", str);
        if (!j16.contains("manu")) {
            j16 = j16 + "&manu=" + str;
        }
        yo.d.d(j16, context, null);
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (QZLog.isColorLevel()) {
            QZLog.d("QZoneJumpUrlManager", 2, "Jump2HotGame URL:" + str);
        }
        yo.d.d(str, context, null);
    }

    public static void b(Context context, String str, String str2, long j3) {
        String i3 = f.i(f.i(f.j(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_QZONE_JUMPAVATALISTPAGE, "https://h5.qzone.qq.com/avatarDress/index?_wv=2098179&from={from}&qua={qua}&router=list&cate_id={cateid}&uin={uin}&hostUin={hostUin}").replace("{qua}", QUA.getQUA3()).replace("{idlist}", "").replace("{refer}", "qzone").replace("{cateid}", str), "{from}", str2), "{uin}", LoginData.getInstance().getUin()), "{hostUin}", j3);
        if (QZLog.isColorLevel()) {
            QZLog.d("QZoneJumpUrlManager", 2, "JumpAvatarListPage:" + i3);
        }
        yo.d.d(i3, context, null);
    }

    public static void c(Context context, String str, long j3) {
        String i3 = f.i(f.i(f.j(f.j(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_AVATAR_SETTING, "https://h5.qzone.qq.com/avatarDress/index?_wv=2098179&from={from}&qua={qua}&router=home&uin={uin}&hostUin={hostUin}"), "{from}", str), "{qua}", QUA.getQUA3()), "{uin}", LoginData.getInstance().getUin()), "{hostUin}", j3);
        yo.d.d(i3, context, null);
        if (QZLog.isColorLevel()) {
            QZLog.d("QZoneJumpUrlManager", 2, "JumpAvatarPage:" + i3);
        }
    }

    public static void d(Context context, String str, String str2, long j3) {
        String i3 = f.i(f.i(f.j(f.j(f.j(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_AVATAR_PREVIEW, "https://h5.qzone.qq.com/avatarDress/index?_wv=2098179&qua={qua}&router=detail&from={from}&avatar_id={avatar_id}&uin={uin}&hostUin={hostUin}"), "{from}", str2), "{avatar_id}", str), "{qua}", QUA.getQUA3()), "{uin}", LoginData.getInstance().getUin()), "{hostUin}", j3);
        yo.d.d(i3, context, null);
        if (QZLog.isColorLevel()) {
            QZLog.d("QZoneJumpUrlManager", 2, "JumpAvatarUsedPage:" + i3);
        }
    }

    public static void e(Context context, String str, String str2, String str3, long j3) {
        String i3 = f.i(f.i(f.j(f.j(f.j(str, "{from}", str3), "{avatar_id}", str2), "{qua}", QUA.getQUA3()), "{uin}", LoginData.getInstance().getUin()), "{hostUin}", j3);
        yo.d.d(i3, context, null);
        if (QZLog.isColorLevel()) {
            QZLog.d("QZoneJumpUrlManager", 2, "JumpAvatarUsedPage:" + i3);
        }
    }

    public static void f(Context context, String str, String str2, long j3) {
        String i3 = f.i(f.i(f.j(f.j(f.j(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_CARD_PREVIEW, "https://h5.qzone.qq.com/feeddress/index?_wv=2098179&qua={qua}&page=preview&direct=1&id={id}&refer={refer}&uin={uin}&_proxy=1"), "{qua}", QUA.getQUA3()), "{id}", str), "{refer}", str2), "{uin}", LoginData.getInstance().getUin()), "{hostUin}", j3);
        yo.d.d(i3, context, null);
        if (QZLog.isColorLevel()) {
            QZLog.d("QZoneCardLogicQZoneJumpUrlManager", 2, "JumpCardPreviewPage:" + i3);
        }
    }

    public static void g(Context context, String str, long j3) {
        String i3 = f.i(f.i(f.j(f.j(f.j(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_CARD_STORE, "https://h5.qzone.qq.com/feeddress/index?_wv=2098179&qua={qua}&page=mall&uin={uin}&_proxy=1"), "{refer}", "qzone"), "{qua}", QUA.getQUA3()), "{from}", str), "{uin}", LoginData.getInstance().getUin()), "{hostUin}", j3);
        yo.d.d(i3, context, null);
        if (QZLog.isColorLevel()) {
            QZLog.d("QZoneCardLogicQZoneJumpUrlManager", 2, "JumpCardStorePage:" + i3);
        }
    }

    public static void h(Context context) {
        String config = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_NAME_PLAYER_STORE, QzoneConfig.SECONDARY_NAME_PLAYER_STORE_DEFAULT);
        if (TextUtils.isEmpty(config)) {
            return;
        }
        yo.d.d(config.replace("{qua}", QUA.getQUA3()), context, "");
    }

    public static void i(Context context) {
        String config = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_EXCLUDE_PERMISION_PAGE, "https://h5.qzone.qq.com/blacklist/index?_bid=2068&uin={uin}&_wv=2097155");
        if (QZLog.isColorLevel()) {
            QZLog.d("QZoneJumpUrlManager", 2, "JumpSepecialFriendManagerPage URL:" + config);
        }
        yo.d.d(config, context, null);
    }

    public static void j(Context context) {
        yo.d.d(QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_FLOWER_VINE_URL, "https://h5.qzone.qq.com/flower/index?from=client&platform=qq&sid={SID}"), context, null);
    }

    public static void k(Context context, String str, long j3) {
        yo.d.d(f.w(str, j3), context, null);
    }

    public static void l(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            str = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_GAMEBAR, QzoneConfig.DefaultValue.QZONE_GAMEBAR_URL);
        }
        if (QZLog.isColorLevel()) {
            QZLog.d("QZoneJumpUrlManager", 2, "Jump2GameBar URL:" + str);
        }
        yo.d.d(str, context, null);
    }

    public static void m(Context context) {
        yo.d.d(f.j(f.j(f.j(f.j(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_VIP_PROFILE, "https://h5.qzone.qq.com/vip/home?_wv=16778243&qzUseTransparentNavBar=1&_wwv=1&_ws=32&source={aid}&qua={qua}&trace_detail=%7B%22appid%22:%22MoreAN%22%7D"), "{from}", "ANDinqq"), "{qua}", QUA.getQUA3()), "{aid}", "jh"), "{source}", "xinxi"), context, null);
    }

    public static void n(Context context) {
        String j3 = f.j(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_NAMEPLATE_URL, "https://h5.qzone.qq.com/vip/nameplate?_wv=3&_bid=2182&qua={qua}"), "{qua}", QUA.getQUA3());
        yo.d.d(j3, context, null);
        if (QZLog.isColorLevel()) {
            QZLog.d("QZoneJumpUrlManager", 2, "jumpToNameplate:" + j3);
        }
    }

    public static void o(Context context, String str) {
        String j3 = f.j(str, "{qua}", QUA.getQUA3());
        yo.d.d(j3, context, null);
        if (QZLog.isColorLevel()) {
            QZLog.d("QZoneJumpUrlManager", 2, "jumpToNameplate:" + j3);
        }
    }

    public static void p(Context context, String str, String str2, long j3) {
        String i3 = f.i(f.i(f.j(f.j(f.j(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_NEW_CARD_PREVIEW, "https://h5.qzone.qq.com/show/cardStore/preview/{itemid}?itemId={itemid}&_wv=2098179"), "{qua}", QUA.getQUA3()), "{itemid}", str), "{refer}", str2), "{uin}", LoginData.getInstance().getUin()), "{hostUin}", j3);
        yo.d.d(i3, context, null);
        if (QZLog.isColorLevel()) {
            QZLog.d("QZoneCardLogicQZoneJumpUrlManager", 2, "JumpCardPreviewPage:" + i3);
        }
    }

    public static void q(Context context, String str, long j3) {
        String i3 = f.i(f.i(f.j(f.j(f.j(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_NEW_CARD_STORE, "https://h5.qzone.qq.com/show/cardStore/mall"), "{refer}", "qzone"), "{qua}", QUA.getQUA3()), "{from}", str), "{uin}", LoginData.getInstance().getUin()), "{hostUin}", j3);
        yo.d.d(i3, context, null);
        if (QZLog.isColorLevel()) {
            QZLog.d("QZoneCardLogicQZoneJumpUrlManager", 2, "JumpCardStorePage:" + i3);
        }
    }

    public static void r(Context context, int i3) {
        String config = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_NAME_PLAYER_PREVIEW, QzoneConfig.SECONDARY_NAME_PLAYER_PREVIEW_DEFAULT);
        if (TextUtils.isEmpty(config)) {
            return;
        }
        yo.d.d(config.replace("{qua}", QUA.getQUA3()).replace("{itemid}", i3 + ""), context, "");
    }

    public static void s(Context context) {
        yo.d.d(f.j(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_PERMISSION_PAGE, "https://h5.qzone.qq.com/visitpower/setting?uin={UIN}&qua={QUA}&_wv=3"), "{qua}", QUA.getQUA3()), context, null);
    }

    public static void t(Context context) {
        String config = QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_SPECIAL_CARD_FRIEND_MANAGER_PAGE, "https://qzs.qzone.qq.com/qzone/hybrid/module/specialCare/index.html?_wv=2097155&_bid=2046&uin={uin}&_proxy=1");
        if (QZLog.isColorLevel()) {
            QZLog.d("QZoneJumpUrlManager", 2, "JumpSepecialFriendManagerPage URL:" + config);
        }
        yo.d.d(config, context, null);
    }

    public static void u(Context context, long j3, String str) {
        yo.d.d("https://h5.qzone.qq.com/visitor/redPackets/index?_proxy=1&_wv=16777219&from=" + str + "&uin=" + LoginData.getInstance().getUin(), context, null);
    }

    public static void w(Context context, long j3, int i3, boolean z16, String str) {
        String j16 = f.j(f.j(f.j(f.i(f.i(f.i(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_VISITOR_OTHER, "https://h5.qzone.qq.com/qzone/visitor/{hostUin}?uin={uin}&from={from}&qua={qua}&clicktime={clicktime}&hostuin={hostUin}&_wv=3&_proxy=1&trace_detail=%7B%22appid%22%3A%22{refer}%22%7D&_noMask=1"), "{uin}", LoginData.getInstance().getUin()), "{hostUin}", j3), "{clicktime}", System.currentTimeMillis()), "{from}", "androidQQ"), "{qua}", QUA.getQUA3()), "{refer}", str);
        f.i(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_VISITOR_REDPOCKET, "https://h5.qzone.qq.com/visitor/redPackets/index?_wv=16777219&_wwv=1024&from=visitor&_proxy=1&uin={uin}"), "{uin}", LoginData.getInstance().getUin());
        int i16 = (j3 > LoginData.getInstance().getUin() ? 1 : (j3 == LoginData.getInstance().getUin() ? 0 : -1));
        yo.d.d(j16, context, null);
        if (QZLog.isColorLevel()) {
            QZLog.d("QZoneJumpUrlManager", 2, "JumpToVistorFromUserHome:" + j16);
        }
        QZoneFeedAlertService.getInstance().clearSingleUnreadCount(1027);
    }

    public static void x(Context context, long j3) {
        String j16 = f.j(f.j(f.i(f.i(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_VISITOR_WIDGET, "https://h5.qzone.qq.com/visitor/qzone/personal?uin={uin}&qua={qua}&clicktime={clicktime}&_bid=329&_wv=3&_proxy=true"), "{hostUin}", j3), "{clicktime}", System.currentTimeMillis()), "{from}", "androidQQ"), "{qua}", QUA.getQUA3());
        yo.d.d(j16, context, null);
        if (QZLog.isColorLevel()) {
            QZLog.d("QZoneJumpUrlManager", 2, "JumpToVistorFromVistorWidget:" + j16);
        }
    }

    private static long y() {
        return QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_FEED_OPEN_VISITOR_LIST_TIME_LIMIT_DAYS, QzoneConfig.DEF_FEED_OPEN_VISITOR_LIST_TIME_LIMIT_DAYS);
    }

    public static void L(Context context) {
        N(context, false);
    }

    public static void N(Context context, boolean z16) {
        M(context, null);
    }

    public static void v(Context context, long j3) {
        w(context, j3, 0, false, "");
    }

    public static void S(Context context, BusinessFeedData businessFeedData, boolean z16) {
        String j3;
        if (context == null) {
            return;
        }
        if (ef.b.d(businessFeedData)) {
            QZLog.d("QZoneJumpUrlManager", 2, "group album not jump");
            return;
        }
        if (z(businessFeedData)) {
            ToastUtil.r(QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_FEED_OPEN_VISITOR_LIST_TIME_LIMIT_TIPS, QzoneConfig.DEF_FEED_OPEN_VISITOR_LIST_TIME_LIMIT_TIPS));
            return;
        }
        long j16 = businessFeedData.getUser().uin;
        int i3 = businessFeedData.getFeedCommInfo().feedsType;
        String str = businessFeedData.getFeedCommInfo().ugckey;
        String str2 = businessFeedData.getFeedCommInfo().feedskey;
        String j17 = f.j(f.j(f.j(f.j(f.i(f.i(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_FEED_VISITOR, "https://h5.qzone.qq.com/feed/visitor/{feedsKey}/feedvisitor?_wv=2098179&from={from}&feedsType={feedsType}&hostUin={hostUin}&ugcKey={ugcKey}&isSingleAlbumFeed={isSingleAlbumFeed}&qua={qua}&_bid=2184&_proxy=1"), "{feedsType}", i3), "{hostUin}", j16), "{feedsKey}", z16 ? businessFeedData.getFeedCommInfo().feedskey : str), "{ugcKey}", str), "{from}", "androidQQ"), "{qua}", QUA.getQUA3());
        if (businessFeedData.getFeedCommInfo().appid == 4 && ((businessFeedData.getPictureInfo() != null && businessFeedData.getPictureInfo().pics != null && businessFeedData.getPictureInfo().pics.size() == 1) || (businessFeedData.getOriginalInfoSafe().getPictureInfo() != null && businessFeedData.getOriginalInfoSafe().getPictureInfo().pics != null && businessFeedData.getOriginalInfoSafe().getPictureInfo().pics.size() == 1))) {
            j3 = f.j(j17, "{isSingleAlbumFeed}", "1");
        } else {
            j3 = f.j(j17, "{isSingleAlbumFeed}", "0");
        }
        if (QZLog.isColorLevel()) {
            QZLog.d("QZoneJumpUrlManager", 2, "Feed Visitor URL:" + j3);
        }
        yo.d.d(j3, context, "");
    }

    private static boolean z(BusinessFeedData businessFeedData) {
        CellFeedCommInfo feedCommInfo = businessFeedData == null ? null : businessFeedData.getFeedCommInfo();
        if (feedCommInfo == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - feedCommInfo.getTime();
        return (currentTimeMillis > 0 ? currentTimeMillis / 86400000 : 0L) >= y();
    }

    public static void T(Context context, long j3, String str) {
        w(context, j3, 0, false, str);
    }
}
