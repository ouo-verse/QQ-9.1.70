package wz3;

import android.content.res.Resources;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final SimpleDateFormat f446795a = new SimpleDateFormat("yy\u5e74M\u6708d\u65e5 hh:mm:ss");

    /* renamed from: b, reason: collision with root package name */
    private static final Date f446796b = new Date();

    /* renamed from: c, reason: collision with root package name */
    private static final StringBuilder f446797c;

    /* renamed from: d, reason: collision with root package name */
    private static final Formatter f446798d;

    /* renamed from: e, reason: collision with root package name */
    private static float f446799e;

    static {
        StringBuilder sb5 = new StringBuilder();
        f446797c = sb5;
        f446798d = new Formatter(sb5, Locale.getDefault());
        f446799e = -1.0f;
    }

    public static int a(com.tencent.rfw.barrage.data.a aVar, com.tencent.rfw.barrage.data.a aVar2) {
        int u16;
        int C;
        int w3;
        int J;
        if (aVar == aVar2) {
            return 0;
        }
        if (aVar == null) {
            return -1;
        }
        if (aVar2 == null) {
            return 1;
        }
        if (aVar.equals(aVar2)) {
            return 0;
        }
        long H = aVar.H() - aVar2.H();
        if (H > 0) {
            return 1;
        }
        if (H < 0 || (u16 = aVar.u() - aVar2.u()) > 0) {
            return -1;
        }
        if (u16 < 0 || (C = aVar.C() - aVar2.C()) > 0) {
            return 1;
        }
        if (C < 0 || (w3 = aVar.w() - aVar2.w()) > 0) {
            return -1;
        }
        if (w3 < 0) {
            return 1;
        }
        long s16 = aVar.s() - aVar2.s();
        if (s16 > 0) {
            return -1;
        }
        if (s16 < 0 || (J = aVar.J() - aVar2.J()) > 0) {
            return 1;
        }
        if (J < 0) {
            return -1;
        }
        return J;
    }

    public static int b(float f16) {
        Resources a16 = g.a();
        if (f446799e < 0.0f) {
            f446799e = a16.getDisplayMetrics().density;
        }
        return (int) ((f16 * f446799e) + 0.5f);
    }

    public static boolean c() {
        return true;
    }

    public static int d(com.tencent.rfw.barrage.data.a aVar, com.tencent.rfw.barrage.data.a aVar2, long j3) {
        if (!aVar.S(j3) && !aVar2.S(j3)) {
            float[] h16 = aVar.h(aVar.q());
            float[] h17 = aVar2.h(aVar.q());
            if (h16 != null && h17 != null) {
                int G = (int) ((h17[0] - h16[2]) / aVar2.G());
                float[] h18 = aVar.h(aVar.p());
                float[] h19 = aVar2.h(aVar.p());
                if (h18 != null && h19 != null) {
                    return Math.max(G, (int) ((h19[0] - h18[2]) / aVar2.G()));
                }
                return G;
            }
        }
        return -1;
    }
}
