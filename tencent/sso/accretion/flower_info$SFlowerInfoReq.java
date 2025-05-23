package tencent.sso.accretion;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class flower_info$SFlowerInfoReq extends MessageMicro<flower_info$SFlowerInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 50}, new String[]{"uin", "queryuin", "version", "platform", "type", "key"}, new Object[]{0L, 0L, "5.4.0", 0, 0, ""}, flower_info$SFlowerInfoReq.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt64Field queryuin = PBField.initUInt64(0);
    public final PBStringField version = PBField.initString("5.4.0");
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBStringField key = PBField.initString("");
}
