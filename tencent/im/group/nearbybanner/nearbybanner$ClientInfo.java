package tencent.im.group.nearbybanner;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nearbybanner$ClientInfo extends MessageMicro<nearbybanner$ClientInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"uint32_lcd_height", "uint32_lcd_width", "bytes_client_version", "uint32_os"}, new Object[]{0, 0, ByteStringMicro.EMPTY, 0}, nearbybanner$ClientInfo.class);
    public final PBUInt32Field uint32_lcd_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_lcd_width = PBField.initUInt32(0);
    public final PBBytesField bytes_client_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_os = PBField.initUInt32(0);
}
