package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import cooperation.qqcircle.report.QCircleLpReportDc05507;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceReader$StLeftTxtRightPicInfo extends MessageMicro<QZIntimateSpaceReader$StLeftTxtRightPicInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"txt_info", QCircleLpReportDc05507.KEY_PIC_INFO}, new Object[]{null, null}, QZIntimateSpaceReader$StLeftTxtRightPicInfo.class);
    public final PBRepeatMessageField<QZoneBaseMeta$StRichMsg> txt_info = PBField.initRepeatMessage(QZoneBaseMeta$StRichMsg.class);
    public QZoneBaseMeta$StImage pic_info = new QZoneBaseMeta$StImage();
}
