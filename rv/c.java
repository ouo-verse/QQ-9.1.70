package rv;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.av.utils.ba;
import com.tencent.util.AssertUtil;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c extends e {

    /* renamed from: x, reason: collision with root package name */
    protected final Context f432536x;

    /* renamed from: y, reason: collision with root package name */
    protected final int f432537y;

    public c(Context context, int i3) {
        AssertUtil.assertNotNull(context);
        this.f432536x = context;
        this.f432537y = i3;
        H(false);
    }

    @Override // rv.e
    protected void E(Bitmap bitmap) {
        if (!com.tencent.av.opengl.texture.a.m()) {
            bitmap.recycle();
        }
    }

    @Override // rv.e
    protected Bitmap F() {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inScaled = false;
        int screenWidth = ba.getScreenWidth(this.f432536x);
        options.inSampleSize = 1;
        if (screenWidth <= 480) {
            options.inSampleSize = 2;
        }
        Resources resources = this.f432536x.getResources();
        try {
            return BitmapFactory.decodeResource(resources, this.f432537y, options);
        } catch (OutOfMemoryError unused) {
            options.inSampleSize *= 2;
            if (resources != null) {
                try {
                    return BitmapFactory.decodeResource(resources, this.f432537y, options);
                } catch (OutOfMemoryError unused2) {
                    options.inSampleSize *= 2;
                    try {
                        return BitmapFactory.decodeResource(resources, this.f432537y, options);
                    } catch (OutOfMemoryError unused3) {
                        return null;
                    }
                }
            }
            return null;
        }
    }
}
