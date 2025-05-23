package tencent.im.oidb.cmd0x508;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x508$RspBody extends MessageMicro<oidb_0x508$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"opt_uint32_result", "opt_bytes_errinfo", "rpt_uint64_appid_list", "opt_uint64_update_seq"}, new Object[]{0, ByteStringMicro.EMPTY, 0L, 0L}, oidb_0x508$RspBody.class);
    public final PBUInt32Field opt_uint32_result = PBField.initUInt32(0);
    public final PBBytesField opt_bytes_errinfo = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<Long> rpt_uint64_appid_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public final PBUInt64Field opt_uint64_update_seq = PBField.initUInt64(0);
}
