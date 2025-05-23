package so1;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\r\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u001a\u0010\n\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\r\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0007\u001a\u0004\b\f\u0010\tR\u001a\u0010\u0010\u001a\u00020\u00068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\tR\u0017\u0010\u0016\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lso1/j;", "Lso1/h;", "", "other", "", "e", "", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "guildId", "f", "b", "channelId", "g", "d", "title", "", tl.h.F, "J", "getCategoryId", "()J", "categoryId", "i", "Z", "getCanCreateChannel", "()Z", "canCreateChannel", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JZ)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class j extends h {

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
    private final long categoryId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final boolean canCreateChannel;

    public /* synthetic */ j(String str, String str2, String str3, long j3, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, j3, z16);
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
        if (!(other instanceof j)) {
            return false;
        }
        j jVar = (j) other;
        if (!Intrinsics.areEqual(jVar.getGuildId(), getGuildId()) || !Intrinsics.areEqual(jVar.getChannelId(), getChannelId()) || !Intrinsics.areEqual(jVar.getTitle(), getTitle()) || jVar.categoryId != this.categoryId || jVar.canCreateChannel != this.canCreateChannel) {
            return false;
        }
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@NotNull String guildId, @NotNull String channelId, @NotNull String title, long j3, boolean z16) {
        super(null, null, null, 7, null);
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(title, "title");
        this.guildId = guildId;
        this.channelId = channelId;
        this.title = title;
        this.categoryId = j3;
        this.canCreateChannel = z16;
    }
}
