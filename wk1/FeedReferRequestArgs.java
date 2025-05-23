package wk1;

import android.content.Context;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStCommonExt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\u0006\u0010\u0019\u001a\u00020\u0013\u0012\u0006\u0010\u001d\u001a\u00020\u0004\u0012\u0006\u0010!\u001a\u00020\u0007\u0012\u0006\u0010&\u001a\u00020\"\u00a2\u0006\u0004\b'\u0010(J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0017\u0010\u0019\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\n\u0010\u0016R\u0017\u0010\u001d\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u001cR\u0017\u0010!\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 R\u0017\u0010&\u001a\u00020\"8\u0006\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b\u001a\u0010%\u00a8\u0006)"}, d2 = {"Lwk1/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "feedId", "", "c", "J", "()J", "guildId", "d", "channelId", "e", "I", "()I", "preferCount", "f", "Z", "()Z", "isPrefer", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStCommonExt;", "g", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStCommonExt;", "()Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStCommonExt;", "stCommonExt", "<init>", "(Landroid/content/Context;Ljava/lang/String;JJIZLcom/tencent/qqnt/kernelgpro/nativeinterface/GProStCommonExt;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: wk1.b, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class FeedReferRequestArgs {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String feedId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long guildId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final long channelId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final int preferCount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean isPrefer;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final GProStCommonExt stCommonExt;

    public FeedReferRequestArgs(@NotNull Context context, @NotNull String feedId, long j3, long j16, int i3, boolean z16, @NotNull GProStCommonExt stCommonExt) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(stCommonExt, "stCommonExt");
        this.context = context;
        this.feedId = feedId;
        this.guildId = j3;
        this.channelId = j16;
        this.preferCount = i3;
        this.isPrefer = z16;
        this.stCommonExt = stCommonExt;
    }

    /* renamed from: a, reason: from getter */
    public final long getChannelId() {
        return this.channelId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    /* renamed from: c, reason: from getter */
    public final long getGuildId() {
        return this.guildId;
    }

    /* renamed from: d, reason: from getter */
    public final int getPreferCount() {
        return this.preferCount;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final GProStCommonExt getStCommonExt() {
        return this.stCommonExt;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FeedReferRequestArgs)) {
            return false;
        }
        FeedReferRequestArgs feedReferRequestArgs = (FeedReferRequestArgs) other;
        if (Intrinsics.areEqual(this.context, feedReferRequestArgs.context) && Intrinsics.areEqual(this.feedId, feedReferRequestArgs.feedId) && this.guildId == feedReferRequestArgs.guildId && this.channelId == feedReferRequestArgs.channelId && this.preferCount == feedReferRequestArgs.preferCount && this.isPrefer == feedReferRequestArgs.isPrefer && Intrinsics.areEqual(this.stCommonExt, feedReferRequestArgs.stCommonExt)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsPrefer() {
        return this.isPrefer;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((((((((this.context.hashCode() * 31) + this.feedId.hashCode()) * 31) + androidx.fragment.app.a.a(this.guildId)) * 31) + androidx.fragment.app.a.a(this.channelId)) * 31) + this.preferCount) * 31;
        boolean z16 = this.isPrefer;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        return ((hashCode + i3) * 31) + this.stCommonExt.hashCode();
    }

    @NotNull
    public String toString() {
        return "FeedReferRequestArgs(context=" + this.context + ", feedId=" + this.feedId + ", guildId=" + this.guildId + ", channelId=" + this.channelId + ", preferCount=" + this.preferCount + ", isPrefer=" + this.isPrefer + ", stCommonExt=" + this.stCommonExt + ")";
    }
}
