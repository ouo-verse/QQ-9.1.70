package x0;

import android.animation.TypeEvaluator;
import android.graphics.Matrix;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes2.dex */
public class g implements TypeEvaluator<Matrix> {

    /* renamed from: a, reason: collision with root package name */
    private final float[] f446820a = new float[9];

    /* renamed from: b, reason: collision with root package name */
    private final float[] f446821b = new float[9];

    /* renamed from: c, reason: collision with root package name */
    private final Matrix f446822c = new Matrix();

    @NonNull
    public Matrix a(float f16, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
        matrix.getValues(this.f446820a);
        matrix2.getValues(this.f446821b);
        for (int i3 = 0; i3 < 9; i3++) {
            float[] fArr = this.f446821b;
            float f17 = fArr[i3];
            float f18 = this.f446820a[i3];
            fArr[i3] = f18 + ((f17 - f18) * f16);
        }
        this.f446822c.setValues(this.f446821b);
        return this.f446822c;
    }
}
