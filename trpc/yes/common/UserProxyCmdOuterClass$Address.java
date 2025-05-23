package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes30.dex */
public final class UserProxyCmdOuterClass$Address extends MessageMicro<UserProxyCmdOuterClass$Address> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82}, new String[]{"country", "zone_name", "zone_code", "province", "city", "district", "town", "village", "street", "street_no"}, new Object[]{"", "", "", "", "", "", "", "", "", ""}, UserProxyCmdOuterClass$Address.class);
    public final PBStringField country = PBField.initString("");
    public final PBStringField zone_name = PBField.initString("");
    public final PBStringField zone_code = PBField.initString("");
    public final PBStringField province = PBField.initString("");
    public final PBStringField city = PBField.initString("");
    public final PBStringField district = PBField.initString("");
    public final PBStringField town = PBField.initString("");
    public final PBStringField village = PBField.initString("");
    public final PBStringField street = PBField.initString("");
    public final PBStringField street_no = PBField.initString("");
}
