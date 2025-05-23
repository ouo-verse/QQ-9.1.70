package y03;

import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\n\u00a8\u0006\u000e"}, d2 = {"Ly03/b;", "", "Landroid/graphics/Bitmap;", "a", "", "width", "height", "textSize", "", "b", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap bitmap;

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Bitmap getBitmap() {
        return this.bitmap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0029, code lost:
    
        if (r0.getHeight() > (r5 + r4)) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void b(int width, int height, int textSize) {
        synchronized (this) {
            int i3 = textSize * 4;
            if (height < i3) {
                height = i3;
            }
            Bitmap bitmap = this.bitmap;
            Bitmap bitmap2 = null;
            if (bitmap != null) {
                Intrinsics.checkNotNull(bitmap);
                if (bitmap.getHeight() >= height) {
                    Bitmap bitmap3 = this.bitmap;
                    Intrinsics.checkNotNull(bitmap3);
                    if (bitmap3.getWidth() >= width) {
                        Bitmap bitmap4 = this.bitmap;
                        Intrinsics.checkNotNull(bitmap4);
                    }
                }
                Bitmap bitmap5 = this.bitmap;
                Intrinsics.checkNotNull(bitmap5);
                bitmap5.recycle();
                this.bitmap = null;
            }
            if (this.bitmap == null) {
                try {
                    bitmap2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
                } catch (OutOfMemoryError unused) {
                }
                this.bitmap = bitmap2;
            }
            Bitmap bitmap6 = this.bitmap;
            if (bitmap6 != null) {
                Intrinsics.checkNotNull(bitmap6);
                bitmap6.setDensity(MobileQQ.sMobileQQ.getResources().getDisplayMetrics().densityDpi);
            }
            Unit unit = Unit.INSTANCE;
        }
    }
}
