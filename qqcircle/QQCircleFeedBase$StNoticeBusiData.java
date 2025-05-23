package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StImage;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StNoticeBusiData extends MessageMicro<QQCircleFeedBase$StNoticeBusiData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 58, 64}, new String[]{"urlInfo", "busiInfo", "pattonInfo", "messageBoxRedPointInfo", "userRelationLabel", "userTypeLabel", "thanked"}, new Object[]{null, null, null, null, null, null, Boolean.FALSE}, QQCircleFeedBase$StNoticeBusiData.class);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> urlInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> busiInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public QQCircleFeedBase$StNoticePattonInfo pattonInfo = new QQCircleFeedBase$StNoticePattonInfo();
    public QQCircleFeedBase$MessageBoxRedPointInfo messageBoxRedPointInfo = new QQCircleFeedBase$MessageBoxRedPointInfo();
    public QQCircleFeedBase$StUserRelationLabel userRelationLabel = new MessageMicro<QQCircleFeedBase$StUserRelationLabel>() { // from class: qqcircle.QQCircleFeedBase$StUserRelationLabel
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{18, 24, 34}, new String[]{"picInfo", "LabelType", "text"}, new Object[]{null, 1, ""}, QQCircleFeedBase$StUserRelationLabel.class);
        public FeedCloudMeta$StImage picInfo = new FeedCloudMeta$StImage();
        public final PBEnumField LabelType = PBField.initEnum(1);
        public final PBStringField text = PBField.initString("");
    };
    public QQCircleFeedBase$StUserTypeLabel userTypeLabel = new QQCircleFeedBase$StUserTypeLabel();
    public final PBBoolField thanked = PBField.initBool(false);
}
