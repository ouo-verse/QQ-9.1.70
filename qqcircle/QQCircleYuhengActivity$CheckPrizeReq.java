package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon$Entry;

/* loaded from: classes29.dex */
public final class QQCircleYuhengActivity$CheckPrizeReq extends MessageMicro<QQCircleYuhengActivity$CheckPrizeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 7994}, new String[]{"infos", "entries"}, new Object[]{null, null}, QQCircleYuhengActivity$CheckPrizeReq.class);
    public final PBRepeatMessageField<QQCircleYuhengActivity$YuhengInfo> infos = PBField.initRepeatMessage(QQCircleYuhengActivity$YuhengInfo.class);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> entries = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
}
