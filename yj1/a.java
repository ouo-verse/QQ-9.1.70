package yj1;

import com.tencent.biz.richframework.part.adapter.delegate.AdapterDelegatesManager;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedOperateData;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lyj1/a;", "Lcom/tencent/biz/richframework/part/adapter/delegate/AdapterDelegatesManager;", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedOperateData;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a extends AdapterDelegatesManager<List<? extends GuildFeedOperateData>> {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f450487a;

    static {
        a aVar = new a();
        f450487a = aVar;
        aVar.addDelegate(20, new vj1.d());
    }

    a() {
    }
}
