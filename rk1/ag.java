package rk1;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes13.dex */
public class ag extends b {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    public String k() {
        return "setLongFeedPublishBtnStatus";
    }

    @Override // ok1.a
    protected boolean o(String str, String str2, String str3) {
        in1.e l3 = l();
        if (l3 == null) {
            return false;
        }
        int d16 = d("btnStatus");
        boolean z16 = true;
        if (QLog.isDevelopLevel()) {
            QLog.d("Guild_Feed_BaseGuildJsBridgeMethod", 1, "SetLongFeedPublishBtnStatusMethod, enable: " + d16);
        }
        if (d16 != 1) {
            z16 = false;
        }
        l3.T8(z16);
        return false;
    }
}
