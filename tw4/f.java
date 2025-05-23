package tw4;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes27.dex */
public class f implements sw4.g {
    @Override // sw4.g
    public void d(String str, String str2) {
        Log.d(str, str2);
    }

    @Override // sw4.g
    public void e(String str, String str2) {
        Log.e(str, str2);
    }

    @Override // sw4.g
    public void i(String str, String str2) {
        Log.i(str, str2);
    }

    @Override // sw4.g
    public boolean isColorLevel() {
        return true;
    }

    @Override // sw4.g
    public void e(String str, String str2, Throwable th5) {
        Log.e(str, str2, th5);
    }
}
