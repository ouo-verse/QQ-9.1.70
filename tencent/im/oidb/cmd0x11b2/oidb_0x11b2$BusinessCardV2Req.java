package tencent.im.oidb.cmd0x11b2;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x11b2$BusinessCardV2Req extends MessageMicro<oidb_0x11b2$BusinessCardV2Req> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 48}, new String[]{"uin", "phone", "jump_url_ios", "jump_url_android", "jump_url_pc", "is_forward"}, new Object[]{0L, "", "", "", "", Boolean.FALSE}, oidb_0x11b2$BusinessCardV2Req.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField phone = PBField.initString("");
    public final PBStringField jump_url_ios = PBField.initString("");
    public final PBStringField jump_url_android = PBField.initString("");
    public final PBStringField jump_url_pc = PBField.initString("");
    public final PBBoolField is_forward = PBField.initBool(false);
}
