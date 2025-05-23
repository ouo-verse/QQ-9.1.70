package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.state.map.MapItemKt;
import com.tencent.view.FilterEnum;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qqconnect$ConnectClientInfo extends MessageMicro<qqconnect$ConnectClientInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 170, 178, 250, 258, 266, 274, FilterEnum.MIC_PTU_BAIXI, MapItemKt.ITEM_AVATAR_MIN_WIDTH}, new String[]{"platform", "sdk_version", "system_name", "system_version", "android_package_name", "android_signature", "ios_bundle_id", "ios_device_id", "ios_app_token", "ios_ref_bundle_id", "ios_ref_universal_link", "pc_sign"}, new Object[]{0, "", "", "", "", "", "", "", "", "", "", ""}, qqconnect$ConnectClientInfo.class);
    public final PBUInt32Field platform = PBField.initUInt32(0);
    public final PBStringField sdk_version = PBField.initString("");
    public final PBStringField system_name = PBField.initString("");
    public final PBStringField system_version = PBField.initString("");
    public final PBStringField android_package_name = PBField.initString("");
    public final PBStringField android_signature = PBField.initString("");
    public final PBStringField ios_bundle_id = PBField.initString("");
    public final PBStringField ios_device_id = PBField.initString("");
    public final PBStringField ios_app_token = PBField.initString("");
    public final PBStringField ios_ref_bundle_id = PBField.initString("");
    public final PBStringField ios_ref_universal_link = PBField.initString("");
    public final PBStringField pc_sign = PBField.initString("");
}
