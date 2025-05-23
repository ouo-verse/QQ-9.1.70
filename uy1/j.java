package uy1;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes14.dex */
public class j extends RecyclerView.ItemDecoration {
    private final a C;
    private final Rect D;

    /* renamed from: d, reason: collision with root package name */
    private final i f440598d;

    /* renamed from: e, reason: collision with root package name */
    private final SparseArray<Rect> f440599e;

    /* renamed from: f, reason: collision with root package name */
    private final c f440600f;

    /* renamed from: h, reason: collision with root package name */
    private final h f440601h;

    /* renamed from: i, reason: collision with root package name */
    private final b f440602i;

    /* renamed from: m, reason: collision with root package name */
    private final d f440603m;

    public j(i iVar) {
        this(iVar, new g(), new a(), null);
    }

    private void c(Rect rect, View view, int i3) {
        this.C.b(this.D, view);
        if (i3 == 1) {
            int height = view.getHeight();
            Rect rect2 = this.D;
            rect.top = height + rect2.top + rect2.bottom;
        } else {
            int width = view.getWidth();
            Rect rect3 = this.D;
            rect.left = width + rect3.left + rect3.right;
        }
    }

    public View a(RecyclerView recyclerView, int i3) {
        return this.f440600f.a(recyclerView, i3);
    }

    public void b() {
        this.f440600f.invalidate();
        this.f440599e.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        super.getItemOffsets(rect, view, recyclerView, state);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition != -1 && this.f440602i.d(childAdapterPosition, this.f440601h.a(recyclerView))) {
            c(rect, a(recyclerView, childAdapterPosition), this.f440601h.b(recyclerView));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        boolean e16;
        super.onDrawOver(canvas, recyclerView, state);
        int childCount = recyclerView.getChildCount();
        if (childCount > 0 && this.f440598d.getItemCount() > 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = recyclerView.getChildAt(i3);
                int childAdapterPosition = recyclerView.getChildAdapterPosition(childAt);
                if (childAdapterPosition != -1 && ((e16 = this.f440602i.e(childAt, this.f440601h.b(recyclerView), childAdapterPosition)) || this.f440602i.d(childAdapterPosition, this.f440601h.a(recyclerView)))) {
                    View a16 = this.f440600f.a(recyclerView, childAdapterPosition);
                    Rect rect = this.f440599e.get(childAdapterPosition);
                    if (rect == null) {
                        rect = new Rect();
                        this.f440599e.put(childAdapterPosition, rect);
                    }
                    Rect rect2 = rect;
                    this.f440602i.h(rect2, recyclerView, a16, childAt, e16);
                    this.f440603m.a(recyclerView, canvas, a16, rect2);
                }
            }
        }
    }

    j(i iVar, h hVar, a aVar, f fVar) {
        this(iVar, hVar, aVar, new d(hVar), new e(iVar, hVar), fVar);
    }

    j(i iVar, h hVar, a aVar, d dVar, c cVar, f fVar) {
        this(iVar, dVar, hVar, aVar, cVar, new b(iVar, cVar, hVar, aVar), fVar);
    }

    j(i iVar, d dVar, h hVar, a aVar, c cVar, b bVar, f fVar) {
        this.f440599e = new SparseArray<>();
        this.D = new Rect();
        this.f440598d = iVar;
        this.f440600f = cVar;
        this.f440601h = hVar;
        this.f440603m = dVar;
        this.C = aVar;
        this.f440602i = bVar;
    }
}
