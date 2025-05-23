package tencent.im.s2c.msgtype0x210.submsgtype0x7c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x7c$MsgBody extends MessageMicro<submsgtype0x7c$MsgBody> {
    public static final int INT32_CMD_FIELD_NUMBER = 2;
    public static final int RPT_STRING_CMD_EXT_FIELD_NUMBER = 3;
    public static final int RPT_STRING_SEQ_EXT_FIELD_NUMBER = 5;
    public static final int UINT64_SEQ_FIELD_NUMBER = 4;
    public static final int UINT64_UIN_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42}, new String[]{"uint64_uin", "int32_cmd", "rpt_string_cmd_ext", "uint64_seq", "rpt_string_seq_ext"}, new Object[]{0L, 0, "", 0L, ""}, submsgtype0x7c$MsgBody.class);
    public final PBRepeatField<String> rpt_string_cmd_ext;
    public final PBRepeatField<String> rpt_string_seq_ext;
    public final PBUInt64Field uint64_seq;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBInt32Field int32_cmd = PBField.initInt32(0);

    public submsgtype0x7c$MsgBody() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.rpt_string_cmd_ext = PBField.initRepeat(pBStringField);
        this.uint64_seq = PBField.initUInt64(0L);
        this.rpt_string_seq_ext = PBField.initRepeat(pBStringField);
    }
}
