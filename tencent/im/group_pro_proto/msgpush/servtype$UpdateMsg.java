package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class servtype$UpdateMsg extends MessageMicro<servtype$UpdateMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64}, new String[]{"uint64_msg_seq", "bool_orig_msg_uncountable", "uint64_event_type", "uint64_event_version", "uint64_operator_tinyid", "uint64_operator_role", "uint64_reason", "uint64_timestamp"}, new Object[]{0L, Boolean.FALSE, 0L, 0L, 0L, 0L, 0L, 0L}, servtype$UpdateMsg.class);
    public final PBUInt64Field uint64_msg_seq = PBField.initUInt64(0);
    public final PBBoolField bool_orig_msg_uncountable = PBField.initBool(false);
    public final PBUInt64Field uint64_event_type = PBField.initUInt64(0);
    public final PBUInt64Field uint64_event_version = PBField.initUInt64(0);
    public final PBUInt64Field uint64_operator_tinyid = PBField.initUInt64(0);
    public final PBUInt64Field uint64_operator_role = PBField.initUInt64(0);
    public final PBUInt64Field uint64_reason = PBField.initUInt64(0);
    public final PBUInt64Field uint64_timestamp = PBField.initUInt64(0);
}
