package u04;

import com.tencent.rmonitor.fd.analysis.data.FdLeakIssue;
import com.tencent.rmonitor.fd.dump.FdLeakDumpResult;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class a<T> implements q {
    public static boolean e(FdLeakDumpResult fdLeakDumpResult) {
        if (fdLeakDumpResult != null && fdLeakDumpResult.isSuccess() && fdLeakDumpResult.getData() != null) {
            return true;
        }
        a14.c.d("RMonitor_FdLeak_BaseFdAnalyzer", "analyze failed due to invalid dump data");
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // u04.q
    public FdLeakIssue a(FdLeakDumpResult fdLeakDumpResult) {
        if (!e(fdLeakDumpResult)) {
            return null;
        }
        FdLeakIssue fdLeakIssue = new FdLeakIssue(b());
        fdLeakIssue.setFeatures(a14.a.a(d(fdLeakDumpResult.getData())));
        return fdLeakIssue;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(Map<String, Integer> map, String str) {
        Integer num = map.get(str);
        if (num == null) {
            num = 0;
            map.put(str, num);
        }
        map.put(str, Integer.valueOf(num.intValue() + 1));
    }

    protected abstract Map<String, Integer> d(T t16);
}
