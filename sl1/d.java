package sl1;

import com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.FeedDetailMainData;
import com.tencent.mobileqq.qroute.QRoute;
import hl1.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qj1.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lsl1/d;", "Lsl1/b;", "Lhl1/g;", "", "messageKey", "contentData", "", "c", "", "d", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d implements b<g> {
    @Override // sl1.b
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean b(@NotNull String messageKey, @NotNull g contentData) {
        Intrinsics.checkNotNullParameter(messageKey, "messageKey");
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        if (Intrinsics.areEqual(messageKey, "message_on_load_main_completed") && (contentData instanceof FeedDetailMainData)) {
            return true;
        }
        return false;
    }

    @Override // sl1.b
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull g contentData) {
        FeedDetailMainData feedDetailMainData;
        h feedDetail;
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        if (contentData instanceof FeedDetailMainData) {
            feedDetailMainData = (FeedDetailMainData) contentData;
        } else {
            feedDetailMainData = null;
        }
        boolean z16 = false;
        if (feedDetailMainData != null && (feedDetail = feedDetailMainData.getFeedDetail()) != null) {
            if (com.tencent.mobileqq.guild.discoveryv2.util.a.f217788a.a(feedDetail.getFeedType())) {
                z16 = true;
            }
        }
        if (z16) {
            ((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).initGuildTaskQueueManager();
        }
    }
}
