package tencent.im.oidb.cmd0x51d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x51d$ReqBody extends MessageMicro<oidb_0x51d$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"opt_uint64_handled_uin", "opt_uint64_office_appid"}, new Object[]{0L, 0L}, oidb_0x51d$ReqBody.class);
    public final PBUInt64Field opt_uint64_handled_uin = PBField.initUInt64(0);
    public final PBUInt64Field opt_uint64_office_appid = PBField.initUInt64(0);
}
