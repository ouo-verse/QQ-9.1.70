package tencent.im.oidb.cmd0xb77;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xb77$ClientInfo extends MessageMicro<oidb_cmd0xb77$ClientInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"platform", "sdk_version", "android_package_name", "android_signature", "ios_bundle_id", "pc_sign"}, new Object[]{0, "", "", "", "", ""}, oidb_cmd0xb77$ClientInfo.class);
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBStringField sdk_version = PBField.initString("");
    public final PBStringField android_package_name = PBField.initString("");
    public final PBStringField android_signature = PBField.initString("");
    public final PBStringField ios_bundle_id = PBField.initString("");
    public final PBStringField pc_sign = PBField.initString("");
}
