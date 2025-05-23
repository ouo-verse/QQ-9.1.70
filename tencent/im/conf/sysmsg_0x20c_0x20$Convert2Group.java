package tencent.im.conf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class sysmsg_0x20c_0x20$Convert2Group extends MessageMicro<sysmsg_0x20c_0x20$Convert2Group> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"u64_operator", "u64_discuss_code", "u64_group_code"}, new Object[]{0L, 0L, 0L}, sysmsg_0x20c_0x20$Convert2Group.class);
    public final PBUInt64Field u64_operator = PBField.initUInt64(0);
    public final PBUInt64Field u64_discuss_code = PBField.initUInt64(0);
    public final PBUInt64Field u64_group_code = PBField.initUInt64(0);
}
