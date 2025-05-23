package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QZIntimateProfileReader$SpaceThemeInfo extends MessageMicro<QZIntimateProfileReader$SpaceThemeInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"update_lable_color", "card_daytime_color", "card_night_color", "customer_daytime_color", "customer_night_color"}, new Object[]{"", "", "", "", ""}, QZIntimateProfileReader$SpaceThemeInfo.class);
    public final PBStringField update_lable_color = PBField.initString("");
    public final PBStringField card_daytime_color = PBField.initString("");
    public final PBStringField card_night_color = PBField.initString("");
    public final PBStringField customer_daytime_color = PBField.initString("");
    public final PBStringField customer_night_color = PBField.initString("");
}
