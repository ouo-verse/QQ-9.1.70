package xt1;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.ab;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype40;
import tencent.im.msg.im_msg_body$CommonElem;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
/* loaded from: classes14.dex */
public class k implements com.tencent.imcore.message.core.codec.a {
    @Override // com.tencent.imcore.message.core.codec.a
    public boolean a(List<im_msg_body$Elem> list, msg_comm$Msg msg_comm_msg, List<MessageRecord> list2, StringBuilder sb5, boolean z16, boolean z17, com.tencent.mobileqq.troop.data.c cVar, ab abVar, com.tencent.mobileqq.service.message.a aVar) {
        im_msg_body$CommonElem im_msg_body_commonelem;
        String str;
        long j3;
        Iterator<im_msg_body$Elem> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                im_msg_body$Elem next = it.next();
                if (next.common_elem.has()) {
                    im_msg_body_commonelem = next.common_elem.get();
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
        hummer_commelem$MsgElemInfo_servtype40 hummer_commelem_msgeleminfo_servtype40 = new hummer_commelem$MsgElemInfo_servtype40();
        try {
            hummer_commelem_msgeleminfo_servtype40.mergeFrom(im_msg_body_commonelem.bytes_pb_elem.get().toByteArray());
            String str2 = "";
            if (!hummer_commelem_msgeleminfo_servtype40.receiver_tiny_id.has()) {
                str = "";
            } else {
                str = hummer_commelem_msgeleminfo_servtype40.receiver_tiny_id.get();
            }
            long j16 = 0;
            if (hummer_commelem_msgeleminfo_servtype40.gift_id.has()) {
                j3 = hummer_commelem_msgeleminfo_servtype40.gift_id.get();
            } else {
                j3 = 0;
            }
            if (hummer_commelem_msgeleminfo_servtype40.gift_num.has()) {
                j16 = hummer_commelem_msgeleminfo_servtype40.gift_num.get();
            }
            long j17 = j16;
            if (hummer_commelem_msgeleminfo_servtype40.gift_name.has()) {
                str2 = hummer_commelem_msgeleminfo_servtype40.gift_name.get();
            }
            String str3 = str2;
            if (QLog.isColorLevel()) {
                QLog.e("GuildLiveGiftMsgElemDecoder", 1, "decodePBMsgElem: receiver[" + str + "] giftId[" + j3 + "] combo[" + j17 + "] giftName[" + str3 + "]");
            }
            list2.add(((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).createMessageRecordForLiveGift("", str, str3, j3, j17));
            return true;
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("GuildLiveGiftMsgElemDecoder", 1, "decodePBMsgElem: " + e16.getMessage());
            return false;
        }
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public boolean b(im_msg_body$Elem im_msg_body_elem) {
        if (im_msg_body_elem.common_elem.has() && im_msg_body_elem.common_elem.get().uint32_service_type.get() == 40) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public int getPriority() {
        return 1000;
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public void c(List<com.tencent.imcore.message.core.codec.a> list) {
    }
}
