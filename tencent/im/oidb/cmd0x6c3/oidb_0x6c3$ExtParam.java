package tencent.im.oidb.cmd0x6c3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes29.dex */
public final class oidb_0x6c3$ExtParam extends MessageMicro<oidb_0x6c3$ExtParam> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 106}, new String[]{"msg_login_sig", "msg_user_login_session"}, new Object[]{null, null}, oidb_0x6c3$ExtParam.class);
    public oidb_0x6c3$LoginSig msg_login_sig = new oidb_0x6c3$LoginSig();
    public oidb_0x6c3$UserLoginSession msg_user_login_session = new MessageMicro<oidb_0x6c3$UserLoginSession>() { // from class: tencent.im.oidb.cmd0x6c3.oidb_0x6c3$UserLoginSession
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBytesField bytes_accesstoken;
        public final PBBytesField bytes_appid;
        public final PBBytesField bytes_openid;

        static {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"bytes_appid", "bytes_openid", "bytes_accesstoken"}, new Object[]{byteStringMicro, byteStringMicro, byteStringMicro}, oidb_0x6c3$UserLoginSession.class);
        }

        {
            ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
            this.bytes_appid = PBField.initBytes(byteStringMicro);
            this.bytes_openid = PBField.initBytes(byteStringMicro);
            this.bytes_accesstoken = PBField.initBytes(byteStringMicro);
        }
    };
}
