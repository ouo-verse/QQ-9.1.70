package tencent.im.oidb.oidb_0x8c9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8c9$ReqBody extends MessageMicro<oidb_0x8c9$ReqBody> {
    public static final int OPT_BYTES_GROUP_SIG_FIELD_NUMBER = 4;
    public static final int OPT_UINT64_FROM_UIN_FIELD_NUMBER = 1;
    public static final int OPT_UINT64_GROUP_CODE_FIELD_NUMBER = 2;
    public static final int RPT_UINT64_APPID_FIELD_NUMBER = 3;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"opt_uint64_from_uin", "opt_uint64_group_code", "rpt_uint64_appid", "opt_bytes_group_sig"}, new Object[]{0L, 0L, 0L, ByteStringMicro.EMPTY}, oidb_0x8c9$ReqBody.class);
    public final PBUInt64Field opt_uint64_from_uin = PBField.initUInt64(0);
    public final PBUInt64Field opt_uint64_group_code = PBField.initUInt64(0);
    public final PBRepeatField<Long> rpt_uint64_appid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBBytesField opt_bytes_group_sig = PBField.initBytes(ByteStringMicro.EMPTY);
}
