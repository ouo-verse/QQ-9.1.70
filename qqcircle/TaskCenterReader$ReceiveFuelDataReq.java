package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TaskCenterReader$ReceiveFuelDataReq extends MessageMicro<TaskCenterReader$ReceiveFuelDataReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"extInfo", "uid", "reqFrom"}, new Object[]{null, "", 0}, TaskCenterReader$ReceiveFuelDataReq.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBStringField uid = PBField.initString("");
    public final PBInt32Field reqFrom = PBField.initInt32(0);
}
