package tencent.im.s2c.msgtype0x210.submsgtype0x28;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x28$FollowList extends MessageMicro<SubMsgType0x28$FollowList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 1080}, new String[]{"uint64_puin", "uint64_uin", "uint32_type", "uint32_seqno", "uint32_disable_cancel_chat"}, new Object[]{0L, 0L, 0, 0, 0}, SubMsgType0x28$FollowList.class);
    public final PBUInt64Field uint64_puin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_seqno = PBField.initUInt32(0);
    public final PBUInt32Field uint32_disable_cancel_chat = PBField.initUInt32(0);
}
