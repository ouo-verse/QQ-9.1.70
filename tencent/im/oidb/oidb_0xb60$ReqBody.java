package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xb60$ReqBody extends MessageMicro<oidb_0xb60$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 82, 90}, new String[]{"client_info", "get_privilege_req", "check_url_req"}, new Object[]{null, null, null}, oidb_0xb60$ReqBody.class);
    public oidb_0xb60$ClientInfo client_info = new oidb_0xb60$ClientInfo();
    public oidb_0xb60$GetPrivilegeReq get_privilege_req = new oidb_0xb60$GetPrivilegeReq();
    public oidb_0xb60$CheckUrlReq check_url_req = new oidb_0xb60$CheckUrlReq();
}
