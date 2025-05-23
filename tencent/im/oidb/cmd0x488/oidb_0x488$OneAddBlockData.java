package tencent.im.oidb.cmd0x488;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x488$OneAddBlockData extends MessageMicro<oidb_0x488$OneAddBlockData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uint32_account_type", "uint64_block_qcall_id", "uint32_result", "bytes_mobile"}, new Object[]{0, 0L, 0, ByteStringMicro.EMPTY}, oidb_0x488$OneAddBlockData.class);
    public final PBUInt32Field uint32_account_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_block_qcall_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBBytesField bytes_mobile = PBField.initBytes(ByteStringMicro.EMPTY);
}
