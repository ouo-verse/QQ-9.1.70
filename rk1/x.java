package rk1;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes13.dex */
public class x extends b {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ok1.a
    public String k() {
        return "setRedoEnable";
    }

    @Override // ok1.a
    protected boolean o(String str, String str2, String str3) {
        in1.e l3 = l();
        if (l3 == null) {
            return false;
        }
        boolean b16 = b("redoEnable");
        QLog.d("Guild_Feed_BaseGuildJsBridgeMethod", 1, "PublishSetRedoMethod, enable: " + b16);
        l3.i7(b16);
        return true;
    }
}
