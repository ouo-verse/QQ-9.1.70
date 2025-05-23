package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qzoneUnifiedStore$BatchGetMemberShipRsp extends MessageMicro<qzoneUnifiedStore$BatchGetMemberShipRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"member_ships"}, new Object[]{null}, qzoneUnifiedStore$BatchGetMemberShipRsp.class);
    public final PBRepeatMessageField<qzoneUnifiedStore$MemberShip> member_ships = PBField.initRepeatMessage(qzoneUnifiedStore$MemberShip.class);
}
