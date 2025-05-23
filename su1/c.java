package su1;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0000\u001a\u0012\u0010\b\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006\u001a\n\u0010\t\u001a\u00020\u0006*\u00020\u0000\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u000b\u001a\u00020\u0006*\u00020\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/data/MessageRecord;", "", "guildId", "", "f", "b", "", "isDirectMessage", "e", "c", "a", "d", "qqguild-api_release"}, k = 2, mv = {1, 7, 1})
@JvmName(name = "GuildMessageRecordUtils")
/* loaded from: classes14.dex */
public final class c {
    @NotNull
    public static final String a(@NotNull MessageRecord messageRecord) {
        Intrinsics.checkNotNullParameter(messageRecord, "<this>");
        String str = messageRecord.frienduin;
        Intrinsics.checkNotNullExpressionValue(str, "this.frienduin");
        return str;
    }

    @NotNull
    public static final String b(@NotNull MessageRecord messageRecord) {
        boolean contains$default;
        Intrinsics.checkNotNullParameter(messageRecord, "<this>");
        String str = messageRecord.extStr;
        boolean z16 = false;
        if (str != null) {
            contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) IGuildMessageUtilsApi.GUILD_ID_EXT_STR, false, 2, (Object) null);
            if (contains$default) {
                z16 = true;
            }
        }
        if (!z16) {
            return "";
        }
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr(IGuildMessageUtilsApi.GUILD_ID_EXT_STR);
        Intrinsics.checkNotNullExpressionValue(extInfoFromExtStr, "getExtInfoFromExtStr(IGu\u2026tilsApi.GUILD_ID_EXT_STR)");
        return extInfoFromExtStr;
    }

    public static final boolean c(@NotNull MessageRecord messageRecord) {
        Intrinsics.checkNotNullParameter(messageRecord, "<this>");
        if ((messageRecord.extLong & 4194304) > 0) {
            return true;
        }
        return false;
    }

    public static final boolean d(@NotNull MessageRecord messageRecord) {
        Intrinsics.checkNotNullParameter(messageRecord, "<this>");
        if (messageRecord.msgtype != -2006) {
            return true;
        }
        return false;
    }

    public static final void e(@NotNull MessageRecord messageRecord, boolean z16) {
        int i3;
        Intrinsics.checkNotNullParameter(messageRecord, "<this>");
        if (z16) {
            i3 = messageRecord.extLong | 4194304;
        } else {
            i3 = messageRecord.extLong & (-4194305);
        }
        messageRecord.extLong = i3;
    }

    public static final void f(@NotNull MessageRecord messageRecord, @NotNull String guildId) {
        Intrinsics.checkNotNullParameter(messageRecord, "<this>");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        messageRecord.saveExtInfoToExtStr(IGuildMessageUtilsApi.GUILD_ID_EXT_STR, guildId);
    }
}
