package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x6cd$RedpointInfo extends MessageMicro<cmd0x6cd$RedpointInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 90, 98, 104, 114}, new String[]{"uint32_taskid", "uint64_cur_seq", "uint64_pull_seq", "uint64_read_seq", "uint32_pull_times", "uint32_last_pull_time", "int32_remained_time", "uint32_last_recv_time", "uint64_from_id", "enum_redpoint_type", "msg_redpoint_extra_info", "str_config_version", "uint32_do_activity", "rpt_msg_unread_msg"}, new Object[]{0, 0L, 0L, 0L, 0, 0, 0, 0, 0L, 1, null, "", 0, null}, cmd0x6cd$RedpointInfo.class);
    public final PBUInt32Field uint32_taskid = PBField.initUInt32(0);
    public final PBUInt64Field uint64_cur_seq = PBField.initUInt64(0);
    public final PBUInt64Field uint64_pull_seq = PBField.initUInt64(0);
    public final PBUInt64Field uint64_read_seq = PBField.initUInt64(0);
    public final PBUInt32Field uint32_pull_times = PBField.initUInt32(0);
    public final PBUInt32Field uint32_last_pull_time = PBField.initUInt32(0);
    public final PBInt32Field int32_remained_time = PBField.initInt32(0);
    public final PBUInt32Field uint32_last_recv_time = PBField.initUInt32(0);
    public final PBUInt64Field uint64_from_id = PBField.initUInt64(0);
    public final PBEnumField enum_redpoint_type = PBField.initEnum(1);
    public cmd0x6cd$RepointExtraInfo msg_redpoint_extra_info = new cmd0x6cd$RepointExtraInfo();
    public final PBStringField str_config_version = PBField.initString("");
    public final PBUInt32Field uint32_do_activity = PBField.initUInt32(0);
    public final PBRepeatMessageField<cmd0x6cd$MessageRec> rpt_msg_unread_msg = PBField.initRepeatMessage(cmd0x6cd$MessageRec.class);
}
