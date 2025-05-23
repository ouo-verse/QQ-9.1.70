package tencent.im.s2c.msgtype0x210.submsgtype0x44;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x44$GroupSyncMsg extends MessageMicro<submsgtype0x44$GroupSyncMsg> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_auth_key;
    public final PBBytesField bytes_msg_buf;
    public final PBUInt32Field uint32_cur_max_mem_count;
    public final PBUInt32Field uint32_cur_mem_count;
    public final PBUInt32Field uint32_ext_admin_num;
    public final PBUInt32Field uint32_inviter_role;
    public final PBUInt32Field uint32_msg_status;
    public final PBUInt32Field uint32_next_max_mem_count;
    public final PBUInt32Field uint32_processflag;
    public final PBUInt32Field uint32_req_src_id;
    public final PBUInt32Field uint32_req_src_sub_id;
    public final PBUInt64Field uint64_action_time;
    public final PBUInt64Field uint64_action_uin;
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_msg_seq = PBField.initUInt64(0);
    public final PBUInt64Field uint64_grp_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_ga_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_opt_uin1 = PBField.initUInt64(0);
    public final PBUInt64Field uint64_opt_uin2 = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 66, 72, 80, 88, 96, 104, 112, 120, 128, 136, 144, 152}, new String[]{"uint32_msg_type", "uint64_msg_seq", "uint64_grp_code", "uint64_ga_code", "uint64_opt_uin1", "uint64_opt_uin2", "bytes_msg_buf", "bytes_auth_key", "uint32_msg_status", "uint64_action_uin", "uint64_action_time", "uint32_cur_max_mem_count", "uint32_next_max_mem_count", "uint32_cur_mem_count", "uint32_req_src_id", "uint32_req_src_sub_id", "uint32_inviter_role", "uint32_ext_admin_num", "uint32_processflag"}, new Object[]{0, 0L, 0L, 0L, 0L, 0L, byteStringMicro, byteStringMicro, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0, 0}, submsgtype0x44$GroupSyncMsg.class);
    }

    public submsgtype0x44$GroupSyncMsg() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_msg_buf = PBField.initBytes(byteStringMicro);
        this.bytes_auth_key = PBField.initBytes(byteStringMicro);
        this.uint32_msg_status = PBField.initUInt32(0);
        this.uint64_action_uin = PBField.initUInt64(0L);
        this.uint64_action_time = PBField.initUInt64(0L);
        this.uint32_cur_max_mem_count = PBField.initUInt32(0);
        this.uint32_next_max_mem_count = PBField.initUInt32(0);
        this.uint32_cur_mem_count = PBField.initUInt32(0);
        this.uint32_req_src_id = PBField.initUInt32(0);
        this.uint32_req_src_sub_id = PBField.initUInt32(0);
        this.uint32_inviter_role = PBField.initUInt32(0);
        this.uint32_ext_admin_num = PBField.initUInt32(0);
        this.uint32_processflag = PBField.initUInt32(0);
    }
}
