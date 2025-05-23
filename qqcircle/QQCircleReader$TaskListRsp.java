package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleReader$TaskListRsp extends MessageMicro<QQCircleReader$TaskListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 42, 50}, new String[]{"extInfo", "myFuel", "taskRecords", "isFinish", "ext", "taskEntranceUrl"}, new Object[]{null, 0, null, 0, "", ""}, QQCircleReader$TaskListRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBUInt32Field myFuel = PBField.initUInt32(0);
    public final PBRepeatMessageField<QQCircleReader$TaskRecord> taskRecords = PBField.initRepeatMessage(QQCircleReader$TaskRecord.class);
    public final PBInt32Field isFinish = PBField.initInt32(0);
    public final PBStringField ext = PBField.initString("");
    public final PBStringField taskEntranceUrl = PBField.initString("");
}
