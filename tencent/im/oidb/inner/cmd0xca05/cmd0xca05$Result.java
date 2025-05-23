package tencent.im.oidb.inner.cmd0xca05;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xca05$Result extends MessageMicro<cmd0xca05$Result> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_id", "uint32_res"}, new Object[]{0, 0}, cmd0xca05$Result.class);
    public final PBUInt32Field uint32_id = PBField.initUInt32(0);
    public final PBUInt32Field uint32_res = PBField.initUInt32(0);
}
