package t80;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.c;
import com.tencent.biz.qqcircle.requests.QCircleTabGetFeedListRequest;
import com.tencent.biz.qqcircle.requests.QFSMixFeedRecommendPageRequester;
import com.tencent.biz.qqcircle.viewmodels.o;
import com.tencent.richframework.data.base.UIStateData;
import e30.d;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StGPSV2;
import feedcloud.FeedCloudRead$StGetFeedListReq;
import java.util.ArrayList;
import java.util.List;
import qqcircle.QQCircleFeedBase$StTabInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends o {
    private FeedCloudMeta$StFeed K;
    private String L;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class a extends QCircleTabGetFeedListRequest.b {
        a() {
        }

        @Override // com.tencent.biz.qqcircle.requests.QCircleTabGetFeedListRequest.b
        public FeedCloudRead$StGetFeedListReq g() {
            FeedCloudRead$StGetFeedListReq g16 = super.g();
            g16.source.set(b.this.D2());
            return g16;
        }
    }

    private QCircleTabGetFeedListRequest.b i2(boolean z16) {
        FeedCloudMeta$StGPSV2 feedCloudMeta$StGPSV2;
        QCircleTabGetFeedListRequest.b p16 = new a().p(new QCircleTabInfo(new QQCircleFeedBase$StTabInfo()));
        if (uq3.o.i()) {
            feedCloudMeta$StGPSV2 = c.e().d();
        } else {
            feedCloudMeta$StGPSV2 = new FeedCloudMeta$StGPSV2();
        }
        QCircleTabGetFeedListRequest.b j3 = p16.j(feedCloudMeta$StGPSV2);
        String str = "";
        if (z16 && !TextUtils.isEmpty(this.G)) {
            str = this.G;
        }
        return j3.h(str);
    }

    protected int D2() {
        return 72;
    }

    public String E2() {
        return String.valueOf(hashCode());
    }

    public void F2(List<e30.b> list) {
        if (list != null && !list.isEmpty()) {
            UIStateData<List<e30.b>> obtainSuccess = UIStateData.obtainSuccess(true);
            obtainSuccess.setData(false, list);
            this.f435354m.setValue(obtainSuccess);
            return;
        }
        this.f435354m.setValue(null);
    }

    public void G2(List<FeedCloudMeta$StFeed> list) {
        if (list != null && !list.isEmpty()) {
            ArrayList<e30.b> b16 = d.b(list);
            UIStateData<List<e30.b>> obtainSuccess = UIStateData.obtainSuccess(true);
            obtainSuccess.setData(false, b16);
            this.f435354m.setValue(obtainSuccess);
            return;
        }
        this.f435354m.setValue(null);
    }

    public void H2(String str) {
        this.L = str;
    }

    public void I2(FeedCloudMeta$StFeed feedCloudMeta$StFeed) {
        this.K = feedCloudMeta$StFeed;
    }

    @Override // com.tencent.biz.qqcircle.viewmodels.o, com.tencent.biz.qqcircle.viewmodels.QFSMixFeedViewModel
    @NonNull
    protected QCircleTabGetFeedListRequest f2(boolean z16) {
        QFSMixFeedRecommendPageRequester qFSMixFeedRecommendPageRequester = new QFSMixFeedRecommendPageRequester(i2(z16));
        qFSMixFeedRecommendPageRequester.mRequest.source.set(D2());
        qFSMixFeedRecommendPageRequester.mRequest.feed.set(QCirclePluginUtil.getSimpleFeed(this.K));
        FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
        feedCloudCommon$Entry.key.set("query_text");
        feedCloudCommon$Entry.value.set(this.L);
        qFSMixFeedRecommendPageRequester.mRequest.extInfo.mapInfo.add(feedCloudCommon$Entry);
        return qFSMixFeedRecommendPageRequester;
    }

    @Override // com.tencent.biz.qqcircle.viewmodels.QFSMixFeedViewModel, com.tencent.richframework.data.idata.IDataDisplaySurface
    public int getDisplaySurfaceType() {
        return 0;
    }

    @Override // com.tencent.biz.qqcircle.viewmodels.o, com.tencent.biz.qqcircle.viewmodels.QFSMixFeedViewModel, com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QFSSearchFeedRecommendViewModel";
    }
}
