package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleTimestamp$BatchGetTimestampField extends MessageMicro<QQCircleTimestamp$BatchGetTimestampField> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"uID", "toUID", "groupID", "timestamp"}, new Object[]{"", "", "", 0L}, QQCircleTimestamp$BatchGetTimestampField.class);
    public final PBStringField uID = PBField.initString("");
    public final PBStringField toUID = PBField.initString("");
    public final PBStringField groupID = PBField.initString("");
    public final PBInt64Field timestamp = PBField.initInt64(0);
}
