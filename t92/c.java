package t92;

import android.content.Context;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    /* renamed from: d, reason: collision with root package name */
    private SparseArrayCompat<View> f435615d;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public interface a {
    }

    public c(View view) {
        super(view);
        this.f435615d = new SparseArrayCompat<>();
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
    }

    public static c b(Context context, ViewGroup viewGroup, int i3) {
        return new c(LayoutInflater.from(context).inflate(i3, viewGroup, false));
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

    public void c(a aVar) {
    }
}
