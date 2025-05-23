package ru1;

import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.guild.message.unread.api.impl.GuildUnreadCntMsgAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\b\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0010\u001a\u0004\b\t\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lru1/c;", "", "", "c", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo;", "unreadInfoNew", "", "b", "", "a", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "<set-?>", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "()Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo$a;", "unreadCount", "<init>", "(Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private UnreadInfo.a unreadCount;

    public c(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.guildId = guildId;
        this.unreadCount = new UnreadInfo.a(false, 0, 0, 4, null);
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final UnreadInfo.a getUnreadCount() {
        return this.unreadCount;
    }

    public final synchronized boolean b(@NotNull UnreadInfo unreadInfoNew) {
        UnreadInfo.a aVar;
        Intrinsics.checkNotNullParameter(unreadInfoNew, "unreadInfoNew");
        aVar = new UnreadInfo.a(this.unreadCount.getIsStrongUnread(), this.unreadCount.getCount(), 0, 4, null);
        this.unreadCount = unreadInfoNew.f();
        return !Intrinsics.areEqual(aVar, r8);
    }

    public final synchronized void c() {
        GuildUnreadCntMsgAdapter.f230860a.p(this.guildId);
    }
}
