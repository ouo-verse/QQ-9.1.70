package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleFeedBase$ViewedFeed extends MessageMicro<QQCircleFeedBase$ViewedFeed> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32}, new String[]{"feed_uid", "feed_id", "feed_create_time", "view_time"}, new Object[]{"", "", 0L, 0L}, QQCircleFeedBase$ViewedFeed.class);
    public final PBStringField feed_uid = PBField.initString("");
    public final PBStringField feed_id = PBField.initString("");
    public final PBUInt64Field feed_create_time = PBField.initUInt64(0);
    public final PBUInt64Field view_time = PBField.initUInt64(0);
}
