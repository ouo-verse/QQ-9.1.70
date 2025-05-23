package tt0;

import com.tencent.widget.ProcessUtil;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f437438a;

    /* renamed from: b, reason: collision with root package name */
    public String f437439b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f437440c;

    public a(String str, String str2, boolean z16) {
        this.f437438a = str;
        this.f437439b = str2;
        this.f437440c = z16;
    }

    public static a a() {
        return new a(null, ProcessUtil.getCurrentProcessNameByApplication(), false);
    }
}
