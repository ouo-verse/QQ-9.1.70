package yh2;

import com.tencent.mobileqq.qqguildsdk.data.IGProRoleMemberListInfo;
import com.tencent.mobileqq.qqguildsdk.engine.GPSManagerEngine;
import java.util.Collections;
import java.util.List;
import vh2.ai;
import vh2.aj;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a implements aj {

    /* renamed from: a, reason: collision with root package name */
    private final GPSManagerEngine f450329a;

    /* renamed from: b, reason: collision with root package name */
    private final String f450330b;

    /* renamed from: c, reason: collision with root package name */
    private final String f450331c;

    /* renamed from: d, reason: collision with root package name */
    private long f450332d;

    /* renamed from: e, reason: collision with root package name */
    private long f450333e;

    /* renamed from: f, reason: collision with root package name */
    private ai f450334f;

    public a(GPSManagerEngine gPSManagerEngine, String str, String str2) {
        this.f450329a = gPSManagerEngine;
        this.f450330b = str;
        this.f450331c = str2;
        e();
    }

    private void e() {
        this.f450332d = 0L;
        this.f450333e = 2L;
    }

    @Override // vh2.aj
    public void a(int i3, String str, boolean z16, long j3, long j16, boolean z17, int i16, List<IGProRoleMemberListInfo> list) {
        ai aiVar = this.f450334f;
        if (aiVar == null) {
            return;
        }
        if (i3 != 0) {
            aiVar.a(i3, str, !z16, i16, Collections.emptyList());
            return;
        }
        this.f450332d = j3;
        this.f450333e = j16;
        aiVar.a(i3, str, !z16, i16, list);
    }

    public void b(int i3, ai aiVar) {
        this.f450334f = aiVar;
        this.f450329a.ue(this.f450330b, this.f450331c, this.f450332d, this.f450333e, i3, 103, this);
    }

    public String c() {
        return this.f450331c;
    }

    public String d() {
        return this.f450330b;
    }
}
