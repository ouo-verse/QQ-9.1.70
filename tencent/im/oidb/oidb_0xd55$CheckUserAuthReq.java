package tencent.im.oidb;

import com.tencent.mobileqq.mini.servlet.GetCMShowInfoServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xd55$CheckUserAuthReq extends MessageMicro<oidb_0xd55$CheckUserAuthReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{GetCMShowInfoServlet.EXTRA_OPENID, "auth_groups"}, new Object[]{"", null}, oidb_0xd55$CheckUserAuthReq.class);
    public final PBRepeatField<String> openids = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatMessageField<appauth_comm$AuthGroupTuple> auth_groups = PBField.initRepeatMessage(appauth_comm$AuthGroupTuple.class);
}
