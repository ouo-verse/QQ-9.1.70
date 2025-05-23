package v80;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import v80.b;

/* compiled from: P */
/* loaded from: classes4.dex */
public abstract class a<T, VH extends b<T>> extends RecyclerView.Adapter<VH> {

    /* renamed from: m, reason: collision with root package name */
    private List<? extends T> f441221m;

    public final T getItem(int i3) {
        return this.f441221m.get(i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<? extends T> list = this.f441221m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @LayoutRes
    protected abstract int i0();

    protected abstract VH j0(View view);

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public final void onBindViewHolder(@NonNull VH vh5, int i3) {
        vh5.l(getItem(i3), i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public final VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        return j0(LayoutInflater.from(viewGroup.getContext()).inflate(i0(), viewGroup, false));
    }

    public final void setData(List<? extends T> list) {
        this.f441221m = list;
        notifyDataSetChanged();
    }
}
