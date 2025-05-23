package tencent.im.oidb.cmd0x88d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x88d$RspGroupInfo extends MessageMicro<oidb_0x88d$RspGroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint64_group_code", "uint32_result", "stgroupinfo"}, new Object[]{0L, 0, null}, oidb_0x88d$RspGroupInfo.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    public oidb_0x88d$GroupInfo stgroupinfo = new oidb_0x88d$GroupInfo();
}
