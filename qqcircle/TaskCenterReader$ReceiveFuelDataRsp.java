package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TaskCenterReader$ReceiveFuelDataRsp extends MessageMicro<TaskCenterReader$ReceiveFuelDataRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"extInfo", "totalReceiveFuel"}, new Object[]{null, 0L}, TaskCenterReader$ReceiveFuelDataRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBUInt64Field totalReceiveFuel = PBField.initUInt64(0);
}
