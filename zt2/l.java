package zt2;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import bu2.c;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheQzoneVipData;
import com.tencent.biz.qcircleshadow.lib.HostStaticInvokeHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;
import com.tencent.mobileqq.tvideo.net.utils.TVideoConfig;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qcircle.application.QCircleApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes19.dex */
public class l {
    public static void a(ImageView imageView) {
        if (imageView != null) {
            imageView.setImageDrawable(QCircleApplication.APP.getDrawable(R.drawable.ow6));
        }
    }

    public static void b(Context context, boolean z16) {
        String str;
        bu2.a i3 = e.f453199a.i();
        if (i3 == null) {
            return;
        }
        boolean isVip = i3.getIsVip();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("&should_reuse_existed_page=");
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        sb5.append(str);
        String sb6 = sb5.toString();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(QAdLoginDefine$LoginCookieKey.QQ_VUSESSION, i3.getVideoSessionKey());
            jSONObject.put(QAdLoginDefine$LoginCookieKey.QQ_VUSERID, i3.getVideoUserId());
            jSONObject.put(QAdLoginDefine$LoginCookieKey.QQ_ACCESS_TOKEN, i3.getCom.huawei.hms.support.feature.result.CommonConstant.KEY_ACCESS_TOKEN java.lang.String());
            jSONObject.put(QAdLoginDefine$LoginCookieKey.QQ_OPENID, i3.getOpenId());
            jSONObject.put(QAdLoginDefine$LoginCookieKey.QQ_APPID, "102031143");
            jSONObject.put("vqq_nickname", i3.getNickName());
            jSONObject.put("omgid", "");
            jSONObject.put("guid", "");
            jSONObject.put("q36", TVideoConfig.f304492a.k());
            jSONObject.put(WidgetCacheQzoneVipData.ISVIP, isVip ? 1 : 0);
            String str2 = "https://fuli.v.qq.com/h5/activity/vg_activity/qq-h5-v1/index.html?_nav_trans=1&bgColor=ff000000&_nav_bgclr=ff000000&_wv=16777219&_wwv=8192&info=" + URLEncoder.encode(jSONObject.toString(), "UTF-8") + sb6;
            QLog.d("TVideoAccountUtils", 4, "jumpToPersonalCenter:" + str2);
            jy2.f.f411169a.i(context, str2);
        } catch (Exception e16) {
            QLog.d("TVideoAccountUtils", 4, "jumpToPersonalCenter Exception " + e16);
        }
    }

    public static void c(Context context, boolean z16) {
        e eVar = e.f453199a;
        if (!eVar.k()) {
            if (HostStaticInvokeHelper.isNetworkValid()) {
                if (context instanceof Activity) {
                    eVar.l((Activity) context);
                    return;
                }
                return;
            }
            QQToast.makeText(context, 1, "\u8bf7\u68c0\u67e5\u7f51\u7edc\u8fde\u63a5", 0).show();
            return;
        }
        b(context, z16);
    }

    public static void d(ImageView imageView, bu2.a aVar) {
        jy2.f.f411169a.j(imageView, aVar.getHeadImageUrl());
    }

    public static void e(ImageView imageView) {
        bu2.a i3 = e.f453199a.i();
        if (i3 != null) {
            d(imageView, i3);
        } else {
            a(imageView);
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class a implements au2.a {

        /* renamed from: a, reason: collision with root package name */
        ImageView f453214a;

        public a(ImageView imageView) {
            this.f453214a = imageView;
        }

        @Override // au2.a
        public void a(@NonNull bu2.a aVar) {
            l.d(this.f453214a, aVar);
            gy2.c.D(aVar);
        }

        @Override // au2.a
        public void b(@NonNull bu2.c cVar) {
            if (cVar instanceof c.a) {
                c.a aVar = (c.a) cVar;
                QQToast.makeText(QCircleApplication.APP, 1, aVar.getErrorMsg() + ", \u9519\u8bef\u7801 " + aVar.getErrorCode(), 0).show();
                return;
            }
            if (cVar instanceof c.C0152c) {
                c.C0152c c0152c = (c.C0152c) cVar;
                QQToast.makeText(QCircleApplication.APP, 1, c0152c.getErrorMsg() + ", \u9519\u8bef\u7801 " + c0152c.getErrorCode(), 0).show();
            }
        }

        @Override // au2.a
        public void d() {
            l.a(this.f453214a);
        }

        @Override // au2.a
        public void c(@Nullable bu2.a aVar) {
        }

        @Override // au2.a
        public void e(@NonNull bu2.a aVar) {
        }
    }
}
