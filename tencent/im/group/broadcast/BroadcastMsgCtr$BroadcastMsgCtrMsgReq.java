package tencent.im.group.broadcast;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class BroadcastMsgCtr$BroadcastMsgCtrMsgReq extends MessageMicro<BroadcastMsgCtr$BroadcastMsgCtrMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ex2_tlv_trans2_buf;
    public final PBBytesField bytes_msg;
    public final PBEnumField enum_red_packet;
    public BroadcastMsgCtr$Ex2tlvGroupInfo group_info_tlv;
    public BroadcastMsgCtr$BroadcastMsgCtrInstInfo msg_from_inst_info;
    public final PBRepeatMessageField<BroadcastMsgCtr$BroadcastMsgCtrInstInfo> msg_roaming_dst_insts;
    public final PBUInt32Field uint32_feeds_topic_flag;
    public final PBUInt32Field uint32_flag_ex;
    public final PBUInt32Field uint32_flag_ex2;
    public final PBUInt32Field uint32_flag_ex3;
    public final PBUInt32Field uint32_flag_ex4;
    public final PBUInt32Field uint32_id_info;
    public final PBUInt32Field uint32_is_total_pkg;
    public final PBUInt32Field uint32_mem_level_name_seq;
    public final PBUInt32Field uint32_message_type;
    public final PBUInt32Field uint32_msg_seq;
    public final PBUInt32Field uint32_msg_sys_seq;
    public final PBUInt32Field uint32_msg_time;
    public final PBUInt32Field uint32_msg_type;
    public final PBUInt32Field uint32_spec_focus_flag;
    public final PBUInt32Field uint32_spec_hated_flag;
    public final PBUInt64Field uint64_group_code;
    public final PBUInt64Field uint64_group_uin;
    public final PBBoolField whether_anonymous_message;
    public final PBBoolField whether_store_message;
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
    public final PBRepeatMessageField<BroadcastMsgCtr$BroadcastMsgCtrMsgUnit> rpt_msg_broadcast_msg_unit = PBField.initRepeatMessage(BroadcastMsgCtr$BroadcastMsgCtrMsgUnit.class);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 50, 56, 64, 72, 80, 88, 96, 104, 112, 122, 138, 144, 152, 160, 168, 176, 184, 192, 202, 208, 216, 224}, new String[]{"uint64_from_uin", "rpt_msg_broadcast_msg_unit", "bytes_msg", "uint32_msg_type", "uint32_msg_seq", "msg_from_inst_info", "uint64_group_code", "uint64_group_uin", "uint32_spec_focus_flag", "uint32_msg_time", "whether_store_message", "uint32_msg_sys_seq", "whether_anonymous_message", "uint32_id_info", "group_info_tlv", "msg_roaming_dst_insts", "uint32_spec_hated_flag", "enum_red_packet", "uint32_feeds_topic_flag", "uint32_flag_ex2", "uint32_mem_level_name_seq", "uint32_flag_ex", "uint32_message_type", "bytes_ex2_tlv_trans2_buf", "uint32_flag_ex3", "uint32_flag_ex4", "uint32_is_total_pkg"}, new Object[]{0L, null, byteStringMicro, 0, 0, null, 0L, 0L, 0, 0, bool, 0, bool, 0, null, null, 0, 0, 0, 0, 0, 0, 0, byteStringMicro, 0, 0, 0}, BroadcastMsgCtr$BroadcastMsgCtrMsgReq.class);
    }

    public BroadcastMsgCtr$BroadcastMsgCtrMsgReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_msg = PBField.initBytes(byteStringMicro);
        this.uint32_msg_type = PBField.initUInt32(0);
        this.uint32_msg_seq = PBField.initUInt32(0);
        this.msg_from_inst_info = new BroadcastMsgCtr$BroadcastMsgCtrInstInfo();
        this.uint64_group_code = PBField.initUInt64(0L);
        this.uint64_group_uin = PBField.initUInt64(0L);
        this.uint32_spec_focus_flag = PBField.initUInt32(0);
        this.uint32_msg_time = PBField.initUInt32(0);
        this.whether_store_message = PBField.initBool(false);
        this.uint32_msg_sys_seq = PBField.initUInt32(0);
        this.whether_anonymous_message = PBField.initBool(false);
        this.uint32_id_info = PBField.initUInt32(0);
        this.group_info_tlv = new BroadcastMsgCtr$Ex2tlvGroupInfo();
        this.msg_roaming_dst_insts = PBField.initRepeatMessage(BroadcastMsgCtr$BroadcastMsgCtrInstInfo.class);
        this.uint32_spec_hated_flag = PBField.initUInt32(0);
        this.enum_red_packet = PBField.initEnum(0);
        this.uint32_feeds_topic_flag = PBField.initUInt32(0);
        this.uint32_flag_ex2 = PBField.initUInt32(0);
        this.uint32_mem_level_name_seq = PBField.initUInt32(0);
        this.uint32_flag_ex = PBField.initUInt32(0);
        this.uint32_message_type = PBField.initUInt32(0);
        this.bytes_ex2_tlv_trans2_buf = PBField.initBytes(byteStringMicro);
        this.uint32_flag_ex3 = PBField.initUInt32(0);
        this.uint32_flag_ex4 = PBField.initUInt32(0);
        this.uint32_is_total_pkg = PBField.initUInt32(0);
    }
}
