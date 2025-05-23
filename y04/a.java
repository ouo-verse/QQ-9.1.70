package y04;

import android.os.SystemClock;
import com.tencent.rmonitor.common.util.FileUtil;
import com.tencent.rmonitor.fd.dump.FdLeakDumpResult;
import java.io.File;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class a implements w04.c {
    private boolean b(String str) {
        File file = new File(str);
        if (file.exists()) {
            return file.isFile();
        }
        return FileUtil.h(str);
    }

    @Override // w04.c
    public FdLeakDumpResult a(String str) {
        FdLeakDumpResult c16;
        long uptimeMillis = SystemClock.uptimeMillis();
        if (!b(str)) {
            a14.c.e("RMonitor_FdLeak_BaseFdLeakDumper", "dump failed due to invalid file path");
            c16 = e(3, str);
        } else {
            c16 = c(str);
        }
        c16.setDumpDurationMillis(SystemClock.uptimeMillis() - uptimeMillis);
        return c16;
    }

    protected abstract FdLeakDumpResult c(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public FdLeakDumpResult d(int i3) {
        return FdLeakDumpResult.failure(getType(), i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FdLeakDumpResult e(int i3, String str) {
        return FdLeakDumpResult.failure(getType(), i3, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FdLeakDumpResult f(String str, Object obj) {
        return new FdLeakDumpResult(getType(), str, obj);
    }
}
