package tencent.im.oidb.cmd0xb01;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xb01$RspBody extends MessageMicro<cmd0xb01$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 17}, new String[]{"uint32_result", "double_density"}, new Object[]{0, Double.valueOf(0.0d)}, cmd0xb01$RspBody.class);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public final PBDoubleField double_density = PBField.initDouble(0.0d);
}
