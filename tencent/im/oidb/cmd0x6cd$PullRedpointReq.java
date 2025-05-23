package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class cmd0x6cd$PullRedpointReq extends MessageMicro<cmd0x6cd$PullRedpointReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_taskid", "uint64_last_pull_seq"}, new Object[]{0, 0L}, cmd0x6cd$PullRedpointReq.class);
    public final PBUInt32Field uint32_taskid = PBField.initUInt32(0);
    public final PBUInt64Field uint64_last_pull_seq = PBField.initUInt64(0);
}
