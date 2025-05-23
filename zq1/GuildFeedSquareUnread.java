package zq1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lzq1/c;", "Lzq1/e;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "<init>", "(Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: zq1.c, reason: from toString */
/* loaded from: classes14.dex */
public final /* data */ class GuildFeedSquareUnread extends e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String guildId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFeedSquareUnread(@NotNull String guildId) {
        super(null);
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof GuildFeedSquareUnread) && Intrinsics.areEqual(this.guildId, ((GuildFeedSquareUnread) other).guildId)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.guildId.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildFeedSquareUnread(guildId=" + this.guildId + ")";
    }
}
