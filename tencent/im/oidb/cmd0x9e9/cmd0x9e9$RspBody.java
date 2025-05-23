package tencent.im.oidb.cmd0x9e9;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x9e9$RspBody extends MessageMicro<cmd0x9e9$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"int64_total_point", "int64_total_divide_point", "bool_is_end"}, new Object[]{0L, 0L, Boolean.FALSE}, cmd0x9e9$RspBody.class);
    public final PBInt64Field int64_total_point = PBField.initInt64(0);
    public final PBInt64Field int64_total_divide_point = PBField.initInt64(0);
    public final PBBoolField bool_is_end = PBField.initBool(false);
}
