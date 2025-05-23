package tencent.im.label.comm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class PersonalityTagComm$Uin2Time extends MessageMicro<PersonalityTagComm$Uin2Time> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_time", "uint64_uin"}, new Object[]{0, 0L}, PersonalityTagComm$Uin2Time.class);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
}
