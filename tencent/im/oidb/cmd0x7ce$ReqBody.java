package tencent.im.oidb;

import appoint.define.appoint_define$AppointID;
import appoint.define.appoint_define$LBSInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x7ce$ReqBody extends MessageMicro<cmd0x7ce$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 50, 56, 64, 800}, new String[]{"rpt_appoint_ids", "uint32_join_start", "uint32_join_want", "uint32_view_start", "uint32_view_want", "msg_lbs_info", "rpt_uint64_uins", "uint32_view_comment_count", "uint64_request_uin"}, new Object[]{null, 0, 0, 0, 0, null, 0L, 0, 0L}, cmd0x7ce$ReqBody.class);
    public final PBRepeatMessageField<appoint_define$AppointID> rpt_appoint_ids = PBField.initRepeatMessage(appoint_define$AppointID.class);
    public final PBUInt32Field uint32_join_start = PBField.initUInt32(0);
    public final PBUInt32Field uint32_join_want = PBField.initUInt32(0);
    public final PBUInt32Field uint32_view_start = PBField.initUInt32(0);
    public final PBUInt32Field uint32_view_want = PBField.initUInt32(0);
    public appoint_define$LBSInfo msg_lbs_info = new appoint_define$LBSInfo();
    public final PBRepeatField<Long> rpt_uint64_uins = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt32Field uint32_view_comment_count = PBField.initUInt32(0);
    public final PBUInt64Field uint64_request_uin = PBField.initUInt64(0);
}
