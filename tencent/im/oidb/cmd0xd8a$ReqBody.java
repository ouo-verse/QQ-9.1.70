package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xd8a$ReqBody extends MessageMicro<cmd0xd8a$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uint64_uin", "uint32_cmd", "str_body", "client_info"}, new Object[]{0L, 0, "", null}, cmd0xd8a$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
    public final PBStringField str_body = PBField.initString("");
    public cmd0xd8a$ClientInfo client_info = new cmd0xd8a$ClientInfo();
}
