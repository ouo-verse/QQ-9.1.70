package zt;

import android.text.TextUtils;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.af;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.service.message.ab;
import com.tencent.mobileqq.transfile.TransfileUtile;
import com.tencent.mobileqq.troop.data.c;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.cs.longconn.c2c_av_terminate_msg_ext$C2CAVTerminateMsgExt;
import tencent.im.msg.hummer.resv.generalflags$ResvAttr;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends af {
    private MessageForVideo d(im_msg_body$Elem im_msg_body_elem, MessageRecord messageRecord, c2c_av_terminate_msg_ext$C2CAVTerminateMsgExt c2c_av_terminate_msg_ext_c2cavterminatemsgext) {
        int i3;
        MessageForVideo messageForVideo = new MessageForVideo();
        MessageRecord.copyMessageRecordBaseField(messageForVideo, messageRecord);
        if (c2c_av_terminate_msg_ext_c2cavterminatemsgext.has_switched.get()) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        f(messageForVideo, c2c_av_terminate_msg_ext_c2cavterminatemsgext.room_id.get(), c2c_av_terminate_msg_ext_c2cavterminatemsgext.reason.get(), c2c_av_terminate_msg_ext_c2cavterminatemsgext.logout_ts.get(), c2c_av_terminate_msg_ext_c2cavterminatemsgext.buss_flag.get(), i3);
        return messageForVideo;
    }

    private boolean e(im_msg_body$Elem im_msg_body_elem, List<MessageRecord> list, c2c_av_terminate_msg_ext$C2CAVTerminateMsgExt c2c_av_terminate_msg_ext_c2cavterminatemsgext) {
        if (im_msg_body_elem != null && list != null && list.size() != 0) {
            if (QLog.isColorLevel() && list.size() != 1) {
                Iterator<MessageRecord> it = list.iterator();
                while (it.hasNext()) {
                    QLog.d("DavBubbleElemDecoder", 1, "[decodeDavBubbleMsg] " + it.next().toString());
                }
            }
            list.set(0, d(im_msg_body_elem, list.get(0), c2c_av_terminate_msg_ext_c2cavterminatemsgext));
            return true;
        }
        QLog.e("DavBubbleElemDecoder", 1, "[decodeDavBubbleMsg] elem: " + im_msg_body_elem + ", message: " + list);
        return false;
    }

    private void f(MessageForVideo messageForVideo, long j3, long j16, long j17, long j18, int i3) {
        int i16;
        messageForVideo.roomId = j3;
        messageForVideo.hungUpReason = j16;
        messageForVideo.hungUpMs = j17;
        messageForVideo.businessFlag = j18;
        messageForVideo.switchFlag = i3;
        messageForVideo.saveExtInfoToExtStr("dav_bubble_room_id", String.valueOf(j3));
        messageForVideo.saveExtInfoToExtStr("dav_bubble_hung_up_reason", String.valueOf(j16));
        messageForVideo.saveExtInfoToExtStr("dav_bubble_hung_up_time", String.valueOf(j17));
        messageForVideo.saveExtInfoToExtStr("dav_bubble_business_flag", String.valueOf(j18));
        messageForVideo.saveExtInfoToExtStr("dav_bubble_switch_flag", String.valueOf(i3));
        messageForVideo.msgtype = -2009;
        messageForVideo.extraflag = 3;
        messageForVideo.isread = true;
        boolean z16 = false;
        if (TextUtils.equals(messageForVideo.selfuin, messageForVideo.senderuin)) {
            i16 = 0;
        } else {
            i16 = 2;
        }
        String str = messageForVideo.f203106msg;
        long j19 = i16;
        if (j18 == 2) {
            z16 = true;
        }
        messageForVideo.f203106msg = TransfileUtile.makeTransFileProtocolData(str, j19, 3, z16);
        if (QLog.isColorLevel() || QLog.isDebugVersion()) {
            QLog.d("DavBubbleElemDecoder", 1, "[decodeDavBubbleMsg] " + messageForVideo.f203106msg + "[msg.business flag]" + j18 + "[switchFlag flag]" + i3 + "[msg.selfuin ]" + messageForVideo.selfuin + "[msg.senderuin ]" + messageForVideo.senderuin);
        }
    }

    public static boolean g(im_msg_body$Elem im_msg_body_elem, c2c_av_terminate_msg_ext$C2CAVTerminateMsgExt c2c_av_terminate_msg_ext_c2cavterminatemsgext) {
        boolean z16;
        if (im_msg_body_elem.general_flags.has() && im_msg_body_elem.general_flags.bytes_pb_reserve.has()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        generalflags$ResvAttr generalflags_resvattr = new generalflags$ResvAttr();
        try {
            generalflags_resvattr.mergeFrom(im_msg_body_elem.general_flags.bytes_pb_reserve.get().toByteArray());
            if (!generalflags_resvattr.pass_through.has() || !generalflags_resvattr.pass_through.bytes_av_terminate_ext.has()) {
                return false;
            }
            if (c2c_av_terminate_msg_ext_c2cavterminatemsgext == null) {
                c2c_av_terminate_msg_ext_c2cavterminatemsgext = new c2c_av_terminate_msg_ext$C2CAVTerminateMsgExt();
            }
            try {
                c2c_av_terminate_msg_ext_c2cavterminatemsgext.mergeFrom(generalflags_resvattr.pass_through.bytes_av_terminate_ext.get().toByteArray());
                return true;
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
                return false;
            }
        } catch (InvalidProtocolBufferMicroException e17) {
            e17.printStackTrace();
            return false;
        }
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.pbelement.af, com.tencent.imcore.message.core.codec.a
    public boolean a(List<im_msg_body$Elem> list, msg_comm$Msg msg_comm_msg, List<MessageRecord> list2, StringBuilder sb5, boolean z16, boolean z17, c cVar, ab abVar, com.tencent.mobileqq.service.message.a aVar) {
        if (list2 == null) {
            return false;
        }
        c2c_av_terminate_msg_ext$C2CAVTerminateMsgExt c2c_av_terminate_msg_ext_c2cavterminatemsgext = new c2c_av_terminate_msg_ext$C2CAVTerminateMsgExt();
        for (im_msg_body$Elem im_msg_body_elem : list) {
            if (g(im_msg_body_elem, c2c_av_terminate_msg_ext_c2cavterminatemsgext) && e(im_msg_body_elem, list2, c2c_av_terminate_msg_ext_c2cavterminatemsgext)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.imcore.message.core.codec.a
    public boolean b(im_msg_body$Elem im_msg_body_elem) {
        return g(im_msg_body_elem, null);
    }

    @Override // com.tencent.imcore.message.ext.codec.decoder.pbelement.af, com.tencent.imcore.message.core.codec.a
    public int getPriority() {
        return -1000;
    }
}
