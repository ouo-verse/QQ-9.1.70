package qqcircle;

import com.tencent.biz.pubaccount.weishi.WSAutoShowCommentParams;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import feedcloud.FeedCloudCommon$BytesEntry;

/* loaded from: classes29.dex */
public final class QQCircleCounter$RedPointTransInfo extends MessageMicro<QQCircleCounter$RedPointTransInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"allPushTrans", "pymkRedTrans"}, new Object[]{null, null}, QQCircleCounter$RedPointTransInfo.class);
    public QQCircleCounter$AllPushTransInfo allPushTrans = new MessageMicro<QQCircleCounter$AllPushTransInfo>() { // from class: qqcircle.QQCircleCounter$AllPushTransInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 48, 56, 64, 74, 82, 88, 98, 104, 112, 122, 128}, new String[]{"feedId", "author", "createTs", QQBrowserActivity.KEY_MSG_TYPE, "taskTransfer", "pageType", "redType", "insertPageType", "guideInfo", "sealTransfer", "contentID", "recomInfo", "recomReasonTypeForClient", "recomReasonType", "psvInfo", "recomRedType"}, new Object[]{"", "", 0L, 0, "", 0, 0, 0, null, "", 0L, null, 0, 0, null, 0}, QQCircleCounter$AllPushTransInfo.class);
        public final PBStringField feedId = PBField.initString("");
        public final PBStringField author = PBField.initString("");
        public final PBInt64Field createTs = PBField.initInt64(0);
        public final PBInt32Field msgType = PBField.initInt32(0);
        public final PBStringField taskTransfer = PBField.initString("");
        public final PBInt32Field pageType = PBField.initInt32(0);
        public final PBEnumField redType = PBField.initEnum(0);
        public final PBInt32Field insertPageType = PBField.initInt32(0);
        public QQCircleCounter$GuideAttachInfo guideInfo = new MessageMicro<QQCircleCounter$GuideAttachInfo>() { // from class: qqcircle.QQCircleCounter$GuideAttachInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"woridng", "uids", "headWording", QZoneDTLoginReporter.SCHEMA}, new Object[]{"", "", "", ""}, QQCircleCounter$GuideAttachInfo.class);
            public final PBStringField woridng = PBField.initString("");
            public final PBRepeatField<String> uids = PBField.initRepeat(PBStringField.__repeatHelper__);
            public final PBStringField headWording = PBField.initString("");
            public final PBStringField schema = PBField.initString("");
        };
        public final PBStringField sealTransfer = PBField.initString("");
        public final PBInt64Field contentID = PBField.initInt64(0);
        public final PBRepeatMessageField<FeedCloudCommon$BytesEntry> recomInfo = PBField.initRepeatMessage(FeedCloudCommon$BytesEntry.class);
        public final PBInt32Field recomReasonTypeForClient = PBField.initInt32(0);
        public final PBInt32Field recomReasonType = PBField.initInt32(0);
        public QQCircleCounter$PsvAttatchInfo psvInfo = new MessageMicro<QQCircleCounter$PsvAttatchInfo>() { // from class: qqcircle.QQCircleCounter$PsvAttatchInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"uid", "feedType", WSAutoShowCommentParams.KEY_COMMENT_ID, WSAutoShowCommentParams.KEY_REPLY_ID}, new Object[]{"", 0, "", ""}, QQCircleCounter$PsvAttatchInfo.class);
            public final PBStringField uid = PBField.initString("");
            public final PBInt32Field feedType = PBField.initInt32(0);
            public final PBStringField commentId = PBField.initString("");
            public final PBStringField replyId = PBField.initString("");
        };
        public final PBInt32Field recomRedType = PBField.initInt32(0);
    };
    public QQCircleCounter$PymkRedTransfer pymkRedTrans = new MessageMicro<QQCircleCounter$PymkRedTransfer>() { // from class: qqcircle.QQCircleCounter$PymkRedTransfer
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{QQBrowserActivity.KEY_MSG_TYPE, "createTs"}, new Object[]{0, 0L}, QQCircleCounter$PymkRedTransfer.class);
        public final PBInt32Field msgType = PBField.initInt32(0);
        public final PBInt64Field createTs = PBField.initInt64(0);
    };
}
