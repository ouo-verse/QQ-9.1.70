package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class QZIntimateProfileReader$ClientAcceptRelationInviteReq extends MessageMicro<QZIntimateProfileReader$ClientAcceptRelationInviteReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"accepted_uin", "src"}, new Object[]{"", 0}, QZIntimateProfileReader$ClientAcceptRelationInviteReq.class);
    public final PBStringField accepted_uin = PBField.initString("");
    public final PBEnumField src = PBField.initEnum(0);
}
