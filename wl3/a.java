package wl3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.collection.SparseArrayCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
    private SparseArrayCompat<View> E;

    /* compiled from: P */
    /* renamed from: wl3.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public interface InterfaceC11493a {
    }

    public a(View view) {
        super(view);
        this.E = new SparseArrayCompat<>();
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
    }

    public static a l(Context context, ViewGroup viewGroup, @LayoutRes int i3) {
        return new a(LayoutInflater.from(context).inflate(i3, viewGroup, false));
    }

    public <T extends View> T getView(int i3) {
        T t16 = (T) this.E.get(i3);
        if (t16 == null) {
            T t17 = (T) this.itemView.findViewById(i3);
            this.E.put(i3, t17);
            return t17;
        }
        return t16;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        EventCollector.getInstance().onViewLongClickedBefore(view);
        EventCollector.getInstance().onViewLongClicked(view);
        return false;
    }

    public void m(InterfaceC11493a interfaceC11493a) {
    }
}
