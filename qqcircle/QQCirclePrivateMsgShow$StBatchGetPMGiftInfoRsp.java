package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* loaded from: classes29.dex */
public final class QQCirclePrivateMsgShow$StBatchGetPMGiftInfoRsp extends MessageMicro<QQCirclePrivateMsgShow$StBatchGetPMGiftInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "userGiftInfos"}, new Object[]{null, null}, QQCirclePrivateMsgShow$StBatchGetPMGiftInfoRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<QQCirclePrivateMsgShow$UserPMGiftInfo> userGiftInfos = PBField.initRepeatMessage(QQCirclePrivateMsgShow$UserPMGiftInfo.class);
}
