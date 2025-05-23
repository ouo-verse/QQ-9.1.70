package tencent.im.oidb.cmd0x592;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.trunk.Qworkflow.Qworkflow$AppID;
import com.trunk.Qworkflow.Qworkflow$Timespan;
import com.trunk.Qworkflow.Qworkflow$Workflow;
import com.trunk.Qworkflow.Qworkflow$WorkflowBrief;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x592$ReqBody extends MessageMicro<oidb_0x592$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154}, new String[]{"msg_appid", "msg_add_schedule_req", "msg_get_once_schedule_list_req", "msg_get_schedule_by_id_req", "msg_get_repeated_schedule_list_req", "msg_update_schedule_content_req", "msg_delete_my_schedule_req", "msg_recall_schedule_req", "msg_share_schedule_req", "msg_change_my_recv_status_req", "msg_set_all_readed_time_req", "msg_modify_unread_cnt_req", "msg_set_remind_bell_switch_req", "msg_get_date_has_once_schedule_req", "msg_modify_repeated_schedule_req", "msg_recall_repeated_schedule_req", "msg_get_repeated_schedule_list_req_new", "msg_get_once_schedule_list_incrementally_req", "msg_accept_schedule_req"}, new Object[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, oidb_0x592$ReqBody.class);
    public Qworkflow$AppID msg_appid = new Qworkflow$AppID();
    public oidb_0x592$AddScheduleReq msg_add_schedule_req = new MessageMicro<oidb_0x592$AddScheduleReq>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$AddScheduleReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_schedule"}, new Object[]{null}, oidb_0x592$AddScheduleReq.class);
        public Qworkflow$Workflow msg_schedule = new Qworkflow$Workflow();
    };
    public oidb_0x592$GetOnceScheduleListReq msg_get_once_schedule_list_req = new MessageMicro<oidb_0x592$GetOnceScheduleListReq>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$GetOnceScheduleListReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 48}, new String[]{"uint32_get_direction", "uint64_start_time", "uint32_amount", "rpt_msg_workflow_list", "uint32_main_type", "uint64_end_time"}, new Object[]{0, 0L, 0, null, 0, 0L}, oidb_0x592$GetOnceScheduleListReq.class);
        public final PBUInt32Field uint32_get_direction = PBField.initUInt32(0);
        public final PBUInt64Field uint64_start_time = PBField.initUInt64(0);
        public final PBUInt32Field uint32_amount = PBField.initUInt32(0);
        public final PBRepeatMessageField<Qworkflow$WorkflowBrief> rpt_msg_workflow_list = PBField.initRepeatMessage(Qworkflow$WorkflowBrief.class);
        public final PBUInt32Field uint32_main_type = PBField.initUInt32(0);
        public final PBUInt64Field uint64_end_time = PBField.initUInt64(0);
    };
    public oidb_0x592$GetScheduleByIDReq msg_get_schedule_by_id_req = new MessageMicro<oidb_0x592$GetScheduleByIDReq>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$GetScheduleByIDReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_workflow_id", "msg_schedule_brief"}, new Object[]{ByteStringMicro.EMPTY, null}, oidb_0x592$GetScheduleByIDReq.class);
        public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public Qworkflow$WorkflowBrief msg_schedule_brief = new Qworkflow$WorkflowBrief();
    };
    public oidb_0x592$GetRepeatedScheduleListReq msg_get_repeated_schedule_list_req = new MessageMicro<oidb_0x592$GetRepeatedScheduleListReq>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$GetRepeatedScheduleListReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint64_lastest_modtime", "uint32_amount", "uint32_main_type", "uint32_get_way"}, new Object[]{0L, 0, 0, 0}, oidb_0x592$GetRepeatedScheduleListReq.class);
        public final PBUInt64Field uint64_lastest_modtime = PBField.initUInt64(0);
        public final PBUInt32Field uint32_amount = PBField.initUInt32(0);
        public final PBUInt32Field uint32_main_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_get_way = PBField.initUInt32(0);
    };
    public oidb_0x592$UpdateScheduleContentReq msg_update_schedule_content_req = new MessageMicro<oidb_0x592$UpdateScheduleContentReq>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$UpdateScheduleContentReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_schedule"}, new Object[]{null}, oidb_0x592$UpdateScheduleContentReq.class);
        public Qworkflow$Workflow msg_schedule = new Qworkflow$Workflow();
    };
    public oidb_0x592$DeleteMyScheduleReq msg_delete_my_schedule_req = new MessageMicro<oidb_0x592$DeleteMyScheduleReq>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$DeleteMyScheduleReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_workflow_id", "msg_delete_time"}, new Object[]{ByteStringMicro.EMPTY, null}, oidb_0x592$DeleteMyScheduleReq.class);
        public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public Qworkflow$Timespan msg_delete_time = new Qworkflow$Timespan();
    };
    public oidb_0x592$RecallScheduleReq msg_recall_schedule_req = new MessageMicro<oidb_0x592$RecallScheduleReq>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$RecallScheduleReq
        public static final int CLOSE = 0;
        public static final int OPEN = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"bytes_workflow_id", "enum_silent_switch", "msg_notify_source_id"}, new Object[]{ByteStringMicro.EMPTY, 0, null}, oidb_0x592$RecallScheduleReq.class);
        public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBEnumField enum_silent_switch = PBField.initEnum(0);
        public Qworkflow$AppID msg_notify_source_id = new Qworkflow$AppID();
    };
    public oidb_0x592$ShareScheduleReq msg_share_schedule_req = new MessageMicro<oidb_0x592$ShareScheduleReq>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$ShareScheduleReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"rpt_schedule_id_list", "rpt_receiver_list", "msg_receive_group", "rpt_msg_repeated_schedule"}, new Object[]{ByteStringMicro.EMPTY, null, null, null}, oidb_0x592$ShareScheduleReq.class);
        public final PBRepeatField<ByteStringMicro> rpt_schedule_id_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
        public final PBRepeatMessageField<oidb_0x592$ShareReceiver> rpt_receiver_list = PBField.initRepeatMessage(oidb_0x592$ShareReceiver.class);
        public Qworkflow$AppID msg_receive_group = new Qworkflow$AppID();
        public final PBRepeatMessageField<oidb_0x592$RepeatedScheduleShareInfo> rpt_msg_repeated_schedule = PBField.initRepeatMessage(oidb_0x592$RepeatedScheduleShareInfo.class);
    };
    public oidb_0x592$ChangeMyNotificationReceivingStatusReq msg_change_my_recv_status_req = new MessageMicro<oidb_0x592$ChangeMyNotificationReceivingStatusReq>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$ChangeMyNotificationReceivingStatusReq
        public static final int ADD_ME = 1;
        public static final int DELETE_ME = 2;
        public static final int OTHER_1 = 3;
        public static final int OTHER_2 = 4;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_workflow_id"}, new Object[]{ByteStringMicro.EMPTY}, oidb_0x592$ChangeMyNotificationReceivingStatusReq.class);
        public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public oidb_0x592$SetAllReadedTimeReq msg_set_all_readed_time_req = new MessageMicro<oidb_0x592$SetAllReadedTimeReq>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$SetAllReadedTimeReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_all_readed_time"}, new Object[]{0L}, oidb_0x592$SetAllReadedTimeReq.class);
        public final PBUInt64Field uint64_all_readed_time = PBField.initUInt64(0);
    };
    public oidb_0x592$ModifyUnreadCntReq msg_modify_unread_cnt_req = new MessageMicro<oidb_0x592$ModifyUnreadCntReq>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$ModifyUnreadCntReq
        public static final int CLEAR = 3;
        public static final int DECREASE = 2;
        public static final int INCREASE = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"enum_modify_type", "uint32_notice_var", "uint32_notice_version"}, new Object[]{1, 0, 0}, oidb_0x592$ModifyUnreadCntReq.class);
        public final PBEnumField enum_modify_type = PBField.initEnum(1);
        public final PBUInt32Field uint32_notice_var = PBField.initUInt32(0);
        public final PBUInt32Field uint32_notice_version = PBField.initUInt32(0);
    };
    public oidb_0x592$SetRemindBellSwitchReq msg_set_remind_bell_switch_req = new MessageMicro<oidb_0x592$SetRemindBellSwitchReq>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$SetRemindBellSwitchReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_remind_bell_switch", "bytes_workflow_id"}, new Object[]{0, ByteStringMicro.EMPTY}, oidb_0x592$SetRemindBellSwitchReq.class);
        public final PBUInt32Field uint32_remind_bell_switch = PBField.initUInt32(0);
        public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public oidb_0x592$GetDateHasOnceScheduleReq msg_get_date_has_once_schedule_req = new MessageMicro<oidb_0x592$GetDateHasOnceScheduleReq>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$GetDateHasOnceScheduleReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_req_start_time", "uint64_req_end_time", "uint32_main_type"}, new Object[]{0L, 0L, 0}, oidb_0x592$GetDateHasOnceScheduleReq.class);
        public final PBUInt64Field uint64_req_start_time = PBField.initUInt64(0);
        public final PBUInt64Field uint64_req_end_time = PBField.initUInt64(0);
        public final PBUInt32Field uint32_main_type = PBField.initUInt32(0);
    };
    public oidb_0x592$ModifyRepeatedScheduleReq msg_modify_repeated_schedule_req = new MessageMicro<oidb_0x592$ModifyRepeatedScheduleReq>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$ModifyRepeatedScheduleReq
        public static final int ALL_MODIFY = 1;
        public static final int PART_MODIFY = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{"msg_new_schedule", "enum_modify_type", "bytes_modify_schedule_id", "msg_modify_timespan"}, new Object[]{null, 1, ByteStringMicro.EMPTY, null}, oidb_0x592$ModifyRepeatedScheduleReq.class);
        public Qworkflow$Workflow msg_new_schedule = new Qworkflow$Workflow();
        public final PBEnumField enum_modify_type = PBField.initEnum(1);
        public final PBBytesField bytes_modify_schedule_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public Qworkflow$Timespan msg_modify_timespan = new Qworkflow$Timespan();
    };
    public oidb_0x592$RecallRepeatedScheduleReq msg_recall_repeated_schedule_req = new MessageMicro<oidb_0x592$RecallRepeatedScheduleReq>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$RecallRepeatedScheduleReq
        public static final int ALL_RECALL = 1;
        public static final int PART_RECALL = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"bytes_workflow_id", "msg_notify_source_id", "enum_recall_type", "uint64_recall_start_time", "uint64_recall_end_time"}, new Object[]{ByteStringMicro.EMPTY, null, 1, 0L, 0L}, oidb_0x592$RecallRepeatedScheduleReq.class);
        public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public Qworkflow$AppID msg_notify_source_id = new Qworkflow$AppID();
        public final PBEnumField enum_recall_type = PBField.initEnum(1);
        public final PBUInt64Field uint64_recall_start_time = PBField.initUInt64(0);
        public final PBUInt64Field uint64_recall_end_time = PBField.initUInt64(0);
    };
    public oidb_0x592$GetRepeatedScheduleListReq msg_get_repeated_schedule_list_req_new = new MessageMicro<oidb_0x592$GetRepeatedScheduleListReq>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$GetRepeatedScheduleListReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint64_lastest_modtime", "uint32_amount", "uint32_main_type", "uint32_get_way"}, new Object[]{0L, 0, 0, 0}, oidb_0x592$GetRepeatedScheduleListReq.class);
        public final PBUInt64Field uint64_lastest_modtime = PBField.initUInt64(0);
        public final PBUInt32Field uint32_amount = PBField.initUInt32(0);
        public final PBUInt32Field uint32_main_type = PBField.initUInt32(0);
        public final PBUInt32Field uint32_get_way = PBField.initUInt32(0);
    };
    public oidb_0x592$GetOnceScheduleListIncrementallyReq msg_get_once_schedule_list_incrementally_req = new MessageMicro<oidb_0x592$GetOnceScheduleListIncrementallyReq>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$GetOnceScheduleListIncrementallyReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint32_get_way", "uint64_lastest_modtime", "uint32_amount", "uint32_main_type"}, new Object[]{0, 0L, 0, 0}, oidb_0x592$GetOnceScheduleListIncrementallyReq.class);
        public final PBUInt32Field uint32_get_way = PBField.initUInt32(0);
        public final PBUInt64Field uint64_lastest_modtime = PBField.initUInt64(0);
        public final PBUInt32Field uint32_amount = PBField.initUInt32(0);
        public final PBUInt32Field uint32_main_type = PBField.initUInt32(0);
    };
    public oidb_0x592$AcceptScheduleReq msg_accept_schedule_req = new MessageMicro<oidb_0x592$AcceptScheduleReq>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$AcceptScheduleReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_schedule_id"}, new Object[]{ByteStringMicro.EMPTY}, oidb_0x592$AcceptScheduleReq.class);
        public final PBBytesField bytes_schedule_id = PBField.initBytes(ByteStringMicro.EMPTY);
    };
}
