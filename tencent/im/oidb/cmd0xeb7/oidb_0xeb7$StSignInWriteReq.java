package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.xweb.internal.ConstValue;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xeb7$StSignInWriteReq extends MessageMicro<oidb_0xeb7$StSignInWriteReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"uid", "groupId", ConstValue.INIT_CONFIG_KEY_CLIENT_VERSION}, new Object[]{"", "", ""}, oidb_0xeb7$StSignInWriteReq.class);
    public final PBStringField uid = PBField.initString("");
    public final PBStringField groupId = PBField.initString("");
    public final PBStringField clientVersion = PBField.initString("");
}
