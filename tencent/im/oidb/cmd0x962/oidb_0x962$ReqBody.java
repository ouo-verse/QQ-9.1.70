package tencent.im.oidb.cmd0x962;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x962$ReqBody extends MessageMicro<oidb_0x962$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48}, new String[]{"uint64_group_code", "bytes_id", "uint32_times", "msg_client_info", "uint32_product_id", "uint32_cmd"}, new Object[]{0L, ByteStringMicro.EMPTY, 0, null, 0, 0}, oidb_0x962$ReqBody.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBBytesField bytes_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_times = PBField.initUInt32(0);
    public oidb_0x962$ClientInfo msg_client_info = new oidb_0x962$ClientInfo();
    public final PBUInt32Field uint32_product_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cmd = PBField.initUInt32(0);
}
