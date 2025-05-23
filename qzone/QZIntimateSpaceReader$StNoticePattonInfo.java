package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QZIntimateSpaceReader$StNoticePattonInfo extends MessageMicro<QZIntimateSpaceReader$StNoticePattonInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"patton_type", "plain_txt", "lefttxt_right_pic"}, new Object[]{0, null, null}, QZIntimateSpaceReader$StNoticePattonInfo.class);
    public final PBUInt32Field patton_type = PBField.initUInt32(0);
    public QZIntimateSpaceReader$StPlainTxtInfo plain_txt = new QZIntimateSpaceReader$StPlainTxtInfo();
    public QZIntimateSpaceReader$StLeftTxtRightPicInfo lefttxt_right_pic = new QZIntimateSpaceReader$StLeftTxtRightPicInfo();
}
