package tencent.im.oidb.cmd0xca6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class WeatherReportStore$WeatherInfo extends MessageMicro<WeatherReportStore$WeatherInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56, 66, 74}, new String[]{"temper", "air_humidity", "wind_power", "wind_direct", "weather", "pubtime", "updatetime", "weather_type", "weather_type_id"}, new Object[]{"", "", "", "", "", "", 0L, "", ""}, WeatherReportStore$WeatherInfo.class);
    public final PBStringField temper = PBField.initString("");
    public final PBStringField air_humidity = PBField.initString("");
    public final PBStringField wind_power = PBField.initString("");
    public final PBStringField wind_direct = PBField.initString("");
    public final PBStringField weather = PBField.initString("");
    public final PBStringField pubtime = PBField.initString("");
    public final PBUInt64Field updatetime = PBField.initUInt64(0);
    public final PBStringField weather_type = PBField.initString("");
    public final PBStringField weather_type_id = PBField.initString("");
}
