package tencent.im.oidb.cmd0xf26;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xf26$ReqBody extends MessageMicro<oidb_0xf26$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 82, 90, 98}, new String[]{"appid", "app_type", "source_from", "openid", "openkey", "query_req", "grant_req", "revoke_req"}, new Object[]{0, 0, 0, "", "", null, null, null}, oidb_0xf26$ReqBody.class);
    public final PBUInt32Field appid = PBField.initUInt32(0);
    public final PBUInt32Field app_type = PBField.initUInt32(0);
    public final PBUInt32Field source_from = PBField.initUInt32(0);
    public final PBStringField openid = PBField.initString("");
    public final PBStringField openkey = PBField.initString("");
    public oidb_0xf26$QueryReq query_req = new MessageMicro<oidb_0xf26$QueryReq>() { // from class: tencent.im.oidb.cmd0xf26.oidb_0xf26$QueryReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"show_unchangeable_auth"}, new Object[]{Boolean.FALSE}, oidb_0xf26$QueryReq.class);
        public final PBBoolField show_unchangeable_auth = PBField.initBool(false);
    };
    public oidb_0xf26$GrantReq grant_req = new oidb_0xf26$GrantReq();
    public oidb_0xf26$RevokeReq revoke_req = new oidb_0xf26$RevokeReq();
}
