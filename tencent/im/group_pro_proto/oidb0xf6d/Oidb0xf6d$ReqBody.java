package tencent.im.group_pro_proto.oidb0xf6d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb0xf6d$ReqBody extends MessageMicro<Oidb0xf6d$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint64_member_id", "rpt_msg_my_channel_list", "uint32_type"}, new Object[]{0L, null, 0}, Oidb0xf6d$ReqBody.class);
    public final PBUInt64Field uint64_member_id = PBField.initUInt64(0);
    public final PBRepeatMessageField<Oidb0xf6d$MyChannelInfo> rpt_msg_my_channel_list = PBField.initRepeatMessage(Oidb0xf6d$MyChannelInfo.class);
    public final PBEnumField uint32_type = PBField.initEnum(0);
}
