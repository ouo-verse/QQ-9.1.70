package va0;

import com.tencent.biz.qqcircle.requests.QCircleDeleteFeedRequest;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.biz.qqcircle.utils.w;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.RequestInterceptor;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StFeed;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J!\u0010\t\u001a\u00020\u00042\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lva0/a;", "Lcom/tencent/biz/richframework/network/request/RequestInterceptor;", "Lcom/tencent/biz/qqcircle/requests/QCircleDeleteFeedRequest;", Const.BUNDLE_KEY_REQUEST, "", "a", "", "", "result", "interceptResponse", "([Ljava/lang/Object;)V", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class a implements RequestInterceptor {
    private final void a(QCircleDeleteFeedRequest request) {
        String str;
        PBStringField pBStringField;
        cq cqVar = cq.f92752a;
        if (!cqVar.s(request.getStFeed())) {
            return;
        }
        FeedCloudMeta$StFeed stFeed = request.getStFeed();
        if (stFeed != null && (pBStringField = stFeed.f398449id) != null) {
            str = pBStringField.get();
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        QLog.d("QCircleDeleteFeedRequestInterceptor", 1, "[dispatchDeleteFeedEvent] feedId=" + str);
        w.f(str, cqVar.q(request.getStFeed()), cqVar.d(request.getStFeed()));
    }

    @Override // com.tencent.biz.richframework.network.request.RequestInterceptor
    public /* synthetic */ void interceptRequest(BaseRequest baseRequest) {
        com.tencent.biz.richframework.network.request.a.a(this, baseRequest);
    }

    @Override // com.tencent.biz.richframework.network.request.RequestInterceptor
    public void interceptResponse(@Nullable Object[] result) {
        Object obj;
        Boolean bool;
        boolean z16;
        Object obj2;
        Long l3;
        long j3;
        Object obj3;
        Object orNull;
        com.tencent.biz.richframework.network.request.a.b(this, result);
        QCircleDeleteFeedRequest qCircleDeleteFeedRequest = null;
        if (result != null) {
            obj = ArraysKt___ArraysKt.getOrNull(result, 1);
        } else {
            obj = null;
        }
        if (obj instanceof Boolean) {
            bool = (Boolean) obj;
        } else {
            bool = null;
        }
        if (bool != null) {
            z16 = bool.booleanValue();
        } else {
            z16 = false;
        }
        if (result != null) {
            obj2 = ArraysKt___ArraysKt.getOrNull(result, 2);
        } else {
            obj2 = null;
        }
        if (obj2 instanceof Long) {
            l3 = (Long) obj2;
        } else {
            l3 = null;
        }
        if (l3 != null) {
            j3 = l3.longValue();
        } else {
            j3 = -1;
        }
        if (z16 && j3 == 0) {
            if (result != null) {
                orNull = ArraysKt___ArraysKt.getOrNull(result, 0);
                obj3 = orNull;
            } else {
                obj3 = null;
            }
            if (obj3 instanceof QCircleDeleteFeedRequest) {
                qCircleDeleteFeedRequest = (QCircleDeleteFeedRequest) obj3;
            }
            if (qCircleDeleteFeedRequest != null) {
                a(qCircleDeleteFeedRequest);
            }
        }
    }
}
