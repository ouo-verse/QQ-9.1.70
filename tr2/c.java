package tr2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c {

    /* renamed from: k, reason: collision with root package name */
    static int[] f437171k = {1001, 1004};

    /* renamed from: l, reason: collision with root package name */
    static int[] f437172l = {-8293377, -16725252};

    /* renamed from: m, reason: collision with root package name */
    static int[] f437173m = {R.string.irt, R.string.f171535j05};

    /* renamed from: n, reason: collision with root package name */
    static int[] f437174n = {R.drawable.hvf, R.drawable.hvg};

    /* renamed from: o, reason: collision with root package name */
    static int[] f437175o = {R.string.f171534j04, R.string.j06};

    /* renamed from: p, reason: collision with root package name */
    static int f437176p = R.string.vvm;

    /* renamed from: a, reason: collision with root package name */
    public int f437177a;

    /* renamed from: b, reason: collision with root package name */
    public int f437178b;

    /* renamed from: c, reason: collision with root package name */
    public String f437179c;

    /* renamed from: d, reason: collision with root package name */
    public String f437180d;

    /* renamed from: e, reason: collision with root package name */
    public int f437181e;

    /* renamed from: f, reason: collision with root package name */
    public String f437182f;

    /* renamed from: g, reason: collision with root package name */
    public int f437183g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f437184h = false;

    /* renamed from: i, reason: collision with root package name */
    public int f437185i = 0;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList<String> f437186j;

    public static ArrayList<c> a() {
        ArrayList<c> arrayList = new ArrayList<>(2);
        for (int i3 = 0; i3 < 2; i3++) {
            c cVar = new c();
            cVar.f437177a = f437171k[i3];
            cVar.f437178b = i3;
            cVar.f437181e = f437172l[i3];
            cVar.f437179c = HardCodeUtil.qqStr(f437173m[i3]);
            cVar.f437183g = f437174n[i3];
            cVar.f437180d = HardCodeUtil.qqStr(f437175o[i3]);
            arrayList.add(cVar);
        }
        return arrayList;
    }

    public static Drawable b(Context context, c cVar) {
        switch (cVar.f437177a) {
            case 1001:
                return context.getResources().getDrawable(R.drawable.hvf);
            case 1002:
                return context.getResources().getDrawable(R.drawable.hvi);
            case 1003:
                return context.getResources().getDrawable(R.drawable.hvh);
            case 1004:
                return context.getResources().getDrawable(R.drawable.hvg);
            case 1005:
                return context.getResources().getDrawable(R.drawable.ndg);
            default:
                return null;
        }
    }

    public String c() {
        if (this.f437184h) {
            return this.f437185i + HardCodeUtil.qqStr(f437176p);
        }
        return this.f437180d;
    }

    public void d(@Nullable c cVar) {
        if (cVar == null) {
            return;
        }
        this.f437184h = cVar.f437184h;
        this.f437185i = cVar.f437185i;
        this.f437186j = cVar.f437186j;
    }
}
