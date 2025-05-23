package tencent.im.msg;

import androidx.core.app.NotificationCompat;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class im_imagent$ImAgentHead extends MessageMicro<im_imagent$ImAgentHead> {
    public static final int COMMAND_FIELD_NUMBER = 1;
    public static final int ECHO_BUF_FIELD_NUMBER = 5;
    public static final int ERR_FIELD_NUMBER = 4;
    public static final int REQ_INFO_FIELD_NUMBER = 7;
    public static final int REQ_USER_FIELD_NUMBER = 6;
    public static final int RESULT_FIELD_NUMBER = 3;
    public static final int SEQ_FIELD_NUMBER = 2;
    public static final int SERVER_IP_FIELD_NUMBER = 10;
    public static final int SIGNATURE_FIELD_NUMBER = 8;
    public static final int SUB_CMD_FIELD_NUMBER = 9;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 58, 66, 72, 80}, new String[]{"command", "seq", "result", NotificationCompat.CATEGORY_ERROR, "echo_buf", "req_user", "req_info", "signature", "sub_cmd", "server_ip"}, new Object[]{1, 0, 0, "", ByteStringMicro.EMPTY, null, null, null, 0, 0}, im_imagent$ImAgentHead.class);
    public final PBEnumField command = PBField.initEnum(1);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBStringField err = PBField.initString("");
    public final PBBytesField echo_buf = PBField.initBytes(ByteStringMicro.EMPTY);
    public im_common$User req_user = new im_common$User();
    public im_imagent$Requestinfo req_info = new MessageMicro<im_imagent$Requestinfo>() { // from class: tencent.im.msg.im_imagent$Requestinfo
        public static final int REQ_FLAG_FIELD_NUMBER = 3;
        public static final int REQ_IP_FIELD_NUMBER = 1;
        public static final int REQ_PORT_FIELD_NUMBER = 2;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{13, 16, 24}, new String[]{"req_ip", "req_port", "req_flag"}, new Object[]{0, 0, 0}, im_imagent$Requestinfo.class);
        public final PBFixed32Field req_ip = PBField.initFixed32(0);
        public final PBUInt32Field req_port = PBField.initUInt32(0);
        public final PBUInt32Field req_flag = PBField.initUInt32(0);
    };
    public im_imagent$Signature signature = new im_imagent$Signature();
    public final PBUInt32Field sub_cmd = PBField.initUInt32(0);
    public final PBUInt32Field server_ip = PBField.initUInt32(0);
}
