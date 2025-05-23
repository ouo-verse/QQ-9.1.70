package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudMeta$StUser;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleDitto$StItemContainer extends MessageMicro<QQCircleDitto$StItemContainer> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 58, 66, 74, 82}, new String[]{"title", "items", "urlInfo", QQWinkConstants.TAB_SUBTITLE, "containerType", "styleType", "busiInfo", "userList", "buttons", "toast"}, new Object[]{"", null, null, "", 0, 0, null, null, null, ""}, QQCircleDitto$StItemContainer.class);
    public final PBStringField title = PBField.initString("");
    public final PBRepeatMessageField<QQCircleDitto$StItemInfo> items = PBField.initRepeatMessage(QQCircleDitto$StItemInfo.class);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> urlInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public final PBStringField subTitle = PBField.initString("");
    public final PBUInt32Field containerType = PBField.initUInt32(0);
    public final PBEnumField styleType = PBField.initEnum(0);
    public final PBRepeatMessageField<FeedCloudCommon$Entry> busiInfo = PBField.initRepeatMessage(FeedCloudCommon$Entry.class);
    public final PBRepeatMessageField<FeedCloudMeta$StUser> userList = PBField.initRepeatMessage(FeedCloudMeta$StUser.class);
    public final PBRepeatMessageField<QQCircleDitto$StButton> buttons = PBField.initRepeatMessage(QQCircleDitto$StButton.class);
    public final PBStringField toast = PBField.initString("");
}
