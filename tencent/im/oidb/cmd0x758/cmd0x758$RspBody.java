package tencent.im.oidb.cmd0x758;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x758$RspBody extends MessageMicro<cmd0x758$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42}, new String[]{"uint64_group_code", "uint64_current_max_msgseq", "string_verify_url", "uint32_verify_type", "bytes_test"}, new Object[]{0L, 0L, "", 0, ByteStringMicro.EMPTY}, cmd0x758$RspBody.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_current_max_msgseq = PBField.initUInt64(0);
    public final PBStringField string_verify_url = PBField.initString("");
    public final PBUInt32Field uint32_verify_type = PBField.initUInt32(0);
    public final PBBytesField bytes_test = PBField.initBytes(ByteStringMicro.EMPTY);
}
