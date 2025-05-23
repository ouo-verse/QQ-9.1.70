package tr2;

import android.support.annotation.Nullable;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class f implements Cloneable {

    @Nullable
    public String D;
    public long E;
    public int F;
    public int G;
    public long I;
    public long J;

    /* renamed from: d, reason: collision with root package name */
    public int f437187d;

    /* renamed from: e, reason: collision with root package name */
    public int f437188e;

    /* renamed from: i, reason: collision with root package name */
    public int f437191i;

    /* renamed from: m, reason: collision with root package name */
    public int f437192m;

    /* renamed from: f, reason: collision with root package name */
    public String f437189f = "";

    /* renamed from: h, reason: collision with root package name */
    public int f437190h = -1;
    public String C = "";
    public String H = "";
    public int K = 0;

    public boolean a() {
        int i3 = this.f437188e;
        if ((i3 == 2 || i3 == 1) && !TextUtils.isEmpty(this.f437189f)) {
            return true;
        }
        return false;
    }
}
