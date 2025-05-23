package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;

/* loaded from: classes29.dex */
public final class QZIntimateProfileReader$GetISpaceListWithUinReq extends MessageMicro<QZIntimateProfileReader$GetISpaceListWithUinReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{QCircleAlphaUserReporter.KEY_USER, "skip_relation_verification"}, new Object[]{0L, Boolean.FALSE}, QZIntimateProfileReader$GetISpaceListWithUinReq.class);
    public final PBRepeatField<Long> user = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBBoolField skip_relation_verification = PBField.initBool(false);
}
