package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xc6c$GroupInfo extends MessageMicro<oidb_0xc6c$GroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_group_uin", "uint64_group_code"}, new Object[]{0L, 0L}, oidb_0xc6c$GroupInfo.class);
    public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
}
