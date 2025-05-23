package z4;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.drawable.ImageDrawable;
import com.tencent.component.media.image.drawable.SpecifiedBitmapDrawable;

/* compiled from: P */
/* loaded from: classes36.dex */
public class d extends ImageProcessor {

    /* renamed from: d, reason: collision with root package name */
    private static volatile Matrix f451873d;

    /* renamed from: a, reason: collision with root package name */
    private int f451874a;

    /* renamed from: b, reason: collision with root package name */
    private int f451875b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f451876c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f451877a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            f451877a = iArr;
            try {
                iArr[Bitmap.Config.RGB_565.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f451877a[Bitmap.Config.ALPHA_8.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f451877a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f451877a[Bitmap.Config.ARGB_8888.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public d(int i3, int i16, boolean z16) {
        this.f451874a = i3;
        this.f451875b = i16;
        this.f451876c = z16;
    }

    public static BitmapReference createScaledBitmap(BitmapReference bitmapReference, int i3, int i16, boolean z16) {
        Matrix matrix;
        synchronized (Bitmap.class) {
            matrix = f451873d;
            f451873d = null;
        }
        if (matrix == null) {
            matrix = new Matrix();
        }
        int width = bitmapReference.getWidth();
        int height = bitmapReference.getHeight();
        matrix.setScale(i3 / width, i16 / height);
        BitmapReference createBitmap = createBitmap(bitmapReference, 0, 0, width, height, matrix, z16);
        synchronized (Bitmap.class) {
            if (f451873d == null) {
                f451873d = matrix;
            }
        }
        return createBitmap;
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    public int getType() {
        return 1;
    }

    @Override // com.tencent.component.media.image.ImageProcessor
    public Drawable process(Drawable drawable) {
        BitmapReference bitmapReference;
        if (this.f451874a <= 0 && this.f451875b <= 0) {
            return drawable;
        }
        if (drawable instanceof ImageDrawable) {
            bitmapReference = ((ImageDrawable) drawable).getBitmapRef();
        } else if (drawable instanceof SpecifiedBitmapDrawable) {
            bitmapReference = ((SpecifiedBitmapDrawable) drawable).getBitmapRef();
        } else {
            bitmapReference = drawable instanceof BitmapDrawable ? BitmapReference.getBitmapReference(((BitmapDrawable) drawable).getBitmap()) : null;
        }
        return bitmapReference == null ? drawable : new SpecifiedBitmapDrawable(getScaledBitmap(bitmapReference, this.f451874a, this.f451875b, this.f451876c));
    }

    public static BitmapReference createBitmap(BitmapReference bitmapReference, int i3, int i16, int i17, int i18, Matrix matrix, boolean z16) {
        BitmapReference bitmap;
        Paint paint;
        int i19 = i3 + i17;
        if (i19 <= bitmapReference.getWidth()) {
            int i26 = i16 + i18;
            if (i26 <= bitmapReference.getHeight()) {
                if (!bitmapReference.isMutable() && i3 == 0 && i16 == 0 && i17 == bitmapReference.getWidth() && i18 == bitmapReference.getHeight() && (matrix == null || matrix.isIdentity())) {
                    return bitmapReference;
                }
                Canvas canvas = new Canvas();
                Rect rect = new Rect(i3, i16, i19, i26);
                RectF rectF = new RectF(0.0f, 0.0f, i17, i18);
                Bitmap.Config config = Bitmap.Config.ARGB_8888;
                Bitmap.Config config2 = bitmapReference.getConfig();
                if (config2 != null) {
                    int i27 = a.f451877a[config2.ordinal()];
                    if (i27 == 1) {
                        config = Bitmap.Config.RGB_565;
                    } else if (i27 != 2) {
                        config = Bitmap.Config.ARGB_8888;
                    } else {
                        config = Bitmap.Config.ALPHA_8;
                    }
                }
                if (matrix != null && !matrix.isIdentity()) {
                    boolean z17 = !matrix.rectStaysRect();
                    RectF rectF2 = new RectF();
                    matrix.mapRect(rectF2, rectF);
                    int round = Math.round(rectF2.width());
                    int round2 = Math.round(rectF2.height());
                    ImageManager imageManager = ImageManager.getInstance();
                    if (z17) {
                        config = Bitmap.Config.ARGB_8888;
                    }
                    bitmap = imageManager.getBitmap(round, round2, config);
                    canvas.setBitmap(bitmap.getBitmap());
                    canvas.translate(-rectF2.left, -rectF2.top);
                    canvas.concat(matrix);
                    paint = new Paint();
                    paint.setFilterBitmap(z16);
                    paint.setAntiAlias(true);
                } else {
                    bitmap = ImageManager.getInstance().getBitmap(i17, i18, config);
                    canvas.setBitmap(bitmap.getBitmap());
                    paint = null;
                }
                canvas.drawBitmap(bitmapReference.getBitmap(), rect, rectF, paint);
                try {
                    canvas.setBitmap(null);
                } catch (Throwable th5) {
                    th5.printStackTrace();
                    ImageManagerEnv.getLogger().e("ScaleProcessor", "canvas.setBitmap(null) catch an exception:" + th5.getMessage());
                }
                return bitmap;
            }
            throw new IllegalArgumentException("y + height must be <= bitmap.height()");
        }
        throw new IllegalArgumentException("x + width must be <= bitmap.width()");
    }

    public static BitmapReference getScaledBitmap(BitmapReference bitmapReference, int i3, int i16, boolean z16) {
        BitmapReference bitmapReference2;
        if (bitmapReference == null) {
            return bitmapReference;
        }
        if (i3 <= 0 && i16 <= 0) {
            return bitmapReference;
        }
        if (bitmapReference.getWidth() == i3 && bitmapReference.getHeight() == i16) {
            return bitmapReference;
        }
        if (i3 <= 0) {
            i3 = bitmapReference.getWidth();
            if (z16) {
                i3 = (i3 * i16) / bitmapReference.getHeight();
            }
        } else if (i16 <= 0) {
            i16 = bitmapReference.getHeight();
            if (z16) {
                i16 = (i16 * i3) / bitmapReference.getWidth();
            }
        }
        try {
            bitmapReference2 = createScaledBitmap(bitmapReference, i3, i16, false);
        } catch (OutOfMemoryError e16) {
            e16.printStackTrace();
            bitmapReference2 = null;
        }
        return bitmapReference2 == null ? bitmapReference : bitmapReference2;
    }
}
