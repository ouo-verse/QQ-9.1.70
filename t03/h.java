package t03;

import android.graphics.Bitmap;
import com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder;
import com.tencent.libra.extension.gif.f;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u00052\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010&\u001a\u00020\u0002\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\u001c\u0010\u0015\u001a\u00020\u00042\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u0013H\u0016R\u0014\u0010\u0017\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0016R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u001eR\u0016\u0010!\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010\u001bR\u0016\u0010\"\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001bR\u0014\u0010%\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010$\u00a8\u0006)"}, d2 = {"Lt03/h;", "Lcom/tencent/cachedrawable/dynamicdrawable/AbsFileDecoder;", "", "path", "", "i", tl.h.F, "Ljava/io/File;", "file", "Lcom/tencent/libra/extension/gif/b;", "g", "", "index", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "Lcom/tencent/cachedrawable/dynamicdrawable/AbsFileDecoder$a;", "c", "b", "a", "Lkotlin/Function1;", "block", "e", "Ljava/lang/String;", "mFilePath", "Lcom/tencent/libra/extension/gif/b;", "mGifDecoder", "d", "I", "mFrameCount", "", "J", "mInvalidateTimeMs", "f", "mWidth", "mHeight", "", "Ljava/lang/Object;", "mLock", "filePath", "<init>", "(Ljava/lang/String;)V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class h extends AbsFileDecoder {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String mFilePath;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.libra.extension.gif.b mGifDecoder;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mFrameCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long mInvalidateTimeMs;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mWidth;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int mHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object mLock;

    public h(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        this.mFilePath = filePath;
        this.mLock = new Object();
    }

    private final com.tencent.libra.extension.gif.b g(File file) {
        try {
            return new com.tencent.libra.extension.gif.b(new f.c(file));
        } catch (Throwable th5) {
            com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.c("GIFFileDecoder", "initDecoder error : mFilePath : " + this.mFilePath, th5);
            return null;
        }
    }

    private final void h() {
        if (new File(this.mFilePath).exists()) {
            try {
                i(this.mFilePath);
                synchronized (this.mLock) {
                    com.tencent.libra.extension.gif.b bVar = this.mGifDecoder;
                    if (bVar != null) {
                        this.mWidth = bVar.e();
                        this.mHeight = bVar.c();
                        this.mInvalidateTimeMs = bVar.b(0);
                        this.mFrameCount = bVar.d();
                        Unit unit = Unit.INSTANCE;
                    }
                }
            } catch (Exception e16) {
                com.tencent.cachedrawable.dynamicdrawable.logcat.a.f99049a.c("GIFFileDecoder", "initGifDecoder error : mFilePath : " + this.mFilePath, e16);
            }
        }
    }

    private final void i(String path) {
        File file = new File(path);
        if (!file.exists()) {
            return;
        }
        this.mGifDecoder = g(file);
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder
    /* renamed from: b, reason: from getter */
    public int getMFrameCount() {
        return this.mFrameCount;
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder
    @Nullable
    public AbsFileDecoder.a c(int index, @Nullable Bitmap bitmap) {
        synchronized (this.mLock) {
            if (this.mGifDecoder == null) {
                h();
            }
            com.tencent.libra.extension.gif.b bVar = this.mGifDecoder;
            if (bVar != null) {
                if (bitmap == null) {
                    bitmap = Bitmap.createBitmap(this.mWidth, this.mHeight, Bitmap.Config.ARGB_8888);
                }
                bVar.f(index, bitmap);
                this.mInvalidateTimeMs = bVar.b(index);
                Intrinsics.checkNotNullExpressionValue(bitmap, "frameBitmap");
                return new AbsFileDecoder.a(bitmap, this.mInvalidateTimeMs);
            }
            return null;
        }
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder
    public void e(@NotNull Function1<? super AbsFileDecoder, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        block.invoke(this);
    }

    @Override // com.tencent.cachedrawable.dynamicdrawable.AbsFileDecoder
    public void a() {
    }
}
