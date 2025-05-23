package z10;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes36.dex */
public class e extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name */
    private final int f451724d;

    public e(int i3) {
        this.f451724d = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        int i3 = this.f451724d;
        rect.left = i3;
        rect.right = i3;
    }
}
