package rl1;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028&X\u00a6\u0004\u00a2\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\u0004R\u0016\u0010\r\u001a\u0004\u0018\u00010\n8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u000e8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00128&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00168&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001c\u001a\u00020\u00028&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u000e8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001d\u0010\u0010R\u0016\u0010\"\u001a\u0004\u0018\u00010\u001f8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b \u0010!R\u0016\u0010&\u001a\u0004\u0018\u00010#8&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010%R\u0016\u0010(\u001a\u0004\u0018\u00010\u00128&X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b'\u0010\u0014\u00a8\u0006)"}, d2 = {"Lrl1/a;", "", "", "getBusinessType", "()Ljava/lang/Integer;", "getBusinessType$annotations", "()V", "businessType", "a", "immersiveSource", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "b", "()Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "joinInfoParam", "", "getFeedId", "()Ljava/lang/String;", "feedId", "", "getStartTime", "()Ljava/lang/Long;", "startTime", "", "d", "()Ljava/lang/Boolean;", "needScrollToCommentArea", "c", "()I", "getCommentTitlePosition", "getTraceId", "traceId", "Landroidx/lifecycle/LifecycleOwner;", "getHostLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "hostLifecycleOwner", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedPublishInfo;", "e", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedPublishInfo;", "feedPublishInfo", "getTopicId", "topicId", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public interface a {
    @Nullable
    Integer a();

    @Nullable
    JumpGuildParam.JoinInfoParam b();

    int c();

    @Nullable
    Boolean d();

    @Nullable
    GuildFeedPublishInfo e();

    @Nullable
    Integer getBusinessType();

    @Nullable
    String getFeedId();

    @Nullable
    LifecycleOwner getHostLifecycleOwner();

    @Nullable
    Long getStartTime();

    @Nullable
    Long getTopicId();

    @NotNull
    String getTraceId();
}
