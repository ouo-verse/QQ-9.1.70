package v14;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.robot.adelie.homepage.category.viewmodel.RecommendCardType;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name */
    private int f440768d;

    /* renamed from: e, reason: collision with root package name */
    private int f440769e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f440770f;

    public b(int i3, int i16, boolean z16) {
        this.f440768d = i3;
        this.f440769e = i16;
        this.f440770f = z16;
    }

    private boolean a(int i3, RecyclerView.Adapter adapter, GridLayoutManager gridLayoutManager) {
        int spanCount = gridLayoutManager.getSpanCount();
        int i16 = 0;
        for (int i17 = 0; i17 < i3; i17++) {
            i16 += gridLayoutManager.getSpanSizeLookup().getSpanSize(i17);
            if (i16 == spanCount) {
                i16 = 0;
            }
        }
        if (i16 + gridLayoutManager.getSpanSizeLookup().getSpanSize(i3) >= spanCount) {
            return false;
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null) {
            return;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        long itemViewType = adapter.getItemViewType(childAdapterPosition);
        int itemCount = adapter.getItemCount();
        int i3 = this.f440769e;
        rect.bottom = i3;
        rect.top = i3;
        if (itemViewType == RecommendCardType.REGULAR.getValue()) {
            if (a(childAdapterPosition, adapter, gridLayoutManager)) {
                rect.left = 0;
                rect.right = ViewUtils.dip2px(5.0f);
                return;
            } else {
                rect.left = ViewUtils.dip2px(5.0f);
                rect.right = 0;
                return;
            }
        }
        if (itemViewType == itemCount - 1) {
            rect.left = 0;
            rect.right = 0;
        } else {
            rect.left = 0;
            rect.right = 0;
        }
    }
}
