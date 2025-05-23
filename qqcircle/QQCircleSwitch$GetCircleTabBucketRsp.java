package qqcircle;

import com.qq.e.comm.constants.TangramHippyConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleSwitch$GetCircleTabBucketRsp extends MessageMicro<QQCircleSwitch$GetCircleTabBucketRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"sws", "isNewRegUid", TangramHippyConstants.EXP_ID, "circleLayoutType"}, new Object[]{null, Boolean.FALSE, 0, 1}, QQCircleSwitch$GetCircleTabBucketRsp.class);
    public final PBRepeatMessageField<QQCircleSwitch$StSwitch> sws = PBField.initRepeatMessage(QQCircleSwitch$StSwitch.class);
    public final PBBoolField isNewRegUid = PBField.initBool(false);
    public final PBUInt32Field expId = PBField.initUInt32(0);
    public final PBEnumField circleLayoutType = PBField.initEnum(1);
}
