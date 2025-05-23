package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class QQCircleFeedBase$StKuoliePasterTransInfo extends MessageMicro<QQCircleFeedBase$StKuoliePasterTransInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42}, new String[]{"feed_id", "feed_author_id", "request_uid", "time", "trace_id"}, new Object[]{"", "", "", 0L, ""}, QQCircleFeedBase$StKuoliePasterTransInfo.class);
    public final PBStringField feed_id = PBField.initString("");
    public final PBStringField feed_author_id = PBField.initString("");
    public final PBStringField request_uid = PBField.initString("");
    public final PBUInt64Field time = PBField.initUInt64(0);
    public final PBStringField trace_id = PBField.initString("");
}
