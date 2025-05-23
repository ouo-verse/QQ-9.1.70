package us2;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.widget.listitem.w;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u000f\u0012\u0006\u0010\n\u001a\u00028\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H\u0014\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00028\u00008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lus2/b;", "Landroid/view/View;", "V", "Lcom/tencent/mobileqq/widget/listitem/w;", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "H", "(Landroid/view/ViewGroup;)Landroid/view/View;", "k", "Landroid/view/View;", "customView", "<init>", "(Landroid/view/View;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class b<V extends View> extends w<V> {

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final V customView;

    public b(V customView) {
        Intrinsics.checkNotNullParameter(customView, "customView");
        this.customView = customView;
    }

    @Override // com.tencent.mobileqq.widget.listitem.w
    protected V H(ViewGroup parent) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        this.customView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return this.customView;
    }
}
