package tencent.im.oidb.submsgtype0x136;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Submsgtype0x136$MsgBody extends MessageMicro<Submsgtype0x136$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_msg_type", "uint64_group_id", "uint64_notify_timestamp"}, new Object[]{0, 0L, 0L}, Submsgtype0x136$MsgBody.class);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_id = PBField.initUInt64(0);
    public final PBUInt64Field uint64_notify_timestamp = PBField.initUInt64(0);
}
