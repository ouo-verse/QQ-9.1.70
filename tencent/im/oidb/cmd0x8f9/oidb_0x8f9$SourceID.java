package tencent.im.oidb.cmd0x8f9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8f9$SourceID extends MessageMicro<oidb_0x8f9$SourceID> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_source_type", "uint64_source_code"}, new Object[]{0, 0L}, oidb_0x8f9$SourceID.class);
    public final PBUInt32Field uint32_source_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_source_code = PBField.initUInt64(0);
}
