package xy;

import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi.view.topnav.WSTopNavigationBar;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\n\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lxy/i;", "Lb20/a;", "Landroid/view/View$OnClickListener;", "listener", "", "b", "c", "", "title", "d", "Lcom/tencent/biz/pubaccount/weishi/view/topnav/WSTopNavigationBar;", "Lcom/tencent/biz/pubaccount/weishi/view/topnav/WSTopNavigationBar;", "topNavigationBar", "<init>", "(Lcom/tencent/biz/pubaccount/weishi/view/topnav/WSTopNavigationBar;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class i extends b20.a {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final WSTopNavigationBar topNavigationBar;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(WSTopNavigationBar topNavigationBar) {
        super(topNavigationBar, R.layout.d1o);
        Intrinsics.checkNotNullParameter(topNavigationBar, "topNavigationBar");
        this.topNavigationBar = topNavigationBar;
    }

    public final void b(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.topNavigationBar.setBackBtnClickListener(listener);
    }

    public final void c(View.OnClickListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.topNavigationBar.setDetailBtnClickListener(listener);
    }

    public final void d(String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        View findViewById = super.getCenterContentView().findViewById(R.id.p99);
        Intrinsics.checkNotNullExpressionValue(findViewById, "super.centerContentView.\u2026ViewById(R.id.ws_top_nav)");
        ((TextView) findViewById).setText(title);
    }
}
