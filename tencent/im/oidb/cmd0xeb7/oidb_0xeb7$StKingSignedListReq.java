package tencent.im.oidb.cmd0xeb7;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xeb7$StKingSignedListReq extends MessageMicro<oidb_0xeb7$StKingSignedListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"uid", "groupId"}, new Object[]{"", ""}, oidb_0xeb7$StKingSignedListReq.class);
    public final PBStringField uid = PBField.initString("");
    public final PBStringField groupId = PBField.initString("");
}
