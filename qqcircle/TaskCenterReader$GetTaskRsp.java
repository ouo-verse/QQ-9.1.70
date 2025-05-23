package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TaskCenterReader$GetTaskRsp extends MessageMicro<TaskCenterReader$GetTaskRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"extInfo", "myFuel", "taskRecords"}, new Object[]{null, 0, null}, TaskCenterReader$GetTaskRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBUInt32Field myFuel = PBField.initUInt32(0);
    public final PBRepeatMessageField<TaskCenterReader$TaskRecord> taskRecords = PBField.initRepeatMessage(TaskCenterReader$TaskRecord.class);
}
