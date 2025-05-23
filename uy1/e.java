package uy1;

import android.view.View;
import android.view.ViewGroup;
import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes14.dex */
public class e implements c {

    /* renamed from: a, reason: collision with root package name */
    private final i f440595a;

    /* renamed from: b, reason: collision with root package name */
    private final LongSparseArray<View> f440596b = new LongSparseArray<>();

    /* renamed from: c, reason: collision with root package name */
    private final h f440597c;

    public e(i iVar, h hVar) {
        this.f440595a = iVar;
        this.f440597c = hVar;
    }

    @Override // uy1.c
    public View a(RecyclerView recyclerView, int i3) {
        int makeMeasureSpec;
        int makeMeasureSpec2;
        long r16 = this.f440595a.r(i3);
        View view = this.f440596b.get(r16);
        if (view == null) {
            RecyclerView.ViewHolder I = this.f440595a.I(recyclerView);
            this.f440595a.d(I, i3);
            view = I.itemView;
            mw1.a.f417705a.f(view);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            if (this.f440597c.b(recyclerView) == 1) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824);
                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 0);
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 0);
                makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824);
            }
            view.measure(ViewGroup.getChildMeasureSpec(makeMeasureSpec, recyclerView.getPaddingLeft() + recyclerView.getPaddingRight(), view.getLayoutParams().width), ViewGroup.getChildMeasureSpec(makeMeasureSpec2, recyclerView.getPaddingTop() + recyclerView.getPaddingBottom(), view.getLayoutParams().height));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            this.f440596b.put(r16, view);
        }
        return view;
    }

    @Override // uy1.c
    public void invalidate() {
        this.f440596b.clear();
    }
}
