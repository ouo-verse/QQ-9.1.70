package tencent.im.msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_msg_head$InstInfo extends MessageMicro<im_msg_head$InstInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 80}, new String[]{"uint32_apppid", "uint32_instid", "uint32_platform", "enum_device_type"}, new Object[]{0, 0, 0, 0}, im_msg_head$InstInfo.class);
    public final PBUInt32Field uint32_apppid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_instid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_platform = PBField.initUInt32(0);
    public final PBEnumField enum_device_type = PBField.initEnum(0);
}
