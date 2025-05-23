package xt1;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.service.message.ab;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import oi1.InnerKeyboardInfo;
import tencent.im.msg.hummer.servtype.InlineKeyboardMsg$InlineKeyboard;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype46;
import tencent.im.msg.im_msg_body$CommonElem;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
/* loaded from: classes14.dex */
public class i implements com.tencent.imcore.message.core.codec.a {
    @Override // com.tencent.imcore.message.core.codec.a
    public boolean a(List<im_msg_body$Elem> list, msg_comm$Msg msg_comm_msg, List<MessageRecord> list2, StringBuilder sb5, boolean z16, boolean z17, com.tencent.mobileqq.troop.data.c cVar, ab abVar, com.tencent.mobileqq.service.message.a aVar) {
        im_msg_body$CommonElem im_msg_body_commonelem;
        Iterator<im_msg_body$Elem> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                im_msg_body$Elem next = it.next();
                if (next.common_elem.has() && next.common_elem.uint32_service_type.get() == 46) {
                    im_msg_body_commonelem = next.common_elem;
                    break;
                }
            } else {
                im_msg_body_commonelem = null;
                break;
            }
        }
        if (im_msg_body_commonelem == null) {
            return false;
        }
        hummer_commelem$MsgElemInfo_servtype46 hummer_commelem_msgeleminfo_servtype46 = new hummer_commelem$MsgElemInfo_servtype46();
        try {
            hummer_commelem_msgeleminfo_servtype46.mergeFrom(im_msg_body_commonelem.bytes_pb_elem.get().toByteArray());
            InlineKeyboardMsg$InlineKeyboard inlineKeyboardMsg$InlineKeyboard = new InlineKeyboardMsg$InlineKeyboard();
            inlineKeyboardMsg$InlineKeyboard.mergeFrom(hummer_commelem_msgeleminfo_servtype46.inline_keyboard.get().toByteArray());
            String a16 = InnerKeyboardInfo.INSTANCE.b(inlineKeyboardMsg$InlineKeyboard).a();
            Iterator<MessageRecord> it5 = list2.iterator();
            while (it5.hasNext()) {
                it5.next().saveExtInfoToExtStr(IGuildMessageUtilsApi.MSG_INNER_KEYBOARD, a16);
            }
            return true;
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("GuildInnerKeyboardElemDecoder", 1, "decodePBMsgElem: " + e16.getMessage());
            return false;
        }
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public boolean b(im_msg_body$Elem im_msg_body_elem) {
        if (im_msg_body_elem.common_elem.has() && im_msg_body_elem.common_elem.get().uint32_service_type.get() == 46) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public int getPriority() {
        return -1000;
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public void c(List<com.tencent.imcore.message.core.codec.a> list) {
    }
}
