package v34;

import android.widget.FrameLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u000b"}, d2 = {"Lv34/b;", "Lv34/a;", "Landroid/widget/FrameLayout;", "pageReserveLayout", "", "b", "Lv34/f;", "pageReserveParams", "a", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class b implements a {
    private final void b(FrameLayout pageReserveLayout) {
        pageReserveLayout.removeAllViews();
        pageReserveLayout.setVisibility(8);
    }

    @Override // v34.a
    public void a(@NotNull PageReserveParams pageReserveParams, @NotNull FrameLayout pageReserveLayout) {
        Intrinsics.checkNotNullParameter(pageReserveParams, "pageReserveParams");
        Intrinsics.checkNotNullParameter(pageReserveLayout, "pageReserveLayout");
        b(pageReserveLayout);
    }
}
