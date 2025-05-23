package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xe62$ReqBody extends MessageMicro<cmd0xe62$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"set_type", "rpt_uint64_uin", "rpt_uint32_smart_status", "bool_clear_smart_status"}, new Object[]{0, 0L, 0, Boolean.FALSE}, cmd0xe62$ReqBody.class);
    public final PBUInt32Field set_type = PBField.initUInt32(0);
    public final PBRepeatField<Long> rpt_uint64_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBRepeatField<Integer> rpt_uint32_smart_status = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
    public final PBBoolField bool_clear_smart_status = PBField.initBool(false);
}
