package tencent.im.group_pro_proto.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class common$Event extends MessageMicro<common$Event> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"type", "version", "op_info"}, new Object[]{0L, 0L, null}, common$Event.class);
    public final PBUInt64Field type = PBField.initUInt64(0);
    public final PBUInt64Field version = PBField.initUInt64(0);
    public common$MsgOpInfo op_info = new common$MsgOpInfo();
}
