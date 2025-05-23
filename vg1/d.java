package vg1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.drawable.DrawableKt;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildContentShareApi;
import com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener;
import com.tencent.mobileqq.guild.u;
import com.tencent.mobileqq.guild.util.GuildBannerPalette;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.eh;
import com.tencent.mobileqq.vas.util.VasColorUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vg1.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 *2\u00020\u0001:\u0003\u0015\u0019!B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\"\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0017R\"\u0010\u001f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010'\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u0006+"}, d2 = {"Lvg1/d;", "Lcom/tencent/mobileqq/guild/contentshare/e;", "", "bgUrl", "", "g", "", "width", "", "i", "k", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "j", "getBackgroundColor", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/mobileqq/guild/contentshare/d;", "shareData", "Lcom/tencent/mobileqq/guild/contentshare/h;", "style", "a", "Lcom/tencent/mobileqq/guild/contentshare/f;", "Lcom/tencent/mobileqq/guild/contentshare/f;", "layoutListener", "b", "I", "getBgColor", "()I", "l", "(I)V", "bgColor", "Landroid/view/View;", "c", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "contentView", "<init>", "(Lcom/tencent/mobileqq/guild/contentshare/f;)V", "d", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d implements com.tencent.mobileqq.guild.contentshare.e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.contentshare.f layoutListener;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int bgColor;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View contentView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000f\u001a\u0004\b\t\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lvg1/d$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "url", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "()Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "<init>", "(Ljava/lang/String;Landroid/graphics/Bitmap;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: vg1.d$a, reason: from toString */
    /* loaded from: classes13.dex */
    public static final /* data */ class BgCacheItem {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String url;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final Bitmap bitmap;

        public BgCacheItem(@NotNull String url, @NotNull Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            this.url = url;
            this.bitmap = bitmap;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final Bitmap getBitmap() {
            return this.bitmap;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BgCacheItem)) {
                return false;
            }
            BgCacheItem bgCacheItem = (BgCacheItem) other;
            if (Intrinsics.areEqual(this.url, bgCacheItem.url) && Intrinsics.areEqual(this.bitmap, bgCacheItem.bitmap)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.url.hashCode() * 31) + this.bitmap.hashCode();
        }

        @NotNull
        public String toString() {
            return "BgCacheItem(url=" + this.url + ", bitmap=" + this.bitmap + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0010\u0006\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010\u000e\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0002J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0006H\u0002J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\nR\u0014\u0010\u001a\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\"\u0010!R\u0014\u0010#\u001a\u00020\u001f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0014\u0010$\u001a\u00020\u001f8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b$\u0010!R\u0014\u0010%\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b%\u0010\u001e\u00a8\u0006("}, d2 = {"Lvg1/d$b;", "", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "url", "", "width", "Lvg1/d$c;", "callback", "", "i", "picBitmap", "mainColor", "e", "containerWidth", "d", "", "scale", DomainData.DOMAIN_NAME, "g", h.F, "k", "l", "f", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "BITMAP_MAX_WIDTH_FOR_GUSSION_BLUR", "I", "BLUR_RADIUS_PX", "DEFAULT_BG_COLOR", "Ljava/lang/String;", "", "HCT_CHROMA", "D", "HCT_SHADOW", "HCT_TONE", "MAIN_COLOR_ALPHA", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: vg1.d$b, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"vg1/d$b$a", "Lcom/tencent/mobileqq/guild/picload/listener/GuildPicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: vg1.d$b$a */
        /* loaded from: classes13.dex */
        public static final class a extends GuildPicStateListener {

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f441582e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f441583f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ c f441584h;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(String str, int i3, c cVar) {
                super(false);
                this.f441582e = str;
                this.f441583f = i3;
                this.f441584h = cVar;
            }

            @Override // com.tencent.mobileqq.guild.picload.listener.GuildPicStateListener
            public void c(@Nullable LoadState state, @Nullable Option option) {
                boolean z16;
                Boolean bool;
                Boolean bool2;
                Boolean bool3;
                boolean z17 = false;
                if (state != null && state.isFinishSuccess()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                Animatable animatable = null;
                if (z16) {
                    if (option != null && option.getResultBitMap() != null) {
                        Companion companion = d.INSTANCE;
                        Bitmap resultBitMap = option.getResultBitMap();
                        Intrinsics.checkNotNullExpressionValue(resultBitMap, "option.resultBitMap");
                        companion.i(resultBitMap, this.f441582e, this.f441583f, this.f441584h);
                        return;
                    }
                    QLog.w("SquareBlurBgComponent", 1, "[loadBgPic] fail. url: " + this.f441582e);
                    this.f441584h.a(this.f441582e, null);
                    return;
                }
                if (state != null) {
                    bool = Boolean.valueOf(state.isDownloadSuccess());
                } else {
                    bool = null;
                }
                if (state != null) {
                    bool2 = Boolean.valueOf(state.isFinish());
                } else {
                    bool2 = null;
                }
                if (state != null) {
                    bool3 = Boolean.valueOf(state.isFinishError());
                } else {
                    bool3 = null;
                }
                QLog.i("SquareBlurBgComponent", 1, "[loadBgPic] onStateChangeCallback. state downloadSuccess: " + bool + ", finish: " + bool2 + ", finishErr: " + bool3 + ", url: " + this.f441582e);
                if (state != null && state.isDownloadSuccess()) {
                    z17 = true;
                }
                if (z17) {
                    if (option != null) {
                        animatable = option.getAnimatable();
                    }
                    if (animatable instanceof Drawable) {
                        QLog.i("SquareBlurBgComponent", 1, "[loadBgPic] onStateChangeCallback. pic is animatable.");
                        Object animatable2 = option.getAnimatable();
                        Intrinsics.checkNotNull(animatable2, "null cannot be cast to non-null type android.graphics.drawable.Drawable");
                        d.INSTANCE.i(DrawableKt.toBitmap$default((Drawable) animatable2, 0, 0, null, 7, null), this.f441582e, this.f441583f, this.f441584h);
                    }
                }
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Bitmap d(Bitmap bitmap, int containerWidth) {
            int width;
            if (bitmap.getWidth() > bitmap.getHeight()) {
                width = bitmap.getHeight();
            } else {
                width = bitmap.getWidth();
            }
            if (width == 0) {
                QLog.w("SquareBlurBgComponent", 1, "[cropAndScaleBitmap] cropWidth = 0, invalid bitmap!");
                return bitmap;
            }
            Bitmap croppedBitmap = Bitmap.createBitmap(bitmap, 0, 0, width, width);
            Intrinsics.checkNotNullExpressionValue(croppedBitmap, "croppedBitmap");
            return n(croppedBitmap, containerWidth / width);
        }

        private final Bitmap e(Bitmap picBitmap, int width, int mainColor) {
            Bitmap n3 = n(d(picBitmap, width), 0.5f);
            Bitmap createBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(width, widt\u2026 Bitmap.Config.ARGB_8888)");
            Canvas canvas = new Canvas(createBitmap);
            eh.a(n3, 200);
            Rect rect = new Rect(0, 0, width, width);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            canvas.drawBitmap(n3, (Rect) null, rect, paint);
            n3.recycle();
            float f16 = width;
            paint.setShader(new LinearGradient(0.0f, 0.0f, 0.0f, f16, VasColorUtil.getColorWithAlpha(0.0f, mainColor), mainColor, Shader.TileMode.CLAMP));
            canvas.drawRect(0.0f, 0.0f, f16, f16, paint);
            paint.setShader(null);
            paint.setColor(mainColor);
            paint.setAlpha(178);
            canvas.drawRect(0.0f, 0.0f, f16, f16, paint);
            return createBitmap;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int g(Bitmap bitmap) {
            vd0.b b16 = vd0.b.b(GuildBannerPalette.e(bitmap));
            b16.f(15.0d);
            b16.h(50.0d);
            return b16.i();
        }

        private final int h(Bitmap bitmap) {
            vd0.b b16 = vd0.b.b(GuildBannerPalette.e(bitmap));
            b16.h(50.0d);
            b16.f(60.0d);
            return b16.i();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void i(final Bitmap bitmap, final String url, final int width, final c callback) {
            ThreadManagerV2.excute(new Runnable() { // from class: vg1.e
                @Override // java.lang.Runnable
                public final void run() {
                    d.Companion.j(bitmap, callback, width, url);
                }
            }, 16, null, true);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void j(Bitmap bitmap, c callback, int i3, String url) {
            Intrinsics.checkNotNullParameter(bitmap, "$bitmap");
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Intrinsics.checkNotNullParameter(url, "$url");
            try {
                Companion companion = d.INSTANCE;
                callback.b(companion.h(bitmap));
                int g16 = companion.g(bitmap);
                callback.c(g16);
                callback.a(url, companion.e(bitmap, i3, g16));
            } catch (Exception e16) {
                QLog.e("SquareBlurBgComponent", 1, "[loadBgPic] exception. url: " + url + ", exception:  " + xg1.b.f447962a.l(e16));
                callback.a(url, null);
            } catch (OutOfMemoryError e17) {
                QLog.e("SquareBlurBgComponent", 1, "[loadBgPic] OutOfMemoryError. url: " + url + ", " + e17.getMessage());
                callback.a(url, null);
            } catch (Throwable th5) {
                QLog.e("SquareBlurBgComponent", 1, "[loadBgPic] exception. url: " + url + ", throwable: " + QLog.getStackTraceString(th5));
                callback.a(url, null);
            }
        }

        private final Bitmap n(Bitmap bitmap, float scale) {
            boolean z16;
            if (scale == 1.0f) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return bitmap;
            }
            Matrix matrix = new Matrix();
            matrix.preScale(scale, scale);
            Bitmap result = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
            Intrinsics.checkNotNullExpressionValue(result, "result");
            return result;
        }

        @Nullable
        public final Bitmap f(@NotNull String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            Object g16 = ImageCacheHelper.f98636a.g("SquareBlurBgComponent");
            if (g16 instanceof BgCacheItem) {
                BgCacheItem bgCacheItem = (BgCacheItem) g16;
                if (Intrinsics.areEqual(bgCacheItem.getUrl(), url)) {
                    return bgCacheItem.getBitmap();
                }
                return null;
            }
            return null;
        }

        public final void k(@NotNull String url, int width, @NotNull c callback) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(callback, "callback");
            QLog.i("SquareBlurBgComponent", 1, "loadBgPic. url: " + url);
            u.s(url, new a(url, width, callback));
        }

        public final void l(@NotNull String url, @NotNull Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            ImageCacheHelper.f98636a.i("SquareBlurBgComponent", new BgCacheItem(url, bitmap), Business.Guild);
        }

        public final void m() {
            ImageCacheHelper.f98636a.m("SquareBlurBgComponent");
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH&J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H&\u00a8\u0006\r"}, d2 = {"Lvg1/d$c;", "", "", "mainColor", "", "c", "", "url", "Landroid/graphics/Bitmap;", "blurBitmap", "a", NodeProps.SHADOW_COLOR, "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface c {
        void a(@NotNull String url, @Nullable Bitmap blurBitmap);

        void b(int shadowColor);

        void c(int mainColor);
    }

    public d(@NotNull com.tencent.mobileqq.guild.contentshare.f layoutListener) {
        Intrinsics.checkNotNullParameter(layoutListener, "layoutListener");
        this.layoutListener = layoutListener;
        this.bgColor = Color.parseColor("#6E7889");
    }

    private final boolean g(String bgUrl) {
        final Bitmap f16 = INSTANCE.f(bgUrl);
        if (f16 != null && !f16.isRecycled()) {
            QLog.i("SquareBlurBgComponent", 1, "[setContent] found cache bitmap. url: " + bgUrl);
            j(f16);
            ThreadManagerV2.excute(new Runnable() { // from class: vg1.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.h(d.this, f16);
                }
            }, 16, null, true);
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(d this$0, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.bgColor = INSTANCE.g(bitmap);
        this$0.layoutListener.a();
    }

    private final void i(String bgUrl, int width) {
        INSTANCE.k(bgUrl, width, new C11418d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j(Bitmap bitmap) {
        View view = this.contentView;
        if (view != null) {
            view.setBackground(new BitmapDrawable(view.getResources(), bitmap));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: vg1.b
            @Override // java.lang.Runnable
            public final void run() {
                d.m(d.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(d this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view = this$0.contentView;
        if (view != null) {
            view.setBackgroundColor(this$0.bgColor);
        }
    }

    @Override // com.tencent.mobileqq.guild.contentshare.g
    public void a(@NotNull ViewGroup parent, @NotNull com.tencent.mobileqq.guild.contentshare.d shareData, @Nullable com.tencent.mobileqq.guild.contentshare.h style) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(shareData, "shareData");
        this.contentView = parent;
        String firstPicUrl = ((IGuildContentShareApi) QRoute.api(IGuildContentShareApi.class)).getFirstPicUrl(shareData.getData(), shareData.getChannelInfo().getGuildId(), shareData.getWidth());
        if (!TextUtils.isEmpty(firstPicUrl)) {
            if (!g(firstPicUrl)) {
                i(firstPicUrl, shareData.getWidth());
            }
        } else {
            QLog.w("SquareBlurBgComponent", 1, "[setContent] fail. url is empty!");
            k();
        }
    }

    @Override // com.tencent.mobileqq.guild.contentshare.e
    /* renamed from: getBackgroundColor, reason: from getter */
    public int getBgColor() {
        return this.bgColor;
    }

    public final void l(int i3) {
        this.bgColor = i3;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"vg1/d$d", "Lvg1/d$c;", "", "mainColor", "", "c", "", "url", "Landroid/graphics/Bitmap;", "blurBitmap", "a", NodeProps.SHADOW_COLOR, "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: vg1.d$d, reason: collision with other inner class name */
    /* loaded from: classes13.dex */
    public static final class C11418d implements c {
        C11418d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(String url, Bitmap bitmap, d this$0) {
            Intrinsics.checkNotNullParameter(url, "$url");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            d.INSTANCE.l(url, bitmap);
            this$0.j(bitmap);
        }

        @Override // vg1.d.c
        public void a(@NotNull final String url, @Nullable final Bitmap blurBitmap) {
            Intrinsics.checkNotNullParameter(url, "url");
            if (blurBitmap == null) {
                d.this.k();
                return;
            }
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final d dVar = d.this;
            uIHandlerV2.post(new Runnable() { // from class: vg1.f
                @Override // java.lang.Runnable
                public final void run() {
                    d.C11418d.e(url, blurBitmap, dVar);
                }
            });
        }

        @Override // vg1.d.c
        public void c(int mainColor) {
            d.this.l(mainColor);
            d.this.layoutListener.a();
            d.this.k();
        }

        @Override // vg1.d.c
        public void b(int shadowColor) {
        }
    }
}
