package t03;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.image.j;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.aspectj.lang.JoinPoint;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0002\b\n\u0018\u0000 T2\u00020\u0001:\u0001\u0015B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\bR\u0010SJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J,\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u00102\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002J\u001c\u0010\u0014\u001a\u00020\u00022\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016J\b\u0010\u0016\u001a\u00020\rH\u0016J\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0017\u001a\u00020\r2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0004R\"\u0010\"\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010(\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u0010,\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010#\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R\"\u0010/\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010#\u001a\u0004\b-\u0010%\"\u0004\b.\u0010'R$\u00103\u001a\u00020\r2\u0006\u00100\u001a\u00020\r8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b1\u0010#\u001a\u0004\b2\u0010%R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0014\u0010:\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u00108R\u0016\u0010=\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010<R\"\u0010C\u001a\u00020;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010<\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\"\u0010F\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010#\u001a\u0004\bD\u0010%\"\u0004\bE\u0010'R\u0018\u0010H\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010GR\u0016\u0010J\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010<R\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010Q\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010P\u00a8\u0006U"}, d2 = {"Lt03/c;", "Lcom/tencent/cachedrawable/dynamicdrawable/AbsFileDecoder;", "", "l", "", "filePath", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "j", "Landroid/content/Context;", "context", "", "originalWidth", "originalHeight", "Lkotlin/Pair;", "i", "Lkotlin/Function1;", "block", "e", "a", "b", "index", "Lcom/tencent/cachedrawable/dynamicdrawable/AbsFileDecoder$a;", "c", "toString", "finalize", "", "[I", "getMImageInfo", "()[I", "setMImageInfo", "([I)V", "mImageInfo", "I", "getMWidth", "()I", "setMWidth", "(I)V", "mWidth", "d", "getMHeight", "setMHeight", "mHeight", "getMCurIndex", "setMCurIndex", "mCurIndex", "<set-?>", "f", "getMFrameCount", "mFrameCount", "g", "Ljava/lang/String;", "Landroid/graphics/Paint;", tl.h.F, "Landroid/graphics/Paint;", "paint", "paintTransparentBlack", "", "J", "nativeFrameInfoInstance", "k", "getNativeImageInstance", "()J", "setNativeImageInstance", "(J)V", "nativeImageInstance", "getDecryptType", "setDecryptType", "decryptType", "Landroid/graphics/Bitmap;", "mCurrentFrameBitmap", DomainData.DOMAIN_NAME, "currentFrameDelay", "", "o", "Ljava/lang/Object;", JoinPoint.SYNCHRONIZATION_LOCK, "p", "Z", "isInitSuccess", "<init>", "(Ljava/lang/String;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c extends AbsFileDecoder {

    /* renamed from: r, reason: collision with root package name */
    private static final boolean f435252r = ar.INSTANCE.b("shouyouye", "2025-02-07", "vas_bugfix_137631363_APNG").isEnable(true);

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private int[] mImageInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int mWidth;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mHeight;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mCurIndex;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mFrameCount;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String filePath;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paintTransparentBlack;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private volatile long nativeFrameInfoInstance;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private long nativeImageInstance;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private int decryptType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap mCurrentFrameBitmap;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private long currentFrameDelay;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Object lock;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isInitSuccess;

    public c(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.mImageInfo = new int[7];
        this.mCurIndex = -1;
        this.filePath = filePath;
        this.paint = new Paint();
        this.paintTransparentBlack = new Paint();
        this.lock = new Object();
    }

    private final Pair<Integer, Integer> i(Context context, int originalWidth, int originalHeight) {
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i3 = point.x;
        int i16 = point.y;
        if (originalWidth <= i3 && originalHeight <= i16) {
            return new Pair<>(Integer.valueOf(originalWidth), Integer.valueOf(originalHeight));
        }
        float f16 = originalWidth;
        float f17 = originalHeight;
        float min = Math.min(i3 / f16, i16 / f17);
        return new Pair<>(Integer.valueOf((int) (f16 * min)), Integer.valueOf((int) (f17 * min)));
    }

    private final boolean j(Bitmap bitmap) {
        this.nativeFrameInfoInstance = ApngImage.nativeGetNextFrame(this.nativeImageInstance, this.nativeFrameInfoInstance, bitmap, this.mImageInfo);
        int[] iArr = this.mImageInfo;
        int i3 = iArr[5];
        if (i3 == 0) {
            this.mWidth = iArr[0];
            this.mHeight = iArr[1];
            this.mFrameCount = iArr[2];
            this.mCurIndex = iArr[3];
            this.currentFrameDelay = iArr[4];
            this.mCurrentFrameBitmap = bitmap;
            return true;
        }
        com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("APNGFileDecoder", "start decode error: " + i3);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(Function1 block, c this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(block, "$block");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            block.invoke(this$0);
        }
    }

    private final void l() {
        if (com.tencent.mobileqq.vas.image.f.f309589a.isApngSoLoaded()) {
            m(this.filePath);
        } else {
            com.tencent.mobileqq.vas.image.f.f309589a.a(new j.a() { // from class: t03.b
                @Override // com.tencent.mobileqq.vas.image.j.a
                public final void onResult(boolean z16) {
                    c.n(c.this, z16);
                }
            });
        }
    }

    private final void m(String filePath) {
        synchronized (this.lock) {
            File file = new File(filePath);
            if (!file.exists()) {
                return;
            }
            this.paint.setAntiAlias(true);
            this.paintTransparentBlack.setAntiAlias(true);
            this.paintTransparentBlack.setColor(0);
            this.nativeImageInstance = ApngImage.nativeStartDecode(file.getAbsolutePath(), this.mImageInfo, this.decryptType);
            int[] iArr = this.mImageInfo;
            int i3 = iArr[5];
            if (i3 == 0) {
                this.mWidth = iArr[0];
                this.mHeight = iArr[1];
                if (f435252r) {
                    BaseApplication context = BaseApplication.context;
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    Pair<Integer, Integer> i16 = i(context, this.mWidth, this.mHeight);
                    this.mWidth = i16.getFirst().intValue();
                    this.mHeight = i16.getSecond().intValue();
                }
                this.mFrameCount = this.mImageInfo[2];
                this.isInitSuccess = true;
            } else {
                com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("APNGFileDecoder", "start decode error: " + i3);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(c this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            this$0.m(this$0.filePath);
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder
    public void a() {
        finalize();
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder
    /* renamed from: b, reason: from getter */
    public int getMFrameCount() {
        return this.mFrameCount;
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder
    @Nullable
    public AbsFileDecoder.a c(int index, @Nullable Bitmap bitmap) {
        int i3;
        int i16;
        Bitmap bitmap2;
        int i17;
        Bitmap bitmap3;
        if (!this.isInitSuccess) {
            l();
        }
        if (this.isInitSuccess && (i3 = this.mWidth) > 0 && (i16 = this.mHeight) > 0) {
            if (index == this.mCurIndex && (bitmap3 = this.mCurrentFrameBitmap) != null) {
                Intrinsics.checkNotNull(bitmap3);
                return new AbsFileDecoder.a(bitmap3, this.currentFrameDelay);
            }
            if (bitmap == null) {
                try {
                    try {
                        bitmap = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
                    } catch (OutOfMemoryError unused) {
                        bitmap = Bitmap.createBitmap(this.mWidth, this.mHeight, Bitmap.Config.ARGB_8888);
                    }
                } catch (OutOfMemoryError unused2) {
                    com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.b("APNGFileDecoder", "APNG create Bitmap OOM");
                    return null;
                }
            }
            if (bitmap != null) {
                while (true) {
                    boolean z16 = true;
                    if (index != 0 && (i17 = this.mCurIndex) >= index && i17 != this.mFrameCount - 1) {
                        break;
                    }
                    if (index < 0 || index >= this.mFrameCount) {
                        z16 = false;
                    }
                    if (!z16 || !j(bitmap)) {
                        return null;
                    }
                    if (index == this.mCurIndex && (bitmap2 = this.mCurrentFrameBitmap) != null) {
                        Intrinsics.checkNotNull(bitmap2);
                        return new AbsFileDecoder.a(bitmap2, this.currentFrameDelay);
                    }
                }
            } else {
                return null;
            }
        }
        return null;
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder
    public void e(@NotNull final Function1<? super AbsFileDecoder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (!com.tencent.mobileqq.vas.image.f.f309589a.isApngSoLoaded()) {
            com.tencent.mobileqq.vas.image.f.f309589a.a(new j.a() { // from class: t03.a
                @Override // com.tencent.mobileqq.vas.image.j.a
                public final void onResult(boolean z16) {
                    c.k(Function1.this, this, z16);
                }
            });
        } else {
            block.invoke(this);
        }
    }

    protected final void finalize() throws Throwable {
        if (this.nativeFrameInfoInstance != 0) {
            ApngImage.nativeFreeFrame(this.nativeFrameInfoInstance);
        }
        long j3 = this.nativeImageInstance;
        if (j3 != 0) {
            ApngImage.nativeFreeImage(j3);
        }
    }

    @NotNull
    public String toString() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.US, "Size: %dx%d, %d frames, error: %d", Arrays.copyOf(new Object[]{Integer.valueOf(this.mImageInfo[0]), Integer.valueOf(this.mImageInfo[1]), Integer.valueOf(this.mImageInfo[2]), Integer.valueOf(this.mImageInfo[3])}, 4));
        Intrinsics.checkNotNullExpressionValue(format, "format(locale, format, *args)");
        return format;
    }
}
