package ur1;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.utils.x;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\f\u00a2\u0006\u0004\b\u0016\u0010\u0017J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\"\u0010\u0015\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lur1/h;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "", "d", "I", "recyclerViewWidth", "e", "getSpanCount", "()I", "setSpanCount", "(I)V", "spanCount", "<init>", "(II)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class h extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int recyclerViewWidth;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int spanCount;

    public h(int i3, int i16) {
        this.recyclerViewWidth = i3;
        this.spanCount = i16;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        int i3 = this.spanCount;
        int i16 = childAdapterPosition % i3;
        int i17 = this.recyclerViewWidth / i3;
        int a16 = x.a(76.0f);
        int i18 = i17 - a16;
        int i19 = this.recyclerViewWidth;
        int i26 = this.spanCount;
        int i27 = (i19 - (a16 * i26)) / (i26 - 1);
        if (i16 == 0) {
            outRect.left = 0;
            outRect.right = i18;
        } else if (i16 == i26 - 1) {
            outRect.left = i18;
            outRect.right = 0;
        } else {
            outRect.left = (i27 - i18) * i16;
            outRect.right = (i18 * (i16 + 1)) - (i27 * i16);
        }
        if (childAdapterPosition >= i26) {
            outRect.top = x.a(24.0f);
        }
    }
}
