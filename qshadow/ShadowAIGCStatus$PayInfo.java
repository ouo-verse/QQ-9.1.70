package qshadow;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheQzoneVipData;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class ShadowAIGCStatus$PayInfo extends MessageMicro<ShadowAIGCStatus$PayInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 42, 48, 56}, new String[]{"type", "text", "desc", AppConstants.VIPKey.KEY_FOR_VIP_TYPE, "vip_name", "quota", WidgetCacheQzoneVipData.ISVIP}, new Object[]{0, "", "", 0, "", 0, Boolean.FALSE}, ShadowAIGCStatus$PayInfo.class);
    public final PBEnumField type = PBField.initEnum(0);
    public final PBStringField text = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBEnumField vip_type = PBField.initEnum(0);
    public final PBStringField vip_name = PBField.initString("");
    public final PBInt32Field quota = PBField.initInt32(0);
    public final PBBoolField is_vip = PBField.initBool(false);
}
