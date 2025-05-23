package tencent.im.oidb.cmd0x44c;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x44c$ReqBody extends MessageMicro<cmd0x44c$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_subcmd", "msg_modify_conf_info_req"}, new Object[]{0, null}, cmd0x44c$ReqBody.class);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public cmd0x44c$ModifyConfInfoReq msg_modify_conf_info_req = new cmd0x44c$ModifyConfInfoReq();
}
