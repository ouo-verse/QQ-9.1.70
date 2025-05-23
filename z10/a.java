package z10;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import z10.b;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class a<M, VH extends b<M>> extends c<M, VH> {
    private List<M> F;

    /* compiled from: P */
    /* renamed from: z10.a$a, reason: collision with other inner class name */
    /* loaded from: classes36.dex */
    public interface InterfaceC11644a {
        void onItemClick(View view, int i3);
    }

    public a(Context context) {
        super(context);
        this.F = new ArrayList();
    }

    public List<M> getDataList() {
        return this.F;
    }

    public M getItem(int i3) {
        List<M> list;
        if ((this.f451718m != null && i3 == 0) || i3 >= this.F.size() + k0()) {
            return null;
        }
        if (this.f451718m == null) {
            list = this.F;
        } else {
            list = this.F;
            i3--;
        }
        return list.get(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.F.size() + j0();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i3) {
        if (this.f451718m != null && i3 == 0) {
            return 1024;
        }
        if (this.C == null || i3 != this.F.size() + k0()) {
            return u0(i3);
        }
        return 1025;
    }

    public boolean r0(List<M> list) {
        boolean addAll = this.F.addAll(list);
        if (addAll) {
            notifyItemRangeInserted(this.F.size() - list.size(), list.size());
        }
        return addAll;
    }

    public void s0() {
        this.F.clear();
        notifyDataSetChanged();
    }

    public boolean t0(List<M> list) {
        boolean z16 = !this.F.isEmpty();
        this.F.clear();
        boolean addAll = this.F.addAll(list) | z16;
        if (addAll) {
            notifyDataSetChanged();
        }
        return addAll;
    }

    public abstract int u0(int i3);
}
