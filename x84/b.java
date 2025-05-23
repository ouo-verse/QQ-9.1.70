package x84;

import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lx84/b;", "Lx84/a;", "Lx84/e;", "adapter", "", "l", "Landroid/view/View;", "itemView", "<init>", "(Landroid/view/View;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
final class b extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }

    public void l(e adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        if (this.itemView.getLayoutParams() == null) {
            this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        int o06 = (adapter.o0() - adapter.l0()) / 2;
        ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        layoutParams.width = o06;
    }
}
