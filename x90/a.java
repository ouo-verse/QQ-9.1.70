package x90;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.bizparts.c;
import com.tencent.biz.qqcircle.immersive.bean.QFSSearchInfo;
import com.tencent.biz.qqcircle.immersive.views.search.simpleitem.QFSSearchQueryFixResultItemView;
import com.tencent.biz.richframework.part.block.MultiViewBlock;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import feedcloud.FeedCloudRead$StCorrectionInfo;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends c {
    private QFSSearchQueryFixResultItemView C;
    private QFSSearchInfo D;
    private com.tencent.biz.qqcircle.immersive.search.a E;

    public a(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.c
    protected String getLogTag() {
        return "QFSSearchBannerResultBlock";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public QFSSearchQueryFixResultItemView createBlockRootView(ViewGroup viewGroup, MultiViewBlock multiViewBlock) {
        QFSSearchQueryFixResultItemView qFSSearchQueryFixResultItemView = new QFSSearchQueryFixResultItemView(viewGroup.getContext());
        this.C = qFSSearchQueryFixResultItemView;
        qFSSearchQueryFixResultItemView.setExtraTypeInfo(getExtraTypeInfo());
        this.C.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.C.setFragment(getParentFragment());
        this.C.setSearchInfo(this.D);
        return this.C;
    }

    @Override // com.tencent.biz.richframework.part.extendsblock.SingleViewBlock, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i3) {
        List<E> list = this.mDataList;
        if (list == 0 || i3 < 0 || list.size() <= i3 || this.C == null || !(this.mDataList.get(i3) instanceof FeedCloudRead$StCorrectionInfo)) {
            return;
        }
        this.C.setSearchInfo(this.D);
        this.C.setData(this.mDataList.get(i3), i3);
        this.C.setQueryFixClickListener(this.E);
    }

    public void setCurrentSearchInfo(QFSSearchInfo qFSSearchInfo) {
        this.D = qFSSearchInfo;
    }

    public void setQueryFixClickListener(com.tencent.biz.qqcircle.immersive.search.a aVar) {
        this.E = aVar;
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
