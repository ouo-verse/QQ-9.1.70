package so1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0006\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\n\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\r\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\tR\u0017\u0010\u0012\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u000b\u0010\t\u00a8\u0006\u0015"}, d2 = {"Lso1/k;", "Lso1/h;", "", "other", "", "e", "", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "guildId", "f", "b", "channelId", "g", "d", "title", tl.h.F, "roomId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class k extends h {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String channelId;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String title;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String roomId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(@NotNull String guildId, @NotNull String channelId, @NotNull String title, @NotNull String roomId) {
        super(null, null, null, 7, null);
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(roomId, "roomId");
        this.guildId = guildId;
        this.channelId = channelId;
        this.title = title;
        this.roomId = roomId;
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
        if (!(other instanceof k)) {
            return false;
        }
        k kVar = (k) other;
        if (!Intrinsics.areEqual(kVar.getGuildId(), getGuildId()) || !Intrinsics.areEqual(kVar.getChannelId(), getChannelId()) || !Intrinsics.areEqual(kVar.getTitle(), getTitle()) || !Intrinsics.areEqual(kVar.roomId, this.roomId)) {
            return false;
        }
        return true;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getRoomId() {
        return this.roomId;
    }
}
