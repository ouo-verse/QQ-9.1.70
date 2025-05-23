package tencent.im.oidb.cmd0xa80;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xa80$RspGroupInfo extends MessageMicro<oidb_cmd0xa80$RspGroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint64_group_code", "uint32_result", "bytes_error_msg"}, new Object[]{0L, 0, ByteStringMicro.EMPTY}, oidb_cmd0xa80$RspGroupInfo.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
