package tvideo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class TVideoChannelList$ReportMap extends MessageMicro<TVideoChannelList$ReportMap> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, TVideoChannelList$ReportMap.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
}
