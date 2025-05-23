package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ShadowShareArkMessage$GetMessageSignatureRequest extends MessageMicro<ShadowShareArkMessage$GetMessageSignatureRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"rawArKMsg"}, new Object[]{""}, ShadowShareArkMessage$GetMessageSignatureRequest.class);
    public final PBStringField rawArKMsg = PBField.initString("");
}
