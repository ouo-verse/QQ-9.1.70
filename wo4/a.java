package wo4;

import com.tencent.imcore.message.Message;
import com.tencent.qqnt.kernel.nativeinterface.GuildGroupOptType;
import com.tencent.troopguild.api.ITroopGuildMsgApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0003*\u00020\u0000\u001a\n\u0010\u0007\u001a\u00020\u0006*\u00020\u0000\u001a\n\u0010\b\u001a\u00020\u0006*\u00020\u0000\u001a\u0012\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\t\u001a\u00020\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/imcore/message/Message;", "", "e", "", "b", "a", "", "d", "c", "pushType", "", "f", "troop-guild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class a {
    @NotNull
    public static final String a(@NotNull Message message) {
        ITroopGuildMsgApi.MsgPushInfo msgPushInfo;
        String channelId;
        Intrinsics.checkNotNullParameter(message, "<this>");
        Object obj = message.extObj;
        if (obj instanceof ITroopGuildMsgApi.MsgPushInfo) {
            msgPushInfo = (ITroopGuildMsgApi.MsgPushInfo) obj;
        } else {
            msgPushInfo = null;
        }
        if (msgPushInfo == null || (channelId = msgPushInfo.getChannelId()) == null) {
            return "";
        }
        return channelId;
    }

    @NotNull
    public static final String b(@NotNull Message message) {
        ITroopGuildMsgApi.MsgPushInfo msgPushInfo;
        String guildId;
        Intrinsics.checkNotNullParameter(message, "<this>");
        Object obj = message.extObj;
        if (obj instanceof ITroopGuildMsgApi.MsgPushInfo) {
            msgPushInfo = (ITroopGuildMsgApi.MsgPushInfo) obj;
        } else {
            msgPushInfo = null;
        }
        if (msgPushInfo == null || (guildId = msgPushInfo.getGuildId()) == null) {
            return "";
        }
        return guildId;
    }

    public static final int c(@NotNull Message message) {
        ITroopGuildMsgApi.MsgPushInfo msgPushInfo;
        Intrinsics.checkNotNullParameter(message, "<this>");
        Object obj = message.extObj;
        if (obj instanceof ITroopGuildMsgApi.MsgPushInfo) {
            msgPushInfo = (ITroopGuildMsgApi.MsgPushInfo) obj;
        } else {
            msgPushInfo = null;
        }
        if (msgPushInfo != null) {
            return msgPushInfo.getPushPlace();
        }
        return 0;
    }

    public static final int d(@NotNull Message message) {
        ITroopGuildMsgApi.MsgPushInfo msgPushInfo;
        Intrinsics.checkNotNullParameter(message, "<this>");
        Object obj = message.extObj;
        if (obj instanceof ITroopGuildMsgApi.MsgPushInfo) {
            msgPushInfo = (ITroopGuildMsgApi.MsgPushInfo) obj;
        } else {
            msgPushInfo = null;
        }
        if (msgPushInfo != null) {
            return msgPushInfo.getPushType();
        }
        return GuildGroupOptType.KUNKNOWN.ordinal();
    }

    public static final boolean e(@NotNull Message message) {
        Intrinsics.checkNotNullParameter(message, "<this>");
        return message.extObj instanceof ITroopGuildMsgApi.MsgPushInfo;
    }

    public static final void f(@NotNull Message message, int i3) {
        ITroopGuildMsgApi.MsgPushInfo msgPushInfo;
        Intrinsics.checkNotNullParameter(message, "<this>");
        Object obj = message.extObj;
        if (obj instanceof ITroopGuildMsgApi.MsgPushInfo) {
            msgPushInfo = (ITroopGuildMsgApi.MsgPushInfo) obj;
        } else {
            msgPushInfo = null;
        }
        if (msgPushInfo != null) {
            msgPushInfo.setPushPlace(i3);
        }
    }
}
