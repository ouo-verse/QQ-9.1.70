package tencent.im.oidb.cmd0xb31;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xb31$ReqBody extends MessageMicro<oidb_0xb31$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_to", "uint64_from"}, new Object[]{0L, 0L}, oidb_0xb31$ReqBody.class);
    public final PBUInt64Field uint64_to = PBField.initUInt64(0);
    public final PBUInt64Field uint64_from = PBField.initUInt64(0);
}
