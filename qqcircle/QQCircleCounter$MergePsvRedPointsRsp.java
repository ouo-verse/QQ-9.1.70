package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon$StCommonExt;

/* loaded from: classes29.dex */
public final class QQCircleCounter$MergePsvRedPointsRsp extends MessageMicro<QQCircleCounter$MergePsvRedPointsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"redPoints", "extInfo", "hasQzonePsv"}, new Object[]{null, null, Boolean.FALSE}, QQCircleCounter$MergePsvRedPointsRsp.class);
    public final PBRepeatMessageField<QQCircleCounterMsg$MergePsvRedPoint> redPoints = PBField.initRepeatMessage(QQCircleCounterMsg$MergePsvRedPoint.class);
    public FeedCloudCommon$StCommonExt extInfo = new FeedCloudCommon$StCommonExt();
    public final PBBoolField hasQzonePsv = PBField.initBool(false);
}
