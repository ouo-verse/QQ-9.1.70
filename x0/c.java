package x0;

import android.animation.TypeEvaluator;
import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c implements TypeEvaluator<Integer> {

    /* renamed from: a, reason: collision with root package name */
    private static final c f446815a = new c();

    @NonNull
    public static c b() {
        return f446815a;
    }

    @Override // android.animation.TypeEvaluator
    @NonNull
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer evaluate(float f16, Integer num, Integer num2) {
        int intValue = num.intValue();
        float f17 = ((intValue >> 24) & 255) / 255.0f;
        int intValue2 = num2.intValue();
        float pow = (float) Math.pow(((intValue >> 16) & 255) / 255.0f, 2.2d);
        float pow2 = (float) Math.pow(((intValue >> 8) & 255) / 255.0f, 2.2d);
        float pow3 = (float) Math.pow((intValue & 255) / 255.0f, 2.2d);
        float pow4 = (float) Math.pow(((intValue2 >> 16) & 255) / 255.0f, 2.2d);
        float f18 = f17 + (((((intValue2 >> 24) & 255) / 255.0f) - f17) * f16);
        float pow5 = pow2 + ((((float) Math.pow(((intValue2 >> 8) & 255) / 255.0f, 2.2d)) - pow2) * f16);
        float pow6 = pow3 + (f16 * (((float) Math.pow((intValue2 & 255) / 255.0f, 2.2d)) - pow3));
        return Integer.valueOf((Math.round(((float) Math.pow(pow + ((pow4 - pow) * f16), 0.45454545454545453d)) * 255.0f) << 16) | (Math.round(f18 * 255.0f) << 24) | (Math.round(((float) Math.pow(pow5, 0.45454545454545453d)) * 255.0f) << 8) | Math.round(((float) Math.pow(pow6, 0.45454545454545453d)) * 255.0f));
    }
}
