package t03;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.vas.ar;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001e2\u00020\u0001:\u0001\u000fB\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\r\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\nH\u0016J\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0011\u001a\u00020\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006H\u0016J\u001c\u0010\u0017\u001a\u00020\u000e2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u000e0\u0015H\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lt03/f;", "Lcom/tencent/cachedrawable/dynamicdrawable/AbsFileDecoder;", "Landroid/content/Context;", "context", "", "imagePath", "Landroid/graphics/Bitmap;", tl.h.F, "Landroid/graphics/BitmapFactory$Options;", "options", "", "reqWidth", "reqHeight", "g", "", "a", "b", "index", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Lcom/tencent/cachedrawable/dynamicdrawable/AbsFileDecoder$a;", "c", "Lkotlin/Function1;", "block", "e", "Landroid/graphics/Bitmap;", "curBitmap", "Ljava/lang/String;", "filePath", "<init>", "(Ljava/lang/String;)V", "d", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class f extends AbsFileDecoder {

    /* renamed from: e, reason: collision with root package name */
    private static final boolean f435272e = ar.INSTANCE.b("shouyouye", "2025-02-07", "vas_bugfix_137631363_2").isEnable(false);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap curBitmap;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String filePath;

    public f(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.filePath = filePath;
    }

    private final int g(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        Pair pair = TuplesKt.to(Integer.valueOf(options.outHeight), Integer.valueOf(options.outWidth));
        int intValue = ((Number) pair.component1()).intValue();
        int intValue2 = ((Number) pair.component2()).intValue();
        int i3 = 1;
        if (intValue > reqHeight || intValue2 > reqWidth) {
            int i16 = intValue / 2;
            int i17 = intValue2 / 2;
            while (i16 / i3 >= reqHeight && i17 / i3 >= reqWidth) {
                i3 *= 2;
            }
        }
        return i3;
    }

    private final Bitmap h(Context context, String imagePath) {
        float coerceAtMost;
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i3 = point.x;
        int i16 = point.y;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(imagePath, options);
        int i17 = options.outWidth;
        int i18 = options.outHeight;
        if (i17 >= i3 && i18 >= i16) {
            float f16 = i17;
            float f17 = i18;
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(i3 / f16, i16 / f17);
            if (i17 > i3) {
                i17 = (int) (f16 * coerceAtMost);
            }
            if (i18 > i16) {
                i18 = (int) (f17 * coerceAtMost);
            }
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inJustDecodeBounds = false;
            options2.inSampleSize = g(options, i17, i18);
            return BitmapFactory.decodeFile(imagePath, options2);
        }
        return BitmapFactory.decodeFile(imagePath);
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder
    public void a() {
        Bitmap bitmap = this.curBitmap;
        if (bitmap != null) {
            bitmap.recycle();
        }
        this.curBitmap = null;
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder
    /* renamed from: b */
    public int getMFrameCount() {
        return 1;
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder
    @Nullable
    public AbsFileDecoder.a c(int index, @Nullable Bitmap bitmap) {
        Bitmap bitmap2;
        if (this.curBitmap == null) {
            try {
            } catch (Exception unused) {
                com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("BitmapFileDecoder", "BitmapFactory.decodeFile error filePath = " + this.filePath);
            }
            if (new File(this.filePath).exists()) {
                if (f435272e) {
                    BaseApplication context = BaseApplication.context;
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    bitmap2 = h(context, this.filePath);
                } else {
                    bitmap2 = BitmapFactory.decodeFile(this.filePath);
                }
                this.curBitmap = bitmap2;
            } else {
                com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("BitmapFileDecoder", "BitmapFactory.decodeFile no exists filePath = " + this.filePath);
                bitmap2 = null;
                this.curBitmap = bitmap2;
            }
        }
        Bitmap bitmap3 = this.curBitmap;
        if (bitmap3 == null) {
            return null;
        }
        return new AbsFileDecoder.a(bitmap3, 0L);
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder
    public void e(@NotNull Function1<? super AbsFileDecoder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke(this);
    }
}
