package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xbfe$RspBody extends MessageMicro<oidb_0xbfe$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_receive_status", "bytes_jump_url", "uint32_flag"}, new Object[]{0, ByteStringMicro.EMPTY, 0}, oidb_0xbfe$RspBody.class);
    public final PBUInt32Field uint32_receive_status = PBField.initUInt32(0);
    public final PBBytesField bytes_jump_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
}
