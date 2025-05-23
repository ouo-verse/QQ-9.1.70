package w63;

import android.graphics.BitmapShader;
import android.graphics.Color;
import android.graphics.Paint;
import hd0.c;

/* compiled from: P */
/* loaded from: classes21.dex */
public class b implements a {

    /* renamed from: e, reason: collision with root package name */
    private static final int f444680e = Color.parseColor("#FF000000");

    /* renamed from: a, reason: collision with root package name */
    public int f444681a;

    /* renamed from: b, reason: collision with root package name */
    public BitmapShader f444682b;

    /* renamed from: c, reason: collision with root package name */
    public Paint f444683c;

    /* renamed from: d, reason: collision with root package name */
    private int f444684d;

    public void a() {
        this.f444682b = null;
    }

    public void b(float f16) {
        w53.b.a("MosaicOperator", "setLineWidth... " + f16);
        this.f444684d = (int) f16;
        this.f444683c.setStrokeWidth(f16);
    }

    public void c(int i3) {
        c.a("MosaicOperator", "set MosaicSize:" + i3);
        this.f444681a = i3;
    }
}
