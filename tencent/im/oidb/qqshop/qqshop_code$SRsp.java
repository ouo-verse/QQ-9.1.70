package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qqshop_code$SRsp extends MessageMicro<qqshop_code$SRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"ret_code", "expired_time", "auth_code"}, new Object[]{0, 0, ""}, qqshop_code$SRsp.class);
    public final PBInt32Field ret_code = PBField.initInt32(0);
    public final PBUInt32Field expired_time = PBField.initUInt32(0);
    public final PBStringField auth_code = PBField.initString("");
}
