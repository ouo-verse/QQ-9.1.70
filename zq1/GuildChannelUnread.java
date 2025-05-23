package zq1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\n\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lzq1/b;", "Lzq1/e;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "guildId", "channelUin", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: zq1.b, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GuildChannelUnread extends e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String channelUin;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildChannelUnread(@NotNull String guildId, @NotNull String channelUin) {
        super(null);
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelUin, "channelUin");
        this.guildId = guildId;
        this.channelUin = channelUin;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getChannelUin() {
        return this.channelUin;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildChannelUnread)) {
            return false;
        }
        GuildChannelUnread guildChannelUnread = (GuildChannelUnread) other;
        if (Intrinsics.areEqual(this.guildId, guildChannelUnread.guildId) && Intrinsics.areEqual(this.channelUin, guildChannelUnread.channelUin)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.guildId.hashCode() * 31) + this.channelUin.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildChannelUnread(guildId=" + this.guildId + ", channelUin=" + this.channelUin + ")";
    }
}
