package qr0;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.guild.api.msg.IGuildMsgElementApi;
import com.tencent.guild.api.pic.IGuildPicApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.msg.MsgExtKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0004\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0005\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0000\u001a\f\u0010\b\u001a\u0004\u0018\u00010\u0007*\u00020\u0000\u001a\n\u0010\t\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\n\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u000b\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\r\u001a\u00020\f*\u00020\u0000\u001a\n\u0010\u000e\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u000f\u001a\u00020\u0001*\u00020\u0000\u001a\f\u0010\u0010\u001a\u00020\u0001*\u00020\u0000H\u0002\u001a\n\u0010\u0011\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0012\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0013\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0014\u001a\u00020\u0001*\u00020\u0000\u001a\n\u0010\u0015\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "", "o", DomainData.DOMAIN_NAME, "j", h.F, "i", "Lcom/tencent/qqnt/kernel/nativeinterface/MarketFaceElement;", "a", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "k", "l", "", "b", "e", "f", "r", "d", "g", "c", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "nt-guild-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d {
    @Nullable
    public static final MarketFaceElement a(@NotNull GuildMsgItem guildMsgItem) {
        MarketFaceElement marketFaceElement;
        Intrinsics.checkNotNullParameter(guildMsgItem, "<this>");
        ArrayList<MsgElement> arrayList = guildMsgItem.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        int i3 = 0;
        for (Object obj : arrayList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            MsgElement msgElement = (MsgElement) obj;
            if (msgElement.elementType == 11 && (marketFaceElement = msgElement.marketFaceElement) != null && i3 == 0) {
                return marketFaceElement;
            }
            i3 = i16;
        }
        return null;
    }

    @NotNull
    public static final String b(@NotNull GuildMsgItem guildMsgItem) {
        Intrinsics.checkNotNullParameter(guildMsgItem, "<this>");
        if (m(guildMsgItem)) {
            IGuildPicApi iGuildPicApi = (IGuildPicApi) QRoute.api(IGuildPicApi.class);
            MsgElement msgElement = guildMsgItem.getMsgRecord().elements.get(0);
            Intrinsics.checkNotNullExpressionValue(msgElement, "msgRecord.elements[0]");
            return iGuildPicApi.getOriginImagePath(msgElement);
        }
        return "";
    }

    public static final boolean c(@NotNull GuildMsgItem guildMsgItem) {
        boolean z16;
        Intrinsics.checkNotNullParameter(guildMsgItem, "<this>");
        ArrayList<MsgElement> arrayList = guildMsgItem.getMsgRecord().elements;
        if (arrayList == null || arrayList.isEmpty()) {
            return false;
        }
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            int i3 = ((MsgElement) it.next()).elementType;
            if (i3 != 14 && i3 != 17) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    public static final boolean d(@NotNull GuildMsgItem guildMsgItem) {
        Intrinsics.checkNotNullParameter(guildMsgItem, "<this>");
        if (guildMsgItem.getMsgRecord().msgType != 11 || guildMsgItem.getMsgRecord().elements == null || guildMsgItem.getMsgRecord().elements.size() != 1 || guildMsgItem.getMsgRecord().elements.get(0).elementType != 10) {
            return false;
        }
        return true;
    }

    public static final boolean e(@NotNull GuildMsgItem guildMsgItem) {
        Intrinsics.checkNotNullParameter(guildMsgItem, "<this>");
        if (!r(guildMsgItem)) {
            return false;
        }
        Integer picType = guildMsgItem.getMsgRecord().elements.get(0).picElement.picType;
        Intrinsics.checkNotNullExpressionValue(picType, "picType");
        if (picType.intValue() < 2000 && picType.intValue() != 2) {
            return false;
        }
        return true;
    }

    public static final boolean f(@NotNull GuildMsgItem guildMsgItem) {
        Intrinsics.checkNotNullParameter(guildMsgItem, "<this>");
        if (!r(guildMsgItem)) {
            return false;
        }
        return MsgExtKt.v(guildMsgItem.getMsgRecord().elements.get(0).picElement.picSubType);
    }

    public static final boolean g(@NotNull GuildMsgItem guildMsgItem) {
        Intrinsics.checkNotNullParameter(guildMsgItem, "<this>");
        if ((guildMsgItem.getMsgRecord().msgType == 2 && c(guildMsgItem)) || guildMsgItem.getMsgRecord().msgType == 31) {
            return true;
        }
        return false;
    }

    public static final boolean h(@NotNull GuildMsgItem guildMsgItem) {
        boolean z16;
        Intrinsics.checkNotNullParameter(guildMsgItem, "<this>");
        if (guildMsgItem.getMsgRecord().msgType != 31) {
            return false;
        }
        ArrayList<MsgElement> arrayList = guildMsgItem.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
            return false;
        }
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            int i3 = ((MsgElement) it.next()).elementType;
            if (i3 != 6 && i3 != 1) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    public static final boolean i(@NotNull GuildMsgItem guildMsgItem) {
        Intrinsics.checkNotNullParameter(guildMsgItem, "<this>");
        if (guildMsgItem.getMsgRecord().msgType != 17) {
            return false;
        }
        ArrayList<MsgElement> arrayList = guildMsgItem.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        int i3 = 0;
        for (Object obj : arrayList) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            MsgElement msgElement = (MsgElement) obj;
            if (msgElement.elementType == 11 && msgElement.marketFaceElement != null && i3 == 0) {
                return true;
            }
            i3 = i16;
        }
        return false;
    }

    public static final boolean j(@NotNull GuildMsgItem guildMsgItem) {
        boolean z16;
        Intrinsics.checkNotNullParameter(guildMsgItem, "<this>");
        if (guildMsgItem.getMsgRecord().msgType != 2) {
            return false;
        }
        ArrayList<MsgElement> arrayList = guildMsgItem.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
            return false;
        }
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            int i3 = ((MsgElement) it.next()).elementType;
            if (i3 != 6 && i3 != 1) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    public static final boolean k(@NotNull GuildMsgItem guildMsgItem) {
        Intrinsics.checkNotNullParameter(guildMsgItem, "<this>");
        if (guildMsgItem.getMsgRecord().msgType != 2 || guildMsgItem.getMsgRecord().elements == null) {
            return false;
        }
        ArrayList<MsgElement> arrayList = guildMsgItem.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        boolean z16 = false;
        boolean z17 = false;
        for (MsgElement it : arrayList) {
            if (it.elementType == 2) {
                z16 = true;
            } else {
                IGuildMsgElementApi iGuildMsgElementApi = (IGuildMsgElementApi) QRoute.api(IGuildMsgElementApi.class);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (!iGuildMsgElementApi.isTextElem(it)) {
                    z17 = true;
                }
            }
        }
        if (!z16 || z17) {
            return false;
        }
        return true;
    }

    public static final boolean l(@NotNull GuildMsgItem guildMsgItem) {
        Intrinsics.checkNotNullParameter(guildMsgItem, "<this>");
        if (guildMsgItem.getMsgRecord().msgType != 2 || guildMsgItem.getMsgRecord().elements == null) {
            return false;
        }
        ArrayList<MsgElement> arrayList = guildMsgItem.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        boolean z16 = false;
        boolean z17 = false;
        for (MsgElement it : arrayList) {
            if (it.elementType == 5) {
                z16 = true;
            } else {
                IGuildMsgElementApi iGuildMsgElementApi = (IGuildMsgElementApi) QRoute.api(IGuildMsgElementApi.class);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (!iGuildMsgElementApi.isTextElem(it)) {
                    z17 = true;
                }
            }
        }
        if (!z16 || z17) {
            return false;
        }
        return true;
    }

    public static final boolean m(@NotNull GuildMsgItem guildMsgItem) {
        Intrinsics.checkNotNullParameter(guildMsgItem, "<this>");
        if (guildMsgItem.getMsgRecord().msgType != 2 || guildMsgItem.getMsgRecord().elements == null || guildMsgItem.getMsgRecord().elements.size() != 1) {
            return false;
        }
        ArrayList<MsgElement> arrayList = guildMsgItem.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            if (((MsgElement) it.next()).elementType == 2) {
                return true;
            }
        }
        return false;
    }

    public static final boolean n(@NotNull GuildMsgItem guildMsgItem) {
        boolean z16;
        Intrinsics.checkNotNullParameter(guildMsgItem, "<this>");
        ArrayList<MsgElement> arrayList = guildMsgItem.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        if ((arrayList instanceof Collection) && arrayList.isEmpty()) {
            return false;
        }
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            if (((MsgElement) it.next()).elementType == 7) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    public static final boolean o(@NotNull GuildMsgItem guildMsgItem) {
        Intrinsics.checkNotNullParameter(guildMsgItem, "<this>");
        if (guildMsgItem.getMsgRecord().msgType != 2 || guildMsgItem.getMsgRecord().elements == null) {
            return false;
        }
        ArrayList<MsgElement> arrayList = guildMsgItem.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            int i3 = ((MsgElement) it.next()).elementType;
            if (i3 != 6 && i3 != 1) {
                return false;
            }
        }
        return true;
    }

    public static final boolean p(@NotNull GuildMsgItem guildMsgItem) {
        Intrinsics.checkNotNullParameter(guildMsgItem, "<this>");
        if (guildMsgItem.getMsgRecord().msgType != 2 || guildMsgItem.getMsgRecord().elements == null) {
            return false;
        }
        ArrayList<MsgElement> arrayList = guildMsgItem.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            if (((MsgElement) it.next()).elementType == 5) {
                return true;
            }
        }
        return false;
    }

    public static final boolean q(@NotNull GuildMsgItem guildMsgItem) {
        Intrinsics.checkNotNullParameter(guildMsgItem, "<this>");
        if (guildMsgItem.getMsgRecord().msgType != 7 || guildMsgItem.getMsgRecord().elements == null) {
            return false;
        }
        ArrayList<MsgElement> arrayList = guildMsgItem.getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgRecord.elements");
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            if (((MsgElement) it.next()).elementType == 5) {
                return true;
            }
        }
        return false;
    }

    private static final boolean r(GuildMsgItem guildMsgItem) {
        if (guildMsgItem.getMsgRecord().msgType != 2 || guildMsgItem.getMsgRecord().elements == null || guildMsgItem.getMsgRecord().elements.size() != 1 || guildMsgItem.getMsgRecord().elements.get(0).elementType != 2) {
            return false;
        }
        return true;
    }
}
