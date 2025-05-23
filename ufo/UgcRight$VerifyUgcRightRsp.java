package ufo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class UgcRight$VerifyUgcRightRsp extends MessageMicro<UgcRight$VerifyUgcRightRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"vuin", "result"}, new Object[]{"", null}, UgcRight$VerifyUgcRightRsp.class);
    public final PBStringField vuin = PBField.initString("");
    public final PBRepeatMessageField<UgcRight$VerifyResult> result = PBField.initRepeatMessage(UgcRight$VerifyResult.class);
}
