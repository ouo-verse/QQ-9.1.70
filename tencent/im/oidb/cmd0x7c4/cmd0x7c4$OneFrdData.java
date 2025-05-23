package tencent.im.oidb.cmd0x7c4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7c4$OneFrdData extends MessageMicro<cmd0x7c4$OneFrdData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40}, new String[]{"uint64_frd_id", "uint32_reason_id", "bytes_smart_remark", "uint32_gender", "uint32_ages"}, new Object[]{0L, 0, ByteStringMicro.EMPTY, 0, 0}, cmd0x7c4$OneFrdData.class);
    public final PBUInt64Field uint64_frd_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_reason_id = PBField.initUInt32(0);
    public final PBBytesField bytes_smart_remark = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ages = PBField.initUInt32(0);
}
