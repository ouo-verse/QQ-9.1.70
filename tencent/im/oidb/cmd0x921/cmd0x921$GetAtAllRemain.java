package tencent.im.oidb.cmd0x921;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x921$GetAtAllRemain extends MessageMicro<cmd0x921$GetAtAllRemain> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_uin", "uint64_discuss_uin"}, new Object[]{0L, 0L}, cmd0x921$GetAtAllRemain.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_discuss_uin = PBField.initUInt64(0);
}
