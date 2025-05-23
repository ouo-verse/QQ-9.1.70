package tencent.im.oidb.jump_url_check;

import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class jump_url_check$RspJumpUrlCheckRecmd extends MessageMicro<jump_url_check$RspJumpUrlCheckRecmd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{CheckForwardServlet.KEY_ERR_CODE, "err_msg", CheckForwardServlet.KEY_CAN_JUMP}, new Object[]{0, "", Boolean.TRUE}, jump_url_check$RspJumpUrlCheckRecmd.class);
    public final PBInt32Field err_code = PBField.initInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBBoolField can_jump = PBField.initBool(true);
}
