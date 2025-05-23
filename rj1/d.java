package rj1;

import com.tencent.mobileqq.guild.discoveryv2.content.recommend.data.RecommendExtData;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedPublishInfo;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProContentRecommendGuild;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rj1.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007H\u0016R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lrj1/d;", "Lrj1/b;", "", "getBusinessType", "a", "", "d", "Lkotlin/Pair;", "b", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "g", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;", "recommendExt", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendGuild;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendGuild;", "f", "()Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendGuild;", "guildInfo", "<init>", "(Lcom/tencent/mobileqq/guild/discoveryv2/content/recommend/data/r;Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProContentRecommendGuild;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class d implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecommendExtData recommendExt;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final IGProContentRecommendGuild guildInfo;

    public d(@NotNull RecommendExtData recommendExt, @Nullable IGProContentRecommendGuild iGProContentRecommendGuild) {
        Intrinsics.checkNotNullParameter(recommendExt, "recommendExt");
        this.recommendExt = recommendExt;
        this.guildInfo = iGProContentRecommendGuild;
    }

    @Override // tk1.b
    public int a() {
        return 8;
    }

    @Override // tk1.b
    @NotNull
    public Pair<String, String> b() {
        return TuplesKt.to("discover", "discover_channel_forum_recommend");
    }

    @Override // rj1.b
    @Nullable
    public GuildTaskProgressState c() {
        return b.a.b(this);
    }

    @Override // tk1.b
    @NotNull
    public String d() {
        return "";
    }

    @Override // rj1.b
    @Nullable
    public GuildFeedPublishInfo e() {
        return b.a.a(this);
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final IGProContentRecommendGuild getGuildInfo() {
        return this.guildInfo;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final RecommendExtData getRecommendExt() {
        return this.recommendExt;
    }

    @Override // tk1.b
    public int getBusinessType() {
        return 17;
    }
}
