package vw3;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ams.mosaic.jsengine.animation.custom.CustomAnimation;
import com.tencent.image.ApngDrawable;
import com.tencent.libra.LoadState;
import com.tencent.libra.base.animation.decode.FrameSeqDecoder;
import com.tencent.libra.extension.gif.GifDrawable;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\u0018\u0000 <2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001fB\u000f\u0012\u0006\u0010.\u001a\u00020\u0001\u00a2\u0006\u0004\b:\u0010;J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u000e\u001a\u00020\bH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\bH\u0014J\b\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u0001H\u0016J\u0006\u0010\u001e\u001a\u00020\u0003J\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001J\u0018\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020 2\u0006\u0010\"\u001a\u00020!H\u0016J\u000e\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020!J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u0001H\u0016J \u0010*\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00012\u0006\u0010'\u001a\u00020&2\u0006\u0010)\u001a\u00020(H\u0016J\u0018\u0010+\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00012\u0006\u0010'\u001a\u00020&H\u0016R\u0016\u0010.\u001a\u00020\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010-R\u0018\u00103\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006="}, d2 = {"Lvw3/a;", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/drawable/Drawable$Callback;", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "draw", "", com.tencent.luggage.wxa.c8.c.f123400v, "setAlpha", "Landroid/graphics/ColorFilter;", CustomAnimation.KeyPath.COLOR_FILTER, "setColorFilter", "getOpacity", "Landroid/graphics/Rect;", "bounds", "onBoundsChange", "", "state", "", "onStateChange", "level", "onLevelChange", "getIntrinsicWidth", "getIntrinsicHeight", NodeProps.VISIBLE, "restart", "setVisible", "mutate", "b", "a", "Lcom/tencent/libra/LoadState;", "Lcom/tencent/libra/request/Option;", "option", "c", "who", "invalidateDrawable", "Ljava/lang/Runnable;", "what", "", RemoteMessageConst.Notification.WHEN, "scheduleDrawable", "unscheduleDrawable", "d", "Landroid/graphics/drawable/Drawable;", "mPlaceHolderDrawable", "e", "mCurrDrawable", "f", "Landroid/graphics/ColorFilter;", "mColorFilter", h.F, "I", "mAlpha", "i", "Lcom/tencent/libra/LoadState;", "mLoadState", "<init>", "(Landroid/graphics/drawable/Drawable;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a extends Drawable implements Drawable.Callback, IPicLoadStateListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Drawable mPlaceHolderDrawable;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable mCurrDrawable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ColorFilter mColorFilter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mAlpha;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LoadState mLoadState;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f443615a;

        static {
            int[] iArr = new int[LoadState.values().length];
            try {
                iArr[LoadState.STATE_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f443615a = iArr;
        }
    }

    public a(@NotNull Drawable mPlaceHolderDrawable) {
        Intrinsics.checkNotNullParameter(mPlaceHolderDrawable, "mPlaceHolderDrawable");
        this.mPlaceHolderDrawable = mPlaceHolderDrawable;
        this.mCurrDrawable = mPlaceHolderDrawable;
        this.mAlpha = 255;
        this.mLoadState = LoadState.STATE_PREPARE;
        if (mPlaceHolderDrawable != null) {
            mPlaceHolderDrawable.setCallback(this);
        }
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final Drawable getMCurrDrawable() {
        return this.mCurrDrawable;
    }

    public final void c(@NotNull Option option) {
        Drawable bitmapDrawable;
        GifDrawable gifDrawable;
        com.tencent.qqnt.emotion.pic.libra.b bVar;
        ApngDrawable apngDrawable;
        z01.a aVar;
        Intrinsics.checkNotNullParameter(option, "option");
        Drawable drawable = this.mCurrDrawable;
        if (option.getAnimatable() instanceof Drawable) {
            Object animatable = option.getAnimatable();
            Intrinsics.checkNotNull(animatable, "null cannot be cast to non-null type android.graphics.drawable.Drawable");
            bitmapDrawable = (Drawable) animatable;
            if (bitmapDrawable instanceof GifDrawable) {
                gifDrawable = (GifDrawable) bitmapDrawable;
            } else {
                gifDrawable = null;
            }
            if (gifDrawable != null) {
                gifDrawable.setBounds(getBounds());
            }
            if (bitmapDrawable instanceof com.tencent.qqnt.emotion.pic.libra.b) {
                bVar = (com.tencent.qqnt.emotion.pic.libra.b) bitmapDrawable;
            } else {
                bVar = null;
            }
            if (bVar != null) {
                bVar.setBounds(getBounds());
                invalidateSelf();
            }
            if (bitmapDrawable instanceof ApngDrawable) {
                apngDrawable = (ApngDrawable) bitmapDrawable;
            } else {
                apngDrawable = null;
            }
            if (apngDrawable != null) {
                apngDrawable.setBounds(getBounds());
                invalidateSelf();
            }
            if (bitmapDrawable instanceof z01.a) {
                aVar = (z01.a) bitmapDrawable;
            } else {
                aVar = null;
            }
            if (aVar != null) {
                aVar.d().o(new c(aVar, this));
            }
            option.getAnimatable().start();
        } else if (option.getResultBitMap() != null) {
            bitmapDrawable = new BitmapDrawable(option.getResultBitMap());
            bitmapDrawable.setBounds(getBounds());
            invalidateSelf();
        } else {
            QLog.e("SysAndEmojiLibraDrawable", 1, "[onLoadSuccess] but pic is null!");
            return;
        }
        bitmapDrawable.setCallback(this);
        this.mCurrDrawable = bitmapDrawable;
        if (drawable != null) {
            drawable.setCallback(null);
        }
        this.mPlaceHolderDrawable.setCallback(null);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Drawable drawable = this.mCurrDrawable;
        if (drawable == null) {
            drawable = this.mPlaceHolderDrawable;
        }
        drawable.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(@NotNull Drawable who) {
        Intrinsics.checkNotNullParameter(who, "who");
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    @NotNull
    public Drawable mutate() {
        Drawable drawable;
        Drawable drawable2 = this.mCurrDrawable;
        if (drawable2 != null) {
            drawable = drawable2.mutate();
        } else {
            drawable = null;
        }
        if (drawable == null) {
            return this;
        }
        return drawable;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(@NotNull Rect bounds) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            drawable.setBounds(bounds);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int level) {
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            drawable.setLevel(level);
            return false;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(@NotNull int[] state) {
        Intrinsics.checkNotNullParameter(state, "state");
        Drawable drawable = this.mCurrDrawable;
        if (drawable == null) {
            return true;
        }
        drawable.setState(state);
        return true;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(@NotNull Drawable who, @NotNull Runnable what, long when) {
        Intrinsics.checkNotNullParameter(who, "who");
        Intrinsics.checkNotNullParameter(what, "what");
        scheduleSelf(what, when);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        if (this.mAlpha != alpha) {
            this.mAlpha = alpha;
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.setAlpha(alpha);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        if (this.mColorFilter != colorFilter) {
            this.mColorFilter = colorFilter;
            Drawable drawable = this.mCurrDrawable;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean visible, boolean restart) {
        boolean visible2 = super.setVisible(visible, restart);
        Drawable drawable = this.mCurrDrawable;
        if (drawable != null) {
            drawable.setVisible(visible, restart);
        }
        return visible2;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(@NotNull Drawable who, @NotNull Runnable what) {
        Intrinsics.checkNotNullParameter(who, "who");
        Intrinsics.checkNotNullParameter(what, "what");
        unscheduleSelf(what);
    }

    @Override // com.tencent.libra.listener.IPicLoadStateListener
    public void onStateChange(@NotNull LoadState state, @NotNull Option option) {
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(option, "option");
        this.mLoadState = state;
        if (b.f443615a[state.ordinal()] == 1) {
            c(option);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"vw3/a$c", "Lcom/tencent/libra/base/animation/decode/FrameSeqDecoder$a;", "", "onStart", "Ljava/nio/ByteBuffer;", "byteBuffer", "onRender", "onEnd", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class c implements FrameSeqDecoder.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ z01.a f443616d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ a f443617e;

        c(z01.a aVar, a aVar2) {
            this.f443616d = aVar;
            this.f443617e = aVar2;
        }

        @Override // com.tencent.libra.base.animation.decode.FrameSeqDecoder.a
        public void onStart() {
            this.f443616d.setBounds(this.f443617e.getBounds());
        }

        @Override // com.tencent.libra.base.animation.decode.FrameSeqDecoder.a
        public void onEnd() {
        }

        @Override // com.tencent.libra.base.animation.decode.FrameSeqDecoder.a
        public void onRender(@Nullable ByteBuffer byteBuffer) {
        }
    }

    @NotNull
    public final IPicLoadStateListener b() {
        return this;
    }
}
