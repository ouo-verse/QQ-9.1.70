package xv3;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\"\u0015\u0010\u0004\u001a\u00020\u0001*\u00020\u00008F\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0005"}, d2 = {"Landroid/view/ViewGroup;", "Landroid/view/LayoutInflater;", "a", "(Landroid/view/ViewGroup;)Landroid/view/LayoutInflater;", "layoutInflater", "ntui_kit_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class a {
    @NotNull
    public static final LayoutInflater a(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "<this>");
        LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "<get-layoutInflater>");
        return from;
    }
}
