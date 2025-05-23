package tencent.im.oidb.cmd0xf4d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xf4d$ReportInfo extends MessageMicro<oidb_0xf4d$ReportInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"show_type", "show_text"}, new Object[]{0, ""}, oidb_0xf4d$ReportInfo.class);
    public final PBUInt32Field show_type = PBField.initUInt32(0);
    public final PBStringField show_text = PBField.initString("");
}
