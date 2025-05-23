package yx2;

import android.os.Bundle;
import com.tencent.mobileqq.perf.block.BinderMethodProxy;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import eipc.EIPCResult;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a {
    public static EIPCResult a(String str, Bundle bundle) {
        return BinderMethodProxy.callServer(QIPCClientHelper.getInstance().getClient(), "TVideoIPCMainServer", str, bundle);
    }

    public static EIPCResult b(Bundle bundle) {
        return a("collect_cookie", bundle);
    }

    public static EIPCResult c(Bundle bundle) {
        return a("call_jsapi", bundle);
    }

    public static EIPCResult d() {
        return a("refresh_login", null);
    }
}
