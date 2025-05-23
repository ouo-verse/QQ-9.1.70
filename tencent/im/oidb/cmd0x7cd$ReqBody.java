package tencent.im.oidb;

import appoint.define.appoint_define$AppointID;
import appoint.define.appoint_define$LBSInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7cd$ReqBody extends MessageMicro<cmd0x7cd$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48, 800}, new String[]{"uint32_stamp", "uint32_start", "uint32_want", "msg_lbs_info", "rpt_msg_appoint_ids", "uint32_appoint_operation", "uint64_request_uin"}, new Object[]{0, 0, 0, null, null, 0, 0L}, cmd0x7cd$ReqBody.class);
    public final PBUInt32Field uint32_stamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_start = PBField.initUInt32(0);
    public final PBUInt32Field uint32_want = PBField.initUInt32(0);
    public appoint_define$LBSInfo msg_lbs_info = new appoint_define$LBSInfo();
    public final PBRepeatMessageField<appoint_define$AppointID> rpt_msg_appoint_ids = PBField.initRepeatMessage(appoint_define$AppointID.class);
    public final PBUInt32Field uint32_appoint_operation = PBField.initUInt32(0);
    public final PBUInt64Field uint64_request_uin = PBField.initUInt64(0);
}
