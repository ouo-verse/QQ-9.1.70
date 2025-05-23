package tencent.im.cs.cmd0x3fb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class cmd0x3fb$GrayMsg extends MessageMicro<cmd0x3fb$GrayMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 82, 90}, new String[]{"uint32_subcmd", "msg_gray_req", "msg_gray_rsp"}, new Object[]{0, null, null}, cmd0x3fb$GrayMsg.class);
    public final PBUInt32Field uint32_subcmd = PBField.initUInt32(0);
    public cmd0x3fb$ReqBody msg_gray_req = new cmd0x3fb$ReqBody();
    public cmd0x3fb$RspBody msg_gray_rsp = new cmd0x3fb$RspBody();
}
