package tencent.im.statsvc.business.info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class businessinfo$RspBody extends MessageMicro<businessinfo$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint32_error_code", "string_error_msg", "uint32_interval"}, new Object[]{0, "", 0}, businessinfo$RspBody.class);
    public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
    public final PBStringField string_error_msg = PBField.initString("");
    public final PBUInt32Field uint32_interval = PBField.initUInt32(0);
}
