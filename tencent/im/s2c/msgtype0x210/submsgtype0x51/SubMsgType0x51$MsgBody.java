package tencent.im.s2c.msgtype0x210.submsgtype0x51;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class SubMsgType0x51$MsgBody extends MessageMicro<SubMsgType0x51$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field appid;
    public final PBStringField auto_renew_tips;
    public final PBBytesField bytes_appname;
    public final PBBytesField bytes_hint1;
    public final PBBytesField bytes_hint2;
    public final PBBytesField bytes_ios_push_tips;
    public final PBBytesField bytes_login_conf;
    public final PBBytesField bytes_logincity;
    public final PBBytesField bytes_qrsig_url;
    public SubMsgType0x51$DevInfo dev_info;
    public final PBBoolField support_auto_renew_ticket;
    public final PBUInt32Field uint32_allow_tmp_auth;
    public final PBUInt32Field uint32_logintime;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 56, 66, 74, 80, 90, 98, 104}, new String[]{"bytes_qrsig_url", "bytes_hint1", "bytes_hint2", "bytes_appname", "bytes_logincity", "uint32_logintime", "uint32_allow_tmp_auth", "bytes_login_conf", "bytes_ios_push_tips", "support_auto_renew_ticket", "auto_renew_tips", "dev_info", "appid"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, Boolean.FALSE, "", null, 0}, SubMsgType0x51$MsgBody.class);
    }

    public SubMsgType0x51$MsgBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_qrsig_url = PBField.initBytes(byteStringMicro);
        this.bytes_hint1 = PBField.initBytes(byteStringMicro);
        this.bytes_hint2 = PBField.initBytes(byteStringMicro);
        this.bytes_appname = PBField.initBytes(byteStringMicro);
        this.bytes_logincity = PBField.initBytes(byteStringMicro);
        this.uint32_logintime = PBField.initUInt32(0);
        this.uint32_allow_tmp_auth = PBField.initUInt32(0);
        this.bytes_login_conf = PBField.initBytes(byteStringMicro);
        this.bytes_ios_push_tips = PBField.initBytes(byteStringMicro);
        this.support_auto_renew_ticket = PBField.initBool(false);
        this.auto_renew_tips = PBField.initString("");
        this.dev_info = new SubMsgType0x51$DevInfo();
        this.appid = PBField.initUInt32(0);
    }
}
