package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StQQSubscriptionPageData extends MessageMicro<QQCircleFeedBase$StQQSubscriptionPageData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"title", "viewMoreJumpUrl", "subscription_feed_count"}, new Object[]{"", "", 0}, QQCircleFeedBase$StQQSubscriptionPageData.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField viewMoreJumpUrl = PBField.initString("");
    public final PBUInt32Field subscription_feed_count = PBField.initUInt32(0);
}
