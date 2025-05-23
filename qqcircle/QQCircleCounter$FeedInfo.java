package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.QCircleLpReportDc010001;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleCounter$FeedInfo extends MessageMicro<QQCircleCounter$FeedInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"feedID", "feedOwner", "feedData", "feedMask"}, new Object[]{"", "", null, 0}, QQCircleCounter$FeedInfo.class);
    public final PBStringField feedID = PBField.initString("");
    public final PBStringField feedOwner = PBField.initString("");
    public QQCircleCounter$FcSingleFeedInfo feedData = new MessageMicro<QQCircleCounter$FcSingleFeedInfo>() { // from class: qqcircle.QQCircleCounter$FcSingleFeedInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 58, 66, 72, 90, 96, 106, 112, 120, 128}, new String[]{QCircleLpReportDc010001.KEY_SUBTYPE, "feedKey", "feedUserID", "feedType", "feedTime", "feedMask", "summary", "feedPublishUid", "feedTimeUsec", "orgRecomSingleFeed", "illegalfeedflag", "ext", "feedSyncTime", "feedRightFlag", "categoryTypeID"}, new Object[]{0, "", "", 0, 0, 0, "", "", 0, "", 0, null, 0, 0, 0}, QQCircleCounter$FcSingleFeedInfo.class);
        public final PBInt32Field subType = PBField.initInt32(0);
        public final PBStringField feedKey = PBField.initString("");
        public final PBStringField feedUserID = PBField.initString("");
        public final PBInt32Field feedType = PBField.initInt32(0);
        public final PBUInt32Field feedTime = PBField.initUInt32(0);
        public final PBUInt32Field feedMask = PBField.initUInt32(0);
        public final PBStringField summary = PBField.initString("");
        public final PBStringField feedPublishUid = PBField.initString("");
        public final PBUInt32Field feedTimeUsec = PBField.initUInt32(0);
        public final PBStringField orgRecomSingleFeed = PBField.initString("");
        public final PBUInt32Field illegalfeedflag = PBField.initUInt32(0);
        public final PBRepeatMessageField<QQCircleCounter$ExtInfo> ext = PBField.initRepeatMessage(QQCircleCounter$ExtInfo.class);
        public final PBUInt32Field feedSyncTime = PBField.initUInt32(0);
        public final PBUInt32Field feedRightFlag = PBField.initUInt32(0);
        public final PBInt32Field categoryTypeID = PBField.initInt32(0);
    };
    public final PBUInt32Field feedMask = PBField.initUInt32(0);
}
