package tencent.im.oidb.cmd0xaee;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class Oidb_0xaee$RspBody extends MessageMicro<Oidb_0xaee$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"list_rsp", "admin_rsp"}, new Object[]{null, null}, Oidb_0xaee$RspBody.class);
    public Oidb_0xaee$ListRsp list_rsp = new Oidb_0xaee$ListRsp();
    public Oidb_0xaee$AdminRsp admin_rsp = new MessageMicro<Oidb_0xaee$AdminRsp>() { // from class: tencent.im.oidb.cmd0xaee.Oidb_0xaee$AdminRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], Oidb_0xaee$AdminRsp.class);
    };
}
