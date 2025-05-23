package tencent.im.oidb.inner.cmd0xca04;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xca04$RspBody extends MessageMicro<cmd0xca04$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_res", "uint32_timestamp"}, new Object[]{0, 0}, cmd0xca04$RspBody.class);
    public final PBUInt32Field uint32_res = PBField.initUInt32(0);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
}
