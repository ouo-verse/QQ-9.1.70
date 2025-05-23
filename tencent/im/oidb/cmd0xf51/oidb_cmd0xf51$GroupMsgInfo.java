package tencent.im.oidb.cmd0xf51;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xf51$GroupMsgInfo extends MessageMicro<oidb_cmd0xf51$GroupMsgInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{"uint64_group_code", "uint64_msg_type", "uint64_msg_seq", "uint64_msg_time", "uint64_msg_uid", "uint64_msg_id"}, new Object[]{0L, 0L, 0L, 0L, 0L, 0L}, oidb_cmd0xf51$GroupMsgInfo.class);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_msg_type = PBField.initUInt64(0);
    public final PBUInt64Field uint64_msg_seq = PBField.initUInt64(0);
    public final PBUInt64Field uint64_msg_time = PBField.initUInt64(0);
    public final PBUInt64Field uint64_msg_uid = PBField.initUInt64(0);
    public final PBUInt64Field uint64_msg_id = PBField.initUInt64(0);
}
