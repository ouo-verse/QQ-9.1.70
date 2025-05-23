package xt1;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.msgtype.MessageRecordForMarkdown;
import com.tencent.mobileqq.guild.temp.api.IGuildMarkdownApi;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.ab;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import msf.msgcomm.msg_comm$MsgHead;
import tencent.im.msg.hummer.servtype.hummer_commelem$MsgElemInfo_servtype45;
import tencent.im.msg.im_msg_body$CommonElem;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
/* loaded from: classes14.dex */
public class m implements com.tencent.imcore.message.core.codec.a {
    @Override // com.tencent.imcore.message.core.codec.a
    public boolean a(List<im_msg_body$Elem> list, msg_comm$Msg msg_comm_msg, List<MessageRecord> list2, StringBuilder sb5, boolean z16, boolean z17, com.tencent.mobileqq.troop.data.c cVar, ab abVar, com.tencent.mobileqq.service.message.a aVar) {
        im_msg_body$CommonElem im_msg_body_commonelem;
        msg_comm$MsgHead msg_comm_msghead;
        Iterator<im_msg_body$Elem> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                im_msg_body$Elem next = it.next();
                if (next.common_elem.has() && next.common_elem.uint32_service_type.get() == 45) {
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
        hummer_commelem$MsgElemInfo_servtype45 hummer_commelem_msgeleminfo_servtype45 = new hummer_commelem$MsgElemInfo_servtype45();
        try {
            hummer_commelem_msgeleminfo_servtype45.mergeFrom(im_msg_body_commonelem.bytes_pb_elem.get().toByteArray());
            String stringUtf8 = hummer_commelem_msgeleminfo_servtype45.bytes_markdown.get().toStringUtf8();
            if (QLog.isColorLevel()) {
                if (msg_comm_msg != null && (msg_comm_msghead = msg_comm_msg.msg_head) != null) {
                    msg_comm_msghead.msg_seq.get();
                }
                QLog.i("GuildMarkdownElemDecoder", 1, "decodePBMsgElem, markdown:" + stringUtf8);
            }
            MessageRecordForMarkdown messageRecordForMarkdown = new MessageRecordForMarkdown(stringUtf8);
            String parse = ((IGuildMarkdownApi) QRoute.api(IGuildMarkdownApi.class)).parse(messageRecordForMarkdown);
            if (hummer_commelem_msgeleminfo_servtype45.md_summary.has()) {
                String stringUtf82 = hummer_commelem_msgeleminfo_servtype45.md_summary.get().toStringUtf8();
                if (!stringUtf82.isEmpty()) {
                    parse = stringUtf82;
                }
            }
            messageRecordForMarkdown.setParsedText(parse);
            messageRecordForMarkdown.setCompatibleText(((IGuildMarkdownApi) QRoute.api(IGuildMarkdownApi.class)).parseCompatibleTextWithAt(list, sb5, msg_comm_msg, cVar, messageRecordForMarkdown));
            list2.add(messageRecordForMarkdown);
            return true;
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e("GuildMarkdownElemDecoder", 1, "decodePBMsgElem: " + e16.getMessage());
            return false;
        }
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public boolean b(im_msg_body$Elem im_msg_body_elem) {
        if (im_msg_body_elem.common_elem.has() && im_msg_body_elem.common_elem.get().uint32_service_type.get() == 45) {
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
