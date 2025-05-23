package tencent.im.login;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class GatewayVerify$A1Sig extends MessageMicro<GatewayVerify$A1Sig> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_a1_sig;
    public final PBBytesField bytes_encrypt_uin;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"bytes_encrypt_uin", "bytes_a1_sig"}, new Object[]{byteStringMicro, byteStringMicro}, GatewayVerify$A1Sig.class);
    }

    public GatewayVerify$A1Sig() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_encrypt_uin = PBField.initBytes(byteStringMicro);
        this.bytes_a1_sig = PBField.initBytes(byteStringMicro);
    }
}
