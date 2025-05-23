package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* loaded from: classes29.dex */
public final class QZIntimateProfileReader$GetCommonISpaceReq extends MessageMicro<QZIntimateProfileReader$GetCommonISpaceReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{QCircleAlphaUserReporter.KEY_USER}, new Object[]{null}, QZIntimateProfileReader$GetCommonISpaceReq.class);
    public final PBRepeatMessageField<QZoneBaseMeta$StUser> user = PBField.initRepeatMessage(QZoneBaseMeta$StUser.class);
}
