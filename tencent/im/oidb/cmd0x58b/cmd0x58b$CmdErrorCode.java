package tencent.im.oidb.cmd0x58b;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x58b$CmdErrorCode extends MessageMicro<cmd0x58b$CmdErrorCode> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_code", "bytes_err_msg"}, new Object[]{0, ByteStringMicro.EMPTY}, cmd0x58b$CmdErrorCode.class);
    public final PBUInt32Field uint32_code = PBField.initUInt32(0);
    public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
