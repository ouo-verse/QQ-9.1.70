package xk4;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import com.tencent.mobileqq.qqlive.api.impl.RoomServiceConstants;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.share.timishare.TgLiveShareParam;
import com.tencent.util.QQCustomArkDialogUtil;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    public static String a(String str, TgLiveShareParam tgLiveShareParam) {
        String b16 = b(b(b(b(b(b(b(str, "room_type", tgLiveShareParam.roomType), "game_id", tgLiveShareParam.gameId), "game_tag_id", tgLiveShareParam.gameTagId), "video_source", tgLiveShareParam.videoSource), RoomServiceConstants.PARAMS_QQ_LIVE_PRODUCT_TYPE, tgLiveShareParam.liveProductType), "pip", "true"), "showmore", "1");
        if (!TextUtils.isEmpty(tgLiveShareParam.platform)) {
            b16 = b(b16, "platform", tgLiveShareParam.platform);
        }
        if (!TextUtils.isEmpty(tgLiveShareParam.huYaAnchorId)) {
            b16 = b(b16, "huya_uid", tgLiveShareParam.huYaAnchorId);
        }
        if (!TextUtils.isEmpty(tgLiveShareParam.flvUrl) && "huya".equals(tgLiveShareParam.platform)) {
            return b(b16, "huya_origin_url", PluginBaseInfoHelper.Base64Helper.encodeToString(tgLiveShareParam.flvUrl.getBytes(), 2));
        }
        return b16;
    }

    public static String b(String str, String str2, String str3) {
        if (str == null) {
            return "";
        }
        if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            return str + ContainerUtils.FIELD_DELIMITER + str2 + ContainerUtils.KEY_VALUE_DELIMITER + str3;
        }
        return str + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str2 + ContainerUtils.KEY_VALUE_DELIMITER + str3;
    }

    public static String c(String str) {
        if (str == null) {
            return "";
        }
        if (str.length() <= 30 && str.getBytes().length <= 100) {
            return str;
        }
        if (str.length() > 30) {
            str = str.substring(0, 30);
        }
        if (Math.min(str.getBytes().length, 100) == 100) {
            int length = str.length() / 2;
            StringBuilder sb5 = new StringBuilder(str.substring(0, length));
            while (sb5.toString().getBytes().length < 100) {
                sb5.append(str.charAt(length));
                length++;
            }
            str = sb5.toString();
        }
        return str + MiniBoxNoticeInfo.APPNAME_SUFFIX;
    }

    public static Intent d(TgLiveShareParam tgLiveShareParam) {
        String arkJsonForShare;
        if (tgLiveShareParam == null) {
            return null;
        }
        Intent intent = new Intent();
        try {
            arkJsonForShare = tgLiveShareParam.getArkJsonForShare();
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (TextUtils.isEmpty(arkJsonForShare)) {
            AegisLogger.e("Share|ILiveShareHelper", "getShareArkIntent", "arkJson is empty:" + arkJsonForShare);
            return null;
        }
        JSONObject jSONObject = new JSONObject(arkJsonForShare);
        String optString = jSONObject.optString("app");
        String optString2 = jSONObject.optString("view");
        String optString3 = jSONObject.optString(PublicAccountMessageUtilImpl.META_NAME);
        String optString4 = jSONObject.optString("prompt");
        String optString5 = jSONObject.optString("ver");
        String optString6 = jSONObject.optString("desc");
        JSONObject optJSONObject = jSONObject.optJSONObject(DownloadInfo.spKey_Config);
        intent.putExtra("forward_type", 27);
        intent.putExtra("is_ark_display_share", true);
        intent.putExtra("forward_ark_app_name", optString);
        intent.putExtra("forward_ark_app_view", optString2);
        intent.putExtra("forward_ark_app_ver", optString5);
        intent.putExtra("forward_ark_app_prompt", optString4);
        intent.putExtra("forward_ark_app_meta", optString3);
        intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_DESC, optString6);
        if (optJSONObject != null) {
            intent.putExtra(AppConstants.Key.FORWARD_ARK_APP_CONFIG, optJSONObject.toString());
        }
        intent.putExtra("appName", optString);
        intent.putExtra(QQCustomArkDialogUtil.APP_VIEW, optString2);
        intent.putExtra(QQCustomArkDialogUtil.APP_MIN_VERSION, optString5);
        intent.putExtra(QQCustomArkDialogUtil.META_DATA, optString3);
        return intent;
    }

    public static String e(TgLiveShareParam tgLiveShareParam, int i3) {
        String str;
        int i16;
        String str2 = "";
        if (tgLiveShareParam == null) {
            return "";
        }
        if (i3 != 0) {
            str = "qqhy";
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            i16 = 99;
                        } else {
                            str = "fzlj";
                            i16 = 53;
                        }
                    } else {
                        str = "wxhy";
                        i16 = 35;
                    }
                } else {
                    str = "wxpyq";
                    i16 = 36;
                }
            } else {
                i16 = 11;
            }
        } else {
            str = "qqkj";
            i16 = 26;
        }
        String a16 = a(b(b(RoomServiceConstants.SCHEME_ILIVE_WATCH.replace("{roomid}", String.valueOf(tgLiveShareParam.roomId)), "source", str), "from", String.valueOf(i16)), tgLiveShareParam);
        if (!TextUtils.isEmpty(tgLiveShareParam.flvUrl)) {
            if (!"huya".equals(tgLiveShareParam.platform)) {
                a16 = b(a16, "flv_url", Uri.encode(tgLiveShareParam.flvUrl));
            }
            a16 = b(a16, "is_use_flv", "1");
        }
        if (!TextUtils.isEmpty(tgLiveShareParam.roomCoverUrl)) {
            a16 = b(a16, "cover_url", Uri.encode(tgLiveShareParam.roomCoverUrl));
        }
        try {
            String b16 = b(b(f().replace("{schema}", URLEncoder.encode(a16, "UTF-8")).replace("{roomid}", String.valueOf(tgLiveShareParam.roomId)), "source", str), "from", String.valueOf(i16));
            if ("huya".equals(tgLiveShareParam.platform)) {
                b16 = b(b16, "compare_version", "9.0.50");
            }
            str2 = b16 + "&_proxy=1";
            return a(str2, tgLiveShareParam);
        } catch (UnsupportedEncodingException e16) {
            QLog.e("Share|ILiveShareHelper", 1, "getShareDetailUrl encode throw:", e16);
            return str2;
        }
    }

    private static String f() {
        return "https://qlive.qq.com/cos/live/h5/jump-qq/index.html?roomid={roomid}&_bid=4849&_static=1&to={schema}";
    }

    public static String g(String str) {
        return c("{room_title}\uff0c\u5feb\u6765\u8ddf\u6211\u4e00\u8d77\u56f4\u89c2\u5427!".replace("{room_title}", str));
    }

    public static String h(String str) {
        return c("\u6211\u6b63\u5728\u770b[{nick_name}]\u7684\u76f4\u64ad\uff0c\u5feb\u6765\u4e00\u8d77\u56f4\u89c2\u5427!".replace("{nick_name}", str));
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public static String i(String str, long j3, String str2, String str3, long j16, String str4, String str5, TgLiveShareParam tgLiveShareParam) {
        String str6;
        String replace;
        String str7 = "{\n    \"app\":\"{app_id}\",\n    \"appView\":\"baseView\",\n    \"view\":\"baseView\",\n    \"config\":{\n        \"forward\":1,\n        \"autosize\":0,\n        \"ctime\":{ctime_value_s},\n        \"type\":\"normal\"\n    },\n    \"ver\":\"1.0.0.0\",\n    \"desc\":\"QQ\u76f4\u64ad\",\n    \"prompt\":\"[QQ\u76f4\u64ad] {nick_name}\u7684\u76f4\u64ad\",\n    \"meta\":{\n        \"data\":{\n            \"avatarJumpUrl\":\"{avatar_jump_url}\",\n            \"contentJumpUrl\":\"{h5_jump_url}\",\n            \"iconJumpUrl\":\"{icon_jump_url}\",\n            \"jumpUrl\":{\n                \"8.3.9\":{\n                    \"contentJumpUrl\":\"{content_jump_url}\"\n                },\n                \"pc\":{\n                    \"contentJumpUrl\":\"https://qzs.qzone.qq.com/qzone/hybrid/page/jumpQQ.html?url=https%3A%2F%2Fh5.qzone.qq.comhttps%3A%2F%2Fh5.qzone.qq.com%2Fv2%2Fvip%2Flive%2Froom%3Froomid%3D110008711\"\n                }\n            },\n            \"media\":[\n                {\n                    \"isVideo\":false,\n                    \"height\":2339,\n                    \"width\":1080,\n                    \"url\":\"{cover_url}\"\n                }\n            ],\n            \"title\":\"{title}\",\n            \"nick\":\"{nick_name}\",\n            \"common\":{\n                \"appIcon\":\"https://qzonestyle.gtimg.cn/qzone/qzact/act/external/live/live-icon-new.png\",\n                \"appName\":\"QQ\u76f4\u64ad\",\n                \"meta\":\"\",\n                \"avatar\":\"{avatar_url}\"\n            }\n        }\n    }\n}";
        try {
            String a16 = a(b(b(RoomServiceConstants.SCHEME_ILIVE_WATCH.replace("{roomid}", String.valueOf(j3)), "source", "qqhy"), "from", String.valueOf(11)), tgLiveShareParam);
            if (!TextUtils.isEmpty(tgLiveShareParam.flvUrl)) {
                if (!"huya".equals(tgLiveShareParam.platform)) {
                    a16 = b(a16, "flv_url", Uri.encode(tgLiveShareParam.flvUrl));
                }
                a16 = b(a16, "is_use_flv", "1");
            }
            if (!TextUtils.isEmpty(tgLiveShareParam.roomCoverUrl)) {
                a16 = b(a16, "cover_url", Uri.encode(tgLiveShareParam.roomCoverUrl));
            }
            String a17 = a(b(f().replace("{roomid}", String.valueOf(j3)).replace("{schema}", URLEncoder.encode(a16, "UTF-8")), "from", String.valueOf(11)), tgLiveShareParam);
            if ("huya".equals(tgLiveShareParam.platform)) {
                a17 = b(a17, "compare_version", "9.0.50");
            }
            String str8 = a17 + "&_proxy=1";
            String replace2 = "{\n    \"app\":\"{app_id}\",\n    \"appView\":\"baseView\",\n    \"view\":\"baseView\",\n    \"config\":{\n        \"forward\":1,\n        \"autosize\":0,\n        \"ctime\":{ctime_value_s},\n        \"type\":\"normal\"\n    },\n    \"ver\":\"1.0.0.0\",\n    \"desc\":\"QQ\u76f4\u64ad\",\n    \"prompt\":\"[QQ\u76f4\u64ad] {nick_name}\u7684\u76f4\u64ad\",\n    \"meta\":{\n        \"data\":{\n            \"avatarJumpUrl\":\"{avatar_jump_url}\",\n            \"contentJumpUrl\":\"{h5_jump_url}\",\n            \"iconJumpUrl\":\"{icon_jump_url}\",\n            \"jumpUrl\":{\n                \"8.3.9\":{\n                    \"contentJumpUrl\":\"{content_jump_url}\"\n                },\n                \"pc\":{\n                    \"contentJumpUrl\":\"https://qzs.qzone.qq.com/qzone/hybrid/page/jumpQQ.html?url=https%3A%2F%2Fh5.qzone.qq.comhttps%3A%2F%2Fh5.qzone.qq.com%2Fv2%2Fvip%2Flive%2Froom%3Froomid%3D110008711\"\n                }\n            },\n            \"media\":[\n                {\n                    \"isVideo\":false,\n                    \"height\":2339,\n                    \"width\":1080,\n                    \"url\":\"{cover_url}\"\n                }\n            ],\n            \"title\":\"{title}\",\n            \"nick\":\"{nick_name}\",\n            \"common\":{\n                \"appIcon\":\"https://qzonestyle.gtimg.cn/qzone/qzact/act/external/live/live-icon-new.png\",\n                \"appName\":\"QQ\u76f4\u64ad\",\n                \"meta\":\"\",\n                \"avatar\":\"{avatar_url}\"\n            }\n        }\n    }\n}".replace("{app_id}", str).replace("{ctime_value_s}", String.valueOf(System.currentTimeMillis() / 1000)).replace("{avatar_jump_url}", "mqqapi://qsubscribe/openhomepage?src_type=ilive&uid={uid}".replace("{uid}", String.valueOf(j16)));
            if ("huya".equals(tgLiveShareParam.platform)) {
                replace = replace2.replace("{content_jump_url}", str8);
            } else {
                replace = replace2.replace("{content_jump_url}", a16);
            }
            String replace3 = replace.replace("{icon_jump_url}", "mqqapi://qsubscribe/opendiscoverpage?src_type=ilive").replace("{h5_jump_url}", str8);
            String j17 = j(str3);
            String j18 = j(str5);
            String j19 = j("");
            String replace4 = replace3.replace("{nick_name}", j18).replace("{cover_url}", str2);
            if (!TextUtils.isEmpty(j19)) {
                j17 = j19;
            }
            str7 = replace4.replace("{title}", j17);
            str6 = str7.replace("{avatar_url}", str4);
        } catch (Throwable th5) {
            AegisLogger.e("Share|ILiveShareHelper", "replaceArkData", "error:" + th5);
            str6 = str7;
        }
        if (QLog.isColorLevel()) {
            AegisLogger.i("Share|ILiveShareHelper", "replaceArkData", " share QQ replaceArkData = \n " + str6);
        }
        return str6;
    }

    public static String j(String str) {
        if (str == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder(1024);
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (charAt != '\f') {
                if (charAt != '\r') {
                    if (charAt != '\"' && charAt != '/' && charAt != '\\') {
                        switch (charAt) {
                            case '\b':
                                sb5.append("\\b");
                                break;
                            case '\t':
                                sb5.append("\\t");
                                break;
                            case '\n':
                                sb5.append(RedTouch.NEWLINE_CHAR);
                                break;
                            default:
                                if (charAt <= 31) {
                                    sb5.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                                    break;
                                } else {
                                    sb5.append(charAt);
                                    break;
                                }
                        }
                    } else {
                        sb5.append('\\');
                        sb5.append(charAt);
                    }
                } else {
                    sb5.append("\\r");
                }
            } else {
                sb5.append("\\f");
            }
        }
        return sb5.toString();
    }
}
