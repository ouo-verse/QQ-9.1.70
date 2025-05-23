package t92;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public abstract class b<T> extends RecyclerView.Adapter<c> {
    private boolean C;

    /* renamed from: d, reason: collision with root package name */
    private int f435609d;

    /* renamed from: e, reason: collision with root package name */
    private int f435610e;

    /* renamed from: f, reason: collision with root package name */
    public List<T> f435611f;

    /* renamed from: h, reason: collision with root package name */
    protected Context f435612h;

    /* renamed from: i, reason: collision with root package name */
    protected int f435613i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f435614m;

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        if (!this.f435614m || this.f435611f.size() == 0) {
            return 1;
        }
        return this.f435611f.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (this.C && !this.f435614m) {
            return this.f435610e;
        }
        if (this.f435611f.size() == 0) {
            return this.f435609d;
        }
        return s(i3);
    }

    public abstract void p(c cVar, T t16);

    protected void q(c cVar, int i3, T t16) {
        p(cVar, this.f435611f.get(i3));
    }

    protected int r(int i3) {
        return this.f435613i;
    }

    protected int s(int i3) {
        return this.f435613i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c cVar, int i3) {
        int itemViewType = getItemViewType(i3);
        if (itemViewType != this.f435609d && itemViewType != this.f435610e) {
            q(cVar, i3, this.f435611f.get(i3));
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(cVar, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup viewGroup, int i3) {
        int i16 = this.f435610e;
        if (i3 == i16) {
            return e.d(this.f435612h, viewGroup, i16);
        }
        int i17 = this.f435609d;
        if (i3 == i17) {
            return d.d(this.f435612h, viewGroup, i17);
        }
        c b16 = c.b(this.f435612h, viewGroup, r(i3));
        b16.c(null);
        return b16;
    }
}
