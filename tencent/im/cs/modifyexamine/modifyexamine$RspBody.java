package tencent.im.cs.modifyexamine;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class modifyexamine$RspBody extends MessageMicro<modifyexamine$RspBody> {
    public static final int STR_ERRMSG_FIELD_NUMBER = 4;
    public static final int UINT32_LIMIT_TIMES_FIELD_NUMBER = 2;
    public static final int UINT32_MODIFY_TIMES_FIELD_NUMBER = 3;
    public static final int UINT32_RESULT_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"uint32_result", "uint32_limit_times", "uint32_modify_times", "str_errmsg"}, new Object[]{0, 0, 0, ""}, modifyexamine$RspBody.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBUInt32Field uint32_limit_times = PBField.initUInt32(0);
    public final PBUInt32Field uint32_modify_times = PBField.initUInt32(0);
    public final PBStringField str_errmsg = PBField.initString("");
}
