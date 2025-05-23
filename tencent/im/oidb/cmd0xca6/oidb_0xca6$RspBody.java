package tencent.im.oidb.cmd0xca6;

import com.tencent.gdtad.jsbridge.GdtGetUserInfoHandler;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xca6$RspBody extends MessageMicro<oidb_0xca6$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 96, 104, 114, 122, 128, 138, 194}, new String[]{"ret", "weather_info", "air_info", "forecast_list", "forecast", "hourinfo_list", "almanac", "warning_list", "astro", "city", GdtGetUserInfoHandler.KEY_AREA, "adcode", "area_id", "all_astro", "en_name", "update_time", "tips_list", "qqStatus"}, new Object[]{0, null, null, null, null, null, "", null, null, "", "", 0, 0, null, "", 0, null, null}, oidb_0xca6$RspBody.class);
    public final PBUInt32Field ret = PBField.initUInt32(0);
    public WeatherReportStore$WeatherInfo weather_info = new WeatherReportStore$WeatherInfo();
    public WeatherReportStore$AirInfo air_info = new WeatherReportStore$AirInfo();
    public WeatherReportStore$WeatherForecastList forecast_list = new WeatherReportStore$WeatherForecastList();
    public WeatherReportStore$WeatherForecast forecast = new MessageMicro<WeatherReportStore$WeatherForecast>() { // from class: tencent.im.oidb.cmd0xca6.WeatherReportStore$WeatherForecast
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 96, 106, 114, 122, 130}, new String[]{"day_weather", "night_weather", "day_temper", "night_temper", "day_wind_direct", "night_wind_direct", "day_wind_power", "night_wind_power", "sunrise_time", "sunset_time", "pubtime", "day", "day_weather_type", "night_weather_type", "day_weather_type_id", "night_weather_type_id"}, new Object[]{"", "", "", "", "", "", "", "", "", "", "", 0, "", "", "", ""}, WeatherReportStore$WeatherForecast.class);
        public final PBStringField day_weather = PBField.initString("");
        public final PBStringField night_weather = PBField.initString("");
        public final PBStringField day_temper = PBField.initString("");
        public final PBStringField night_temper = PBField.initString("");
        public final PBStringField day_wind_direct = PBField.initString("");
        public final PBStringField night_wind_direct = PBField.initString("");
        public final PBStringField day_wind_power = PBField.initString("");
        public final PBStringField night_wind_power = PBField.initString("");
        public final PBStringField sunrise_time = PBField.initString("");
        public final PBStringField sunset_time = PBField.initString("");
        public final PBStringField pubtime = PBField.initString("");
        public final PBUInt32Field day = PBField.initUInt32(0);
        public final PBStringField day_weather_type = PBField.initString("");
        public final PBStringField night_weather_type = PBField.initString("");
        public final PBStringField day_weather_type_id = PBField.initString("");
        public final PBStringField night_weather_type_id = PBField.initString("");
    };
    public WeatherReportStore$WeatherHourInfoList hourinfo_list = new WeatherReportStore$WeatherHourInfoList();
    public final PBStringField almanac = PBField.initString("");
    public WeatherReportStore$WeatherWarningList warning_list = new WeatherReportStore$WeatherWarningList();
    public WeatherReportStore$DailyAstroFortune astro = new MessageMicro<WeatherReportStore$DailyAstroFortune>() { // from class: tencent.im.oidb.cmd0xca6.WeatherReportStore$DailyAstroFortune
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 58}, new String[]{"astro", "date", "fortunes", "astro_id", "astro_pic", "astro_title", "recommend"}, new Object[]{"", "", null, 0, "", "", null}, WeatherReportStore$DailyAstroFortune.class);
        public final PBStringField astro = PBField.initString("");
        public final PBStringField date = PBField.initString("");
        public final PBRepeatMessageField<WeatherReportStore$Fortune> fortunes = PBField.initRepeatMessage(WeatherReportStore$Fortune.class);
        public final PBUInt32Field astro_id = PBField.initUInt32(0);
        public final PBStringField astro_pic = PBField.initString("");
        public final PBStringField astro_title = PBField.initString("");
        public WeatherReportStore$AstroRecommend recommend = new MessageMicro<WeatherReportStore$AstroRecommend>() { // from class: tencent.im.oidb.cmd0xca6.WeatherReportStore$AstroRecommend
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"signId", "daily", "commentary", "image", "path"}, new Object[]{"", "", "", "", ""}, WeatherReportStore$AstroRecommend.class);
            public final PBStringField signId = PBField.initString("");
            public final PBStringField daily = PBField.initString("");
            public final PBStringField commentary = PBField.initString("");
            public final PBStringField image = PBField.initString("");
            public final PBStringField path = PBField.initString("");
        };
    };
    public final PBStringField city = PBField.initString("");
    public final PBStringField area = PBField.initString("");
    public final PBUInt32Field adcode = PBField.initUInt32(0);
    public final PBUInt32Field area_id = PBField.initUInt32(0);
    public final PBRepeatMessageField<WeatherReportStore$DailyAstroFortune> all_astro = PBField.initRepeatMessage(WeatherReportStore$DailyAstroFortune.class);
    public final PBStringField en_name = PBField.initString("");
    public final PBUInt32Field update_time = PBField.initUInt32(0);
    public WeatherReportStore$TipsList tips_list = new WeatherReportStore$TipsList();
    public oidb_0xca6$QQStatus qqStatus = new oidb_0xca6$QQStatus();
}
