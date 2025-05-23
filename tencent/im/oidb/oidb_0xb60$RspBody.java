package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xb60$RspBody extends MessageMicro<oidb_0xb60$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 82, 90}, new String[]{"wording", "get_privilege_rsp", "check_url_rsp"}, new Object[]{"", null, null}, oidb_0xb60$RspBody.class);
    public final PBStringField wording = PBField.initString("");
    public oidb_0xb60$GetPrivilegeRsp get_privilege_rsp = new oidb_0xb60$GetPrivilegeRsp();
    public oidb_0xb60$CheckUrlRsp check_url_rsp = new oidb_0xb60$CheckUrlRsp();
}
