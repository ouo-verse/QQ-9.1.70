package w70;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.immersive.views.mixfeed.QFSMixFeedRecommendCardItemView;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudMeta$StFeed;
import org.jetbrains.annotations.NotNull;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a extends BaseListViewAdapter<QQCircleDitto$StItemInfo> {
    private QCircleExtraTypeInfo C;

    /* renamed from: m, reason: collision with root package name */
    private com.tencent.biz.qqcircle.scrollers.b f444707m;

    /* compiled from: P */
    /* renamed from: w70.a$a, reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    private static class C11465a extends RecyclerView.ViewHolder {
        public C11465a(@NonNull View view) {
            super(view);
        }

        public void l(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo, int i3) {
            View view = this.itemView;
            if (view instanceof QFSMixFeedRecommendCardItemView) {
                ((QFSMixFeedRecommendCardItemView) view).bindData(qQCircleDitto$StItemInfo, i3);
            }
        }

        public void m(QCircleExtraTypeInfo qCircleExtraTypeInfo) {
            View view = this.itemView;
            if (view instanceof QFSMixFeedRecommendCardItemView) {
                ((QFSMixFeedRecommendCardItemView) view).setExtraTypeInfo(qCircleExtraTypeInfo);
            }
        }
    }

    public void i0(int i3) {
        if (i3 >= 0) {
            getNUM_BACKGOURND_ICON();
        }
    }

    public void j0(QCircleExtraTypeInfo qCircleExtraTypeInfo) {
        this.C = qCircleExtraTypeInfo;
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NonNull @NotNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f444707m = new com.tencent.biz.qqcircle.scrollers.b(recyclerView.getContext(), recyclerView, this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        QQCircleDitto$StItemInfo item;
        PBRepeatMessageField<FeedCloudMeta$StFeed> pBRepeatMessageField;
        if ((viewHolder instanceof C11465a) && (item = getItem(i3)) != null && (pBRepeatMessageField = item.feeds) != null && pBRepeatMessageField.size() != 0) {
            C11465a c11465a = (C11465a) viewHolder;
            c11465a.m(this.C);
            c11465a.l(getItem(i3), i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        QFSMixFeedRecommendCardItemView qFSMixFeedRecommendCardItemView = new QFSMixFeedRecommendCardItemView(viewGroup.getContext());
        qFSMixFeedRecommendCardItemView.setParentView(viewGroup);
        return new C11465a(qFSMixFeedRecommendCardItemView);
    }

    @Override // com.tencent.biz.richframework.part.block.base.BaseListViewAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onDetachedFromRecyclerView(@NonNull @NotNull RecyclerView recyclerView) {
        super.onDetachedFromRecyclerView(recyclerView);
        com.tencent.biz.qqcircle.scrollers.b bVar = this.f444707m;
        if (bVar != null) {
            bVar.onDestroy();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewAttachedToWindow(@NonNull @NotNull RecyclerView.ViewHolder viewHolder) {
        super.onViewAttachedToWindow(viewHolder);
        com.tencent.biz.qqcircle.scrollers.b bVar = this.f444707m;
        if (bVar != null) {
            bVar.k(viewHolder);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onViewDetachedFromWindow(@NonNull @NotNull RecyclerView.ViewHolder viewHolder) {
        super.onViewDetachedFromWindow(viewHolder);
        com.tencent.biz.qqcircle.scrollers.b bVar = this.f444707m;
        if (bVar != null) {
            bVar.k(viewHolder);
        }
    }
}
