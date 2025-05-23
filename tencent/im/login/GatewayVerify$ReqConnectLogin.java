package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GatewayVerify$ReqConnectLogin extends MessageMicro<GatewayVerify$ReqConnectLogin> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"str_connect_data"}, new Object[]{""}, GatewayVerify$ReqConnectLogin.class);
    public final PBStringField str_connect_data = PBField.initString("");
}
