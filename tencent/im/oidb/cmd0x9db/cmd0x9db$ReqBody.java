package tencent.im.oidb.cmd0x9db;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x9db$ReqBody extends MessageMicro<cmd0x9db$ReqBody> {
    public static final int RPT_UINT64_ID_FIELD_NUMBER = 2;
    public static final int UINT32_SEQUENCE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_sequence", "rpt_uint64_id"}, new Object[]{0, 0L}, cmd0x9db$ReqBody.class);
    public final PBUInt32Field uint32_sequence = PBField.initUInt32(0);
    public final PBRepeatField<Long> rpt_uint64_id = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
