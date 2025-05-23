package tencent.im.oidb.cmd0x858;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x858$MessageRecallReminder extends MessageMicro<oidb_0x858$MessageRecallReminder> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_nickname;
    public final PBBytesField bytes_userdef;
    public final PBBytesField str_reminder_content;
    public final PBUInt32Field uint32_group_type;
    public final PBUInt32Field uint32_op_type;
    public final PBRepeatMessageField<MessageMeta> uint32_recalled_msg_list;
    public final PBUInt64Field uint64_admin_uin;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class MessageMeta extends MessageMicro<MessageMeta> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56}, new String[]{"uint32_seq", "uint32_time", "uint32_msg_random", "uint32_msg_type", "uint32_msg_flag", "uint64_author_uin", "uint32_is_anony_msg"}, new Object[]{0, 0, 0, 0, 0, 0L, 0}, MessageMeta.class);
        public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
        public final PBUInt32Field uint32_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_msg_random = PBField.initUInt32(0);
        public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_msg_flag = PBField.initUInt32(0);
        public final PBUInt64Field uint64_author_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_is_anony_msg = PBField.initUInt32(0);
    }

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 48, 56, 64}, new String[]{"uint64_uin", "bytes_nickname", "uint32_recalled_msg_list", "str_reminder_content", "bytes_userdef", "uint32_group_type", "uint32_op_type", "uint64_admin_uin"}, new Object[]{0L, byteStringMicro, null, byteStringMicro, byteStringMicro, 0, 0, 0L}, oidb_0x858$MessageRecallReminder.class);
    }

    public oidb_0x858$MessageRecallReminder() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_nickname = PBField.initBytes(byteStringMicro);
        this.uint32_recalled_msg_list = PBField.initRepeatMessage(MessageMeta.class);
        this.str_reminder_content = PBField.initBytes(byteStringMicro);
        this.bytes_userdef = PBField.initBytes(byteStringMicro);
        this.uint32_group_type = PBField.initUInt32(0);
        this.uint32_op_type = PBField.initUInt32(0);
        this.uint64_admin_uin = PBField.initUInt64(0L);
    }
}
