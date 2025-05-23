package tencent.im.oidb.cmd0x4d4;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.trunk.Qworkflow.Qworkflow$AppID;
import com.trunk.Qworkflow.Qworkflow$Approver;
import com.trunk.Qworkflow.Qworkflow$ApproverState;
import com.trunk.Qworkflow.Qworkflow$UserSource;
import com.trunk.Qworkflow.Qworkflow$Workflow;
import com.trunk.Qworkflow.Qworkflow$WorkflowBrief;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x4d4$ReqBody extends MessageMicro<oidb_0x4d4$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98}, new String[]{"msg_appid", "msg_get_workflow_list_req", "msg_update_workflows_req", "msg_add_workflow_req", "msg_delete_workflow_req", "msg_recall_workflow_req", "msg_set_workflows_readed_req", "msg_set_all_workflow_processed_req", "msg_get_workflow_by_id_req", "msg_set_workflows_ignore_state_req", "msg_share_workflow_req", "msg_hasten_workflow_req"}, new Object[]{null, null, null, null, null, null, null, null, null, null, null, null}, oidb_0x4d4$ReqBody.class);
    public Qworkflow$AppID msg_appid = new Qworkflow$AppID();
    public oidb_0x4d4$GetWorkflowListReq msg_get_workflow_list_req = new MessageMicro<oidb_0x4d4$GetWorkflowListReq>() { // from class: tencent.im.oidb.cmd0x4d4.oidb_0x4d4$GetWorkflowListReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42}, new String[]{"uint64_end_time", "rpt_msg_workflow_list", "uint32_amount", "msg_filter", "msg_order"}, new Object[]{0L, null, 0, null, null}, oidb_0x4d4$GetWorkflowListReq.class);
        public final PBUInt64Field uint64_end_time = PBField.initUInt64(0);
        public final PBRepeatMessageField<Qworkflow$WorkflowBrief> rpt_msg_workflow_list = PBField.initRepeatMessage(Qworkflow$WorkflowBrief.class);
        public final PBUInt32Field uint32_amount = PBField.initUInt32(0);
        public oidb_0x4d4$WorkflowFilter msg_filter = new MessageMicro<oidb_0x4d4$WorkflowFilter>() { // from class: tencent.im.oidb.cmd0x4d4.oidb_0x4d4$WorkflowFilter
            public static final int IGNORED = 1;
            public static final int NOT_IGNORED = 2;
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 50}, new String[]{"uint32_main_type", "uint32_sub_type", "uint64_author_uin", "rpt_msg_my_state", "enum_ignore_state", "msg_workflow_source"}, new Object[]{0, 0, 0L, null, 1, null}, oidb_0x4d4$WorkflowFilter.class);
            public final PBUInt32Field uint32_main_type = PBField.initUInt32(0);
            public final PBUInt32Field uint32_sub_type = PBField.initUInt32(0);
            public final PBUInt64Field uint64_author_uin = PBField.initUInt64(0);
            public final PBRepeatMessageField<Qworkflow$ApproverState> rpt_msg_my_state = PBField.initRepeatMessage(Qworkflow$ApproverState.class);
            public final PBEnumField enum_ignore_state = PBField.initEnum(1);
            public oidb_0x4d4$WorkflowSource msg_workflow_source = new oidb_0x4d4$WorkflowSource();
        };
        public oidb_0x4d4$WorkflowOrder msg_order = new MessageMicro<oidb_0x4d4$WorkflowOrder>() { // from class: tencent.im.oidb.cmd0x4d4.oidb_0x4d4$WorkflowOrder
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0x4d4$WorkflowOrder.class);
        };
    };
    public oidb_0x4d4$UpdateWorkflowsReq msg_update_workflows_req = new MessageMicro<oidb_0x4d4$UpdateWorkflowsReq>() { // from class: tencent.im.oidb.cmd0x4d4.oidb_0x4d4$UpdateWorkflowsReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"enum_update_type", "rpt_msg_update_list", "rpt_msg_process_workflows", "msg_hand_over"}, new Object[]{1, null, null, null}, oidb_0x4d4$UpdateWorkflowsReq.class);
        public final PBEnumField enum_update_type = PBField.initEnum(1);
        public final PBRepeatMessageField<oidb_0x4d4$UpdateApproverListOfState> rpt_msg_update_list = PBField.initRepeatMessage(oidb_0x4d4$UpdateApproverListOfState.class);
        public final PBRepeatMessageField<oidb_0x4d4$UpdateApproverProcessState> rpt_msg_process_workflows = PBField.initRepeatMessage(oidb_0x4d4$UpdateApproverProcessState.class);
        public oidb_0x4d4$UpdateHandOver msg_hand_over = new MessageMicro<oidb_0x4d4$UpdateHandOver>() { // from class: tencent.im.oidb.cmd0x4d4.oidb_0x4d4$UpdateHandOver
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"bytes_workflow_id", "uint32_data_version", "msg_approver"}, new Object[]{ByteStringMicro.EMPTY, 0, null}, oidb_0x4d4$UpdateHandOver.class);
            public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
            public final PBUInt32Field uint32_data_version = PBField.initUInt32(0);
            public Qworkflow$Approver msg_approver = new Qworkflow$Approver();
        };
    };
    public oidb_0x4d4$AddWorkflowReq msg_add_workflow_req = new MessageMicro<oidb_0x4d4$AddWorkflowReq>() { // from class: tencent.im.oidb.cmd0x4d4.oidb_0x4d4$AddWorkflowReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_workflow"}, new Object[]{null}, oidb_0x4d4$AddWorkflowReq.class);
        public Qworkflow$Workflow msg_workflow = new Qworkflow$Workflow();
    };
    public oidb_0x4d4$DeleteWorkflowReq msg_delete_workflow_req = new MessageMicro<oidb_0x4d4$DeleteWorkflowReq>() { // from class: tencent.im.oidb.cmd0x4d4.oidb_0x4d4$DeleteWorkflowReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_workflow_id"}, new Object[]{ByteStringMicro.EMPTY}, oidb_0x4d4$DeleteWorkflowReq.class);
        public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public oidb_0x4d4$RecallWorkflowReq msg_recall_workflow_req = new MessageMicro<oidb_0x4d4$RecallWorkflowReq>() { // from class: tencent.im.oidb.cmd0x4d4.oidb_0x4d4$RecallWorkflowReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_workflow_id"}, new Object[]{ByteStringMicro.EMPTY}, oidb_0x4d4$RecallWorkflowReq.class);
        public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public oidb_0x4d4$SetWorkflowsReadedReq msg_set_workflows_readed_req = new MessageMicro<oidb_0x4d4$SetWorkflowsReadedReq>() { // from class: tencent.im.oidb.cmd0x4d4.oidb_0x4d4$SetWorkflowsReadedReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rpt_msg_workflow_list"}, new Object[]{null}, oidb_0x4d4$SetWorkflowsReadedReq.class);
        public final PBRepeatMessageField<Qworkflow$WorkflowBrief> rpt_msg_workflow_list = PBField.initRepeatMessage(Qworkflow$WorkflowBrief.class);
    };
    public oidb_0x4d4$SetAllWorkflowProcessedReq msg_set_all_workflow_processed_req = new MessageMicro<oidb_0x4d4$SetAllWorkflowProcessedReq>() { // from class: tencent.im.oidb.cmd0x4d4.oidb_0x4d4$SetAllWorkflowProcessedReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_end_time", "msg_approver_state"}, new Object[]{0L, null}, oidb_0x4d4$SetAllWorkflowProcessedReq.class);
        public final PBUInt64Field uint64_end_time = PBField.initUInt64(0);
        public Qworkflow$ApproverState msg_approver_state = new Qworkflow$ApproverState();
    };
    public oidb_0x4d4$GetWorkflowByIDReq msg_get_workflow_by_id_req = new MessageMicro<oidb_0x4d4$GetWorkflowByIDReq>() { // from class: tencent.im.oidb.cmd0x4d4.oidb_0x4d4$GetWorkflowByIDReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_workflow_id", "msg_workflow_brief"}, new Object[]{ByteStringMicro.EMPTY, null}, oidb_0x4d4$GetWorkflowByIDReq.class);
        public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public Qworkflow$WorkflowBrief msg_workflow_brief = new Qworkflow$WorkflowBrief();
    };
    public oidb_0x4d4$SetWorkflowsIgnoreStateReq msg_set_workflows_ignore_state_req = new MessageMicro<oidb_0x4d4$SetWorkflowsIgnoreStateReq>() { // from class: tencent.im.oidb.cmd0x4d4.oidb_0x4d4$SetWorkflowsIgnoreStateReq
        public static final int IGNORED = 1;
        public static final int NOT_IGNORED = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"enum_state", "rpt_msg_workflow_list"}, new Object[]{1, null}, oidb_0x4d4$SetWorkflowsIgnoreStateReq.class);
        public final PBEnumField enum_state = PBField.initEnum(1);
        public final PBRepeatMessageField<Qworkflow$WorkflowBrief> rpt_msg_workflow_list = PBField.initRepeatMessage(Qworkflow$WorkflowBrief.class);
    };
    public oidb_0x4d4$ShareWorkflowReq msg_share_workflow_req = new MessageMicro<oidb_0x4d4$ShareWorkflowReq>() { // from class: tencent.im.oidb.cmd0x4d4.oidb_0x4d4$ShareWorkflowReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_workflow_id", "msg_receiver"}, new Object[]{ByteStringMicro.EMPTY, null}, oidb_0x4d4$ShareWorkflowReq.class);
        public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public oidb_0x4d4$ShareReceiver msg_receiver = new MessageMicro<oidb_0x4d4$ShareReceiver>() { // from class: tencent.im.oidb.cmd0x4d4.oidb_0x4d4$ShareReceiver
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint64_uin", "msg_source"}, new Object[]{0L, null}, oidb_0x4d4$ShareReceiver.class);
            public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
            public Qworkflow$UserSource msg_source = new Qworkflow$UserSource();
        };
    };
    public oidb_0x4d4$HastenWorkflowReq msg_hasten_workflow_req = new MessageMicro<oidb_0x4d4$HastenWorkflowReq>() { // from class: tencent.im.oidb.cmd0x4d4.oidb_0x4d4$HastenWorkflowReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bytes_workflow_id"}, new Object[]{ByteStringMicro.EMPTY}, oidb_0x4d4$HastenWorkflowReq.class);
        public final PBBytesField bytes_workflow_id = PBField.initBytes(ByteStringMicro.EMPTY);
    };
}
