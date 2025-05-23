package tencent.im.login;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GatewayVerify$UinInfo extends MessageMicro<GatewayVerify$UinInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_a1_sig;
    public final PBBytesField bytes_encrypt_uin;
    public final PBStringField str_key_uin;
    public final PBStringField str_mask_uin = PBField.initString("");
    public final PBStringField str_nick = PBField.initString("");
    public final PBStringField str_image_url = PBField.initString("");

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"str_mask_uin", "str_nick", "str_image_url", "bytes_encrypt_uin", "str_key_uin", "bytes_a1_sig"}, new Object[]{"", "", "", byteStringMicro, "", byteStringMicro}, GatewayVerify$UinInfo.class);
    }

    public GatewayVerify$UinInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_encrypt_uin = PBField.initBytes(byteStringMicro);
        this.str_key_uin = PBField.initString("");
        this.bytes_a1_sig = PBField.initBytes(byteStringMicro);
    }
}
