package yb0;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.tencent.biz.qqcircle.beans.QCircleShareInfo;
import com.tencent.biz.qqcircle.immersive.request.QFSGetShareDataRequest;
import com.tencent.biz.qqcircle.immersive.utils.au;
import com.tencent.biz.qqcircle.utils.af;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StShare;
import feedcloud.FeedCloudRead$StGetFeedSharePanelRsp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes5.dex */
public class r {

    /* renamed from: d, reason: collision with root package name */
    private a f450014d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f450015e;

    /* renamed from: a, reason: collision with root package name */
    private int f450011a = -1;

    /* renamed from: b, reason: collision with root package name */
    private final Map<String, String> f450012b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final Map<String, wb0.c> f450013c = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    private final ArrayList<String> f450016f = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final long f450017a;

        /* renamed from: b, reason: collision with root package name */
        private final String f450018b;

        public a(long j3, String str) {
            this.f450017a = j3;
            this.f450018b = str;
        }

        public String a() {
            return this.f450018b;
        }

        public long b() {
            return this.f450017a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        static final r f450019a = new r();
    }

    r() {
    }

    private boolean D(QCircleShareInfo qCircleShareInfo) {
        FeedCloudMeta$StShare feedCloudMeta$StShare;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = qCircleShareInfo.feed;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StShare = feedCloudMeta$StFeed.share) != null && !TextUtils.isEmpty(feedCloudMeta$StShare.shareCardInfo.get()) && !TextUtils.isEmpty(qCircleShareInfo.feed.share.url.get())) {
            return false;
        }
        return true;
    }

    private void c(long j3, String str, QCircleShareInfo qCircleShareInfo) {
        if (j3 != 0 && uq3.c.f0()) {
            this.f450014d = new a(j3, str);
            if (qCircleShareInfo != null && qCircleShareInfo.feed != null) {
                h().z(qCircleShareInfo.feed.f398449id.get());
            }
        }
    }

    private boolean e(QFSGetShareDataRequest qFSGetShareDataRequest, BaseRequest baseRequest, boolean z16, FeedCloudRead$StGetFeedSharePanelRsp feedCloudRead$StGetFeedSharePanelRsp) {
        if (feedCloudRead$StGetFeedSharePanelRsp != null && z16 && p(qFSGetShareDataRequest, baseRequest)) {
            return true;
        }
        QLog.e("QFSSharePart", 1, "isSuccess: " + z16 + ", isCorrespondingReq: " + p(qFSGetShareDataRequest, baseRequest));
        this.f450015e = false;
        return false;
    }

    private boolean f(@NonNull QCircleShareInfo qCircleShareInfo) {
        FeedCloudMeta$StShare feedCloudMeta$StShare;
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = qCircleShareInfo.feed;
        if (feedCloudMeta$StFeed != null && (feedCloudMeta$StShare = feedCloudMeta$StFeed.share) != null) {
            String str = feedCloudMeta$StShare.feed_id.get();
            if (TextUtils.isEmpty(str)) {
                return true;
            }
            return str.startsWith(String.valueOf(qCircleShareInfo.shareStyleType));
        }
        QLog.e("QFSSharePart", 1, "shareInfo feed is null. ");
        return false;
    }

    public static r h() {
        return b.f450019a;
    }

    private String i(@NonNull QCircleShareInfo qCircleShareInfo) {
        String str;
        if (qCircleShareInfo.feed == null) {
            QLog.e("QFSSharePart", 1, "shareInfo feed is null. ");
            return null;
        }
        if (this.f450015e) {
            str = NotificationCompat.GROUP_KEY_SILENT;
        } else {
            str = "";
        }
        return str + qCircleShareInfo.shareStyleType + qCircleShareInfo.feed.f398449id.get();
    }

    private String k(String str) {
        for (Map.Entry<String, String> entry : this.f450012b.entrySet()) {
            if (TextUtils.equals(entry.getValue(), str)) {
                return entry.getKey();
            }
        }
        QLog.e("QFSSharePart", 1, "can't find seqId. ");
        return null;
    }

    private String l(QCircleShareInfo qCircleShareInfo) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        if (qCircleShareInfo != null && (feedCloudMeta$StFeed = qCircleShareInfo.feed) != null) {
            return af.a(feedCloudMeta$StFeed.f398449id.get());
        }
        return "";
    }

    private void m(@NonNull QCircleShareInfo qCircleShareInfo, @NonNull FeedCloudRead$StGetFeedSharePanelRsp feedCloudRead$StGetFeedSharePanelRsp, wb0.a aVar, wb0.c cVar, long j3, String str) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed;
        c(j3, str, qCircleShareInfo);
        FeedCloudMeta$StShare feedCloudMeta$StShare = feedCloudRead$StGetFeedSharePanelRsp.share_info;
        if (feedCloudMeta$StShare != null && (feedCloudMeta$StFeed = qCircleShareInfo.feed) != null && feedCloudMeta$StFeed.share != null) {
            String str2 = feedCloudMeta$StShare.feed_id.get();
            if (!TextUtils.equals(l(qCircleShareInfo), str2)) {
                QLog.e("QFSSharePart", 1, "feed id don't match. rspFeedId: " + str2 + ", origin feed id: " + qCircleShareInfo.feed.f398449id.get() + ", share info feed id: " + l(qCircleShareInfo));
                this.f450015e = false;
                String l3 = l(qCircleShareInfo);
                u(l3);
                x(l3);
                return;
            }
            feedCloudRead$StGetFeedSharePanelRsp.share_info.feed_id.set(qCircleShareInfo.shareStyleType + str2);
            qCircleShareInfo.feed.share = feedCloudRead$StGetFeedSharePanelRsp.share_info;
            if (aVar != null) {
                QLog.d("QFSSharePart", 1, "callback shareActionSheet refresh collect state");
                aVar.b(feedCloudRead$StGetFeedSharePanelRsp.is_collect.get());
            }
            if (feedCloudRead$StGetFeedSharePanelRsp.profile_card_cover_data != null && au.j(qCircleShareInfo)) {
                e30.b bVar = qCircleShareInfo.feedBlockData;
                if (bVar != null) {
                    bVar.o("share_panel_profile_card_cover", feedCloudRead$StGetFeedSharePanelRsp.profile_card_cover_data.get());
                }
                QLog.d("QFSSharePart", 1, "[handleShareDataRsp] showSetQQProfileCover:" + feedCloudRead$StGetFeedSharePanelRsp.profile_card_cover_data.show_entry.get());
            }
            h().z(str2);
            if (cVar != null && this.f450015e) {
                QLog.d("QFSSharePart", 1, "callback realOperate");
                cVar.a();
                this.f450015e = false;
            }
            if (this.f450013c.containsKey(str2)) {
                wb0.c cVar2 = this.f450013c.get(str2);
                if (cVar2 != null) {
                    cVar2.a();
                    x(str2);
                }
                QLog.d("QFSSharePart", 1, "OperationCallbackMap callback realOperate");
                return;
            }
            return;
        }
        QLog.e("QFSSharePart", 1, "rsp.shareInfo is null");
    }

    private boolean n(@NonNull QCircleShareInfo qCircleShareInfo) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = qCircleShareInfo.feed;
        if (feedCloudMeta$StFeed != null && feedCloudMeta$StFeed.share != null) {
            if (!f(qCircleShareInfo)) {
                QLog.d("QFSSharePart", 1, "checkShareType: false ");
                return false;
            }
            if (!D(qCircleShareInfo)) {
                return true;
            }
            QLog.d("QFSSharePart", 1, "shareCardInfo or url is empty. ");
            return false;
        }
        QLog.e("QFSSharePart", 1, "shareInfo feed is null. ");
        return false;
    }

    private boolean p(QFSGetShareDataRequest qFSGetShareDataRequest, BaseRequest baseRequest) {
        if (qFSGetShareDataRequest == null || baseRequest == null || qFSGetShareDataRequest.getCurrentSeq() != baseRequest.getCurrentSeq()) {
            return false;
        }
        return true;
    }

    private boolean q(@NonNull QCircleShareInfo qCircleShareInfo) {
        FeedCloudMeta$StFeed feedCloudMeta$StFeed = qCircleShareInfo.feed;
        if (feedCloudMeta$StFeed == null) {
            QLog.e("QFSSharePart", 1, "shareInfo feed is null. ");
            return false;
        }
        String str = feedCloudMeta$StFeed.f398449id.get();
        if (TextUtils.isEmpty(str)) {
            QLog.e("QFSSharePart", 1, "shareInfo feed id is null. ");
            return false;
        }
        return str.startsWith("Z_");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void s(wb0.a aVar, QFSGetShareDataRequest qFSGetShareDataRequest, QCircleShareInfo qCircleShareInfo, wb0.c cVar, BaseRequest baseRequest, boolean z16, long j3, String str, FeedCloudRead$StGetFeedSharePanelRsp feedCloudRead$StGetFeedSharePanelRsp) {
        QLog.d("QFSSharePart", 1, "requestData onReceive: dispatch Success:" + z16 + " | TraceId:" + baseRequest.getTraceId() + " | SeqId:" + baseRequest.getCurrentSeq() + " | retCode:" + j3 + " | retMessage:" + str);
        h().y(String.valueOf(baseRequest.getCurrentSeq()));
        if (aVar != null) {
            aVar.c();
        }
        if (!e(qFSGetShareDataRequest, baseRequest, z16, feedCloudRead$StGetFeedSharePanelRsp)) {
            if (qCircleShareInfo.feed != null) {
                x(l(qCircleShareInfo));
                return;
            }
            return;
        }
        m(qCircleShareInfo, feedCloudRead$StGetFeedSharePanelRsp, aVar, cVar, j3, str);
    }

    private void u(String str) {
        wb0.c cVar;
        if (this.f450013c.containsKey(str) && (cVar = this.f450013c.get(str)) != null) {
            cVar.b();
        }
    }

    private String v(int i3) {
        switch (i3) {
            case 0:
                return "normal style";
            case 1:
                return "push page";
            case 2:
                return "main page";
            case 3:
                return "tag page";
            case 4:
                return "school page";
            case 5:
                return "lbs page";
            case 6:
                return "album page";
            default:
                return "unknown scene";
        }
    }

    public void A(int i3, BaseRequest baseRequest, VSDispatchObserver.OnVSRspCallBack<FeedCloudRead$StGetFeedSharePanelRsp> onVSRspCallBack) {
        VSNetworkHelper.getInstance().sendRequest(i3, baseRequest, onVSRspCallBack);
        QLog.d("QFSSharePart", 1, "sendRequest success");
    }

    public void B(boolean z16) {
        this.f450015e = z16;
    }

    public void C(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f450016f.add(str);
    }

    public void b(String str, wb0.c cVar) {
        this.f450013c.put(str, cVar);
    }

    public boolean d(@NonNull QCircleShareInfo qCircleShareInfo) {
        return this.f450012b.containsKey(i(qCircleShareInfo));
    }

    public void g() {
        this.f450014d = null;
    }

    public a j() {
        return this.f450014d;
    }

    public boolean o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f450016f.contains(str);
    }

    public boolean r(@NonNull QCircleShareInfo qCircleShareInfo) {
        boolean z16;
        boolean q16 = q(qCircleShareInfo);
        boolean n3 = n(qCircleShareInfo);
        boolean d16 = d(qCircleShareInfo);
        if (this.f450014d != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.d("QFSSharePart", 1, "[isNeedRequestShareData] isLiveFeed | " + q16 + ", isCompleteShare | " + n3 + ", isRequesting | " + d16 + ", isErrorRsp | " + z16);
        if (q16 || n3 || d16 || z16) {
            return false;
        }
        return true;
    }

    public void t(@NonNull final QCircleShareInfo qCircleShareInfo, final wb0.a aVar, final wb0.c cVar) {
        QLog.d("QFSSharePart", 1, "[loadShareData] isSilent: " + this.f450015e + ", shareStyleType: " + v(qCircleShareInfo.shareStyleType));
        final QFSGetShareDataRequest qFSGetShareDataRequest = new QFSGetShareDataRequest(qCircleShareInfo);
        this.f450014d = null;
        qFSGetShareDataRequest.setEnableCache(true);
        A(this.f450011a, qFSGetShareDataRequest, new VSDispatchObserver.OnVSRspCallBack() { // from class: yb0.q
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                r.this.s(aVar, qFSGetShareDataRequest, qCircleShareInfo, cVar, baseRequest, z16, j3, str, (FeedCloudRead$StGetFeedSharePanelRsp) obj);
            }
        });
        h().w(qCircleShareInfo, String.valueOf(qFSGetShareDataRequest.getCurrentSeq()));
    }

    public void w(@NonNull QCircleShareInfo qCircleShareInfo, String str) {
        this.f450012b.put(i(qCircleShareInfo), str);
        QLog.d("QFSSharePart", 1, "[putReqRecord]: success");
    }

    public void x(String str) {
        this.f450013c.remove(str);
    }

    public void y(String str) {
        if (TextUtils.isEmpty(str)) {
            QLog.e("QFSSharePart", 1, "request seqId is null. ");
            return;
        }
        String k3 = k(str);
        QLog.d("QFSSharePart", 1, "[putReqRecord] key: " + k3);
        if (k3 == null) {
            return;
        }
        QLog.d("QFSSharePart", 1, "[removeReqRecordBySeqId] before " + this.f450012b.size());
        this.f450012b.remove(k3);
        QLog.d("QFSSharePart", 1, "[removeReqRecordBySeqId] after " + this.f450012b.size());
    }

    public void z(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f450016f.remove(str);
    }
}
