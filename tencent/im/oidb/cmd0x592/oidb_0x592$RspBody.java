package tencent.im.oidb.cmd0x592;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.trunk.Qworkflow.Qworkflow$AppID;
import com.trunk.Qworkflow.Qworkflow$Workflow;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x592$RspBody extends MessageMicro<oidb_0x592$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154}, new String[]{"msg_appid", "msg_add_schedule_rsp", "msg_get_once_schedule_list_rsp", "msg_get_schedule_by_id_rsp", "msg_get_repeated_schedule_list_rsp", "msg_update_schedule_content_rsp", "msg_delete_my_schedule_rsp", "msg_recall_schedule_rsp", "msg_share_schedule_rsp", "msg_change_my_recv_status_rsp", "msg_set_all_readed_time_rsp", "msg_modify_unread_cnt_rsp", "msg_set_remind_bell_switch_rsp", "msg_get_date_has_once_schedule_rsp", "msg_modify_repeated_schedule_rsp", "msg_recall_repeated_schedule_rsp", "msg_get_repeated_schedule_list_rsp_new", "msg_get_once_schedule_list_incrementally_rsp", "msg_accept_schedule_rsp"}, new Object[]{null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}, oidb_0x592$RspBody.class);
    public Qworkflow$AppID msg_appid = new Qworkflow$AppID();
    public oidb_0x592$AddScheduleRsp msg_add_schedule_rsp = new MessageMicro<oidb_0x592$AddScheduleRsp>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$AddScheduleRsp
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_error_msg;
        public final PBBytesField bytes_workflow_id;
        public final PBUInt32Field uint32_data_version;
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"uint32_result", "bytes_error_msg", "bytes_workflow_id", "uint32_data_version"}, new Object[]{0, byteStringMicro, byteStringMicro, 0}, oidb_0x592$AddScheduleRsp.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_error_msg = PBField.initBytes(byteStringMicro);
            this.bytes_workflow_id = PBField.initBytes(byteStringMicro);
            this.uint32_data_version = PBField.initUInt32(0);
        }
    };
    public oidb_0x592$GetOnceScheduleListRsp msg_get_once_schedule_list_rsp = new MessageMicro<oidb_0x592$GetOnceScheduleListRsp>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$GetOnceScheduleListRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42}, new String[]{"uint32_result", "bytes_error_msg", "uint32_get_direction", "uint64_end_time", "rpt_msg_result_list"}, new Object[]{0, ByteStringMicro.EMPTY, 0, 0L, null}, oidb_0x592$GetOnceScheduleListRsp.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_get_direction = PBField.initUInt32(0);
        public final PBUInt64Field uint64_end_time = PBField.initUInt64(0);
        public final PBRepeatMessageField<oidb_0x592$GetScheduleResult> rpt_msg_result_list = PBField.initRepeatMessage(oidb_0x592$GetScheduleResult.class);
    };
    public oidb_0x592$GetScheduleByIDRsp msg_get_schedule_by_id_rsp = new MessageMicro<oidb_0x592$GetScheduleByIDRsp>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$GetScheduleByIDRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_result", "bytes_error_msg", "msg_schedule_result"}, new Object[]{0, ByteStringMicro.EMPTY, null}, oidb_0x592$GetScheduleByIDRsp.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
        public oidb_0x592$GetScheduleResult msg_schedule_result = new MessageMicro<oidb_0x592$GetScheduleResult>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$GetScheduleResult
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_result", "msg_schedule"}, new Object[]{0, null}, oidb_0x592$GetScheduleResult.class);
            public final PBUInt32Field uint32_result = PBField.initUInt32(0);
            public Qworkflow$Workflow msg_schedule = new Qworkflow$Workflow();
        };
    };
    public oidb_0x592$GetRepeatedScheduleListRsp msg_get_repeated_schedule_list_rsp = new MessageMicro<oidb_0x592$GetRepeatedScheduleListRsp>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$GetRepeatedScheduleListRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40}, new String[]{"uint32_result", "bytes_error_msg", "rpt_msg_schedule_list", "uint64_next_modtime", "uint32_next_get_way"}, new Object[]{0, ByteStringMicro.EMPTY, null, 0L, 0}, oidb_0x592$GetRepeatedScheduleListRsp.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBRepeatMessageField<oidb_0x592$GetScheduleResult> rpt_msg_schedule_list = PBField.initRepeatMessage(oidb_0x592$GetScheduleResult.class);
        public final PBUInt64Field uint64_next_modtime = PBField.initUInt64(0);
        public final PBUInt32Field uint32_next_get_way = PBField.initUInt32(0);
    };
    public oidb_0x592$UpdateScheduleContentRsp msg_update_schedule_content_rsp = new MessageMicro<oidb_0x592$UpdateScheduleContentRsp>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$UpdateScheduleContentRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_result", "bytes_error_msg", "uint32_data_version"}, new Object[]{0, ByteStringMicro.EMPTY, 0}, oidb_0x592$UpdateScheduleContentRsp.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_data_version = PBField.initUInt32(0);
    };
    public oidb_0x592$DeleteMyScheduleRsp msg_delete_my_schedule_rsp = new MessageMicro<oidb_0x592$DeleteMyScheduleRsp>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$DeleteMyScheduleRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_result", "bytes_error_msg"}, new Object[]{0, ByteStringMicro.EMPTY}, oidb_0x592$DeleteMyScheduleRsp.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public oidb_0x592$RecallScheduleRsp msg_recall_schedule_rsp = new MessageMicro<oidb_0x592$RecallScheduleRsp>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$RecallScheduleRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_result", "bytes_error_msg"}, new Object[]{0, ByteStringMicro.EMPTY}, oidb_0x592$RecallScheduleRsp.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public oidb_0x592$ShareScheduleRsp msg_share_schedule_rsp = new MessageMicro<oidb_0x592$ShareScheduleRsp>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$ShareScheduleRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_result", "bytes_error_msg", "rpt_fail_schedule_list"}, new Object[]{0, ByteStringMicro.EMPTY, null}, oidb_0x592$ShareScheduleRsp.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBRepeatMessageField<oidb_0x592$ShareScheduleResult> rpt_fail_schedule_list = PBField.initRepeatMessage(oidb_0x592$ShareScheduleResult.class);
    };
    public oidb_0x592$ChangeMyNotificationReceivingStatusRsp msg_change_my_recv_status_rsp = new MessageMicro<oidb_0x592$ChangeMyNotificationReceivingStatusRsp>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$ChangeMyNotificationReceivingStatusRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_result", "bytes_error_msg"}, new Object[]{0, ByteStringMicro.EMPTY}, oidb_0x592$ChangeMyNotificationReceivingStatusRsp.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public oidb_0x592$SetAllReadedTimeRsp msg_set_all_readed_time_rsp = new MessageMicro<oidb_0x592$SetAllReadedTimeRsp>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$SetAllReadedTimeRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_result", "bytes_error_msg"}, new Object[]{0, ByteStringMicro.EMPTY}, oidb_0x592$SetAllReadedTimeRsp.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public oidb_0x592$ModifyUnreadCntRsp msg_modify_unread_cnt_rsp = new MessageMicro<oidb_0x592$ModifyUnreadCntRsp>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$ModifyUnreadCntRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_result", "bytes_error_msg"}, new Object[]{0, ByteStringMicro.EMPTY}, oidb_0x592$ModifyUnreadCntRsp.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public oidb_0x592$SetRemindBellSwitchRsp msg_set_remind_bell_switch_rsp = new MessageMicro<oidb_0x592$SetRemindBellSwitchRsp>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$SetRemindBellSwitchRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_result", "bytes_error_msg"}, new Object[]{0, ByteStringMicro.EMPTY}, oidb_0x592$SetRemindBellSwitchRsp.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public oidb_0x592$GetDateHasOnceScheduleRsp msg_get_date_has_once_schedule_rsp = new MessageMicro<oidb_0x592$GetDateHasOnceScheduleRsp>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$GetDateHasOnceScheduleRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"uint32_result", "bytes_error_msg", "uint64_rsp_end_time", "rpt_msg_date_result"}, new Object[]{0, ByteStringMicro.EMPTY, 0L, null}, oidb_0x592$GetDateHasOnceScheduleRsp.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt64Field uint64_rsp_end_time = PBField.initUInt64(0);
        public final PBRepeatMessageField<oidb_0x592$GetDateResult> rpt_msg_date_result = PBField.initRepeatMessage(oidb_0x592$GetDateResult.class);
    };
    public oidb_0x592$ModifyRepeatedScheduleRsp msg_modify_repeated_schedule_rsp = new MessageMicro<oidb_0x592$ModifyRepeatedScheduleRsp>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$ModifyRepeatedScheduleRsp
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_error_msg;
        public final PBBytesField bytes_new_workflow_id;
        public final PBUInt32Field uint32_data_version;
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"uint32_result", "bytes_error_msg", "uint32_data_version", "bytes_new_workflow_id"}, new Object[]{0, byteStringMicro, 0, byteStringMicro}, oidb_0x592$ModifyRepeatedScheduleRsp.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_error_msg = PBField.initBytes(byteStringMicro);
            this.uint32_data_version = PBField.initUInt32(0);
            this.bytes_new_workflow_id = PBField.initBytes(byteStringMicro);
        }
    };
    public oidb_0x592$RecallRepeatedScheduleRsp msg_recall_repeated_schedule_rsp = new MessageMicro<oidb_0x592$RecallRepeatedScheduleRsp>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$RecallRepeatedScheduleRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_result", "bytes_error_msg"}, new Object[]{0, ByteStringMicro.EMPTY}, oidb_0x592$RecallRepeatedScheduleRsp.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public oidb_0x592$GetRepeatedScheduleListRsp msg_get_repeated_schedule_list_rsp_new = new MessageMicro<oidb_0x592$GetRepeatedScheduleListRsp>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$GetRepeatedScheduleListRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40}, new String[]{"uint32_result", "bytes_error_msg", "rpt_msg_schedule_list", "uint64_next_modtime", "uint32_next_get_way"}, new Object[]{0, ByteStringMicro.EMPTY, null, 0L, 0}, oidb_0x592$GetRepeatedScheduleListRsp.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBRepeatMessageField<oidb_0x592$GetScheduleResult> rpt_msg_schedule_list = PBField.initRepeatMessage(oidb_0x592$GetScheduleResult.class);
        public final PBUInt64Field uint64_next_modtime = PBField.initUInt64(0);
        public final PBUInt32Field uint32_next_get_way = PBField.initUInt32(0);
    };
    public oidb_0x592$GetOnceScheduleListIncrementallyRsp msg_get_once_schedule_list_incrementally_rsp = new MessageMicro<oidb_0x592$GetOnceScheduleListIncrementallyRsp>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$GetOnceScheduleListIncrementallyRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40}, new String[]{"uint32_result", "bytes_error_msg", "rpt_msg_schedule_list", "uint64_next_modtime", "uint32_next_get_way"}, new Object[]{0, ByteStringMicro.EMPTY, null, 0L, 0}, oidb_0x592$GetOnceScheduleListIncrementallyRsp.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBRepeatMessageField<oidb_0x592$GetScheduleResult> rpt_msg_schedule_list = PBField.initRepeatMessage(oidb_0x592$GetScheduleResult.class);
        public final PBUInt64Field uint64_next_modtime = PBField.initUInt64(0);
        public final PBUInt32Field uint32_next_get_way = PBField.initUInt32(0);
    };
    public oidb_0x592$AcceptScheduleRsp msg_accept_schedule_rsp = new MessageMicro<oidb_0x592$AcceptScheduleRsp>() { // from class: tencent.im.oidb.cmd0x592.oidb_0x592$AcceptScheduleRsp
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_error_msg;
        public final PBBytesField bytes_schedule_id;
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_result", "bytes_error_msg", "bytes_schedule_id"}, new Object[]{0, byteStringMicro, byteStringMicro}, oidb_0x592$AcceptScheduleRsp.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_error_msg = PBField.initBytes(byteStringMicro);
            this.bytes_schedule_id = PBField.initBytes(byteStringMicro);
        }
    };
}
