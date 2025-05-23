package tencent.im.group_pro_proto.msgpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class servtype$MsgSeq extends MessageMicro<servtype$MsgSeq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_seq", "uint64_time"}, new Object[]{0L, 0L}, servtype$MsgSeq.class);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0);
    public final PBUInt64Field uint64_time = PBField.initUInt64(0);
}
