package tencent.im.oidb.oidb_0x783;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x783$RemarkInfo extends MessageMicro<oidb_0x783$RemarkInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"uint64_uin", "bytes_remark", "uint32_source", "uint32_is_frd"}, new Object[]{0L, ByteStringMicro.EMPTY, 0, 0}, oidb_0x783$RemarkInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBBytesField bytes_remark = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_source = PBField.initUInt32(0);
    public final PBUInt32Field uint32_is_frd = PBField.initUInt32(0);
}
