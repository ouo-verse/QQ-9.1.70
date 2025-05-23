package tencent.im.cs.cmd0x3fb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x3fb$ReqBody extends MessageMicro<cmd0x3fb$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uint32_identity", "uint64_to_guin", "uint32_client_id", "str_version"}, new Object[]{0, 0L, 0, ""}, cmd0x3fb$ReqBody.class);
    public final PBUInt32Field uint32_identity = PBField.initUInt32(0);
    public final PBUInt64Field uint64_to_guin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_client_id = PBField.initUInt32(0);
    public final PBStringField str_version = PBField.initString("");
}
