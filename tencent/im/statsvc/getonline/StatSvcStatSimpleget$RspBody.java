package tencent.im.statsvc.getonline;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class StatSvcStatSimpleget$RspBody extends MessageMicro<StatSvcStatSimpleget$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"uint32_error_code", "str_errmsg", "uint32_hello_interval", "str_clientip"}, new Object[]{0, "", 0, ""}, StatSvcStatSimpleget$RspBody.class);
    public final PBUInt32Field uint32_error_code = PBField.initUInt32(0);
    public final PBStringField str_errmsg = PBField.initString("");
    public final PBUInt32Field uint32_hello_interval = PBField.initUInt32(0);
    public final PBStringField str_clientip = PBField.initString("");
}
