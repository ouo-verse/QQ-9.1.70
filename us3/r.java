package us3;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import java.text.DecimalFormat;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\"\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bJ\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\bJ\u0016\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f\u00a8\u0006\u0014"}, d2 = {"Lus3/r;", "", "Landroid/content/Context;", "context", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "b", "Landroid/widget/ImageView;", "view", "", "url", "", "d", "path", "", "c", "Lcom/tencent/gamecenter/wadl/biz/entity/WadlResult;", "result", "a", "<init>", "()V", "minibox-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final r f440004a = new r();

    r() {
    }

    @JvmStatic
    @NotNull
    public static final URLDrawable.URLDrawableOptions b(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        URLDrawable.URLDrawableOptions options = URLDrawable.URLDrawableOptions.obtain();
        Drawable drawable = ResourcesCompat.getDrawable(context.getResources(), R.drawable.n0j, null);
        options.mFailedDrawable = drawable;
        options.mLoadingDrawable = drawable;
        Intrinsics.checkNotNullExpressionValue(options, "options");
        return options;
    }

    @NotNull
    public final String a(@NotNull Context context, @NotNull WadlResult result) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(result, "result");
        String b16 = s.f440005a.b();
        long j3 = result.speed;
        float f16 = 1024;
        float f17 = (((float) j3) / f16) / f16;
        long j16 = ((float) (result.fileSize - result.downloadFileSize)) / ((float) j3);
        DecimalFormat decimalFormat = new DecimalFormat("0.0");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String string = context.getString(R.string.f16532288);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026_download_detain_content)");
        StringBuilder sb5 = new StringBuilder();
        sb5.append(j16);
        sb5.append('s');
        String format = String.format(string, Arrays.copyOf(new Object[]{b16, decimalFormat.format(f17) + " MB/s", sb5.toString()}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    public final boolean c(@NotNull String path) {
        boolean startsWith$default;
        boolean startsWith$default2;
        Intrinsics.checkNotNullParameter(path, "path");
        if (!TextUtils.isEmpty(path)) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(path, "https://", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(path, "http://", false, 2, null);
                if (!startsWith$default2) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public final void d(@Nullable Context context, @NotNull ImageView view, @Nullable String url) {
        URLDrawable fileDrawable;
        Intrinsics.checkNotNullParameter(view, "view");
        if (!TextUtils.isEmpty(url) && context != null && url != null) {
            try {
                URLDrawable.URLDrawableOptions b16 = b(context);
                if (f440004a.c(url)) {
                    fileDrawable = URLDrawable.getDrawable(url, b16);
                } else {
                    fileDrawable = URLDrawable.getFileDrawable(url, b16);
                }
                view.setImageDrawable(fileDrawable);
            } catch (Throwable th5) {
                QLog.e("MiniBoxUIHelper", 1, "[setUrlDrawable] err:" + th5.getMessage());
            }
        }
    }
}
