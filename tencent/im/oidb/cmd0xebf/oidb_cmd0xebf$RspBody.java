package tencent.im.oidb.cmd0xebf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xebf$RspBody extends MessageMicro<oidb_cmd0xebf$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"business_type", "ret_code", "result_json"}, new Object[]{0, 0, ""}, oidb_cmd0xebf$RspBody.class);
    public final PBUInt32Field business_type = PBField.initUInt32(0);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField result_json = PBField.initString("");
}
