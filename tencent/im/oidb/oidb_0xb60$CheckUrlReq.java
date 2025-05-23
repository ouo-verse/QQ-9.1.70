package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xb60$CheckUrlReq extends MessageMicro<oidb_0xb60$CheckUrlReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"appid", "app_type", "url"}, new Object[]{0, 0, ""}, oidb_0xb60$CheckUrlReq.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBUInt32Field app_type = PBField.initUInt32(0);
    public final PBStringField url = PBField.initString("");
}
