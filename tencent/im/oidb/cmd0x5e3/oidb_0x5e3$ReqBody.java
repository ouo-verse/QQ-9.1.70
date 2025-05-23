package tencent.im.oidb.cmd0x5e3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x5e3$ReqBody extends MessageMicro<oidb_0x5e3$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90, 98, 104, 112, 122, 170}, new String[]{"rpt_msg_get_qq_uin_req", "rpt_msg_get_qcall_uin_req", "uint64_timestamp", "uint32_max_rsp_len", "msg_qq_login_sig", "msg_get_phone_req"}, new Object[]{null, null, 0L, 0, null, null}, oidb_0x5e3$ReqBody.class);
    public oidb_0x5e3$GetQQUinReq rpt_msg_get_qq_uin_req = new MessageMicro<oidb_0x5e3$GetQQUinReq>() { // from class: tencent.im.oidb.cmd0x5e3.oidb_0x5e3$GetQQUinReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 160016, 160072, 160248, 560000, 560008, 560016, 560024, 560032, 800160}, new String[]{"rpt_uint64_uins", "uint32_req_nick", "uint32_req_gender", "uint32_req_birthday", "uint32_req_remark", "uint32_req_netstatus", "uint32_req_qcall_id", "uint32_req_is_call_free", "uint32_req_auto_remark", "uint32_req_qcall_nick"}, new Object[]{0L, 0, 0, 0, 0, 0, 0, 0, 0, 0}, oidb_0x5e3$GetQQUinReq.class);
        public final PBRepeatField<Long> rpt_uint64_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
        public final PBUInt32Field uint32_req_nick = PBField.initUInt32(0);
        public final PBUInt32Field uint32_req_gender = PBField.initUInt32(0);
        public final PBUInt32Field uint32_req_birthday = PBField.initUInt32(0);
        public final PBUInt32Field uint32_req_remark = PBField.initUInt32(0);
        public final PBUInt32Field uint32_req_netstatus = PBField.initUInt32(0);
        public final PBUInt32Field uint32_req_qcall_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_req_is_call_free = PBField.initUInt32(0);
        public final PBUInt32Field uint32_req_auto_remark = PBField.initUInt32(0);
        public final PBUInt32Field uint32_req_qcall_nick = PBField.initUInt32(0);
    };
    public oidb_0x5e3$GetQCallUinReq rpt_msg_get_qcall_uin_req = new oidb_0x5e3$GetQCallUinReq();
    public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0);
    public final PBUInt32Field uint32_max_rsp_len = PBField.initUInt32(0);
    public oidb_0x5e3$QQLoginSig msg_qq_login_sig = new MessageMicro<oidb_0x5e3$QQLoginSig>() { // from class: tencent.im.oidb.cmd0x5e3.oidb_0x5e3$QQLoginSig
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"uint64_uin", "uint32_type", "bytes_sig", "uint32_appid"}, new Object[]{0L, 0, ByteStringMicro.EMPTY, 0}, oidb_0x5e3$QQLoginSig.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_type = PBField.initUInt32(0);
        public final PBBytesField bytes_sig = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    };
    public oidb_0x5e3$GetPhoneReq msg_get_phone_req = new MessageMicro<oidb_0x5e3$GetPhoneReq>() { // from class: tencent.im.oidb.cmd0x5e3.oidb_0x5e3$GetPhoneReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 88, 96}, new String[]{"rpt_bytes_phones", "uint32_req_contact_qq", "uint32_req_qq_status"}, new Object[]{ByteStringMicro.EMPTY, 0, 0}, oidb_0x5e3$GetPhoneReq.class);
        public final PBRepeatField<ByteStringMicro> rpt_bytes_phones = PBField.initRepeat(PBBytesField.__repeatHelper__);
        public final PBUInt32Field uint32_req_contact_qq = PBField.initUInt32(0);
        public final PBUInt32Field uint32_req_qq_status = PBField.initUInt32(0);
    };
}
