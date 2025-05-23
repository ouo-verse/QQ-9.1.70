package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8dd$LocationInfo extends MessageMicro<oidb_0x8dd$LocationInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"str_province", "str_city", "str_district", "str_town", "str_road", "str_premises"}, new Object[]{"", "", "", "", "", ""}, oidb_0x8dd$LocationInfo.class);
    public final PBStringField str_province = PBField.initString("");
    public final PBStringField str_city = PBField.initString("");
    public final PBStringField str_district = PBField.initString("");
    public final PBStringField str_town = PBField.initString("");
    public final PBStringField str_road = PBField.initString("");
    public final PBStringField str_premises = PBField.initString("");
}
