package tencent.im.msg.hummer.servtype;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class hummer_commelem$MsgElemInfo_servtype21 extends MessageMicro<hummer_commelem$MsgElemInfo_servtype21> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_confessor_nick;
    public final PBBytesField bytes_topic;
    public C2CConfessContext c2c_confess_ctx;
    public GroupConfessContext group_confess_ctx;
    public GroupConfessMsg group_confess_msg;
    public final PBUInt32Field uint32_confessor_sex;
    public final PBUInt32Field uint32_sysmsg_flag;
    public final PBUInt64Field uint64_confess_time;
    public final PBUInt32Field uint32_topic_id = PBField.initUInt32(0);
    public final PBUInt64Field uint64_confessor_uin = PBField.initUInt64(0);

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class C2CConfessContext extends MessageMicro<C2CConfessContext> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_confess;
        public final PBBytesField bytes_confessor_nick;
        public final PBUInt32Field uint32_bg_type;
        public final PBUInt32Field uint32_biz_type;
        public final PBUInt32Field uint32_confess_num;
        public final PBUInt32Field uint32_confess_to_sex;
        public final PBUInt32Field uint32_confessor_sex;
        public final PBUInt32Field uint32_topic_id;
        public final PBUInt64Field uint64_confess_time;
        public final PBUInt64Field uint64_confessor_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_confess_to_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_send_uin = PBField.initUInt64(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 48, 56, 64, 72, 80, 88, 96}, new String[]{"uint64_confessor_uin", "uint64_confess_to_uin", "uint64_send_uin", "bytes_confessor_nick", "bytes_confess", "uint32_bg_type", "uint32_topic_id", "uint64_confess_time", "uint32_confessor_sex", "uint32_biz_type", "uint32_confess_num", "uint32_confess_to_sex"}, new Object[]{0L, 0L, 0L, byteStringMicro, byteStringMicro, 0, 0, 0L, 0, 0, 0, 0}, C2CConfessContext.class);
        }

        public C2CConfessContext() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_confessor_nick = PBField.initBytes(byteStringMicro);
            this.bytes_confess = PBField.initBytes(byteStringMicro);
            this.uint32_bg_type = PBField.initUInt32(0);
            this.uint32_topic_id = PBField.initUInt32(0);
            this.uint64_confess_time = PBField.initUInt64(0L);
            this.uint32_confessor_sex = PBField.initUInt32(0);
            this.uint32_biz_type = PBField.initUInt32(0);
            this.uint32_confess_num = PBField.initUInt32(0);
            this.uint32_confess_to_sex = PBField.initUInt32(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class GroupConfessContext extends MessageMicro<GroupConfessContext> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_confess_to_nick;
        public final PBBytesField bytes_confessor_nick;
        public final PBBytesField bytes_topic;
        public final PBUInt32Field uint32_confess_to_nick_type;
        public final PBUInt32Field uint32_topic_id;
        public final PBUInt64Field uint64_confess_time;
        public final PBUInt64Field uint64_confessor_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_confess_to_uin = PBField.initUInt64(0);
        public final PBUInt64Field uint64_send_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_confessor_sex = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 50, 56, 64, 72, 82}, new String[]{"uint64_confessor_uin", "uint64_confess_to_uin", "uint64_send_uin", "uint32_confessor_sex", "bytes_confess_to_nick", "bytes_topic", "uint32_topic_id", "uint64_confess_time", "uint32_confess_to_nick_type", "bytes_confessor_nick"}, new Object[]{0L, 0L, 0L, 0, byteStringMicro, byteStringMicro, 0, 0L, 0, byteStringMicro}, GroupConfessContext.class);
        }

        public GroupConfessContext() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_confess_to_nick = PBField.initBytes(byteStringMicro);
            this.bytes_topic = PBField.initBytes(byteStringMicro);
            this.uint32_topic_id = PBField.initUInt32(0);
            this.uint64_confess_time = PBField.initUInt64(0L);
            this.uint32_confess_to_nick_type = PBField.initUInt32(0);
            this.bytes_confessor_nick = PBField.initBytes(byteStringMicro);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class GroupConfessItem extends MessageMicro<GroupConfessItem> {
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_confess_to_nick;
        public final PBBytesField bytes_topic;
        public final PBUInt32Field uint32_confess_to_nick_type;
        public final PBUInt32Field uint32_topic_id = PBField.initUInt32(0);
        public final PBUInt64Field uint64_confess_to_uin = PBField.initUInt64(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 40}, new String[]{"uint32_topic_id", "uint64_confess_to_uin", "bytes_confess_to_nick", "bytes_topic", "uint32_confess_to_nick_type"}, new Object[]{0, 0L, byteStringMicro, byteStringMicro, 0}, GroupConfessItem.class);
        }

        public GroupConfessItem() {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_confess_to_nick = PBField.initBytes(byteStringMicro);
            this.bytes_topic = PBField.initBytes(byteStringMicro);
            this.uint32_confess_to_nick_type = PBField.initUInt32(0);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class GroupConfessMsg extends MessageMicro<GroupConfessMsg> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48}, new String[]{"uint64_confess_time", "uint64_confessor_uin", "uint32_confessor_sex", "uint32_sysmsg_flag", "confess_items", "uint32_total_topic_count"}, new Object[]{0L, 0L, 0, 0, null, 0}, GroupConfessMsg.class);
        public final PBUInt64Field uint64_confess_time = PBField.initUInt64(0);
        public final PBUInt64Field uint64_confessor_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_confessor_sex = PBField.initUInt32(0);
        public final PBUInt32Field uint32_sysmsg_flag = PBField.initUInt32(0);
        public final PBRepeatMessageField<GroupConfessItem> confess_items = PBField.initRepeatMessage(GroupConfessItem.class);
        public final PBUInt32Field uint32_total_topic_count = PBField.initUInt32(0);
    }

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 50, 58, 64, 74, 82}, new String[]{"uint32_topic_id", "uint64_confessor_uin", "bytes_confessor_nick", "uint32_confessor_sex", "uint32_sysmsg_flag", "c2c_confess_ctx", "bytes_topic", "uint64_confess_time", "group_confess_msg", "group_confess_ctx"}, new Object[]{0, 0L, byteStringMicro, 0, 0, null, byteStringMicro, 0L, null, null}, hummer_commelem$MsgElemInfo_servtype21.class);
    }

    public hummer_commelem$MsgElemInfo_servtype21() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_confessor_nick = PBField.initBytes(byteStringMicro);
        this.uint32_confessor_sex = PBField.initUInt32(0);
        this.uint32_sysmsg_flag = PBField.initUInt32(0);
        this.bytes_topic = PBField.initBytes(byteStringMicro);
        this.uint64_confess_time = PBField.initUInt64(0L);
        this.c2c_confess_ctx = new C2CConfessContext();
        this.group_confess_msg = new GroupConfessMsg();
        this.group_confess_ctx = new GroupConfessContext();
    }
}
