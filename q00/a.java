package q00;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi.util.bb;

/* compiled from: P */
/* loaded from: classes36.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private int f428146a;

    /* renamed from: b, reason: collision with root package name */
    private long f428147b;

    public static a a(String str) {
        a aVar = new a();
        if (TextUtils.isEmpty(str)) {
            return aVar;
        }
        String[] split = str.split(",");
        if (split.length != 2) {
            return aVar;
        }
        aVar.f(bb.Y(split[0], 0));
        aVar.e(bb.Z(split[1], 0L));
        return aVar;
    }

    public static String b(int i3, long j3) {
        return i3 + "," + j3;
    }

    public long c() {
        return this.f428147b;
    }

    public int d() {
        return this.f428146a;
    }

    public void e(long j3) {
        this.f428147b = j3;
    }

    public void f(int i3) {
        this.f428146a = i3;
    }
}
