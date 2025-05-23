package qqcircle;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qqcircle.report.QCircleWeakNetReporter;
import feedcloud.FeedCloudCommon$BytesEntry;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StBusiReportInfo extends MessageMicro<QQCircleFeedBase$StBusiReportInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50, 56}, new String[]{"tianji_report", "recom_report", "downTime", QCircleWeakNetReporter.KEY_TRACE_ID, "busiTranparent", "entryTraceID", "contentID"}, new Object[]{ByteStringMicro.EMPTY, null, 0L, "", null, "", 0L}, QQCircleFeedBase$StBusiReportInfo.class);
    public final PBBytesField tianji_report = PBField.initBytes(ByteStringMicro.EMPTY);
    public QQCircleFeedBase$StRecomReportInfo recom_report = new MessageMicro<QQCircleFeedBase$StRecomReportInfo>() { // from class: qqcircle.QQCircleFeedBase$StRecomReportInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"recomInfos"}, new Object[]{null}, QQCircleFeedBase$StRecomReportInfo.class);
        public final PBRepeatMessageField<QQCircleFeedBase$StSingleRecomReportInfo> recomInfos = PBField.initRepeatMessage(QQCircleFeedBase$StSingleRecomReportInfo.class);
    };
    public final PBInt64Field downTime = PBField.initInt64(0);
    public final PBStringField traceID = PBField.initString("");
    public final PBRepeatMessageField<FeedCloudCommon$BytesEntry> busiTranparent = PBField.initRepeatMessage(FeedCloudCommon$BytesEntry.class);
    public final PBStringField entryTraceID = PBField.initString("");
    public final PBUInt64Field contentID = PBField.initUInt64(0);
}
