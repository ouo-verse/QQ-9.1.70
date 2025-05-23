package tencent.im.oidb.cmd0x686;

import appoint.define.appoint_define$LBSInfo;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0x686$ReqBody extends MessageMicro<Oidb_0x686$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32}, new String[]{"msg_lbs_info", "uint32_last_config_seq", "uint32_last_config_time", "uint32_push_redpoint_id"}, new Object[]{null, 0, 0, 0}, Oidb_0x686$ReqBody.class);
    public appoint_define$LBSInfo msg_lbs_info = new appoint_define$LBSInfo();
    public final PBUInt32Field uint32_last_config_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_last_config_time = PBField.initUInt32(0);
    public final PBRepeatField<Integer> uint32_push_redpoint_id = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
