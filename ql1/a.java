package ql1;

import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import hl1.g;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u000e2\u00020\u0001:\u0001\tB-\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010\u001a\u001a\u00020\u0007\u0012\u0006\u0010\u001f\u001a\u00020\u001b\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0001H\u0016J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0006\u001a\u00020\u0001H\u0016R\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001a\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001f\u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Lql1/a;", "Lhl1/g;", "", "getItemType", "", "getItemId", "newItem", "", "b", "a", "", "c", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "e", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "Ljava/util/List;", "d", "()Ljava/util/List;", "feedsList", "Z", "f", "()Z", "loadMainDataSuccess", "", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "traceId", "<init>", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;Ljava/util/List;ZLjava/lang/String;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a implements g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IGProGuildInfo guildInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<GProStFeed> feedsList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean loadMainDataSuccess;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String traceId;

    public a(@NotNull IGProGuildInfo guildInfo, @NotNull List<GProStFeed> feedsList, boolean z16, @NotNull String traceId) {
        Intrinsics.checkNotNullParameter(guildInfo, "guildInfo");
        Intrinsics.checkNotNullParameter(feedsList, "feedsList");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        this.guildInfo = guildInfo;
        this.feedsList = feedsList;
        this.loadMainDataSuccess = z16;
        this.traceId = traceId;
    }

    @Override // hl1.g
    public boolean a(@NotNull g newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        if (!(newItem instanceof a)) {
            return false;
        }
        a aVar = (a) newItem;
        if (aVar.feedsList.size() != this.feedsList.size() || aVar.guildInfo.isMember() != this.guildInfo.isMember()) {
            return false;
        }
        return true;
    }

    @Override // hl1.g
    public boolean b(@NotNull g newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return newItem instanceof a;
    }

    @Override // hl1.g
    @Nullable
    public Object c(@NotNull g newItem) {
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        return null;
    }

    @NotNull
    public final List<GProStFeed> d() {
        return this.feedsList;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final IGProGuildInfo getGuildInfo() {
        return this.guildInfo;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getLoadMainDataSuccess() {
        return this.loadMainDataSuccess;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    @Override // hl1.g
    public long getItemId() {
        return -20476302;
    }

    @Override // hl1.g
    public int getItemType() {
        return 9;
    }
}
