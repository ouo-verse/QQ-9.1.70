package zw0;

import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ad.tangram.statistics.metric.AdMetricID;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.icgame.game.liveroom.impl.room.share.timishare.c;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.util.QQCustomArkDialogUtil;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {
    public static String a(String str, c cVar) {
        return b(b(b(b(b(b(b(str, "room_type", cVar.f115625h), "game_id", cVar.f115627j), "game_tag_id", cVar.f115628k), "video_source", cVar.f115626i), "pip", "true"), "showmore", "1"), "share_token", cVar.f115632o);
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

    public static Intent c(c cVar) {
        String a16;
        if (cVar == null) {
            return null;
        }
        Intent intent = new Intent();
        try {
            a16 = cVar.a();
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (TextUtils.isEmpty(a16)) {
            rt0.a.c("ICGameShare|ILiveShareHelper", "getShareArkIntent", "arkJson is empty:" + a16);
            return null;
        }
        JSONObject jSONObject = new JSONObject(a16);
        String optString = jSONObject.optString("app");
        String optString2 = jSONObject.optString("view");
        String optString3 = jSONObject.optString(PublicAccountMessageUtilImpl.META_NAME);
        String optString4 = jSONObject.optString("prompt");
        String optString5 = jSONObject.optString("ver");
        String optString6 = jSONObject.optString("desc");
        JSONObject optJSONObject = jSONObject.optJSONObject(DownloadInfo.spKey_Config);
        intent.putExtra("forward_type", 57);
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

    /* JADX WARN: Removed duplicated region for block: B:19:0x009b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d(c cVar, int i3) {
        String str;
        int i16;
        boolean z16;
        if (cVar == null) {
            return "";
        }
        if (i3 != 0) {
            str = "qqhy";
            z16 = true;
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            i16 = 99;
                        } else {
                            str = "fzlj";
                            i16 = gdt_analysis_event.EVENT_MOTIVE_HIPPY_PREDOWNLOAD_TEMPLATE_ITEM_FAILED;
                        }
                    } else {
                        str = "wxhy";
                        i16 = gdt_analysis_event.EVENT_MOTIVE_HIPPY_PREDOWNLOAD_TEMPLATE_ITEM_START;
                    }
                } else {
                    str = "wxpyq";
                    i16 = gdt_analysis_event.EVENT_MOTIVE_HIPPY_PREDOWNLOAD_TEMPLATE_ITEM_SUCCESS;
                }
                String a16 = a(b(b(b(b(b(b("https://now.qq.com/cos/activity/cloud-games/transfer.html?roomid={roomid}".replace("{roomid}", String.valueOf(cVar.f115618a)), "source", str), "from", String.valueOf(i16)), "video_source", String.valueOf(0)), "streamtype", "" + cVar.f115631n), "_wv", "16777218"), "_wwv", "8192"), cVar);
                if (z16) {
                    a16 = b(b(b("https://now.qq.com/cos/h5/jump-qq/index.html?direct=1", "_wv", "16777218"), "_wwv", "8192"), "to", g(a16));
                }
                rt0.a.f("ICGameShare|ILiveShareHelper", "getShareDetailUrl", "shareUrl:" + a16);
                return a16;
            }
            i16 = AdMetricID.Click.SUCCESS;
        } else {
            str = "qqkj";
            i16 = 200002;
        }
        z16 = false;
        String a162 = a(b(b(b(b(b(b("https://now.qq.com/cos/activity/cloud-games/transfer.html?roomid={roomid}".replace("{roomid}", String.valueOf(cVar.f115618a)), "source", str), "from", String.valueOf(i16)), "video_source", String.valueOf(0)), "streamtype", "" + cVar.f115631n), "_wv", "16777218"), "_wwv", "8192"), cVar);
        if (z16) {
        }
        rt0.a.f("ICGameShare|ILiveShareHelper", "getShareDetailUrl", "shareUrl:" + a162);
        return a162;
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return "\u76f4\u64ad x \u4e92\u52a8\u4e91\u73a9\u6cd5\uff0c\u6765\u548c\u5c0f\u4f19\u4f34\u4e00\u8d77\u73a9\u5427\uff5e";
        }
        return str + "\uff0c\u6765\u548c\u5c0f\u4f19\u4f34\u4e00\u8d77\u73a9\u5427\uff5e";
    }

    public static String f(String str) {
        return "\u76f4\u64ad x \u4e92\u52a8\u4e91\u73a9\u6cd5\uff0c\u6765\u548c\u5c0f\u4f19\u4f34\u4e00\u8d77\u73a9\u5427\uff5e";
    }

    public static String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            rt0.a.c("ICGameShare|ILiveShareHelper", "toUrlEncoder", "url encode fail! url:" + str);
            return "";
        }
    }
}
