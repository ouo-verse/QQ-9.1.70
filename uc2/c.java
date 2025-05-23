package uc2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import uc2.c.a;

/* compiled from: P */
/* loaded from: classes16.dex */
public abstract class c<M, VH extends a<M>> extends RecyclerView.Adapter<VH> {
    private List<M> C = new ArrayList();
    protected Context D;

    /* renamed from: m, reason: collision with root package name */
    protected b f438781m;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public static class a<M> extends RecyclerView.ViewHolder {
        public a(View view) {
            super(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    public interface b {
        void onItemClick(View view, int i3);
    }

    public c(Context context) {
        this.D = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n0(a aVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        b bVar = this.f438781m;
        if (bVar != null) {
            bVar.onItemClick(aVar.itemView, aVar.getAdapterPosition());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public M getItem(int i3) {
        return this.C.get(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.C.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemViewType(int i3) {
        return m0(i3);
    }

    public void j0() {
        this.C.clear();
        notifyDataSetChanged();
    }

    public boolean k0(List<M> list) {
        boolean z16 = !this.C.isEmpty();
        this.C.clear();
        boolean addAll = this.C.addAll(list) | z16;
        if (addAll) {
            notifyDataSetChanged();
        }
        return addAll;
    }

    public abstract int m0(int i3);

    public abstract void o0(VH vh5, int i3);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p0, reason: merged with bridge method [inline-methods] */
    public final void onBindViewHolder(@NonNull VH vh5, int i3) {
        o0(vh5, i3);
    }

    public abstract VH q0(ViewGroup viewGroup, int i3);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public final VH onCreateViewHolder(ViewGroup viewGroup, int i3) {
        final VH q06 = q0(viewGroup, i3);
        if (this.f438781m != null) {
            q06.itemView.setOnClickListener(new View.OnClickListener() { // from class: uc2.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c.this.n0(q06, view);
                }
            });
        }
        return q06;
    }

    public void s0(b bVar) {
        this.f438781m = bVar;
    }

    public int l0(int i3) {
        return i3;
    }
}
