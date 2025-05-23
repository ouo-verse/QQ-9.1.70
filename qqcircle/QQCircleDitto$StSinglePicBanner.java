package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import feedcloud.FeedCloudMeta$StImage;
import tianshu.QQCircleTianShu$AdItem;

/* loaded from: classes29.dex */
public final class QQCircleDitto$StSinglePicBanner extends MessageMicro<QQCircleDitto$StSinglePicBanner> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42}, new String[]{"image", "actionType", "actionUrl", "buttons", "tianshuAdItem"}, new Object[]{null, 1, "", null, null}, QQCircleDitto$StSinglePicBanner.class);
    public FeedCloudMeta$StImage image = new FeedCloudMeta$StImage();
    public final PBEnumField actionType = PBField.initEnum(1);
    public final PBStringField actionUrl = PBField.initString("");
    public final PBRepeatMessageField<QQCircleDitto$StNegativeFbButton> buttons = PBField.initRepeatMessage(QQCircleDitto$StNegativeFbButton.class);
    public QQCircleTianShu$AdItem tianshuAdItem = new QQCircleTianShu$AdItem();
}
