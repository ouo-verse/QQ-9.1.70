package vq1;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\u001a\u0016\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002\u001a\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t\"\u0015\u0010\u0010\u001a\u00020\r*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0015\u0010\u0013\u001a\u00020\u0002*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0014"}, d2 = {"", "input", "", "maxLength", "a", "", "codePoint", "", "e", "Landroid/view/View;", "view", "Landroid/graphics/Bitmap;", "b", "", "d", "(I)F", "dpf", "c", "(I)I", "dp", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {
    @NotNull
    public static final String a(@NotNull String input, int i3) {
        boolean z16;
        Intrinsics.checkNotNullParameter(input, "input");
        if (i3 > 0) {
            if (input.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                int length = input.length();
                int i16 = 0;
                for (int i17 = 0; i17 < length; i17++) {
                    i16++;
                    if (i16 > i3) {
                        int i18 = i17 - 1;
                        while (true) {
                            if (i18 < input.length()) {
                                if (!e(input.charAt(i18))) {
                                    break;
                                }
                                i18++;
                            } else {
                                i18 = -1;
                                break;
                            }
                        }
                        if (i18 != -1) {
                            String substring = input.substring(0, i18);
                            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
                            return substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                        }
                        return input;
                    }
                }
                return input;
            }
            return "";
        }
        return "";
    }

    @NotNull
    public static final Bitmap b(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.measure(View.MeasureSpec.makeMeasureSpec(ViewUtils.getScreenWidth(), Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(ViewUtils.getScreenHeight(), Integer.MIN_VALUE));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        Bitmap bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_4444);
        view.draw(new Canvas(bitmap));
        Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
        return bitmap;
    }

    public static final int c(int i3) {
        return Utils.n(i3, BaseApplication.getContext().getResources());
    }

    public static final float d(int i3) {
        return Utils.o(i3, BaseApplication.getContext().getResources());
    }

    private static final boolean e(char c16) {
        boolean z16;
        boolean z17;
        if (c16 == 0 || c16 == '\t' || c16 == '\n' || c16 == '\r') {
            return false;
        }
        if (' ' <= c16 && c16 < '\ud800') {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        if ('\ue000' <= c16 && c16 < '\ufffe') {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            return false;
        }
        return true;
    }
}
