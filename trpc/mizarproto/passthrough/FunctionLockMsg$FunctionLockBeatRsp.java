package trpc.mizarproto.passthrough;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class FunctionLockMsg$FunctionLockBeatRsp extends MessageMicro<FunctionLockMsg$FunctionLockBeatRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"wording", "btns"}, new Object[]{"", null}, FunctionLockMsg$FunctionLockBeatRsp.class);
    public final PBStringField wording = PBField.initString("");
    public final PBRepeatMessageField<FunctionLockMsg$FunctionLockBtn> btns = PBField.initRepeatMessage(FunctionLockMsg$FunctionLockBtn.class);
}
