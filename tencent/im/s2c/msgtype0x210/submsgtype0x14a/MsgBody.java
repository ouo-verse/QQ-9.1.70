package tencent.im.s2c.msgtype0x210.submsgtype0x14a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class MsgBody extends MessageMicro<MsgBody> {
    public static final int CMD_PRINT_COOKIE = 1;
    public static final int CMD_UNDEFINED = 0;
    public static final int CMD_UPLOAD_FILE = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"enum_cmd", "rpt_msg_params"}, new Object[]{0, null}, MsgBody.class);
    public final PBEnumField enum_cmd = PBField.initEnum(0);
    public final PBRepeatMessageField<Param> rpt_msg_params = PBField.initRepeatMessage(Param.class);

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static final class Param extends MessageMicro<Param> {
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"string_key", "bytes_value"}, new Object[]{"", ByteStringMicro.EMPTY}, Param.class);
        public final PBStringField string_key = PBField.initString("");
        public final PBBytesField bytes_value = PBField.initBytes(ByteStringMicro.EMPTY);
    }
}
