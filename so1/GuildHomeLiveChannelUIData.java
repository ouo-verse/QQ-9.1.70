package so1;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u00d6\u0003R\u001a\u0010\u000e\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0011\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\u0014\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000b\u001a\u0004\b\u0013\u0010\rR\u0017\u0010\u0016\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u0017\u0010\u0019\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u000b\u001a\u0004\b\u0018\u0010\rR\u0017\u0010\u001b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u000b\u001a\u0004\b\u0012\u0010\r\u00a8\u0006\u001e"}, d2 = {"Lso1/i;", "Lso1/h;", "", "other", "", "e", "", "toString", "", "hashCode", "equals", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "guildId", "f", "b", "channelId", "g", "d", "title", tl.h.F, "coverUrl", "i", "getRoomName", "roomName", "j", "roomId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: so1.i, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class GuildHomeLiveChannelUIData extends h {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String channelId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String title;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String coverUrl;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String roomName;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String roomId;

    public /* synthetic */ GuildHomeLiveChannelUIData(String str, String str2, String str3, String str4, String str5, String str6, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, (i3 & 16) != 0 ? "" : str5, (i3 & 32) != 0 ? "" : str6);
    }

    @Override // so1.h
    @NotNull
    /* renamed from: b, reason: from getter */
    public String getChannelId() {
        return this.channelId;
    }

    @Override // so1.h
    @NotNull
    /* renamed from: c, reason: from getter */
    public String getGuildId() {
        return this.guildId;
    }

    @Override // so1.h
    @NotNull
    /* renamed from: d, reason: from getter */
    public String getTitle() {
        return this.title;
    }

    @Override // so1.h
    public boolean e(@NotNull Object other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if ((other instanceof GuildHomeLiveChannelUIData) && Intrinsics.areEqual(other, this)) {
            return true;
        }
        return false;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildHomeLiveChannelUIData)) {
            return false;
        }
        GuildHomeLiveChannelUIData guildHomeLiveChannelUIData = (GuildHomeLiveChannelUIData) other;
        if (Intrinsics.areEqual(getGuildId(), guildHomeLiveChannelUIData.getGuildId()) && Intrinsics.areEqual(getChannelId(), guildHomeLiveChannelUIData.getChannelId()) && Intrinsics.areEqual(getTitle(), guildHomeLiveChannelUIData.getTitle()) && Intrinsics.areEqual(this.coverUrl, guildHomeLiveChannelUIData.coverUrl) && Intrinsics.areEqual(this.roomName, guildHomeLiveChannelUIData.roomName) && Intrinsics.areEqual(this.roomId, guildHomeLiveChannelUIData.roomId)) {
            return true;
        }
        return false;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getCoverUrl() {
        return this.coverUrl;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getRoomId() {
        return this.roomId;
    }

    public int hashCode() {
        return (((((((((getGuildId().hashCode() * 31) + getChannelId().hashCode()) * 31) + getTitle().hashCode()) * 31) + this.coverUrl.hashCode()) * 31) + this.roomName.hashCode()) * 31) + this.roomId.hashCode();
    }

    @NotNull
    public String toString() {
        return "GuildHomeLiveChannelUIData(guildId=" + getGuildId() + ", channelId=" + getChannelId() + ", title=" + getTitle() + ", coverUrl=" + this.coverUrl + ", roomName=" + this.roomName + ", roomId=" + this.roomId + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildHomeLiveChannelUIData(@NotNull String guildId, @NotNull String channelId, @NotNull String title, @NotNull String coverUrl, @NotNull String roomName, @NotNull String roomId) {
        super(null, null, null, 7, null);
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(coverUrl, "coverUrl");
        Intrinsics.checkNotNullParameter(roomName, "roomName");
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        this.guildId = guildId;
        this.channelId = channelId;
        this.title = title;
        this.coverUrl = coverUrl;
        this.roomName = roomName;
        this.roomId = roomId;
    }
}
