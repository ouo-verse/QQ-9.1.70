package tencent.im.oidb.cmd0xca6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class WeatherReportStore$TipsItem extends MessageMicro<WeatherReportStore$TipsItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"content", "date"}, new Object[]{"", ""}, WeatherReportStore$TipsItem.class);
    public final PBStringField content = PBField.initString("");
    public final PBStringField date = PBField.initString("");
}
