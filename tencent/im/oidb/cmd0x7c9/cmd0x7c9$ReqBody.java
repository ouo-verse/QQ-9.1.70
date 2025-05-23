package tencent.im.oidb.cmd0x7c9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7c9$ReqBody extends MessageMicro<cmd0x7c9$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"uint32_req_type", "uint32_has_data", "rpt_hello_type", "string_qua"}, new Object[]{0, 1, null, ""}, cmd0x7c9$ReqBody.class);
    public final PBUInt32Field uint32_req_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_has_data = PBField.initUInt32(1);
    public final PBRepeatMessageField<cmd0x7c9$ReqHelloType> rpt_hello_type = PBField.initRepeatMessage(cmd0x7c9$ReqHelloType.class);
    public final PBStringField string_qua = PBField.initString("");
}
