package tencent.im.s2c.msgtype0x210.submsgtype0x27;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x27$ModGroupName extends MessageMicro<SubMsgType0x27$ModGroupName> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_groupid", "bytes_groupname"}, new Object[]{0, ByteStringMicro.EMPTY}, SubMsgType0x27$ModGroupName.class);
    public final PBUInt32Field uint32_groupid = PBField.initUInt32(0);
    public final PBBytesField bytes_groupname = PBField.initBytes(ByteStringMicro.EMPTY);
}
