package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QZIntimateProfileReader$ClientRelationInviteReq extends MessageMicro<QZIntimateProfileReader$ClientRelationInviteReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"invited_uin", "src"}, new Object[]{"", 0}, QZIntimateProfileReader$ClientRelationInviteReq.class);
    public final PBStringField invited_uin = PBField.initString("");
    public final PBEnumField src = PBField.initEnum(0);
}
