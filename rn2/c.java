package rn2;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    protected AppInterface f431745a;

    /* renamed from: g, reason: collision with root package name */
    protected int f431751g;

    /* renamed from: i, reason: collision with root package name */
    protected int f431753i;

    /* renamed from: j, reason: collision with root package name */
    protected List<String> f431754j;

    /* renamed from: b, reason: collision with root package name */
    protected String f431746b = "";

    /* renamed from: c, reason: collision with root package name */
    protected String f431747c = "";

    /* renamed from: d, reason: collision with root package name */
    protected String f431748d = "";

    /* renamed from: e, reason: collision with root package name */
    protected String f431749e = "";

    /* renamed from: f, reason: collision with root package name */
    protected String f431750f = "";

    /* renamed from: h, reason: collision with root package name */
    protected int f431752h = 1;

    public c(AppInterface appInterface) {
        this.f431745a = appInterface;
    }

    public c a(String str) {
        this.f431747c = str;
        return this;
    }

    public c b(String... strArr) {
        if (this.f431754j == null) {
            this.f431754j = new ArrayList(4);
        }
        if (strArr != null) {
            Collections.addAll(this.f431754j, strArr);
        }
        return this;
    }

    public c c(String str) {
        this.f431749e = str;
        return this;
    }

    public c d(String str) {
        this.f431748d = str;
        return this;
    }

    public void e() {
        List<String> list = this.f431754j;
        if (list != null && list.size() != 0) {
            while (this.f431754j.size() < 4) {
                this.f431754j.add("");
            }
            ReportController.n(this.f431745a, this.f431746b, this.f431747c, this.f431750f, this.f431748d, this.f431749e, this.f431753i, this.f431752h, this.f431751g, this.f431754j.get(0), this.f431754j.get(1), this.f431754j.get(2), this.f431754j.get(3));
            return;
        }
        ReportController.n(this.f431745a, this.f431746b, this.f431747c, this.f431750f, this.f431748d, this.f431749e, this.f431753i, this.f431752h, this.f431751g, "", "", "", "");
    }

    public c f(String str) {
        this.f431746b = str;
        return this;
    }
}
