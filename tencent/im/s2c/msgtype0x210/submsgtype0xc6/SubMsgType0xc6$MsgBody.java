package tencent.im.s2c.msgtype0x210.submsgtype0xc6;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0xc6$MsgBody extends MessageMicro<SubMsgType0xc6$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_sec_cmd", "msg_s2c_account_exception_notify"}, new Object[]{0, null}, SubMsgType0xc6$MsgBody.class);
    public final PBUInt32Field uint32_sec_cmd = PBField.initUInt32(0);
    public SubMsgType0xc6$AccountExceptionAlertBody msg_s2c_account_exception_notify = new MessageMicro<SubMsgType0xc6$AccountExceptionAlertBody>() { // from class: tencent.im.s2c.msgtype0x210.submsgtype0xc6.SubMsgType0xc6$AccountExceptionAlertBody
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 56}, new String[]{"str_title", "str_content", "str_left_button_text", "str_right_button_text", "str_right_button_link", "uint32_left_button_id", "uint32_right_button_id"}, new Object[]{"", "", "", "", "", 0, 0}, SubMsgType0xc6$AccountExceptionAlertBody.class);
        public final PBStringField str_title = PBField.initString("");
        public final PBStringField str_content = PBField.initString("");
        public final PBStringField str_left_button_text = PBField.initString("");
        public final PBStringField str_right_button_text = PBField.initString("");
        public final PBStringField str_right_button_link = PBField.initString("");
        public final PBUInt32Field uint32_left_button_id = PBField.initUInt32(0);
        public final PBUInt32Field uint32_right_button_id = PBField.initUInt32(0);
    };
}
