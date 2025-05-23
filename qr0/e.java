package qr0;

import com.tencent.guild.api.util.IGuildUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.nativeinterface.AnonymousExtInfo;
import com.tencent.qqnt.kernel.nativeinterface.FoldingInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.kernel.nativeinterface.WalletElement;
import com.tencent.qqnt.msg.MsgExtKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a\u0012\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0007\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004\u001a\n\u0010\b\u001a\u00020\u0006*\u00020\u0000\u001a\u0012\u0010\t\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u0012\u0010\n\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u0012\u0010\f\u001a\u00020\u0006*\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0006\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "", "newSendStatus", "a", "", "selfTinyId", "", "c", "f", "b", "d", "isUserOnline", "e", "nt-guild-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class e {
    @NotNull
    public static final MsgRecord a(@NotNull MsgRecord msgRecord, int i3) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        return new MsgRecord(msgRecord.msgId, msgRecord.msgRandom, msgRecord.msgSeq, msgRecord.cntSeq, msgRecord.chatType, msgRecord.msgType, msgRecord.subMsgType, msgRecord.sendType, msgRecord.senderUid, msgRecord.peerUid, msgRecord.channelId, msgRecord.guildId, msgRecord.guildCode, msgRecord.fromUid, msgRecord.fromAppid, msgRecord.msgTime, msgRecord.msgMeta, i3, msgRecord.sendRemarkName, msgRecord.sendMemberName, msgRecord.sendNickName, msgRecord.guildName, msgRecord.channelName, msgRecord.elements, msgRecord.records, msgRecord.emojiLikesList, msgRecord.commentCnt, msgRecord.directMsgFlag, msgRecord.directMsgMembers, msgRecord.peerName, msgRecord.freqLimitInfo, msgRecord.editable, msgRecord.avatarMeta, msgRecord.avatarPendant, msgRecord.feedId, msgRecord.roleId, msgRecord.timeStamp, msgRecord.clientIdentityInfo, msgRecord.isImportMsg, msgRecord.atType, msgRecord.roleType, msgRecord.fromChannelRoleInfo, msgRecord.fromGuildRoleInfo, msgRecord.levelRoleInfo, msgRecord.recallTime, msgRecord.isOnlineMsg, msgRecord.generalFlags, 0L, 0, new FoldingInfo(), msgRecord.multiTransInfo, 0L, 0L, new HashMap(), new AnonymousExtInfo(), msgRecord.nameType, msgRecord.avatarFlag, new byte[0], msgRecord.personalMedal, msgRecord.categoryManage, msgRecord.msgEventInfo);
    }

    public static final boolean b(@NotNull MsgRecord msgRecord, @NotNull String selfTinyId) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        Intrinsics.checkNotNullParameter(selfTinyId, "selfTinyId");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        if (arrayList != null) {
            arrayList.isEmpty();
            if (d(msgRecord, selfTinyId) || c(msgRecord, selfTinyId) || MsgExtKt.C(msgRecord, selfTinyId)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean c(@NotNull MsgRecord msgRecord, @NotNull String selfTinyId) {
        boolean z16;
        ArrayList<MsgElement> arrayList;
        ArrayList<Long> arrayList2;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        Intrinsics.checkNotNullParameter(selfTinyId, "selfTinyId");
        boolean z17 = false;
        if (selfTinyId.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && f(msgRecord) && (arrayList = msgRecord.elements) != null) {
            arrayList.isEmpty();
            WalletElement walletElement = msgRecord.elements.get(0).walletElement;
            if (walletElement == null || !((IGuildUtilApi) QRoute.api(IGuildUtilApi.class)).isMyPersonalGuildWalletMsgType(walletElement.msgType) || (arrayList2 = walletElement.grapUin) == null) {
                return false;
            }
            if (!arrayList2.isEmpty()) {
                Iterator<T> it = arrayList2.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(String.valueOf((Long) it.next()), selfTinyId)) {
                        break;
                    }
                }
            }
            z17 = true;
            return !z17;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0060 A[EDGE_INSN: B:27:0x0060->B:8:0x0060 BREAK  A[LOOP:0: B:12:0x002d->B:28:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[LOOP:0: B:12:0x002d->B:28:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean d(@NotNull MsgRecord msgRecord, @NotNull String selfTinyId) {
        boolean z16;
        boolean z17;
        Long l3;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        Intrinsics.checkNotNullParameter(selfTinyId, "selfTinyId");
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        boolean z18 = false;
        if (arrayList == null) {
            return false;
        }
        arrayList.isEmpty();
        ArrayList<MsgElement> elements = msgRecord.elements;
        Intrinsics.checkNotNullExpressionValue(elements, "elements");
        if (!(elements instanceof Collection) || !elements.isEmpty()) {
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                TextElement textElement = ((MsgElement) it.next()).textElement;
                if (textElement != null && textElement.atType == 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    if (textElement != null) {
                        l3 = Long.valueOf(textElement.atTinyId);
                    } else {
                        l3 = null;
                    }
                    if (Intrinsics.areEqual(String.valueOf(l3), selfTinyId)) {
                        z17 = true;
                        if (!z17) {
                            break;
                        }
                    }
                }
                z17 = false;
                if (!z17) {
                }
            }
        }
        z18 = true;
        return !z18;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0058, code lost:
    
        if (r3 == false) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006c A[EDGE_INSN: B:28:0x006c->B:10:0x006c BREAK  A[LOOP:0: B:13:0x0023->B:29:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[LOOP:0: B:13:0x0023->B:29:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean e(@NotNull MsgRecord msgRecord, boolean z16) {
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        Integer num;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        ArrayList<MsgElement> elements = msgRecord.elements;
        boolean z27 = false;
        if (elements == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(elements, "elements");
        if (!(elements instanceof Collection) || !elements.isEmpty()) {
            for (MsgElement msgElement : elements) {
                TextElement textElement = msgElement.textElement;
                if (textElement != null && textElement.atType == 8) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17 || (num = textElement.needNotify) == null || num.intValue() != 1) {
                    if (z16) {
                        TextElement textElement2 = msgElement.textElement;
                        if (textElement2 != null && textElement2.atType == 64) {
                            z26 = true;
                        } else {
                            z26 = false;
                        }
                    }
                    TextElement textElement3 = msgElement.textElement;
                    if (textElement3 != null && textElement3.atType == 1) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (!z18) {
                        z19 = false;
                        if (!z19) {
                            break;
                        }
                    }
                }
                z19 = true;
                if (!z19) {
                }
            }
        }
        z27 = true;
        return !z27;
    }

    public static final boolean f(@NotNull MsgRecord msgRecord) {
        boolean z16;
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        if (msgRecord.msgType != 10) {
            return false;
        }
        ArrayList<MsgElement> arrayList = msgRecord.elements;
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16 || msgRecord.elements.get(0).elementType != 9 || msgRecord.elements.get(0).walletElement == null) {
            return false;
        }
        return ((IGuildUtilApi) QRoute.api(IGuildUtilApi.class)).isGuildWalletMsgType(msgRecord.elements.get(0).walletElement.msgType);
    }
}
