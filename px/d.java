package px;

import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes2.dex */
public class d implements b {
    @Override // px.b
    public void d(String str, int i3, String str2) {
        QLog.d(str, i3, str2);
    }

    @Override // px.b
    public void i(String str, int i3, String str2) {
        QLog.i(str, i3, str2);
    }

    @Override // px.b
    public boolean isColorLevel() {
        return QLog.isColorLevel();
    }

    @Override // px.b
    public boolean isDevelopLevel() {
        return QLog.isDevelopLevel();
    }
}
