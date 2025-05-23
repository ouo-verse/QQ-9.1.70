package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import feedcloud.FeedCloudCommon$Entry;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleClientData$CommonReportTransInfo extends MessageMicro<QQCircleClientData$CommonReportTransInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"report_data"}, new Object[]{null}, QQCircleClientData$CommonReportTransInfo.class);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> report_data = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
}
