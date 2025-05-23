package ua;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

/* compiled from: P */
/* loaded from: classes36.dex */
public class c implements b {
    private boolean c(LinearLayoutManager linearLayoutManager) {
        int findFirstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
        return ((linearLayoutManager instanceof GridLayoutManager) && findFirstVisibleItemPosition < 15) || findFirstVisibleItemPosition < b();
    }

    @Override // ua.b
    public boolean a(RecyclerView recyclerView) {
        if (recyclerView.getLayoutManager() instanceof LinearLayoutManager) {
            return c((LinearLayoutManager) recyclerView.getLayoutManager());
        }
        if (recyclerView.getLayoutManager() instanceof StaggeredGridLayoutManager) {
            return d((StaggeredGridLayoutManager) recyclerView.getLayoutManager());
        }
        return false;
    }

    protected int b() {
        throw null;
    }

    private boolean d(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        int columnCountForAccessibility = staggeredGridLayoutManager.getColumnCountForAccessibility(null, null);
        if (columnCountForAccessibility == 1) {
            int[] iArr = new int[1];
            staggeredGridLayoutManager.findFirstVisibleItemPositions(iArr);
            return iArr[0] <= 16;
        }
        int[] iArr2 = new int[columnCountForAccessibility];
        staggeredGridLayoutManager.findFirstVisibleItemPositions(iArr2);
        return iArr2[0] <= columnCountForAccessibility * 3;
    }
}
