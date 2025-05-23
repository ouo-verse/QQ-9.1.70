package tencent.im.oidb.cmd0xbe4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xbe4$ReqBody extends MessageMicro<oidb_cmd0xbe4$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"client_version", "msg_get_req"}, new Object[]{"", null}, oidb_cmd0xbe4$ReqBody.class);
    public final PBStringField client_version = PBField.initString("");
    public oidb_cmd0xbe4$MsgGetReq msg_get_req = new MessageMicro<oidb_cmd0xbe4$MsgGetReq>() { // from class: tencent.im.oidb.cmd0xbe4.oidb_cmd0xbe4$MsgGetReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_last_msg", "uint32_msg_content", "str_msgid"}, new Object[]{0, 0, ""}, oidb_cmd0xbe4$MsgGetReq.class);
        public final PBUInt32Field uint32_last_msg = PBField.initUInt32(0);
        public final PBUInt32Field uint32_msg_content = PBField.initUInt32(0);
        public final PBStringField str_msgid = PBField.initString("");
    };
}
