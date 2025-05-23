package qb2;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import xb2.g;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c extends RecyclerView.Adapter<d> {

    /* renamed from: d, reason: collision with root package name */
    private BaseActivity f428783d;

    /* renamed from: e, reason: collision with root package name */
    private g f428784e;

    /* renamed from: f, reason: collision with root package name */
    private RecyclerView f428785f;

    /* renamed from: h, reason: collision with root package name */
    private int f428786h = 3;

    /* renamed from: i, reason: collision with root package name */
    private final List<ac2.d> f428787i;

    public c(BaseActivity baseActivity, RecyclerView recyclerView, List<ac2.d> list) {
        this.f428783d = baseActivity;
        this.f428785f = recyclerView;
        this.f428787i = list;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<ac2.d> list;
        if (this.f428786h != 1 && ((list = this.f428787i) == null || list.size() == 0)) {
            return 3;
        }
        List<ac2.d> list2 = this.f428787i;
        if (list2 != null) {
            return list2.size() + 2;
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (i3 == 0) {
            return 0;
        }
        if (i3 == 1) {
            return 1;
        }
        if (this.f428786h != 1) {
            List<ac2.d> list = this.f428787i;
            if (list == null || list.size() == 0) {
                return 3;
            }
            return 2;
        }
        return 2;
    }

    public void onDestroy() {
        g gVar = this.f428784e;
        if (gVar != null) {
            gVar.o();
        }
    }

    public void onResume() {
        notifyItemChanged(0);
    }

    protected boolean p(int i3) {
        if (getItemViewType(i3) == 2) {
            return false;
        }
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(d dVar, int i3) {
        int itemViewType = getItemViewType(i3);
        if (itemViewType != 0) {
            if (itemViewType != 1) {
                if (itemViewType != 2) {
                    if (itemViewType == 3) {
                        ac2.b.b(this.f428783d, dVar, this.f428786h);
                    }
                } else {
                    int i16 = i3 - 2;
                    if (i16 < this.f428787i.size()) {
                        ac2.b.c(this.f428783d, dVar, this.f428787i.get(i16), i3);
                    }
                }
            } else {
                sb2.a.a(this.f428783d, dVar);
            }
        } else {
            this.f428784e.p();
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(dVar, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public d onCreateViewHolder(ViewGroup viewGroup, int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 3) {
                    return new e(LayoutInflater.from(this.f428783d).inflate(R.layout.fpn, viewGroup, false));
                }
                return new ac2.a(LayoutInflater.from(this.f428783d).inflate(R.layout.fpo, viewGroup, false));
            }
            return new sb2.b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fph, viewGroup, false));
        }
        if (this.f428784e == null) {
            this.f428784e = new g(this.f428783d, this.f428785f, LayoutInflater.from(this.f428783d).inflate(R.layout.fpl, viewGroup, false));
        }
        return this.f428784e;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void onViewAttachedToWindow(d dVar) {
        super.onViewAttachedToWindow(dVar);
        ViewGroup.LayoutParams layoutParams = dVar.itemView.getLayoutParams();
        if (layoutParams != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) && p(dVar.getLayoutPosition())) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    public void t(int i3) {
        this.f428786h = i3;
    }
}
