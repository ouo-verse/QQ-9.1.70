package rx3;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.tencent.ark.ark;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ \u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\r"}, d2 = {"Lrx3/f;", "", "Landroid/content/Context;", "context", "Landroid/widget/ImageView;", "imageView", "", ark.ARKMETADATA_JSON, "", "c", "f", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f432901a = new f();

    f() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(Context context, String json, final ImageView imageView) {
        Intrinsics.checkNotNullParameter(json, "$json");
        Intrinsics.checkNotNullParameter(imageView, "$imageView");
        try {
            LottieCompositionFactory.fromAsset(context, json).addListener(new LottieHelper.c(new OnCompositionLoadedListener() { // from class: rx3.e
                @Override // com.airbnb.lottie.OnCompositionLoadedListener
                public final void onCompositionLoaded(LottieComposition lottieComposition) {
                    f.e(imageView, lottieComposition);
                }
            }));
        } catch (Exception e16) {
            QLog.e("LottieUtils", 1, "loadCornerAnimation fail.", e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(ImageView imageView, LottieComposition lottieComposition) {
        Intrinsics.checkNotNullParameter(imageView, "$imageView");
        if (lottieComposition == null) {
            QLog.d("LottieUtils", 1, "onCompositionLoaded lottieComposition is null");
            return;
        }
        LottieDrawable lottieDrawable = new LottieDrawable();
        lottieDrawable.setComposition(lottieComposition);
        lottieDrawable.loop(true);
        lottieDrawable.playAnimation();
        imageView.setImageDrawable(lottieDrawable);
    }

    public final void c(@Nullable final Context context, @NotNull final ImageView imageView, @NotNull final String json) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Intrinsics.checkNotNullParameter(json, "json");
        if (context == null) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: rx3.d
            @Override // java.lang.Runnable
            public final void run() {
                f.d(context, json, imageView);
            }
        }, 16, null, true);
    }

    public final void f(@NotNull ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "imageView");
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof LottieDrawable) {
            ((LottieDrawable) drawable).stop();
        }
    }
}
