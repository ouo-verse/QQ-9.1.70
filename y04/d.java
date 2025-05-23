package y04;

import com.tencent.rmonitor.fd.dump.FdLeakDumpResult;
import com.tencent.rmonitor.fd.hook.FdOpenStackManager;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d extends a {
    @Override // y04.a
    protected FdLeakDumpResult c(String str) {
        if (FdOpenStackManager.a(str)) {
            return f(str, null);
        }
        return d(1);
    }

    @Override // w04.c
    public int getType() {
        return 4;
    }
}
