package tencent.im.oidb.cmd0xca6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class WeatherReportStore$AreaWeatherKey extends MessageMicro<WeatherReportStore$AreaWeatherKey> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"area_id", "type"}, new Object[]{0, 0}, WeatherReportStore$AreaWeatherKey.class);
    public final PBUInt32Field area_id = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
}
