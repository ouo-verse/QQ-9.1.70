package t6;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.qzone.album.data.model.AlbumCacheData;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellIdInfo;
import com.qzone.proxy.feedcomponent.model.CellOperationInfo;
import com.qzone.proxy.feedcomponent.model.CellPermissionInfo;
import com.qzone.proxy.feedcomponent.model.CellUserInfo;
import com.qzone.proxy.feedcomponent.model.DetailDataOutShare;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.util.d;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;
import s4.c;
import v4.b;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static String f435461a;

    /* renamed from: b, reason: collision with root package name */
    private static String f435462b;

    /* renamed from: c, reason: collision with root package name */
    private static String f435463c;

    /* renamed from: d, reason: collision with root package name */
    private static String f435464d;

    /* renamed from: e, reason: collision with root package name */
    private static String f435465e;

    private static DetailDataOutShare a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        DetailDataOutShare detailDataOutShare = new DetailDataOutShare();
        detailDataOutShare.mapPhotoUrl = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            detailDataOutShare.sTitle = jSONObject.optString("title");
            detailDataOutShare.sSummary = jSONObject.optString("summary");
            detailDataOutShare.ark_content = jSONObject.optString("ark_content");
            detailDataOutShare.ark_id = jSONObject.optString("ark_id");
            detailDataOutShare.view_id = jSONObject.optString("view_id");
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("photourl"));
            Iterator keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String str2 = (String) keys.next();
                detailDataOutShare.mapPhotoUrl.put(Integer.valueOf(Integer.parseInt(str2)), h(new JSONObject(jSONObject2.getString(str2))));
            }
            return detailDataOutShare;
        } catch (JSONException e16) {
            QLog.e("TransformJsonToFeeddataUtil", 1, "parse sharedata jsonString exception" + e16.toString());
            return detailDataOutShare;
        }
    }

    private static CellFeedCommInfo b(String str) {
        CellFeedCommInfo cellFeedCommInfo = new CellFeedCommInfo();
        if (TextUtils.isEmpty(str)) {
            return cellFeedCommInfo;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            cellFeedCommInfo.appid = jSONObject.optInt("appid");
            cellFeedCommInfo.sqDynamicFeedsKey = jSONObject.optString("sqDynamicFeedsKey");
            cellFeedCommInfo.subid = jSONObject.optInt("subid");
            cellFeedCommInfo.refer = jSONObject.optString("refer");
            cellFeedCommInfo.setTime(jSONObject.optInt("time") * 1000);
            cellFeedCommInfo.actiontype = jSONObject.optInt("actiontype");
            cellFeedCommInfo.actionurl = jSONObject.optString(AlbumCacheData.ACTIONURL);
            cellFeedCommInfo.originaltype = jSONObject.optInt("originaltype");
            cellFeedCommInfo.operatemask = jSONObject.optInt(AlbumCacheData.OPERATEMASK);
            cellFeedCommInfo.uflag = jSONObject.optInt("uflag");
            cellFeedCommInfo.recom_show_type = jSONObject.optInt("recom_show_type");
            String optString = jSONObject.optString("feedskey");
            String optString2 = jSONObject.optString(c.UGCKEY);
            cellFeedCommInfo.clientkey = jSONObject.optString(b.CLIENTKEY);
            if (TextUtils.isEmpty(optString)) {
                optString = UUID.randomUUID() + "";
            }
            cellFeedCommInfo.feedskey = optString;
            if (TextUtils.isEmpty(optString2)) {
                optString2 = cellFeedCommInfo.feedskey;
            }
            cellFeedCommInfo.ugckey = optString2;
            cellFeedCommInfo.orglikekey = jSONObject.optString("orglikekey");
            cellFeedCommInfo.curlikekey = jSONObject.optString("curlikekey");
            cellFeedCommInfo.feedsType = jSONObject.optInt("feedsType");
            cellFeedCommInfo.feedsAttr = jSONObject.optInt("feedsAttr");
            cellFeedCommInfo.feedsAttr2 = jSONObject.optInt("feedsAttr2");
            cellFeedCommInfo.ugcRightKey = jSONObject.optString("ugcRightKey");
            cellFeedCommInfo.interestkey = jSONObject.optString("interestkey");
            cellFeedCommInfo.recomtype = jSONObject.optInt("recomtype");
            cellFeedCommInfo.feedsid = jSONObject.optString("feedsid");
            cellFeedCommInfo.advStyle = Long.valueOf(jSONObject.optInt("adv_stytle") * 1).longValue();
            cellFeedCommInfo.adv_subtype = Long.valueOf(jSONObject.optInt("adv_subtype") * 1).longValue();
            cellFeedCommInfo.reportfeedsattr = jSONObject.optInt("reportfeedsattr");
            cellFeedCommInfo.recomlayout = jSONObject.optInt("recomlayout");
            cellFeedCommInfo.ugcRight = 1;
            cellFeedCommInfo.recomreportid = Long.valueOf(jSONObject.optInt("recomreportid") * 1).longValue();
            cellFeedCommInfo.isFollowed = d.j(cellFeedCommInfo.operatemask, 20);
            cellFeedCommInfo.wup_feeds_type = jSONObject.optInt("wup_feeds_type");
            cellFeedCommInfo.operatemask3 = jSONObject.optInt("operatemask3");
            cellFeedCommInfo.operatemask2 = jSONObject.optInt("operatemask2");
            cellFeedCommInfo.positionmask = jSONObject.optInt("positionmask");
            cellFeedCommInfo.positionmask2 = jSONObject.optInt("positionmask2");
            cellFeedCommInfo.feedsDelTime = Long.valueOf(jSONObject.optInt("feedsDelTime") * 1000).longValue();
            cellFeedCommInfo.ugcRight = new JSONObject(jSONObject.optString("right_info")).optInt("right_info");
            cellFeedCommInfo.reportfeedsattr = jSONObject.optInt("reportfeedsattr");
            if (d.j(cellFeedCommInfo.operatemask, 27)) {
                cellFeedCommInfo.isFollowed = false;
            } else if (d.j(cellFeedCommInfo.operatemask, 20)) {
                cellFeedCommInfo.isFollowed = true;
            }
            cellFeedCommInfo.paykey = jSONObject.optString("paykey");
            String optString3 = jSONObject.optString("extendInfo");
            if (!TextUtils.isEmpty(optString3)) {
                HashMap hashMap = new HashMap();
                JSONObject jSONObject2 = new JSONObject(optString3);
                Iterator keys = jSONObject2.keys();
                if (keys != null) {
                    while (keys.hasNext()) {
                        String str2 = (String) keys.next();
                        hashMap.put(str2, jSONObject2.optString(str2));
                    }
                }
                cellFeedCommInfo.extendInfo = hashMap;
            }
        } catch (JSONException e16) {
            QLog.e("TransformJsonToFeeddataUtil", 1, "parse cellcomm jsonString exception" + e16.toString());
        }
        return cellFeedCommInfo;
    }

    private static CellIdInfo c(String str) {
        CellIdInfo cellIdInfo = new CellIdInfo();
        if (TextUtils.isEmpty(str)) {
            return cellIdInfo;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            cellIdInfo.cellId = jSONObject.optString(c.CELLID);
            cellIdInfo.subId = jSONObject.optString("subid");
        } catch (JSONException e16) {
            QLog.e("TransformJsonToFeeddataUtil", 1, "parse cellid jsonString exception" + e16.toString());
        }
        return cellIdInfo;
    }

    private static CellOperationInfo d(String str) {
        CellOperationInfo cellOperationInfo = new CellOperationInfo();
        if (TextUtils.isEmpty(str)) {
            return cellOperationInfo;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            cellOperationInfo.weixinUrl = jSONObject.optString("weixin_url");
            cellOperationInfo.qqUrl = jSONObject.optString("qq_url");
            cellOperationInfo.shareData = a(jSONObject.optString("share_info"));
            String optString = jSONObject.optString("schema_info");
            if (!TextUtils.isEmpty(optString)) {
                JSONObject jSONObject2 = new JSONObject(optString);
                cellOperationInfo.actionType = jSONObject2.optInt("actionType");
                cellOperationInfo.actionUrl = jSONObject2.optString(AlbumCacheData.ACTIONURL);
                cellOperationInfo.downloadUrl = jSONObject2.optString(JefsClass.DOWNLOAD_URL);
                cellOperationInfo.appid = jSONObject2.optString("appid");
                cellOperationInfo.userPost = jSONObject2.optInt("usepost");
                cellOperationInfo.postParams = jSONObject2.optString("postparams");
                cellOperationInfo.schemaPageUrl = jSONObject2.optString("schemaPageUrl");
                cellOperationInfo.yingYongBao = jSONObject2.optBoolean("yingyongbao");
            }
            if (jSONObject.optString("share_info") != null) {
                JSONObject jSONObject3 = new JSONObject(jSONObject.optString("share_info"));
                cellOperationInfo.title = jSONObject3.optString("title");
                cellOperationInfo.summary = jSONObject3.optString("summary");
                DetailDataOutShare detailDataOutShare = cellOperationInfo.shareData;
                if (detailDataOutShare != null) {
                    cellOperationInfo.photoUrl = detailDataOutShare.mapPhotoUrl;
                }
            }
            cellOperationInfo.genericUrl = jSONObject.optString("generic_url");
            cellOperationInfo.qbossTrace = jSONObject.optString("qboss_trace");
            cellOperationInfo.hasReportExposure = 0;
        } catch (JSONException e16) {
            QLog.e("TransformJsonToFeeddataUtil", 1, "parse cellOper jsonString exception" + e16.toString());
        }
        return cellOperationInfo;
    }

    private static CellPermissionInfo e(String str) {
        CellPermissionInfo cellPermissionInfo = new CellPermissionInfo();
        if (TextUtils.isEmpty(str)) {
            return cellPermissionInfo;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            cellPermissionInfo.permission_info = jSONObject.optString(CommonConstant.ReqAccessTokenParam.PERMISSION_INFO_LABEL);
            cellPermissionInfo.permission_mask = jSONObject.optInt("permission_mask");
            cellPermissionInfo.status_info = jSONObject.optString("status_info");
            cellPermissionInfo.permission_visit = jSONObject.optInt("permission_visit");
            cellPermissionInfo.permission_tips = jSONObject.optString("permission_tips");
        } catch (JSONException e16) {
            QLog.e("TransformJsonToFeeddataUtil", 1, "parse cellpermission jsonString exception" + e16.toString());
        }
        return cellPermissionInfo;
    }

    private static CellUserInfo f(String str) {
        CellUserInfo cellUserInfo = new CellUserInfo();
        if (TextUtils.isEmpty(str)) {
            return cellUserInfo;
        }
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(str).optString(QCircleAlphaUserReporter.KEY_USER));
            User user = new CellUserInfo().getUser();
            cellUserInfo.user = user;
            user.uin = jSONObject.optLong("uin");
            cellUserInfo.user.nickName = jSONObject.optString("nickname");
            cellUserInfo.user.timestamp = jSONObject.optInt("timestamp");
            cellUserInfo.user.uinKey = jSONObject.optString("uinKey");
            cellUserInfo.user.logo = jSONObject.optString("logo");
            cellUserInfo.user.vip = jSONObject.optInt("vip");
            cellUserInfo.user.vipLevel = jSONObject.optInt("vipLevel");
            if (jSONObject.optString("qzonedesc") != null) {
                try {
                    cellUserInfo.user.qzoneDesc = URLDecoder.decode(jSONObject.optString("qzonedesc"), "UTF-8");
                } catch (Exception e16) {
                    e16.printStackTrace();
                    cellUserInfo.user.qzoneDesc = jSONObject.optString("qzonedesc");
                }
            }
            cellUserInfo.user.isOwner = jSONObject.optInt("is_owner");
            cellUserInfo.user.opMask = jSONObject.optInt("operation_mask");
            cellUserInfo.user.uid = jSONObject.optString("uid");
            cellUserInfo.user.talkId = jSONObject.optString("talk_id");
            cellUserInfo.user.portrait_id = jSONObject.optInt("portrait_id");
            cellUserInfo.user.is_own = jSONObject.optInt("is_own");
            cellUserInfo.user.isFamousWhite = jSONObject.optInt("isFamousWhite");
            cellUserInfo.user.isQzoneUser = jSONObject.optInt("isQzoneUser");
            cellUserInfo.user.isAnnualVip = (byte) jSONObject.optInt("isAnnualVip");
            cellUserInfo.user.isNickNameFlash = (byte) jSONObject.optInt("isNickNameFlash");
            cellUserInfo.actionType = jSONObject.optInt("actionType");
        } catch (JSONException e17) {
            QLog.e("TransformJsonToFeeddataUtil", 1, "parse cellcomm jsonString exception" + e17.toString());
        }
        return cellUserInfo;
    }

    public static BusinessFeedData g(String str) {
        String i3 = i(str);
        BusinessFeedData businessFeedData = new BusinessFeedData();
        if (TextUtils.isEmpty(i3)) {
            return businessFeedData;
        }
        try {
            JSONObject jSONObject = new JSONObject(i3);
            f435461a = jSONObject.optString("cell_comm");
            f435462b = jSONObject.optString("cell_userinfo");
            f435463c = jSONObject.optString(PictureConst.CELL_ID);
            f435464d = jSONObject.optString("cell_operation");
            f435465e = jSONObject.optString("cell_permission");
        } catch (JSONException e16) {
            QLog.e("TransformJsonToFeeddataUtil", 1, "parse feeddata jsonString exception" + e16.toString());
        }
        businessFeedData.setCellFeedCommInfo(b(f435461a));
        businessFeedData.setCellUserInfo(f(f435462b));
        businessFeedData.setCellIdInfo(c(f435463c));
        businessFeedData.setCellOperationInfo(d(f435464d));
        businessFeedData.setCellPermissionInfo(e(f435465e));
        return businessFeedData;
    }

    private static String i(String str) {
        String[] strArr;
        String[] split = (str + "/#").split("/");
        if (split.length < 5) {
            return "";
        }
        String str2 = split[2];
        if (split.length == 5) {
            String[] split2 = split[3].split("#");
            if (split2.length > 1) {
                try {
                    Integer.parseInt(split2[1]);
                } catch (NumberFormatException e16) {
                    StringBuilder sb5 = new StringBuilder("illegal jsbridge[");
                    sb5.append(str);
                    sb5.append("] error:");
                    sb5.append(e16.toString());
                    QLog.e("TransformJsonToFeeddataUtil", 1, sb5);
                    return "";
                }
            }
            String[] split3 = split2[0].split("\\?");
            if (split3.length > 1) {
                strArr = split3[1].split(ContainerUtils.FIELD_DELIMITER);
                int length = strArr.length;
                for (int i3 = 0; i3 < length; i3++) {
                    int indexOf = strArr[i3].indexOf(61);
                    if (indexOf != -1) {
                        strArr[i3] = URLDecoder.decode(strArr[i3].substring(indexOf + 1));
                    } else {
                        strArr[i3] = "";
                    }
                }
            } else {
                strArr = new String[0];
            }
            String str3 = split3[0];
        } else {
            String str4 = split[3];
            try {
                Long.parseLong(split[4]);
                int length2 = split.length - 6;
                String[] strArr2 = new String[length2];
                System.arraycopy(split, 5, strArr2, 0, length2);
                for (int i16 = 0; i16 < length2; i16++) {
                    strArr2[i16] = URLDecoder.decode(strArr2[i16]);
                }
                strArr = strArr2;
            } catch (Exception e17) {
                StringBuilder sb6 = new StringBuilder("illegal jsbridge[");
                sb6.append(str);
                sb6.append("] error:");
                sb6.append(e17.toString());
                QLog.e("TransformJsonToFeeddataUtil", 1, sb6);
                return "";
            }
        }
        return strArr[0];
    }

    public static PictureUrl h(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        PictureUrl pictureUrl = new PictureUrl();
        pictureUrl.width = jSONObject.optInt("width");
        pictureUrl.height = jSONObject.optInt("height");
        pictureUrl.url = jSONObject.optString("url");
        pictureUrl.enlargeRate = jSONObject.optInt("enlarge_rate");
        return pictureUrl;
    }
}
