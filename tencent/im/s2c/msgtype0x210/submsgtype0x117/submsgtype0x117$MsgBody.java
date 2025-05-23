package tencent.im.s2c.msgtype0x210.submsgtype0x117;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x117$MsgBody extends MessageMicro<submsgtype0x117$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_uin", "rpt_uint32_moudle_id"}, new Object[]{0L, 0}, submsgtype0x117$MsgBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBRepeatField<Integer> rpt_uint32_moudle_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
