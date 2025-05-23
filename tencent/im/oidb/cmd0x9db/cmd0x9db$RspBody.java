package tencent.im.oidb.cmd0x9db;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x9db$RspBody extends MessageMicro<cmd0x9db$RspBody> {
    public static final int INT32_RESULT_FIELD_NUMBER = 1;
    public static final int RPT_UINT64_UIN_FIELD_NUMBER = 4;
    public static final int STR_ERRORMESSAGE_FIELD_NUMBER = 3;
    public static final int UINT32_SEQUENCE_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"int32_result", "uint32_sequence", "str_errormessage", "rpt_uint64_uin"}, new Object[]{0, 0, "", 0L}, cmd0x9db$RspBody.class);
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBUInt32Field uint32_sequence = PBField.initUInt32(0);
    public final PBStringField str_errormessage = PBField.initString("");
    public final PBRepeatField<Long> rpt_uint64_uin = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
