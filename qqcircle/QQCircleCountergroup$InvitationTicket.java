package qqcircle;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleCountergroup$InvitationTicket extends MessageMicro<QQCircleCountergroup$InvitationTicket> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"groupID", "InvitationCode"}, new Object[]{0L, ""}, QQCircleCountergroup$InvitationTicket.class);
    public final PBUInt64Field groupID = PBField.initUInt64(0);
    public final PBStringField InvitationCode = PBField.initString("");
}
