package s70;

import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.qqcircle.beans.QCircleTagChallengeInfo;
import com.tencent.biz.qqcircle.beans.QCircleTopicRankItemInfo;
import com.tencent.biz.qqcircle.requests.QCircleGetTagChallengeRankRequest;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleReportFirstLogin;
import feedcloud.FeedCloudCommon$StCommonExt;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StTagInfo;
import feedcloud.FeedCloudRead$GetTagChallengeRankRsp;
import feedcloud.FeedCloudRead$TagChallengeRankItem;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b extends com.tencent.biz.qqcircle.viewmodels.a {
    public static final String I = "s70.b";
    private int F;
    public boolean H;

    /* renamed from: m, reason: collision with root package name */
    private String f433415m = null;
    private FeedCloudCommon$StCommonExt C = new FeedCloudCommon$StCommonExt();
    private final MutableLiveData<List<QCircleTopicRankItemInfo>> D = new MutableLiveData<>();
    private MutableLiveData<a> E = new MutableLiveData<>();
    private MutableLiveData<QCircleTagChallengeInfo> G = new MutableLiveData<>();

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class a extends LoadInfo {

        /* renamed from: a, reason: collision with root package name */
        public boolean f433416a;
    }

    private void S1(QCircleGetTagChallengeRankRequest qCircleGetTagChallengeRankRequest, boolean z16, long j3, String str, FeedCloudRead$GetTagChallengeRankRsp feedCloudRead$GetTagChallengeRankRsp, boolean z17) {
        boolean z18;
        String str2;
        a aVar = new a();
        String str3 = I;
        QLog.d(str3, 1, "handleTopicChallengeRankFeedsResponse isSuccess:" + z16 + " retCode:" + j3 + "errMsg:" + str);
        if (z16 && j3 == 0 && feedCloudRead$GetTagChallengeRankRsp != null) {
            aVar.f433416a = true;
            if (feedCloudRead$GetTagChallengeRankRsp.isFinish.get() > 0) {
                z18 = true;
            } else {
                z18 = false;
            }
            aVar.setFinish(z18);
            List<FeedCloudRead$TagChallengeRankItem> list = feedCloudRead$GetTagChallengeRankRsp.vecTagChallengeItem.get();
            if (list != null && !list.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (FeedCloudRead$TagChallengeRankItem feedCloudRead$TagChallengeRankItem : list) {
                    List<FeedCloudMeta$StFeed> list2 = feedCloudRead$TagChallengeRankItem.feedList.get();
                    FeedCloudMeta$StTagInfo feedCloudMeta$StTagInfo = feedCloudRead$TagChallengeRankItem.tagInfo;
                    if (feedCloudMeta$StTagInfo != null) {
                        str2 = feedCloudMeta$StTagInfo.get().tagName.get();
                    } else {
                        str2 = "";
                    }
                    arrayList.add(new QCircleTopicRankItemInfo(str2, list2, feedCloudRead$TagChallengeRankItem.tagInfo));
                }
                if (z17 && this.D.getValue() != null && this.D.getValue().size() > 0) {
                    arrayList.addAll(0, this.D.getValue());
                }
                this.D.setValue(arrayList);
                this.C = feedCloudRead$GetTagChallengeRankRsp.extInfo.get();
                this.f433415m = feedCloudRead$GetTagChallengeRankRsp.feedAttchInfo.get();
                aVar.setCurrentState(4);
                this.E.setValue(aVar);
                return;
            }
            aVar.setFinish(true);
            aVar.setCurrentState(4);
            this.E.setValue(aVar);
            QLog.w(str3, 4, "tagChallengeRankItem is empty");
            return;
        }
        QLog.e(getLogTag(), 1, "[requestData] onReceive dispatch Error: | TraceId:" + qCircleGetTagChallengeRankRequest.getTraceId() + " | SeqId:" + qCircleGetTagChallengeRankRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
        aVar.setCurrentState(4);
        aVar.setFinish(false);
        aVar.f433416a = false;
        this.E.setValue(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T1(QCircleGetTagChallengeRankRequest qCircleGetTagChallengeRankRequest, boolean z16, BaseRequest baseRequest, boolean z17, long j3, String str, FeedCloudRead$GetTagChallengeRankRsp feedCloudRead$GetTagChallengeRankRsp) {
        S1(qCircleGetTagChallengeRankRequest, z17, j3, str, feedCloudRead$GetTagChallengeRankRsp, z16);
        String str2 = I;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("requestData onReceive: dispatch Success:");
        sb5.append(z17);
        sb5.append(" | TraceId:");
        sb5.append(baseRequest.getTraceId());
        sb5.append(" | SeqId:");
        sb5.append(baseRequest.getCurrentSeq());
        sb5.append(" | retCode:");
        sb5.append(j3);
        sb5.append(" | retMessage:");
        sb5.append(str);
        sb5.append(" | isLoadMore:");
        sb5.append(z16);
        sb5.append(" | isCache:");
        sb5.append(VSNetworkHelper.isProtocolCache(str));
        sb5.append(" | extInfo:");
        QCircleGetTagChallengeRankRequest qCircleGetTagChallengeRankRequest2 = (QCircleGetTagChallengeRankRequest) baseRequest;
        sb5.append(qCircleGetTagChallengeRankRequest2.getRequest().extInfo.mapInfo.get(0).key.get());
        sb5.append(MsgSummary.STR_COLON);
        sb5.append(qCircleGetTagChallengeRankRequest2.getRequest().extInfo.mapInfo.get(0).value.get());
        QLog.d(str2, 1, sb5.toString());
    }

    private void W1(final boolean z16, boolean z17) {
        String str;
        int i3;
        FeedCloudCommon$StCommonExt feedCloudCommon$StCommonExt = this.C;
        if (z16) {
            str = this.f433415m;
        } else {
            str = null;
        }
        final QCircleGetTagChallengeRankRequest qCircleGetTagChallengeRankRequest = new QCircleGetTagChallengeRankRequest(feedCloudCommon$StCommonExt, str);
        this.H = z16;
        a aVar = new a();
        aVar.setFinish(false);
        if (z16) {
            i3 = 3;
        } else {
            i3 = 2;
        }
        aVar.setCurrentState(i3);
        this.E.setValue(aVar);
        qCircleGetTagChallengeRankRequest.setEnableCache(z17);
        qCircleGetTagChallengeRankRequest.getRequest().extInfo.setHasFlag(true);
        qCircleGetTagChallengeRankRequest.getRequest().extInfo.mapInfo.add(QCircleReportFirstLogin.getFirstLoginEntry());
        VSNetworkHelper.getInstance().sendRequest(qCircleGetTagChallengeRankRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: s70.a
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z18, long j3, String str2, Object obj) {
                b.this.T1(qCircleGetTagChallengeRankRequest, z16, baseRequest, z18, j3, str2, (FeedCloudRead$GetTagChallengeRankRsp) obj);
            }
        });
    }

    public int M1(String str) {
        List<QCircleTopicRankItemInfo> value = this.D.getValue();
        if (value != null) {
            for (int i3 = 0; i3 < value.size(); i3++) {
                if (str.equals(value.get(i3).getTagInfo().tagId.get())) {
                    return i3;
                }
            }
            return -1;
        }
        return -1;
    }

    public int N1() {
        if (Q1().getValue() != null) {
            return M1(Q1().getValue().mTagId);
        }
        return -1;
    }

    public int O1() {
        return this.F;
    }

    public MutableLiveData<a> P1() {
        return this.E;
    }

    public MutableLiveData<QCircleTagChallengeInfo> Q1() {
        return this.G;
    }

    public MutableLiveData<List<QCircleTopicRankItemInfo>> R1() {
        return this.D;
    }

    public void U1() {
        W1(false, false);
    }

    public void X1(int i3) {
        this.F = i3;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return I;
    }

    public void loadMore() {
        W1(true, false);
    }
}
