package tencent.im.s2c.msgtype0x210.submsgtype0xb1;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0xb1$MsgBody extends MessageMicro<submsgtype0xb1$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint32_notify_type", "invite_info", "univite_info", "deal_info"}, new Object[]{0, null, null, null}, submsgtype0xb1$MsgBody.class);
    public final PBUInt32Field uint32_notify_type = PBField.initUInt32(0);
    public submsgtype0xb1$InviteInfo invite_info = new MessageMicro<submsgtype0xb1$InviteInfo>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xb1.submsgtype0xb1$InviteInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uint64_uin", "uint64_group_code", "uint32_expire_time", "str_id"}, new Object[]{0L, 0L, 0, ""}, submsgtype0xb1$InviteInfo.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBUInt32Field uint32_expire_time = PBField.initUInt32(0);
        public final PBStringField str_id = PBField.initString("");
    };
    public submsgtype0xb1$UninviteInfo univite_info = new MessageMicro<submsgtype0xb1$UninviteInfo>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xb1.submsgtype0xb1$UninviteInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint64_uin", "uint64_group_code", "str_id"}, new Object[]{0L, 0L, ""}, submsgtype0xb1$UninviteInfo.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBStringField str_id = PBField.initString("");
    };
    public submsgtype0xb1$DealInviteInfo deal_info = new MessageMicro<submsgtype0xb1$DealInviteInfo>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xb1.submsgtype0xb1$DealInviteInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"uint64_uin", "uint64_group_code", "str_id", "uint32_deal_result"}, new Object[]{0L, 0L, "", 0}, submsgtype0xb1$DealInviteInfo.class);
        public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
        public final PBStringField str_id = PBField.initString("");
        public final PBUInt32Field uint32_deal_result = PBField.initUInt32(0);
    };
}
