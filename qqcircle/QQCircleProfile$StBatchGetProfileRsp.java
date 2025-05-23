package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* loaded from: classes29.dex */
public final class QQCircleProfile$StBatchGetProfileRsp extends MessageMicro<QQCircleProfile$StBatchGetProfileRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "userInfos"}, new Object[]{null, null}, QQCircleProfile$StBatchGetProfileRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<QQCircleProfile$StUserInfo> userInfos = PBField.initRepeatMessage(QQCircleProfile$StUserInfo.class);
}
