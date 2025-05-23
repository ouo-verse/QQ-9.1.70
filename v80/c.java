package v80;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.views.search.game.union.QFSSearchGameUnionView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import feedcloud.FeedCloudRead$StSearchGameCollection;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends com.tencent.biz.qqcircle.bizparts.c {
    private QFSSearchGameUnionView C;
    private boolean D;

    public c(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView createBlockRootView(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        QFSSearchGameUnionView qFSSearchGameUnionView = new QFSSearchGameUnionView(viewGroup.getContext());
        this.C = qFSSearchGameUnionView;
        qFSSearchGameUnionView.setExtraTypeInfo(getExtraTypeInfo());
        this.C.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.C.setFragment(getParentFragment());
        this.C.setParentView(viewGroup);
        return this.C;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.c
    protected String getLogTag() {
        return "QFSSearchGameUnionBlock";
    }

    public void i0(boolean z16) {
        this.D = z16;
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        if (!(this.mDataList.get(i3) instanceof FeedCloudRead$StSearchGameCollection)) {
            return;
        }
        FeedCloudRead$StSearchGameCollection feedCloudRead$StSearchGameCollection = (FeedCloudRead$StSearchGameCollection) getItem(i3);
        this.C.setBannerExist(this.D);
        this.C.setData(feedCloudRead$StSearchGameCollection.get());
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
