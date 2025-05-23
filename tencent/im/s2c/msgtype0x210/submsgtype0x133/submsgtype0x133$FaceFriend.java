package tencent.im.s2c.msgtype0x210.submsgtype0x133;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x133$FaceFriend extends MessageMicro<submsgtype0x133$FaceFriend> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint64_friend", "bytes_name", "uint32_type"}, new Object[]{0L, ByteStringMicro.EMPTY, 0}, submsgtype0x133$FaceFriend.class);
    public final PBUInt64Field uint64_friend = PBField.initUInt64(0);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
}
