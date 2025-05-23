package uy1;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes14.dex */
public class g implements h {
    private void c(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager instanceof LinearLayoutManager) {
        } else {
            throw new IllegalStateException("StickyListHeadersDecoration can only be used with a LinearLayoutManager.");
        }
    }

    @Override // uy1.h
    public boolean a(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        c(layoutManager);
        return ((LinearLayoutManager) layoutManager).getReverseLayout();
    }

    @Override // uy1.h
    public int b(RecyclerView recyclerView) {
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        c(layoutManager);
        return ((LinearLayoutManager) layoutManager).getOrientation();
    }
}
