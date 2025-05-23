package tencent.im.oidb.cmd0xdc2;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77$RspBody;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_cmd0xdc2$BatchSendRsp extends MessageMicro<oidb_cmd0xdc2$BatchSendRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 42, 50}, new String[]{"send_type", "recv_uin", "recv_openid", CheckForwardServlet.KEY_ERR_CODE, "err_msg", "rsp_body"}, new Object[]{0, 0L, "", 0, "", null}, oidb_cmd0xdc2$BatchSendRsp.class);
    public final PBUInt32Field send_type = PBField.initUInt32(0);
    public final PBUInt64Field recv_uin = PBField.initUInt64(0);
    public final PBStringField recv_openid = PBField.initString("");
    public final PBUInt32Field err_code = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public oidb_cmd0xb77$RspBody rsp_body = new oidb_cmd0xb77$RspBody();
}
