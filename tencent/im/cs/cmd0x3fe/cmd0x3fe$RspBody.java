package tencent.im.cs.cmd0x3fe;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x3fe$RspBody extends MessageMicro<cmd0x3fe$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 80}, new String[]{"int32_ret", "rpt_msg_level_info", "uint32_subcmd"}, new Object[]{0, null, 0}, cmd0x3fe$RspBody.class);
    public final PBInt32Field int32_ret = PBField.initInt32(0);
    public final PBRepeatMessageField<cmd0x3fe$LevelInfo> rpt_msg_level_info = PBField.initRepeatMessage(cmd0x3fe$LevelInfo.class);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
}
