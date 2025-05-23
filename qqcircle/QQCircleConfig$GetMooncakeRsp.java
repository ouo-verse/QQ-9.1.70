package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleConfig$GetMooncakeRsp extends MessageMicro<QQCircleConfig$GetMooncakeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48}, new String[]{"allowLongVideo", "videoLength", "nextTimeInterval", "needClientReportSuccessRateCmd", "featureMask", "tempConversionUin"}, new Object[]{0, 0, 0, "", 0L, 0L}, QQCircleConfig$GetMooncakeRsp.class);
    public final PBInt32Field allowLongVideo = PBField.initInt32(0);
    public final PBInt32Field videoLength = PBField.initInt32(0);
    public final PBInt32Field nextTimeInterval = PBField.initInt32(0);
    public final PBRepeatField<String> needClientReportSuccessRateCmd = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBInt64Field featureMask = PBField.initInt64(0);
    public final PBRepeatField<Long> tempConversionUin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
