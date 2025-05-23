package tencent.im.oidb.cmd0xca6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class WeatherReportStore$WeatherWarningDetail extends MessageMicro<WeatherReportStore$WeatherWarningDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 50, 56, 64, 74, 82, 90, 98, 106, 114, 122, 130}, new String[]{"id", "area_id", "type", "level", "status", "content", "pub_time", "op_time", "pub_org", "affect", "defend", "cancle_desc", "province", "city", "type_name", "level_name"}, new Object[]{"", 0, 0, 0, 0, "", 0, 0, "", "", "", "", "", "", "", ""}, WeatherReportStore$WeatherWarningDetail.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f435989id = PBField.initString("");
    public final PBUInt32Field area_id = PBField.initUInt32(0);
    public final PBInt32Field type = PBField.initInt32(0);
    public final PBInt32Field level = PBField.initInt32(0);
    public final PBInt32Field status = PBField.initInt32(0);
    public final PBStringField content = PBField.initString("");
    public final PBInt32Field pub_time = PBField.initInt32(0);
    public final PBInt32Field op_time = PBField.initInt32(0);
    public final PBStringField pub_org = PBField.initString("");
    public final PBStringField affect = PBField.initString("");
    public final PBStringField defend = PBField.initString("");
    public final PBStringField cancle_desc = PBField.initString("");
    public final PBStringField province = PBField.initString("");
    public final PBStringField city = PBField.initString("");
    public final PBStringField type_name = PBField.initString("");
    public final PBStringField level_name = PBField.initString("");
}
