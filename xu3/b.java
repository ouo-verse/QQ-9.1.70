package xu3;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Landroid/view/View;", "", "b", "aio_ext_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b {
    public static final void b(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        view.setOnTouchListener(new View.OnTouchListener() { // from class: xu3.a
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean c16;
                c16 = b.c(view2, motionEvent);
                return c16;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(View view, MotionEvent motionEvent) {
        Integer num;
        if (motionEvent != null) {
            num = Integer.valueOf(motionEvent.getActionMasked());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 0) {
            if (view != null) {
                view.setAlpha(0.5f);
            }
        } else {
            boolean z16 = true;
            if ((num == null || num.intValue() != 3) && (num == null || num.intValue() != 1)) {
                z16 = false;
            }
            if (z16 && view != null) {
                view.setAlpha(1.0f);
            }
        }
        return false;
    }
}
