package qu3;

import android.text.TextUtils;
import com.tencent.mobileqq.aio.utils.aj;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.data.ZPlanPicExtraData;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qqnt.kernel.nativeinterface.EmojiAD;
import com.tencent.qqnt.kernel.nativeinterface.EmojiMall;
import com.tencent.qqnt.kernel.nativeinterface.EmojiZPlan;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import org.json.JSONObject;
import qu3.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\r"}, d2 = {"Lqu3/l;", "Lqu3/d;", "Lmqq/app/AppRuntime;", "app", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElement", "Lcom/tencent/mobileqq/data/ChatMessage;", "b", "<init>", "()V", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes36.dex */
public final class l implements d {
    @Override // qu3.d
    public ChatMessage a(AppRuntime appRuntime, MsgRecord msgRecord, MsgElement msgElement) {
        return d.a.a(this, appRuntime, msgRecord, msgElement);
    }

    @Override // qu3.d
    public ChatMessage b(AppRuntime app, MsgRecord msgRecord, MsgElement msgElement) {
        MsgElement msgElement2;
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        MessageRecord d16 = com.tencent.mobileqq.service.message.q.d(-2000);
        MessageForPic messageForPic = d16 instanceof MessageForPic ? (MessageForPic) d16 : null;
        if (messageForPic == null) {
            return null;
        }
        if (msgElement == null) {
            msgElement2 = i.f429570a.k(msgRecord);
            if (msgElement2 == null) {
                return null;
            }
        } else {
            msgElement2 = msgElement;
        }
        PicElement picElement = msgElement2.picElement;
        messageForPic.subTypeId = msgElement2.elementId;
        messageForPic.uuid = picElement.fileName;
        Intrinsics.checkNotNullExpressionValue(picElement, "picElement");
        messageForPic.path = defpackage.g.c(picElement);
        if (TextUtils.isEmpty(picElement.sourcePath)) {
            if (msgRecord.isImportMsg && !picElement.original) {
                String d17 = defpackage.g.d(picElement, 720);
                if (!TextUtils.isEmpty(d17)) {
                    messageForPic.path = d17;
                }
            }
        } else {
            messageForPic.path = picElement.sourcePath;
        }
        if (TextUtils.isEmpty(messageForPic.path)) {
            String a16 = aj.a(picElement);
            messageForPic.path = a16;
            if (msgRecord.isImportMsg && !picElement.original) {
                if (!FileUtils.fileExistsAndNotEmpty(a16)) {
                    String b16 = aj.b(picElement, 720);
                    if (FileUtils.fileExistsAndNotEmpty(b16)) {
                        defpackage.g.f(picElement, 720, b16);
                        messageForPic.path = b16;
                    }
                } else {
                    defpackage.g.e(picElement, a16);
                }
            }
        }
        messageForPic.size = picElement.fileSize;
        messageForPic.width = picElement.picWidth;
        messageForPic.height = picElement.picHeight;
        messageForPic.md5 = picElement.md5HexStr;
        Integer num = picElement.picType;
        Intrinsics.checkNotNullExpressionValue(num, "picElement.picType");
        messageForPic.imageType = num.intValue();
        try {
            String str = picElement.fileUuid;
            Intrinsics.checkNotNullExpressionValue(str, "picElement.fileUuid");
            messageForPic.groupFileID = Long.parseLong(str);
        } catch (Exception unused) {
        }
        messageForPic.type = 1;
        messageForPic.ntChatType = msgRecord.chatType;
        messageForPic.ntPeerUid = msgRecord.peerUid;
        PicMessageExtraData picMessageExtraData = new PicMessageExtraData();
        picMessageExtraData.textSummary = picElement.summary;
        picMessageExtraData.imageBizType = picElement.picSubType;
        Integer num2 = picElement.emojiFrom;
        picMessageExtraData.from = num2 == null ? -1 : num2.intValue();
        picMessageExtraData.webUrl = picElement.emojiWebUrl;
        picMessageExtraData.mOriginImageMd5 = picElement.originImageMd5;
        EmojiAD emojiAD = picElement.emojiAd;
        if (emojiAD != null) {
            picMessageExtraData.mAdEmoJumpUrl = emojiAD.url;
            picMessageExtraData.mAdEmoDescStr = emojiAD.desc;
        }
        EmojiMall emojiMall = picElement.emojiMall;
        if (emojiMall != null) {
            picMessageExtraData.emojiPkgId = String.valueOf(emojiMall.packageId);
            picMessageExtraData.emojiId = String.valueOf(picElement.emojiMall.emojiId);
        }
        EmojiZPlan emojiZPlan = picElement.emojiZplan;
        if (emojiZPlan != null) {
            long j3 = emojiZPlan.peerUid;
            EmojiZPlan emojiZPlan2 = picElement.emojiZplan;
            picMessageExtraData.mZPlanPicInfo = new ZPlanPicExtraData(emojiZPlan2.actionId, emojiZPlan2.actionName, emojiZPlan2.playerNumber, emojiZPlan2.actionType, j3, null, emojiZPlan2.bytesReserveInfo, 0, 0, MsgConstant.KRMFILETHUMBSIZE384, null);
        }
        if (com.tencent.mobileqq.aio.utils.d.z(msgRecord)) {
            boolean z16 = false;
            try {
                byte[] bArr = msgElement2.extBufForUI;
                if (bArr != null) {
                    Intrinsics.checkNotNullExpressionValue(bArr, "picMsgElement.extBufForUI");
                    z16 = new JSONObject(new String(bArr, Charsets.UTF_8)).optBoolean("hasRead", false);
                }
            } catch (Exception unused2) {
            }
            messageForPic.saveExtInfoToExtStr("commen_flash_pic", String.valueOf(z16));
        }
        messageForPic.picExtraData = picMessageExtraData;
        return messageForPic;
    }
}
