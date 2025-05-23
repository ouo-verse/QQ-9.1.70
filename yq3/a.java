package yq3;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.mini.servlet.CloudStorageServlet;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a extends WebViewPlugin {

    /* renamed from: d, reason: collision with root package name */
    private BroadcastReceiver f451014d = new C11627a();

    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public String getNameSpace() {
        return "qidian";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public boolean handleJsRequest(JsBridgeListener jsBridgeListener, String str, String str2, String str3, String... strArr) {
        if (QLog.isColorLevel()) {
            QLog.d("QidianWpaWebviewPlugin", 2, str2 + str3 + strArr[0]);
        }
        if (str2.equals("qidian") && str3.equals("videochat")) {
            try {
                JSONObject jSONObject = new JSONObject(strArr[0]);
                String optString = jSONObject.optString(CloudStorageServlet.REQUEST_TYPE);
                String optString2 = jSONObject.optString("uin");
                String optString3 = jSONObject.optString("sigt");
                String optString4 = jSONObject.optString("nickname");
                Bundle bundle = new Bundle();
                bundle.putString(CloudStorageServlet.REQUEST_TYPE, optString);
                bundle.putString("uin", optString2);
                bundle.putString("sigt", optString3);
                bundle.putString("nickname", optString4);
                q(bundle);
                return true;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("QidianWpaWebviewPlugin", 2, "handleJsRequest ", e16);
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onCreate() {
        Activity a16 = this.mRuntime.a();
        if (a16 != null) {
            a16.registerReceiver(this.f451014d, new IntentFilter("com.tencent.mobileqq.qidian.openactionsheet"), "com.tencent.msg.permission.pushnotify", null);
        }
        super.onCreate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.webview.swift.WebViewPlugin
    public void onDestroy() {
        super.onDestroy();
        Activity a16 = this.mRuntime.a();
        if (a16 != null) {
            a16.unregisterReceiver(this.f451014d);
        }
    }

    /* compiled from: P */
    /* renamed from: yq3.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    class C11627a extends BroadcastReceiver {
        C11627a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!intent.getAction().equalsIgnoreCase("com.tencent.mobileqq.qidian.openactionsheet") || a.this.mRuntime.a() == null) {
                return;
            }
            ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog((Activity) context, null);
            actionSheet.addButton(R.string.f0k);
            actionSheet.addCancelButton(R.string.cancel);
            actionSheet.setOnButtonClickListener(new C11628a(intent, actionSheet));
            actionSheet.show();
        }

        /* compiled from: P */
        /* renamed from: yq3.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes36.dex */
        class C11628a implements ActionSheet.OnButtonClickListener {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Intent f451016d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ ActionSheet f451017e;

            C11628a(Intent intent, ActionSheet actionSheet) {
                this.f451016d = intent;
                this.f451017e = actionSheet;
            }

            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public void onClick(View view, int i3) {
                if (i3 == 0) {
                    Bundle extras = this.f451016d.getExtras();
                    if (extras.containsKey(CloudStorageServlet.REQUEST_TYPE) && extras.containsKey("uin") && extras.containsKey("sigt") && extras.containsKey("nickname")) {
                        a.this.q(extras);
                    }
                }
                this.f451017e.dismiss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(Bundle bundle) {
        if (bundle == null || bundle.isEmpty()) {
            return;
        }
        ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).sendServiceIpcReq(com.tencent.mobileqq.emosm.a.a("ipc_qidian_video_chat", "", 0, bundle));
    }
}
