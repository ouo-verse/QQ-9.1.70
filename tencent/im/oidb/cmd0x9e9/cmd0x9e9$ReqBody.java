package tencent.im.oidb.cmd0x9e9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x9e9$ReqBody extends MessageMicro<cmd0x9e9$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"msg_user", "uint32_start", "uint32_size"}, new Object[]{null, 0, 0}, cmd0x9e9$ReqBody.class);
    public cmd0x9e9$User msg_user = new MessageMicro<cmd0x9e9$User>() { // from class: tencent.im.oidb.cmd0x9e9.cmd0x9e9$User
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_client", "bytes_version", "uint32_portal"}, new Object[]{0, ByteStringMicro.EMPTY, 0}, cmd0x9e9$User.class);
        public final PBUInt32Field uint32_client = PBField.initUInt32(0);
        public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_portal = PBField.initUInt32(0);
    };
    public final PBUInt32Field uint32_start = PBField.initUInt32(0);
    public final PBUInt32Field uint32_size = PBField.initUInt32(0);
}
