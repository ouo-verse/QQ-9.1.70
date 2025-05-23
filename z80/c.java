package z80;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.views.search.hotrank.QFSSearchHotRankView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.richframework.data.base.UIStateData;
import feedcloud.FeedCloudRead$StSearchHotEventInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends com.tencent.biz.qqcircle.bizparts.c {
    private QFSSearchHotRankView C;

    public c(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.c
    protected String getLogTag() {
        return "QFSSearchHotRankBlock";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public QFSSearchHotRankView createBlockRootView(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        QFSSearchHotRankView qFSSearchHotRankView = new QFSSearchHotRankView(viewGroup.getContext());
        this.C = qFSSearchHotRankView;
        qFSSearchHotRankView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.C.setExtraTypeInfo(getExtraTypeInfo());
        this.C.setFragment(getParentFragment());
        return this.C;
    }

    public LiveData<UIStateData<List<e30.b>>> j0() {
        QFSSearchHotRankView qFSSearchHotRankView = this.C;
        if (qFSSearchHotRankView != null) {
            return qFSSearchHotRankView.u0();
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        this.C.setData((FeedCloudRead$StSearchHotEventInfo) this.mDataList.get(i3), i3);
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        QFSSearchHotRankView qFSSearchHotRankView = this.C;
        if (qFSSearchHotRankView != null) {
            qFSSearchHotRankView.a();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        QFSSearchHotRankView qFSSearchHotRankView = this.C;
        if (qFSSearchHotRankView != null) {
            qFSSearchHotRankView.onActivityPause();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        QFSSearchHotRankView qFSSearchHotRankView = this.C;
        if (qFSSearchHotRankView != null) {
            qFSSearchHotRankView.onActivityResume();
        }
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
