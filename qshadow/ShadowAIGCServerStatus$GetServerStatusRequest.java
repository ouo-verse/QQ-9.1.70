package qshadow;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class ShadowAIGCServerStatus$GetServerStatusRequest extends MessageMicro<ShadowAIGCServerStatus$GetServerStatusRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"busi_id"}, new Object[]{""}, ShadowAIGCServerStatus$GetServerStatusRequest.class);
    public final PBStringField busi_id = PBField.initString("");
}
