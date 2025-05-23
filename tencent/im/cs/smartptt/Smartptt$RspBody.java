package tencent.im.cs.smartptt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Smartptt$RspBody extends MessageMicro<Smartptt$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"uint32_sub_cmd", "msg_semantic_reco_rsp", "msg_ptttrans_rsp", "msg_tts_rsp", "str_trace_id"}, new Object[]{0, null, null, null, ""}, Smartptt$RspBody.class);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public Smartptt$SemanticRecoRsp msg_semantic_reco_rsp = new MessageMicro<Smartptt$SemanticRecoRsp>() { // from class: tencent.im.cs.smartptt.Smartptt$SemanticRecoRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 56, 66, 74, 82}, new String[]{"uint32_ret_code", "str_voice_id", "uint32_ans_node_id", "str_ans_node_name", "uint32_is_final", "uint32_title_id", "str_title", "slot_info", "str_answer"}, new Object[]{0, "", 0, "", 0, 0, "", null, ""}, Smartptt$SemanticRecoRsp.class);
        public final PBUInt32Field uint32_ret_code = PBField.initUInt32(0);
        public final PBStringField str_voice_id = PBField.initString("");
        public final PBUInt32Field uint32_ans_node_id = PBField.initUInt32(0);
        public final PBStringField str_ans_node_name = PBField.initString("");
        public final PBUInt32Field uint32_is_final = PBField.initUInt32(0);
        public final PBUInt32Field uint32_title_id = PBField.initUInt32(0);
        public final PBStringField str_title = PBField.initString("");
        public final PBRepeatMessageField<Smartptt$Slot> slot_info = PBField.initRepeatMessage(Smartptt$Slot.class);
        public final PBStringField str_answer = PBField.initString("");
    };
    public Smartptt$PttTransRsp msg_ptttrans_rsp = new Smartptt$PttTransRsp();
    public Smartptt$TTSRsp msg_tts_rsp = new MessageMicro<Smartptt$TTSRsp>() { // from class: tencent.im.cs.smartptt.Smartptt$TTSRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], Smartptt$TTSRsp.class);
    };
    public final PBStringField str_trace_id = PBField.initString("");
}
