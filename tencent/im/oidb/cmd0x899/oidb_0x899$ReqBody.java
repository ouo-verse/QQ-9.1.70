package tencent.im.oidb.cmd0x899;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x899$ReqBody extends MessageMicro<oidb_0x899$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56, 64}, new String[]{"uint64_group_code", "uint64_start_uin", "uint32_identify_flag", "rpt_uint64_uin_list", "memberlist_opt", "uint32_member_num", "uint32_filter_method", "uint32_online_flag"}, new Object[]{0L, 0L, 0, 0L, null, 0, 0, 0}, oidb_0x899$ReqBody.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_start_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_identify_flag = PBField.initUInt32(0);
    public final PBRepeatField<Long> rpt_uint64_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
    public oidb_0x899$memberlist memberlist_opt = new MessageMicro<oidb_0x899$memberlist>() { // from class: tencent.im.oidb.cmd0x899.oidb_0x899$memberlist
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_rich_info;
        public final PBBytesField bytes_special_title;
        public final PBBytesField bytes_uin_key;
        public final PBUInt32Field uint32_active_day;
        public final PBUInt32Field uint32_privilege;
        public final PBUInt32Field uint32_special_title_expire_time;
        public final PBUInt64Field uint64_member_uin = PBField.initUInt64(0);
        public final PBUInt32Field uint32_uin_flag = PBField.initUInt32(0);
        public final PBUInt32Field uint32_uin_flagex = PBField.initUInt32(0);
        public final PBUInt32Field uint32_uin_mobile_flag = PBField.initUInt32(0);
        public final PBUInt32Field uint32_uin_arch_flag = PBField.initUInt32(0);
        public final PBUInt32Field uint32_join_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_old_msg_seq = PBField.initUInt32(0);
        public final PBUInt32Field uint32_new_msg_seq = PBField.initUInt32(0);
        public final PBUInt32Field uint32_last_speak_time = PBField.initUInt32(0);
        public final PBUInt32Field uint32_level = PBField.initUInt32(0);
        public final PBUInt32Field uint32_point = PBField.initUInt32(0);
        public final PBUInt32Field uint32_shutup_timestap = PBField.initUInt32(0);
        public final PBUInt32Field uint32_flagex2 = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 114, 120, 128, 138, 144, 154}, new String[]{"uint64_member_uin", "uint32_uin_flag", "uint32_uin_flagex", "uint32_uin_mobile_flag", "uint32_uin_arch_flag", "uint32_join_time", "uint32_old_msg_seq", "uint32_new_msg_seq", "uint32_last_speak_time", "uint32_level", "uint32_point", "uint32_shutup_timestap", "uint32_flagex2", "bytes_special_title", "uint32_special_title_expire_time", "uint32_active_day", "bytes_uin_key", "uint32_privilege", "bytes_rich_info"}, new Object[]{0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, byteStringMicro, 0, 0, byteStringMicro, 0, byteStringMicro}, oidb_0x899$memberlist.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_special_title = PBField.initBytes(byteStringMicro);
            this.uint32_special_title_expire_time = PBField.initUInt32(0);
            this.uint32_active_day = PBField.initUInt32(0);
            this.bytes_uin_key = PBField.initBytes(byteStringMicro);
            this.uint32_privilege = PBField.initUInt32(0);
            this.bytes_rich_info = PBField.initBytes(byteStringMicro);
        }
    };
    public final PBUInt32Field uint32_member_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_filter_method = PBField.initUInt32(0);
    public final PBUInt32Field uint32_online_flag = PBField.initUInt32(0);
}
