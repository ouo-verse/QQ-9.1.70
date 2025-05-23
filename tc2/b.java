package tc2;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes16.dex */
public class b extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name */
    private final int f435850d;

    public b(int i3) {
        this.f435850d = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.bottom = this.f435850d;
    }
}
