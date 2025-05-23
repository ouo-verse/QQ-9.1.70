package tencent.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class TroopApiGateway$KeyValue extends MessageMicro<TroopApiGateway$KeyValue> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, TroopApiGateway$KeyValue.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
}
