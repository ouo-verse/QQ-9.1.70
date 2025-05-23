package y20;

import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.immersive.utils.r;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private final String f449284a;

    /* renamed from: b, reason: collision with root package name */
    private int f449285b;

    /* renamed from: c, reason: collision with root package name */
    private int f449286c = -1;

    /* renamed from: d, reason: collision with root package name */
    private int f449287d = -1;

    /* renamed from: e, reason: collision with root package name */
    private boolean f449288e = true;

    public a(String str, int i3) {
        this.f449284a = str;
        this.f449285b = i3;
    }

    private boolean g(int i3) {
        if (d() == QCirclePluginUtil.isFollow(i3)) {
            return false;
        }
        this.f449285b = i3;
        int i16 = this.f449286c;
        int i17 = -1;
        if (i16 == -1) {
            return false;
        }
        if (d()) {
            i17 = 1;
        }
        this.f449286c = i16 + i17;
        return true;
    }

    private boolean h(int i3) {
        int i16 = this.f449287d;
        int i17 = -1;
        if (i16 == -1) {
            return false;
        }
        if (QCirclePluginUtil.isFollow(i3)) {
            i17 = 1;
        }
        this.f449287d = i16 + i17;
        return true;
    }

    public void a(a aVar) {
        if (!TextUtils.equals(this.f449284a, aVar.f449284a)) {
            return;
        }
        this.f449285b = aVar.f449285b;
        if (aVar.f449285b != -1) {
            this.f449287d = aVar.f449287d;
        }
        int i3 = aVar.f449286c;
        if (i3 != -1) {
            this.f449286c = i3;
        }
    }

    public int b() {
        return this.f449285b;
    }

    public String c() {
        return this.f449284a;
    }

    public boolean d() {
        return QCirclePluginUtil.isFollow(this.f449285b);
    }

    public boolean e() {
        return this.f449288e;
    }

    public boolean f(int i3) {
        if (r.v0(this.f449284a)) {
            return h(i3);
        }
        return g(i3);
    }
}
