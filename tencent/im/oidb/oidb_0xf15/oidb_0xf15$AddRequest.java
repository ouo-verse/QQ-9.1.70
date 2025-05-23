package tencent.im.oidb.oidb_0xf15;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xf15$AddRequest extends MessageMicro<oidb_0xf15$AddRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"group_code", "question_id", "reply"}, new Object[]{0L, 0L, ""}, oidb_0xf15$AddRequest.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt64Field question_id = PBField.initUInt64(0);
    public final PBStringField reply = PBField.initString("");
}
