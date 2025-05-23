package tencent.im.oidb.olympic;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class torch_transfer$CityBackPicInfo extends MessageMicro<torch_transfer$CityBackPicInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50, 58}, new String[]{"uint32_city_id", "str_city_name", "uint64_city_pic_id", "str_city_pic_url", "str_city_pic_md5", "str_cons_pic_url", "str_cons_pic_md5"}, new Object[]{0, "", 0L, "", "", "", ""}, torch_transfer$CityBackPicInfo.class);
    public final PBUInt32Field uint32_city_id = PBField.initUInt32(0);
    public final PBStringField str_city_name = PBField.initString("");
    public final PBUInt64Field uint64_city_pic_id = PBField.initUInt64(0);
    public final PBStringField str_city_pic_url = PBField.initString("");
    public final PBStringField str_city_pic_md5 = PBField.initString("");
    public final PBStringField str_cons_pic_url = PBField.initString("");
    public final PBStringField str_cons_pic_md5 = PBField.initString("");
}
