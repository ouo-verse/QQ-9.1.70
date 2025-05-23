package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta$StImage;

/* loaded from: classes29.dex */
public final class QQCircleDitto$StPicTextBanner extends MessageMicro<QQCircleDitto$StPicTextBanner> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 50, 58, 64, 74}, new String[]{"banner_id", "title", "content", "backgroundImage", "actionType", "actionUrl", "buttons", "exposeTimeMs", "icon"}, new Object[]{"", "", "", null, 1, "", null, 0, null}, QQCircleDitto$StPicTextBanner.class);
    public final PBStringField banner_id = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField content = PBField.initString("");
    public FeedCloudMeta$StImage backgroundImage = new FeedCloudMeta$StImage();
    public final PBEnumField actionType = PBField.initEnum(1);
    public final PBStringField actionUrl = PBField.initString("");
    public final PBRepeatMessageField<QQCircleDitto$StButton> buttons = PBField.initRepeatMessage(QQCircleDitto$StButton.class);
    public final PBUInt32Field exposeTimeMs = PBField.initUInt32(0);
    public FeedCloudMeta$StImage icon = new FeedCloudMeta$StImage();
}
