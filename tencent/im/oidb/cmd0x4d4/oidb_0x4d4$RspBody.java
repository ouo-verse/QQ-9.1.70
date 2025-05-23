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
import com.trunk.Qworkflow.Qworkflow$Workflow;
import com.trunk.Qworkflow.Qworkflow$WorkflowBrief;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x4d4$RspBody extends MessageMicro<oidb_0x4d4$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98}, new String[]{"msg_appid", "msg_get_workflow_list_rsp", "msg_update_workflow_rsp", "msg_add_workflow_rsp", "msg_delete_workflow_rsp", "msg_recall_workflow_rsp", "msg_set_workflows_readed_rsp", "msg_set_all_workflow_processed_rsp", "msg_get_workflow_by_id_rsp", "msg_set_workflows_ignore_state_rsp", "msg_share_workflow_rsp", "msg_hasten_workflow_rsp"}, new Object[]{null, null, null, null, null, null, null, null, null, null, null, null}, oidb_0x4d4$RspBody.class);
    public Qworkflow$AppID msg_appid = new Qworkflow$AppID();
    public oidb_0x4d4$GetWorkflowListRsp msg_get_workflow_list_rsp = new MessageMicro<oidb_0x4d4$GetWorkflowListRsp>() { // from class: tencent.im.oidb.cmd0x4d4.oidb_0x4d4$GetWorkflowListRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42}, new String[]{"uint32_result", "bytes_error_msg", "uint64_start_time", "uint64_end_time", "rpt_msg_result_list"}, new Object[]{0, ByteStringMicro.EMPTY, 0L, 0L, null}, oidb_0x4d4$GetWorkflowListRsp.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt64Field uint64_start_time = PBField.initUInt64(0);
        public final PBUInt64Field uint64_end_time = PBField.initUInt64(0);
        public final PBRepeatMessageField<oidb_0x4d4$GetWorkflowResult> rpt_msg_result_list = PBField.initRepeatMessage(oidb_0x4d4$GetWorkflowResult.class);
    };
    public oidb_0x4d4$UpdateWorkflowsRsp msg_update_workflow_rsp = new MessageMicro<oidb_0x4d4$UpdateWorkflowsRsp>() { // from class: tencent.im.oidb.cmd0x4d4.oidb_0x4d4$UpdateWorkflowsRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"enum_update_type", "uint32_result", "bytes_error_msg", "rpt_msg_udpate_failure_list"}, new Object[]{1, 0, ByteStringMicro.EMPTY, null}, oidb_0x4d4$UpdateWorkflowsRsp.class);
        public final PBEnumField enum_update_type = PBField.initEnum(1);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBRepeatMessageField<oidb_0x4d4$UpdateFailure> rpt_msg_udpate_failure_list = PBField.initRepeatMessage(oidb_0x4d4$UpdateFailure.class);
    };
    public oidb_0x4d4$AddWorkflowRsp msg_add_workflow_rsp = new MessageMicro<oidb_0x4d4$AddWorkflowRsp>() { // from class: tencent.im.oidb.cmd0x4d4.oidb_0x4d4$AddWorkflowRsp
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_error_msg;
        public final PBBytesField bytes_workflow_id;
        public final PBUInt32Field uint32_data_version;
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"uint32_result", "bytes_error_msg", "bytes_workflow_id", "uint32_data_version"}, new Object[]{0, byteStringMicro, byteStringMicro, 0}, oidb_0x4d4$AddWorkflowRsp.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_error_msg = PBField.initBytes(byteStringMicro);
            this.bytes_workflow_id = PBField.initBytes(byteStringMicro);
            this.uint32_data_version = PBField.initUInt32(0);
        }
    };
    public oidb_0x4d4$DeleteWorkflowRsp msg_delete_workflow_rsp = new MessageMicro<oidb_0x4d4$DeleteWorkflowRsp>() { // from class: tencent.im.oidb.cmd0x4d4.oidb_0x4d4$DeleteWorkflowRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_result", "bytes_error_msg"}, new Object[]{0, ByteStringMicro.EMPTY}, oidb_0x4d4$DeleteWorkflowRsp.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public oidb_0x4d4$RecallWorkflowRsp msg_recall_workflow_rsp = new MessageMicro<oidb_0x4d4$RecallWorkflowRsp>() { // from class: tencent.im.oidb.cmd0x4d4.oidb_0x4d4$RecallWorkflowRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_result", "bytes_error_msg"}, new Object[]{0, ByteStringMicro.EMPTY}, oidb_0x4d4$RecallWorkflowRsp.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public oidb_0x4d4$SetWorkflowsReadedRsp msg_set_workflows_readed_rsp = new MessageMicro<oidb_0x4d4$SetWorkflowsReadedRsp>() { // from class: tencent.im.oidb.cmd0x4d4.oidb_0x4d4$SetWorkflowsReadedRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_result", "bytes_error_msg", "rpt_msg_failure_list"}, new Object[]{0, ByteStringMicro.EMPTY, null}, oidb_0x4d4$SetWorkflowsReadedRsp.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBRepeatMessageField<Qworkflow$WorkflowBrief> rpt_msg_failure_list = PBField.initRepeatMessage(Qworkflow$WorkflowBrief.class);
    };
    public oidb_0x4d4$SetAllWorkflowProcessedRsp msg_set_all_workflow_processed_rsp = new MessageMicro<oidb_0x4d4$SetAllWorkflowProcessedRsp>() { // from class: tencent.im.oidb.cmd0x4d4.oidb_0x4d4$SetAllWorkflowProcessedRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_result", "bytes_error_msg", "uint32_failure_count"}, new Object[]{0, ByteStringMicro.EMPTY, 0}, oidb_0x4d4$SetAllWorkflowProcessedRsp.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field uint32_failure_count = PBField.initUInt32(0);
    };
    public oidb_0x4d4$GetWorkflowByIDRsp msg_get_workflow_by_id_rsp = new MessageMicro<oidb_0x4d4$GetWorkflowByIDRsp>() { // from class: tencent.im.oidb.cmd0x4d4.oidb_0x4d4$GetWorkflowByIDRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_result", "bytes_error_msg", "msg_workflow_result"}, new Object[]{0, ByteStringMicro.EMPTY, null}, oidb_0x4d4$GetWorkflowByIDRsp.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
        public oidb_0x4d4$GetWorkflowResult msg_workflow_result = new MessageMicro<oidb_0x4d4$GetWorkflowResult>() { // from class: tencent.im.oidb.cmd0x4d4.oidb_0x4d4$GetWorkflowResult
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_result", "msg_workflow_source", "msg_workflow"}, new Object[]{0, null, null}, oidb_0x4d4$GetWorkflowResult.class);
            public final PBUInt32Field uint32_result = PBField.initUInt32(0);
            public oidb_0x4d4$WorkflowSource msg_workflow_source = new oidb_0x4d4$WorkflowSource();
            public Qworkflow$Workflow msg_workflow = new Qworkflow$Workflow();
        };
    };
    public oidb_0x4d4$SetWorkflowsIgnoreStateRsp msg_set_workflows_ignore_state_rsp = new MessageMicro<oidb_0x4d4$SetWorkflowsIgnoreStateRsp>() { // from class: tencent.im.oidb.cmd0x4d4.oidb_0x4d4$SetWorkflowsIgnoreStateRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uint32_result", "bytes_error_msg", "rpt_msg_failure_list"}, new Object[]{0, ByteStringMicro.EMPTY, null}, oidb_0x4d4$SetWorkflowsIgnoreStateRsp.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBRepeatMessageField<Qworkflow$WorkflowBrief> rpt_msg_failure_list = PBField.initRepeatMessage(Qworkflow$WorkflowBrief.class);
    };
    public oidb_0x4d4$ShareWorkflowRsp msg_share_workflow_rsp = new MessageMicro<oidb_0x4d4$ShareWorkflowRsp>() { // from class: tencent.im.oidb.cmd0x4d4.oidb_0x4d4$ShareWorkflowRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_result", "bytes_error_msg"}, new Object[]{0, ByteStringMicro.EMPTY}, oidb_0x4d4$ShareWorkflowRsp.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public oidb_0x4d4$HastenWorkflowRsp msg_hasten_workflow_rsp = new MessageMicro<oidb_0x4d4$HastenWorkflowRsp>() { // from class: tencent.im.oidb.cmd0x4d4.oidb_0x4d4$HastenWorkflowRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_result", "bytes_error_msg"}, new Object[]{0, ByteStringMicro.EMPTY}, oidb_0x4d4$HastenWorkflowRsp.class);
        public final PBUInt32Field uint32_result = PBField.initUInt32(0);
        public final PBBytesField bytes_error_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    };
}
