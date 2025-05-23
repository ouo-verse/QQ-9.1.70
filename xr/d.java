package xr;

import android.animation.TypeEvaluator;

/* compiled from: P */
/* loaded from: classes36.dex */
public class d implements TypeEvaluator<b> {

    /* renamed from: a, reason: collision with root package name */
    private b f448427a;

    @Override // android.animation.TypeEvaluator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public b evaluate(float f16, b bVar, b bVar2) {
        float f17 = bVar.f448421a;
        float f18 = f17 + ((bVar2.f448421a - f17) * f16);
        float f19 = bVar.f448422b;
        float f26 = f19 + ((bVar2.f448422b - f19) * f16);
        float f27 = bVar.f448423c;
        float f28 = f27 + ((bVar2.f448423c - f27) * f16);
        float f29 = bVar.f448424d;
        float f36 = f29 + (f16 * (bVar2.f448424d - f29));
        b bVar3 = this.f448427a;
        if (bVar3 == null) {
            this.f448427a = new b(f18, f26, f28, f36);
        } else {
            bVar3.c(f18, f26, f28, f36);
        }
        return this.f448427a;
    }
}
