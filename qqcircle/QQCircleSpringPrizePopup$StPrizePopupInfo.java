package qqcircle;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import feedcloud.FeedCloudMeta$StShare;

/* loaded from: classes29.dex */
public final class QQCircleSpringPrizePopup$StPrizePopupInfo extends MessageMicro<QQCircleSpringPrizePopup$StPrizePopupInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 104}, new String[]{"popup_id", "reason", "text", "activity_info", "prize_info", "feed_info", "comment_info", "share_info", "prize_use_jump_url", "activity_link", WadlProxyConsts.KEY_MATERIAL, "prize_owner", "popup_type"}, new Object[]{"", "", "", null, null, null, null, null, "", "", null, null, 0}, QQCircleSpringPrizePopup$StPrizePopupInfo.class);
    public final PBStringField popup_id = PBField.initString("");
    public final PBStringField reason = PBField.initString("");
    public final PBStringField text = PBField.initString("");
    public QQCircleSpringPrizePopup$StActivityInfo activity_info = new QQCircleSpringPrizePopup$StActivityInfo();
    public final PBRepeatMessageField<QQCircleSpringPrizePopup$StPrizeInfo> prize_info = PBField.initRepeatMessage(QQCircleSpringPrizePopup$StPrizeInfo.class);
    public QQCircleSpringPrizePopup$StFeedInfo feed_info = new MessageMicro<QQCircleSpringPrizePopup$StFeedInfo>() { // from class: qqcircle.QQCircleSpringPrizePopup$StFeedInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"cover", "detail_page_scheme"}, new Object[]{"", ""}, QQCircleSpringPrizePopup$StFeedInfo.class);
        public final PBStringField cover = PBField.initString("");
        public final PBStringField detail_page_scheme = PBField.initString("");
    };
    public QQCircleSpringPrizePopup$StCommentInfo comment_info = new MessageMicro<QQCircleSpringPrizePopup$StCommentInfo>() { // from class: qqcircle.QQCircleSpringPrizePopup$StCommentInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"content", "pic_url"}, new Object[]{"", ""}, QQCircleSpringPrizePopup$StCommentInfo.class);
        public final PBStringField content = PBField.initString("");
        public final PBStringField pic_url = PBField.initString("");
    };
    public FeedCloudMeta$StShare share_info = new FeedCloudMeta$StShare();
    public final PBStringField prize_use_jump_url = PBField.initString("");
    public final PBStringField activity_link = PBField.initString("");
    public QQCircleSpringPrizePopup$SpringMaterial material = new QQCircleSpringPrizePopup$SpringMaterial();
    public QQCircleSpringPrizePopup$StUser prize_owner = new MessageMicro<QQCircleSpringPrizePopup$StUser>() { // from class: qqcircle.QQCircleSpringPrizePopup$StUser
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, "icon"}, new Object[]{"", ""}, QQCircleSpringPrizePopup$StUser.class);
        public final PBStringField nick_name = PBField.initString("");
        public final PBStringField icon = PBField.initString("");
    };
    public final PBInt32Field popup_type = PBField.initInt32(0);
}
