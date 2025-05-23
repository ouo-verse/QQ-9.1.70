package zm;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0005"}, d2 = {"Landroid/view/View;", "", "padding", "", "b", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b {
    public static final void b(final View view, final int i3) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.post(new Runnable() { // from class: zm.a
            @Override // java.lang.Runnable
            public final void run() {
                b.c(view, i3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(View this_expandTouchZone, int i3) {
        Intrinsics.checkNotNullParameter(this_expandTouchZone, "$this_expandTouchZone");
        Rect rect = new Rect();
        this_expandTouchZone.getHitRect(rect);
        rect.top -= i3;
        rect.bottom += i3;
        rect.left -= i3;
        rect.right += i3;
        TouchDelegate touchDelegate = new TouchDelegate(rect, this_expandTouchZone);
        Object parent = this_expandTouchZone.getParent();
        View view = parent instanceof View ? (View) parent : null;
        if (view == null) {
            return;
        }
        view.setTouchDelegate(touchDelegate);
    }
}
