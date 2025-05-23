package z3;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.webview.AbsWebView;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import com.tencent.mobileqq.widget.bx;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends b {

    /* renamed from: c, reason: collision with root package name */
    private View f451835c;

    public a(Context context, Activity activity, AppRuntime appRuntime) {
        super(context, activity, appRuntime);
    }

    public View b() {
        return this.f451835c;
    }

    @Override // z3.b, com.tencent.mobileqq.webview.util.m
    public void buildLayout() {
        int i3;
        super.buildLayout();
        TouchWebView touchWebView = new TouchWebView(this.f451836a);
        this.mWebview = touchWebView;
        touchWebView.setWillNotCacheDrawing(false);
        this.mWebview.setDrawingCacheEnabled(true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        if (this.f451837b) {
            i3 = ImmersiveUtils.getStatusBarHeight(this.f451836a) - 2;
        } else {
            i3 = 0;
        }
        layoutParams.setMargins(0, i3, 0, 0);
        this.mWebview.setLayoutParams(layoutParams);
        if (this.mWebview.getX5WebViewExtension() != null) {
            try {
                this.mWebview.getView().setBackgroundColor(0);
            } catch (Exception e16) {
                QLog.e(AbsWebView.TAG, 1, "", e16);
            }
        } else {
            this.mWebview.setBackgroundColor(0);
        }
        WebViewProgressBar webViewProgressBar = new WebViewProgressBar(this.f451836a);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, x.c(this.f451836a, 3.0f));
        layoutParams2.gravity = 48;
        webViewProgressBar.setLayoutParams(layoutParams2);
        bx bxVar = new bx();
        this.mProgressBarController = bxVar;
        webViewProgressBar.setController(bxVar);
        FrameLayout frameLayout = new FrameLayout(this.f451836a);
        frameLayout.addView(this.mWebview);
        frameLayout.addView(webViewProgressBar);
        frameLayout.setBackgroundResource(R.color.ajr);
        this.f451835c = frameLayout;
        this.f451836a.getWindow().setBackgroundDrawableResource(R.color.ajr);
    }
}
