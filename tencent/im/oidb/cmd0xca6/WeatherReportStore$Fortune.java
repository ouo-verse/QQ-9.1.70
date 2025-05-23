package tencent.im.oidb.cmd0xca6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class WeatherReportStore$Fortune extends MessageMicro<WeatherReportStore$Fortune> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"type", "content"}, new Object[]{"", ""}, WeatherReportStore$Fortune.class);
    public final PBStringField type = PBField.initString("");
    public final PBStringField content = PBField.initString("");
}
