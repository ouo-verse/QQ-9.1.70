package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x27$DelFriend extends MessageMicro<SubMsgType0x27$DelFriend> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"rpt_uint64_uins"}, new Object[]{0L}, SubMsgType0x27$DelFriend.class);
    public final PBRepeatField<Long> rpt_uint64_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
