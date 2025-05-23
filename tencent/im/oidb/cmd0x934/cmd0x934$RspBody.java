package tencent.im.oidb.cmd0x934;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x934$RspBody extends MessageMicro<cmd0x934$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"version", "lists", "robot_uin"}, new Object[]{0, null, 0L}, cmd0x934$RspBody.class);
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBRepeatMessageField<cmd0x934$List> lists = PBField.initRepeatMessage(cmd0x934$List.class);
    public final PBUInt64Field robot_uin = PBField.initUInt64(0);
}
