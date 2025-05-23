package xy3;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.crashdefend.CrashDefendManager;
import com.tencent.qqperf.safemode.SafeModeClearHelper;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a implements com.tencent.qqperf.monitor.crash.safemode.a {
    @Override // com.tencent.qqperf.monitor.crash.safemode.a
    public void a(Context context) {
        if (CrashDefendManager.i().b()) {
            SafeModeClearHelper.b(context);
        }
        QLog.d("SafeModeHelper.CommonClear", 1, "doOnSafeModeStartUp run");
    }

    @Override // com.tencent.qqperf.monitor.crash.safemode.a
    public String b() {
        return "CommonClearRunner";
    }
}
