package tx;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.coupon.CouponActivity;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends WebViewPlugin {
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "coupon";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (!"coupon".equals(str2)) {
            return false;
        }
        if ("goToCouponHomePage".equals(str3) && strArr.length == 1) {
            p(strArr[0]);
            jsBridgeListener.c(null);
        }
        return true;
    }

    public void p(String str) {
        Activity a16 = this.mRuntime.a();
        if (a16 instanceof CouponActivity) {
            CouponActivity couponActivity = (CouponActivity) a16;
            int i3 = couponActivity.f78476a0;
            if ((i3 & 8) != 0) {
                Intent intent = new Intent();
                intent.putExtra("toPage", 2);
                couponActivity.setResult(-1, intent);
                couponActivity.superFinish();
                return;
            }
            Intent intent2 = new Intent(a16, (Class<?>) CouponActivity.class);
            intent2.putExtra("from", (i3 | 10) & 14);
            if (!TextUtils.isEmpty(str)) {
                intent2.putExtra("jsonParams", str);
            }
            a16.startActivity(intent2);
        }
    }
}
