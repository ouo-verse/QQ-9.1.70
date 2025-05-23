package tencent.im.s2c.msgtype0x210.submsgtype0x11a;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class submsgtype0x11a$MsgBody extends MessageMicro<submsgtype0x11a$MsgBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_encrypt_key;
    public final PBBytesField bytes_token;
    public final PBEnumField enum_biz_type;
    public final PBEnumField enum_result = PBField.initEnum(0);
    public submsgtype0x11a$UserData msg_user_data;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 40}, new String[]{"enum_result", "bytes_token", "bytes_encrypt_key", "msg_user_data", "enum_biz_type"}, new Object[]{0, byteStringMicro, byteStringMicro, null, 1}, submsgtype0x11a$MsgBody.class);
    }

    public submsgtype0x11a$MsgBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_token = PBField.initBytes(byteStringMicro);
        this.bytes_encrypt_key = PBField.initBytes(byteStringMicro);
        this.msg_user_data = new submsgtype0x11a$UserData();
        this.enum_biz_type = PBField.initEnum(1);
    }
}
