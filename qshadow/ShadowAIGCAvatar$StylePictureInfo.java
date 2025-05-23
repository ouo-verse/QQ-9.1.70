package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.wink.api.QQWinkConstants;

/* loaded from: classes29.dex */
public final class ShadowAIGCAvatar$StylePictureInfo extends MessageMicro<ShadowAIGCAvatar$StylePictureInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"material_id", QQWinkConstants.BUSINESS_MAIGC_STUDIO_STYLE_NAME, "material_url"}, new Object[]{"", "", ""}, ShadowAIGCAvatar$StylePictureInfo.class);
    public final PBStringField material_id = PBField.initString("");
    public final PBStringField style_name = PBField.initString("");
    public final PBStringField material_url = PBField.initString("");
}
