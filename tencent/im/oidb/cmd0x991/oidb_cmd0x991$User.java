package tencent.im.oidb.cmd0x991;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x991$User extends MessageMicro<oidb_cmd0x991$User> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 48}, new String[]{"uint64_group", "uint32_client", "bytes_version", "uint32_portal", "msg_login_sig", "uint32_instance_id"}, new Object[]{0L, 0, ByteStringMicro.EMPTY, 0, null, 0}, oidb_cmd0x991$User.class);
    public final PBUInt64Field uint64_group = PBField.initUInt64(0);
    public final PBUInt32Field uint32_client = PBField.initUInt32(0);
    public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_portal = PBField.initUInt32(0);
    public oidb_cmd0x991$LoginSig msg_login_sig = new oidb_cmd0x991$LoginSig();
    public final PBUInt32Field uint32_instance_id = PBField.initUInt32(0);
}
