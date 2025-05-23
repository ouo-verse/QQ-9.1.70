package tencent.im.oidb.cmd0x903;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x903$RspBody extends MessageMicro<cmd0x903$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"opt_uint32_result", "opt_bytes_errmsg", "opt_msg_check_forbit_group_rsp", "opt_msg_get_invited_uin_list_rsp"}, new Object[]{0, ByteStringMicro.EMPTY, null, null}, cmd0x903$RspBody.class);
    public final PBUInt32Field opt_uint32_result = PBField.initUInt32(0);
    public final PBBytesField opt_bytes_errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
    public cmd0x903$SubCmd0x1Rsp opt_msg_check_forbit_group_rsp = new MessageMicro<cmd0x903$SubCmd0x1Rsp>() { // from class: tencent.im.oidb.cmd0x903.cmd0x903$SubCmd0x1Rsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"rpt_uint64_group_code"}, new Object[]{0L}, cmd0x903$SubCmd0x1Rsp.class);
        public final PBRepeatField<Long> rpt_uint64_group_code = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    };
    public cmd0x903$SubCmd0x2Rsp opt_msg_get_invited_uin_list_rsp = new cmd0x903$SubCmd0x2Rsp();
}
