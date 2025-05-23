package ufo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class UgcRight$BatchVerifyResult extends MessageMicro<UgcRight$BatchVerifyResult> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"vuin", "authResult"}, new Object[]{"", null}, UgcRight$BatchVerifyResult.class);
    public final PBStringField vuin = PBField.initString("");
    public UgcRight$AuthResult authResult = new UgcRight$AuthResult();
}
