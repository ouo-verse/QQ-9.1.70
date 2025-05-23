package rj1;

import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lrj1/b;", "Ltk1/b;", "Lcom/tencent/mobileqq/guild/feed/publish/bean/GuildTaskProgressState;", "c", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedPublishInfo;", "e", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface b extends tk1.b {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public static final class a {
        @Nullable
        public static GuildFeedPublishInfo a(@NotNull b bVar) {
            return null;
        }

        @Nullable
        public static GuildTaskProgressState b(@NotNull b bVar) {
            return null;
        }
    }

    @Nullable
    GuildTaskProgressState c();

    @Nullable
    GuildFeedPublishInfo e();
}
