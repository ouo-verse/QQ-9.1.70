package tencent.im.oidb.cmd0xfc2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xfc2$Addr extends MessageMicro<oidb_0xfc2$Addr> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"str_ip", "uint32_http_port", "uint32_https_port"}, new Object[]{"", 0, 0}, oidb_0xfc2$Addr.class);
    public final PBStringField str_ip = PBField.initString("");
    public final PBUInt32Field uint32_http_port = PBField.initUInt32(0);
    public final PBUInt32Field uint32_https_port = PBField.initUInt32(0);
}
