package tencent.im.oidb.cmd0x962;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x962$ClientInfo extends MessageMicro<oidb_0x962$ClientInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_client_type", "bytes_version"}, new Object[]{0, ByteStringMicro.EMPTY}, oidb_0x962$ClientInfo.class);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
}
