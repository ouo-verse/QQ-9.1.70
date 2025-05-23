package v90;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.bizparts.c;
import com.tencent.biz.qqcircle.immersive.views.search.simpleitem.QFSSearchSmallItemResultView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import feedcloud.FeedCloudRead$StSearchMiniApp;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends c {
    private QFSSearchSmallItemResultView C;

    public a(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    protected BaseWidgetView createBlockRootView(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        QFSSearchSmallItemResultView qFSSearchSmallItemResultView = new QFSSearchSmallItemResultView(viewGroup.getContext());
        this.C = qFSSearchSmallItemResultView;
        qFSSearchSmallItemResultView.setExtraTypeInfo(getExtraTypeInfo());
        this.C.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.C.setFragment(getParentFragment());
        this.C.setSource(3);
        return this.C;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.c
    protected String getLogTag() {
        return "QFSSearchMiniAppResultBlock";
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        FeedCloudRead$StSearchMiniApp feedCloudRead$StSearchMiniApp = (FeedCloudRead$StSearchMiniApp) getItem(i3);
        if (feedCloudRead$StSearchMiniApp != null && feedCloudRead$StSearchMiniApp.items.has()) {
            this.C.setVisibility(0);
            this.C.setData(feedCloudRead$StSearchMiniApp.items.get());
            this.C.setTitle(feedCloudRead$StSearchMiniApp.title.get());
            return;
        }
        this.C.setVisibility(8);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
