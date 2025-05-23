package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleReader$FuelListRsp extends MessageMicro<QQCircleReader$FuelListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"extInfo", "fuelRecords", "isFinish", "ext"}, new Object[]{null, null, 0, ""}, QQCircleReader$FuelListRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<QQCircleReader$FuelListRecord> fuelRecords = PBField.initRepeatMessage(QQCircleReader$FuelListRecord.class);
    public final PBInt32Field isFinish = PBField.initInt32(0);
    public final PBStringField ext = PBField.initString("");
}
