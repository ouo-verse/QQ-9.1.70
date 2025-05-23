package uy1;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private final i f440586a;

    /* renamed from: b, reason: collision with root package name */
    private final h f440587b;

    /* renamed from: c, reason: collision with root package name */
    private final c f440588c;

    /* renamed from: d, reason: collision with root package name */
    private final a f440589d;

    /* renamed from: e, reason: collision with root package name */
    private final Rect f440590e = new Rect();

    /* renamed from: f, reason: collision with root package name */
    private final Rect f440591f = new Rect();

    public b(i iVar, c cVar, h hVar, a aVar) {
        this.f440586a = iVar;
        this.f440588c = cVar;
        this.f440587b = hVar;
        this.f440589d = aVar;
    }

    private View a(RecyclerView recyclerView, View view) {
        int i3;
        int i16;
        boolean a16 = this.f440587b.a(recyclerView);
        if (a16) {
            i3 = -1;
        } else {
            i3 = 1;
        }
        if (a16) {
            i16 = recyclerView.getChildCount() - 1;
        } else {
            i16 = 0;
        }
        while (i16 >= 0 && i16 <= recyclerView.getChildCount() - 1) {
            View childAt = recyclerView.getChildAt(i16);
            if (!j(recyclerView, childAt, view, this.f440587b.b(recyclerView))) {
                return childAt;
            }
            i16 += i3;
        }
        return null;
    }

    private int b(RecyclerView recyclerView) {
        if (recyclerView.getLayoutManager().getClipToPadding()) {
            return recyclerView.getPaddingLeft();
        }
        return 0;
    }

    private int c(RecyclerView recyclerView) {
        if (recyclerView.getLayoutManager().getClipToPadding()) {
            return recyclerView.getPaddingTop();
        }
        return 0;
    }

    private boolean f(int i3) {
        if (i3 >= 0 && i3 < this.f440586a.getItemCount()) {
            return false;
        }
        return true;
    }

    private void g(Rect rect, RecyclerView recyclerView, View view, View view2, int i3) {
        int i16;
        int i17;
        int max;
        int i18;
        this.f440589d.b(this.f440590e, view);
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            i16 = marginLayoutParams.leftMargin;
            i17 = marginLayoutParams.topMargin;
        } else {
            i16 = 0;
            i17 = 0;
        }
        if (i3 == 1) {
            max = (view2.getLeft() - i16) + this.f440590e.left;
            i18 = Math.max(((view2.getTop() - i17) - view.getHeight()) - this.f440590e.bottom, c(recyclerView) + this.f440590e.top);
        } else {
            int top = (view2.getTop() - i17) + this.f440590e.top;
            max = Math.max(((view2.getLeft() - i16) - view.getWidth()) - this.f440590e.right, b(recyclerView) + this.f440590e.left);
            i18 = top;
        }
        rect.set(max, i18, view.getWidth() + max, view.getHeight() + i18);
    }

    private boolean i(RecyclerView recyclerView, View view) {
        View a16 = a(recyclerView, view);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(a16);
        if (childAdapterPosition == -1) {
            return false;
        }
        boolean a17 = this.f440587b.a(recyclerView);
        if (childAdapterPosition > 0 && d(childAdapterPosition, a17)) {
            View a18 = this.f440588c.a(recyclerView, childAdapterPosition);
            this.f440589d.b(this.f440590e, a18);
            this.f440589d.b(this.f440591f, view);
            if (this.f440587b.b(recyclerView) == 1) {
                int top = ((a16.getTop() - this.f440590e.bottom) - a18.getHeight()) - this.f440590e.top;
                int paddingTop = recyclerView.getPaddingTop() + view.getBottom();
                Rect rect = this.f440591f;
                if (top < paddingTop + rect.top + rect.bottom) {
                    return true;
                }
            } else {
                int left = ((a16.getLeft() - this.f440590e.right) - a18.getWidth()) - this.f440590e.left;
                int paddingLeft = recyclerView.getPaddingLeft() + view.getRight();
                Rect rect2 = this.f440591f;
                if (left < paddingLeft + rect2.left + rect2.right) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean j(RecyclerView recyclerView, View view, View view2, int i3) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        this.f440589d.b(this.f440590e, view2);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (childAdapterPosition == -1 || this.f440588c.a(recyclerView, childAdapterPosition) != view2) {
            return false;
        }
        if (i3 == 1) {
            int top = view.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin;
            int c16 = c(recyclerView) + view2.getBottom();
            Rect rect = this.f440590e;
            if (top >= c16 + rect.bottom + rect.top) {
                return false;
            }
        } else {
            int left = view.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin;
            int b16 = b(recyclerView) + view2.getRight();
            Rect rect2 = this.f440590e;
            if (left >= b16 + rect2.right + rect2.left) {
                return false;
            }
        }
        return true;
    }

    private void k(RecyclerView recyclerView, int i3, Rect rect, View view, View view2, View view3) {
        this.f440589d.b(this.f440590e, view3);
        this.f440589d.b(this.f440591f, view);
        if (i3 == 1) {
            int c16 = c(recyclerView);
            Rect rect2 = this.f440591f;
            int i16 = c16 + rect2.top + rect2.bottom;
            int top = view2.getTop() - view3.getHeight();
            Rect rect3 = this.f440590e;
            int height = (((top - rect3.bottom) - rect3.top) - view.getHeight()) - i16;
            if (height < i16) {
                rect.top += height;
                return;
            }
            return;
        }
        int b16 = b(recyclerView);
        Rect rect4 = this.f440591f;
        int i17 = b16 + rect4.left + rect4.right;
        int left = view2.getLeft() - view3.getWidth();
        Rect rect5 = this.f440590e;
        int width = (((left - rect5.right) - rect5.left) - view.getWidth()) - i17;
        if (width < i17) {
            rect.left += width;
        }
    }

    public boolean d(int i3, boolean z16) {
        int i16;
        long j3;
        int i17;
        if (f(i3)) {
            return false;
        }
        long r16 = this.f440586a.r(i3);
        if (r16 < 0) {
            return false;
        }
        if (z16) {
            i16 = 1;
        } else {
            i16 = -1;
        }
        int i18 = i16 + i3;
        if (!f(i18)) {
            j3 = this.f440586a.r(i18);
        } else {
            j3 = -1;
        }
        if (z16) {
            i17 = this.f440586a.getItemCount() - 1;
        } else {
            i17 = 0;
        }
        if (i3 != i17 && r16 == j3) {
            return false;
        }
        return true;
    }

    public boolean e(View view, int i3, int i16) {
        int left;
        int i17;
        this.f440589d.b(this.f440590e, view);
        if (i3 == 1) {
            left = view.getTop();
            i17 = this.f440590e.top;
        } else {
            left = view.getLeft();
            i17 = this.f440590e.left;
        }
        if (left <= i17 && this.f440586a.r(i16) >= 0) {
            return true;
        }
        return false;
    }

    public void h(Rect rect, RecyclerView recyclerView, View view, View view2, boolean z16) {
        g(rect, recyclerView, view, view2, this.f440587b.b(recyclerView));
        if (z16 && i(recyclerView, view)) {
            View a16 = a(recyclerView, view);
            k(recyclerView, this.f440587b.b(recyclerView), rect, view, a16, this.f440588c.a(recyclerView, recyclerView.getChildAdapterPosition(a16)));
        }
    }
}
