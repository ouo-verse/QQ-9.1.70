package tencent.im.sso2sns;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class sso2sns_comm_info$Sso2SnsCommInfo extends MessageMicro<sso2sns_comm_info$Sso2SnsCommInfo> {
    public static final int STR_ERROR_MSG_FIELD_NUMBER = 3;
    public static final int UINT32_RESULT_FIELD_NUMBER = 2;
    public static final int UINT32_SEQ_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_seq", "uint32_result", "str_error_msg"}, new Object[]{0, 0, ""}, sso2sns_comm_info$Sso2SnsCommInfo.class);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBStringField str_error_msg = PBField.initString("");
}
