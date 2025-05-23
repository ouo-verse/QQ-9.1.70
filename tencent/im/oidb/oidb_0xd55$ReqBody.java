package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xd55$ReqBody extends MessageMicro<oidb_0xd55$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 40, 90, 98, 106, 114, 122, 130, 138}, new String[]{"appid", "app_type", "src_id", "raw_url", "is_need_appinfo", "check_app_sign_req", "check_user_req", "check_mini_app_req", "check_url_sig_req", "decrypt_req", "encrypt_req", "check_user_auth_req"}, new Object[]{0L, 0, 0, "", 0, null, null, null, null, null, null, null}, oidb_0xd55$ReqBody.class);
    public final PBUInt64Field appid = PBField.initUInt64(0);
    public final PBUInt32Field app_type = PBField.initUInt32(0);
    public final PBUInt32Field src_id = PBField.initUInt32(0);
    public final PBStringField raw_url = PBField.initString("");
    public final PBUInt32Field is_need_appinfo = PBField.initUInt32(0);
    public oidb_0xd55$CheckAppSignReq check_app_sign_req = new oidb_0xd55$CheckAppSignReq();
    public oidb_0xd55$CheckUserReq check_user_req = new oidb_0xd55$CheckUserReq();
    public oidb_0xd55$CheckMiniAppReq check_mini_app_req = new oidb_0xd55$CheckMiniAppReq();
    public oidb_0xd55$CheckUrlSigReq check_url_sig_req = new oidb_0xd55$CheckUrlSigReq();
    public oidb_0xd55$DecryptReq decrypt_req = new oidb_0xd55$DecryptReq();
    public oidb_0xd55$EncryptReq encrypt_req = new MessageMicro<oidb_0xd55$EncryptReq>() { // from class: tencent.im.oidb.oidb_0xd55$EncryptReq
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"plain_texts"}, new Object[]{""}, oidb_0xd55$EncryptReq.class);
        public final PBRepeatField<String> plain_texts = PBField.initRepeat(PBStringField.__repeatHelper__);
    };
    public oidb_0xd55$CheckUserAuthReq check_user_auth_req = new oidb_0xd55$CheckUserAuthReq();
}
