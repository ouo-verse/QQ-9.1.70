package t92;

import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    /* renamed from: d, reason: collision with root package name */
    private RecyclerView.Adapter f435606d;

    /* renamed from: e, reason: collision with root package name */
    private SparseArrayCompat<View> f435607e = new SparseArrayCompat<>();

    /* renamed from: f, reason: collision with root package name */
    private SparseArrayCompat<View> f435608f = new SparseArrayCompat<>();

    /* compiled from: P */
    /* renamed from: t92.a$a, reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    static class C11276a extends RecyclerView.ViewHolder {
        public C11276a(View view) {
            super(view);
        }
    }

    public a(RecyclerView.Adapter adapter) {
        this.f435606d = adapter;
    }

    private int q() {
        return this.f435606d.getItemCount();
    }

    private boolean t(int i3) {
        if (i3 >= s() + q()) {
            return true;
        }
        return false;
    }

    private boolean u(int i3) {
        if (i3 < s()) {
            return true;
        }
        return false;
    }

    public void addFooterView(View view) {
        SparseArrayCompat<View> sparseArrayCompat = this.f435608f;
        sparseArrayCompat.put(sparseArrayCompat.size() + 200000, view);
    }

    public void addHeaderView(View view) {
        SparseArrayCompat<View> sparseArrayCompat = this.f435607e;
        sparseArrayCompat.put(sparseArrayCompat.size() + 100000, view);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return s() + q() + r();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (u(i3)) {
            return this.f435607e.keyAt(i3);
        }
        if (t(i3)) {
            return this.f435608f.keyAt((i3 - s()) - q());
        }
        return this.f435606d.getItemViewType(i3 - s());
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        if (!u(i3) && !t(i3)) {
            this.f435606d.onBindViewHolder(viewHolder, i3 - s());
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(viewHolder, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        if (this.f435607e.get(i3) != null) {
            return new C11276a(this.f435607e.get(i3));
        }
        if (this.f435608f.get(i3) != null) {
            return new C11276a(this.f435608f.get(i3));
        }
        return this.f435606d.onCreateViewHolder(viewGroup, i3);
    }

    public RecyclerView.Adapter p() {
        return this.f435606d;
    }

    public int r() {
        return this.f435608f.size();
    }

    public int s() {
        return this.f435607e.size();
    }
}
