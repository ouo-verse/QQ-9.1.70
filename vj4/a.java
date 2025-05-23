package vj4;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.mobileqq.qqlive.data.message.LiveMessageData;
import com.tencent.mobileqq.qqlive.widget.chat.data.DressUpBubble;
import com.tencent.mobileqq.qqlive.widget.chat.data.b;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.common.api.AegisLogger;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pq4.c;
import sr4.g;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J \u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\u0010\u0004\u001a\u00060\u0002R\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\u0014\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\nH\u0002J\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0003\u00a8\u0006\u0014"}, d2 = {"Lvj4/a;", "", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData$ExtData;", "Lcom/tencent/mobileqq/qqlive/data/message/LiveMessageData;", "ext", "Lcom/tencent/mobileqq/qqlive/widget/chat/data/b;", "extraMedalInfo", "b", "", "data", "Loz0/a;", "d", "extraInfo", "c", "", "uid", "liveMessageData", "a", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class a {
    private final b b(LiveMessageData.ExtData ext, b extraMedalInfo) {
        String str;
        int i3 = ext.mId;
        if (299 == i3) {
            byte[] bArr = ext.mValue;
            if (bArr != null) {
                Charset forName = Charset.forName("UTF-8");
                Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
                str = new String(bArr, forName);
            } else {
                str = null;
            }
            DressUpBubble dressUpBubble = new DressUpBubble(str);
            QLog.i("ChatMsgMedalInfoParser", 2, "has chat bubble ext.mValue=" + ext.mValue + " dressStr=" + str + " dressUpBubble=" + dressUpBubble);
            if (extraMedalInfo == null) {
                extraMedalInfo = new b();
            }
            extraMedalInfo.f273760e = dressUpBubble;
        } else if (298 == i3) {
            try {
                c c16 = c.c(ext.mValue);
                if (extraMedalInfo != null) {
                    extraMedalInfo.f273761f = c16;
                }
            } catch (InvalidProtocolBufferNanoException e16) {
                AegisLogger.INSTANCE.i("ChatMsgMedalInfoParser", "handleMsgBubbleInfo", "parse ChatBubbleStyleV2 exception=" + e16);
            }
        }
        return extraMedalInfo;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
    
        if (r2 != false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final b c(oz0.a extraInfo) {
        boolean z16;
        List<g> list;
        boolean z17;
        g[] gVarArr = extraInfo.f424558b;
        if (gVarArr != null) {
            z16 = false;
            if (gVarArr.length == 0) {
                z17 = true;
            } else {
                z17 = false;
            }
        }
        z16 = true;
        if (z16) {
            QLog.e("ChatMsgMedalInfoParser", 1, "parseMedalInfo medalInfoList is null or empty");
            return null;
        }
        QLog.i("ChatMsgMedalInfoParser", 2, "has medal info list\uff0c size:" + gVarArr.length);
        b bVar = new b();
        bVar.f273756a = extraInfo.f424557a;
        g[] gVarArr2 = extraInfo.f424558b;
        Intrinsics.checkNotNullExpressionValue(gVarArr2, "extraInfo.medalInfoList");
        list = ArraysKt___ArraysKt.toList(gVarArr2);
        bVar.f273762g = list;
        return bVar;
    }

    private final oz0.a d(byte[] data) {
        if (data == null) {
            QLog.e("ChatMsgMedalInfoParser", 1, "parseUserExtraInfo data is null");
            return null;
        }
        return oz0.a.c(data);
    }

    @Nullable
    public final b a(long uid, @NotNull LiveMessageData liveMessageData) {
        Intrinsics.checkNotNullParameter(liveMessageData, "liveMessageData");
        ArrayList<LiveMessageData.ExtData> arrayList = liveMessageData.msgContent.mExtDatas;
        Iterator<LiveMessageData.ExtData> it = arrayList.iterator();
        b bVar = null;
        while (it.hasNext()) {
            LiveMessageData.ExtData next = it.next();
            if (230 == next.mId) {
                QLog.i("ChatMsgMedalInfoParser", 2, "has medal info in extra");
                oz0.a d16 = d(next.mValue);
                if (d16 != null) {
                    bVar = c(d16);
                }
            }
        }
        Iterator<LiveMessageData.ExtData> it5 = arrayList.iterator();
        while (it5.hasNext()) {
            LiveMessageData.ExtData ext = it5.next();
            Intrinsics.checkNotNullExpressionValue(ext, "ext");
            bVar = b(ext, bVar);
        }
        if (bVar != null) {
            bVar.f273756a = uid;
        }
        return bVar;
    }
}
