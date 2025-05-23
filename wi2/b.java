package wi2;

import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\"(\u0010\u0007\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006\"(\u0010\u000e\u001a\u00020\t*\u00020\b2\u0006\u0010\u0002\u001a\u00020\t8F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\"\u0015\u0010\u0010\u001a\u00020\t*\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u000b\"\u0015\u0010\u0012\u001a\u00020\t*\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u000b\u00a8\u0006\u0013"}, d2 = {"Landroid/widget/TextView;", "", "value", "getTextSizeDp", "(Landroid/widget/TextView;)F", "d", "(Landroid/widget/TextView;F)V", "textSizeDp", "Landroid/view/View;", "", "getPaddings", "(Landroid/view/View;)I", "c", "(Landroid/view/View;I)V", "paddings", "b", ParseCommon.LAYOUT_PARAMS_WRAP_CONTENT, "a", ParseCommon.LAYOUT_PARAMS_MATCH_PARENT, "qq-live-widget-kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b {
    public static final int a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return -1;
    }

    public static final int b(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return -2;
    }

    public static final void c(@NotNull View view, int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setPadding(i3, i3, i3, i3);
    }

    public static final void d(@NotNull TextView textView, float f16) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setTextSize(1, f16);
    }
}
