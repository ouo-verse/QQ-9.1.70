package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class servtype$AppChannelMsg extends MessageMicro<servtype$AppChannelMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42}, new String[]{"summary", "msg", "expire_time_ms", "schema_type", QZoneDTLoginReporter.SCHEMA}, new Object[]{"", "", 0L, 0, ""}, servtype$AppChannelMsg.class);
    public final PBStringField summary = PBField.initString("");

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f435944msg = PBField.initString("");
    public final PBUInt64Field expire_time_ms = PBField.initUInt64(0);
    public final PBUInt32Field schema_type = PBField.initUInt32(0);
    public final PBStringField schema = PBField.initString("");
}
