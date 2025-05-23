package qqcircle;

import com.tencent.mobileqq.app.identity.jwt.JsonWebSignature;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class QQCircleCounterStyle$StyleRed extends MessageMicro<QQCircleCounterStyle$StyleRed> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{JsonWebSignature.TYPE, "wording", "url"}, new Object[]{0, "", ""}, QQCircleCounterStyle$StyleRed.class);
    public final PBEnumField typ = PBField.initEnum(0);
    public final PBStringField wording = PBField.initString("");
    public final PBStringField url = PBField.initString("");
}
