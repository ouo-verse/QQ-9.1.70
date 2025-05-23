package tencent.im.oidb.cmd0x58b;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x58b$ReqBody extends MessageMicro<cmd0x58b$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uint32_subcmd", "msg_get_conf_info", "msg_get_conf_name_for_push", "msg_get_multi_conf_info"}, new Object[]{0, null, null, null}, cmd0x58b$ReqBody.class);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public cmd0x58b$GetConfInfoReq msg_get_conf_info = new MessageMicro<cmd0x58b$GetConfInfoReq>() { // from class: tencent.im.oidb.cmd0x58b.cmd0x58b$GetConfInfoReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"uint64_conf_uin", "msg_conf_base_info", "msg_conf_mem_info", "uint32_interemark_timestamp"}, new Object[]{0L, null, null, 0}, cmd0x58b$GetConfInfoReq.class);
        public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0);
        public cmd0x58b$ConfBaseInfo msg_conf_base_info = new cmd0x58b$ConfBaseInfo();
        public cmd0x58b$ConfMemberInfo msg_conf_mem_info = new cmd0x58b$ConfMemberInfo();
        public final PBUInt32Field uint32_interemark_timestamp = PBField.initUInt32(0);
    };
    public cmd0x58b$GetConfNameForPushReq msg_get_conf_name_for_push = new MessageMicro<cmd0x58b$GetConfNameForPushReq>() { // from class: tencent.im.oidb.cmd0x58b.cmd0x58b$GetConfNameForPushReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_conf_uin"}, new Object[]{0L}, cmd0x58b$GetConfNameForPushReq.class);
        public final PBUInt64Field uint64_conf_uin = PBField.initUInt64(0);
    };
    public cmd0x58b$GetMultiConfInfoReq msg_get_multi_conf_info = new cmd0x58b$GetMultiConfInfoReq();
}
