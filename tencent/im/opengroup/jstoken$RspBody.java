package tencent.im.opengroup;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class jstoken$RspBody extends MessageMicro<jstoken$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBBytesField bytes_err_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> rpt_bytes_apilist = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBUInt32Field uint32_frequency = PBField.initUInt32(0);
    public final PBUInt32Field uint32_token_time_out = PBField.initUInt32(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40}, new String[]{"uint32_result", "bytes_err_info", "rpt_bytes_apilist", "uint32_frequency", "uint32_token_time_out"}, new Object[]{0, byteStringMicro, byteStringMicro, 0, 0}, jstoken$RspBody.class);
    }
}
