package tencent.im.mobileqq.mobroute;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DomainIp$MobRouteSSOListInfo extends MessageMicro<DomainIp$MobRouteSSOListInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"string_ip", "uint32_port"}, new Object[]{"", 0}, DomainIp$MobRouteSSOListInfo.class);
    public final PBStringField string_ip = PBField.initString("");
    public final PBUInt32Field uint32_port = PBField.initUInt32(0);
}
