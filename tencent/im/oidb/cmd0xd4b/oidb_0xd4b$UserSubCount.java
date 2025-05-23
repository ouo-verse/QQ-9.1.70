package tencent.im.oidb.cmd0xd4b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xd4b$UserSubCount extends MessageMicro<oidb_0xd4b$UserSubCount> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_uin", "uint32_user_sub_count"}, new Object[]{0L, 0}, oidb_0xd4b$UserSubCount.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_user_sub_count = PBField.initUInt32(0);
}
