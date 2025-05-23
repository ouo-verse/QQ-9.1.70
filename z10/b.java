package z10;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes36.dex */
public class b<M> extends RecyclerView.ViewHolder {
    private SparseArray<View> E;

    public b(ViewGroup viewGroup, int i3) {
        super(LayoutInflater.from(viewGroup.getContext()).inflate(i3, viewGroup, false));
        this.E = new SparseArray<>();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Context getContext() {
        return this.itemView.getContext();
    }

    public b(View view) {
        super(view);
        this.E = new SparseArray<>();
    }

    public void l(M m3) {
    }
}
