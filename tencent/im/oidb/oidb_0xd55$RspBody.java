package tencent.im.oidb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class oidb_0xd55$RspBody extends MessageMicro<oidb_0xd55$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 90, 98, 106, 114, 122, 130, 138}, new String[]{"wording", "appinfo", "check_app_sign_rsp", "check_user_rsp", "check_mini_app_rsp", "check_url_sig_rsp", "decrypt_rsp", "encrypt_rsp", "check_user_auth_rsp"}, new Object[]{"", null, null, null, null, null, null, null, null}, oidb_0xd55$RspBody.class);
    public final PBStringField wording = PBField.initString("");
    public qqconnect$Appinfo appinfo = new qqconnect$Appinfo();
    public oidb_0xd55$CheckAppSignRsp check_app_sign_rsp = new MessageMicro<oidb_0xd55$CheckAppSignRsp>() { // from class: tencent.im.oidb.oidb_0xd55$CheckAppSignRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 88}, new String[]{"ios_app_token", "ios_universal_link", "optimize_switch"}, new Object[]{"", "", 0}, oidb_0xd55$CheckAppSignRsp.class);
        public final PBStringField ios_app_token = PBField.initString("");
        public final PBStringField ios_universal_link = PBField.initString("");
        public final PBUInt32Field optimize_switch = PBField.initUInt32(0);
    };
    public oidb_0xd55$CheckUserRsp check_user_rsp = new MessageMicro<oidb_0xd55$CheckUserRsp>() { // from class: tencent.im.oidb.oidb_0xd55$CheckUserRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"openid_uin"}, new Object[]{0L}, oidb_0xd55$CheckUserRsp.class);
        public final PBUInt64Field openid_uin = PBField.initUInt64(0);
    };
    public oidb_0xd55$CheckMiniAppRsp check_mini_app_rsp = new MessageMicro<oidb_0xd55$CheckMiniAppRsp>() { // from class: tencent.im.oidb.oidb_0xd55$CheckMiniAppRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], oidb_0xd55$CheckMiniAppRsp.class);
    };
    public oidb_0xd55$CheckUrlSigRsp check_url_sig_rsp = new MessageMicro<oidb_0xd55$CheckUrlSigRsp>() { // from class: tencent.im.oidb.oidb_0xd55$CheckUrlSigRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"plaintxt"}, new Object[]{""}, oidb_0xd55$CheckUrlSigRsp.class);
        public final PBStringField plaintxt = PBField.initString("");
    };
    public oidb_0xd55$DecryptRsp decrypt_rsp = new oidb_0xd55$DecryptRsp();
    public oidb_0xd55$EncryptRsp encrypt_rsp = new MessageMicro<oidb_0xd55$EncryptRsp>() { // from class: tencent.im.oidb.oidb_0xd55$EncryptRsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"crypto_infos"}, new Object[]{null}, oidb_0xd55$EncryptRsp.class);
        public final PBRepeatMessageField<oidb_0xd55$CryptoInfo> crypto_infos = PBField.initRepeatMessage(oidb_0xd55$CryptoInfo.class);
    };
    public oidb_0xd55$CheckUserAuthRsp check_user_auth_rsp = new oidb_0xd55$CheckUserAuthRsp();
}
