package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x6f5$TaskInfo extends MessageMicro<cmd0x6f5$TaskInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{"uint32_task_id", "uint32_appid", "uint32_passthrough_level", "uint32_show_level", "uint32_extra", "uint32_priority"}, new Object[]{0, 0, 0, 0, 0, 0}, cmd0x6f5$TaskInfo.class);
    public final PBUInt32Field uint32_task_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_passthrough_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_level = PBField.initUInt32(0);
    public final PBUInt32Field uint32_extra = PBField.initUInt32(0);
    public final PBUInt32Field uint32_priority = PBField.initUInt32(0);
}
