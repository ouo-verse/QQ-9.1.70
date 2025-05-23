package tencent.im.kqq.profilesvr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GroupLocation$SetGroupLocationReq extends MessageMicro<GroupLocation$SetGroupLocationReq> {
    public static final int GROUPCODE_FIELD_NUMBER = 1;
    public static final int GROUPLOCATION_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"groupcode", "grouplocation"}, new Object[]{0, ""}, GroupLocation$SetGroupLocationReq.class);
    public final PBUInt32Field groupcode = PBField.initUInt32(0);
    public final PBStringField grouplocation = PBField.initString("");
}
