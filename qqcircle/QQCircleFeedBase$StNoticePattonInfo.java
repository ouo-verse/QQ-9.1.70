package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta$StImage;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StNoticePattonInfo extends MessageMicro<QQCircleFeedBase$StNoticePattonInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"pattonType", "userCertificationLabel", "plainTxt", "leftTxtRightPic", "leftTxtRightButton", "topPicBottomTxt"}, new Object[]{0, null, null, null, null, null}, QQCircleFeedBase$StNoticePattonInfo.class);
    public final PBUInt32Field pattonType = PBField.initUInt32(0);
    public QQCircleFeedBase$StUserCertificationLabel userCertificationLabel = new MessageMicro<QQCircleFeedBase$StUserCertificationLabel>() { // from class: qqcircle.QQCircleFeedBase$StUserCertificationLabel
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"needShow", "picInfo", "text"}, new Object[]{Boolean.FALSE, null, ""}, QQCircleFeedBase$StUserCertificationLabel.class);
        public final PBBoolField needShow = PBField.initBool(false);
        public FeedCloudMeta$StImage picInfo = new FeedCloudMeta$StImage();
        public final PBStringField text = PBField.initString("");
    };
    public QQCircleFeedBase$StPlainTxtInfo plainTxt = new QQCircleFeedBase$StPlainTxtInfo();
    public QQCircleFeedBase$StLeftTxtRightPicInfo leftTxtRightPic = new QQCircleFeedBase$StLeftTxtRightPicInfo();
    public QQCircleFeedBase$StLeftTxtRightButtonInfo leftTxtRightButton = new QQCircleFeedBase$StLeftTxtRightButtonInfo();
    public QQCircleFeedBase$StTopPicBottomTxtInfo topPicBottomTxt = new QQCircleFeedBase$StTopPicBottomTxtInfo();
}
