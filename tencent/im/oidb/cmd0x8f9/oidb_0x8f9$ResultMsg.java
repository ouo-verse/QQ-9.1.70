package tencent.im.oidb.cmd0x8f9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x8f9$ResultMsg extends MessageMicro<oidb_0x8f9$ResultMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_result", "bytes_err_msg"}, new Object[]{0, ByteStringMicro.EMPTY}, oidb_0x8f9$ResultMsg.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
}
