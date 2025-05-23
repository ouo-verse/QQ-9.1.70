package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class servtype$SchedulerMsg extends MessageMicro<servtype$SchedulerMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"creator_head_url", "wording", "expire_time_ms"}, new Object[]{ByteStringMicro.EMPTY, "", 0L}, servtype$SchedulerMsg.class);
    public final PBBytesField creator_head_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField wording = PBField.initString("");
    public final PBUInt64Field expire_time_ms = PBField.initUInt64(0);
}
