package tencent.im.oidb.cmd0xe71;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xe71$ReqBody extends MessageMicro<oidb_cmd0xe71$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"uint64_uin", "uint32_client_type", "bytes_version", "uint32_op_type"}, new Object[]{0L, 0, ByteStringMicro.EMPTY, 0}, oidb_cmd0xe71$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_op_type = PBField.initUInt32(0);
}
