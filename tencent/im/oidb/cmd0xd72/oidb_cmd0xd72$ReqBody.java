package tencent.im.oidb.cmd0xd72;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xd72$ReqBody extends MessageMicro<oidb_cmd0xd72$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uin", "doubt_uin"}, new Object[]{0L, 0L}, oidb_cmd0xd72$ReqBody.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBUInt64Field doubt_uin = PBField.initUInt64(0);
}
