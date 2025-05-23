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
import msf.msgcomm.msg_comm$MsgHead;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype42;
import tencent.im.msg.im_msg_body$CommonElem;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c implements com.tencent.imcore.message.core.codec.a {
    @Override // com.tencent.imcore.message.core.codec.a
    public boolean a(List<im_msg_body$Elem> list, msg_comm$Msg msg_comm_msg, List<MessageRecord> list2, StringBuilder sb5, boolean z16, boolean z17, com.tencent.mobileqq.troop.data.c cVar, ab abVar, com.tencent.mobileqq.service.message.a aVar) {
        im_msg_body$CommonElem im_msg_body_commonelem;
        msg_comm$MsgHead msg_comm_msghead;
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
        int i3 = 0;
        if (im_msg_body_commonelem == null) {
            return false;
        }
        hummer_commelem$MsgElemInfo_servtype42 hummer_commelem_msgeleminfo_servtype42 = new hummer_commelem$MsgElemInfo_servtype42();
        try {
            hummer_commelem_msgeleminfo_servtype42.mergeFrom(im_msg_body_commonelem.bytes_pb_elem.get().toByteArray());
            String str = hummer_commelem_msgeleminfo_servtype42.summary.get();
            String str2 = hummer_commelem_msgeleminfo_servtype42.f435952msg.get();
            long j3 = hummer_commelem_msgeleminfo_servtype42.expire_time_ms.get();
            int i16 = hummer_commelem_msgeleminfo_servtype42.schema_type.get();
            String str3 = hummer_commelem_msgeleminfo_servtype42.schema.get();
            if (QLog.isColorLevel()) {
                if (msg_comm_msg != null && (msg_comm_msghead = msg_comm_msg.msg_head) != null) {
                    i3 = msg_comm_msghead.msg_seq.get();
                }
                QLog.i("GuildAppChannelNormalMsgElemDecoder", 1, "decodePBMsgElem, summary:" + str + ",msg:" + str2 + ",expireTimeMs:" + j3 + ",schemaType:" + i16 + ",schema:" + str3 + ",seq:" + i3);
            }
            list2.add(((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).createMessageRecordForAppChannel(str, str2, j3, i16, str3, true));
            return true;
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("GuildAppChannelNormalMsgElemDecoder", 1, "decodePBMsgElem: " + e16.getMessage());
            return false;
        }
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public boolean b(im_msg_body$Elem im_msg_body_elem) {
        if (im_msg_body_elem.common_elem.has() && im_msg_body_elem.common_elem.get().uint32_service_type.get() == 42) {
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
