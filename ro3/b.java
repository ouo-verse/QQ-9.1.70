package ro3;

import android.content.Context;
import android.util.TypedValue;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b {
    public static int a(Context context, float f16) {
        return (int) TypedValue.applyDimension(1, f16, context.getResources().getDisplayMetrics());
    }
}
