package x20;

import com.tencent.biz.qqcircle.manager.QCirclePushInfoManager;
import com.tencent.richframework.data.idata.IDataConverter;
import com.tencent.richframework.data.idata.IDataWeakSupport;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StPushList;
import qqcircle.QQCircleFeedBase$StFeedBusiReqData;
import uq3.o;

/* compiled from: P */
/* loaded from: classes4.dex */
public class a implements IDataConverter<e30.b>, IDataWeakSupport {
    private void d(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StFeed feedCloudMeta$StFeed2) {
        if (feedCloudMeta$StFeed2.opMask2.get().contains(25)) {
            if (feedCloudMeta$StFeed.opMask2.get().contains(25)) {
                return;
            }
            feedCloudMeta$StFeed.opMask2.get().add(25);
        } else if (feedCloudMeta$StFeed.opMask2.get().contains(25)) {
            feedCloudMeta$StFeed.opMask2.get().remove((Object) 25);
        }
    }

    private void e(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StFeed feedCloudMeta$StFeed2) {
        if (!feedCloudMeta$StFeed2.commentCount.has()) {
            return;
        }
        feedCloudMeta$StFeed.commentCount.set(feedCloudMeta$StFeed2.commentCount.get());
    }

    private void f(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StFeed feedCloudMeta$StFeed2) {
        if (!feedCloudMeta$StFeed2.right.has()) {
            return;
        }
        feedCloudMeta$StFeed.right = feedCloudMeta$StFeed2.right;
    }

    private void g(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StFeed feedCloudMeta$StFeed2) {
        if (!feedCloudMeta$StFeed2.likeInfo.has()) {
            return;
        }
        feedCloudMeta$StFeed.likeInfo = feedCloudMeta$StFeed2.likeInfo;
        if (!feedCloudMeta$StFeed2.tianshuEntry.has()) {
            return;
        }
        feedCloudMeta$StFeed.tianshuEntry.set(feedCloudMeta$StFeed2.tianshuEntry.get());
    }

    private void h(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StFeed feedCloudMeta$StFeed2) {
        FeedCloudMeta$StPushList f16 = QCirclePushInfoManager.e().f(feedCloudMeta$StFeed2.f398449id.get());
        if (f16 != null && f16.has()) {
            QCirclePushInfoManager.e().i(feedCloudMeta$StFeed.f398449id.get()).put(feedCloudMeta$StFeed.f398449id.get(), f16);
        }
    }

    private void i(e30.b bVar, e30.b bVar2) {
        QQCircleFeedBase$StFeedBusiReqData qQCircleFeedBase$StFeedBusiReqData = (QQCircleFeedBase$StFeedBusiReqData) bVar2.b("DITTO_FEED_BUSI_REQ_DATA");
        if (qQCircleFeedBase$StFeedBusiReqData != null) {
            bVar.o("DITTO_FEED_BUSI_REQ_DATA", qQCircleFeedBase$StFeedBusiReqData);
        }
    }

    private void j(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StFeed feedCloudMeta$StFeed2) {
        if (!feedCloudMeta$StFeed2.share.sharedCount.has()) {
            return;
        }
        feedCloudMeta$StFeed.share.sharedCount.set(feedCloudMeta$StFeed2.share.sharedCount.get());
    }

    private void k(FeedCloudMeta$StFeed feedCloudMeta$StFeed, FeedCloudMeta$StFeed feedCloudMeta$StFeed2) {
        if (!feedCloudMeta$StFeed2.visitorInfo.viewCount.has()) {
            return;
        }
        feedCloudMeta$StFeed.visitorInfo.viewCount.set(feedCloudMeta$StFeed2.visitorInfo.viewCount.get());
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public e30.b cloneConvertData(e30.b bVar) {
        if (isSupportWeakData()) {
            return bVar;
        }
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = new FeedCloudMeta$StFeed();
        feedCloudMeta$StFeed.f398449id.set(bVar.g().f398449id.get());
        e30.b bVar2 = new e30.b(feedCloudMeta$StFeed);
        update(bVar2, bVar);
        return bVar2;
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public String getObserverKey(e30.b bVar) {
        FeedCloudMeta$StFeed g16;
        if (bVar == null) {
            g16 = null;
        } else {
            g16 = bVar.g();
        }
        if (g16 == null) {
            return null;
        }
        return g16.f398449id.get();
    }

    @Override // com.tencent.richframework.data.idata.IDataConverter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void update(e30.b bVar, e30.b bVar2) {
        if (bVar != null && bVar2 != null) {
            e(bVar.g(), bVar2.g());
            g(bVar.g(), bVar2.g());
            j(bVar.g(), bVar2.g());
            d(bVar.g(), bVar2.g());
            i(bVar, bVar2);
            h(bVar.g(), bVar2.g());
            f(bVar.g(), bVar2.g());
            k(bVar.g(), bVar2.g());
        }
    }

    @Override // com.tencent.richframework.data.idata.IDataWeakSupport
    public boolean isSupportWeakData() {
        return o.X1();
    }
}
