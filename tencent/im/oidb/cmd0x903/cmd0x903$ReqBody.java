package tencent.im.oidb.cmd0x903;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x903$ReqBody extends MessageMicro<cmd0x903$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"opt_msg_check_forbit_group_req", "opt_msg_get_invited_uin_list_req", "uint32_client_type", "uint32_client_version"}, new Object[]{null, null, 0, 0}, cmd0x903$ReqBody.class);
    public cmd0x903$SubCmd0x1Req opt_msg_check_forbit_group_req = new MessageMicro<cmd0x903$SubCmd0x1Req>() { // from class: tencent.im.oidb.cmd0x903.cmd0x903$SubCmd0x1Req
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"rpt_uint64_group_code"}, new Object[]{0L}, cmd0x903$SubCmd0x1Req.class);
        public final PBRepeatField<Long> rpt_uint64_group_code = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    };
    public cmd0x903$SubCmd0x2Req opt_msg_get_invited_uin_list_req = new cmd0x903$SubCmd0x2Req();
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_version = PBField.initUInt32(0);
}
