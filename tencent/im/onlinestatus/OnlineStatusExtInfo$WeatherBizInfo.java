package tencent.im.onlinestatus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class OnlineStatusExtInfo$WeatherBizInfo extends MessageMicro<OnlineStatusExtInfo$WeatherBizInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 50, 58, 64, 74, 82, 90}, new String[]{"string_weather_type", "string_weather_type_id", "uint32_adcode", "uint64_update_time", "string_city", "string_area", "string_temper", "uint32_flag", "string_weather_desc", "icon_key", "prompt"}, new Object[]{"", "", 0, 0L, "", "", "", 0, "", "", ""}, OnlineStatusExtInfo$WeatherBizInfo.class);
    public final PBStringField string_weather_type = PBField.initString("");
    public final PBStringField string_weather_type_id = PBField.initString("");
    public final PBUInt32Field uint32_adcode = PBField.initUInt32(0);
    public final PBUInt64Field uint64_update_time = PBField.initUInt64(0);
    public final PBStringField string_city = PBField.initString("");
    public final PBStringField string_area = PBField.initString("");
    public final PBStringField string_temper = PBField.initString("");
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBStringField string_weather_desc = PBField.initString("");
    public final PBStringField icon_key = PBField.initString("");
    public final PBStringField prompt = PBField.initString("");
}
