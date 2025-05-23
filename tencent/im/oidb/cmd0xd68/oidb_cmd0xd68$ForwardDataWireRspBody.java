package tencent.im.oidb.cmd0xd68;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xd68$ForwardDataWireRspBody extends MessageMicro<oidb_cmd0xd68$ForwardDataWireRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"int32_ret_code", "str_ret_msg", "bytes_uuid", "uint64_total_space"}, new Object[]{0, "", ByteStringMicro.EMPTY, 0L}, oidb_cmd0xd68$ForwardDataWireRspBody.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBBytesField bytes_uuid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_total_space = PBField.initUInt64(0);
}
