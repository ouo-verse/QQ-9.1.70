package tencent.im.oidb.cmd0xe26;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.thumbplayer.report.reportv1.TPReportParams;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe26$ClientInfo extends MessageMicro<oidb_0xe26$ClientInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", TPReportParams.JSON_KEY_VAL}, new Object[]{"", ""}, oidb_0xe26$ClientInfo.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField val = PBField.initString("");
}
