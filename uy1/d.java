package uy1;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes14.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private final a f440592a;

    /* renamed from: b, reason: collision with root package name */
    private final h f440593b;

    /* renamed from: c, reason: collision with root package name */
    private final Rect f440594c;

    public d(h hVar) {
        this(hVar, new a());
    }

    private void b(Rect rect, RecyclerView recyclerView, View view) {
        this.f440592a.b(rect, view);
        if (this.f440593b.b(recyclerView) == 1) {
            rect.set(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), (recyclerView.getWidth() - recyclerView.getPaddingRight()) - rect.right, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            rect.set(recyclerView.getPaddingLeft(), recyclerView.getPaddingTop(), recyclerView.getWidth() - recyclerView.getPaddingRight(), (recyclerView.getHeight() - recyclerView.getPaddingBottom()) - rect.bottom);
        }
    }

    public void a(RecyclerView recyclerView, Canvas canvas, View view, Rect rect) {
        canvas.save();
        if (recyclerView.getLayoutManager().getClipToPadding()) {
            b(this.f440594c, recyclerView, view);
            canvas.clipRect(this.f440594c);
        }
        canvas.translate(rect.left, rect.top);
        view.draw(canvas);
        canvas.restore();
    }

    d(h hVar, a aVar) {
        this.f440594c = new Rect();
        this.f440593b = hVar;
        this.f440592a = aVar;
    }
}
