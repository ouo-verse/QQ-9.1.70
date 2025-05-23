package s90;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.immersive.views.search.simpleitem.QFSSearchSmallItemResultItemView;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import feedcloud.FeedCloudRead$StSearchSmallItem;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends BaseListViewAdapter<FeedCloudRead$StSearchSmallItem> {
    private Fragment C;
    private int D;

    /* renamed from: m, reason: collision with root package name */
    private QCircleExtraTypeInfo f433517m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    private class a extends RecyclerView.ViewHolder {
        private final QFSSearchSmallItemResultItemView E;

        public a(@NonNull View view) {
            super(view);
            this.E = (QFSSearchSmallItemResultItemView) view;
        }

        public void l(FeedCloudRead$StSearchSmallItem feedCloudRead$StSearchSmallItem, int i3) {
            this.E.setData(feedCloudRead$StSearchSmallItem, i3);
        }
    }

    public void i0(Fragment fragment) {
        this.C = fragment;
    }

    public void j0(int i3) {
        this.D = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        ((a) viewHolder).l(getItem(i3), i3);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public final RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        QFSSearchSmallItemResultItemView qFSSearchSmallItemResultItemView = new QFSSearchSmallItemResultItemView(viewGroup.getContext());
        qFSSearchSmallItemResultItemView.setParentView(viewGroup);
        qFSSearchSmallItemResultItemView.setExtraTypeInfo(this.f433517m);
        qFSSearchSmallItemResultItemView.setFragment(this.C);
        qFSSearchSmallItemResultItemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        qFSSearchSmallItemResultItemView.setSource(this.D);
        return new a(qFSSearchSmallItemResultItemView);
    }
}
