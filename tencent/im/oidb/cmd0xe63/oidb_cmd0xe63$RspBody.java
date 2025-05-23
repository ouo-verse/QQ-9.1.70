package tencent.im.oidb.cmd0xe63;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xe63$RspBody extends MessageMicro<oidb_cmd0xe63$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"bool_online_status_visible_to_all_frd", "rpt_uint64_uin_can_see_my_online_status", "rpt_uint64_uin_online_status_visible_to_me", "rpt_uint32_smart_status"}, new Object[]{Boolean.FALSE, 0L, 0L, 0}, oidb_cmd0xe63$RspBody.class);
    public final PBBoolField bool_online_status_visible_to_all_frd = PBField.initBool(false);
    public final PBRepeatField<Integer> rpt_uint32_smart_status;
    public final PBRepeatField<Long> rpt_uint64_uin_can_see_my_online_status;
    public final PBRepeatField<Long> rpt_uint64_uin_online_status_visible_to_me;

    public oidb_cmd0xe63$RspBody() {
        PBUInt64Field pBUInt64Field = PBUInt64Field.__repeatHelper__;
        this.rpt_uint64_uin_can_see_my_online_status = PBField.initRepeat(pBUInt64Field);
        this.rpt_uint64_uin_online_status_visible_to_me = PBField.initRepeat(pBUInt64Field);
        this.rpt_uint32_smart_status = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    }
}
