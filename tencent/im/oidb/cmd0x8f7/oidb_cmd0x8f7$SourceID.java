package tencent.im.oidb.cmd0x8f7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x8f7$SourceID extends MessageMicro<oidb_cmd0x8f7$SourceID> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_source_type", "uint64_source_code"}, new Object[]{0, 0L}, oidb_cmd0x8f7$SourceID.class);
    public final PBUInt32Field uint32_source_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_source_code = PBField.initUInt64(0);
}
