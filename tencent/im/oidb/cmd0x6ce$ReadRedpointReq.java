package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x6ce$ReadRedpointReq extends MessageMicro<cmd0x6ce$ReadRedpointReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_taskid", "uint64_read_seq", "uint32_appid"}, new Object[]{0, 0L, 0}, cmd0x6ce$ReadRedpointReq.class);
    public final PBUInt32Field uint32_taskid = PBField.initUInt32(0);
    public final PBUInt64Field uint64_read_seq = PBField.initUInt64(0);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
}
