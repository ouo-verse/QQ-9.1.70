package w70;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCircleExtraTypeInfo;
import com.tencent.biz.qqcircle.immersive.views.mixfeed.QFSMixFeedRecommendCommentItemView;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends com.tencent.biz.qqcircle.immersive.adapter.a<FeedCloudMeta$StComment> {
    private QCircleExtraTypeInfo C;
    private y70.b D;

    /* renamed from: m, reason: collision with root package name */
    public FeedCloudMeta$StFeed f444708m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a extends RecyclerView.ViewHolder {
        public a(@NonNull View view) {
            super(view);
        }

        public void l(FeedCloudMeta$StComment feedCloudMeta$StComment) {
            View view = this.itemView;
            if (view instanceof QFSMixFeedRecommendCommentItemView) {
                ((QFSMixFeedRecommendCommentItemView) view).setData(feedCloudMeta$StComment);
            }
        }

        public void m(QCircleExtraTypeInfo qCircleExtraTypeInfo) {
            View view = this.itemView;
            if (view instanceof QFSMixFeedRecommendCommentItemView) {
                ((QFSMixFeedRecommendCommentItemView) view).setExtraTypeInfo(qCircleExtraTypeInfo);
            }
        }

        public void n(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
            View view = this.itemView;
            if (view instanceof QFSMixFeedRecommendCommentItemView) {
                ((QFSMixFeedRecommendCommentItemView) view).setStFeed(feedCloudMeta$StFeed);
            }
        }
    }

    public FeedCloudMeta$StFeed getFeed() {
        return this.f444708m;
    }

    public void i0(y70.b bVar) {
        this.D = bVar;
    }

    public void j0(QCircleExtraTypeInfo qCircleExtraTypeInfo) {
        this.C = qCircleExtraTypeInfo;
    }

    public void k0(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.f444708m = feedCloudMeta$StFeed;
    }

    @Override // com.tencent.biz.richframework.video.rfw.drive.RFWBaseVideoAdapter, androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        if (viewHolder instanceof a) {
            a aVar = (a) viewHolder;
            aVar.m(this.C);
            aVar.n(getFeed());
            aVar.l((FeedCloudMeta$StComment) this.mDataList.get(i3));
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.adapter.a
    @NonNull
    public RecyclerView.ViewHolder onCreateItemViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        QFSMixFeedRecommendCommentItemView qFSMixFeedRecommendCommentItemView = new QFSMixFeedRecommendCommentItemView(viewGroup.getContext());
        qFSMixFeedRecommendCommentItemView.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        return new a(qFSMixFeedRecommendCommentItemView);
    }
}
