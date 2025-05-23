package ux1;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes14.dex */
public class h extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name */
    private int f440546d;

    public h(int i3) {
        this.f440546d = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.top = this.f440546d;
    }
}
