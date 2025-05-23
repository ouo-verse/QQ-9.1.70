package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import feedcloud.FeedCloudMeta$StUser;

/* loaded from: classes29.dex */
public final class QQCircleRankinglist$GetPushWeekRankingRsp extends MessageMicro<QQCircleRankinglist$GetPushWeekRankingRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66}, new String[]{"IsHostReq", "LastWeekInfo", "ThisWeekInfo", "NoRankingText", "NoRankingBtnText", "NoRankingSubText", "NoRankingJumpURL", "popWindow"}, new Object[]{Boolean.FALSE, null, null, "", "", "", "", null}, QQCircleRankinglist$GetPushWeekRankingRsp.class);
    public final PBBoolField IsHostReq = PBField.initBool(false);
    public QQCircleRankinglist$PushRankInfo LastWeekInfo = new MessageMicro<QQCircleRankinglist$PushRankInfo>() { // from class: qqcircle.QQCircleRankinglist$PushRankInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBRepeatMessageField<QQCircleRankinglist$PushRankItem> items = PBField.initRepeatMessage(QQCircleRankinglist$PushRankItem.class);
        public QQCircleRankinglist$PushRankItem userItem = new MessageMicro<QQCircleRankinglist$PushRankItem>() { // from class: qqcircle.QQCircleRankinglist$PushRankItem
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 48, 58}, new String[]{QCircleAlphaUserReporter.KEY_USER, "RankNo", "rocketNum", "rankImg", "rocketImg", "thanked", "fansImg"}, new Object[]{null, 0, 0L, "", "", Boolean.FALSE, ""}, QQCircleRankinglist$PushRankItem.class);
            public FeedCloudMeta$StUser user = new FeedCloudMeta$StUser();
            public final PBInt32Field RankNo = PBField.initInt32(0);
            public final PBUInt64Field rocketNum = PBField.initUInt64(0);
            public final PBStringField rankImg = PBField.initString("");
            public final PBStringField rocketImg = PBField.initString("");
            public final PBBoolField thanked = PBField.initBool(false);
            public final PBStringField fansImg = PBField.initString("");
        };
        public final PBStringField title = PBField.initString("");
        public final PBUInt64Field userReceivedRocket = PBField.initUInt64(0);
        public final PBBoolField unchanged = PBField.initBool(false);
        public final PBBoolField allThanked = PBField.initBool(false);

        static {
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48}, new String[]{"items", "userItem", "title", "userReceivedRocket", "unchanged", "allThanked"}, new Object[]{null, null, "", 0L, bool, bool}, QQCircleRankinglist$PushRankInfo.class);
        }
    };
    public QQCircleRankinglist$PushRankInfo ThisWeekInfo = new MessageMicro<QQCircleRankinglist$PushRankInfo>() { // from class: qqcircle.QQCircleRankinglist$PushRankInfo
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBRepeatMessageField<QQCircleRankinglist$PushRankItem> items = PBField.initRepeatMessage(QQCircleRankinglist$PushRankItem.class);
        public QQCircleRankinglist$PushRankItem userItem = new MessageMicro<QQCircleRankinglist$PushRankItem>() { // from class: qqcircle.QQCircleRankinglist$PushRankItem
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 48, 58}, new String[]{QCircleAlphaUserReporter.KEY_USER, "RankNo", "rocketNum", "rankImg", "rocketImg", "thanked", "fansImg"}, new Object[]{null, 0, 0L, "", "", Boolean.FALSE, ""}, QQCircleRankinglist$PushRankItem.class);
            public FeedCloudMeta$StUser user = new FeedCloudMeta$StUser();
            public final PBInt32Field RankNo = PBField.initInt32(0);
            public final PBUInt64Field rocketNum = PBField.initUInt64(0);
            public final PBStringField rankImg = PBField.initString("");
            public final PBStringField rocketImg = PBField.initString("");
            public final PBBoolField thanked = PBField.initBool(false);
            public final PBStringField fansImg = PBField.initString("");
        };
        public final PBStringField title = PBField.initString("");
        public final PBUInt64Field userReceivedRocket = PBField.initUInt64(0);
        public final PBBoolField unchanged = PBField.initBool(false);
        public final PBBoolField allThanked = PBField.initBool(false);

        static {
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48}, new String[]{"items", "userItem", "title", "userReceivedRocket", "unchanged", "allThanked"}, new Object[]{null, null, "", 0L, bool, bool}, QQCircleRankinglist$PushRankInfo.class);
        }
    };
    public final PBStringField NoRankingText = PBField.initString("");
    public final PBStringField NoRankingBtnText = PBField.initString("");
    public final PBStringField NoRankingSubText = PBField.initString("");
    public final PBStringField NoRankingJumpURL = PBField.initString("");
    public QQCircleRankinglist$Notification popWindow = new MessageMicro<QQCircleRankinglist$Notification>() { // from class: qqcircle.QQCircleRankinglist$Notification
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"title", "text", "choose_text"}, new Object[]{"", "", ""}, QQCircleRankinglist$Notification.class);
        public final PBStringField title = PBField.initString("");
        public final PBStringField text = PBField.initString("");
        public final PBStringField choose_text = PBField.initString("");
    };
}
