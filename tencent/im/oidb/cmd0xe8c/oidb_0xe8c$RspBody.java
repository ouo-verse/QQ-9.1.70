package tencent.im.oidb.cmd0xe8c;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xe8c$RspBody extends MessageMicro<oidb_0xe8c$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint64_friend_uin", "uint32_flag", "bytes_reserver_buffer"}, new Object[]{0L, 0, ByteStringMicro.EMPTY}, oidb_0xe8c$RspBody.class);
    public final PBUInt64Field uint64_friend_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_flag = PBField.initUInt32(0);
    public final PBBytesField bytes_reserver_buffer = PBField.initBytes(ByteStringMicro.EMPTY);
}
