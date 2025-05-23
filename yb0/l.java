package yb0;

import com.tencent.biz.qqcircle.beans.QFSFastShareUserInfo;
import com.tencent.biz.qqcircle.immersive.events.QFSShowFastShareHintEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QFSDoBatchShareFeedRequest;
import com.tencent.biz.qqcircle.utils.cc;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudWrite$ShareResult;
import feedcloud.FeedCloudWrite$ShareTarget;
import feedcloud.FeedCloudWrite$StDoBatchShareFeedRsp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J.\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J,\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f\u00a8\u0006\u0017"}, d2 = {"Lyb0/l;", "", "", "Lcom/tencent/mobileqq/selectmember/ResultRecord;", "resultRecords", "Lfeedcloud/FeedCloudWrite$ShareTarget;", "c", "", "uinType", "b", "", "feedId", "shareUsers", "Lfeedcloud/FeedCloudWrite$StDoBatchShareFeedRsp;", "rsp", "", "isNeedToast", "", "d", "leaveMsg", "e", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final l f449997a = new l();

    l() {
    }

    private final int b(int uinType) {
        if (uinType == 0) {
            return 1;
        }
        if (uinType != 1) {
            if (uinType != 10008) {
                return 0;
            }
            return 3;
        }
        return 2;
    }

    private final List<FeedCloudWrite$ShareTarget> c(List<? extends ResultRecord> resultRecords) {
        List<FeedCloudWrite$ShareTarget> list;
        ArrayList arrayList = new ArrayList();
        for (ResultRecord resultRecord : resultRecords) {
            FeedCloudWrite$ShareTarget feedCloudWrite$ShareTarget = new FeedCloudWrite$ShareTarget();
            feedCloudWrite$ShareTarget.dest_uin.set(resultRecord.uin);
            feedCloudWrite$ShareTarget.type.set(b(resultRecord.uinType));
            arrayList.add(feedCloudWrite$ShareTarget);
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        return list;
    }

    private final void d(String feedId, List<? extends ResultRecord> shareUsers, FeedCloudWrite$StDoBatchShareFeedRsp rsp, boolean isNeedToast) {
        ArrayList arrayList = new ArrayList();
        Iterator<FeedCloudWrite$ShareResult> it = rsp.res.get().iterator();
        int i3 = -1;
        while (true) {
            int i16 = 0;
            if (!it.hasNext()) {
                break;
            }
            FeedCloudWrite$ShareResult next = it.next();
            if (next.status.get() == 1 && next.targets.type.get() == 3) {
                String uin = next.targets.dest_uin.get();
                Intrinsics.checkNotNullExpressionValue(uin, "uin");
                arrayList.add(uin);
                if (i3 < 0) {
                    int size = shareUsers.size();
                    while (true) {
                        if (i16 >= size) {
                            break;
                        }
                        if (Intrinsics.areEqual(uin, shareUsers.get(i16).uin)) {
                            i3 = i16;
                            break;
                        }
                        i16++;
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            cc.d(arrayList);
        }
        if (isNeedToast && i3 >= 0 && arrayList.size() == rsp.res.get().size()) {
            ResultRecord resultRecord = shareUsers.get(i3);
            SimpleEventBus.getInstance().dispatchEvent(new QFSShowFastShareHintEvent(new QFSFastShareUserInfo(resultRecord.name, resultRecord.uin, resultRecord.uinType), feedId));
        }
        if (isNeedToast) {
            QCircleToast.l(QCircleToast.f91646f, "\u5df2\u53d1\u9001", 0, true, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(String feedId, List shareUsers, boolean z16, BaseRequest baseRequest, boolean z17, long j3, String str, FeedCloudWrite$StDoBatchShareFeedRsp feedCloudWrite$StDoBatchShareFeedRsp) {
        Intrinsics.checkNotNullParameter(feedId, "$feedId");
        Intrinsics.checkNotNullParameter(shareUsers, "$shareUsers");
        if (z17 && j3 == 0 && feedCloudWrite$StDoBatchShareFeedRsp != null) {
            QLog.d("QFSMultiShareRequestHelper", 1, "[sendShareRequest] success, traceId: " + baseRequest.getTraceId() + ".");
            f449997a.d(feedId, shareUsers, feedCloudWrite$StDoBatchShareFeedRsp, z16);
            return;
        }
        QCircleToast.l(QCircleToast.f91645e, com.tencent.biz.qqcircle.utils.h.a(R.string.f19228473), 0, true, false);
        QLog.e("QFSMultiShareRequestHelper", 1, "[sendShareRequest] error, traceId: " + baseRequest.getTraceId() + ", errMsg: " + str);
    }

    public final void e(@NotNull final String feedId, @NotNull final List<? extends ResultRecord> shareUsers, @NotNull String leaveMsg, final boolean isNeedToast) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(shareUsers, "shareUsers");
        Intrinsics.checkNotNullParameter(leaveMsg, "leaveMsg");
        if (shareUsers.size() > 9) {
            QLog.d("QFSMultiShareRequestHelper", 1, "[sendShareRequest] over size.");
        } else {
            VSNetworkHelper.getInstance().sendRequest(new QFSDoBatchShareFeedRequest(feedId, c(shareUsers), leaveMsg), new VSDispatchObserver.OnVSRspCallBack() { // from class: yb0.k
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                    l.f(feedId, shareUsers, isNeedToast, baseRequest, z16, j3, str, (FeedCloudWrite$StDoBatchShareFeedRsp) obj);
                }
            });
        }
    }
}
