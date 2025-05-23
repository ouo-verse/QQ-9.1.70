package tr2;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.intervideo.singtogether.SingTogetherSession;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherSession;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import com.tencent.util.URLUtil;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final DownloadParams.DecodeHandler f437193a = new a();

    /* compiled from: P */
    /* loaded from: classes9.dex */
    class a implements DownloadParams.DecodeHandler {
        a() {
        }

        @Override // com.tencent.image.DownloadParams.DecodeHandler
        public Bitmap run(DownloadParams downloadParams, Bitmap bitmap) {
            if (QLog.isColorLevel()) {
                QLog.d("TogetherUtils", 2, "AVATAR_WALL_RECT__DECODER");
            }
            if (bitmap == null) {
                return null;
            }
            Object obj = downloadParams.tag;
            if (obj instanceof int[]) {
                int[] iArr = (int[]) obj;
                if (iArr.length == 3) {
                    return BaseImageUtil.getRoundedCornerBitmap3(bitmap, iArr[2], iArr[0], iArr[1]);
                }
                return bitmap;
            }
            return bitmap;
        }
    }

    public static <T extends f> T a(int i3, int i16, String str) {
        if (i3 == 2) {
            return new WatchTogetherSession(str);
        }
        if (i3 == 4) {
            return new SingTogetherSession(i16, str);
        }
        throw new UnsupportedOperationException("Can not generate an object.");
    }

    public static String b(@NonNull String str, @NonNull Bundle bundle) {
        if (bundle.containsKey("TOGETHER_BUNDLE_KEY_C2C_FRIEND_OPENID")) {
            str = URLUtil.addParameter(str, "friend_user_openid", bundle.getString("TOGETHER_BUNDLE_KEY_C2C_FRIEND_OPENID"));
        }
        if (bundle.containsKey("TOGETHER_BUNDLE_KEY_OPEN_STATUS")) {
            str = URLUtil.addParameter(str, "isopen", bundle.getBoolean("TOGETHER_BUNDLE_KEY_OPEN_STATUS") + "");
        }
        if (bundle.containsKey("TOGETHER_BUNDLE_KEY_FROM_TYPE")) {
            str = URLUtil.addParameter(str, "from", bundle.getInt("TOGETHER_BUNDLE_KEY_FROM_TYPE") + "");
        }
        if (QLog.isColorLevel()) {
            QLog.d("TogetherUtils", 2, "generalC2CJumpURL, realJumpURL=", str);
        }
        return str;
    }

    public static String c(@NonNull String str, @NonNull Bundle bundle) {
        if (bundle.containsKey("TOGETHER_BUNDLE_KEY_TROOP_UIN")) {
            String string = bundle.getString("TOGETHER_BUNDLE_KEY_TROOP_UIN");
            if (string == null) {
                string = "";
            }
            str = URLUtil.addParameter(str, "troopuin", string);
        }
        if (bundle.containsKey("TOGETHER_BUNDLE_KEY_OWNER_UIN")) {
            String string2 = bundle.getString("TOGETHER_BUNDLE_KEY_OWNER_UIN");
            if (string2 == null) {
                string2 = "";
            }
            str = URLUtil.addParameter(str, "troopowneruin", string2);
        }
        if (bundle.containsKey("TOGETHER_BUNDLE_KEY_IS_OWNER")) {
            str = URLUtil.addParameter(str, "isowner", bundle.getBoolean("TOGETHER_BUNDLE_KEY_IS_OWNER", false) + "");
        }
        if (bundle.containsKey("TOGETHER_BUNDLE_KEY_IS_ADMIN")) {
            str = URLUtil.addParameter(str, "isadmin", bundle.getBoolean("TOGETHER_BUNDLE_KEY_IS_ADMIN", false) + "");
        }
        if (bundle.containsKey("TOGETHER_BUNDLE_KEY_OPEN_STATUS")) {
            str = URLUtil.addParameter(str, "isopen", bundle.getBoolean("TOGETHER_BUNDLE_KEY_OPEN_STATUS", false) + "");
        }
        if (bundle.containsKey("TOGETHER_BUNDLE_KEY_FROM_TYPE")) {
            str = URLUtil.addParameter(str, "from", bundle.getInt("TOGETHER_BUNDLE_KEY_FROM_TYPE", 0) + "");
        }
        if (QLog.isColorLevel()) {
            QLog.d("TogetherUtils", 2, "jumpToDefaultTogetherWatch, realJumpURL=", str);
        }
        return str;
    }

    public static Bundle d(boolean z16, int i3) {
        Bundle bundle = new Bundle();
        bundle.putInt("TOGETHER_BUNDLE_KEY_FROM_TYPE", i3);
        bundle.putBoolean("TOGETHER_BUNDLE_KEY_OPEN_STATUS", z16);
        return bundle;
    }

    public static Bundle e(boolean z16, boolean z17, boolean z18, String str, String str2, int i3) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("TOGETHER_BUNDLE_KEY_IS_OWNER", z17);
        bundle.putBoolean("TOGETHER_BUNDLE_KEY_IS_ADMIN", z18);
        bundle.putString("TOGETHER_BUNDLE_KEY_OWNER_UIN", str);
        bundle.putString("TOGETHER_BUNDLE_KEY_TROOP_UIN", str2);
        bundle.putInt("TOGETHER_BUNDLE_KEY_FROM_TYPE", i3);
        bundle.putBoolean("TOGETHER_BUNDLE_KEY_OPEN_STATUS", z16);
        return bundle;
    }

    public static String f(int i3, String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            int d16 = com.tencent.mobileqq.profile.PersonalityLabel.tagCloud.b.d(str);
            if (i3 > 0 && !TextUtils.isEmpty(str) && d16 > i3) {
                StringBuilder sb5 = new StringBuilder();
                int i16 = 0;
                int i17 = 0;
                while (i16 < str.length()) {
                    int codePointAt = str.codePointAt(i16);
                    if (codePointAt >= 32 && codePointAt <= 126) {
                        i17++;
                    } else if (codePointAt >= 65535) {
                        i17++;
                        i16++;
                    } else {
                        i17 += 2;
                    }
                    sb5.appendCodePoint(codePointAt);
                    if (i17 >= i3) {
                        break;
                    }
                    i16++;
                }
                sb5.append(MiniBoxNoticeInfo.APPNAME_SUFFIX);
                return sb5.toString();
            }
            return str;
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.i("TogetherUtils", 2, th5.getMessage(), th5);
            }
            return "";
        }
    }

    private static QBaseActivity g() {
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if (baseActivity == null && (Foreground.getTopActivity() instanceof QBaseActivity)) {
            return (QBaseActivity) Foreground.getTopActivity();
        }
        return baseActivity;
    }

    private static QQAppInterface h() {
        QQAppInterface qQAppInterface;
        BaseActivity baseActivity = BaseActivity.sTopActivity;
        if (baseActivity != null && (qQAppInterface = baseActivity.app) != null) {
            return qQAppInterface;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            return (QQAppInterface) peekAppRuntime;
        }
        return null;
    }

    public static void i(@NonNull Context context, int i3, @NonNull String str, @Nullable String str2, @NonNull Bundle bundle, int i16) {
        String b16;
        String b17;
        if (i3 != 1) {
            if (i3 != 2) {
                QQToast.makeText(context, 0, R.string.vty, 0).show();
                return;
            }
            Intent intent = new Intent();
            if (i16 == 1) {
                b17 = c(str, bundle);
            } else {
                b17 = b(str, bundle);
            }
            Uri parse = Uri.parse(b17);
            if (QLog.isColorLevel()) {
                QLog.d("TogetherUtils", 2, "jumpToDefaultTogetherWatch, realJumpURI=", parse.toString());
            }
            intent.setData(parse);
            intent.setFlags(268435456);
            BaseApplication.getContext().startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(context, (Class<?>) QQBrowserActivity.class);
        if (i16 == 1) {
            b16 = c(str, bundle);
        } else {
            b16 = b(str, bundle);
        }
        intent2.putExtra("url", b16);
        intent2.setFlags(268435456);
        context.startActivity(intent2);
    }

    public static void j(@NonNull QQAppInterface qQAppInterface, int i3, @NonNull String str, @Nullable String str2, @NonNull Bundle bundle, int i16) {
        i(qQAppInterface.getApp(), i3, str, str2, bundle, i16);
    }

    public static void k(int i3, Map<String, Object> map, Map<String, String> map2) {
        String str;
        String str2;
        HashMap hashMap;
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        int i16;
        int intValue;
        String str3;
        String str4;
        long j3;
        String str5 = null;
        if (map2 == null) {
            str = null;
        } else {
            str = map2.get("chatType");
        }
        if (map2 == null) {
            str2 = null;
        } else {
            str2 = map2.get("chatUIN");
        }
        if (map == null) {
            hashMap = null;
        } else {
            hashMap = (HashMap) map.get("extra");
        }
        if (hashMap == null) {
            obj = null;
        } else {
            obj = hashMap.get("aio_media_id");
        }
        if (hashMap == null) {
            obj2 = null;
        } else {
            obj2 = hashMap.get("song_id");
        }
        if (hashMap == null) {
            obj3 = "";
        } else {
            obj3 = hashMap.get("match_id");
        }
        String str6 = (String) obj3;
        if (hashMap == null) {
            obj4 = null;
        } else {
            obj4 = hashMap.get("sub_type");
        }
        Integer num = (Integer) obj4;
        if (num != null) {
            try {
                intValue = num.intValue();
            } catch (Throwable th5) {
                QLog.e("TogetherUtils", 1, "categoryId to int ", th5);
                i16 = 0;
            }
        } else {
            intValue = 0;
        }
        i16 = intValue;
        if (map == null) {
            str3 = null;
        } else {
            str3 = (String) map.get("summary");
        }
        if (map == null) {
            str4 = null;
        } else {
            str4 = (String) map.get("cover");
        }
        QLog.d("TogetherUtils", 1, "onArkTogetherClick params[", str, " ", str2, " ", obj, " ", obj2, "]");
        if (obj instanceof Long) {
            j3 = ((Long) obj).longValue();
        } else {
            j3 = 0;
        }
        if (obj2 instanceof String) {
            str5 = (String) obj2;
        }
        int i17 = -1;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                if ("2".equalsIgnoreCase(str)) {
                    i17 = 2;
                } else if ("3".equalsIgnoreCase(str)) {
                    i17 = 1;
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("TogetherUtils", 2, e16.getMessage(), e16);
                }
            }
        }
        int i18 = i17;
        if ((i18 != 2 && i18 != 1) || j3 == 0) {
            QLog.d("TogetherUtils", 1, "onArkTogetherClick return invalid params");
            return;
        }
        QBaseActivity g16 = g();
        QQAppInterface h16 = h();
        if (g16 != null && h16 != null) {
            Bundle bundle = new Bundle();
            bundle.putString("video_id", str6);
            bundle.putInt(PictureConst.KEY_CATEGORY_ID, i16);
            bundle.putString("title_name", str3);
            bundle.putString("room_cover", str4);
            bundle.putString("song_id", str5);
            b.q(h16).E(g16, i3, i18, str2, j3, 8, bundle);
            return;
        }
        QLog.d("TogetherUtils", 1, "onArkTogetherClick return null activity");
    }

    public static void l(QQAppInterface qQAppInterface, String str, boolean z16, int i3, int i16) {
        if (i3 == 1) {
            ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).updateTogetherBusinessFlag(str, z16, i16);
        }
    }

    public static void m(QQAppInterface qQAppInterface, String str, boolean z16) {
        TroopInfo troopInfoFromCache;
        MqqHandler handler;
        if (QLog.isColorLevel()) {
            QLog.i("TogetherUtils", 2, "setIsGroupWatchTogetherOpen, app =" + qQAppInterface + ",troopuin=" + str + ",isOpen=" + z16);
        }
        if (qQAppInterface == null || (troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(str)) == null) {
            return;
        }
        boolean isWatchTogetherOpen = troopInfoFromCache.isWatchTogetherOpen();
        ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).updateWatchTogetherState(str, z16);
        if (QLog.isColorLevel()) {
            QLog.i("TogetherUtils", 2, "setIsGroupWatchTogetherOpen troopinfo saved, last=" + isWatchTogetherOpen);
        }
        if (isWatchTogetherOpen != z16 && (handler = qQAppInterface.getHandler(Conversation.class)) != null) {
            handler.sendEmptyMessage(1009);
        }
    }
}
