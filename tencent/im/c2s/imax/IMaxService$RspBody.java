package tencent.im.c2s.imax;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class IMaxService$RspBody extends MessageMicro<IMaxService$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"int32_ret", "str_msg", "int32_type", "int32_exposure_flag"}, new Object[]{0, "", 0, 0}, IMaxService$RspBody.class);
    public final PBInt32Field int32_ret = PBField.initInt32(0);
    public final PBStringField str_msg = PBField.initString("");
    public final PBInt32Field int32_type = PBField.initInt32(0);
    public final PBInt32Field int32_exposure_flag = PBField.initInt32(0);
}
