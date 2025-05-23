package tencent.im.oidb.cmd0xca6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class WeatherReportStore$WeatherInfoList extends MessageMicro<WeatherReportStore$WeatherInfoList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{34}, new String[]{"weatherInfo"}, new Object[]{null}, WeatherReportStore$WeatherInfoList.class);
    public final PBRepeatMessageField<WeatherReportStore$WeatherInfo> weatherInfo = PBField.initRepeatMessage(WeatherReportStore$WeatherInfo.class);
}
