package rc;

import android.graphics.Rect;
import android.util.Pair;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.base.h;
import com.qzone.util.ar;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\f\u00a2\u0006\u0004\b\u0014\u0010\u0012J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R$\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0017"}, d2 = {"Lrc/c;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "d", "Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "getConcatAdapter", "()Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;", "setConcatAdapter", "(Lcom/tencent/biz/richframework/part/adapter/widget/RFWConcatAdapter;)V", "concatAdapter", "<init>", "e", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RFWConcatAdapter concatAdapter;

    public c(RFWConcatAdapter rFWConcatAdapter) {
        this.concatAdapter = rFWConcatAdapter;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        Intrinsics.checkNotNullParameter(outRect, "outRect");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.getItemOffsets(outRect, view, parent, state);
        int childAdapterPosition = parent.getChildAdapterPosition(view);
        RFWConcatAdapter rFWConcatAdapter = this.concatAdapter;
        Intrinsics.checkNotNull(rFWConcatAdapter);
        Pair<RecyclerView.Adapter<? extends RecyclerView.ViewHolder>, Integer> wrappedAdapterAndPosition = rFWConcatAdapter.getWrappedAdapterAndPosition(childAdapterPosition);
        Intrinsics.checkNotNullExpressionValue(wrappedAdapterAndPosition, "concatAdapter!!.getWrapp\u2026dPosition(globalPosition)");
        if (wrappedAdapterAndPosition.first instanceof h) {
            Integer albumPosition = (Integer) wrappedAdapterAndPosition.second;
            if (albumPosition.intValue() % 2 == 0) {
                outRect.left = ar.e(16.0f);
                outRect.right = ar.e(8.0f);
            } else {
                outRect.left = ar.e(8.0f);
                outRect.right = ar.e(16.0f);
            }
            Intrinsics.checkNotNullExpressionValue(albumPosition, "albumPosition");
            if (albumPosition.intValue() < 2) {
                outRect.top = ar.e(16.0f);
                outRect.bottom = ar.e(10.0f);
            } else {
                outRect.top = ar.e(10.0f);
                outRect.bottom = ar.e(10.0f);
            }
        }
    }
}
