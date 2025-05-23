package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* loaded from: classes29.dex */
public final class QQCircleCounter$PreRecommendCountInfo extends MessageMicro<QQCircleCounter$PreRecommendCountInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"redPointMsgType", QCircleScheme.AttrDetail.FEED_INFO, "feedList"}, new Object[]{0, null, null}, QQCircleCounter$PreRecommendCountInfo.class);
    public final PBInt32Field redPointMsgType = PBField.initInt32(0);
    public QQCircleCounter$RecommendRedPointBackupFeedInfo feedInfo = new MessageMicro<QQCircleCounter$RecommendRedPointBackupFeedInfo>() { // from class: qqcircle.QQCircleCounter$RecommendRedPointBackupFeedInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"feedId", "createTs", "feedAuthor"}, new Object[]{"", 0L, ""}, QQCircleCounter$RecommendRedPointBackupFeedInfo.class);
        public final PBStringField feedId = PBField.initString("");
        public final PBInt64Field createTs = PBField.initInt64(0);
        public final PBStringField feedAuthor = PBField.initString("");
    };
    public final PBRepeatMessageField<QQCircleCounter$PreRecommendFeedInfo> feedList = PBField.initRepeatMessage(QQCircleCounter$PreRecommendFeedInfo.class);
}
