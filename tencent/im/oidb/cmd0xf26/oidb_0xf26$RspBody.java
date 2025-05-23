package tencent.im.oidb.cmd0xf26;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xf26$RspBody extends MessageMicro<oidb_0xf26$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 82, 90, 98}, new String[]{"wording", "query_rsp", "grant_rsp", "revoke_rsp"}, new Object[]{"", null, null, null}, oidb_0xf26$RspBody.class);
    public final PBStringField wording = PBField.initString("");
    public oidb_0xf26$QueryRsp query_rsp = new oidb_0xf26$QueryRsp();
    public oidb_0xf26$GrantRsp grant_rsp = new MessageMicro<oidb_0xf26$GrantRsp>() { // from class: tencent.im.oidb.cmd0xf26.oidb_0xf26$GrantRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0xf26$GrantRsp.class);
    };
    public oidb_0xf26$RevokeRsp revoke_rsp = new MessageMicro<oidb_0xf26$RevokeRsp>() { // from class: tencent.im.oidb.cmd0xf26.oidb_0xf26$RevokeRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0xf26$RevokeRsp.class);
    };
}
