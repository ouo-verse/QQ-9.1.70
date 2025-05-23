package tencent.im.oidb.cmd0x5d4;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x5d4$DelResult extends MessageMicro<oidb_0x5d4$DelResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uin", "res"}, new Object[]{0L, 0}, oidb_0x5d4$DelResult.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBEnumField res = PBField.initEnum(0);
}
