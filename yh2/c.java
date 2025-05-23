package yh2;

import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import com.tencent.mobileqq.qqguildsdk.engine.GPSManagerEngine;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import vh2.ar;
import vh2.as;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c implements as {

    /* renamed from: a, reason: collision with root package name */
    private final GPSManagerEngine f450345a;

    /* renamed from: b, reason: collision with root package name */
    private final String f450346b;

    /* renamed from: c, reason: collision with root package name */
    private final String f450347c;

    /* renamed from: d, reason: collision with root package name */
    private final String f450348d;

    /* renamed from: e, reason: collision with root package name */
    private final String f450349e;

    /* renamed from: f, reason: collision with root package name */
    private long f450350f;

    /* renamed from: g, reason: collision with root package name */
    private int f450351g;

    /* renamed from: h, reason: collision with root package name */
    private final List<IGProUserInfo> f450352h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private int f450353i;

    /* renamed from: j, reason: collision with root package name */
    private int f450354j;

    /* renamed from: k, reason: collision with root package name */
    private ar f450355k;

    public c(GPSManagerEngine gPSManagerEngine, String str, String str2, String str3, String str4) {
        this.f450345a = gPSManagerEngine;
        this.f450346b = str;
        this.f450347c = str2;
        this.f450348d = str3;
        this.f450349e = str4;
    }

    private void g() {
        int i3 = this.f450351g + 1;
        this.f450351g = i3;
        if (i3 > 5) {
            this.f450355k.a(-3, "\u62c9\u53d6\u6b21\u6570\u8fc7\u591a", 0, true, Collections.emptyList());
        } else {
            this.f450345a.De(this.f450346b, this.f450347c, this.f450348d, this.f450349e, this.f450350f, this.f450354j, this);
        }
    }

    @Override // vh2.as
    public void a(int i3, String str, int i16, boolean z16, long j3, List<IGProUserInfo> list) {
        if (i3 != 0) {
            this.f450355k.a(i3, str, i16, !z16, Collections.emptyList());
            return;
        }
        this.f450350f = j3;
        this.f450353i -= list.size();
        this.f450352h.addAll(list);
        if (!z16 && this.f450353i > 0) {
            g();
        } else {
            this.f450355k.a(i3, str, i16, !z16, this.f450352h);
        }
    }

    public void b(int i3, ar arVar) {
        this.f450351g = 0;
        this.f450352h.clear();
        this.f450353i = Math.max(0, i3);
        this.f450354j = Math.max(0, i3);
        this.f450355k = arVar;
        g();
    }

    public String c() {
        return this.f450348d;
    }

    public String d() {
        return this.f450347c;
    }

    public String e() {
        return this.f450346b;
    }

    public String f() {
        return this.f450349e;
    }
}
