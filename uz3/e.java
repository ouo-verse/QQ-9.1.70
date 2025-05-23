package uz3;

import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;

/* compiled from: P */
/* loaded from: classes25.dex */
public class e {
    public static b a(View view) {
        if (view instanceof SurfaceView) {
            return new h((SurfaceView) view);
        }
        if (view instanceof TextureView) {
            return new j((TextureView) view);
        }
        return null;
    }
}
