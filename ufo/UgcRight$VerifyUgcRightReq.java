package ufo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class UgcRight$VerifyUgcRightReq extends MessageMicro<UgcRight$VerifyUgcRightReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"vuin", "ugcKeys"}, new Object[]{"", null}, UgcRight$VerifyUgcRightReq.class);
    public final PBStringField vuin = PBField.initString("");
    public final PBRepeatMessageField<UgcRight$UgcDataKey> ugcKeys = PBField.initRepeatMessage(UgcRight$UgcDataKey.class);
}
