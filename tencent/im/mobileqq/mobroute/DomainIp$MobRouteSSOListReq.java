package tencent.im.mobileqq.mobroute;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DomainIp$MobRouteSSOListReq extends MessageMicro<DomainIp$MobRouteSSOListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 50}, new String[]{"uint32_uintype", "string_uin", "string_imsi", "uint32_nettype", "uint32_appid", "string_imei"}, new Object[]{0, "", "", 0, 0, ""}, DomainIp$MobRouteSSOListReq.class);
    public final PBUInt32Field uint32_uintype = PBField.initUInt32(0);
    public final PBStringField string_uin = PBField.initString("");
    public final PBStringField string_imsi = PBField.initString("");
    public final PBUInt32Field uint32_nettype = PBField.initUInt32(0);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBStringField string_imei = PBField.initString("");
}
