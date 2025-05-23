package va0;

import com.tencent.biz.qqcircle.requests.QCircleDoLikeRequest;
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
import feedcloud.FeedCloudWrite$StDoLikeReq;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J!\u0010\t\u001a\u00020\u00042\u0010\u0010\b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0007\u0018\u00010\u0006H\u0016\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lva0/c;", "Lcom/tencent/biz/richframework/network/request/RequestInterceptor;", "Lcom/tencent/biz/qqcircle/requests/QCircleDoLikeRequest;", Const.BUNDLE_KEY_REQUEST, "", "a", "", "", "result", "interceptResponse", "([Ljava/lang/Object;)V", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class c implements RequestInterceptor {
    private final void a(QCircleDoLikeRequest request) {
        String str;
        int i3;
        FeedCloudMeta$StComment feedCloudMeta$StComment;
        PBStringField pBStringField;
        FeedCloudMeta$StComment feedCloudMeta$StComment2;
        PBStringField pBStringField2;
        String str2;
        FeedCloudMeta$StReply feedCloudMeta$StReply;
        PBStringField pBStringField3;
        FeedCloudMeta$StComment feedCloudMeta$StComment3;
        PBStringField pBStringField4;
        String str3;
        FeedCloudMeta$StReply feedCloudMeta$StReply2;
        PBStringField pBStringField5;
        FeedCloudMeta$StComment feedCloudMeta$StComment4;
        PBStringField pBStringField6;
        PBUInt32Field pBUInt32Field;
        PBStringField pBStringField7;
        cq cqVar = cq.f92752a;
        if (!cqVar.s(request.getStFeed())) {
            return;
        }
        FeedCloudMeta$StFeed stFeed = request.getStFeed();
        String str4 = null;
        if (stFeed != null && (pBStringField7 = stFeed.f398449id) != null) {
            str = pBStringField7.get();
        } else {
            str = null;
        }
        String str5 = "";
        if (str == null) {
            str = "";
        }
        FeedCloudWrite$StDoLikeReq req = request.getReq();
        if (req != null && (pBUInt32Field = req.likeType) != null) {
            i3 = pBUInt32Field.get();
        } else {
            i3 = -1;
        }
        QLog.d("QCircleDoLikeRequestInterceptor", 1, "[dispatchLikeEvent] feedId=" + str + ", likeType=" + i3);
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            if (i3 == 6) {
                                String q16 = cqVar.q(request.getStFeed());
                                FeedCloudWrite$StDoLikeReq req2 = request.getReq();
                                if (req2 != null && (feedCloudMeta$StComment4 = req2.comment) != null && (pBStringField6 = feedCloudMeta$StComment4.f398447id) != null) {
                                    str3 = pBStringField6.get();
                                } else {
                                    str3 = null;
                                }
                                if (str3 == null) {
                                    str3 = "";
                                }
                                FeedCloudWrite$StDoLikeReq req3 = request.getReq();
                                if (req3 != null && (feedCloudMeta$StReply2 = req3.reply) != null && (pBStringField5 = feedCloudMeta$StReply2.f398460id) != null) {
                                    str4 = pBStringField5.get();
                                }
                                if (str4 != null) {
                                    str5 = str4;
                                }
                                w.j(str, q16, str3, str5, false);
                                return;
                            }
                            return;
                        }
                        String q17 = cqVar.q(request.getStFeed());
                        FeedCloudWrite$StDoLikeReq req4 = request.getReq();
                        if (req4 != null && (feedCloudMeta$StComment3 = req4.comment) != null && (pBStringField4 = feedCloudMeta$StComment3.f398447id) != null) {
                            str2 = pBStringField4.get();
                        } else {
                            str2 = null;
                        }
                        if (str2 == null) {
                            str2 = "";
                        }
                        FeedCloudWrite$StDoLikeReq req5 = request.getReq();
                        if (req5 != null && (feedCloudMeta$StReply = req5.reply) != null && (pBStringField3 = feedCloudMeta$StReply.f398460id) != null) {
                            str4 = pBStringField3.get();
                        }
                        if (str4 != null) {
                            str5 = str4;
                        }
                        w.j(str, q17, str2, str5, true);
                        return;
                    }
                    String q18 = cqVar.q(request.getStFeed());
                    FeedCloudWrite$StDoLikeReq req6 = request.getReq();
                    if (req6 != null && (feedCloudMeta$StComment2 = req6.comment) != null && (pBStringField2 = feedCloudMeta$StComment2.f398447id) != null) {
                        str4 = pBStringField2.get();
                    }
                    if (str4 != null) {
                        str5 = str4;
                    }
                    w.h(str, q18, str5, false);
                    return;
                }
                String q19 = cqVar.q(request.getStFeed());
                FeedCloudWrite$StDoLikeReq req7 = request.getReq();
                if (req7 != null && (feedCloudMeta$StComment = req7.comment) != null && (pBStringField = feedCloudMeta$StComment.f398447id) != null) {
                    str4 = pBStringField.get();
                }
                if (str4 != null) {
                    str5 = str4;
                }
                w.h(str, q19, str5, true);
                return;
            }
            w.i(str, cqVar.q(request.getStFeed()), true);
            return;
        }
        w.i(str, cqVar.q(request.getStFeed()), false);
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
        QCircleDoLikeRequest qCircleDoLikeRequest = null;
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
            if (obj3 instanceof QCircleDoLikeRequest) {
                qCircleDoLikeRequest = (QCircleDoLikeRequest) obj3;
            }
            if (qCircleDoLikeRequest != null) {
                a(qCircleDoLikeRequest);
            }
        }
    }
}
