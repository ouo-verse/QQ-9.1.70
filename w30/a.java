package w30;

import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.immersive.QFSFlowAggregationFragment;
import com.tencent.biz.qqcircle.immersive.aggregation.widget.QFSAggregationBottomWidget;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends com.tencent.biz.qqcircle.bizparts.c {
    private QFSAggregationBottomWidget C;

    public a(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView createBlockRootView(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        QFSAggregationBottomWidget qFSAggregationBottomWidget = new QFSAggregationBottomWidget(viewGroup.getContext(), (QFSFlowAggregationFragment) getParentFragment());
        this.C = qFSAggregationBottomWidget;
        qFSAggregationBottomWidget.setParentRecyclerView(getParentRecyclerView());
        return this.C;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.c
    protected String getLogTag() {
        return null;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
