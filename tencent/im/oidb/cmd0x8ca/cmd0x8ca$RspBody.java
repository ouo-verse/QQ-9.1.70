package tencent.im.oidb.cmd0x8ca;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x8ca$RspBody extends MessageMicro<cmd0x8ca$RspBody> {
    public static final int OPT_UINT64_GROUP_CODE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"opt_uint64_group_code"}, new Object[]{0L}, cmd0x8ca$RspBody.class);
    public final PBUInt64Field opt_uint64_group_code = PBField.initUInt64(0);
}
