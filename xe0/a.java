package xe0;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    public static int a(RecyclerView recyclerView) {
        if (recyclerView != null) {
            try {
                if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
                    return ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();
                }
                if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
                    int columnCountForAccessibility = recyclerView.getLayoutManager().getColumnCountForAccessibility(null, null);
                    int[] iArr = new int[columnCountForAccessibility];
                    ((StaggeredGridLayoutManager) recyclerView.getLayoutManager()).findLastCompletelyVisibleItemPositions(iArr);
                    int i3 = iArr[columnCountForAccessibility - 1];
                    if (columnCountForAccessibility == 2) {
                        return Math.max(iArr[0], iArr[1]);
                    }
                    return i3;
                }
                return -1;
            } catch (Exception e16) {
                e16.printStackTrace();
                return -1;
            }
        }
        return -1;
    }
}
