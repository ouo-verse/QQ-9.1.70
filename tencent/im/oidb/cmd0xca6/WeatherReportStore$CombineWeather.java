package tencent.im.oidb.cmd0xca6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class WeatherReportStore$CombineWeather extends MessageMicro<WeatherReportStore$CombineWeather> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 56}, new String[]{"weather_info", "air_info", "forecast_list", "hourinfo_list", "warning_list", "tips_list", "update_time"}, new Object[]{null, null, null, null, null, null, 0}, WeatherReportStore$CombineWeather.class);
    public WeatherReportStore$WeatherInfo weather_info = new WeatherReportStore$WeatherInfo();
    public WeatherReportStore$AirInfo air_info = new WeatherReportStore$AirInfo();
    public WeatherReportStore$WeatherForecastList forecast_list = new WeatherReportStore$WeatherForecastList();
    public WeatherReportStore$WeatherHourInfoList hourinfo_list = new WeatherReportStore$WeatherHourInfoList();
    public WeatherReportStore$WeatherWarningList warning_list = new WeatherReportStore$WeatherWarningList();
    public WeatherReportStore$TipsList tips_list = new WeatherReportStore$TipsList();
    public final PBUInt32Field update_time = PBField.initUInt32(0);
}
