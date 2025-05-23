package so1;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\n\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\r\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\tR\u0017\u0010\u0012\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0007\u001a\u0004\b\u000e\u0010\tR\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u000b\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lso1/b;", "Lso1/h;", "", "other", "", "e", "", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "guildId", "f", "b", "channelId", "g", "d", "title", tl.h.F, "sessionId", "", "i", "I", "()I", "cardType", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b extends h {

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
    private final String sessionId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int cardType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull String guildId, @NotNull String channelId, @NotNull String title, @NotNull String sessionId, int i3) {
        super(null, null, null, 7, null);
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.guildId = guildId;
        this.channelId = channelId;
        this.title = title;
        this.sessionId = sessionId;
        this.cardType = i3;
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
        if (!(other instanceof b)) {
            return false;
        }
        b bVar = (b) other;
        if (!Intrinsics.areEqual(bVar.getGuildId(), getGuildId()) || !Intrinsics.areEqual(bVar.getChannelId(), getChannelId()) || !Intrinsics.areEqual(bVar.getTitle(), getTitle()) || !Intrinsics.areEqual(bVar.sessionId, this.sessionId) || bVar.cardType != this.cardType) {
            return false;
        }
        return true;
    }

    /* renamed from: f, reason: from getter */
    public final int getCardType() {
        return this.cardType;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final String getSessionId() {
        return this.sessionId;
    }
}
