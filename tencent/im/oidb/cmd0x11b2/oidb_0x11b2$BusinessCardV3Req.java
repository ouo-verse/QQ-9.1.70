package tencent.im.oidb.cmd0x11b2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x11b2$BusinessCardV3Req extends MessageMicro<oidb_0x11b2$BusinessCardV3Req> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"uin", "phone", "jump_url"}, new Object[]{0L, "", ""}, oidb_0x11b2$BusinessCardV3Req.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField phone = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
}
