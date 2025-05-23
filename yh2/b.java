package yh2;

import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.engine.GPSManagerEngine;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import vh2.am;
import vh2.an;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b implements an {

    /* renamed from: a, reason: collision with root package name */
    private final GPSManagerEngine f450335a;

    /* renamed from: b, reason: collision with root package name */
    private final String f450336b;

    /* renamed from: c, reason: collision with root package name */
    private final String f450337c;

    /* renamed from: d, reason: collision with root package name */
    private final String f450338d;

    /* renamed from: e, reason: collision with root package name */
    private final String f450339e;

    /* renamed from: f, reason: collision with root package name */
    private long f450340f;

    /* renamed from: g, reason: collision with root package name */
    private int f450341g;

    /* renamed from: h, reason: collision with root package name */
    private final List<IGProUserInfo> f450342h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private int f450343i;

    /* renamed from: j, reason: collision with root package name */
    private am f450344j;

    public b(GPSManagerEngine gPSManagerEngine, String str, String str2, String str3, String str4) {
        this.f450335a = gPSManagerEngine;
        this.f450336b = str;
        this.f450337c = str2;
        this.f450338d = str3;
        this.f450339e = str4;
    }

    private void g() {
        int i3 = this.f450341g + 1;
        this.f450341g = i3;
        if (i3 > 5) {
            this.f450344j.a(-3, "\u62c9\u53d6\u6b21\u6570\u8fc7\u591a", true, this.f450342h);
        } else {
            this.f450335a.xe(this.f450336b, this.f450337c, this.f450338d, this.f450339e, this.f450340f, 500, 101, this);
        }
    }

    @Override // vh2.an
    public void a(int i3, String str, long j3, boolean z16, List<IGProUserInfo> list) {
        boolean z17 = true;
        if (i3 != 0) {
            am amVar = this.f450344j;
            if (j3 == 0) {
                z17 = false;
            }
            amVar.a(i3, str, z17, Collections.emptyList());
            return;
        }
        this.f450340f = j3;
        this.f450343i -= list.size();
        this.f450342h.addAll(list);
        if (j3 != 0 && this.f450343i > 0) {
            g();
            return;
        }
        am amVar2 = this.f450344j;
        if (j3 == 0) {
            z17 = false;
        }
        amVar2.a(i3, str, z17, this.f450342h);
    }

    public void b(int i3, am amVar) {
        this.f450341g = 0;
        this.f450342h.clear();
        this.f450343i = Math.max(0, i3);
        this.f450344j = amVar;
        g();
    }

    public String c() {
        return this.f450338d;
    }

    public String d() {
        return this.f450337c;
    }

    public String e() {
        return this.f450336b;
    }

    public String f() {
        return this.f450339e;
    }
}
