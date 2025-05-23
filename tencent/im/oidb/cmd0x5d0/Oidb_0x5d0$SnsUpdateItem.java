package tencent.im.oidb.cmd0x5d0;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x5d0$SnsUpdateItem extends MessageMicro<Oidb_0x5d0$SnsUpdateItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_update_sns_type", "bytes_value"}, new Object[]{0, ByteStringMicro.EMPTY}, Oidb_0x5d0$SnsUpdateItem.class);
    public final PBUInt32Field uint32_update_sns_type = PBField.initUInt32(0);
    public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
}
