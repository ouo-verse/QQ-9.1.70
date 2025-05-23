package r10;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u0011"}, d2 = {"Lr10/g;", "Landroid/support/v7/widget/LinearLayoutManager;", "Landroid/support/v7/widget/RecyclerView;", "recyclerView", "Landroid/support/v7/widget/RecyclerView$State;", "state", "", "position", "", "smoothScrollToPosition", "Landroid/content/Context;", "context", "orientation", "", "reverseLayout", "<init>", "(Landroid/content/Context;IZ)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class g extends LinearLayoutManager {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0014J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0014\u00a8\u0006\u000b"}, d2 = {"r10/g$a", "Landroid/support/v7/widget/LinearSmoothScroller;", "", "targetPos", "Landroid/graphics/PointF;", "computeScrollVectorForPosition", "getVerticalSnapPreference", "Landroid/util/DisplayMetrics;", "displayMetrics", "", "calculateSpeedPerPixel", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes36.dex */
    public static final class a extends LinearSmoothScroller {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f430484a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(LinearLayoutManager linearLayoutManager, Context context) {
            super(context);
            this.f430484a = linearLayoutManager;
        }

        @Override // android.support.v7.widget.LinearSmoothScroller
        protected float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
            Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
            return 500.0f / displayMetrics.densityDpi;
        }

        @Override // android.support.v7.widget.LinearSmoothScroller
        public PointF computeScrollVectorForPosition(int targetPos) {
            float f16 = targetPos < this.f430484a.findFirstVisibleItemPosition() ? -1.0f : targetPos > this.f430484a.findLastVisibleItemPosition() ? 1.0f : 0.0f;
            if (this.f430484a.getOrientation() == 0) {
                return new PointF(f16, 0.0f);
            }
            return new PointF(0.0f, f16);
        }

        @Override // android.support.v7.widget.LinearSmoothScroller
        protected int getVerticalSnapPreference() {
            return -1;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(Context context, int i3, boolean z16) {
        super(context, i3, z16);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int position) {
        Intrinsics.checkNotNullParameter(state, "state");
        if (recyclerView == null) {
            return;
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
        a aVar = new a((LinearLayoutManager) layoutManager, recyclerView.getContext());
        aVar.setTargetPosition(position);
        startSmoothScroll(aVar);
    }
}
