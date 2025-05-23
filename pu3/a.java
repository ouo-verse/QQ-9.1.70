package pu3;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.service.message.q;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qu3.l;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J.\u0010\u0015\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012J \u0010\u0017\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J\u001e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0006\u00a8\u0006\u001b"}, d2 = {"Lpu3/a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/PicElement;", "picElement", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "d", "msgElement", "", "e", "Lcom/tencent/common/app/business/BaseQQAppInterface;", "app", "", "friendUin", "groupUin", "", "type", "Lcom/tencent/mobileqq/data/MarkFaceMessage;", "mfm", "Lcom/tencent/mobileqq/data/MessageForMarketFace;", "c", "Lcom/tencent/mobileqq/data/ChatMessage;", "b", "a", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f427394a = new a();

    a() {
    }

    private final boolean e(MsgElement msgElement, PicElement picElement) {
        PicElement picElement2 = msgElement.picElement;
        return picElement2 != null && picElement.picSubType == picElement2.picSubType && Intrinsics.areEqual(picElement.picType, picElement2.picType) && Intrinsics.areEqual(picElement.sourcePath, picElement2.sourcePath);
    }

    public final ChatMessage a(BaseQQAppInterface app, MsgRecord msgRecord, MsgElement msgElement) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(msgElement, "msgElement");
        ChatMessage a16 = new l().a(app, msgRecord, msgElement);
        if (a16 != null) {
            return a16;
        }
        MessageForPic q16 = q.q(app, "", "", 0);
        Intrinsics.checkNotNullExpressionValue(q16, "createSendMSg_Pic(app, \"\", \"\", 0)");
        return q16;
    }

    public final ChatMessage b(BaseQQAppInterface app, MsgRecord msgRecord, PicElement picElement) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        ChatMessage a16 = new l().a(app, msgRecord, d(msgRecord, picElement));
        if (a16 != null) {
            return a16;
        }
        MessageForPic q16 = q.q(app, "", "", 0);
        Intrinsics.checkNotNullExpressionValue(q16, "createSendMSg_Pic(app, \"\", \"\", 0)");
        return q16;
    }

    public final MessageForMarketFace c(BaseQQAppInterface app, String friendUin, String groupUin, int type, MarkFaceMessage mfm) {
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(friendUin, "friendUin");
        Intrinsics.checkNotNullParameter(groupUin, "groupUin");
        Intrinsics.checkNotNullParameter(mfm, "mfm");
        MessageForMarketFace x16 = q.x((QQAppInterface) app, groupUin, friendUin, type, mfm);
        Intrinsics.checkNotNullExpressionValue(x16, "createSendMsg_MarketFace\u2026            mfm\n        )");
        return x16;
    }

    private final MsgElement d(MsgRecord msgRecord, PicElement picElement) {
        ArrayList<MsgElement> arrayList;
        MsgElement msgElement = null;
        if (picElement != null && (arrayList = msgRecord.elements) != null) {
            for (MsgElement it : arrayList) {
                a aVar = f427394a;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                if (aVar.e(it, picElement)) {
                    msgElement = it;
                }
            }
        }
        return msgElement;
    }
}
