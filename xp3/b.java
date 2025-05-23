package xp3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.aelight.camera.download.AEResManagerConfigBean;
import com.tencent.biz.ProtoUtils;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.List;
import tencent.im.oidb.appauth_comm$AuthGroupTuple;
import tencent.im.oidb.oidb_0xd55$CheckUrlSigReq;
import tencent.im.oidb.oidb_0xd55$CheckUserAuthReq;
import tencent.im.oidb.oidb_0xd55$DecryptReq;
import tencent.im.oidb.oidb_0xd55$ReqBody;
import tencent.im.oidb.oidb_0xd55$RspBody;
import zp3.d;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {
    public static void a(BaseQQAppInterface baseQQAppInterface, c cVar, long j3, ProtoUtils.TroopProtocolObserver troopProtocolObserver) {
        List<String> list;
        List<appauth_comm$AuthGroupTuple> list2;
        oidb_0xd55$ReqBody oidb_0xd55_reqbody = new oidb_0xd55$ReqBody();
        oidb_0xd55_reqbody.check_app_sign_req.setHasFlag(true);
        oidb_0xd55_reqbody.check_app_sign_req.client_info.setHasFlag(true);
        if (!TextUtils.isEmpty(cVar.packageName)) {
            oidb_0xd55_reqbody.check_app_sign_req.client_info.android_package_name.set(cVar.packageName);
        }
        oidb_0xd55_reqbody.check_app_sign_req.client_info.platform.set(1);
        String b16 = b(baseQQAppInterface.getApp(), cVar.packageName);
        if (!TextUtils.isEmpty(b16)) {
            oidb_0xd55_reqbody.check_app_sign_req.client_info.android_signature.set(b16);
        }
        String str = cVar.sdkVersion;
        if (TextUtils.isEmpty(str)) {
            str = AEResManagerConfigBean.DEFAULT_VERSION;
        }
        oidb_0xd55_reqbody.check_app_sign_req.client_info.sdk_version.set(str);
        oidb_0xd55_reqbody.check_user_req.setHasFlag(true);
        oidb_0xd55_reqbody.check_user_req.openid.set(cVar.openid);
        oidb_0xd55_reqbody.check_user_req.need_check_same_user.set(cVar.needCheckSameUser ? 1 : 0);
        if (cVar.needCheckMiniApp) {
            oidb_0xd55_reqbody.check_mini_app_req.setHasFlag(true);
            oidb_0xd55_reqbody.check_mini_app_req.mini_app_appid.set(cVar.miniAppId);
            oidb_0xd55_reqbody.check_mini_app_req.need_check_bind.set(1);
        }
        oidb_0xd55_reqbody.appid.set(cVar.appid);
        oidb_0xd55_reqbody.app_type.set(cVar.apptype);
        oidb_0xd55_reqbody.src_id.set(cVar.srcId);
        oidb_0xd55_reqbody.is_need_appinfo.set(cVar.isNeedAppInfo ? 1 : 0);
        if (!TextUtils.isEmpty(cVar.rawUrl)) {
            oidb_0xd55_reqbody.raw_url.set(cVar.rawUrl);
            oidb_0xd55$CheckUrlSigReq oidb_0xd55_checkurlsigreq = new oidb_0xd55$CheckUrlSigReq();
            oidb_0xd55_checkurlsigreq.is_need_check_raw_url_sig.set(true);
            oidb_0xd55_reqbody.check_url_sig_req.set(oidb_0xd55_checkurlsigreq);
        }
        d.a aVar = cVar.checkAppParams;
        if (aVar != null) {
            if (!TextUtils.isEmpty(aVar.f452983a)) {
                oidb_0xd55$DecryptReq oidb_0xd55_decryptreq = new oidb_0xd55$DecryptReq();
                oidb_0xd55_decryptreq.cipher_text.set(aVar.f452983a);
                oidb_0xd55_reqbody.decrypt_req.set(oidb_0xd55_decryptreq);
            }
            if (cVar.openid != null && (list = aVar.f452984b) != null && !list.isEmpty() && (list2 = aVar.f452985c) != null && !list2.isEmpty()) {
                oidb_0xd55$CheckUserAuthReq oidb_0xd55_checkuserauthreq = new oidb_0xd55$CheckUserAuthReq();
                oidb_0xd55_checkuserauthreq.openids.addAll(aVar.f452984b);
                oidb_0xd55_checkuserauthreq.auth_groups.addAll(aVar.f452985c);
                oidb_0xd55_reqbody.check_user_auth_req.set(oidb_0xd55_checkuserauthreq);
            }
        }
        ProtoUtils.c(baseQQAppInterface, troopProtocolObserver, oidb_0xd55_reqbody.toByteArray(), "OidbSvc.0xd55", 3413, 0, null, j3);
    }

    public static String b(Context context, String str) {
        try {
            Signature[] signatureArr = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), str, 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            messageDigest.update(signatureArr[0].toByteArray());
            String bytes2HexStr = HexUtil.bytes2HexStr(messageDigest.digest());
            if (bytes2HexStr == null) {
                return "";
            }
            String lowerCase = bytes2HexStr.toLowerCase();
            messageDigest.reset();
            return lowerCase;
        } catch (Exception e16) {
            hd0.c.h("JumpUtils", "getAppSign exception!", e16);
            hd0.c.g("JumpUtils", "");
            return "";
        }
    }

    public static oidb_0xd55$RspBody c(byte[] bArr) {
        if (bArr == null) {
            QLog.e("JumpUtils", 1, "parseOIDBD55RspBody onError data == null");
            return null;
        }
        oidb_0xd55$RspBody oidb_0xd55_rspbody = new oidb_0xd55$RspBody();
        try {
            oidb_0xd55_rspbody.mergeFrom(bArr);
            return oidb_0xd55_rspbody;
        } catch (Exception e16) {
            QLog.e("JumpUtils", 1, "parseOIDBD55RspBody exception. ", e16);
            return null;
        }
    }

    public static JumpParserResult d(String str) {
        String substring;
        if (TextUtils.isEmpty(str)) {
            QLog.e("JumpUtils", 1, "parseUrl error: jump is empty");
            return null;
        }
        JumpParserResult jumpParserResult = new JumpParserResult("", "", "", "", str);
        int indexOf = str.indexOf(":");
        if (indexOf > 0) {
            jumpParserResult.setScheme(str.substring(0, indexOf));
            QLog.d("JumpUtils", 1, "parseUrl scheme is: " + jumpParserResult.getScheme());
            String[] split = str.split("\\?");
            if (split.length == 2) {
                substring = split[0].substring(indexOf + 3);
            } else {
                substring = str.substring(indexOf + 3);
            }
            String[] split2 = substring.split("/");
            if (split2.length == 0) {
                jumpParserResult.setServer(substring);
                QLog.d("JumpUtils", 1, "parseUrl server is: " + jumpParserResult.getServer());
            } else {
                jumpParserResult.setServer(split2[0]);
                jumpParserResult.setAction(substring.substring(substring.indexOf("/") + 1));
                QLog.d("JumpUtils", 1, "parseUrl server is: " + jumpParserResult.getServer() + " action is: " + jumpParserResult.getAction());
            }
            if (split.length == 2) {
                for (String str2 : split[1].split(ContainerUtils.FIELD_DELIMITER)) {
                    String[] split3 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (split3.length == 2) {
                        try {
                            String decode = URLDecoder.decode(split3[1], "UTF-8");
                            split3[1] = decode;
                            jumpParserResult.putAttribute(split3[0], decode);
                        } catch (Exception e16) {
                            QLog.e("JumpUtils", 1, "failed to decode param value,keyValues[1] is:" + split3[1] + ",keyValues[2] is:" + split3[1], e16);
                        }
                    }
                }
            }
            return jumpParserResult;
        }
        jumpParserResult.setScheme(str);
        QLog.d("JumpUtils", 1, "parseUrl scheme is: " + jumpParserResult.getScheme());
        return jumpParserResult;
    }

    public static final void e(Activity activity, String str, boolean z16, long j3, String str2) {
        String format;
        if (activity == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("JumpUtils", 2, "sdk_share:sdk callback=", Boolean.valueOf(z16), " appId=", Long.valueOf(j3), " action=", "action_common_channel");
        }
        Intent intent = new Intent();
        if (z16) {
            format = String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", Long.valueOf(j3), "action_common_channel");
        } else {
            format = String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=cancel", Long.valueOf(j3), "action_common_channel");
        }
        if (str2 != null && !str2.isEmpty()) {
            try {
                format = format + "&message=" + URLEncoder.encode(str2, "UTF-8");
            } catch (UnsupportedEncodingException unused) {
            }
        }
        intent.setData(Uri.parse(format));
        if (str != null) {
            intent.setPackage(str);
        }
        try {
            activity.startActivity(intent);
        } catch (Exception e16) {
            QLog.d("JumpUtils", 1, "startSdkCallback exception", e16);
        }
    }
}
