package tencent.im.oidb.cmd0xbe6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xbe6$MsgChannelInfo extends MessageMicro<oidb_cmd0xbe6$MsgChannelInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"string_name", "uint32_channel_id", "uint32_channel_type"}, new Object[]{"", 0, 0}, oidb_cmd0xbe6$MsgChannelInfo.class);
    public final PBStringField string_name = PBField.initString("");
    public final PBUInt32Field uint32_channel_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_channel_type = PBField.initUInt32(0);
}
