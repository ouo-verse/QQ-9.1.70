package tencent.im.oidb.cmd0x8dd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class oidb_0x8dd$POIDetail extends MessageMicro<oidb_0x8dd$POIDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 34, 42, 50, 58, 66, 74, 82, 90}, new String[]{"str_nation", "str_name", "str_province", "str_city", "str_district", "str_town", "str_village", "str_street", "str_street_no", "str_code"}, new Object[]{"", "", "", "", "", "", "", "", "", ""}, oidb_0x8dd$POIDetail.class);
    public final PBStringField str_nation = PBField.initString("");
    public final PBStringField str_name = PBField.initString("");
    public final PBStringField str_province = PBField.initString("");
    public final PBStringField str_city = PBField.initString("");
    public final PBStringField str_district = PBField.initString("");
    public final PBStringField str_town = PBField.initString("");
    public final PBStringField str_village = PBField.initString("");
    public final PBStringField str_street = PBField.initString("");
    public final PBStringField str_street_no = PBField.initString("");
    public final PBStringField str_code = PBField.initString("");
}
