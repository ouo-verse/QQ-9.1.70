package yt1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0014\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0016\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0019\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0017\u001a\u0004\b\u0015\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lyt1/a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "guildId", "b", "channelId", "", "J", "e", "()J", "time", "d", "content", "Z", "()Z", "hasDraft", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;)V", "qqguild-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: yt1.a, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class DraftInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String channelId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long time;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String content;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean hasDraft;

    public DraftInfo(@NotNull String guildId, @NotNull String channelId, long j3, @NotNull String content) {
        boolean z16;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(content, "content");
        this.guildId = guildId;
        this.channelId = channelId;
        this.time = j3;
        this.content = content;
        if (content.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.hasDraft = z16;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    /* renamed from: d, reason: from getter */
    public final boolean getHasDraft() {
        return this.hasDraft;
    }

    /* renamed from: e, reason: from getter */
    public final long getTime() {
        return this.time;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DraftInfo)) {
            return false;
        }
        DraftInfo draftInfo = (DraftInfo) other;
        if (Intrinsics.areEqual(this.guildId, draftInfo.guildId) && Intrinsics.areEqual(this.channelId, draftInfo.channelId) && this.time == draftInfo.time && Intrinsics.areEqual(this.content, draftInfo.content)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.guildId.hashCode() * 31) + this.channelId.hashCode()) * 31) + androidx.fragment.app.a.a(this.time)) * 31) + this.content.hashCode();
    }

    @NotNull
    public String toString() {
        return "DraftInfo(guildId=" + this.guildId + ", channelId=" + this.channelId + ", time=" + this.time + ", content=" + this.content + ')';
    }
}
