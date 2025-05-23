package vl3;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.collection.SparseArrayCompat;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private SparseArrayCompat<View> C = new SparseArrayCompat<>();
    private SparseArrayCompat<View> D = new SparseArrayCompat<>();

    /* renamed from: m, reason: collision with root package name */
    private RecyclerView.Adapter f441832m;

    /* compiled from: P */
    /* renamed from: vl3.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    static class C11425a extends RecyclerView.ViewHolder {
        public C11425a(View view) {
            super(view);
        }
    }

    public a(RecyclerView.Adapter adapter) {
        this.f441832m = adapter;
    }

    private int l0() {
        return this.f441832m.getItemCount();
    }

    private boolean o0(int i3) {
        if (i3 >= n0() + l0()) {
            return true;
        }
        return false;
    }

    private boolean p0(int i3) {
        if (i3 < n0()) {
            return true;
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return n0() + l0() + m0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (p0(i3)) {
            return this.C.keyAt(i3);
        }
        if (o0(i3)) {
            return this.D.keyAt((i3 - n0()) - l0());
        }
        return this.f441832m.getItemViewType(i3 - n0());
    }

    public void i0(View view) {
        SparseArrayCompat<View> sparseArrayCompat = this.D;
        sparseArrayCompat.put(sparseArrayCompat.size() + 200000, view);
    }

    public void j0(View view) {
        SparseArrayCompat<View> sparseArrayCompat = this.C;
        sparseArrayCompat.put(sparseArrayCompat.size() + 100000, view);
    }

    public RecyclerView.Adapter k0() {
        return this.f441832m;
    }

    public int m0() {
        return this.D.size();
    }

    public int n0() {
        return this.C.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f441832m.onAttachedToRecyclerView(recyclerView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        if (!p0(i3) && !o0(i3)) {
            this.f441832m.onBindViewHolder(viewHolder, i3 - n0());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        if (this.C.get(i3) != null) {
            return new C11425a(this.C.get(i3));
        }
        if (this.D.get(i3) != null) {
            return new C11425a(this.D.get(i3));
        }
        return this.f441832m.onCreateViewHolder(viewGroup, i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        this.f441832m.onDetachedFromRecyclerView(recyclerView);
    }
}
