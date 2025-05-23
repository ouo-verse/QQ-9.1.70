package va0;

import com.tencent.biz.qqcircle.requests.QCircleDoReplyRequest;
import com.tencent.biz.qqcircle.utils.cq;
import com.tencent.biz.qqcircle.utils.w;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.RequestInterceptor;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta$StComment;
import feedcloud.FeedCloudMeta$StFeed;
import feedcloud.FeedCloudMeta$StReply;
import feedcloud.FeedCloudMeta$StUser;
import feedcloud.FeedCloudWrite$StDoReplyReq;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J!\u0010\t\u001a\u00020\u00042\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lva0/d;", "Lcom/tencent/biz/richframework/network/request/RequestInterceptor;", "Lcom/tencent/biz/qqcircle/requests/QCircleDoReplyRequest;", Const.BUNDLE_KEY_REQUEST, "", "a", "", "", "result", "interceptResponse", "([Ljava/lang/Object;)V", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class d implements RequestInterceptor {
    private final void a(QCircleDoReplyRequest request) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        Integer num;
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        FeedCloudMeta$StUser feedCloudMeta$StUser;
        FeedCloudMeta$StUser feedCloudMeta$StUser2;
        String str7;
        FeedCloudMeta$StReply feedCloudMeta$StReply;
        PBStringField pBStringField;
        FeedCloudMeta$StReply feedCloudMeta$StReply2;
        FeedCloudMeta$StReply feedCloudMeta$StReply3;
        FeedCloudMeta$StUser feedCloudMeta$StUser3;
        PBUInt32Field pBUInt32Field;
        FeedCloudMeta$StReply feedCloudMeta$StReply4;
        PBStringField pBStringField2;
        FeedCloudMeta$StComment feedCloudMeta$StComment2;
        PBStringField pBStringField3;
        PBStringField pBStringField4;
        cq cqVar = cq.f92752a;
        if (!cqVar.s(request.getStFeed())) {
            return;
        }
        FeedCloudMeta$StFeed stFeed = request.getStFeed();
        String str8 = null;
        if (stFeed != null && (pBStringField4 = stFeed.f398449id) != null) {
            str = pBStringField4.get();
        } else {
            str = null;
        }
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        FeedCloudWrite$StDoReplyReq req = request.getReq();
        if (req != null && (feedCloudMeta$StComment2 = req.comment) != null && (pBStringField3 = feedCloudMeta$StComment2.f398447id) != null) {
            str3 = pBStringField3.get();
        } else {
            str3 = null;
        }
        if (str3 == null) {
            str4 = "";
        } else {
            str4 = str3;
        }
        FeedCloudWrite$StDoReplyReq req2 = request.getReq();
        if (req2 != null && (feedCloudMeta$StReply4 = req2.reply) != null && (pBStringField2 = feedCloudMeta$StReply4.f398460id) != null) {
            str5 = pBStringField2.get();
        } else {
            str5 = null;
        }
        if (str5 == null) {
            str6 = "";
        } else {
            str6 = str5;
        }
        FeedCloudWrite$StDoReplyReq req3 = request.getReq();
        if (req3 != null && (pBUInt32Field = req3.replyType) != null) {
            num = Integer.valueOf(pBUInt32Field.get());
        } else {
            num = null;
        }
        boolean z16 = true;
        QLog.d("QCircleDoReplyRequestInterceptor", 1, "[dispatchReplyEvent] feedId=" + str2 + ", commentId=" + str4 + ", replyId=" + str6 + ", replyType=" + num);
        if (num != null && num.intValue() == 1) {
            FeedCloudWrite$StDoReplyReq req4 = request.getReq();
            if (req4 == null || (feedCloudMeta$StReply3 = req4.reply) == null || (feedCloudMeta$StUser3 = feedCloudMeta$StReply3.targetUser) == null || !feedCloudMeta$StUser3.has()) {
                z16 = false;
            }
            FeedCloudWrite$StDoReplyReq req5 = request.getReq();
            if (!z16 ? !(req5 == null || (feedCloudMeta$StComment = req5.comment) == null || (feedCloudMeta$StUser = feedCloudMeta$StComment.postUser) == null) : !(req5 == null || (feedCloudMeta$StReply2 = req5.reply) == null || (feedCloudMeta$StUser = feedCloudMeta$StReply2.targetUser) == null)) {
                feedCloudMeta$StUser2 = feedCloudMeta$StUser.get();
            } else {
                feedCloudMeta$StUser2 = null;
            }
            String q16 = cqVar.q(request.getStFeed());
            FeedCloudWrite$StDoReplyReq req6 = request.getReq();
            if (req6 != null && (feedCloudMeta$StReply = req6.reply) != null && (pBStringField = feedCloudMeta$StReply.content) != null) {
                str8 = pBStringField.get();
            }
            if (str8 == null) {
                str7 = "";
            } else {
                str7 = str8;
            }
            w.d(str2, q16, str4, str6, feedCloudMeta$StUser2, str7);
            return;
        }
        if ((num == null || num.intValue() != 0) && (num == null || num.intValue() != 2)) {
            z16 = false;
        }
        if (z16) {
            w.g(str2, cqVar.q(request.getStFeed()), str4, str6);
        }
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
        QCircleDoReplyRequest qCircleDoReplyRequest = null;
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
            if (obj3 instanceof QCircleDoReplyRequest) {
                qCircleDoReplyRequest = (QCircleDoReplyRequest) obj3;
            }
            if (qCircleDoReplyRequest != null) {
                a(qCircleDoReplyRequest);
            }
        }
    }
}
