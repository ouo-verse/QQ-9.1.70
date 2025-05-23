package tencent.im.oidb.cmd0x8f5;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x8f5$ReqBody extends MessageMicro<oidb_cmd0x8f5$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint64_uin", "enum_follow_op", "uint32_parent_channel_id", "rpt_child_channel_list"}, new Object[]{0L, 0, 0, 0}, oidb_cmd0x8f5$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBEnumField enum_follow_op = PBField.initEnum(0);
    public final PBUInt32Field uint32_parent_channel_id = PBField.initUInt32(0);
    public final PBRepeatField<Integer> rpt_child_channel_list = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
