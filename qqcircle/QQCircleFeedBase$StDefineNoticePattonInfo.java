package qqcircle;

import com.tencent.mobileqq.data.MessageForQCircleFeed;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta$StImage;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StDefineNoticePattonInfo extends MessageMicro<QQCircleFeedBase$StDefineNoticePattonInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 48, 58, 66, 74, 82, 90}, new String[]{"pattonType", MessageForQCircleFeed.MSG_QCIRCLE_FEED_KEY_CONTENT_JUMP_URL, "picJumpUrl", "buttonName", "buttonJumpUrl", "contentShowCutOff", "pic", "forcePicJumpUrl", "versionContentJumpUrl", "versionPicJumpUrl", "versionButtonJumpUrl"}, new Object[]{0, "", "", "", "", Boolean.FALSE, null, "", "", "", ""}, QQCircleFeedBase$StDefineNoticePattonInfo.class);
    public final PBUInt32Field pattonType = PBField.initUInt32(0);
    public final PBStringField contentJumpUrl = PBField.initString("");
    public final PBStringField picJumpUrl = PBField.initString("");
    public final PBStringField buttonName = PBField.initString("");
    public final PBStringField buttonJumpUrl = PBField.initString("");
    public final PBBoolField contentShowCutOff = PBField.initBool(false);
    public FeedCloudMeta$StImage pic = new FeedCloudMeta$StImage();
    public final PBStringField forcePicJumpUrl = PBField.initString("");
    public final PBStringField versionContentJumpUrl = PBField.initString("");
    public final PBStringField versionPicJumpUrl = PBField.initString("");
    public final PBStringField versionButtonJumpUrl = PBField.initString("");
}
