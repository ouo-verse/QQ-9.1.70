package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qqcircle.report.QCircleLpReportDc05502;

/* loaded from: classes29.dex */
public final class QZonePhotoDegrade$IsGrayUinRsp extends MessageMicro<QZonePhotoDegrade$IsGrayUinRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"is_gray_uin", QCircleLpReportDc05502.KEY_BEGIN_TIME}, new Object[]{Boolean.FALSE, 0L}, QZonePhotoDegrade$IsGrayUinRsp.class);
    public final PBBoolField is_gray_uin = PBField.initBool(false);
    public final PBUInt64Field begin_time = PBField.initUInt64(0);
}
