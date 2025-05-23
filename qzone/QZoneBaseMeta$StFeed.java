package qzone;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QZoneBaseMeta$StFeed extends MessageMicro<QZoneBaseMeta$StFeed> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122}, new String[]{"cell_common", "cell_user_info", "cell_title", "cell_summary", "cell_media", "cell_lbs", "cell_comment", "cell_like", "cell_bottom_recomm", "cell_space_info", "cell_visitor", "cell_qun_info", "rpt_bottom_recomm", "cell_remark", "cell_origin"}, new Object[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, QZoneBaseMeta$StFeed.class);
    public QZoneBaseMeta$StFeedCellCommon cell_common = new QZoneBaseMeta$StFeedCellCommon();
    public QZoneBaseMeta$StFeedCellUserInfo cell_user_info = new QZoneBaseMeta$StFeedCellUserInfo();
    public QZoneBaseMeta$StFeedCellTitle cell_title = new QZoneBaseMeta$StFeedCellTitle();
    public QZoneBaseMeta$StFeedCellSummary cell_summary = new QZoneBaseMeta$StFeedCellSummary();
    public QZoneBaseMeta$StFeedCellMedia cell_media = new QZoneBaseMeta$StFeedCellMedia();
    public QZoneBaseMeta$StFeedCellLBS cell_lbs = new QZoneBaseMeta$StFeedCellLBS();
    public QZoneBaseMeta$StFeedCellComment cell_comment = new QZoneBaseMeta$StFeedCellComment();
    public QZoneBaseMeta$StFeedCellLike cell_like = new QZoneBaseMeta$StFeedCellLike();
    public QZoneBaseMeta$StCellBottomRecomm cell_bottom_recomm = new QZoneBaseMeta$StCellBottomRecomm();
    public QZoneBaseMeta$StFeedCellSpaceInfo cell_space_info = new QZoneBaseMeta$StFeedCellSpaceInfo();
    public QZoneBaseMeta$StFeedCellVisitor cell_visitor = new MessageMicro<QZoneBaseMeta$StFeedCellVisitor>() { // from class: qzone.QZoneBaseMeta$StFeedCellVisitor
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{QCircleSchemeAttr.Detail.VIEW_NUM, "visitor_num", "visitors"}, new Object[]{0, 0, null}, QZoneBaseMeta$StFeedCellVisitor.class);
        public final PBInt32Field view_num = PBField.initInt32(0);
        public final PBInt32Field visitor_num = PBField.initInt32(0);
        public final PBRepeatMessageField<QZoneBaseMeta$StUser> visitors = PBField.initRepeatMessage(QZoneBaseMeta$StUser.class);
    };
    public QZoneBaseMeta$StFeedCellQunInfo cell_qun_info = new MessageMicro<QZoneBaseMeta$StFeedCellQunInfo>() { // from class: qzone.QZoneBaseMeta$StFeedCellQunInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"qun_id"}, new Object[]{""}, QZoneBaseMeta$StFeedCellQunInfo.class);
        public final PBStringField qun_id = PBField.initString("");
    };
    public final PBRepeatMessageField<QZoneBaseMeta$StCellBottomRecomm> rpt_bottom_recomm = PBField.initRepeatMessage(QZoneBaseMeta$StCellBottomRecomm.class);
    public QZoneBaseMeta$StCellRemark cell_remark = new MessageMicro<QZoneBaseMeta$StCellRemark>() { // from class: qzone.QZoneBaseMeta$StCellRemark
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"type", "title", "icon_token", "action_url"}, new Object[]{0, "", "", ""}, QZoneBaseMeta$StCellRemark.class);
        public final PBEnumField type = PBField.initEnum(0);
        public final PBStringField title = PBField.initString("");
        public final PBStringField icon_token = PBField.initString("");
        public final PBStringField action_url = PBField.initString("");
    };
    public QZoneBaseMeta$StCellOrigin cell_origin = new MessageMicro<QZoneBaseMeta$StCellOrigin>() { // from class: qzone.QZoneBaseMeta$StCellOrigin
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"cell_common", "cell_user_info", "cell_title", "cell_summary", "cell_media"}, new Object[]{null, null, null, null, null}, QZoneBaseMeta$StCellOrigin.class);
        public QZoneBaseMeta$StFeedCellCommon cell_common = new QZoneBaseMeta$StFeedCellCommon();
        public QZoneBaseMeta$StFeedCellUserInfo cell_user_info = new QZoneBaseMeta$StFeedCellUserInfo();
        public QZoneBaseMeta$StFeedCellTitle cell_title = new QZoneBaseMeta$StFeedCellTitle();
        public QZoneBaseMeta$StFeedCellSummary cell_summary = new QZoneBaseMeta$StFeedCellSummary();
        public QZoneBaseMeta$StFeedCellMedia cell_media = new QZoneBaseMeta$StFeedCellMedia();
    };
}
