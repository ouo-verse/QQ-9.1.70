package tencent.im.s2c.msgtype0x210.submsgtype0x16a;

import com.tencent.mobileqq.minigame.report.StartupReportKey;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x16a$LockStatusChangeNotify extends MessageMicro<SubMsgType0x16a$LockStatusChangeNotify> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58}, new String[]{"type", "instance_id", "seq", "lock_status", StartupReportKey.PLATFORM_ID, "plat_type", "dev_name"}, new Object[]{0, 0, 0L, 0, 0, 0, ByteStringMicro.EMPTY}, SubMsgType0x16a$LockStatusChangeNotify.class);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt32Field instance_id = PBField.initUInt32(0);
    public final PBUInt64Field seq = PBField.initUInt64(0);
    public final PBUInt32Field lock_status = PBField.initUInt32(0);
    public final PBUInt32Field platform_id = PBField.initUInt32(0);
    public final PBUInt32Field plat_type = PBField.initUInt32(0);
    public final PBBytesField dev_name = PBField.initBytes(ByteStringMicro.EMPTY);
}
