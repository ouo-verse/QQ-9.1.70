package tencent.im.oidb;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class oidb_0xb61$GetPkgUrlReq extends MessageMicro<oidb_0xb61$GetPkgUrlReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50}, new String[]{"appid", "app_type", "app_version", "platform", "sys_version", AppConstants.Preferences.QQ_VERSION}, new Object[]{0, 0, 0, 0, "", ""}, oidb_0xb61$GetPkgUrlReq.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBUInt32Field app_type = PBField.initUInt32(0);
    public final PBUInt32Field app_version = PBField.initUInt32(0);
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBStringField sys_version = PBField.initString("");
    public final PBStringField qq_version = PBField.initString("");
}
