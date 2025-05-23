package tencent.im.oidb.qqshop;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes29.dex */
public final class qqshop$SQQSHPNewUserRecmd extends MessageMicro<qqshop$SQQSHPNewUserRecmd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"recmdflag", "recmdurl"}, new Object[]{0, ""}, qqshop$SQQSHPNewUserRecmd.class);
    public final PBInt32Field recmdflag = PBField.initInt32(0);
    public final PBStringField recmdurl = PBField.initString("");
}
