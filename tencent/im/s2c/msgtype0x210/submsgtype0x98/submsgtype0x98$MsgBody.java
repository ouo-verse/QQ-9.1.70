package tencent.im.s2c.msgtype0x210.submsgtype0x98;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x98$MsgBody extends MessageMicro<submsgtype0x98$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint64_uin", "uint32_sub_cmd", "msg_mod_block"}, new Object[]{0L, 0, null}, submsgtype0x98$MsgBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public submsgtype0x98$ModBlock msg_mod_block = new submsgtype0x98$ModBlock();
}
