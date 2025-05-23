package q60;

import android.os.Bundle;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.search.filter.QFSSearchFilterGroupItemView;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import feedcloud.FeedCloudRead$FilterGroup;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class d extends com.tencent.biz.qqcircle.bizparts.a<FeedCloudRead$FilterGroup> {
    public d(Bundle bundle) {
        super(bundle);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock, com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        List<E> list = this.mDataList;
        if (list != 0) {
            return list.size();
        }
        return 0;
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    protected String getLogTag() {
        return "QFSSearchFilterGroupAdapter";
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public int getViewTypeCount() {
        return 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        ((QFSSearchFilterGroupItemView) viewHolder.itemView).setData(getItem(i3), i3);
    }

    @Override // com.tencent.biz.qqcircle.bizparts.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        QFSSearchFilterGroupItemView qFSSearchFilterGroupItemView = new QFSSearchFilterGroupItemView(viewGroup.getContext());
        qFSSearchFilterGroupItemView.setFragment(getParentFragment());
        qFSSearchFilterGroupItemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        qFSSearchFilterGroupItemView.setReportBean(getReportBean());
        return new BaseListViewAdapter.BaseVH(qFSSearchFilterGroupItemView);
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void loadData(LoadInfo loadInfo) {
    }

    @Override // com.tencent.biz.richframework.part.block.MultiViewBlock
    public void onInitBlock(Bundle bundle) {
    }
}
