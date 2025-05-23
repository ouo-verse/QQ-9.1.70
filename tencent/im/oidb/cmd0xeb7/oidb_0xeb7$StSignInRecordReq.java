package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xeb7$StSignInRecordReq extends MessageMicro<oidb_0xeb7$StSignInRecordReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"dayYmd", "uid", "groupId"}, new Object[]{"", "", ""}, oidb_0xeb7$StSignInRecordReq.class);
    public final PBStringField dayYmd = PBField.initString("");
    public final PBStringField uid = PBField.initString("");
    public final PBStringField groupId = PBField.initString("");
}
