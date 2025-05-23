package tencent.im.s2c.msgtype0x210.submsgtype0xab;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0xab$MsgBody extends MessageMicro<SubMsgType0xab$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"uint64_uin", "uint64_gc", "string_reward_id", "uint32_reward_status"}, new Object[]{0L, 0L, "", 0}, SubMsgType0xab$MsgBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_gc = PBField.initUInt64(0);
    public final PBStringField string_reward_id = PBField.initString("");
    public final PBUInt32Field uint32_reward_status = PBField.initUInt32(0);
}
