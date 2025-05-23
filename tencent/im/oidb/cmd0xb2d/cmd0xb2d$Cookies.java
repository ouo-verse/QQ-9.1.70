package tencent.im.oidb.cmd0xb2d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0xb2d$Cookies extends MessageMicro<cmd0xb2d$Cookies> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 120}, new String[]{"uint32_next_start", "uint64_test_count"}, new Object[]{0, 0L}, cmd0xb2d$Cookies.class);
    public final PBUInt32Field uint32_next_start = PBField.initUInt32(0);
    public final PBUInt64Field uint64_test_count = PBField.initUInt64(0);
}
