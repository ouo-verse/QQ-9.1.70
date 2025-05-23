package tencent.im.oidb.cmd0x58b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x58b$GetConfInfoRsp extends MessageMicro<cmd0x58b$GetConfInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"uint64_conf_uin", "msg_conf_base_info", "rpt_msg_member_info", "uint32_server_remark_timestamp"}, new Object[]{0L, null, null, 0}, cmd0x58b$GetConfInfoRsp.class);
    public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0);
    public cmd0x58b$ConfBaseInfo msg_conf_base_info = new cmd0x58b$ConfBaseInfo();
    public final PBRepeatMessageField<cmd0x58b$ConfMemberInfo> rpt_msg_member_info = PBField.initRepeatMessage(cmd0x58b$ConfMemberInfo.class);
    public final PBUInt32Field uint32_server_remark_timestamp = PBField.initUInt32(0);
}
