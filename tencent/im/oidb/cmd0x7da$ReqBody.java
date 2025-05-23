package tencent.im.oidb;

import appoint.define.appoint_define$AppointID;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7da$ReqBody extends MessageMicro<cmd0x7da$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"rpt_msg_appoint_ids", "uint32_appoint_operation", "uint32_operation_reason", "uint32_overwrite"}, new Object[]{null, 0, 0, 0}, cmd0x7da$ReqBody.class);
    public final PBRepeatMessageField<appoint_define$AppointID> rpt_msg_appoint_ids = PBField.initRepeatMessage(appoint_define$AppointID.class);
    public final PBUInt32Field uint32_appoint_operation = PBField.initUInt32(0);
    public final PBUInt32Field uint32_operation_reason = PBField.initUInt32(0);
    public final PBUInt32Field uint32_overwrite = PBField.initUInt32(0);
}
