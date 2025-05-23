package tencent.im.conf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class sysmsg_0x20c_0x20$MemberNumRemind extends MessageMicro<sysmsg_0x20c_0x20$MemberNumRemind> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"u64_discuss_code", "u32_mem_num"}, new Object[]{0L, 0}, sysmsg_0x20c_0x20$MemberNumRemind.class);
    public final PBUInt64Field u64_discuss_code = PBField.initUInt64(0);
    public final PBUInt32Field u32_mem_num = PBField.initUInt32(0);
}
