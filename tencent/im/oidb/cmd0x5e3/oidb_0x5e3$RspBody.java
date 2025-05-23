package tencent.im.oidb.cmd0x5e3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x5e3$RspBody extends MessageMicro<oidb_0x5e3$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{90, 98, 104, 112, 120, 128, 136, 170}, new String[]{"rpt_msg_get_qq_uin_rsps", "rpt_msg_get_qcall_uin_rsps", "rpt_uint64_unfilled_qq_uins", "rpt_uint64_unfilled_qcall_uins", "rpt_uint64_not_exist_qq_uins", "rpt_uint64_not_exist_qcall_uins", "uint64_timestamp", "rpt_msg_get_phone_rsps"}, new Object[]{null, null, 0L, 0L, 0L, 0L, 0L, null}, oidb_0x5e3$RspBody.class);
    public final PBRepeatMessageField<oidb_0x5e3$GetPhoneRsp> rpt_msg_get_phone_rsps;
    public final PBRepeatField<Long> rpt_uint64_not_exist_qcall_uins;
    public final PBRepeatField<Long> rpt_uint64_not_exist_qq_uins;
    public final PBRepeatField<Long> rpt_uint64_unfilled_qcall_uins;
    public final PBRepeatField<Long> rpt_uint64_unfilled_qq_uins;
    public final PBUInt64Field uint64_timestamp;
    public final PBRepeatMessageField<oidb_0x5e3$GetQQUinRsp> rpt_msg_get_qq_uin_rsps = PBField.initRepeatMessage(oidb_0x5e3$GetQQUinRsp.class);
    public final PBRepeatMessageField<oidb_0x5e3$GetQCallUinRsp> rpt_msg_get_qcall_uin_rsps = PBField.initRepeatMessage(oidb_0x5e3$GetQCallUinRsp.class);

    public oidb_0x5e3$RspBody() {
        PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
        this.rpt_uint64_unfilled_qq_uins = PBField.initRepeat(pBUInt64Field);
        this.rpt_uint64_unfilled_qcall_uins = PBField.initRepeat(pBUInt64Field);
        this.rpt_uint64_not_exist_qq_uins = PBField.initRepeat(pBUInt64Field);
        this.rpt_uint64_not_exist_qcall_uins = PBField.initRepeat(pBUInt64Field);
        this.uint64_timestamp = PBField.initUInt64(0L);
        this.rpt_msg_get_phone_rsps = PBField.initRepeatMessage(oidb_0x5e3$GetPhoneRsp.class);
    }
}
