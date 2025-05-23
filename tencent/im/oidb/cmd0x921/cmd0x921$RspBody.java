package tencent.im.oidb.cmd0x921;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x921$RspBody extends MessageMicro<cmd0x921$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_subcmd", "msg_get_at_all_remain"}, new Object[]{0, null}, cmd0x921$RspBody.class);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public cmd0x921$GetAtAllRemainRsp msg_get_at_all_remain = new cmd0x921$GetAtAllRemainRsp();
}
