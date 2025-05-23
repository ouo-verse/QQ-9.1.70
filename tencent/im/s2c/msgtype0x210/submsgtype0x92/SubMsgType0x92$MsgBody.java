package tencent.im.s2c.msgtype0x210.submsgtype0x92;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x92$MsgBody extends MessageMicro<SubMsgType0x92$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 802}, new String[]{"uint32_sub_cmd", "msg_crm_common_head", "msg_Push_Eman_Msg"}, new Object[]{0, null, null}, SubMsgType0x92$MsgBody.class);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public SubMsgType0x92$CrmS2CMsgHead msg_crm_common_head = new MessageMicro<SubMsgType0x92$CrmS2CMsgHead>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0x92.SubMsgType0x92$CrmS2CMsgHead
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 66}, new String[]{"uint32_crm_sub_cmd", "uint32_head_len", "uint32_ver_no", "uint64_kf_uin", "uint32_seq", "uint32_pack_num", "uint32_cur_pack", "str_buf_sig"}, new Object[]{0, 0, 0, 0L, 0, 0, 0, ""}, SubMsgType0x92$CrmS2CMsgHead.class);
        public final PBUInt32Field uint32_crm_sub_cmd = PBField.initUInt32(0);
        public final PBUInt32Field uint32_head_len = PBField.initUInt32(0);
        public final PBUInt32Field uint32_ver_no = PBField.initUInt32(0);
        public final PBUInt64Field uint64_kf_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
        public final PBUInt32Field uint32_pack_num = PBField.initUInt32(0);
        public final PBUInt32Field uint32_cur_pack = PBField.initUInt32(0);
        public final PBStringField str_buf_sig = PBField.initString("");
    };
    public S2CPushEmanMsgToC msg_Push_Eman_Msg = new S2CPushEmanMsgToC();

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class S2CPushEmanMsgToC extends MessageMicro<S2CPushEmanMsgToC> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_uin", "str_xml"}, new Object[]{0L, ""}, S2CPushEmanMsgToC.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBStringField str_xml = PBField.initString("");
    }
}
