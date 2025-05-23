package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xd55$CheckUserReq extends MessageMicro<oidb_0xd55$CheckUserReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"openid", "need_check_same_user"}, new Object[]{"", 0}, oidb_0xd55$CheckUserReq.class);
    public final PBStringField openid = PBField.initString("");
    public final PBUInt32Field need_check_same_user = PBField.initUInt32(0);
}
