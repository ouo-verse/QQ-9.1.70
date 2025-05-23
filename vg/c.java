package vg;

import androidx.recyclerview.widget.RecyclerView;

/* compiled from: P */
/* loaded from: classes36.dex */
public interface c {
    void c();

    void onDestroy();

    void onPaused();

    void onStop();

    void onViewHolderAttachedToWindow(RecyclerView.ViewHolder viewHolder);

    void onViewHolderDetachedFromWindow(RecyclerView.ViewHolder viewHolder);
}
