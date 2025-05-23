package tencent.im.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class nt_msg_common$Event extends MessageMicro<nt_msg_common$Event> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"type", "version", "op_info"}, new Object[]{0L, 0L, null}, nt_msg_common$Event.class);
    public final PBUInt64Field type = PBField.initUInt64(0);
    public final PBUInt64Field version = PBField.initUInt64(0);
    public nt_msg_common$MsgOpInfo op_info = new MessageMicro<nt_msg_common$MsgOpInfo>() { // from class: tencent.im.common.nt_msg_common$MsgOpInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40}, new String[]{"operator_tinyid", "operator_role", "reason", "timestamp", "at_type"}, new Object[]{0L, 0L, 0L, 0L, 0L}, nt_msg_common$MsgOpInfo.class);
        public final PBUInt64Field operator_tinyid = PBField.initUInt64(0);
        public final PBUInt64Field operator_role = PBField.initUInt64(0);
        public final PBUInt64Field reason = PBField.initUInt64(0);
        public final PBUInt64Field timestamp = PBField.initUInt64(0);
        public final PBUInt64Field at_type = PBField.initUInt64(0);
    };
}
