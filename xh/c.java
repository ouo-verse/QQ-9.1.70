package xh;

import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.tencent.qqnt.kernel.nativeinterface.StComment;
import com.tencent.qqnt.kernel.nativeinterface.StFeed;
import com.tencent.qqnt.kernel.nativeinterface.StLike;
import com.tencent.qqnt.kernel.nativeinterface.StReply;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J2\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ*\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ@\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\u0018"}, d2 = {"Lxh/c;", "", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "", "spaceId", "Lcom/qzone/proxy/feedcomponent/model/Comment;", "comment", "", "actionType", "Lkotlin/Pair;", "Lcom/tencent/qqnt/kernel/nativeinterface/StFeed;", "Lcom/tencent/qqnt/kernel/nativeinterface/StComment;", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/StLike;", "c", "Lcom/qzone/proxy/feedcomponent/model/Reply;", "reply", "Lkotlin/Triple;", "Lcom/tencent/qqnt/kernel/nativeinterface/StReply;", "d", "b", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f448000a = new c();

    c() {
    }

    public final Pair<StFeed, StComment> a(BusinessFeedData feedData, String spaceId, Comment comment, int actionType) {
        StComment j3;
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        Intrinsics.checkNotNullParameter(comment, "comment");
        StFeed k3 = d.k(feedData, spaceId, actionType == 2 || actionType == 4);
        j3 = d.j(comment, actionType);
        return new Pair<>(k3, j3);
    }

    public final StFeed b(BusinessFeedData feedData, String spaceId) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        return d.l(feedData, spaceId, false, 4, null);
    }

    public final Pair<StFeed, StLike> c(BusinessFeedData feedData, String spaceId, int actionType) {
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        return new Pair<>(d.l(feedData, spaceId, false, 4, null), d.n(feedData, spaceId, actionType, false, 8, null));
    }

    public final Triple<StFeed, StComment, StReply> d(BusinessFeedData feedData, String spaceId, Comment comment, Reply reply, int actionType) {
        StComment j3;
        StReply e16;
        Intrinsics.checkNotNullParameter(feedData, "feedData");
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        Intrinsics.checkNotNullParameter(comment, "comment");
        Intrinsics.checkNotNullParameter(reply, "reply");
        StFeed k3 = d.k(feedData, spaceId, actionType == 2 || actionType == 4);
        j3 = d.j(comment, actionType);
        e16 = d.e(reply);
        return new Triple<>(k3, j3, e16);
    }
}
