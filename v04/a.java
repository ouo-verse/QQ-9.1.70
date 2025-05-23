package v04;

import com.tencent.rmonitor.fd.data.FdCountable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a implements Comparable<a> {

    /* renamed from: d, reason: collision with root package name */
    private final int f440723d;

    /* renamed from: h, reason: collision with root package name */
    private List<FdCountable> f440726h;

    /* renamed from: f, reason: collision with root package name */
    private final Map<String, Integer> f440725f = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    private int f440724e = 0;

    public a(int i3) {
        this.f440723d = i3;
    }

    public void c(String str) {
        this.f440724e++;
        Integer num = this.f440725f.get(str);
        if (num == null) {
            this.f440725f.put(str, 0);
            num = 0;
        }
        this.f440725f.put(str, Integer.valueOf(num.intValue() + 1));
    }

    @Override // java.lang.Comparable
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public int compareTo(a aVar) {
        return aVar.f440724e - this.f440724e;
    }

    public int h() {
        return this.f440724e;
    }

    public Map<String, Integer> i() {
        return this.f440725f;
    }

    public List<FdCountable> j() {
        if (this.f440726h == null) {
            this.f440726h = a14.a.a(this.f440725f);
        }
        return this.f440726h;
    }

    public int k() {
        return this.f440723d;
    }

    public String toString() {
        return "FdStatisticItem{type=" + this.f440723d + ", count=" + this.f440724e + '}';
    }
}
