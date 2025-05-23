package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x27$FriendRemark extends MessageMicro<SubMsgType0x27$FriendRemark> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"uint32_type", "uint64_fuin", "bytes_rmk_name", "uint64_group_code"}, new Object[]{0, 0L, ByteStringMicro.EMPTY, 0L}, SubMsgType0x27$FriendRemark.class);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_fuin = PBField.initUInt64(0);
    public final PBBytesField bytes_rmk_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
}
