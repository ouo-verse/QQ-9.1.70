package z10;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import z10.a;
import z10.b;

/* compiled from: P */
/* loaded from: classes36.dex */
public abstract class c<M, VH extends b<M>> extends RecyclerView.Adapter<b<M>> {
    protected View C;
    protected Context D;
    protected a.InterfaceC11644a E;

    /* renamed from: m, reason: collision with root package name */
    protected View f451718m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes36.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ b f451719d;

        a(b bVar) {
            this.f451719d = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int position = this.f451719d.getPosition();
            if (position >= 0) {
                c.this.E.onItemClick(this.f451719d.itemView, position);
            }
        }
    }

    public c(Context context) {
        this.D = context;
    }

    public int j0() {
        int i3 = this.f451718m != null ? 1 : 0;
        return this.C != null ? i3 + 1 : i3;
    }

    public int k0() {
        return this.f451718m == null ? 0 : 1;
    }

    public abstract void l0(VH vh5, int i3);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public final void onBindViewHolder(b bVar, int i3) {
        int itemViewType = bVar.getItemViewType();
        if (itemViewType == 1024 || itemViewType == 1025) {
            return;
        }
        l0(bVar, i3);
    }

    public abstract VH n0(ViewGroup viewGroup, int i3);

    public void p0() {
        if (this.C != null) {
            this.C = null;
            notifyDataSetChanged();
        }
    }

    public void q0(a.InterfaceC11644a interfaceC11644a) {
        this.E = interfaceC11644a;
    }

    public void i0(View view) {
        if (view == null) {
            Log.w("HeaderAndFooterAdapter", "add the footer view is null");
        } else {
            this.C = view;
            notifyDataSetChanged();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public final b onCreateViewHolder(ViewGroup viewGroup, int i3) {
        b n06;
        if (i3 == 1024) {
            n06 = new b(this.f451718m);
        } else if (i3 == 1025) {
            n06 = new b(this.C);
        } else {
            n06 = n0(viewGroup, i3);
        }
        if (this.E != null) {
            n06.itemView.setOnClickListener(new a(n06));
        }
        return n06;
    }
}
