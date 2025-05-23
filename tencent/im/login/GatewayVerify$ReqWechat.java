package tencent.im.login;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GatewayVerify$ReqWechat extends MessageMicro<GatewayVerify$ReqWechat> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{82, 90, 98}, new String[]{"str_appid", "str_code", "str_profile_sig"}, new Object[]{"", "", ""}, GatewayVerify$ReqWechat.class);
    public final PBStringField str_appid = PBField.initString("");
    public final PBStringField str_code = PBField.initString("");
    public final PBStringField str_profile_sig = PBField.initString("");
}
