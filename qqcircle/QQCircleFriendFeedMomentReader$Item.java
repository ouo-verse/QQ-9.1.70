package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFriendFeedMomentReader$Item extends MessageMicro<QQCircleFriendFeedMomentReader$Item> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 80, 88, 98}, new String[]{"uin", "nick", "portrait", "jump_url", "circle_type", "buis_type", "unread_feeds"}, new Object[]{0L, "", "", "", 0, 0, null}, QQCircleFriendFeedMomentReader$Item.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField nick = PBField.initString("");
    public final PBStringField portrait = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBUInt32Field circle_type = PBField.initUInt32(0);
    public final PBUInt32Field buis_type = PBField.initUInt32(0);
    public final PBRepeatMessageField<QQCircleFriendFeedMomentReader$SimpleFeed> unread_feeds = PBField.initRepeatMessage(QQCircleFriendFeedMomentReader$SimpleFeed.class);
}
