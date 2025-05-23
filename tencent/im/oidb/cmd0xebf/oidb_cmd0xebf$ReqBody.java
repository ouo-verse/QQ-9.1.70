package tencent.im.oidb.cmd0xebf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xebf$ReqBody extends MessageMicro<oidb_cmd0xebf$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"business_type", "request_params_json", "extend_info_json"}, new Object[]{0, "", ""}, oidb_cmd0xebf$ReqBody.class);
    public final PBUInt32Field business_type = PBField.initUInt32(0);
    public final PBStringField request_params_json = PBField.initString("");
    public final PBStringField extend_info_json = PBField.initString("");
}
