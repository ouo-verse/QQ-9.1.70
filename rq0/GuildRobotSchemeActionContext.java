package rq0;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n14.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000e\u001a\u00020\n\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0015\u001a\u0004\b\u0010\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lrq0/a;", "Ln14/c;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/aio/api/runtime/a;", "a", "Lcom/tencent/aio/api/runtime/a;", "()Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "b", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "c", "()Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "msgItemRef", "Ljava/lang/String;", "()Ljava/lang/String;", "atTinyId", "<init>", "(Lcom/tencent/aio/api/runtime/a;Lcom/tencent/guild/api/data/msglist/GuildMsgItem;Ljava/lang/String;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: rq0.a, reason: from toString */
/* loaded from: classes6.dex */
public final /* data */ class GuildRobotSchemeActionContext implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final GuildMsgItem msgItemRef;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final String atTinyId;

    public GuildRobotSchemeActionContext(@NotNull com.tencent.aio.api.runtime.a aioContext, @Nullable GuildMsgItem guildMsgItem, @Nullable String str) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        this.aioContext = aioContext;
        this.msgItemRef = guildMsgItem;
        this.atTinyId = str;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final com.tencent.aio.api.runtime.a getAioContext() {
        return this.aioContext;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final String getAtTinyId() {
        return this.atTinyId;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final GuildMsgItem getMsgItemRef() {
        return this.msgItemRef;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildRobotSchemeActionContext)) {
            return false;
        }
        GuildRobotSchemeActionContext guildRobotSchemeActionContext = (GuildRobotSchemeActionContext) other;
        if (Intrinsics.areEqual(this.aioContext, guildRobotSchemeActionContext.aioContext) && Intrinsics.areEqual(this.msgItemRef, guildRobotSchemeActionContext.msgItemRef) && Intrinsics.areEqual(this.atTinyId, guildRobotSchemeActionContext.atTinyId)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = this.aioContext.hashCode() * 31;
        GuildMsgItem guildMsgItem = this.msgItemRef;
        int i3 = 0;
        if (guildMsgItem == null) {
            hashCode = 0;
        } else {
            hashCode = guildMsgItem.hashCode();
        }
        int i16 = (hashCode2 + hashCode) * 31;
        String str = this.atTinyId;
        if (str != null) {
            i3 = str.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "GuildRobotSchemeActionContext(aioContext=" + this.aioContext + ", msgItemRef=" + this.msgItemRef + ", atTinyId=" + this.atTinyId + ")";
    }

    public /* synthetic */ GuildRobotSchemeActionContext(com.tencent.aio.api.runtime.a aVar, GuildMsgItem guildMsgItem, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(aVar, guildMsgItem, (i3 & 4) != 0 ? (guildMsgItem == null || (r3 = guildMsgItem.getMsgRecord()) == null) ? null : r3.senderUid : str);
        MsgRecord msgRecord;
    }
}
