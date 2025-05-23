package uz3;

import android.graphics.Canvas;
import android.text.TextPaint;

/* compiled from: P */
/* loaded from: classes25.dex */
public class g extends f {

    /* renamed from: b, reason: collision with root package name */
    private TextPaint f440679b = new TextPaint();

    private String h(com.tencent.rfw.barrage.data.a aVar) {
        if (aVar == null) {
            return "";
        }
        return String.valueOf(aVar.l());
    }

    @Override // uz3.f
    public boolean a(com.tencent.rfw.barrage.data.a aVar) {
        return true;
    }

    @Override // uz3.f
    public wz3.a e(com.tencent.rfw.barrage.data.a aVar) {
        if (aVar == null) {
            return new wz3.a(0.0f, 0.0f);
        }
        tz3.k l3 = tz3.i.l();
        float f16 = wz3.f.f(l3.l(), h(aVar)) + l3.g() + l3.g();
        float e16 = wz3.f.e(l3.l()) + (l3.h() * 2.0f);
        aVar.j0(e16);
        aVar.k0(f16);
        return new wz3.a(f16, e16);
    }

    @Override // uz3.f
    public void f(Canvas canvas, com.tencent.rfw.barrage.data.a aVar, tz3.i iVar, float f16, float f17) {
        tz3.k l3 = tz3.i.l();
        this.f440679b.setTextSize(l3.l());
        this.f440679b.setColor(-1);
        canvas.drawText(h(aVar), f16 + l3.g(), (f17 + l3.h()) - this.f440679b.ascent(), this.f440679b);
    }
}
