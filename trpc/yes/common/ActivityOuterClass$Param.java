package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes30.dex */
public final class ActivityOuterClass$Param extends MessageMicro<ActivityOuterClass$Param> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, ActivityOuterClass$Param.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
}
