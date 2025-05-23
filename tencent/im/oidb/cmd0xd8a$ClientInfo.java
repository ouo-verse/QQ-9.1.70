package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xd8a$ClientInfo extends MessageMicro<cmd0xd8a$ClientInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_implat", "string_clientver"}, new Object[]{0, ""}, cmd0xd8a$ClientInfo.class);
    public final PBUInt32Field uint32_implat = PBField.initUInt32(0);
    public final PBStringField string_clientver = PBField.initString("");
}
