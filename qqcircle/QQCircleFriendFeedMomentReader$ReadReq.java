package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFriendFeedMomentReader$ReadReq extends MessageMicro<QQCircleFriendFeedMomentReader$ReadReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 82}, new String[]{"start_feed", "per_page", "cookie"}, new Object[]{null, 0, ""}, QQCircleFriendFeedMomentReader$ReadReq.class);
    public QQCircleFriendFeedMomentReader$SimpleFeed start_feed = new QQCircleFriendFeedMomentReader$SimpleFeed();
    public final PBUInt32Field per_page = PBField.initUInt32(0);
    public final PBStringField cookie = PBField.initString("");
}
