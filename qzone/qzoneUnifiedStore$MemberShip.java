package qzone;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class qzoneUnifiedStore$MemberShip extends MessageMicro<qzoneUnifiedStore$MemberShip> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40}, new String[]{"space_id", "member_status", "member_code", "expiration_time", "remain_signing"}, new Object[]{"", 0, "", 0L, 0}, qzoneUnifiedStore$MemberShip.class);
    public final PBStringField space_id = PBField.initString("");
    public final PBEnumField member_status = PBField.initEnum(0);
    public final PBStringField member_code = PBField.initString("");
    public final PBInt64Field expiration_time = PBField.initInt64(0);
    public final PBInt32Field remain_signing = PBField.initInt32(0);
}
