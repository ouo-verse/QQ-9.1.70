package uu0;

import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0010\"(\u0010\u0007\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00018F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006\"\u0015\u0010\f\u001a\u00020\t*\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\"\u0015\u0010\u000e\u001a\u00020\t*\u00020\b8F\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000b\"\u0015\u0010\u0011\u001a\u00020\t*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\u00018F\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u0015\u0010\u0014\u001a\u00020\u0001*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0015\u0010\u0011\u001a\u00020\t*\u00020\t8F\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u0019"}, d2 = {"Landroid/widget/TextView;", "", "value", "getTextSizeDp", "(Landroid/widget/TextView;)F", "g", "(Landroid/widget/TextView;F)V", "textSizeDp", "Landroid/view/View;", "", "f", "(Landroid/view/View;)I", ParseCommon.LAYOUT_PARAMS_WRAP_CONTENT, "e", ParseCommon.LAYOUT_PARAMS_MATCH_PARENT, "a", "(F)I", "dp", "c", "(F)F", "dpf", "d", "(I)F", "b", "(I)I", "ic-game-timi-game-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a {
    public static final int a(float f16) {
        return Utils.n(f16, BaseApplication.getContext().getResources());
    }

    public static final int b(int i3) {
        return Utils.n(i3, BaseApplication.getContext().getResources());
    }

    public static final float c(float f16) {
        return Utils.o(f16, BaseApplication.getContext().getResources());
    }

    public static final float d(int i3) {
        return Utils.o(i3, BaseApplication.getContext().getResources());
    }

    public static final int e(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return -1;
    }

    public static final int f(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        return -2;
    }

    public static final void g(@NotNull TextView textView, float f16) {
        Intrinsics.checkNotNullParameter(textView, "<this>");
        textView.setTextSize(1, f16);
    }
}
