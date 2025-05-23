package tencent.im.oidb.cmd0x82a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x82a$MsgInfo extends MessageMicro<cmd0x82a$MsgInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88, 96}, new String[]{"uint64_from_uin", "uint64_to_uin", "uint32_msg_seq", "uint64_msg_uid", "uint64_msg_time", "uint32_msg_random", "uint32_pkg_num", "uint32_pkg_index", "uint32_div_seq", "uint32_msg_type", "uint32_type", "uint32_subtype"}, new Object[]{0L, 0L, 0, 0L, 0L, 0, 0, 0, 0, 0, 0, 0}, cmd0x82a$MsgInfo.class);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_msg_seq = PBField.initUInt32(0);
    public final PBUInt64Field uint64_msg_uid = PBField.initUInt64(0);
    public final PBUInt64Field uint64_msg_time = PBField.initUInt64(0);
    public final PBUInt32Field uint32_msg_random = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pkg_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pkg_index = PBField.initUInt32(0);
    public final PBUInt32Field uint32_div_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_msg_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_subtype = PBField.initUInt32(0);
}
