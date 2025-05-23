package tencent.im.oidb.cmd0x991;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0x991$ReqBody extends MessageMicro<oidb_cmd0x991$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_user", "msg_goods"}, new Object[]{null, null}, oidb_cmd0x991$ReqBody.class);
    public oidb_cmd0x991$User msg_user = new oidb_cmd0x991$User();
    public oidb_cmd0x991$Goods msg_goods = new oidb_cmd0x991$Goods();
}
