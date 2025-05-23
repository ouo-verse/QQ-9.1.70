package ru1;

import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.guild.message.unread.api.impl.GuildUnreadCntMsgAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000f\u001a\u00020\b\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u0017\u0010\r\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\n\u001a\u0004\b\u000e\u0010\fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\t\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lru1/a;", "", "", "c", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo;", "unreadInfoNew", "", "b", "", "a", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "getCategoryId", "categoryId", "Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo;", "()Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo;", "setUnreadInfo", "(Lcom/tencent/mobileqq/guild/message/unread/UnreadInfo;)V", "unreadInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String categoryId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private UnreadInfo unreadInfo;

    public a(@NotNull String guildId, @NotNull String categoryId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(categoryId, "categoryId");
        this.guildId = guildId;
        this.categoryId = categoryId;
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final UnreadInfo getUnreadInfo() {
        return this.unreadInfo;
    }

    public final boolean b(@NotNull UnreadInfo unreadInfoNew) {
        Intrinsics.checkNotNullParameter(unreadInfoNew, "unreadInfoNew");
        if (!Intrinsics.areEqual(unreadInfoNew, this.unreadInfo)) {
            this.unreadInfo = unreadInfoNew;
            return true;
        }
        return false;
    }

    public final void c() {
        GuildUnreadCntMsgAdapter.f230860a.k(this.guildId, this.categoryId);
    }
}
