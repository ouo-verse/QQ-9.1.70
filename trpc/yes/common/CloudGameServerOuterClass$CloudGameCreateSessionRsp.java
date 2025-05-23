package trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes30.dex */
public final class CloudGameServerOuterClass$CloudGameCreateSessionRsp extends MessageMicro<CloudGameServerOuterClass$CloudGameCreateSessionRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"server_session"}, new Object[]{""}, CloudGameServerOuterClass$CloudGameCreateSessionRsp.class);
    public final PBStringField server_session = PBField.initString("");
}
