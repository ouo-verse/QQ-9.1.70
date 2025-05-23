package tencent.im.oidb.cmd0x758;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x758$InviteUinInfo extends MessageMicro<cmd0x758$InviteUinInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint64_uin", "uint64_judge_group_code", "uint64_judge_conf_code"}, new Object[]{0L, 0L, 0L}, cmd0x758$InviteUinInfo.class);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_judge_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_judge_conf_code = PBField.initUInt64(0);
}
