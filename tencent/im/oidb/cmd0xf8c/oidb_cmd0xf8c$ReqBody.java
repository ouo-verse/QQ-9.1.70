package tencent.im.oidb.cmd0xf8c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xf8c$ReqBody extends MessageMicro<oidb_cmd0xf8c$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40, 50}, new String[]{"uin", "sdk_version", "clientplat", "zhongtai_number", "PlatformFlag", "cakeID"}, new Object[]{0L, "", "", "", 0, ""}, oidb_cmd0xf8c$ReqBody.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField sdk_version = PBField.initString("");
    public final PBStringField clientplat = PBField.initString("");
    public final PBStringField zhongtai_number = PBField.initString("");
    public final PBUInt32Field PlatformFlag = PBField.initUInt32(0);
    public final PBStringField cakeID = PBField.initString("");
}
