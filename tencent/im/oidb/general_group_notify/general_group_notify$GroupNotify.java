package tencent.im.oidb.general_group_notify;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class general_group_notify$GroupNotify extends MessageMicro<general_group_notify$GroupNotify> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"opt_uint32_msg_type", "opt_st_alliance_notify", "opt_st_sec_front_info", "opt_st_special_flag"}, new Object[]{0, null, null, null}, general_group_notify$GroupNotify.class);
    public final PBUInt32Field opt_uint32_msg_type = PBField.initUInt32(0);
    public general_group_notify$GroupAllianceNotify opt_st_alliance_notify = new MessageMicro<general_group_notify$GroupAllianceNotify>() { // from class: tencent.im.oidb.general_group_notify.general_group_notify$GroupAllianceNotify
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_alliance_name;
        public final PBBytesField bytes_alliance_owner_name;
        public general_group_notify$ApplyAlliance st_apply_alliance;
        public final PBUInt32Field uint32_result;
        public final PBUInt64Field uint64_alliance_owner;
        public final PBUInt64Field uint64_leader_group_code;
        public final PBUInt32Field uint32_alliance_notify_type = PBField.initUInt32(0);
        public final PBUInt64Field uint64_alliance_id = PBField.initUInt64(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 48, 58, 64}, new String[]{"uint32_alliance_notify_type", "uint64_alliance_id", "bytes_alliance_name", "uint64_alliance_owner", "bytes_alliance_owner_name", "uint64_leader_group_code", "st_apply_alliance", "uint32_result"}, new Object[]{0, 0L, byteStringMicro, 0L, byteStringMicro, 0L, null, 0}, general_group_notify$GroupAllianceNotify.class);
        }

        /* JADX WARN: Type inference failed for: r1v3, types: [tencent.im.oidb.general_group_notify.general_group_notify$ApplyAlliance] */
        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_alliance_name = PBField.initBytes(byteStringMicro);
            this.uint64_alliance_owner = PBField.initUInt64(0L);
            this.bytes_alliance_owner_name = PBField.initBytes(byteStringMicro);
            this.uint64_leader_group_code = PBField.initUInt64(0L);
            this.st_apply_alliance = new MessageMicro<general_group_notify$ApplyAlliance>() { // from class: tencent.im.oidb.general_group_notify.general_group_notify$ApplyAlliance
                static final MessageMicro.FieldMap __fieldMap__;
                public final PBBytesField bytes_apply_group_name;
                public final PBBytesField bytes_apply_group_owner_name;
                public final PBBytesField bytes_source_group_name;
                public final PBUInt64Field uint64_apply_group_code = PBField.initUInt64(0);
                public final PBUInt64Field uint64_apply_group_owner_uin;
                public final PBUInt64Field uint64_source_group_uin;

                static {
                    ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                    __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 50}, new String[]{"uint64_apply_group_code", "bytes_apply_group_name", "uint64_apply_group_owner_uin", "bytes_apply_group_owner_name", "uint64_source_group_uin", "bytes_source_group_name"}, new Object[]{0L, byteStringMicro2, 0L, byteStringMicro2, 0L, byteStringMicro2}, general_group_notify$ApplyAlliance.class);
                }

                {
                    ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                    this.bytes_apply_group_name = PBField.initBytes(byteStringMicro2);
                    this.uint64_apply_group_owner_uin = PBField.initUInt64(0L);
                    this.bytes_apply_group_owner_name = PBField.initBytes(byteStringMicro2);
                    this.uint64_source_group_uin = PBField.initUInt64(0L);
                    this.bytes_source_group_name = PBField.initBytes(byteStringMicro2);
                }
            };
            this.uint32_result = PBField.initUInt32(0);
        }
    };
    public general_group_notify$InviteJoinGroupSecFront opt_st_sec_front_info = new MessageMicro<general_group_notify$InviteJoinGroupSecFront>() { // from class: tencent.im.oidb.general_group_notify.general_group_notify$InviteJoinGroupSecFront
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"opt_uint32_index"}, new Object[]{0}, general_group_notify$InviteJoinGroupSecFront.class);
        public final PBUInt32Field opt_uint32_index = PBField.initUInt32(0);
    };
    public general_group_notify$NotifySpecialFlag opt_st_special_flag = new MessageMicro<general_group_notify$NotifySpecialFlag>() { // from class: tencent.im.oidb.general_group_notify.general_group_notify$NotifySpecialFlag
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"opt_uint32_is_hrtx"}, new Object[]{0}, general_group_notify$NotifySpecialFlag.class);
        public final PBUInt32Field opt_uint32_is_hrtx = PBField.initUInt32(0);
    };
}
