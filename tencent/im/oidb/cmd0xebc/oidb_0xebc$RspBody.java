package tencent.im.oidb.cmd0xebc;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xebc$RspBody extends MessageMicro<oidb_0xebc$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"type", "rank"}, new Object[]{"", 0}, oidb_0xebc$RspBody.class);
    public final PBStringField type = PBField.initString("");
    public final PBUInt32Field rank = PBField.initUInt32(0);
}
