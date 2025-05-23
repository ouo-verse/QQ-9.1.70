package yl1;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lyl1/c;", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "", "onPreDraw", "Landroid/view/View;", "d", "Landroid/view/View;", "getView", "()Landroid/view/View;", "view", "Lkotlin/Function0;", "", "e", "Lkotlin/jvm/functions/Function0;", "getInvokeOnPreDraw", "()Lkotlin/jvm/functions/Function0;", "invokeOnPreDraw", "<init>", "(Landroid/view/View;Lkotlin/jvm/functions/Function0;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View view;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> invokeOnPreDraw;

    public c(@NotNull View view, @NotNull Function0<Unit> invokeOnPreDraw) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(invokeOnPreDraw, "invokeOnPreDraw");
        this.view = view;
        this.invokeOnPreDraw = invokeOnPreDraw;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        this.view.getViewTreeObserver().removeOnPreDrawListener(this);
        this.invokeOnPreDraw.invoke();
        return false;
    }
}
