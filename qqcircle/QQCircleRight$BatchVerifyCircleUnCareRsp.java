package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleRight$BatchVerifyCircleUnCareRsp extends MessageMicro<QQCircleRight$BatchVerifyCircleUnCareRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "uncareInfos"}, new Object[]{null, null}, QQCircleRight$BatchVerifyCircleUnCareRsp.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBRepeatMessageField<QQCircleRight$UncareInfo> uncareInfos = PBField.initRepeatMessage(QQCircleRight$UncareInfo.class);
}
