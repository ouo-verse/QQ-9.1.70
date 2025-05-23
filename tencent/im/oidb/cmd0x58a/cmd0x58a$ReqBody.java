package tencent.im.oidb.cmd0x58a;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x58a$ReqBody extends MessageMicro<cmd0x58a$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_subcmd", "msg_get_comm_conf_req"}, new Object[]{0, null}, cmd0x58a$ReqBody.class);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public cmd0x58a$GetCommConfReq msg_get_comm_conf_req = new MessageMicro<cmd0x58a$GetCommConfReq>() { // from class: tencent.im.oidb.cmd0x58a.cmd0x58a$GetCommConfReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uint64_other_uin"}, new Object[]{0L}, cmd0x58a$GetCommConfReq.class);
        public final PBUInt64Field uint64_other_uin = PBField.initUInt64(0);
    };
}
