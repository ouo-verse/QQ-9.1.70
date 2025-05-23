package tencent.im.oidb;

import appoint.define.appoint_define$AppointID;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7db$ReqBody extends MessageMicro<cmd0x7db$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34}, new String[]{"msg_appoint_id", "uint32_appoint_action", "uint32_overwrite", "rpt_msg_appoint_ids"}, new Object[]{null, 0, 0, null}, cmd0x7db$ReqBody.class);
    public appoint_define$AppointID msg_appoint_id = new appoint_define$AppointID();
    public final PBUInt32Field uint32_appoint_action = PBField.initUInt32(0);
    public final PBUInt32Field uint32_overwrite = PBField.initUInt32(0);
    public final PBRepeatMessageField<appoint_define$AppointID> rpt_msg_appoint_ids = PBField.initRepeatMessage(appoint_define$AppointID.class);
}
