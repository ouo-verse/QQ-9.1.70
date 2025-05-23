package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleCounter$CountInfoRsp extends MessageMicro<QQCircleCounter$CountInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42}, new String[]{"extInfo", "rptRedPoint", "retCode", "retMsg", "jumpSchema"}, new Object[]{null, null, 0, "", ""}, QQCircleCounter$CountInfoRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<QQCircleCounter$RedPointInfo> rptRedPoint = PBField.initRepeatMessage(QQCircleCounter$RedPointInfo.class);
    public final PBUInt32Field retCode = PBField.initUInt32(0);
    public final PBStringField retMsg = PBField.initString("");
    public final PBStringField jumpSchema = PBField.initString("");
}
