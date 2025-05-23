package tencent.im.oidb.cmd0x5d6;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x5d6$SnsUpdateItem extends MessageMicro<oidb_0x5d6$SnsUpdateItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_update_sns_type", "bytes_value", "uint32_value_offset"}, new Object[]{0, ByteStringMicro.EMPTY, 0}, oidb_0x5d6$SnsUpdateItem.class);
    public final PBUInt32Field uint32_update_sns_type = PBField.initUInt32(0);
    public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_value_offset = PBField.initUInt32(0);
}
