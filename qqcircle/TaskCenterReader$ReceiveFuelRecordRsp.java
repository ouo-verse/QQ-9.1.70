package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TaskCenterReader$ReceiveFuelRecordRsp extends MessageMicro<TaskCenterReader$ReceiveFuelRecordRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "records"}, new Object[]{null, null}, TaskCenterReader$ReceiveFuelRecordRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<TaskCenterReader$ReceiveFuelRecord> records = PBField.initRepeatMessage(TaskCenterReader$ReceiveFuelRecord.class);
}
