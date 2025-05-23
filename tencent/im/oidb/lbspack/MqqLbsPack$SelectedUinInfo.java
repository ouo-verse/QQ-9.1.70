package tencent.im.oidb.lbspack;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class MqqLbsPack$SelectedUinInfo extends MessageMicro<MqqLbsPack$SelectedUinInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"uint32_all_frd", "uint64_uin", "uint64_group_code", "uint64_discuss_uin"}, new Object[]{0, 0L, 0L, 0L}, MqqLbsPack$SelectedUinInfo.class);
    public final PBUInt32Field uint32_all_frd = PBField.initUInt32(0);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_discuss_uin = PBField.initUInt64(0);
}
