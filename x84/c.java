package x84;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\t\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lx84/c;", "Lx84/a;", "", "show", "", "l", "Lx84/e;", "adapter", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "E", "Landroid/view/View;", "getLoadingView", "()Landroid/view/View;", "setLoadingView", "(Landroid/view/View;)V", "loadingView", "itemView", "<init>", "(Landroid/view/View;Landroid/view/View;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
final class c extends a {

    /* renamed from: E, reason: from kotlin metadata */
    private View loadingView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(View itemView, View loadingView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(loadingView, "loadingView");
        this.loadingView = loadingView;
    }

    public void m(e adapter) {
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        if (this.itemView.getLayoutParams() == null) {
            this.itemView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        }
        int o06 = (adapter.o0() - adapter.l0()) / 2;
        ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = o06;
            layoutParams.height = -1;
        }
    }

    public final void l(boolean show) {
        if (show) {
            this.loadingView.setVisibility(0);
        } else {
            this.loadingView.setVisibility(8);
        }
    }
}
