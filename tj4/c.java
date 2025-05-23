package tj4;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import com.tencent.biz.common.util.k;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.biz.webviewbase.AbsBaseWebViewActivity;
import com.tencent.mobileqq.webview.swift.SwiftReuseTouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewWrapper;
import com.tencent.mobileqq.webview.swift.z;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.liveroom.impl.room.match.TGLiveTouchWebView;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c extends WebViewWrapper {
    public c(Activity activity, z zVar, Intent intent, boolean z16) {
        super(zVar, intent, activity, z16);
    }

    @Override // com.tencent.mobileqq.webview.swift.WebViewWrapper
    public TouchWebView h(Context context, boolean z16) {
        TouchWebView tGLiveTouchWebView;
        k.a(AbsBaseWebViewActivity.WEBVIEW_BROWSER_INIT_WEBVIEW);
        long currentTimeMillis = System.currentTimeMillis();
        boolean z17 = true;
        if (z16) {
            if (SwiftReuseTouchWebView.I != 0) {
                z17 = false;
            }
            tGLiveTouchWebView = SwiftReuseTouchWebView.q(context);
        } else {
            tGLiveTouchWebView = new TGLiveTouchWebView(context);
        }
        DisplayMetrics displayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
        ViewGroup.LayoutParams layoutParams = tGLiveTouchWebView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(displayMetrics.widthPixels, displayMetrics.heightPixels);
        } else {
            layoutParams.width = displayMetrics.widthPixels;
            layoutParams.height = displayMetrics.heightPixels;
        }
        tGLiveTouchWebView.setLayoutParams(layoutParams);
        if (z17) {
            this.f314159f = System.currentTimeMillis() - currentTimeMillis;
        }
        return tGLiveTouchWebView;
    }
}
