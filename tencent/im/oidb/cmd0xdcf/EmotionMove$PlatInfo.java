package tencent.im.oidb.cmd0xdcf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;

/* loaded from: classes29.dex */
public final class EmotionMove$PlatInfo extends MessageMicro<EmotionMove$PlatInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"implat", TPReportKeys.Common.COMMON_OS_VERSION, "mqqver"}, new Object[]{0, "", ""}, EmotionMove$PlatInfo.class);
    public final PBInt32Field implat = PBField.initInt32(0);
    public final PBStringField osver = PBField.initString("");
    public final PBStringField mqqver = PBField.initString("");
}
