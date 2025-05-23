package tencent.im.oidb.cmd0xefb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xefb$RspBody extends MessageMicro<oidb_cmd0xefb$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"retcode", "retmsg"}, new Object[]{0, ""}, oidb_cmd0xefb$RspBody.class);
    public final PBInt32Field retcode = PBField.initInt32(0);
    public final PBStringField retmsg = PBField.initString("");
}
