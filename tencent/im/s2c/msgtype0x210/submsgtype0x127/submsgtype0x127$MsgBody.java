package tencent.im.s2c.msgtype0x210.submsgtype0x127;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x127$MsgBody extends MessageMicro<submsgtype0x127$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48}, new String[]{"uint64_seq", "uint32_action_type", "uint64_friend_uin", "uint64_oper_uin", "bytes_gray_tips", "join_state"}, new Object[]{0L, 0, 0L, 0L, ByteStringMicro.EMPTY, 1}, submsgtype0x127$MsgBody.class);
    public final PBUInt64Field uint64_seq = PBField.initUInt64(0);
    public final PBUInt32Field uint32_action_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_friend_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_oper_uin = PBField.initUInt64(0);
    public final PBBytesField bytes_gray_tips = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBEnumField join_state = PBField.initEnum(1);
}
