package tencent.im.mutualmark;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class mutualmark$Graded extends MessageMicro<mutualmark$Graded> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34}, new String[]{"level", "name", "threshold", "desc"}, new Object[]{0L, "", 0, ""}, mutualmark$Graded.class);
    public final PBUInt64Field level = PBField.initUInt64(0);
    public final PBStringField name = PBField.initString("");
    public final PBUInt32Field threshold = PBField.initUInt32(0);
    public final PBStringField desc = PBField.initString("");
}
