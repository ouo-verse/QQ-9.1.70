package xj1;

import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\b\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\b\u001a\u00020\u0006H&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\u000b\u001a\u00020\u0004H&\u00a8\u0006\f"}, d2 = {"Lxj1/c;", "", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "b", "", "getGuildId", "", "getBusinessType", "a", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "c", "getChannelName", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface c {
    int a();

    @NotNull
    JumpGuildParam.JoinInfoParam b();

    @NotNull
    GuildFeedBaseInitBean c();

    int getBusinessType();

    @NotNull
    String getChannelName();

    @NotNull
    String getGuildId();
}
