package w30;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.QFSFlowAggregationFragment;
import com.tencent.biz.qqcircle.immersive.aggregation.widget.QFSAggregationMusicHeadWidget;
import com.tencent.biz.qqcircle.immersive.aggregation.widget.QFSAggregationMusicHeadWidgetExp;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends com.tencent.biz.qqcircle.bizparts.c {
    private y30.a C;

    public c(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView createBlockRootView(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        if (o83.b.f422214a.a()) {
            this.C = new QFSAggregationMusicHeadWidgetExp(viewGroup.getContext(), (QFSFlowAggregationFragment) getParentFragment());
        } else {
            this.C = new QFSAggregationMusicHeadWidget(viewGroup.getContext(), (QFSFlowAggregationFragment) getParentFragment());
        }
        return (BaseWidgetView) this.C;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.c
    protected String getLogTag() {
        return null;
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        y30.a aVar = this.C;
        if (aVar != null) {
            aVar.f();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        y30.a aVar = this.C;
        if (aVar != null) {
            aVar.onActivityPause();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        y30.a aVar = this.C;
        if (aVar != null) {
            aVar.onActivityResume();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
    }
}
