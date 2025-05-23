package tencent.im.oidb.cmd0x8fc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x8fc$ClientInfo extends MessageMicro<Oidb_0x8fc$ClientInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_implat", "string_clientver"}, new Object[]{0, ""}, Oidb_0x8fc$ClientInfo.class);
    public final PBUInt32Field uint32_implat = PBField.initUInt32(0);
    public final PBStringField string_clientver = PBField.initString("");
}
