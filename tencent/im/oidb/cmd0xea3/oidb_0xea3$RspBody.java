package tencent.im.oidb.cmd0xea3;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xea3$RspBody extends MessageMicro<oidb_0xea3$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"result", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "back_group_msg", "return_unchange_seq"}, new Object[]{0, "", null, 0L}, oidb_0xea3$RspBody.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBRepeatMessageField<oidb_0xea3$BackMsg> back_group_msg = PBField.initRepeatMessage(oidb_0xea3$BackMsg.class);
    public final PBRepeatField<Long> return_unchange_seq = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
