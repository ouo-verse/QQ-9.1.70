package tencent.im.cs.cmd0x355;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Stt$RspBody extends MessageMicro<Stt$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint32_sub_cmd", "msg_group_ptt_resp", "msg_c2c_ptt_resp", "msg_corret_text_Resp"}, new Object[]{0, null, null, null}, Stt$RspBody.class);
    public final PBUInt32Field uint32_sub_cmd = PBField.initUInt32(0);
    public Stt$TransGroupPttResp msg_group_ptt_resp = new Stt$TransGroupPttResp();
    public Stt$TransC2CPttResp msg_c2c_ptt_resp = new Stt$TransC2CPttResp();
    public Stt$CorretTextResp msg_corret_text_Resp = new MessageMicro<Stt$CorretTextResp>() { // from class: tencent.im.cs.cmd0x355.Stt$CorretTextResp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_sessionid", "uint32_error_code", "uint32_seq"}, new Object[]{0L, 0, 0}, Stt$CorretTextResp.class);
        public final PBUInt64Field uint64_sessionid = PBField.initUInt64(0);
        public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
        public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    };
}
