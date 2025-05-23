package zk;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.R;
import com.tencent.widget.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0007B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\tR\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\fR\u0014\u0010\u000f\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\f\u00a8\u0006\u0015"}, d2 = {"Lzk/a;", "", "", WidgetCacheConstellationData.NUM, "", "b", "Landroid/widget/RelativeLayout;", "a", "Landroid/widget/RelativeLayout;", "()Landroid/widget/RelativeLayout;", "mRootView", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "mTabText", "c", "mRedPointView", "Landroid/view/ViewGroup;", "tabView", "<init>", "(Landroid/view/ViewGroup;)V", "d", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final RelativeLayout mRootView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final TextView mTabText;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final TextView mRedPointView;

    public a(ViewGroup tabView) {
        Intrinsics.checkNotNullParameter(tabView, "tabView");
        View inflate = LayoutInflater.from(tabView.getContext()).inflate(R.layout.cmj, tabView, false);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout = (RelativeLayout) inflate;
        this.mRootView = relativeLayout;
        View findViewById = relativeLayout.findViewById(android.R.id.text1);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(android.R.id.text1)");
        this.mTabText = (TextView) findViewById;
        View findViewById2 = relativeLayout.findViewById(R.id.njt);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById<T\u2026tView>(R.id.tv_red_point)");
        this.mRedPointView = (TextView) findViewById2;
    }

    /* renamed from: a, reason: from getter */
    public final RelativeLayout getMRootView() {
        return this.mRootView;
    }

    public final void b(int num) {
        if (num > 0) {
            d.b(this.mRedPointView, 9, num, 0);
        } else {
            this.mRedPointView.setVisibility(8);
        }
    }
}
