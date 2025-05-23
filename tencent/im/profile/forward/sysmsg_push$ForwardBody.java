package tencent.im.profile.forward;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class sysmsg_push$ForwardBody extends MessageMicro<sysmsg_push$ForwardBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 162}, new String[]{"uint32_notify_type", "uint32_op_type", "msg_appointment_not"}, new Object[]{0, 0, null}, sysmsg_push$ForwardBody.class);
    public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
    public sysmsg_push$AppointmentNot msg_appointment_not = new MessageMicro<sysmsg_push$AppointmentNot>() { // from class: tencent.im.profile.forward.sysmsg_push$AppointmentNot
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint64_from_uin", "uint32_notifytype", "bytes_tips_content"}, new Object[]{0L, 0, ByteStringMicro.EMPTY}, sysmsg_push$AppointmentNot.class);
        public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_notifytype = PBField.initUInt32(0);
        public final PBBytesField bytes_tips_content = PBField.initBytes(ByteStringMicro.EMPTY);
    };
}
