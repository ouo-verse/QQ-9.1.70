package tencent.im.oidb.cmd0x77c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x77c$ReqBody extends MessageMicro<cmd0x77c$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_uin", "int32_timezone"}, new Object[]{0L, 0}, cmd0x77c$ReqBody.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBInt32Field int32_timezone = PBField.initInt32(0);
}
