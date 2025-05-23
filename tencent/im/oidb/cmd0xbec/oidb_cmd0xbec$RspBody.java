package tencent.im.oidb.cmd0xbec;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xbec$RspBody extends MessageMicro<oidb_cmd0xbec$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"search_result_rsp", "rpt_hot_rsp"}, new Object[]{null, null}, oidb_cmd0xbec$RspBody.class);
    public oidb_cmd0xbec$SearchResultRsp search_result_rsp = new MessageMicro<oidb_cmd0xbec$SearchResultRsp>() { // from class: tencent.im.oidb.cmd0xbec.oidb_cmd0xbec$SearchResultRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"rpt_question_info", "bytes_cookies", "bool_is_end"}, new Object[]{null, ByteStringMicro.EMPTY, Boolean.FALSE}, oidb_cmd0xbec$SearchResultRsp.class);
        public final PBRepeatMessageField<oidb_cmd0xbec$QuestionInfo> rpt_question_info = PBField.initRepeatMessage(oidb_cmd0xbec$QuestionInfo.class);
        public final PBBytesField bytes_cookies = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBBoolField bool_is_end = PBField.initBool(false);
    };
    public oidb_cmd0xbec$HotWendaRsp rpt_hot_rsp = new MessageMicro<oidb_cmd0xbec$HotWendaRsp>() { // from class: tencent.im.oidb.cmd0xbec.oidb_cmd0xbec$HotWendaRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"rpt_hot", "uint64_next_pull_time"}, new Object[]{null, 0L}, oidb_cmd0xbec$HotWendaRsp.class);
        public final PBRepeatMessageField<oidb_cmd0xbec$HotItem> rpt_hot = PBField.initRepeatMessage(oidb_cmd0xbec$HotItem.class);
        public final PBUInt64Field uint64_next_pull_time = PBField.initUInt64(0);
    };
}
