package we0;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.part.block.MultiViewBlock;
import com.tencent.biz.subscribe.part.block.base.a;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class a extends MultiViewBlock {
    private BaseWidgetView J;
    private boolean K;

    public a(Bundle bundle) {
        super(bundle);
        this.K = true;
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock
    public int P() {
        return 3;
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock, com.tencent.biz.subscribe.part.block.base.a, android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.K ? 1 : 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return 1;
    }

    protected abstract BaseWidgetView i0(ViewGroup viewGroup, MultiViewBlock multiViewBlock);

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        if (this.J == null) {
            this.J = i0(viewGroup, this);
        }
        return new a.C0969a(this.J);
    }

    @Override // com.tencent.biz.subscribe.part.block.MultiViewBlock, android.support.v7.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
    }
}
