package v14;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a extends RecyclerView.ItemDecoration {

    /* renamed from: d, reason: collision with root package name */
    private int f440763d;

    /* renamed from: e, reason: collision with root package name */
    private int f440764e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f440765f;

    /* renamed from: h, reason: collision with root package name */
    private int f440766h = -1;

    /* renamed from: i, reason: collision with root package name */
    private int f440767i;

    public a(int i3, int i16, boolean z16) {
        this.f440763d = i3;
        this.f440764e = i16;
        this.f440765f = z16;
    }

    public void a(int i3, int i16) {
        this.f440766h = i3;
        this.f440767i = i16;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null) {
            return;
        }
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int itemCount = adapter.getItemCount();
        int i3 = this.f440763d;
        int i16 = childAdapterPosition % i3;
        if (this.f440766h == childAdapterPosition) {
            rect.bottom = this.f440767i;
            return;
        }
        if (this.f440765f) {
            int i17 = this.f440764e;
            rect.left = i17 - ((i16 * i17) / i3);
            rect.right = ((i16 + 1) * i17) / i3;
            if (childAdapterPosition < i3) {
                rect.top = i17;
            }
            rect.bottom = i17;
            return;
        }
        int i18 = this.f440764e;
        rect.left = (i16 * i18) / i3;
        rect.right = i18 - (((i16 + 1) * i18) / i3);
        if (childAdapterPosition >= i3 && childAdapterPosition < itemCount - 1) {
            rect.top = i18;
        }
    }
}
