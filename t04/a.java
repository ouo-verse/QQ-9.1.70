package t04;

import com.tencent.rmonitor.fd.analysis.data.FdLeakIssueResult;
import com.tencent.rmonitor.fd.dump.FdLeakDumpResult;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a implements c {

    /* renamed from: a, reason: collision with root package name */
    private final c f435284a;

    public a(c cVar) {
        this.f435284a = cVar;
    }

    @Override // w04.b
    public void c(int i3, FdLeakDumpResult fdLeakDumpResult) {
        c cVar = this.f435284a;
        if (cVar != null) {
            cVar.c(i3, fdLeakDumpResult);
        }
    }

    @Override // t04.c
    public void e() {
        c cVar = this.f435284a;
        if (cVar != null) {
            cVar.e();
        }
    }

    @Override // w04.b
    public void g(int i3) {
        c cVar = this.f435284a;
        if (cVar != null) {
            cVar.g(i3);
        }
    }

    @Override // t04.c
    public void h(FdLeakIssueResult fdLeakIssueResult) {
        c cVar = this.f435284a;
        if (cVar != null) {
            cVar.h(fdLeakIssueResult);
        }
    }
}
