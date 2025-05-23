package tencent.im.oidb.cmd0xfe3;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xfe3$ReqBody extends MessageMicro<oidb_cmd0xfe3$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"post_time", "sign"}, new Object[]{0L, ""}, oidb_cmd0xfe3$ReqBody.class);
    public final PBUInt64Field post_time = PBField.initUInt64(0);
    public final PBStringField sign = PBField.initString("");
}
