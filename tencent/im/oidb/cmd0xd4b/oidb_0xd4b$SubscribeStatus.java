package tencent.im.oidb.cmd0xd4b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xd4b$SubscribeStatus extends MessageMicro<oidb_0xd4b$SubscribeStatus> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_column_id", "uint32_sub_status"}, new Object[]{0, 0}, oidb_0xd4b$SubscribeStatus.class);
    public final PBUInt32Field uint32_column_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sub_status = PBField.initUInt32(0);
}
