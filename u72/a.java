package u72;

import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$Feed;
import com.tencent.trpcprotocol.qqstranger.common.feed.FeedPB$StImage;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\u0004\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0006\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003\"\u001a\u0010\n\u001a\u0004\u0018\u00010\u0007*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\"\u0018\u0010\f\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\u0003\"(\u0010\u0013\u001a\u00020\r*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r8@@@X\u0080\u000e\u00a2\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\"(\u0010\u0019\u001a\u00020\u0014*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00148@@@X\u0080\u000e\u00a2\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\"(\u0010\u001c\u001a\u00020\u0014*\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00148@@@X\u0080\u000e\u00a2\u0006\f\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018\"\u0018\u0010\u001e\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0003\"\u0018\u0010 \u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010\u0003\"\u0018\u0010$\u001a\u00020!*\u00020\u00008@X\u0080\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#\u00a8\u0006%"}, d2 = {"Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;", "", "b", "(Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;)Ljava/lang/String;", "feedId", "d", "feedText", "Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$StImage;", "c", "(Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;)Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$StImage;", "feedImage", h.F, "recomTrace", "", "value", "j", "(Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;)Z", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;Z)V", "isLiked", "", "f", "(Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;)I", "l", "(Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;I)V", MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_LIKE_COUNT, "a", "k", "commentCount", "e", "formatCreateTime", "g", "openId", "", "i", "(Lcom/tencent/trpcprotocol/qqstranger/common/feed/FeedPB$Feed;)J", "tinyId", "matchfriend_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {
    public static final int a(FeedPB$Feed feedPB$Feed) {
        Intrinsics.checkNotNullParameter(feedPB$Feed, "<this>");
        return feedPB$Feed.comment_count.get();
    }

    public static final String b(FeedPB$Feed feedPB$Feed) {
        Intrinsics.checkNotNullParameter(feedPB$Feed, "<this>");
        String str = feedPB$Feed.feed_id.get();
        return str == null ? "0" : str;
    }

    public static final FeedPB$StImage c(FeedPB$Feed feedPB$Feed) {
        Object orNull;
        Intrinsics.checkNotNullParameter(feedPB$Feed, "<this>");
        List<FeedPB$StImage> list = feedPB$Feed.images.get();
        Intrinsics.checkNotNullExpressionValue(list, "images.get()");
        orNull = CollectionsKt___CollectionsKt.getOrNull(list, 0);
        return (FeedPB$StImage) orNull;
    }

    public static final String d(FeedPB$Feed feedPB$Feed) {
        Intrinsics.checkNotNullParameter(feedPB$Feed, "<this>");
        try {
            String stringUtf8 = feedPB$Feed.custom_text.get().toStringUtf8();
            if (stringUtf8 == null) {
                return "";
            }
            Intrinsics.checkNotNullExpressionValue(stringUtf8, "custom_text.get().toStringUtf8() ?: \"\"");
            return stringUtf8;
        } catch (Exception e16) {
            QLog.d("QQStrangerFeed", 1, "custom_text error ", e16);
            return "";
        }
    }

    public static final String e(FeedPB$Feed feedPB$Feed) {
        Intrinsics.checkNotNullParameter(feedPB$Feed, "<this>");
        return com.tencent.mobileqq.matchfriend.reborn.content.main.framework.utils.d.f244359a.a(feedPB$Feed.create_time.get() * 1000);
    }

    public static final int f(FeedPB$Feed feedPB$Feed) {
        Intrinsics.checkNotNullParameter(feedPB$Feed, "<this>");
        return feedPB$Feed.like_info.count.get();
    }

    public static final String g(FeedPB$Feed feedPB$Feed) {
        Intrinsics.checkNotNullParameter(feedPB$Feed, "<this>");
        String str = feedPB$Feed.poster.open_id.get();
        return str == null ? "" : str;
    }

    public static final String h(FeedPB$Feed feedPB$Feed) {
        Intrinsics.checkNotNullParameter(feedPB$Feed, "<this>");
        String str = feedPB$Feed.recom_trace.get();
        return str == null ? "" : str;
    }

    public static final long i(FeedPB$Feed feedPB$Feed) {
        Intrinsics.checkNotNullParameter(feedPB$Feed, "<this>");
        return feedPB$Feed.poster.tiny_id.get();
    }

    public static final boolean j(FeedPB$Feed feedPB$Feed) {
        Intrinsics.checkNotNullParameter(feedPB$Feed, "<this>");
        return feedPB$Feed.like_info.my_like.get() == 1;
    }

    public static final void k(FeedPB$Feed feedPB$Feed, int i3) {
        Intrinsics.checkNotNullParameter(feedPB$Feed, "<this>");
        feedPB$Feed.comment_count.set(i3);
    }

    public static final void l(FeedPB$Feed feedPB$Feed, int i3) {
        Intrinsics.checkNotNullParameter(feedPB$Feed, "<this>");
        feedPB$Feed.like_info.count.set(i3);
    }

    public static final void m(FeedPB$Feed feedPB$Feed, boolean z16) {
        Intrinsics.checkNotNullParameter(feedPB$Feed, "<this>");
        feedPB$Feed.like_info.my_like.set(z16 ? 1 : 0);
    }
}
