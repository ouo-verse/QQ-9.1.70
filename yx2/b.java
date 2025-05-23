package yx2;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.tvideo.webview.d;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.io.Serializable;
import java.util.HashMap;
import jy2.g;
import org.json.JSONException;
import org.json.JSONObject;
import zt2.e;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b extends QIPCModule {

    /* compiled from: P */
    /* loaded from: classes19.dex */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f451376a = new b();
    }

    b() {
        super("TVideoIPCMainServer");
        QLog.d("TVideoIPCMainServer", 4, "new instance");
    }

    public static b b() {
        return a.f451376a;
    }

    private boolean c(Bundle bundle) {
        if (bundle == null) {
            return false;
        }
        return TextUtils.equals(bundle.getString("is_auth_pay_cookie", ""), "1");
    }

    @Override // eipc.EIPCModule
    public EIPCResult onCall(String str, Bundle bundle, int i3) {
        QLog.d("TVideoIPCMainServer", 4, "onCall\uff1a" + str);
        if ("collect_cookie".equals(str)) {
            Bundle bundle2 = new Bundle();
            if (c(bundle)) {
                bundle2.putSerializable("collect_cookie", (Serializable) g.b());
            } else {
                bundle2.putSerializable("collect_cookie", (Serializable) g.c());
            }
            return EIPCResult.createSuccessResult(bundle2);
        }
        if ("call_jsapi".equals(str)) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            try {
                JSONObject o16 = d.o(bundle.getString("method"), new HashMap(), null, false);
                if (o16 != null) {
                    bundle.putSerializable("call_jsapi", o16.toString());
                }
            } catch (JSONException unused) {
                QLog.d("TVideoIPCMainServer", 4, "on JSONException");
            }
            return EIPCResult.createSuccessResult(bundle);
        }
        if (!"refresh_login".equals(str)) {
            return null;
        }
        e.f453199a.p();
        return EIPCResult.createSuccessResult(null);
    }
}
