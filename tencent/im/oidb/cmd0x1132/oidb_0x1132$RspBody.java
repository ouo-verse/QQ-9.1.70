package tencent.im.oidb.cmd0x1132;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x1132$RspBody extends MessageMicro<oidb_0x1132$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"match_status", "match_pattern"}, new Object[]{0, ""}, oidb_0x1132$RspBody.class);
    public final PBUInt32Field match_status = PBField.initUInt32(0);
    public final PBStringField match_pattern = PBField.initString("");
}
