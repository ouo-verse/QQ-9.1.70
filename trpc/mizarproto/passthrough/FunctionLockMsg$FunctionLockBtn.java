package trpc.mizarproto.passthrough;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class FunctionLockMsg$FunctionLockBtn extends MessageMicro<FunctionLockMsg$FunctionLockBtn> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"woding", "url", "jump_type"}, new Object[]{"", "", 0}, FunctionLockMsg$FunctionLockBtn.class);
    public final PBStringField woding = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBUInt32Field jump_type = PBField.initUInt32(0);
}
