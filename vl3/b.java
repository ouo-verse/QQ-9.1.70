package vl3;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.component.core.thread.ThreadCenter;
import com.tencent.mobileqq.R;
import java.util.List;
import wl3.c;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class b<T> extends RecyclerView.Adapter<wl3.a> implements ThreadCenter.HandlerKeyable {
    public List<T> D;
    protected Context E;
    protected int F;

    /* renamed from: m, reason: collision with root package name */
    private int f441833m = R.layout.i3o;
    private int C = R.layout.i3p;
    private boolean G = true;
    private boolean H = false;

    public b(Context context, @LayoutRes int i3, List<T> list) throws IllegalArgumentException {
        if (context != null) {
            this.E = context;
            this.F = i3;
            this.D = list;
            return;
        }
        throw new IllegalArgumentException(" context is null !!!");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (!this.G || this.D.size() == 0) {
            return 1;
        }
        return this.D.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (this.H && !this.G) {
            return this.C;
        }
        if (this.D.size() == 0) {
            return this.f441833m;
        }
        return m0(i3);
    }

    public abstract void i0(wl3.a aVar, T t16);

    protected void j0(wl3.a aVar, int i3, T t16) {
        i0(aVar, this.D.get(i3));
    }

    public void k0() {
        this.D.clear();
        notifyDataSetChanged();
    }

    protected int l0(int i3) {
        return this.F;
    }

    protected int m0(int i3) {
        return this.F;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(wl3.a aVar, int i3) {
        int itemViewType = getItemViewType(i3);
        if (itemViewType != this.f441833m && itemViewType != this.C) {
            j0(aVar, i3, this.D.get(i3));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(wl3.a aVar, int i3, List<Object> list) {
        if (list.isEmpty()) {
            onBindViewHolder(aVar, i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        ThreadCenter.clear(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public wl3.a onCreateViewHolder(ViewGroup viewGroup, int i3) {
        int i16 = this.C;
        if (i3 == i16) {
            return c.n(this.E, viewGroup, i16);
        }
        int i17 = this.f441833m;
        if (i3 == i17) {
            return wl3.b.n(this.E, viewGroup, i17);
        }
        wl3.a l3 = wl3.a.l(this.E, viewGroup, l0(i3));
        l3.m(null);
        return l3;
    }

    public void q0(@LayoutRes int i3) {
        this.f441833m = i3;
    }

    public void setData(List<T> list) {
        updateData(list);
    }

    void updateData(List<T> list) {
        if (list == null) {
            return;
        }
        this.D.clear();
        this.D.addAll(list);
    }
}
