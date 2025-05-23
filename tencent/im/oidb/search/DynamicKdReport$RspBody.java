package tencent.im.oidb.search;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class DynamicKdReport$RspBody extends MessageMicro<DynamicKdReport$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"iret", "sreason"}, new Object[]{0, ""}, DynamicKdReport$RspBody.class);
    public final PBInt32Field iret = PBField.initInt32(0);
    public final PBStringField sreason = PBField.initString("");
}
