package tencent.im.oidb.cmd0x88d;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0x88d$ReqGroupInfo extends MessageMicro<oidb_0x88d$ReqGroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"uint64_group_code", "stgroupinfo", "uint32_last_get_group_name_time"}, new Object[]{0L, null, 0}, oidb_0x88d$ReqGroupInfo.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public oidb_0x88d$GroupInfo stgroupinfo = new oidb_0x88d$GroupInfo();
    public final PBUInt32Field uint32_last_get_group_name_time = PBField.initUInt32(0);
}
