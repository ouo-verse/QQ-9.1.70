package t04;

import com.tencent.rmonitor.fd.analysis.data.FdLeakIssueResult;
import com.tencent.rmonitor.fd.dump.FdLeakDumpResult;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import u04.d;
import u04.e;
import u04.f;
import u04.g;
import u04.h;
import u04.i;
import u04.j;
import u04.k;
import u04.l;
import u04.m;
import u04.n;
import u04.o;
import u04.p;
import u04.q;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<Integer, q[]> f435285a;

    /* renamed from: b, reason: collision with root package name */
    private static final p[] f435286b;

    static {
        HashMap hashMap = new HashMap();
        f435285a = hashMap;
        hashMap.put(1, new q[]{new u04.c(), new j(), new n(), new i(), new d(), new f(), new g(), new l(), new k()});
        hashMap.put(2, new q[]{new h()});
        f435286b = new p[]{new e(), new o(), new m()};
    }

    private void a(q qVar, FdLeakIssueResult fdLeakIssueResult, FdLeakDumpResult fdLeakDumpResult) {
        fdLeakIssueResult.addAnalyzeData(qVar.a(fdLeakDumpResult));
    }

    public static q[] b(int i3) {
        return f435285a.get(Integer.valueOf(i3));
    }

    public void c(int i3, int i16, FdLeakDumpResult fdLeakDumpResult, c cVar) {
        if (cVar != null) {
            cVar.e();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(fdLeakDumpResult);
        FdLeakIssueResult fdLeakIssueResult = new FdLeakIssueResult(i3, i16);
        fdLeakIssueResult.setFdDumpList(arrayList);
        if (fdLeakDumpResult.isSuccess()) {
            for (q qVar : b(1)) {
                a(qVar, fdLeakIssueResult, fdLeakDumpResult);
            }
        }
        FdLeakDumpResult c16 = w04.a.c(2, cVar);
        arrayList.add(c16);
        if (c16.isSuccess()) {
            for (q qVar2 : b(2)) {
                a(qVar2, fdLeakIssueResult, c16);
            }
        }
        if (com.tencent.rmonitor.fd.a.f()) {
            arrayList.add(w04.a.c(4, cVar));
        }
        arrayList.add(w04.a.c(3, cVar));
        cVar.h(fdLeakIssueResult);
    }
}
