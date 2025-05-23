package tencent.im.s2c.msgtype0x210.submsgtype0x9b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class SubMsgType0x9b$PbOfficeNotify extends MessageMicro<SubMsgType0x9b$PbOfficeNotify> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"opt_uint32_myoffice_flag", "rpt_uint64_appid"}, new Object[]{0, 0L}, SubMsgType0x9b$PbOfficeNotify.class);
    public final PBUInt32Field opt_uint32_myoffice_flag = PBField.initUInt32(0);
    public final PBRepeatField<Long> rpt_uint64_appid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
