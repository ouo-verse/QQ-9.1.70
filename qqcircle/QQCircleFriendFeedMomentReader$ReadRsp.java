package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFriendFeedMomentReader$ReadRsp extends MessageMicro<QQCircleFriendFeedMomentReader$ReadRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 80, 90}, new String[]{"feeds", "is_end", "cookie"}, new Object[]{null, Boolean.FALSE, ""}, QQCircleFriendFeedMomentReader$ReadRsp.class);
    public final PBRepeatMessageField<QQCircleFriendFeedMomentReader$SimpleFeed> feeds = PBField.initRepeatMessage(QQCircleFriendFeedMomentReader$SimpleFeed.class);
    public final PBBoolField is_end = PBField.initBool(false);
    public final PBStringField cookie = PBField.initString("");
}
