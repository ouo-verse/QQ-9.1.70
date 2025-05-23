package tencent.im.kqq.profilesvr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GroupLocation$SetGroupLocationRes extends MessageMicro<GroupLocation$SetGroupLocationRes> {
    public static final int GROUPLOCATION_FIELD_NUMBER = 2;
    public static final int RESULT_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"result", "grouplocation"}, new Object[]{-1, ""}, GroupLocation$SetGroupLocationRes.class);
    public final PBInt32Field result = PBField.initInt32(-1);
    public final PBStringField grouplocation = PBField.initString("");
}
